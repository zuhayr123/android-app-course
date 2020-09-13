package com.laaltentech.abou.myapplication.di.module

import com.laaltentech.abou.myapplication.iot.owner.fragment.IoTFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentModule {
    //todo just an example to add fragments here

    @ContributesAndroidInjector
    abstract fun contributeIoTFragment(): IoTFragment
}