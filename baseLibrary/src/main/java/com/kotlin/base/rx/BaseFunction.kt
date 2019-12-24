package com.kotlin.base.rx

import com.kotlin.base.data.protocol.BaseResp
import io.reactivex.Observable
import io.reactivex.functions.Function

class BaseFunction<T>: Function<BaseResp<T>, Observable<T>> {
    override fun apply(t: BaseResp<T>): Observable<T> {
        if (t.code != 0)
            return Observable.error(BaseException(t.code, t.msg))
        return  Observable.just(t.data)
    }
}