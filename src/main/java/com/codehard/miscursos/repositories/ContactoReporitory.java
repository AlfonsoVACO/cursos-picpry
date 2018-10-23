package com.codehard.miscursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehard.miscursos.modelos.Contacto;

@Repository("contactoRepository")
public interface ContactoReporitory extends JpaRepository<Contacto, Integer>{

}
