package com.lqd.androidpractice.util;

import java.lang.System;

/**
 * @author: a564
 * @Date 2021/6/18
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006J\u0006\u0010\u0013\u001a\u00020\u0011R&\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/lqd/androidpractice/util/ActivityManager;", "", "()V", "list", "", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "oomActivity", "getOomActivity", "()Landroid/app/Activity;", "setOomActivity", "(Landroid/app/Activity;)V", "add", "", "activity", "check", "app_debug"})
public final class ActivityManager {
    @org.jetbrains.annotations.NotNull()
    public static final com.lqd.androidpractice.util.ActivityManager INSTANCE = null;
    @org.jetbrains.annotations.Nullable()
    private static android.app.Activity oomActivity;
    @org.jetbrains.annotations.NotNull()
    private static java.util.List<java.lang.ref.WeakReference<android.app.Activity>> list;
    
    private ActivityManager() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public android.app.Activity getOomActivity() {
        return null;
    }
    
    public void setOomActivity(@org.jetbrains.annotations.Nullable()
    android.app.Activity p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.ref.WeakReference<android.app.Activity>> getList() {
        return null;
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.ref.WeakReference<android.app.Activity>> p0) {
    }
    
    public final void add(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
    }
    
    public final void check() {
    }
}