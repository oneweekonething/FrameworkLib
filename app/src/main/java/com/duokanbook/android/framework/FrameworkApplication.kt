package com.duokanbook.android.framework

import android.app.Application
import com.duokanbook.android.framework.services.ServiceConfig

class FrameworkApplication :Application(){
    override fun onCreate() {
        super.onCreate()
        ServiceConfig.init(this)
    }
}