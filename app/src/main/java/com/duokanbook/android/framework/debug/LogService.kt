package com.duokanbook.android.framework.debug

import android.util.Log
import com.duokanbook.android.framework.BuildConfig


class LogService : ILogService {
    override fun d(msg: String?) {
        logService()?.d(msg)
    }

    override fun d(msg: String?, tr: Throwable?) {
        logService()?.d(msg, tr)
    }

    override fun d(msg: String?, instance: Any?, tr: Throwable?) {
        logService()?.d(msg, instance, tr)
    }

    override fun e(msg: String?) {
        logService()?.d(msg)
    }

    override fun e(msg: String?, tr: Throwable?) {
        logService()?.d(msg, tr)
    }

    override fun e(msg: String?, instance: Any?, tr: Throwable?) {
        logService()?.e(msg, instance, tr)
    }

    override fun i(msg: String?) {
        logService()?.i(msg)
    }

    override fun i(msg: String?, tr: Throwable?) {
        logService()?.i(msg, tr)
    }

    override fun i(msg: String?, instance: Any?, tr: Throwable?) {
        logService()?.i(msg, instance, tr)
    }

    override fun v(msg: String?) {
        logService()?.v(msg)
    }

    override fun v(msg: String?, tr: Throwable?) {
        logService()?.v(msg, tr)
    }

    override fun v(msg: String?, instance: Any?, tr: Throwable?) {
        logService()?.v(msg, instance, tr)
    }

    override fun w(msg: String?) {
        logService()?.w(msg)
    }

    override fun w(msg: String?, tr: Throwable?) {
        logService()?.w(msg, tr)
    }

    override fun w(msg: String?, instance: Any?, tr: Throwable?) {
        logService()?.w(msg, instance, tr)
    }

    override fun addTag(tag: Tag?): ILogService {
        mTag = tag
        return this
    }

    private var debugLogService: ILogService? = null
    private var releaseLogService: ILogService? = null
    private var mTag: Tag? = null
    private fun logService(): ILogService? {
        val tagSt = if (mTag == null) {
            "logTag"
        } else {
            mTag.toString()
        }
        return if (BuildConfig.DEBUG) {
            debugLog(tagSt)
        } else {
            releaseLog(tagSt)
        }
        return null
    }

    private fun debugLog(tagTag: String): ILogService? {
        var tag = "logTag"
        if (tag != tagTag) {
            tag = tagTag
        }
        if (debugLogService == null) {
            debugLogService = object : ILogService {
                override fun d(msg: String?) {
                    Log.d(tag, LogUtil.addTags(msg))
                }

                override fun d(msg: String?, tr: Throwable?) {
                    Log.d(tag, LogUtil.addTags(msg, tr))
                }

                override fun d(msg: String?, instance: Any?, tr: Throwable?) {
                    Log.d(tag, LogUtil.addTags(msg, tr, instance))
                }

                override fun e(msg: String?) {
                    Log.e(tag, LogUtil.addTags(msg))
                }

                override fun e(msg: String?, tr: Throwable?) {
                    Log.e(tag, LogUtil.addTags(msg, tr))
                }

                override fun e(msg: String?, instance: Any?, tr: Throwable?) {
                    Log.e(tag, LogUtil.addTags(msg, tr, instance))
                }

                override fun i(msg: String?) {
                    Log.i(tag, LogUtil.addTags(msg))
                }

                override fun i(msg: String?, tr: Throwable?) {
                    Log.i(tag, LogUtil.addTags(msg, tr))
                }

                override fun i(msg: String?, instance: Any?, tr: Throwable?) {
                    Log.i(tag, LogUtil.addTags(msg, tr, instance))
                }

                override fun v(msg: String?) {
                    Log.v(tag, LogUtil.addTags(msg))
                }

                override fun v(msg: String?, tr: Throwable?) {
                    Log.v(tag, LogUtil.addTags(msg, tr))
                }

                override fun v(msg: String?, instance: Any?, tr: Throwable?) {
                    Log.v(tag, LogUtil.addTags(msg, tr, instance))
                }

                override fun w(msg: String?) {
                    Log.w(tag, LogUtil.addTags(msg))
                }

                override fun w(msg: String?, tr: Throwable?) {
                    Log.w(tag, LogUtil.addTags(msg, tr))
                }

                override fun w(msg: String?, instance: Any?, tr: Throwable?) {
                    Log.w(tag, LogUtil.addTags(msg, tr, instance))
                }

                override fun addTag(tag: Tag?): ILogService {
                    return this
                }
            }
            return debugLogService
        } else {
            return debugLogService
        }
    }

    private fun releaseLog(tag: String): ILogService? {
        return null
    }

}