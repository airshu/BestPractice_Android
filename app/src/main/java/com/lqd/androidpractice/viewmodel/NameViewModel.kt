package com.lqd.androidpractice.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.Dispatchers

/**
 * Copyright (C) 2021 shjlone Inc. All rights reserved.
 *
 *
 * @author a564
 * @Date 4/28/21
 * @version 1.0
 *
 */
class NameViewModel : ViewModel() {
    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

}


object NameVMFactory : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return NameViewModel() as T
    }
}