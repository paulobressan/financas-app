package com.paulobressan.financas.transaction

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.paulobressan.financas.R
import com.paulobressan.financas.base.BaseActivity
import com.paulobressan.financas.enum.TransactionType
import com.paulobressan.financas.model.Transaction
import kotlinx.android.synthetic.main.activity_transactions.*
import java.util.*

class TransactionsActivity : BaseActivity() {
    override fun layoutId(): Int {
        return R.layout.activity_transactions
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val recyclerView = lista_transacoes_recyclerview
        recyclerView.adapter = TransactionAdapter(transacoes(), this)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

    }

    private fun transacoes(): List<Transaction> {
        return listOf(
            Transaction("Sorvete Azul", Date(), 40.00, TransactionType.EXPENSE),
            Transaction("Açaí Borboleta", Date(), 20.00, TransactionType.EXPENSE),
            Transaction("Pagamento", Date(), 600.00, TransactionType.REVENUE),
            Transaction("Sorvete Azul", Date(), 40.00, TransactionType.EXPENSE),
            Transaction("Açaí Borboleta", Date(), 20.00, TransactionType.EXPENSE),
            Transaction("Pagamento", Date(), 600.00, TransactionType.REVENUE),
            Transaction("Sorvete Azul", Date(), 40.00, TransactionType.EXPENSE),
            Transaction("Açaí Borboleta", Date(), 20.00, TransactionType.EXPENSE),
            Transaction("Pagamento", Date(), 600.00, TransactionType.REVENUE)

        )
    }
}
