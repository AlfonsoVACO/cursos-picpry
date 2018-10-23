package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Calificacion;
import com.codehard.miscursos.repositories.CalificacionRepository;

@Service("servicioCalificacion")
public class CalificacionServiceImp {
	@Autowired
	@Qualifier("calificacionRepository")
	public CalificacionRepository calificacionRepository;

	public Optional<Calificacion> getCalificacionById(Integer id) {
		return calificacionRepository.findById(id);
	}

	public List<Calificacion> getCalificacionAll() {
		return calificacionRepository.findAll();
	}

	public Calificacion addCalificacion(Calificacion calificacion) {
		return calificacionRepository.saveAndFlush(calificacion);
	}

	public Calificacion editCalificacion(Calificacion calificacion) {
		return calificacionRepository.saveAndFlush(calificacion);
	}

	public void deleteCalificacion(Integer id) {
		calificacionRepository.deleteById(id);
	}
}
