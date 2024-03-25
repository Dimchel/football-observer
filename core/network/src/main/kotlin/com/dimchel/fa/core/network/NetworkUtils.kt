package com.dimchel.fa.core.network

import com.dimchel.fa.core.common.architecture.DataResult

suspend fun <T> safeApiCall(apiCall: suspend () -> T) : DataResult<T> {
    return try {
        DataResult.Success(apiCall.invoke())
    } catch (throwable: Throwable) {
        DataResult.Failure
    }
}