package com.codehard.miscursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehard.miscursos.modelos.Profesor;

@Repository("profesorRepository")
public interface ProfesorReporitory extends JpaRepository<Profesor, Integer>{

}
