package com.paulobressan.financas.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Transaction(
    @SerializedName("_id")
    val id: String = "",
    val category: Category,
    val date: Date,
    val value: Double,
    @SerializedName("type")
    val transactionType: Int
)