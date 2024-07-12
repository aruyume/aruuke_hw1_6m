package com.example.aruuke_hw1_6m

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    private val repo = CounterModel() // Repository

    private val _counterData = MutableLiveData<Int>()

    val counterData: LiveData<Int> get() = _counterData

    fun onIncrement() {
        repo.increment()
        _counterData.value = repo.getResult()
    }

    fun onDecrement() {
        repo.decrement()
        _counterData.value = repo.getResult()
    }
}
