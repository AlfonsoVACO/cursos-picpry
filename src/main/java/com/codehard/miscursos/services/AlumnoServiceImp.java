package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Alumno;
import com.codehard.miscursos.repositories.AlumnoReporitory;

@Service("servicioAlumno")
public class AlumnoServiceImp {
	@Autowired
	@Qualifier("alumnoRepository")
	public AlumnoReporitory alumnoRepository;

	public Optional<Alumno> getAlumnoById(Integer id) {
		return alumnoRepository.findById(id);
	}

	public List<Alumno> getAlumnoAll() {
		return alumnoRepository.findAll();
	}

	public Alumno addAlumno(Alumno alumno) {
		return alumnoRepository.saveAndFlush(alumno);
	}

	public Alumno editAlumno(Alumno alumno) {
		return alumnoRepository.saveAndFlush(alumno);
	}

	public void deleteAlumno(Integer id) {
		alumnoRepository.deleteById(id);
	}
}
