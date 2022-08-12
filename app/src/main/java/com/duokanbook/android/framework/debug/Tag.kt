package com.duokanbook.android.framework.debug

import android.util.Log.w


class Tag(tag: String) {
    private val mValue: String
    override fun toString(): String {
        return mValue
    }
    companion object {
        private val tagTip = "FL_"
        private val MAX_TAG_LEN: Int = 23 - tagTip.length
    }

    init {
        val lenDiff = tag.length - MAX_TAG_LEN
        if (lenDiff > 0) {
            w( "Tag","Tag $tag is $lenDiff chars longer than limit.")
        }
        mValue = tagTip + if (lenDiff > 0) tag.substring(0, MAX_TAG_LEN) else tag
    }
}