package com.kotlin.base.ext

import com.kotlin.base.rx.BaseSubscriber
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Observable<T>.execute(subscribe: BaseSubscriber<T>){
    this.observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(subscribe)
}