package com.paulobressan.financas

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.paulobressan.financas.adapter.ListaTransacoesAdapter
import com.paulobressan.financas.base.BaseActivity
import com.paulobressan.financas.enum.TransacaoType
import com.paulobressan.financas.model.Transacao
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import java.util.*

class ListaTransacoesActivity : BaseActivity() {
    override fun layoutId(): Int {
        return R.layout.activity_lista_transacoes
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val recyclerView = lista_transacoes_recyclerview
        recyclerView.adapter = ListaTransacoesAdapter(transacoes(), this)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

    }

    private fun transacoes(): List<Transacao> {
        return listOf(
            Transacao("Sorvete Azul", Date(), 40.00, TransacaoType.despesa),
            Transacao("Açaí Borboleta", Date(), 20.00, TransacaoType.despesa),
            Transacao("Pagamento", Date(), 600, TransacaoType.receita),
            Transacao("Sorvete Azul", Date(), 40.00, TransacaoType.despesa),
            Transacao("Açaí Borboleta", Date(), 20.00, TransacaoType.despesa),
            Transacao("Pagamento", Date(), 600, TransacaoType.receita),
            Transacao("Sorvete Azul", Date(), 40.00, TransacaoType.despesa),
            Transacao("Açaí Borboleta", Date(), 20.00, TransacaoType.despesa),
            Transacao("Pagamento", Date(), 600, TransacaoType.receita)

        )
    }
}
