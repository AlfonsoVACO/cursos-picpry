package com.codehard.miscursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehard.miscursos.modelos.Noticias;

@Repository("noticiasRepository")
public interface NoticiasReporitory extends JpaRepository<Noticias, Integer>{

}
