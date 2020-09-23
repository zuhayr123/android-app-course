package com.laaltentech.abou.myapplication.iot.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "IoTDataTable")
class IoTDataTable{
    @PrimaryKey(autoGenerate = true)
    var pKey : Int? = 0

    @SerializedName("redSwitch")
    var redSwitch: String? = "00"

    @SerializedName("greenSwitch")
    var greenSwitch: String? = "00"

    @SerializedName("blueSwitch")
    var blueSwitch: String? = "00"

    @SerializedName("timeStamp")
    var timestamp: String? = "123"
}