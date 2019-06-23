package com.paulobressan.financas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.paulobressan.financas.adapter.ListaTransacoesAdapter
import com.paulobressan.financas.enum.TransacaoType
import com.paulobressan.financas.model.Transacao
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import java.util.*

class ListaTransacoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val recyclerView = lista_transacoes_recyclerview
        recyclerView.adapter = ListaTransacoesAdapter(transacoes(), this)

        val layoutManager = StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.HORIZONTAL)
        recyclerView.layoutManager = layoutManager

    }

    private fun transacoes():List<Transacao>{
        return listOf(
            Transacao("Sorvete Azul", Date(), 40.00, TransacaoType.despesa),
            Transacao("Açaí Borboleta", Date(), 20.00, TransacaoType.despesa),
            Transacao("Pagamento", Date(), 600, TransacaoType.receita)
        )
    }
}
