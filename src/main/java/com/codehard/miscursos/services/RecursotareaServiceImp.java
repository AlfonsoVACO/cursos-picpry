package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Recursotarea;
import com.codehard.miscursos.repositories.ResursotareaRepository;

@Service("recursotareaServicios")
public class RecursotareaServiceImp {
	@Autowired
	@Qualifier("resursotareaRepository")
	private ResursotareaRepository recursotareaRepository;
	
	public Optional<Recursotarea> getRecursotareaById(Integer id) {
		return recursotareaRepository.findById(id);
	}

	public List<Recursotarea> getRecursotareaAll() {
		return recursotareaRepository.findAll();
	}

	public Recursotarea addRecursotarea(Recursotarea recursotarea) {
		return recursotareaRepository.saveAndFlush(recursotarea);
	}

	public Recursotarea editRecursotarea(Recursotarea recursotarea) {
		return recursotareaRepository.saveAndFlush(recursotarea);
	}

	public void deleteRecursotarea(Integer id) {
		recursotareaRepository.deleteById(id);
	}
}
