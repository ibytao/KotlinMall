package com.kotlin.user.data.api

import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.user.data.protocol.RegisterReq
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("/")
    fun register(@Body req: RegisterReq): Observable<BaseResp<String>>
}