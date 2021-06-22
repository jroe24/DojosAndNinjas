package com.jacobroe.DojosAndNinjas.controllers;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.jacobroe.DojosAndNinjas.models.Dojo;
import com.jacobroe.DojosAndNinjas.services.DojoAndNinjaServices;



@Controller
public class DojoController {
	
private final DojoAndNinjaServices dojoAndNinjaServices;
	
	public DojoController(DojoAndNinjaServices dojoAndNinjaServices) {
		this.dojoAndNinjaServices = dojoAndNinjaServices;
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "jsp/newDojo.jsp";
	}
	
	@PostMapping("/add/dojo")
	public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "jsp/newDojo.jsp";
		}
		else {
			dojoAndNinjaServices.addDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}
	
	@GetMapping("/dojos/{dojoId}")
	public String showDojo(@PathVariable("dojoId") long id, Model model) {
		Dojo dojo = dojoAndNinjaServices.singleDojo(id);
		model.addAttribute("dojo", dojo);
		return "jsp/show.jsp";
	}

}