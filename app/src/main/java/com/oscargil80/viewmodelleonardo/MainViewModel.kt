package com.oscargil80.viewmodelleonardo
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel:ViewModel() {

    private var counter = 0

    fun getinitialCounter():Int{
        return counter
    }

    fun getUpdateCounter():Int{
        return ++counter
    }




}