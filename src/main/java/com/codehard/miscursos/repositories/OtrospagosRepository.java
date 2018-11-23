package com.codehard.miscursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehard.miscursos.modelos.Otrospagos;

@Repository("otrospagosRepository")
public interface OtrospagosRepository extends JpaRepository<Otrospagos, Integer>{

}
