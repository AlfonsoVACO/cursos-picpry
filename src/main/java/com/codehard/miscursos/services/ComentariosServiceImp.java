package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Comentarios;
import com.codehard.miscursos.repositories.ComentariosReporitory;

@Service("servicioComentarios")
public class ComentariosServiceImp {
	@Autowired
	@Qualifier("comentariosRepository")
	public ComentariosReporitory comentariosRepository;

	public Optional<Comentarios> getComentariosById(Integer id) {
		return comentariosRepository.findById(id);
	}

	public List<Comentarios> getComentariosAll() {
		return comentariosRepository.findAll();
	}

	public Comentarios addComentarios(Comentarios comentarios) {
		return comentariosRepository.saveAndFlush(comentarios);
	}

	public Comentarios editComentarios(Comentarios comentarios) {
		return comentariosRepository.saveAndFlush(comentarios);
	}

	public void deleteComentarios(Integer id) {
		comentariosRepository.deleteById(id);
	}
}
