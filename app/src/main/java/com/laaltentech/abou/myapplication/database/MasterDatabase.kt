package com.laaltentech.abou.myapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.laaltentech.abou.myapplication.game.data.GameDAO
import com.laaltentech.abou.myapplication.game.data.GameData
import com.laaltentech.abou.myapplication.game.data.IndividualGameScore
import com.laaltentech.abou.myapplication.iot.data.IoTDAO
import com.laaltentech.abou.myapplication.iot.data.IoTDataTable

@Database(entities =
[
    (GameData::class),
    (IndividualGameScore::class),
    (IoTDataTable::class)
], version = 2, exportSchema = false)

@TypeConverters(DateConverter::class)

abstract class MasterDatabase : RoomDatabase() {

    abstract fun gameDAO(): GameDAO

    abstract fun iotDAO() : IoTDAO
}