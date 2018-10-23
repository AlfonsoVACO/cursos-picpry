package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Asistencia;
import com.codehard.miscursos.repositories.AsistenciaReporitory;

@Service("servicioAsistencia")
public class AsistenciaServiceImp {
	@Autowired
	@Qualifier("asistenciaRepository")
	public AsistenciaReporitory asistenciaRepository;

	public Optional<Asistencia> getAsistenciaById(Integer id) {
		return asistenciaRepository.findById(id);
	}

	public List<Asistencia> getAsistenciaAll() {
		return asistenciaRepository.findAll();
	}

	public Asistencia addAsistencia(Asistencia asistencia) {
		return asistenciaRepository.saveAndFlush(asistencia);
	}

	public Asistencia editAsistencia(Asistencia asistencia) {
		return asistenciaRepository.saveAndFlush(asistencia);
	}

	public void deleteAsistencia(Integer id) {
		asistenciaRepository.deleteById(id);
	}
}
