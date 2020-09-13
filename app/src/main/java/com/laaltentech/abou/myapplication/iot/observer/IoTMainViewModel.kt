package com.laaltentech.abou.myapplication.iot.observer

import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.laaltentech.abou.myapplication.iot.data.IoTDataTable
import com.laaltentech.abou.myapplication.iot.repository.IoTRepository
import com.laaltentech.abou.myapplication.network.Resource
import com.laaltentech.abou.myapplication.util.AbsentLiveData
import com.laaltentech.abou.myapplication.util.AppExecutors
import javax.inject.Inject

class IoTMainViewModel @Inject constructor(
    private val repository: IoTRepository,
    var executors: AppExecutors
) : ViewModel(), Observable {

    val apiCall = MutableLiveData<String>()
    var ioTDataTable = IoTDataTable()
    var results: LiveData<Resource<IoTDataTable>>

    private val callbacks: PropertyChangeRegistry by lazy { PropertyChangeRegistry() }


    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.remove(callback)    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.add(callback)    }

    fun notifyChange() {
        callbacks.notifyCallbacks(this, 0, null)
    }

    init{
        results = Transformations.switchMap(apiCall){
            when(apiCall.value){
                "available" -> {
                    repository.changeIoTState(timestamp = "123", data = ioTDataTable)
                }
                else -> {
                    AbsentLiveData.create()
                }
            }
        }
    }

}