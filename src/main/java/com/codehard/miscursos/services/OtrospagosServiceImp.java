package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Otrospagos;
import com.codehard.miscursos.repositories.OtrospagosRepository;

@Service("servicioOtrospagos")
public class OtrospagosServiceImp {
	@Autowired
	@Qualifier("otrospagosRepository")
	public OtrospagosRepository otrospagosRepository;

	public Optional<Otrospagos> getOtrospagosById(Integer id) {
		return otrospagosRepository.findById(id);
	}

	public List<Otrospagos> getOtrospagosAll() {
		return otrospagosRepository.findAll();
	}

	public Otrospagos addOtrospagos(Otrospagos otrospagos) {
		return otrospagosRepository.saveAndFlush(otrospagos);
	}

	public Otrospagos editOtrospagos(Otrospagos otrospagos) {
		return otrospagosRepository.saveAndFlush(otrospagos);
	}

	public void deleteOtrospagos(Integer id) {
		otrospagosRepository.deleteById(id);
	}
}
