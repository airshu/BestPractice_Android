package com.lqd.androidpractice.kotlin.specialclasses;

import java.lang.System;

/**
 * Sealed类的所有子类必须在同一个文件，Sealed类不能实例化
 */
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/lqd/androidpractice/kotlin/specialclasses/Mammal;", "", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "Lcom/lqd/androidpractice/kotlin/specialclasses/Cat;", "Lcom/lqd/androidpractice/kotlin/specialclasses/Human;", "app_debug"})
public abstract class Mammal {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    
    private Mammal(java.lang.String name) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
}