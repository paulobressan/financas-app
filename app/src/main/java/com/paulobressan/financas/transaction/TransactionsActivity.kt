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
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_transactions.*

class TransactionsActivity : BaseActivity() {
    private var compositeDisposable: CompositeDisposable? = null
    private var transactionBusiness: TransactionBusiness? = null
    private var recyclerView: RecyclerView? = null

    override fun layoutId(): Int {
        return R.layout.activity_transactions
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        compositeDisposable = CompositeDisposable()
        transactionBusiness = TransactionBusiness()

        initRecyclerView()
        initFabButton()

        loadTransactions()
    }

    private fun loadTransactions() {
        this.compositeDisposable?.add(
            this.transactionBusiness?.getTransactions()!!.subscribe(this::handleResponse, this::handleError)
        )
    }

    private fun initFabButton() {
        fab_transaction_add_expense.setOnClickListener {
            DialogTransactionFragment.showDialogTransaction(
                supportFragmentManager,
                "Receita",
                TransactionType.EXPENSE
            ) {
                Toast.makeText(this, "${it.category.id} - ${it.category.name}", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun initRecyclerView() {
        recyclerView = lista_transacoes_recyclerview

        val layoutManager = LinearLayoutManager(this)
        recyclerView?.layoutManager = layoutManager
    }

    private fun handleResponse(transactions: BaseResponse<Transaction>) {
        recyclerView?.adapter = TransactionAdapter(transactions.items, this)
    }

    private fun handleError(error: Throwable) {
        Toast.makeText(this, "Ops! Tente novamente mais tarde.", Toast.LENGTH_LONG).show()
    }

}
