package com.codehard.miscursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehard.miscursos.modelos.Auditoria;

@Repository("auditoriaRepository")
public interface AuditoriaRepository extends JpaRepository<Auditoria, Integer>{

}
