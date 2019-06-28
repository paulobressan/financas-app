package com.paulobressan.financas.transaction.dialog

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.SpinnerAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.paulobressan.financas.R
import com.paulobressan.financas.databinding.ItemCategoryBinding
import com.paulobressan.financas.model.Category

class CategoryTransactionAdapter(private val activity: AppCompatActivity, private val categories: List<Category>) :
    BaseAdapter(), SpinnerAdapter {
    override fun getView(index: Int, p1: View?, viewGroup: ViewGroup?): View {
        val binding = DataBindingUtil.inflate<ItemCategoryBinding>(
            activity.layoutInflater,
            R.layout.item_category,
            viewGroup!!,
            false
        )
        binding.category = categories[index]
        return binding.root
    }

    override fun getItem(index: Int): Any {
        return categories[index]
    }

    override fun getItemId(index: Int): Long {
        val category = categories[index]
        return categories.indexOf(category).toLong()
    }

    override fun getCount(): Int {
        return categories.size
    }
}