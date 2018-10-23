package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Estados;
import com.codehard.miscursos.repositories.EstadosReporitory;

@Service("servicioEstados")
public class EstadosServiceImp {
	@Autowired
	@Qualifier("estadosRepository")
	public EstadosReporitory estadosRepository;

	public Optional<Estados> getEstadosById(Integer id) {
		return estadosRepository.findById(id);
	}

	public List<Estados> getEstadosAll() {
		return estadosRepository.findAll();
	}

	public Estados addEstados(Estados estados) {
		return estadosRepository.saveAndFlush(estados);
	}

	public Estados editEstados(Estados estados) {
		return estadosRepository.saveAndFlush(estados);
	}

	public void deleteEstados(Integer id) {
		estadosRepository.deleteById(id);
	}
}
