package com.axiagroups.kotlinuipractice.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


/**
 * Created by Ahsan Habib on 5/12/2024.
 * shehanuk.ahsan@gmail.com
 */
class MainActivityViewModel : ViewModel() {
    var counter = MutableLiveData<Int>(0)
    var incrementCounter = {
        counter.value = counter.value?.plus(1)
    }
    var decrementCounter = {
        counter.value = counter.value?.minus(1)

    }
}