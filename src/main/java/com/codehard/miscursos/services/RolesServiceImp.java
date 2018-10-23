package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Roles;
import com.codehard.miscursos.repositories.RolesRepository;

@Service("servicioRoles")
public class RolesServiceImp {
	@Autowired
	@Qualifier("rolesRepository")
	public RolesRepository rolesRepository;

	public Optional<Roles> getRolesById(Integer id) {
		return rolesRepository.findById(id);
	}

	public List<Roles> getRolesAll() {
		return rolesRepository.findAll();
	}

	public Roles addRoles(Roles roles) {
		return rolesRepository.saveAndFlush(roles);
	}

	public Roles editRoles(Roles roles) {
		return rolesRepository.saveAndFlush(roles);
	}

	public void deleteRoles(Integer id) {
		rolesRepository.deleteById(id);
	}
}
