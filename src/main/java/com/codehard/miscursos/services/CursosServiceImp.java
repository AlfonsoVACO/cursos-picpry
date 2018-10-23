package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Cursos;
import com.codehard.miscursos.repositories.CursosReporitory;

@Service("servicioCursos")
public class CursosServiceImp {
	@Autowired
	@Qualifier("cursosRepository")
	public CursosReporitory cursosRepository;

	public Optional<Cursos> getCursosById(Integer id) {
		return cursosRepository.findById(id);
	}

	public List<Cursos> getCursosAll() {
		return cursosRepository.findAll();
	}

	public Cursos addCursos(Cursos cursos) {
		return cursosRepository.saveAndFlush(cursos);
	}

	public Cursos editCursos(Cursos cursos) {
		return cursosRepository.saveAndFlush(cursos);
	}

	public void deleteCursos(Integer id) {
		cursosRepository.deleteById(id);
	}
}
