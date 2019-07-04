package com.paulobressan.financas.transaction

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.paulobressan.financas.R
import com.paulobressan.financas.base.BaseActivity
import com.paulobressan.financas.enum.TransactionType
import com.paulobressan.financas.model.Transaction
import com.paulobressan.financas.network.BaseResponse
import com.paulobressan.financas.transaction.dialog.DialogTransactionFragment
import kotlinx.android.synthetic.main.activity_transactions.*
import kotlinx.android.synthetic.main.resume_card.*

class TransactionsActivity : BaseActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun layoutId(): Int {
        return R.layout.activity_transactions
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initRecyclerView()
        initFabButton()

        loadTransactions()
    }

    private fun loadTransactions() {
        this.addCompose(
            TransactionBusiness.getTransactions().subscribe(this::handleResponse, this::handleError)
        )
    }

    private fun initFabButton() {
        fab_transaction_add_revenue.setOnClickListener {
            DialogTransactionFragment.showDialogTransaction(
                supportFragmentManager,
                "Receita",
                TransactionType.REVENUE
            ) {
                fab_transaction.close(true)
                addCompose(
                    TransactionBusiness.postTransaction(it.let {
                        TransactionEntity(
                            it.category.id,
                            it.date,
                            it.value,
                            it.transactionType
                        )
                    }).subscribe({
                        loadTransactions()
                        Toast.makeText(this, "Cadastrado com sucesso", Toast.LENGTH_LONG).show()
                    }, {
                        Toast.makeText(this, "Falha ao cadastrar", Toast.LENGTH_LONG).show()
                    })
                )
            }
        }

        fab_transaction_add_expense.setOnClickListener {
            DialogTransactionFragment.showDialogTransaction(
                supportFragmentManager,
                "Despesa",
                TransactionType.EXPENSE
            ) {
                fab_transaction.close(true)
                addCompose(
                    TransactionBusiness.postTransaction(it.let {
                        TransactionEntity(
                            it.category.id,
                            it.date,
                            it.value,
                            it.transactionType
                        )
                    }).subscribe({
                        loadTransactions()
                        Toast.makeText(this, "Cadastrado com sucesso", Toast.LENGTH_LONG).show()
                    }, {
                        Toast.makeText(this, "Falha ao cadastrar", Toast.LENGTH_LONG).show()
                    })
                )
            }
        }
    }

    private fun initRecyclerView() {
        recyclerView = lista_transacoes_recyclerview

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
    }

    private fun handleResponse(transactions: BaseResponse<Transaction>) {
        val items = transactions.items
        recyclerView.adapter = TransactionAdapter(items, this)
        txtvDespesaValor.text = getString(
            R.string.text_value,
            items.filter { it.transactionType == TransactionType.EXPENSE }.sumByDouble { it.value })
        txtvReceitaValor.text = getString(
            R.string.text_value,
            items.filter { it.transactionType == TransactionType.REVENUE }.sumByDouble { it.value })
    }

    private fun handleError(error: Throwable) {
        Toast.makeText(this, "Ops! Tente novamente mais tarde.", Toast.LENGTH_LONG).show()
    }

}
