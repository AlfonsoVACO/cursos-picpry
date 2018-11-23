package com.codehard.miscursos.controllers.profesores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codehard.miscursos.modelos.Profesor;
import com.codehard.miscursos.services.ProfesorServiceImp;
import com.codehard.miscursos.utils.ExamplesClass;

@Controller
@RequestMapping( path="/profes")
public class ProfesorController {
	
	@Autowired
	@Qualifier("servicioProfesor")
	private ProfesorServiceImp servicioProfesor;
	
	@GetMapping("/")
    public String getAdmin(Model model) {
		UserDetails userDetails = getAuthorities();
		model.addAttribute("user", userDetails.getUsername() );
		model.addAttribute("auto", userDetails.getAuthorities() );
        return "profesor/index";
    }
	
	@GetMapping("/quiz")
	public String getQuiz(Model model) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Profesor profesor = getProfesor();
		model.addAttribute("profesor", profesor);
		model.addAttribute("grupos", profesor.getGrupoprofeList());
		return "profesor/componentes/quiz/index";
	}
	
	@GetMapping("/quiz/create")
	public String getQuizCreate(Model model) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Profesor profesor = getProfesor();
		model.addAttribute("profesor", profesor);
		return "profesor/componentes/quiz/crud";
	}
	
	private Profesor getProfesor() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails)
		  userDetails = (UserDetails) principal;
		
		ExamplesClass<Profesor> examplesProfesor = new ExamplesClass<>(new Profesor(), new Object[] { "correo", userDetails.getUsername() });
		Profesor profesor = servicioProfesor.getProfesorByCriteria( examplesProfesor.getExample() );
		
		return profesor.getIdprofesor() != null ? profesor : new Profesor();
	}
	
	private UserDetails getAuthorities() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails)
		  userDetails = (UserDetails) principal;
		return userDetails;
	}
}
