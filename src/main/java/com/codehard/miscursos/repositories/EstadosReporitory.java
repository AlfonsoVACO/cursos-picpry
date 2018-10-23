package com.codehard.miscursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehard.miscursos.modelos.Estados;

@Repository("estadosRepository")
public interface EstadosReporitory extends JpaRepository<Estados, Integer>{

}
