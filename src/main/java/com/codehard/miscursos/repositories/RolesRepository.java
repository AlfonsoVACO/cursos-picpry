package com.codehard.miscursos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codehard.miscursos.modelos.Roles;

@Repository("rolesRepository")
public interface RolesRepository extends JpaRepository<Roles, Integer>{

}
