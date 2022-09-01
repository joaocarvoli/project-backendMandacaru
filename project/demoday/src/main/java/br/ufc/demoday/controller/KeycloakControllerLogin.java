package br.ufc.demoday.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class KeycloakControllerLogin {

   @RequestMapping("/api")
   public ModelAndView index() {
       ModelAndView modelAndView = new ModelAndView();
       modelAndView.setViewName("index");
       return modelAndView;
	 }
}
