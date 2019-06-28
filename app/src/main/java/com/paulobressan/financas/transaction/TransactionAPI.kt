package com.paulobressan.financas.transaction

import com.google.gson.annotations.SerializedName
import com.paulobressan.financas.model.Transaction
import com.paulobressan.financas.network.BaseResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface TransactionAPI {
    @SerializedName("items")
    @GET("/transactions")
    fun getTransactions(): Observable<BaseResponse<Transaction>>
}