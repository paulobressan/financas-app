package com.paulobressan.financas.model

import com.paulobressan.financas.enum.TransactionType
import java.util.*

class Transaction(
    val description: String,
    val date: Date,
    val value: Double,
    val transactionType: Int
)