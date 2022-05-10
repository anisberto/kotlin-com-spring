package com.br.anisberto.forum.service

import com.br.anisberto.forum.dto.TopicoDTO
import com.br.anisberto.forum.model.Topico
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
) {

    fun listar(): List<Topico> {
        return topicos;
    }

    fun findById(id: Long): Topico {
        return topicos.stream().filter { value ->
            value.id == id
        }.findFirst().get()
    }

    fun cadastrar(dto: TopicoDTO): Topico {
        topicos = topicos.plus(
            Topico(
                id = getItTopicoMock(topicos),
                titulo = dto.titulo,
                mensagem = dto.mensagem,
                curso = cursoService.findById(dto.idCurso),
                autor = usuarioService.findById(dto.idUsuario)
            )
        )
        return topicos.get(topicos.lastIndex);
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