package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Noticias;
import com.codehard.miscursos.repositories.NoticiasReporitory;

@Service("servicioNoticias")
public class NoticiasServiceImp {
	@Autowired
	@Qualifier("noticiasRepository")
	public NoticiasReporitory noticiasRepository;

	public Optional<Noticias> getNoticiasById(Integer id) {
		return noticiasRepository.findById(id);
	}

	public List<Noticias> getNoticiasAll() {
		return noticiasRepository.findAll();
	}

	public Noticias addNoticias(Noticias noticias) {
		return noticiasRepository.saveAndFlush(noticias);
	}

	public Noticias editNoticias(Noticias noticias) {
		return noticiasRepository.saveAndFlush(noticias);
	}

	public void deleteNoticias(Integer id) {
		noticiasRepository.deleteById(id);
	}
}
