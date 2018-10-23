package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.CursoProfesor;
import com.codehard.miscursos.repositories.CursoProfesorReporitory;

@Service("servicioCursoProfesor")
public class CursoProfesorServiceImp {
	@Autowired
	@Qualifier("cursoprofesorRepository")
	public CursoProfesorReporitory cursoProfesorRepository;

	public Optional<CursoProfesor> getCursoProfesorById(Integer id) {
		return cursoProfesorRepository.findById(id);
	}

	public List<CursoProfesor> getCursoProfesorAll() {
		return cursoProfesorRepository.findAll();
	}

	public CursoProfesor addCursoProfesor(CursoProfesor cursoProfesor) {
		return cursoProfesorRepository.saveAndFlush(cursoProfesor);
	}

	public CursoProfesor editCursoProfesor(CursoProfesor cursoProfesor) {
		return cursoProfesorRepository.saveAndFlush(cursoProfesor);
	}

	public void deleteCursoProfesor(Integer id) {
		cursoProfesorRepository.deleteById(id);
	}
}
