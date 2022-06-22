package com.lqd.utils;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程工具类
 *
 * @author a564
 * @version 1.0
 * @Date 3/18/21
 */
public class ThreadHelper {
    private static AtomicInteger poolNumber = new AtomicInteger(1);
    private static int corePoolsSize = Runtime.getRuntime().availableProcessors() + 1;
    private static ThreadPoolExecutor mCacheThreadPoolExecutor = initThreadPoolExecutor();

    static final Handler sUIHandler = new Handler(Looper.getMainLooper());
    static final Handler sBackgroundHandler = BackgroundHandlerThread.getInstance().getHandler();

    private static ThreadPoolExecutor initThreadPoolExecutor() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                corePoolsSize, corePoolsSize, 60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName("thread-" + poolNumber.getAndIncrement());
                        return thread;
                    }
                });
        //设置允许核心线程池到达存活时间也自动关闭
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }


    public static void runOnUiThread(Runnable run) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            run.run();
        } else {
            sUIHandler.post(run);
        }
    }

    public static void runOnUiThread(Runnable run, long delayMillis) {
        sUIHandler.postDelayed(run, delayMillis);
    }

    public static void runOnBackgroundThread(Runnable run) {
        if (Looper.myLooper() == sBackgroundHandler.getLooper()) {
            run.run();
        } else {
            sBackgroundHandler.post(run);
        }
    }

    private static class HookRunnable implements Runnable {

        private Runnable handler;
        private String method1 = "";
        private String method2 = "";

        public HookRunnable(Runnable runnable) {
            StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
            if (stackTrace.length >= 4) {
                method1 = "File:" + stackTrace[2].getFileName().toString() + ", Line: " + stackTrace[2].getLineNumber() + ", MethodName:" + stackTrace[2].getMethodName();
                method2 = "File:" + stackTrace[3].getFileName().toString() + ", Line: " + stackTrace[3].getLineNumber() + ", MethodName:" + stackTrace[3].getMethodName();
            }
            handler = runnable;
        }

        @Override
        public void run() {
            handler.run();
        }
    }

    /**
     * @param run
     * @param delayMillis
     */
//    @Deprecated
    public static void runOnBackgroundThread(Runnable run, long delayMillis) {
        sBackgroundHandler.postDelayed(run, delayMillis);
    }

    public static void runOnAsyncThread(final Runnable runnable) {
        mCacheThreadPoolExecutor.execute(runnable);
    }

    /**
     * @param runnable
     * @param delayMillis
     */
    public static void runOnAsyncThread(final Runnable runnable, long delayMillis) {
        sBackgroundHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mCacheThreadPoolExecutor.execute(runnable);
            }
        }, delayMillis);
    }
}
