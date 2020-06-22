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
import com.unla.grupo1oo22020.models.LoteModel;
import com.unla.grupo1oo22020.services.ILocalService;
import com.unla.grupo1oo22020.services.ILoteService;
import com.unla.grupo1oo22020.services.IProductoService;

@Controller
@RequestMapping("/lote")
public class LoteController {
	
	@Autowired
	@Qualifier("loteService")
	private ILoteService loteService;
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	
	@Autowired
	@Qualifier("localService")
	private ILocalService localService;

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.LOTE_INDEX);
		mAV.addObject("lote", loteService.getAlls());
		return mAV;
	}
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.LOTE_NEW);
		mAV.addObject("lote", new LoteModel());
		mAV.addObject("producto", productoService.getAlls());
		mAV.addObject("locales", localService.getAlls());
		return mAV;
	}
	
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("lote") LoteModel loteModel) {
		loteService.insert(loteModel);
		return new RedirectView(ViewRouteHelpers.LOTE_ROOT);
	}
	/*@PostMapping("/create")
	public RedirectView create(@ModelAttribute("lote") LoteModel loteModel) {
		loteModel.setCantidadIngreso(loteModel.getCantidadActual());
		loteService.insertOrUpdate(loteModel);
	StockModel stockModel =	stockService.findByIdStock(loteModel.getStock().getIdStock());
	System.out.println("Se trajo bien: " + stockService.findByIdStock(loteModel.getStock().getIdStock()).getIdStock());
		stockModel.getLotes().add(loteModel);
		stockService.insertOrUpdate(stockModel);
		System.out.println("TRAIDO: " + stockModel.getLotes().get(0).getCantidadActual());
		
		return new RedirectView(ViewRouteHelpers.LOTE_ROOT);
	}*/
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") long idLote) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.LOTE_UPDATE);
		mAV.addObject("lote", loteService.findByIdLote(idLote));
		mAV.addObject("producto", productoService.getAlls());
		mAV.addObject("locales", localService.getAlls());
		return mAV;
	}
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("lote") LoteModel loteModel) {
	    loteService.update(loteModel);
	    return new RedirectView(ViewRouteHelpers.LOTE_ROOT);
	}

	
	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") long idLote) {
		loteService.remove(idLote);
		return new RedirectView(ViewRouteHelpers.LOTE_ROOT);
	}

	
	@PostMapping("/back")
	public RedirectView back() {
		return new RedirectView(ViewRouteHelpers.LOTE_ROOT);
	}
	



}