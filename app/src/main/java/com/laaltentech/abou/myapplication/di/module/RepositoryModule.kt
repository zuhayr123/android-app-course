package com.laaltentech.abou.myapplication.di.module

import androidx.paging.PagedList
import com.laaltentech.abou.myapplication.di.WebService
import com.laaltentech.abou.myapplication.game.data.GameDAO
import com.laaltentech.abou.myapplication.game.repository.GameDataRepository
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
    fun provideFlickrRepository(webservice: WebService, dao: GameDAO, executor: AppExecutors): GameDataRepository {
        return GameDataRepository(webService = webservice, gameDAO = dao, appExecutors = executor)
    }

    @Provides
    @Singleton
    fun provideIoTRepository(webservice: WebService, dao: IoTDAO, executor: AppExecutors): IoTRepository {
        return IoTRepository(webService = webservice, iotDAO = dao, appExecutors = executor)
    }
}