package com.codehard.miscursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehard.miscursos.modelos.Calificacion;

@Repository("calificacionRepository")
public interface CalificacionRepository extends JpaRepository<Calificacion, Integer>{

}
