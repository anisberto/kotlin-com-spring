package com.br.anisberto.forum.dto

import com.br.anisberto.forum.enumeration.TopicoStatus

data class TopicoDTO(
    val titulo: String,
    val mensagem: String,
    val idCurso: Long,
    val idUsuario: Long,
    val status: TopicoStatus
)
