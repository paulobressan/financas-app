package com.paulobressan.financas.transaction

import com.paulobressan.financas.model.Category
import com.paulobressan.financas.model.Transaction
import com.paulobressan.financas.network.BaseResponse
import com.paulobressan.financas.network.Network
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


object TransactionBusiness {
    fun getTransactions(): Single<BaseResponse<Transaction>> {
        return Network.getTransactions()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    fun getCategories(): Single<BaseResponse<Category>> {
        return Network.getCategories()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    fun postTransaction(transaction: TransactionEntity): Single<BaseResponse<Transaction>>{
        return Network.postTransactions(transaction)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}