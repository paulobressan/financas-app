package com.paulobressan.financas.transaction

import com.paulobressan.financas.model.Transaction
import com.paulobressan.financas.network.BaseResponse
import com.paulobressan.financas.network.Network
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class TransactionBusiness {
    fun getTransactions(): Observable<BaseResponse<Transaction>> {
        return Network.getTransactions()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}