package com.codehard.miscursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehard.miscursos.modelos.Administrador;

@Repository("administradorRepository")
public interface AdministradorRepository extends JpaRepository<Administrador, Integer>{
	
}
