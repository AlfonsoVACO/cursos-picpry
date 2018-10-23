package com.codehard.miscursos.controllers.admins;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping( path="/admin/pagos")
public class PagosController {
	
	@GetMapping("/")
	public String getPagosAdmin(@RequestParam(value="_", required=false) String clave, Model model) {
        return "administrador/componentes/pagos/index";
    }
}
