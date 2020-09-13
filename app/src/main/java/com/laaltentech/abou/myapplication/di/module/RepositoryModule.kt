package com.laaltentech.abou.myapplication.di.module

import com.laaltentech.abou.myapplication.di.WebService
import com.laaltentech.abou.myapplication.iot.data.IoTDAO
import com.laaltentech.abou.myapplication.iot.repository.IoTRepository
import com.laaltentech.abou.myapplication.util.AppExecutors
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    //todo provides repository

    @Provides
    @Singleton
    fun provideIoTRepository(webservice: WebService, dao: IoTDAO, executor: AppExecutors): IoTRepository {
        return IoTRepository(webService = webservice, iotDAO = dao, appExecutors = executor)
    }
}