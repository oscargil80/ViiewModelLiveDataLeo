package com.oscargil80.viewmodelleonardo


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*


class MainViewModel : ViewModel() {

    private var _time = MutableStateFlow<Int>(0)
    val count: StateFlow<Int> = _time

    init {
        startTimer()
    }


    private fun startTimer() {

        (60 downTo 0).asFlow().onEach { value ->
            _time.value = value
            delay(1000)
        }.launchIn(viewModelScope)
    }


}