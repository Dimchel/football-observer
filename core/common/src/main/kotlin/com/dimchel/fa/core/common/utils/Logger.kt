package com.dimchel.fa.core.common.utils

import android.os.Looper
import android.util.Log

private const val LOG_TAG = "kkk"

fun klog(message: String) {
    Log.v(LOG_TAG, message)
}

fun klog(message: String, throwable: Throwable) {
    Log.v(LOG_TAG, message, throwable)
}

fun isMainThread(message: String) {
    Log.v(LOG_TAG, message + (Looper.getMainLooper().thread === Thread.currentThread()))
}