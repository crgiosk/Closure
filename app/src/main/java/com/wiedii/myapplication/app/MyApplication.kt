package com.wiedii.myapplication.app

import android.app.Application
import com.wiedii.myapplication.modules.applicationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            androidLogger()
            modules(listOf(applicationModule))
        }
    }
}