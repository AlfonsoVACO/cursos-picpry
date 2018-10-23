package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Recursos;
import com.codehard.miscursos.repositories.RecursosReporitory;

@Service("servicioRecursos")
public class RecursosServiceImp {
	@Autowired
	@Qualifier("recursosRepository")
	public RecursosReporitory recursosRepository;

	public Optional<Recursos> getRecursosById(Integer id) {
		return recursosRepository.findById(id);
	}

	public List<Recursos> getRecursosAll() {
		return recursosRepository.findAll();
	}

	public Recursos addRecursos(Recursos recursos) {
		return recursosRepository.saveAndFlush(recursos);
	}

	public Recursos editRecursos(Recursos recursos) {
		return recursosRepository.saveAndFlush(recursos);
	}

	public void deleteRecursos(Integer id) {
		recursosRepository.deleteById(id);
	}
}
