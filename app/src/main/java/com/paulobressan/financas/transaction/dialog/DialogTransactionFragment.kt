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
import com.redmadrobot.inputmask.MaskedTextChangedListener
import com.redmadrobot.inputmask.helper.AffinityCalculationStrategy
import java.text.SimpleDateFormat


class DialogTransactionFragment(
    private val title: String,
    private val transactionType: Int,
    private val confirm: (transaction: Transaction) -> Unit
) : DialogFragment() {

    private var categories = listOf(Category(1, "Pagamento Labs"), Category(2, "Alimentação"))

    @SuppressLint("SimpleDateFormat")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<DialogTransactionBinding>(
            inflater,
            R.layout.dialog_transaction,
            container,
            false
        )

        setupSuffixSample(binding)

        binding.textTitle.text = this.title

        binding.buttonAdd.setOnClickListener {
            var transaction = Transaction(
                categories[binding.spinnerCategories.selectedItemPosition],
                SimpleDateFormat("dd/MM/yyyy").parse(binding.editDate.text.toString())!!,
                binding.editValue.text.toString().toDouble(),
                this.transactionType
            )

            confirm(transaction)
            //Fechar fragmento
            this.dismiss()
        }


        val adapter = CategoryTransactionAdapter(activity as AppCompatActivity, categories)

//        val adapter = ArrayAdapter(activity!!, android.R.layout.simple_spinner_item, categories.map { it.name })
        binding.spinnerCategories.adapter = adapter

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        this.dialog.window!!.setLayout(MATCH_PARENT, WRAP_CONTENT)
    }

    private fun setupSuffixSample(binding: DialogTransactionBinding) {
        val affineFormats = listOf(
            "[00]/[00]/[0000]"
        )

        MaskedTextChangedListener.installOn(
            binding.editDate,
            affineFormats[0],
            affineFormats,
            AffinityCalculationStrategy.WHOLE_STRING
        )
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
