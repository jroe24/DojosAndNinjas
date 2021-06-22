package com.jacobroe.DojosAndNinjas.controllers;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.jacobroe.DojosAndNinjas.models.Ninja;
import com.jacobroe.DojosAndNinjas.services.DojoAndNinjaServices;

@Controller
public class NinjaController {
private final DojoAndNinjaServices dojoAndNinjaServices;
	
	public NinjaController(DojoAndNinjaServices dojoAndNinjaServices) {
		this.dojoAndNinjaServices = dojoAndNinjaServices;
	}

	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja Ninja, Model model) {
		model.addAttribute("dojos", dojoAndNinjaServices.getAllDojos());
		return "jsp/newNinja.jsp";
	}
	
	@PostMapping("/add/ninja")
	public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "jsp/newNinja.jsp";
		}
		else {
			dojoAndNinjaServices.addNinja(ninja);
			return "redirect:/dojos/" + ninja.getDojo().getId() ;
		}
	}
	

}