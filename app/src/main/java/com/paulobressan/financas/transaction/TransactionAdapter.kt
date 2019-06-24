package com.paulobressan.financas.transaction

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.paulobressan.financas.R
import com.paulobressan.financas.databinding.ItemTransactionBinding
import com.paulobressan.financas.model.Transaction

class TransactionAdapter(private val transaction: List<Transaction>, private val context: Context) :
    Adapter<TransactionAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemTransactionBinding>(LayoutInflater.from(context), R.layout.item_transaction, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return transaction.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val transaction = transaction[position]
        holder.bindView(transaction)
    }

    class ViewHolder(private val binding: ItemTransactionBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindView(transaction: Transaction) {
            binding.transaction = transaction

//            description.text = transaction.description
//            valor.text = transaction.value.toString()
//            data.text = transaction.date.format("dd/MM/yyyy")
//            when (transaction.transactionType) {
//                TransactionType.EXPENSE -> image.setImageResource(R.drawable.ic_transaction_expense)
//                TransactionType.REVENUE -> image.setImageResource(R.drawable.ic_transaction_revenue)
//            }
        }
    }
}