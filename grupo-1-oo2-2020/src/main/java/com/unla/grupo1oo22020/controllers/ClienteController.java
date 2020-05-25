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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo1oo22020.entities.Cliente;
import com.unla.grupo1oo22020.entities.Empleado;
import com.unla.grupo1oo22020.helpers.ViewRouteHelpers;
import com.unla.grupo1oo22020.models.ClienteModel;
import com.unla.grupo1oo22020.models.EmpleadoModel;
import com.unla.grupo1oo22020.services.IClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	@Qualifier("clienteService")
	private IClienteService clienteService;
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.CLIENTE_INDEX);
		mAV.addObject("cliente", clienteService.getAll());
		return mAV;
	}
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.CLIENTE_NEW);
		mAV.addObject("cliente", new ClienteModel());
		return mAV;
	}
	
	
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("cliente") ClienteModel clienteModel, RedirectAttributes redirectAttrs) {
		int i=0;
		boolean encontrado = false;
		
		while(i<clienteService.getAll().size() && !encontrado){
			Cliente c = clienteService.getAll().get(i);
				if(c.getDni() == clienteModel.getDni()){
					encontrado = true;
				}
			i++;
		}
		if(!encontrado){
			clienteService.insertOrUpdate(clienteModel);
			redirectAttrs
				.addFlashAttribute("mensaje","Agregado Correctamente")
				.addFlashAttribute("clase", "success");
		}else{
			redirectAttrs
				.addFlashAttribute("mensaje","No se pudo agregar, ya existe un cliente con ese DNI")
				.addFlashAttribute("clase", "warning");
		}
		return new RedirectView(ViewRouteHelpers.CLIENTE_ROOT);
	}
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") long idPersona) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.CLIENTE_UPDATE);
		mAV.addObject("cliente", clienteService.findByIdPersona(idPersona));
		return mAV;
	}
	
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("cliente") ClienteModel clienteModel) {
		clienteService.insertOrUpdate(clienteModel);
		return new RedirectView(ViewRouteHelpers.CLIENTE_ROOT);
	}
	
	/*@PostMapping("/update")
	public RedirectView update(@ModelAttribute("cliente") ClienteModel clienteModel, RedirectAttributes redirectAttrs) {
		int i=0;
		boolean encontrado = false;
		
		while(i<clienteService.getAll().size() && !encontrado){
			Cliente e = clienteService.getAll().get(i);
				if(e.getDni() == clienteModel.getDni()){
					encontrado = true;
				}
			i++;
		}
		if(!encontrado){
			clienteService.insertOrUpdate(clienteModel);
			redirectAttrs
				.addFlashAttribute("mensaje","Agregado Correctamente")
				.addFlashAttribute("clase", "success");
		}else{
			redirectAttrs
				.addFlashAttribute("mensaje","No se pudo modificar, ya existe un cliente con ese DNI")
				.addFlashAttribute("clase", "warning");
		}
		return new RedirectView(ViewRouteHelpers.CLIENTE_ROOT);
	}*/
	
	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") long idPersona) {
		clienteService.remove(idPersona);
		return new RedirectView(ViewRouteHelpers.CLIENTE_ROOT);
	}
	
	@PostMapping("/back")
	public RedirectView back() {
		
		return new RedirectView(ViewRouteHelpers.CLIENTE_ROOT);
	}
}