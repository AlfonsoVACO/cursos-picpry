package com.codehard.miscursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehard.miscursos.modelos.Horario;

@Repository("horarioRepository")
public interface HorarioReporitory extends JpaRepository<Horario, Integer>{

}
