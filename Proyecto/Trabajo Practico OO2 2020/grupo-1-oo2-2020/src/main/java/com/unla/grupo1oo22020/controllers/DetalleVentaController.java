package com.unla.grupo1oo22020.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unla.grupo1oo22020.helpers.ViewRouteHelpers;
import com.unla.grupo1oo22020.services.IDetalleVentaService;

@Controller
@RequestMapping("/detalleVenta")
public class DetalleVentaController {

	@Autowired
	@Qualifier("detalleVentaService")
	private IDetalleVentaService detalleVentaService;

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView maV = new ModelAndView(ViewRouteHelpers.DETALLEVENTA_INDEX);
		maV.addObject("detalleVenta", detalleVentaService.getAll());
		return maV;
	}

	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") long id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.DETALLEVENTA_UPDATE);
		mAV.addObject("detalleVenta", detalleVentaService.findByIdVenta(id));
		return mAV;

	}
}
