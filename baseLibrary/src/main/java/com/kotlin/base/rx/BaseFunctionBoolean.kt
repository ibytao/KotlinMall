package com.kotlin.base.rx

import com.kotlin.base.data.protocol.BaseResp
import io.reactivex.Observable
import io.reactivex.functions.Function

class BaseFunctionBoolean<T>: Function<BaseResp<T>, Observable<Boolean>> {
    override fun apply(t: BaseResp<T>): Observable<Boolean> {
        if (t.code != 0)
            return Observable.error(BaseException(t.code, t.msg))
        return  Observable.just(true)
    }
}