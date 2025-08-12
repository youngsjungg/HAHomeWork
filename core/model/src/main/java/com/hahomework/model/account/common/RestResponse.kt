package com.hahomework.model.account.common

sealed class RestResponse<out T> {
    data class Success<T>(val data: T) : RestResponse<T>()
    data class Fail(val message: String) : RestResponse<Nothing>()
}