package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Plantel;
import com.codehard.miscursos.repositories.PlantelReporitory;

@Service("servicioPlantel")
public class PlantelServiceImp {
	@Autowired
	@Qualifier("plantelRepository")
	public PlantelReporitory plantelRepository;

	public Optional<Plantel> getPlantelById(Integer id) {
		return plantelRepository.findById(id);
	}

	public List<Plantel> getPlantelAll() {
		return plantelRepository.findAll();
	}

	public Plantel addPlantel(Plantel plantel) {
		return plantelRepository.saveAndFlush(plantel);
	}

	public Plantel editPlantel(Plantel plantel) {
		return plantelRepository.saveAndFlush(plantel);
	}

	public void deletePlantel(Integer id) {
		plantelRepository.deleteById(id);
	}
}
