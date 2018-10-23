package com.codehard.miscursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehard.miscursos.modelos.CursoProfesor;

@Repository("cursoprofesorRepository")
public interface CursoProfesorReporitory extends JpaRepository<CursoProfesor, Integer>{

}
