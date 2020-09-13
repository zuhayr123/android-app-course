package com.laaltentech.abou.myapplication.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.laaltentech.abou.myapplication.di.ViewModelKey
import com.laaltentech.abou.myapplication.factory.AppModelFactory
import com.laaltentech.abou.myapplication.iot.observer.IoTMainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    //todo add these details to the app model factory
    @Binds
    @IntoMap
    @ViewModelKey(IoTMainViewModel::class)
    abstract fun bindIoTMainViewModel(newIoTMainViewModel: IoTMainViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: AppModelFactory): ViewModelProvider.Factory
}