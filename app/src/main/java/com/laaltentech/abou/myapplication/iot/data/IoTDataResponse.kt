package com.laaltentech.abou.myapplication.iot.data

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

class IoTDataResponse{
    @PrimaryKey(autoGenerate = false)

    @SerializedName("msg")
    var game_id: String? = null

    @SerializedName("orders")
    var iotData: IoTDataTable? = null

    @SerializedName("status")
    var status: String? = null
}