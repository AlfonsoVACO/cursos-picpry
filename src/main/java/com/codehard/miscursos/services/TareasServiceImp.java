package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Tareas;
import com.codehard.miscursos.repositories.TareasRepository;

@Service("servicioTareas")
public class TareasServiceImp {

	@Autowired
	@Qualifier("tareasRepository")
	private TareasRepository tareasRepository;
	
	public Optional<Tareas> getTareasById(Integer id) {
		return tareasRepository.findById(id);
	}

	public List<Tareas> getTareasAll() {
		return tareasRepository.findAll();
	}

	public Tareas addTareas(Tareas tareas) {
		return tareasRepository.saveAndFlush(tareas);
	}

	public Tareas editTareas(Tareas tareas) {
		return tareasRepository.saveAndFlush(tareas);
	}

	public void deleteTareas(Integer id) {
		tareasRepository.deleteById(id);
	}
}
