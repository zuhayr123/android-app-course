package com.laaltentech.abou.myapplication.di

import androidx.lifecycle.LiveData
import com.laaltentech.abou.myapplication.game.data.GameData
import com.laaltentech.abou.myapplication.game.data.GameDataResponse
import com.laaltentech.abou.myapplication.iot.data.IoTDataResponse
import com.laaltentech.abou.myapplication.iot.data.IoTDataTable
import com.laaltentech.abou.myapplication.util.ApiResponse
import retrofit2.http.*

interface WebService {
    //todo just an example to use in future cases

    @POST
    fun insertGameData(@Url url: String,
                          @Body gameData : GameData) : LiveData<ApiResponse<GameDataResponse>>

    @PUT
    fun updateIotState(@Url url: String,
                        @Query("timeStamp") timeStamp : String,
                        @Body data: IoTDataTable): LiveData<ApiResponse<IoTDataResponse>>
}