package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Notasfinales;
import com.codehard.miscursos.repositories.NotasfinalesRepository;

@Service("servicioNotasfinales")
public class NotasfinalesServiceImp {
	@Autowired
	@Qualifier("notasfinalesRepository")
	public NotasfinalesRepository notasfinalesRepository;

	public Optional<Notasfinales> getNotasfinalesById(Integer id) {
		return notasfinalesRepository.findById(id);
	}

	public List<Notasfinales> getNotasfinalesAll() {
		return notasfinalesRepository.findAll();
	}

	public Notasfinales addNotasfinales(Notasfinales notasfinales) {
		return notasfinalesRepository.saveAndFlush(notasfinales);
	}

	public Notasfinales editNotasfinales(Notasfinales notasfinales) {
		return notasfinalesRepository.saveAndFlush(notasfinales);
	}

	public void deleteNotasfinales(Integer id) {
		notasfinalesRepository.deleteById(id);
	}
}
