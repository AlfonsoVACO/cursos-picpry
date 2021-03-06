package com.codehard.miscursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehard.miscursos.modelos.Alumno;

@Repository("alumnoRepository")
public interface AlumnoReporitory extends JpaRepository<Alumno, Integer>{

}
