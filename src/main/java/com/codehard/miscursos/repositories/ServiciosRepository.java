package com.codehard.miscursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehard.miscursos.modelos.Servicios;

@Repository("serviciosRepository")
public interface ServiciosRepository extends JpaRepository<Servicios, Integer>{

}
