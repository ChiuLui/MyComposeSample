package com.chiului.android_mvvm_architecture.utilities

import android.util.Log
import com.chiului.mycomposesample.BuildConfig

/**
 * 日志工具类$
 * @author Lei
 * @date   2022/04/28 15:50
 */
object LogUtil {

    /**
     * 是否打印日志
     */
    private val mIsShow = BuildConfig.DEBUG

    /**
     * 日志打印 tag
     */
    const val mTag = "LogUtil"

    fun v(tag: String = mTag, msg: String) {
        if (mIsShow) Log.v(tag, msg)
    }

    fun d(tag: String = mTag, msg: String) {
        if (mIsShow) Log.d(tag, msg)
    }

    fun i(tag: String = mTag, msg: String) {
        if (mIsShow) Log.i(tag, msg)
    }

    fun w(tag: String = mTag, msg: String) {
        if (mIsShow) Log.w(tag, msg)
    }

    fun e(tag: String = mTag, msg: String) {
        if (mIsShow) Log.e(tag, msg)
    }

    fun a(tag: String = mTag, msg: String) {
        if (mIsShow) Log.wtf(tag, msg)
    }

    fun log(tag: String = mTag, level: Int = Log.INFO, msg: String) {
        when(level){
            Log.VERBOSE -> v(tag, msg)
            Log.DEBUG -> d(tag, msg)
            Log.INFO -> i(tag, msg)
            Log.WARN -> w(tag, msg)
            Log.ERROR -> e(tag, msg)
            Log.ASSERT -> a(tag, msg)
        }
    }

}

fun String.log(tag: String = LogUtil.mTag, level: Int) = LogUtil.log(tag, level, this)

fun String.logV(tag: String = LogUtil.mTag) = LogUtil.v(tag, this)

fun String.logD(tag: String = LogUtil.mTag) = LogUtil.d(tag, this)

fun String.logI(tag: String = LogUtil.mTag) = LogUtil.i(tag, this)

fun String.logW(tag: String = LogUtil.mTag) = LogUtil.w(tag, this)

fun String.logE(tag: String = LogUtil.mTag) = LogUtil.e(tag, this)

fun String.logA(tag: String = LogUtil.mTag) = LogUtil.a(tag, this)