package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Grupoprofe;
import com.codehard.miscursos.repositories.GrupoprofeRepository;

@Service("servicioGrupoprofe")
public class GrupoprofeServiceImp {
	@Autowired
	@Qualifier("grupoprofeRepository")
	public GrupoprofeRepository grupoprofeRepository;

	public Optional<Grupoprofe> getGrupoprofeById(Integer id) {
		return grupoprofeRepository.findById(id);
	}

	public List<Grupoprofe> getGrupoprofeAll() {
		return grupoprofeRepository.findAll();
	}

	public Grupoprofe addGrupoprofe(Grupoprofe grupoprofe) {
		return grupoprofeRepository.saveAndFlush(grupoprofe);
	}

	public Grupoprofe editGrupoprofe(Grupoprofe grupoprofe) {
		return grupoprofeRepository.saveAndFlush(grupoprofe);
	}

	public void deleteGrupoprofe(Integer id) {
		grupoprofeRepository.deleteById(id);
	}
}
