package com.paulobressan.financas.network

import com.paulobressan.financas.model.Category
import com.paulobressan.financas.model.Transaction
import com.paulobressan.financas.transaction.TransactionAPI
import com.paulobressan.financas.transaction.TransactionEntity
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Network {
    private const val URL = "http://10.53.19.107:5000"

    fun getTransactions(): Single<BaseResponse<Transaction>> {
        return getRetrofit().create(TransactionAPI::class.java).getTransactions()
    }

    fun postTransactions(transaction: TransactionEntity): Single<BaseResponse<Transaction>> {
        return getRetrofit().create(TransactionAPI::class.java).postTransactions(transaction)
    }

    fun getCategories(): Single<BaseResponse<Category>> {
        return getRetrofit().create(TransactionAPI::class.java).getCategories()
    }

    private fun getRetrofit() = Retrofit.Builder()
        .baseUrl(URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}