package com.codehard.miscursos.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.codehard.miscursos.modelos.Alumno;
import com.codehard.miscursos.modelos.Estados;
import com.codehard.miscursos.modelos.Municipios;
import com.codehard.miscursos.modelos.Questions;
import com.codehard.miscursos.modelos.Quiz;
import com.codehard.miscursos.modelos.Registroquiz;
import com.codehard.miscursos.modelos.Roles;
import com.codehard.miscursos.services.AlumnoServiceImp;
import com.codehard.miscursos.services.EstadosServiceImp;
import com.codehard.miscursos.services.MunicipiosServiceImp;
import com.codehard.miscursos.services.PlantelServiceImp;
import com.codehard.miscursos.services.QuestionsServiceImp;
import com.codehard.miscursos.services.QuizServiceImp;
import com.codehard.miscursos.services.RegistroquizServiceImp;
import com.codehard.miscursos.services.RolesServiceImp;
import com.codehard.miscursos.utils.ExamplesClass;
import com.codehard.miscursos.utils.MapToClass;

@Controller
@RequestMapping(path = "/")
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
	
	@Autowired
	@Qualifier("servicioRegistroquiz")
	private RegistroquizServiceImp servicioRegistroquiz;
	
	@Autowired
	@Qualifier("servicioAlumno")
	private AlumnoServiceImp servicioAlumno;
	
	@Autowired
	@Qualifier("servicioQuiz")
	private QuizServiceImp servicioQuiz;
	
	@Autowired
	@Qualifier("servicioQuestions")
	private QuestionsServiceImp servicioQuestions;

	@GetMapping("/")
	public String index(Model model) {
		return "alumno/index";
	}

	@GetMapping("/quiz/realize")
	public String quiz(Model model) {
		return "alumno/quiz";
	}

	@GetMapping("/login")
	public String getLogin(Model model) {
		model.addAttribute("lstplanteles", plantelServiceImp.getPlantelAll());
		return "alumno/login";
	}

	@RequestMapping(value = "/register/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Alumno setRegister(@RequestParam(defaultValue = "0") Map<String, Object> lstproduct)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {

		MapToClass<Alumno> objAlumno = new MapToClass<>(new Alumno());
		objAlumno.setConfiguration(lstproduct, "com.codehard.miscursos.modelos");
		Alumno alumno = objAlumno.getClassMap();
		Map<Object, Object[]> claves = objAlumno.getTogas();

		ExamplesClass<Estados> examplesEstados = new ExamplesClass<>(new Estados(),
				new Object[] { "nombre", claves.get("Estados")[1] });
		ExamplesClass<Municipios> examplesMunicip = new ExamplesClass<>(new Municipios(),
				new Object[] { "nombre", claves.get("Municipios")[1] });

		Estados estado = estadosServiceImp.getEstdoByCriteria(examplesEstados.getExample());
		Municipios municipio = municipiosServiceImp.getMunicipioByCriteria(examplesMunicip.getExample());

		Estados nuevoestado = estado.getIdestado() == null
				? estadosServiceImp.addEstados(new Estados(claves.get("Estados")[1].toString()))
				: estado;
		Municipios nuevomunici = municipio.getIdmunicipio() == null
				? municipiosServiceImp.addMunicipios(new Municipios(claves.get("Municipios")[1].toString()))
				: municipio;

		Roles rol = rolesServiceImp.getRolesById(4).get();
		System.out.println(alumno);
		// System.out.println(plantel);

		System.out.println(nuevoestado);
		System.out.println(nuevomunici);
		System.out.println(rol);

		// alumno.setIdplantel( plantel );

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
	public String getDetallesPago(@RequestParam(defaultValue = "0") Map<String, String> lstproduct, Model model) {
		List<Integer> lstIdes = new ArrayList<>();
		lstproduct.forEach((k, v) -> lstIdes.add(Integer.valueOf(v)));
		model.addAttribute("listaIdes", lstIdes);
		return "alumno/detalles-pago";
	}

	private Model getSession(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
			userDetails = (UserDetails) principal;
		}
		String userName = userDetails.getUsername();
		model.addAttribute("user", userName);
		model.addAttribute("auto", userDetails.getAuthorities());
		return model;
	}

	@RequestMapping(value = "/quizquest/edit/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Registroquiz setQuizquest(@RequestParam(defaultValue = "0") Map<String, Object> lstproduct, @PathVariable(name = "id") int id) {
		Optional<Registroquiz> registroquiz = servicioRegistroquiz.getRegistroquizById(id);
		if(registroquiz.isPresent()) return new Registroquiz();
		if(registroquiz.get().getRespuestas() != null) return new Registroquiz();
		
		Registroquiz registro = registroquiz.get();
		List<Questions> questionsMap = new ArrayList<>();
		String respuestas = (String) lstproduct.get("respuestas");
		String[] pregres = respuestas.split(":");
		for(String item: pregres) {
			String[] idpregresp = item.split(",");
			int idres = Integer.parseInt( idpregresp[0] );
			questionsMap.add( servicioQuestions.getQuestionsById(idres).get() );
		}
		double porcent = Double.parseDouble( lstproduct.get("porcent").toString() );
		double[] califpor = getCalificacion(questionsMap, respuestas, porcent);
		
		registro.setPorcent(califpor[1]);
		registro.setCalificacion(califpor[0]);
		registro.setCountquest(questionsMap.size());
		registro.setRespuestas(respuestas);
		registro.setTimer(new Date());
		
		return servicioRegistroquiz.editRegistroquiz(registro);
	}
	
	@RequestMapping(value = "/quizquest/add/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Registroquiz setQuizquest( @PathVariable(name = "id") int id) 
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		
		Optional<Quiz> quiz  = servicioQuiz.getQuizById(id);
		if(!quiz.isPresent()) new Registroquiz();
		
		Registroquiz registro = new Registroquiz();
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
			userDetails = (UserDetails) principal;
		}		
		ExamplesClass<Alumno> examplesAlumno = new ExamplesClass<>(new Alumno(), new Object[] { "correo", userDetails.getUsername() });
		Alumno alumno = servicioAlumno.getAlumnoByCriteria( examplesAlumno.getExample() );
		
		registro.setIdalumno(alumno);
		Date fecha = new Date();
		registro.setFechaini(fecha);
		registro.setFechafin(getMinusCalendar(fecha, quiz.get() ) );
		registro.setIdquiz(quiz.get());
		
		return servicioRegistroquiz.addRegistroquiz(registro);
	}
	
	@SuppressWarnings("deprecation")
	private Date getMinusCalendar(Date fechaini, Quiz quiz) {
		Calendar calendar = Calendar.getInstance();
		Date fechaTime = quiz.getOntimer();
		calendar.setTime(fechaini);
		calendar.add(Calendar.HOUR, fechaTime.getHours());
		calendar.add(Calendar.MINUTE, fechaTime.getMinutes());
		calendar.add(Calendar.SECOND, fechaTime.getSeconds());
		return calendar.getTime();
	}
	
	private double total = 0;
	private int i = 0;
	
	private double[] getCalificacion( List<Questions> objlquiz, String respuestas, double unidad){
		i = 0;
		total = 0;
		String[] quest = respuestas.split(":");
		objlquiz.forEach( v -> {
			String[] questresp = quest[i].split(",");
			String[] onlyresp = questresp.length > 0 ? questresp[1].split("-") : questresp;
			
			String[] answers = v.getAnswers().split(",");
			double unidadres = unidad / answers.length;
			for(String item: answers) {
				boolean respans = false;
				for(String itemresp: onlyresp)
					if( item.equals( itemresp ) ) respans = true;
				if(respans) total += unidadres;
			}
			i++;
		});
		
		return new double[]{total * 10, total * 100};
	}
	
}
