package com.codehard.miscursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehard.miscursos.modelos.Comentarios;

@Repository("comentariosRepository")
public interface ComentariosReporitory  extends JpaRepository<Comentarios, Integer>{

}
