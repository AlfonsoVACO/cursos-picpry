package com.codehard.miscursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehard.miscursos.modelos.Plantel;

@Repository("plantelRepository")
public interface PlantelReporitory extends JpaRepository<Plantel, Integer>{

}
