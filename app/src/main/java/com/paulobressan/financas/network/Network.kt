package com.paulobressan.financas.network

import com.paulobressan.financas.model.Transaction
import com.paulobressan.financas.transaction.TransactionAPI
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Network {
    private const val URL = "http://192.168.0.109:5000"

    fun getTransactions(): Observable<BaseResponse<Transaction>> {
        return getRetrofit().create(TransactionAPI::class.java).getTransactions()
    }

    private fun getRetrofit() = Retrofit.Builder()
        .baseUrl(URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}