package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Profesor;
import com.codehard.miscursos.repositories.ProfesorReporitory;

@Service("servicioProfesor")
public class ProfesorServiceImp {
	@Autowired
	@Qualifier("profesorRepository")
	public ProfesorReporitory profesorRepository;

	public Optional<Profesor> getProfesorById(Integer id) {
		return profesorRepository.findById(id);
	}

	public List<Profesor> getProfesorAll() {
		return profesorRepository.findAll();
	}

	public Profesor addProfesor(Profesor profesor) {
		return profesorRepository.saveAndFlush(profesor);
	}

	public Profesor editProfesor(Profesor profesor) {
		return profesorRepository.saveAndFlush(profesor);
	}

	public void deleteProfesor(Integer id) {
		profesorRepository.deleteById(id);
	}
	
	public Profesor getProfesorByCriteria(Example<Profesor> example) {
		Optional<Profesor> isNull = profesorRepository.findOne(example);
		return isNull.isPresent() ? isNull.get() : new Profesor();
	}
}
