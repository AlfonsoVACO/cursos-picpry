package com.codehard.miscursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehard.miscursos.modelos.Clases;

@Repository("clasesRepository")
public interface ClasesRepository extends JpaRepository<Clases, Integer>{

}
