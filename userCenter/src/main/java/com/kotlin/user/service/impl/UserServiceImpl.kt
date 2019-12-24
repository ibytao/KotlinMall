package com.kotlin.user.service.impl

import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.user.data.repository.UserRepository
import com.kotlin.user.service.UserService
import io.reactivex.Observable
import io.reactivex.functions.Function
import javax.inject.Inject

class UserServiceImpl @Inject constructor() : UserService {
    @Inject
    lateinit var repository: UserRepository

    override fun register(mobile: String, pwd: String, verifyCode: String): Observable<Boolean> {
        return repository.register(mobile, pwd, verifyCode).flatMap(object: Function<BaseResp<String>, Observable<Boolean>>{
            override fun apply(t: BaseResp<String>): Observable<Boolean> {
                print(t)
               return  Observable.just(true)
            }
        })
    }
}
