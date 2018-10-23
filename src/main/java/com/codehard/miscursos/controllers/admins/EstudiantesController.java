package com.codehard.miscursos.controllers.admins;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codehard.miscursos.modelos.Alumno;

@Controller
@RequestMapping( path="/admin/estudiantes")
public class EstudiantesController {
	
	@GetMapping("/")
	public String getEstudiantesAdmin(@RequestParam(value="_", required=false) String clave, Model model) {
        return "administrador/componentes/estudiantes/index";
    }
	
	@GetMapping("/edit/{id}")
    public String getEstudianteAdmin(
    		@RequestParam(value="_", required=false) String clave, 
    		@PathVariable(name = "id") int id, Model model) {
	    Alumno alumno = new Alumno();
	    model.addAttribute("alumno", alumno);
        return "administrador/componentes/estudiantes/detalles";
    }
}
