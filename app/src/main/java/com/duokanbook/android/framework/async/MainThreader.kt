package com.duokanbook.android.framework.async

import android.os.Handler
import android.os.Looper

class MainThreader private constructor(private val mHandler: Handler):HandlerExecutor(mHandler){
    companion object{
        private val sIsMainThread: ThreadLocal<Boolean> = object : ThreadLocal<Boolean>() {
            override fun initialValue(): Boolean {
                return Looper.getMainLooper().thread === Thread.currentThread()
            }
        }
        fun create():MainThreader{
            return MainThreader(Handler(Looper.getMainLooper()))
        }
        fun isMainThread(): Boolean {
            return sIsMainThread.get()
        }
        fun checkMainThread(){
            check(isMainThread()){
                "Not main thread."
            }
        }


    }
}