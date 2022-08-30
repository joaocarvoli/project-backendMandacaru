package br.ufc.demoday.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


//@RestController
//@RequestMapping(path = "/")

@Controller
public class KeycloakControllerLogin {


		//@Autowired
		//KeyCloakController service;

   @GetMapping(path = "/")
   public String index() {
	   return "index";
	 }

   @GetMapping(path = "/api")
   public String secure(Model model) {
	 model.addAttribute("message", "Está em uma pagina segura!");
	 	return "secure";
   }
		
		
}