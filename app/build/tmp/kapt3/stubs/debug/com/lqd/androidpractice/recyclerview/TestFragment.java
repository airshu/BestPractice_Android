package com.lqd.androidpractice.recyclerview;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006#"}, d2 = {"Lcom/lqd/androidpractice/recyclerview/TestFragment;", "Landroidx/fragment/app/Fragment;", "()V", "fragmentPosition", "", "getFragmentPosition", "()I", "setFragmentPosition", "(I)V", "mDatas", "Ljava/util/ArrayList;", "", "getMDatas", "()Ljava/util/ArrayList;", "setMDatas", "(Ljava/util/ArrayList;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "Companion", "TestAdapter", "app_debug"})
public final class TestFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    public static final com.lqd.androidpractice.recyclerview.TestFragment.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    private static com.lqd.androidpractice.recyclerview.MyRecycledViewPool recycledViewPool;
    private int fragmentPosition = -1;
    public androidx.recyclerview.widget.RecyclerView recyclerView;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> mDatas;
    private java.util.HashMap _$_findViewCache;
    
    public TestFragment() {
        super();
    }
    
    public final int getFragmentPosition() {
        return 0;
    }
    
    public final void setFragmentPosition(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView getRecyclerView() {
        return null;
    }
    
    public final void setRecyclerView(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getMDatas() {
        return null;
    }
    
    public final void setMDatas(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\u000f\u001a\u00020\bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\bH\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\bH\u0016R\u000e\u0010\n\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0017"}, d2 = {"Lcom/lqd/androidpractice/recyclerview/TestFragment$TestAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/lqd/androidpractice/recyclerview/MyViewHolder;", "datas", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "fragmentPosition", "", "(Ljava/util/ArrayList;I)V", "TAG", "getDatas", "()Ljava/util/ArrayList;", "getFragmentPosition", "()I", "getItemCount", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "app_debug"})
    public static final class TestAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.lqd.androidpractice.recyclerview.MyViewHolder> {
        @org.jetbrains.annotations.NotNull()
        private final java.util.ArrayList<java.lang.String> datas = null;
        private final int fragmentPosition = 0;
        private final java.lang.String TAG = "TestAdapter";
        
        public TestAdapter(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<java.lang.String> datas, int fragmentPosition) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.ArrayList<java.lang.String> getDatas() {
            return null;
        }
        
        public final int getFragmentPosition() {
            return 0;
        }
        
        @java.lang.Override()
        public int getItemCount() {
            return 0;
        }
        
        @java.lang.Override()
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
        com.lqd.androidpractice.recyclerview.MyViewHolder viewHolder, int position) {
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public com.lqd.androidpractice.recyclerview.MyViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup parent, int position) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/lqd/androidpractice/recyclerview/TestFragment$Companion;", "", "()V", "recycledViewPool", "Lcom/lqd/androidpractice/recyclerview/MyRecycledViewPool;", "getRecycledViewPool", "()Lcom/lqd/androidpractice/recyclerview/MyRecycledViewPool;", "setRecycledViewPool", "(Lcom/lqd/androidpractice/recyclerview/MyRecycledViewPool;)V", "newInstance", "Lcom/lqd/androidpractice/recyclerview/TestFragment;", "pos", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.lqd.androidpractice.recyclerview.TestFragment newInstance(int pos) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.lqd.androidpractice.recyclerview.MyRecycledViewPool getRecycledViewPool() {
            return null;
        }
        
        public final void setRecycledViewPool(@org.jetbrains.annotations.NotNull()
        com.lqd.androidpractice.recyclerview.MyRecycledViewPool p0) {
        }
    }
}