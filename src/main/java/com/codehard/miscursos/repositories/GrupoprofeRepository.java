package com.codehard.miscursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehard.miscursos.modelos.Grupoprofe;

@Repository("grupoprofeRepository")
public interface GrupoprofeRepository extends JpaRepository<Grupoprofe, Integer>{

}
