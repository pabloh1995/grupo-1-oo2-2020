package com.unla.grupo1oo22020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo1oo22020.helpers.ViewRouteHelpers;
import com.unla.grupo1oo22020.models.PersonaModel;
import com.unla.grupo1oo22020.services.IPersonaService;


@Controller
@RequestMapping("/person")
public class PersonaController {

	@Autowired
	@Qualifier("personaService")
	private IPersonaService personaService;
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.PERSONA_INDEX);
		mAV.addObject("persona", personaService.getAll());
		return mAV;
	}
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.PERSONA_NEW);
		mAV.addObject("persona", new PersonaModel());
		return mAV;
	}
	
	
	
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("persona") PersonaModel personaModel) {
		personaService.insertOrUpdate(personaModel);
		return new RedirectView(ViewRouteHelpers.PERSONA_ROOT);
	}
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") long idPersona) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.PERSONA_UPDATE);
		mAV.addObject("persona", personaService.findByIdPersona(idPersona));
		return mAV;
	}
	
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("persona") PersonaModel personaModel) {
		personaService.insertOrUpdate(personaModel);
		return new RedirectView(ViewRouteHelpers.PERSONA_ROOT);
	}
	
	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") long idPersona) {
		personaService.remove(idPersona);
		return new RedirectView(ViewRouteHelpers.PERSONA_ROOT);
	}
}
