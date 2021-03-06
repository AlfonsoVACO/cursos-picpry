package com.codehard.miscursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehard.miscursos.modelos.Cursos;

@Repository("cursosRepository")
public interface CursosReporitory extends JpaRepository<Cursos, Integer>{

}
