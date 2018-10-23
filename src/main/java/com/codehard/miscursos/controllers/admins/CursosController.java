package com.codehard.miscursos.controllers.admins;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping( path="/admin/cursos")
public class CursosController {
	
	@GetMapping("/")
	public String getCursosAdmin(@RequestParam(value="_", required=false) String clave, Model model) {
        return "administrador/componentes/cursos/index";
    }
	
	@GetMapping("/edit/{id}")
	public String getCursosAdmin( @RequestParam(value="_", required=false) String clave, @PathVariable(name = "id") int id, Model model) {
        return "administrador/componentes/cursos/crud";
    }
}
