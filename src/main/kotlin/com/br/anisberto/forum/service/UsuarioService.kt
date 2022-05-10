package com.br.anisberto.forum.service

import com.br.anisberto.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService (private var usuarios: List<Usuario>){

    init {
        val usuario1: Usuario = Usuario(
            id = 1,
            nome = "maria reis",
            email = "maria@gmail.com"
        )
        val usuario2: Usuario = Usuario(
            id = 2,
            nome = "marta reis",
            email = "marta@gmail.com"
        )
        val usuario3: Usuario = Usuario(
            id = 3,
            nome = "anisberto reis",
            email = "anisberto@gmail.com"
        )

        usuarios = Arrays.asList(usuario1, usuario2, usuario3)
    }

    fun listAll(): List<Usuario>{
        return usuarios;
    }
    fun findById(id: Long): Usuario{
        return usuarios.stream().filter { c ->
            c.id == id
        }.findFirst().get();
    }

}
