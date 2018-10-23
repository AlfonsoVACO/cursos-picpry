package com.codehard.miscursos.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codehard.miscursos.modelos.Alumno;
import com.codehard.miscursos.repositories.PlantelReporitory;
import com.codehard.miscursos.services.PlantelServiceImp;
import com.codehard.miscursos.utils.MapToClass;

@Controller
@RequestMapping( path="/")
public class PrincipalController {
	
	@Autowired
	@Qualifier("servicioPlantel")
	public PlantelServiceImp plantelServiceImp;
	
	@GetMapping("/")
    public String index(Model model) {
        return "alumno/index";
    }
	
	@GetMapping("/login")
    public String getLogin(Model model) {
		model.addAttribute("lstplanteles", plantelServiceImp.getPlantelAll() );
        return "alumno/login";
    }
	
	@RequestMapping(value = "/register/add", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Alumno setRegister(@RequestParam(defaultValue="0") Map<String,Object> lstproduct) {		
		System.out.println(plantelServiceImp.getPlantelById(1).get());
		MapToClass<Alumno> objAlumno = new MapToClass<>(new Alumno());
		objAlumno.setConfiguration( lstproduct, "com.codehard.miscursos.modelos" );
		
		System.out.println(objAlumno.getClassMap().toString());
		
        return new Alumno();
    }
	
	@GetMapping("/access-denied")
    public String getAccessDenied(Model model) {
		model = getSession(model);
        return "alumno/access-denied";
    }
	
	@GetMapping("/contacto")
    public String getContacto(Model model) {
        return "alumno/contacto";
    }
	
	@GetMapping("/nosotros")
    public String getNosotros(Model model) {
        return "alumno/nosotros";
    }
	
	@GetMapping("/curso")
    public String getItemCurso(Model model) {
        return "alumno/item-curso";
    }
	
	@GetMapping("/cursos")
    public String getCursos(Model model) {
        return "alumno/cursos";
    }
	
	@GetMapping("/detalles")
    public String getDetallesPago(@RequestParam(defaultValue="0") Map<String,String> lstproduct, Model model) {
		List<Integer> lstIdes = new ArrayList<>();
		lstproduct.forEach((k,v)-> lstIdes.add( Integer.valueOf(v) ) );
		model.addAttribute("listaIdes", lstIdes);
        return "alumno/detalles-pago";
    }
	
	@GetMapping("/mis-cursos")
    public String getMisCursos(Model model) {
        return "alumno/mis-cursos";
    }
	
	@GetMapping("/mis-pagos")
    public String getMisPagos(Model model) {
        return "alumno/mis-pagos";
    }
	
	@GetMapping("/perfil")
    public String getPerfil(Model model) {
        return "alumno/perfil";
    }
	
	private Model getSession(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
		  userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
		model.addAttribute("user", userName);
		model.addAttribute("auto", userDetails.getAuthorities() );
		return model;
	}
}
