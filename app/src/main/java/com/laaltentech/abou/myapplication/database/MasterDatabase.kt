package com.laaltentech.abou.myapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.laaltentech.abou.myapplication.iot.data.IoTDAO
import com.laaltentech.abou.myapplication.iot.data.IoTDataTable

@Database(entities =
[
    (IoTDataTable::class)
], version = 4, exportSchema = false)

@TypeConverters(DateConverter::class)

abstract class MasterDatabase : RoomDatabase() {

    abstract fun iotDAO() : IoTDAO
}