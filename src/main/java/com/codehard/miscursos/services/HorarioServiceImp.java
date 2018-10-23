package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Horario;
import com.codehard.miscursos.repositories.HorarioReporitory;

@Service("servicioHorario")
public class HorarioServiceImp {
	@Autowired
	@Qualifier("horarioRepository")
	public HorarioReporitory horarioRepository;

	public Optional<Horario> getHorarioById(Integer id) {
		return horarioRepository.findById(id);
	}

	public List<Horario> getHorarioAll() {
		return horarioRepository.findAll();
	}

	public Horario addHorario(Horario horario) {
		return horarioRepository.saveAndFlush(horario);
	}

	public Horario editHorario(Horario horario) {
		return horarioRepository.saveAndFlush(horario);
	}

	public void deleteHorario(Integer id) {
		horarioRepository.deleteById(id);
	}
}
