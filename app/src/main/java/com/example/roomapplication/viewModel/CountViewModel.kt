package com.example.roomapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel : ViewModel() {

    private val _count = MutableLiveData(0)
    val count: LiveData<Int> = _count

    fun countInc() {

        _count.value = _count.value?.plus(10)
    }
}