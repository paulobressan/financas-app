package com.paulobressan.financas.network

import com.paulobressan.financas.model.Category
import com.paulobressan.financas.model.Transaction
import com.paulobressan.financas.transaction.TransactionAPI
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Network {
    private const val URL = "http://10.53.19.107:5000"

    fun getTransactions(): Observable<BaseResponse<Transaction>> {
        return getRetrofit().create(TransactionAPI::class.java).getTransactions()
    }

    fun postTransactions(transaction: Transaction): Observable<BaseResponse<Transaction>> {
        return getRetrofit().create(TransactionAPI::class.java).postTransactions(transaction)
    }

    fun getCategories(): Observable<BaseResponse<Category>> {
        return getRetrofit().create(TransactionAPI::class.java).getCategories()
    }

    private fun getRetrofit() = Retrofit.Builder()
        .baseUrl(URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}