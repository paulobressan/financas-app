package com.paulobressan.financas.model

import com.paulobressan.financas.enum.TransacaoType
import java.util.*

class Transacao(
    val descricao: String,
    val data: Date,
    val valor: Number,
    val transacaoType: TransacaoType
)