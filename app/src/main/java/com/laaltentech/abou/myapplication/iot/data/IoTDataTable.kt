package com.laaltentech.abou.myapplication.iot.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "IoTDataTable")
class IoTDataTable{
    @PrimaryKey(autoGenerate = true)
    var pKey : Int? = 0

    @SerializedName("switchState")
    var state: String? = "00"

    @SerializedName("timeStamp")
    var timestamp: String? = "123"
}