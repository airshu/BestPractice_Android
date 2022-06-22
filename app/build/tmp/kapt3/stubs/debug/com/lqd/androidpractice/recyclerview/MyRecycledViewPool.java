package com.lqd.androidpractice.recyclerview;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/lqd/androidpractice/recyclerview/MyRecycledViewPool;", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "()V", "num", "", "getNum", "()I", "setNum", "(I)V", "getRecycledView", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewType", "putRecycledView", "", "scrap", "app_debug"})
public final class MyRecycledViewPool extends androidx.recyclerview.widget.RecyclerView.RecycledViewPool {
    private int num = 0;
    
    public MyRecycledViewPool() {
        super();
    }
    
    public final int getNum() {
        return 0;
    }
    
    public final void setNum(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public androidx.recyclerview.widget.RecyclerView.ViewHolder getRecycledView(int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void putRecycledView(@org.jetbrains.annotations.Nullable()
    androidx.recyclerview.widget.RecyclerView.ViewHolder scrap) {
    }
}