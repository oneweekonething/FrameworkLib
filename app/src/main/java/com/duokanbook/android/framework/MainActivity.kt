package com.duokanbook.android.framework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.duokanbook.android.framework.debug.ILogService
import com.duokanbook.android.framework.debug.LogService
import com.duokanbook.android.framework.debug.Tag
import com.duokanbook.android.framework.services.Services

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Services.`as`(ILogService::class.java).w("main jjjj ")
        Services.`as`(ILogService::class.java).addTag(Tag("pad")).w("mainxxx")
        Services.`as`(ILogService::class.java).w("mainjjjjjaa")
        Services.`as`(ILogService::class.java).addTag(Tag("padpad")).clearTagUsed().w("aaaa")
        Services.`as`(ILogService::class.java).w("bbb")
        Services.`as`(ILogService::class.java).w("bbb",this,null)
    }
}