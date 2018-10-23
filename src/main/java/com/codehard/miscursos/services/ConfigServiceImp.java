package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Config;
import com.codehard.miscursos.repositories.ConfigReporitory;

@Service("servicioConfig")
public class ConfigServiceImp {
	@Autowired
	@Qualifier("configRepository")
	public ConfigReporitory configRepository;

	public Optional<Config> getConfigById(Integer id) {
		return configRepository.findById(id);
	}

	public List<Config> getConfigAll() {
		return configRepository.findAll();
	}

	public Config addConfig(Config config) {
		return configRepository.saveAndFlush(config);
	}

	public Config editConfig(Config config) {
		return configRepository.saveAndFlush(config);
	}

	public void deleteConfig(Integer id) {
		configRepository.deleteById(id);
	}
}
