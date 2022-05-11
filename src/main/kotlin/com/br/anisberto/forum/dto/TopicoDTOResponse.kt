package com.br.anisberto.forum.dto

import com.br.anisberto.forum.enumeration.TopicoStatus
import java.time.LocalDateTime

data class TopicoDTOResponse(
    val id: Long?,
    val titulo: String,
    val mensagem: String,
    val status: TopicoStatus?,
    val dataCriacao: LocalDateTime
)