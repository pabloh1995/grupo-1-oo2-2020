package com.unla.grupo1oo22020.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
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

	@PreAuthorize("hasRole( 'ROLE_ADMIN' )" + " || hasRole('ROLE_GERENTE')")
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.EMPLEADO_NEW);
		mAV.addObject("empleado", new EmpleadoModel());
		mAV.addObject("locales", localService.getAlls());
		return mAV;
	}

	@PreAuthorize("hasRole( 'ROLE_ADMIN' )" + " || hasRole('ROLE_GERENTE')")
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("empleado") EmpleadoModel empleadoModel) {
		empleadoService.insert(empleadoModel);
		return new RedirectView(ViewRouteHelpers.EMPLEADO_ROOT);
	}

	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") long idPersona) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.EMPLEADO_UPDATE);
		mAV.addObject("empleado", empleadoService.findByIdPersona(idPersona));
		mAV.addObject("locales", localService.getAlls());
		return mAV;
	}

	@PreAuthorize("hasRole( 'ROLE_ADMIN' )" + " || hasRole('ROLE_GERENTE')")
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("empleado") EmpleadoModel empleadoModel) {
		empleadoService.update(empleadoModel);
		return new RedirectView(ViewRouteHelpers.EMPLEADO_ROOT);
	}

	@PreAuthorize("hasRole( 'ROLE_ADMIN' )" + " || hasRole('ROLE_GERENTE')")
	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") long idPersona) {
		empleadoService.remove(idPersona);
		return new RedirectView(ViewRouteHelpers.EMPLEADO_ROOT);
	}

	@PostMapping("/back")
	public RedirectView back() {
		return new RedirectView(ViewRouteHelpers.EMPLEADO_ROOT);
	}

	@GetMapping("/local/{idLocal}")
	public ModelAndView getByIdLocal(@PathVariable("idLocal") long idLocal) {
		ModelAndView mV = new ModelAndView(ViewRouteHelpers.EMPLEADO_INDEX);
		mV.addObject("empleado", empleadoService.findByIdLocal(idLocal));
		return mV;
	}

	@GetMapping("/sueldosBruto")
	public ModelAndView sueldosBruto() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.EMPLEADO_SUELDOS);
		mAV.addObject("sueldosBruto", empleadoService.SueldoBruto());
		return mAV;
	}

	@PostMapping("/pagoSueldos")
	public ModelAndView pagoSueldos() {
		List<EmpleadoModel> em = new ArrayList<EmpleadoModel>();
		em = empleadoService.getAlls();
		int i = 0;
		while (i < em.size()) {
			em.get(i).setComision(0);
			empleadoService.update(em.get(i));
			i++;
		}
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.EMPLEADO_SUELDOS);
		mAV.addObject("sueldosBruto", empleadoService.SueldoBruto());
		return mAV;
	}
}