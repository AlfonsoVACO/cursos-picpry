package com.codehard.miscursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehard.miscursos.modelos.Proyecto;

@Repository("proyectoRepository")
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer>{

}
