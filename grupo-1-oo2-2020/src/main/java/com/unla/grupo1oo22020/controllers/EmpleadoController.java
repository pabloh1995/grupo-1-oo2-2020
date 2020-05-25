package com.unla.grupo1oo22020.controllers;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo1oo22020.entities.Empleado;
import com.unla.grupo1oo22020.helpers.ViewRouteHelpers;
import com.unla.grupo1oo22020.models.EmpleadoModel;
import com.unla.grupo1oo22020.services.IEmpleadoService;
import com.unla.grupo1oo22020.services.ILocalService;

@Controller
@RequestMapping("/empleado")

public class EmpleadoController {
	@Autowired
	@Qualifier("empleadoService")
	private IEmpleadoService empleadoService;
	
	@Autowired
	@Qualifier("localService")
	private ILocalService localService;
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.EMPLEADO_INDEX);
		mAV.addObject("empleado", empleadoService.getAll());
		return mAV;
	}
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.EMPLEADO_NEW);
		mAV.addObject("empleado", new EmpleadoModel());
		mAV.addObject("locales", localService.getAll());
		return mAV;
	}
	
	
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("empleado") EmpleadoModel empleadoModel, RedirectAttributes redirectAttrs) {
		int i=0;
		boolean encontrado = false;
		
		while(i<empleadoService.getAll().size() && !encontrado){
			Empleado e = empleadoService.getAll().get(i);
				if(e.getDni() == empleadoModel.getDni()){
					encontrado = true;
				}
			i++;
		}
		if(!encontrado){
			empleadoService.insertOrUpdate(empleadoModel);
			redirectAttrs
				.addFlashAttribute("mensaje","Agregado Correctamente")
				.addFlashAttribute("clase", "success");
		}else{
			redirectAttrs
				.addFlashAttribute("mensaje","No se pudo agregar, ya existe un empleado con ese DNI")
				.addFlashAttribute("clase", "warning");
		}
		return new RedirectView(ViewRouteHelpers.EMPLEADO_ROOT);
	}

	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") long idPersona) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.EMPLEADO_UPDATE);
		mAV.addObject("empleado", empleadoService.findByIdPersona(idPersona));
		return mAV;
	}
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("empleado") EmpleadoModel empleadoModel) {
		empleadoService.insertOrUpdate(empleadoModel);
		return new RedirectView(ViewRouteHelpers.EMPLEADO_ROOT);
	}

	/*@PostMapping("/update")
	public RedirectView update(@ModelAttribute("empleado") EmpleadoModel empleadoModel, RedirectAttributes redirectAttrs) {
		int i=0;
		boolean encontrado = false;
		
		while(i<empleadoService.getAll().size() && !encontrado){
			Empleado e = empleadoService.getAll().get(i);
				if(e.getDni() == empleadoModel.getDni()){
					encontrado = true;
				}
			i++;
		}
		if(!encontrado){
			empleadoService.insertOrUpdate(empleadoModel);
			redirectAttrs
				.addFlashAttribute("mensaje","Agregado Correctamente")
				.addFlashAttribute("clase", "success");
		}else{
			redirectAttrs
				.addFlashAttribute("mensaje","No se pudo modificar, ya existe un empleado con ese DNI")
				.addFlashAttribute("clase", "warning");
		}
		return new RedirectView(ViewRouteHelpers.EMPLEADO_ROOT);
	}*/
	
	
	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") long idPersona) {
		empleadoService.remove(idPersona);
		return new RedirectView(ViewRouteHelpers.EMPLEADO_ROOT);
	}
	
	@PostMapping("/back")
	public RedirectView back() {
		
		return new RedirectView(ViewRouteHelpers.EMPLEADO_ROOT);
	}
}