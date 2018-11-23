package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Clases;
import com.codehard.miscursos.repositories.ClasesRepository;

@Service("servicioClases")
public class ClasesServiceImp {
	@Autowired
	@Qualifier("clasesRepository")
	public ClasesRepository clasesRepository;

	public Optional<Clases> getClasesById(Integer id) {
		return clasesRepository.findById(id);
	}

	public List<Clases> getClasesAll() {
		return clasesRepository.findAll();
	}

	public Clases addClases(Clases clases) {
		return clasesRepository.saveAndFlush(clases);
	}

	public Clases editClases(Clases clases) {
		return clasesRepository.saveAndFlush(clases);
	}

	public void deleteClases(Integer id) {
		clasesRepository.deleteById(id);
	}
}
