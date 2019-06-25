package com.paulobressan.financas

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.paulobressan.financas.enum.TransactionType
import com.paulobressan.financas.extension.format
import java.util.*

@BindingAdapter("app:formatDate")
fun TextView.formatDate(date: Date) {
    this.text = date.format("dd/MM/yyyy")
}

@BindingAdapter("app:setImage")
fun ImageView.setImage(transactionType: Int) {
    when (transactionType) {
        TransactionType.EXPENSE -> this.setImageResource(R.drawable.ic_transaction_expense)
        TransactionType.REVENUE -> this.setImageResource(R.drawable.ic_transaction_revenue)
    }
}