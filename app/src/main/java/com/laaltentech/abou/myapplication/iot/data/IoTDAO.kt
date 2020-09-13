package com.laaltentech.abou.myapplication.iot.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface IoTDAO{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertIoTData(iotData: IoTDataTable)

    @Query("SELECT * FROM IoTDataTable WHERE timestamp = :timestamp")
    fun loadAll(timestamp : String) : LiveData<IoTDataTable>
}