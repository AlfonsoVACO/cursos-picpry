package com.codehard.miscursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehard.miscursos.modelos.Empresa;

@Repository("empresaRepository")
public interface EmpresaRepository extends JpaRepository<Empresa, Integer>{

}
