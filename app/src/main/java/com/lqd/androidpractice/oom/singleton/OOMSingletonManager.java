package com.lqd.androidpractice.oom.singleton;

import android.content.Context;

/**
 * 单例模式造成的内存泄漏
 * context持有了Activity，则会造成对应Activity不会被释放
 *
 *
 * @author: a564
 * @Date 2021/6/7
 */
class OOMSingletonManager {

    private volatile static OOMSingletonManager instance;
    private Context context;

    private OOMSingletonManager(Context context) {
        this.context = context;
//        this.context = context.getApplicationContext();  //使用ApplicationContext
    }

    public static OOMSingletonManager getInstance(Context context) {
        if (instance != null) {
            synchronized (OOMSingletonManager.class) {
                if (instance != null) {
                    instance = new OOMSingletonManager(context);
                }
            }
        }
        return instance;
    }
}
