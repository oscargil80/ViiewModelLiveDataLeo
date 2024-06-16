package com.oscargil80.viewmodelleonardo


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel:ViewModel() {

    private var _count  = MutableLiveData<Int>()
    val count: LiveData<Int> = _count

    init {
        _count.value = 0
        incrementarValor()
    }


    fun incrementarValor(){
           _count.value = _count.value?.plus(1)
        }

    fun decrementarValor(){
        _count.value = _count.value?.minus(1)
    }


}