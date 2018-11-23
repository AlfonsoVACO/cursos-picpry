package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Proyecto;
import com.codehard.miscursos.repositories.ProyectoRepository;;

@Service("servicioProyecto")
public class ProyectoServiceImp {
	
	@Autowired
	@Qualifier("proyectoRepository")
	public ProyectoRepository proyectoRepository;

	public Optional<Proyecto> getProyectoById(Integer id) {
		return proyectoRepository.findById(id);
	}

	public List<Proyecto> getProyectoAll() {
		return proyectoRepository.findAll();
	}

	public Proyecto addProyecto(Proyecto proyecto) {
		return proyectoRepository.saveAndFlush(proyecto);
	}

	public Proyecto editProyecto(Proyecto proyecto) {
		return proyectoRepository.saveAndFlush(proyecto);
	}

	public void deleteProyecto(Integer id) {
		proyectoRepository.deleteById(id);
	}
}
