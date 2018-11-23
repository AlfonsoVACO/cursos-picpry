package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Servicios;
import com.codehard.miscursos.repositories.ServiciosRepository;

@Service("servicioServicios")
public class ServiciosServiceImp {

	@Autowired
	@Qualifier("serviciosRepository")
	private ServiciosRepository serviciosRepository;
	
	public Optional<Servicios> getServiciosById(Integer id) {
		return serviciosRepository.findById(id);
	}

	public List<Servicios> getServiciosAll() {
		return serviciosRepository.findAll();
	}

	public Servicios addServicios(Servicios servicios) {
		return serviciosRepository.saveAndFlush(servicios);
	}

	public Servicios editServicios(Servicios servicios) {
		return serviciosRepository.saveAndFlush(servicios);
	}

	public void deleteServicios(Integer id) {
		serviciosRepository.deleteById(id);
	}
	
}
