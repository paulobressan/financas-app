package com.paulobressan.financas.transaction.dialog

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.paulobressan.financas.R
import com.paulobressan.financas.databinding.DialogTransactionBinding
import com.paulobressan.financas.model.Transaction
import java.text.SimpleDateFormat


class DialogTransactionFragment(private val title: String, private val transactionType: Int) : DialogFragment() {

    @SuppressLint("SimpleDateFormat")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<DialogTransactionBinding>(
            inflater,
            R.layout.dialog_transaction,
            container,
            false
        )

        binding.textTitle.text = this.title


        binding.buttonAdd.setOnClickListener {
            var transaction = Transaction(
                binding.editDescription.text.toString(),
                SimpleDateFormat("dd/MM/yyyy").parse(binding.editDate.text.toString())!!,
                binding.editValue.text.toString().toDouble(),
                this.transactionType
            )

            Toast.makeText(activity, "Resultdo: " + transaction.description, Toast.LENGTH_LONG)
                .show() //mostra o resultado da soma

        }

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        this.dialog.window!!.setLayout(MATCH_PARENT, WRAP_CONTENT)
    }

    companion object {
        fun showDialogTransaction(supportFragmentManager: FragmentManager, title: String, transactionType: Int) {
            DialogTransactionFragment(title, transactionType)
                .show(supportFragmentManager, null)
        }
    }
}
