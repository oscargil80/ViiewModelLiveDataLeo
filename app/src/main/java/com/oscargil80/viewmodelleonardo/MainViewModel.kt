package com.oscargil80.viewmodelleonardo


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {

    private var _count = MutableStateFlow<Int>(0)
    val count: StateFlow<Int> = _count

    private var _event = MutableSharedFlow<Boolean>()
    val event = _event.asSharedFlow()

    init {
    }


    fun incrementarValor() {
        _count.value = _count.value.plus(1)
    }

    fun decrementarValor() {
        if (_count.value > 0) {
            _count.value = _count.value.minus(1)
        } else {
            viewModelScope.launch {
                _event.emit(true)
            }
        }
    }


}