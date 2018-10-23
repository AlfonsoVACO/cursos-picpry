package com.codehard.miscursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehard.miscursos.modelos.Config;

@Repository("configRepository")
public interface ConfigReporitory extends JpaRepository<Config, Integer>{

}
