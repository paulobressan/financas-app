package com.paulobressan.financas.adapter

import android.content.Context
import android.graphics.drawable.Icon
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.paulobressan.financas.R
import com.paulobressan.financas.enum.TransacaoType
import com.paulobressan.financas.format
import com.paulobressan.financas.model.Transacao
import kotlinx.android.synthetic.main.transacao_item.view.*

class ListaTransacoesAdapter(private val transacoes: List<Transacao>, private val context: Context) :
    Adapter<ListaTransacoesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.transacao_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return transacoes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val transacao = transacoes[position]
        holder.bindView(transacao)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(transacao: Transacao) {
            val descricao = itemView.txtvItemDescricao
            val valor = itemView.txtvItemValor
            val data = itemView.txtvItemData
            val image = itemView.imgvItem

            descricao.text = transacao.descricao
            valor.text = transacao.valor.toString()
            data.text = transacao.data.format("dd/MM/yyyy")
            when (transacao.transacaoType) {
                TransacaoType.despesa -> image.setImageResource(R.drawable.icone_transacao_item_despesa)
                TransacaoType.receita -> image.setImageResource(R.drawable.icone_transacao_item_receita)
            }
        }
    }
}