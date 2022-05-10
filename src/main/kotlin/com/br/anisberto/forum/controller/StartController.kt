package com.br.anisberto.forum.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("api/v1/server")
class StartController {

    @GetMapping("/status")
    fun start(): ResponseEntity<List<String>>{
        return ResponseEntity.ok().body(Arrays.asList("Servidor Rodando .....", "Status - 200", "Resource - Status[server]"));
    }
}