package com.codehard.miscursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehard.miscursos.modelos.Recursotarea;

@Repository("resursotareaRepository")
public interface ResursotareaRepository extends JpaRepository<Recursotarea, Integer>{

}
