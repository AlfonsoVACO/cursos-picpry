package com.codehard.miscursos.controllers.alumno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codehard.miscursos.modelos.Alumno;
import com.codehard.miscursos.services.AlumnoServiceImp;
import com.codehard.miscursos.utils.ExamplesClass;

@Controller
@RequestMapping(path = "/me")
public class AlumnoController {
	
	@Autowired
	@Qualifier("servicioAlumno")
	private AlumnoServiceImp servicioAlumno;
	
	@GetMapping("/mis-cursos")
	public String getMisCursos(Model model) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Alumno alumno = getAlumno();
		model.addAttribute("alumnolog", alumno);
		return "alumno/mis-cursos";
	}

	@GetMapping("/mis-pagos")
	public String getMisPagos(Model model) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Alumno alumno = getAlumno();
		model.addAttribute("alumnolog", alumno);
		return "alumno/mis-pagos";
	}

	@GetMapping("/perfil")
	public String getPerfil(Model model) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Alumno alumno = getAlumno();
		model.addAttribute("alumnolog", alumno);
		return "alumno/perfil";
	}
	
	private Alumno getAlumno() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails)
		  userDetails = (UserDetails) principal;
		ExamplesClass<Alumno> examplesAlumno = new ExamplesClass<>(new Alumno(), new Object[] { "correo", userDetails.getUsername() });
		Alumno alumno = servicioAlumno.getAlumnoByCriteria( examplesAlumno.getExample() );
		return alumno.getIdalumno() != null ? alumno : new Alumno();
	}
}
