package com.codehard.miscursos.controllers.admins;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codehard.miscursos.modelos.Administrador;

@Controller
@RequestMapping( path="/admin")
public class AdministradorController {
	
	@GetMapping("/")
    public String getAdmin(Model model) {
        return "administrador/index";
    }
	
	@GetMapping("/perfil")
	public String getPerfilAdmin(@RequestParam(value="_", required=false) String clave, Model model) {
        return "administrador/componentes/perfil/index";
    }
	
	@GetMapping("/config")
	public String getConfigAdmin(@RequestParam(value="_", required=false) String clave, Model model) {
        return "administrador/componentes/config/index";
    }
	
	@GetMapping("/crud/{id}")
    public String getCursoAdmin(
    		@RequestParam(value="_", required=false) String clave, 
    		@PathVariable(name = "id") int id, Model model) {
        return "administrador/componentes/admins/crud";
    }
	
	@PostMapping("/crud")
	public String postCursoAdmin(@ModelAttribute("administrador") Administrador administrador) {
		System.out.println(administrador.toString());
		return "redirect: /admin/index";
	}
}
