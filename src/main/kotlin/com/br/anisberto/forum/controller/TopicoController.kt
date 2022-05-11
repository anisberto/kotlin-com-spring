package com.br.anisberto.forum.controller

import com.br.anisberto.forum.dto.TopicoDTO
import com.br.anisberto.forum.dto.TopicoDTOResponse
import com.br.anisberto.forum.model.Topico
import com.br.anisberto.forum.service.TopicoService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/topicos")
@CrossOrigin("*")
class TopicoController(private val topicoService: TopicoService) {

    @GetMapping
    fun listar() : List<TopicoDTOResponse>{
        return topicoService.listar();
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) : TopicoDTOResponse{
        return topicoService.findById(id);
    }
    @PostMapping
    fun cadastrarTopico(@RequestBody dto: TopicoDTO): TopicoDTOResponse{
        return topicoService.cadastrar(dto);
    }
}