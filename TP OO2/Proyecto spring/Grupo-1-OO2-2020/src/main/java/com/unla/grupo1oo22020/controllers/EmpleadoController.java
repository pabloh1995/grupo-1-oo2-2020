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
import com.unla.grupo1oo22020.models.EmpleadoModel;
import com.unla.grupo1oo22020.services.IEmpleadoService;

@Controller
@RequestMapping("/empleado")

public class EmpleadoController {
	@Autowired
	@Qualifier("empleadoService")
	private IEmpleadoService empleadoService;
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.EMPLEADO_INDEX);
		mAV.addObject("empleados", empleadoService.getAll());
		return mAV;
	}
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.EMPLEADO_NEW);
		mAV.addObject("empleados", new EmpleadoModel());
		return mAV;
	}
	
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("empleados") EmpleadoModel empleadoModel) {
		empleadoService.insertOrUpdate(empleadoModel);
		return new RedirectView(ViewRouteHelpers.EMPLEADO_ROOT);
	}
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") long idPersona) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.EMPLEADO_UPDATE);
		mAV.addObject("empleado", empleadoService.findById(idPersona));
		return mAV;
	}
	
/*	@GetMapping("/by_name/{name}") //VER METODO Y REVISAR
	public ModelAndView getByName(@PathVariable("name") String name) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERSON_UPDATE);
		mAV.addObject("person", personService.findByName(name));
		return mAV;
	} */
		
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("empleado") EmpleadoModel empleadoModel) {
		empleadoService.insertOrUpdate(empleadoModel);
		return new RedirectView(ViewRouteHelpers.EMPLEADO_ROOT);
	}
	
	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") long idPersona) {
		empleadoService.remove(idPersona);
		return new RedirectView(ViewRouteHelpers.EMPLEADO_ROOT);
	}
}