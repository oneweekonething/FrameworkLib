package com.duokanbook.android.framework.services

import android.app.Application
import com.duokanbook.android.framework.debug.ILogService
import com.duokanbook.android.framework.debug.LogService

object ServiceConfig {
    @JvmStatic
    fun init(application: Application) {
        Services.register(ILogService::class.java, LogService::class.java)
    }
}