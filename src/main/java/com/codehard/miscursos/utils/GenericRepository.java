package com.codehard.miscursos.utils;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("genericRepository")
public interface GenericRepository<T extends Object> extends JpaRepository<T, Integer> {

}
