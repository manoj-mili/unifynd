package com.mili.unifynd

import android.app.Application
import com.mili.unifynd.simpledi.Injector

class BaseApp : Application() {
    lateinit var appInjector: Injector

    override fun onCreate() {
        appInjector = Injector(this)
        super.onCreate()
    }
}