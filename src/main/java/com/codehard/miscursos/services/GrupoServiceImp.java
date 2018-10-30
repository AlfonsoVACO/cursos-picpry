package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Grupo;
import com.codehard.miscursos.repositories.GrupoRepository;

@Service("servicioGrupo")
public class GrupoServiceImp {
	@Autowired
	@Qualifier("grupoRepository")
	public GrupoRepository grupoRepository;

	public Optional<Grupo> getGrupoById(Integer id) {
		return grupoRepository.findById(id);
	}

	public List<Grupo> getGrupoAll() {
		return grupoRepository.findAll();
	}

	public Grupo addGrupo(Grupo grupo) {
		return grupoRepository.saveAndFlush(grupo);
	}

	public Grupo editGrupo(Grupo grupo) {
		return grupoRepository.saveAndFlush(grupo);
	}

	public void deleteGrupo(Integer id) {
		grupoRepository.deleteById(id);
	}
}
