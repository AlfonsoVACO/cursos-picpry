package com.codehard.miscursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehard.miscursos.modelos.Asistencia;

@Repository("asistenciaRepository")
public interface AsistenciaReporitory extends JpaRepository<Asistencia, Integer>{

}
