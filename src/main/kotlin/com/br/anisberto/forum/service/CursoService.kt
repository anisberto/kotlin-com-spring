package com.br.anisberto.forum.service

import com.br.anisberto.forum.model.Curso
import org.springframework.stereotype.Service
import java.util.*

@Service
class CursoService (private var cursos: List<Curso>){

    init {
        val curso1: Curso = Curso(
            id = 1,
            nome = "Curso de Java",
            categoria = "Java"
        );
        val curso2: Curso = Curso(
            id = 2,
            nome = "Curso de Kotlin com Spring",
            categoria = "Kotlin"
        )
        val curso3: Curso = Curso(
            id = 3,
            nome = "Curso de Java web",
            categoria = "Java"
        )
        cursos = Arrays.asList(curso1, curso2, curso3);
    }

    fun listAll(): List<Curso>{
        return cursos;
    }
    fun findById(id: Long): Curso {
        return cursos.stream().filter { c ->
            c.id == id
        }.findFirst().get();
    }

}
