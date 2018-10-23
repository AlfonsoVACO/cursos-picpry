package com.codehard.miscursos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codehard.miscursos.modelos.Contacto;
import com.codehard.miscursos.repositories.ContactoReporitory;

@Service("servicioContacto")
public class ContactoServiceImp {
	@Autowired
	@Qualifier("contactoRepository")
	public ContactoReporitory contactoRepository;

	public Optional<Contacto> getContactoById(Integer id) {
		return contactoRepository.findById(id);
	}

	public List<Contacto> getContactoAll() {
		return contactoRepository.findAll();
	}

	public Contacto addContacto(Contacto contacto) {
		return contactoRepository.saveAndFlush(contacto);
	}

	public Contacto editContacto(Contacto contacto) {
		return contactoRepository.saveAndFlush(contacto);
	}

	public void deleteContacto(Integer id) {
		contactoRepository.deleteById(id);
	}
}
