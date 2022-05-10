package com.br.anisberto.forum.model

import com.br.anisberto.forum.enumeration.TopicoStatus
import java.time.LocalDateTime

data class Topico(
    val id: Long? = null,
    val titulo: String,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val curso: Curso,
    val autor: Usuario,
    val status: TopicoStatus = TopicoStatus.NAO_RESPONDIDO,
    val respostas: List<Resposta> = ArrayList()
)