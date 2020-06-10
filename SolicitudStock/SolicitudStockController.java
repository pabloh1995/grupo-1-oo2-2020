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
import com.unla.grupo1oo22020.models.SolicitudStockModel;
import com.unla.grupo1oo22020.services.IEmpleadoService;
import com.unla.grupo1oo22020.services.ILocalService;
import com.unla.grupo1oo22020.services.IProductoService;
import com.unla.grupo1oo22020.services.ISolicitudStockService;

@Controller
@RequestMapping("/solicitudStock")
public class SolicitudStockController {

	@Autowired
	@Qualifier("solicitudStockService")
	private ISolicitudStockService solicitudStockService;

	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;

	@Autowired
	@Qualifier("localService")
	private ILocalService localService;
	
	@Autowired
	@Qualifier("empleadoService")
	private IEmpleadoService empleadoService;

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.SOLICITUDSTOCK_INDEX);
		mAV.addObject("solicitudStock", solicitudStockService.getAll());
		return mAV;
	}

	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.SOLICITUDSTOCK_NEW);
		mAV.addObject("solicitudStock", new SolicitudStockModel());
		mAV.addObject("locales", localService.getAlls());
		mAV.addObject("producto", productoService.getAlls());
		mAV.addObject("empleado", empleadoService.getAlle());
		return mAV;
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("solicitudStock") SolicitudStockModel solicitudStockModel) {
		solicitudStockService.insert(solicitudStockModel);
		return new RedirectView(ViewRouteHelpers.SOLICITUDSTOCK_ROOT);
	}

	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") long id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.SOLICITUDSTOCK_UPDATE);
		mAV.addObject("solicitudStock", solicitudStockService.findByIdSolicitudStock(id));
		mAV.addObject("locales", localService.getAlls());
		mAV.addObject("productos", productoService.getAlls());
		mAV.addObject("empleado", empleadoService.getAlle());
		return mAV;

	}

	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("solicitudStock") SolicitudStockModel solicitudStockModel) {
		solicitudStockService.update(solicitudStockModel);
		return new RedirectView(ViewRouteHelpers.SOLICITUDSTOCK_ROOT);
	}

	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") long id) {
		solicitudStockService.remove(id);
		return new RedirectView(ViewRouteHelpers.SOLICITUDSTOCK_ROOT);
	}
}
