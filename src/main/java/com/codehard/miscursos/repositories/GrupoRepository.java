package com.codehard.miscursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehard.miscursos.modelos.Grupo;

@Repository("grupoRepository")
public interface GrupoRepository extends JpaRepository<Grupo, Integer>{

}
