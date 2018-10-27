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
import com.codehard.miscursos.modelos.Estados;
import com.codehard.miscursos.modelos.Municipios;
import com.codehard.miscursos.modelos.Roles;
import com.codehard.miscursos.services.EstadosServiceImp;
import com.codehard.miscursos.services.MunicipiosServiceImp;
import com.codehard.miscursos.services.PlantelServiceImp;
import com.codehard.miscursos.services.RolesServiceImp;
import com.codehard.miscursos.utils.ExamplesClass;
import com.codehard.miscursos.utils.MapToClass;

@Controller
@RequestMapping( path="/")
public class PrincipalController {
	
	@Autowired
	@Qualifier("servicioPlantel")
	public PlantelServiceImp plantelServiceImp;
	
	@Autowired
	@Qualifier("servicioEstados")
	public EstadosServiceImp estadosServiceImp;
	
	@Autowired
	@Qualifier("servicioMunicipios")
	public MunicipiosServiceImp municipiosServiceImp;
	
	@Autowired
	@Qualifier("servicioRoles")
	public RolesServiceImp rolesServiceImp;
	
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
	public Alumno setRegister(@RequestParam(defaultValue="0") Map<String,Object> lstproduct) 
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		
		MapToClass<Alumno> objAlumno = new MapToClass<>(new Alumno());
		objAlumno.setConfiguration( lstproduct, "com.codehard.miscursos.modelos" );		
		Alumno alumno = objAlumno.getClassMap();
		Map< Object, Object[] > claves = objAlumno.getTogas();
		
		ExamplesClass<Estados> examplesEstados = new ExamplesClass<>(new Estados(), 
				new Object[] {"nombre", claves.get("Estados")[1] });
		ExamplesClass<Municipios> examplesMunicip = new ExamplesClass<>(new Municipios(), 
				new Object[] {"nombre", claves.get("Municipios")[1] });
		
		Estados estado = estadosServiceImp.getEstdoByCriteria(examplesEstados.getExample());
		Municipios municipio = municipiosServiceImp.getMunicipioByCriteria(examplesMunicip.getExample());
		
		Estados nuevoestado = estado.getIdestado() == null ? estadosServiceImp.addEstados( new Estados( claves.get("Estados")[1].toString() ) ) : estado;
		Municipios nuevomunici =municipio.getIdmunicipio() == null ? municipiosServiceImp.addMunicipios( new Municipios( claves.get("Municipios")[1].toString() ) ) : municipio;
		
		Roles rol = rolesServiceImp.getRolesById(4).get();
		System.out.println(alumno);
		//System.out.println(plantel);
		
		System.out.println(nuevoestado);
		System.out.println(nuevomunici);
		System.out.println(rol);
		
		//alumno.setIdplantel( plantel );
		
        return alumno;
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
