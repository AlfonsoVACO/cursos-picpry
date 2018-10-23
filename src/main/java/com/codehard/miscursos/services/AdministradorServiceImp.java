package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Administrador;
import com.codehard.miscursos.repositories.AdministradorRepository;

@Service("servicioAdministrador")
public class AdministradorServiceImp {
	@Autowired
	@Qualifier("administradorRepository")
	public AdministradorRepository administradorRepository;

	public Optional<Administrador> getAdministradorById(Integer id) {
		return administradorRepository.findById(id);
	}

	public List<Administrador> getAdministradorAll() {
		return administradorRepository.findAll();
	}

	public Administrador addAdministrador(Administrador administrador) {
		return administradorRepository.saveAndFlush(administrador);
	}

	public Administrador editAdministrador(Administrador administrador) {
		return administradorRepository.saveAndFlush(administrador);
	}

	public void deleteAdministrador(Integer id) {
		administradorRepository.deleteById(id);
	}

}
