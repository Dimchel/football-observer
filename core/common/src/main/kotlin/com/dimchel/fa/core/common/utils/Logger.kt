package com.dimchel.fa.core.common.utils

import android.util.Log

private const val LOG_TAG = "kkk"

fun klog(message: String) {
    Log.v(LOG_TAG, message)
}

fun klog(message: String, throwable: Throwable) {
    Log.v(LOG_TAG, message, throwable)
}