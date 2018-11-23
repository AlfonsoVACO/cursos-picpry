package com.codehard.miscursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehard.miscursos.modelos.Registroquiz;

@Repository("registroquizRepository")
public interface RegistroquizRepository extends JpaRepository<Registroquiz, Integer>{

}
