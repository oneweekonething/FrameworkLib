package com.duokanbook.android.framework.debug

import com.duokanbook.android.framework.async.MainThreader
import java.util.*

object LogUtil {


    fun addTags(msg: String?, tr: Throwable?=null, instance: Any?=null): String {
        return if (instance != null) {
            hashCodeTag(instance).plus(mainThreadTag()).plus(" ").plus(msg).plus(tr?.message)
        } else {
            msg?.plus(tr?:"") ?: ""
        }
    }

    private fun hashCodeTag(instance: Any?): String {
        val tag: String = if (instance == null) {
            "null"
        } else {
            Integer.toHexString(Objects.hashCode(instance))
        }
        return String.format("[%-9s]", "@$tag")
    }

    private fun mainThreadTag(): String {
        return if (MainThreader.isMainThread()) "[ui]" else ""
    }
}