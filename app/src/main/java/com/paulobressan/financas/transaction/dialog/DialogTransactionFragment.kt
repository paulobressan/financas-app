package com.paulobressan.financas.transaction.dialog

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.paulobressan.financas.R
import com.paulobressan.financas.databinding.DialogTransactionBinding
import com.paulobressan.financas.model.Category
import com.paulobressan.financas.model.Transaction
import com.paulobressan.financas.network.BaseResponse
import com.paulobressan.financas.transaction.TransactionBusiness
import io.reactivex.disposables.CompositeDisposable
import java.text.SimpleDateFormat
import java.util.*


class DialogTransactionFragment(
    private val title: String,
    private val transactionType: Int,
    private val confirm: (transaction: Transaction) -> Unit
) : DialogFragment() {
    private var compositeDisposable = CompositeDisposable()
    private var transactionBusiness = TransactionBusiness()
    private lateinit var binding: DialogTransactionBinding
    private var categories: List<Category> = Collections.emptyList()

    @SuppressLint("SimpleDateFormat")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.dialog_transaction,
            container,
            false
        )

        initDialog()

        loadSpinner()

        return binding.root
    }

    private fun initDialog() {
        binding.textTitle.text = this.title


        binding.buttonAdd.setOnClickListener {
            val transaction = Transaction(
                category = categories[binding.spinnerCategories.selectedItemPosition],
                date = SimpleDateFormat("dd/MM/yyyy").parse(binding.editDate.text.toString())!!,
                value = binding.editValue.text.toString().toDouble(),
                transactionType = this.transactionType
            )

            confirm(transaction)
            this.dismiss()
        }
    }

    private fun loadSpinner() {
        this.compositeDisposable.add(
            this.transactionBusiness.getCategories().subscribe(this::handlerResponse)
        )
    }

    private fun handlerResponse(categories: BaseResponse<Category>) {
        val adapter = CategoryTransactionAdapter(activity as AppCompatActivity, categories.items)
        binding.spinnerCategories.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        this.dialog.window!!.setLayout(MATCH_PARENT, WRAP_CONTENT)
    }

    companion object {
        fun showDialogTransaction(
            supportFragmentManager: FragmentManager,
            title: String,
            transactionType: Int,
            confirm: (transaction: Transaction) -> Unit
        ) {
            DialogTransactionFragment(title, transactionType, confirm)
                .show(supportFragmentManager, null)
        }
    }
}
