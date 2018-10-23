package com.codehard.miscursos.controllers.profesores;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping( path="/profes")
public class ProfesorController {
	
	@GetMapping("/")
    public String getAdmin(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
		  userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
		model.addAttribute("user", userName);
		model.addAttribute("auto", userDetails.getAuthorities() );
        return "profesor/index";
    }
}
