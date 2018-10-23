package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Municipios;
import com.codehard.miscursos.repositories.MunicipiosReporitory;

@Service("servicioMunicipios")
public class MunicipiosServiceImp {
	@Autowired
	@Qualifier("municipiosRepository")
	public MunicipiosReporitory municipiosRepository;

	public Optional<Municipios> getMunicipiosById(Integer id) {
		return municipiosRepository.findById(id);
	}

	public List<Municipios> getMunicipiosAll() {
		return municipiosRepository.findAll();
	}

	public Municipios addMunicipios(Municipios municipios) {
		return municipiosRepository.saveAndFlush(municipios);
	}

	public Municipios editMunicipios(Municipios municipios) {
		return municipiosRepository.saveAndFlush(municipios);
	}

	public void deleteMunicipios(Integer id) {
		municipiosRepository.deleteById(id);
	}
}
