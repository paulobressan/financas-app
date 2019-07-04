package com.paulobressan.financas.transaction

import java.util.*

data class TransactionEntity(
    val category: String,
    val date: Date,
    val value: Double,
    val type: Int
)