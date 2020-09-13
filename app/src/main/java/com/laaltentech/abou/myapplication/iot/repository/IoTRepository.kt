package com.laaltentech.abou.myapplication.iot.repository

import androidx.lifecycle.LiveData
import com.laaltentech.abou.myapplication.di.WebService
import com.laaltentech.abou.myapplication.iot.data.IoTDAO
import com.laaltentech.abou.myapplication.iot.data.IoTDataResponse
import com.laaltentech.abou.myapplication.iot.data.IoTDataTable
import com.laaltentech.abou.myapplication.network.NetworkBoundResource
import com.laaltentech.abou.myapplication.util.ApiResponse
import com.laaltentech.abou.myapplication.util.AppExecutors
import com.laaltentech.abou.myapplication.util.URL_HUB
import javax.inject.Inject

class IoTRepository @Inject constructor(
    private val webService: WebService,
    private val appExecutors: AppExecutors,
    private val iotDAO: IoTDAO
){

    fun changeIoTState(data : IoTDataTable, timestamp : String) : LiveData<com.laaltentech.abou.myapplication.network.Resource<IoTDataTable>>{
        return object : NetworkBoundResource<IoTDataTable, IoTDataResponse>(appExecutors = appExecutors){
            override fun saveCallResult(item: IoTDataResponse) {
                if(item.status == "success"){
                    iotDAO.insertIoTData(item.iotData!!)
                }
            }

            override fun shouldFetch(data: IoTDataTable?): Boolean = true

            override fun loadFromDb(): LiveData<IoTDataTable> {
                return iotDAO.loadAll(timestamp = timestamp)
            }

            override fun createCall(): LiveData<ApiResponse<IoTDataResponse>> {
                return webService.updateIotState(url = URL_HUB.CHANGE_STATE, timeStamp = timestamp, data = data)
            }

            override fun uploadTag(): String? = null

        }.asLiveData()
    }
}