package com.paulobressan.financas.model

import java.util.*

data class Transaction(
    val category: Category,
    val date: Date,
    val value: Double,
    val transactionType: Int
)