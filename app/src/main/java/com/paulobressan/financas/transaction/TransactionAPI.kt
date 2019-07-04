package com.paulobressan.financas.transaction

import com.google.gson.annotations.SerializedName
import com.paulobressan.financas.model.Category
import com.paulobressan.financas.model.Transaction
import com.paulobressan.financas.network.BaseResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface TransactionAPI {
    @SerializedName("items")
    @GET("/transactions")
    fun getTransactions(): Single<BaseResponse<Transaction>>

    @SerializedName("items")
    @GET("/categories")
    fun getCategories(): Single<BaseResponse<Category>>

    @POST("/transactions")
    fun postTransactions(@Body transaction: TransactionEntity): Single<BaseResponse<Transaction>>
}