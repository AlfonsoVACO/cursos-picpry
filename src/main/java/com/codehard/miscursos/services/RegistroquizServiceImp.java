package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Registroquiz;
import com.codehard.miscursos.repositories.RegistroquizRepository;

@Service("servicioRegistroquiz")
public class RegistroquizServiceImp {

	@Autowired
	@Qualifier("registroquizRepository")
	private RegistroquizRepository registroquizRepository;
	
	public Optional<Registroquiz> getRegistroquizById(Integer id) {
		return registroquizRepository.findById(id);
	}

	public List<Registroquiz> getRegistroquizAll() {
		return registroquizRepository.findAll();
	}

	public Registroquiz addRegistroquiz(Registroquiz registroquiz) {
		return registroquizRepository.saveAndFlush(registroquiz);
	}

	public Registroquiz editRegistroquiz(Registroquiz registroquiz) {
		return registroquizRepository.saveAndFlush(registroquiz);
	}

	public void deleteRegistroquiz(Integer id) {
		registroquizRepository.deleteById(id);
	}
	
	public Registroquiz getRegistroquizByCriteria(Example<Registroquiz> example) {
		Optional<Registroquiz> isNull = registroquizRepository.findOne(example);
		return isNull.isPresent() ? isNull.get() : new Registroquiz();
	}
}
