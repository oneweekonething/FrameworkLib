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

    override fun clearTagUsed(): ILogService {
        tagUsedClear = true
        return this
    }


    private var debugLogService: ILogService? = null
    private var releaseLogService: ILogService? = null
    private var mTag: Tag? = null
    private var tagUsedClear = false
    private fun logService(): ILogService? {
        return if (BuildConfig.DEBUG) {
            debugLog()
        } else {
            releaseLog()
        }
        return null
    }
    private fun getTag():String{
        val tagSt = if (mTag == null) {
            "logTag"
        } else {
            mTag.toString()
        }
        if (tagUsedClear){
            tagUsedClear = false
            mTag = null
        }
        return tagSt
    }

    private fun debugLog(): ILogService? {
        if (debugLogService == null) {
            debugLogService = object : ILogService {
                override fun d(msg: String?) {
                    Log.d(getTag(), LogUtil.addTags(msg))
                }

                override fun d(msg: String?, tr: Throwable?) {
                    Log.d(getTag(), LogUtil.addTags(msg, tr))
                }

                override fun d(msg: String?, instance: Any?, tr: Throwable?) {
                    Log.d(getTag(), LogUtil.addTags(msg, tr, instance))
                }

                override fun e(msg: String?) {
                    Log.e(getTag(), LogUtil.addTags(msg))
                }

                override fun e(msg: String?, tr: Throwable?) {
                    Log.e(getTag(), LogUtil.addTags(msg, tr))
                }

                override fun e(msg: String?, instance: Any?, tr: Throwable?) {
                    Log.e(getTag(), LogUtil.addTags(msg, tr, instance))
                }

                override fun i(msg: String?) {
                    Log.i(getTag(), LogUtil.addTags(msg))
                }

                override fun i(msg: String?, tr: Throwable?) {
                    Log.i(getTag(), LogUtil.addTags(msg, tr))
                }

                override fun i(msg: String?, instance: Any?, tr: Throwable?) {
                    Log.i(getTag(), LogUtil.addTags(msg, tr, instance))
                }

                override fun v(msg: String?) {
                    Log.v(getTag(), LogUtil.addTags(msg))
                }

                override fun v(msg: String?, tr: Throwable?) {
                    Log.v(getTag(), LogUtil.addTags(msg, tr))
                }

                override fun v(msg: String?, instance: Any?, tr: Throwable?) {
                    Log.v(getTag(), LogUtil.addTags(msg, tr, instance))
                }

                override fun w(msg: String?) {
                    Log.w(getTag(), LogUtil.addTags(msg))
                }

                override fun w(msg: String?, tr: Throwable?) {
                    Log.w(getTag(), LogUtil.addTags(msg, tr))
                }

                override fun w(msg: String?, instance: Any?, tr: Throwable?) {
                    Log.w(getTag(), LogUtil.addTags(msg, tr, instance))
                }

                override fun addTag(tag: Tag?): ILogService {
                    return this
                }

                override fun clearTagUsed(): ILogService {
                   return this
                }
            }
            return debugLogService
        } else {
            return debugLogService
        }
    }

    private fun releaseLog(): ILogService? {
        return null
    }

}