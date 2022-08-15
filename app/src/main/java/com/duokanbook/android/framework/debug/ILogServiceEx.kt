package com.duokanbook.android.framework.debug

interface ILogServiceEx {
    fun addTag(tag: Tag?):ILogService
    fun clearTagUsed():ILogService
    fun d(msg: String?, instance: Any?, tr: Throwable?)
    fun e(msg: String?, instance: Any?, tr: Throwable?)
    fun i(msg: String?, instance: Any?, tr: Throwable?)
    fun v(msg: String?, instance: Any?, tr: Throwable?)
    fun w(msg: String?, instance: Any?, tr: Throwable?)
}