package com.paulobressan.financas.transaction

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.paulobressan.financas.R
import com.paulobressan.financas.base.BaseActivity
import com.paulobressan.financas.enum.TransactionType
import com.paulobressan.financas.model.Category
import com.paulobressan.financas.model.Transaction
import com.paulobressan.financas.transaction.dialog.DialogTransactionFragment
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

        lista_transacoes_adiciona_receita.setOnClickListener {
            DialogTransactionFragment.showDialogTransaction(supportFragmentManager, "Test", TransactionType.EXPENSE) {
                Toast.makeText(this, "${it.category.id} - ${it.category.name}", Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun transacoes(): List<Transaction> {
        val categoryPayment = Category(1, "Pagamento Labs")
        val categoryFood = Category(2, "Alimentação")

        return listOf(
            Transaction(categoryFood, Date(), 40.00, TransactionType.EXPENSE),
            Transaction(categoryFood, Date(), 20.00, TransactionType.EXPENSE),
            Transaction(categoryPayment, Date(), 600.00, TransactionType.REVENUE),
            Transaction(categoryFood, Date(), 40.00, TransactionType.EXPENSE),
            Transaction(categoryFood, Date(), 20.00, TransactionType.EXPENSE),
            Transaction(categoryPayment, Date(), 600.00, TransactionType.REVENUE),
            Transaction(categoryFood, Date(), 40.00, TransactionType.EXPENSE),
            Transaction(categoryFood, Date(), 20.00, TransactionType.EXPENSE),
            Transaction(categoryPayment, Date(), 600.00, TransactionType.REVENUE)

        )
    }
}
