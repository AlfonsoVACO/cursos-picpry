package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Faltasclase;
import com.codehard.miscursos.repositories.FaltasClaseRepository;

@Service("servicioFaltasclase")
public class FaltasclaseServiceImp {
	@Autowired
	@Qualifier("faltasclaseRepository")
	public FaltasClaseRepository faltasclaseRepository;

	public Optional<Faltasclase> getFaltasclaseById(Integer id) {
		return faltasclaseRepository.findById(id);
	}

	public List<Faltasclase> getFaltasclaseAll() {
		return faltasclaseRepository.findAll();
	}

	public Faltasclase addFaltasclase(Faltasclase faltasclase) {
		return faltasclaseRepository.saveAndFlush(faltasclase);
	}

	public Faltasclase editFaltasclase(Faltasclase faltasclase) {
		return faltasclaseRepository.saveAndFlush(faltasclase);
	}

	public void deleteFaltasclase(Integer id) {
		faltasclaseRepository.deleteById(id);
	}
}
