package com.kotlin.base.data.protocol

class BaseResp<T>(val code: Int, val msg: String, val data:T) {
}