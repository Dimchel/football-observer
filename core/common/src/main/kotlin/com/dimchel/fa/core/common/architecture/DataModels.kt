package com.dimchel.fa.core.common.architecture

sealed class DataResult<out T> {
    class Success<out T>(val result: T) : DataResult<T>()
    data object Failure : DataResult<Nothing>()
}

fun <T, NEW> DataResult<T>.mapSuccess(function: (T) -> NEW): DataResult<NEW> =
    when (this) {
        is DataResult.Success -> DataResult.Success(function.invoke(result))
        is DataResult.Failure -> this
    }

suspend fun <T> DataResult<T>.alsoSuccess(function: suspend (T) -> Unit): DataResult<T> =
    when (this) {
        is DataResult.Success -> {
            function.invoke(this.result)
            this
        }
        is DataResult.Failure -> this
    }

suspend fun <T> DataResult<T>.mapFailure(function: suspend () -> DataResult<T>): DataResult<T> =
    when (this) {
        is DataResult.Success -> this
        is DataResult.Failure -> function.invoke()
    }