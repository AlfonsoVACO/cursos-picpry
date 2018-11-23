package com.codehard.miscursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehard.miscursos.modelos.Tareas;

@Repository("tareasRepository")
public interface TareasRepository extends JpaRepository<Tareas, Integer>{

}
