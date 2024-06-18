package com.oscargil80.viewmodelleonardo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*


class MainViewModel : ViewModel() {

    private var _time = MutableStateFlow<Int>(0)
    val time: StateFlow<Int> = _time

    private val _StartCount = MutableSharedFlow<Int>()
    val StartCount = _StartCount.asSharedFlow()

    private var  _maxProgres = MutableStateFlow<Int>(0)
    val maxProgres:StateFlow<Int> = _maxProgres

    private var _isRunning = MutableStateFlow<Boolean>(false)
    val isRunnig:StateFlow<Boolean> = _isRunning


    fun incrementarValor() {
        _time.value = _time.value.plus(1)
    }

    fun decrementarValor() {
        if(_time.value >0) {
            _time.value = _time.value.minus(1)
        }
    }

    fun displayStartCount() {
        (3 downTo 0).asFlow().onEach {
            if (it > 0) {
                _StartCount.emit(it)
                delay(1000)
            } else {
                startTimer()
            }
        }.launchIn(viewModelScope)
    }

    private fun startTimer() {
        _maxProgres.value = _time.value
        _isRunning.value = true


        (_time.value downTo 0).asFlow().onEach {
            _time.value = it
            delay(1000)
        }.launchIn(viewModelScope)
    }

    fun restartTimer(){
        _maxProgres.value = 0
        _isRunning.value = false
        _time.value = 0
    }


}