package com.duokanbook.android.framework.async

import android.os.Handler
import java.util.concurrent.Executor


open class HandlerExecutor(private val mHandler: Handler) : Executor {
    override fun execute(runnable: Runnable) {
        mHandler.post(runnable)
    }
}