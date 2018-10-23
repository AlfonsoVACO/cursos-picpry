package com.codehard.miscursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehard.miscursos.modelos.Libros;

@Repository("librosRepository")
public interface LibrosReporitory extends JpaRepository<Libros, Integer>{

}
