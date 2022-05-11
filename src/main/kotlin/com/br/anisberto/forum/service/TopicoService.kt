package com.br.anisberto.forum.service

import com.br.anisberto.forum.dto.TopicoDTO
import com.br.anisberto.forum.dto.TopicoDTOResponse
import com.br.anisberto.forum.enumeration.TopicoStatus
import com.br.anisberto.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
) {

    fun listar(): List<TopicoDTOResponse> {
        return topicos.stream().map { topico ->
            TopicoDTOResponse(
                id = topico.id,
                titulo = topico.titulo,
                mensagem = topico.mensagem,
                status = topico.status,
                dataCriacao = topico.dataCriacao
            )
        }.collect(Collectors.toList())
    }

    fun findById(id: Long): TopicoDTOResponse {
        val topico = topicos.stream().filter { value ->
            value.id == id
        }.findFirst().get()
        return TopicoDTOResponse(
            id = topico.id,
            titulo = topico.titulo,
            mensagem = topico.mensagem,
            status = topico.status,
            dataCriacao = topico.dataCriacao
        )
    }

    fun cadastrar(dto: TopicoDTO): TopicoDTOResponse {
        topicos = topicos.plus(
            Topico(
                id = getItTopicoMock(topicos),
                titulo = dto.titulo,
                mensagem = dto.mensagem,
                curso = cursoService.findById(dto.idCurso),
                autor = usuarioService.findById(dto.idUsuario),
                status = dto.status
            )
        )
        val topico = topicos.get(topicos.lastIndex);
        return TopicoDTOResponse(
            id = topico.id,
            titulo = topico.titulo,
            mensagem = topico.mensagem,
            status = topico.status,
            dataCriacao = topico.dataCriacao
        )
    }

    fun getItTopicoMock(topicos: List<Topico>): Long {
        var counterElements: Long = 0;
        counterElements = topicos.count().toLong();
        println("Totao de elementos $counterElements")
        if (counterElements.toInt() == 0) {
            println("Proximo id sera $counterElements")
            return (++counterElements);
        } else {
            println("Proximo id sera $counterElements")
            return (counterElements + 1);
        }
    }
}