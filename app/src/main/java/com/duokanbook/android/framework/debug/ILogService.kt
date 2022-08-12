package com.duokanbook.android.framework.debug

import com.duokanbook.android.framework.services.IService

/**
 * @see android.util.Log
 */
interface ILogService : ILogServiceEx,IService {
    fun d(msg: String?)

    fun d(msg: String?, tr: Throwable?)

    fun e(msg: String?)

    fun e(msg: String?, tr: Throwable?)

    fun i(msg: String?)

    fun i(msg: String?, tr: Throwable?)

    fun v(msg: String?)

    fun v(msg: String?, tr: Throwable?)

    fun w(msg: String?)

    fun w(msg: String?, tr: Throwable?)


}