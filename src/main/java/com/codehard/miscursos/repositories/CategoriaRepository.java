package com.codehard.miscursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehard.miscursos.modelos.Categoria;

@Repository("categoriaRepository")
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
