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
import com.unla.grupo1oo22020.models.LocalModel;
import com.unla.grupo1oo22020.services.ILocalService;

@Controller
@RequestMapping("/local")
public class LocalController {

	@Autowired
	@Qualifier("localService")
	private ILocalService localService;
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.LOCAL_INDEX);
		mAV.addObject("local", localService.getAll());
		return mAV;
	}
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.LOCAL_NEW);
		mAV.addObject("local", new LocalModel());
		return mAV;
	}
	
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("local") LocalModel localModel) {
		localService.insertOrUpdate(localModel);
		return new RedirectView(ViewRouteHelpers.LOCAL_ROOT);
	}
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") long id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.LOCAL_UPDATE);
		mAV.addObject("local", localService.findById(id));
		return mAV;
	}
	

	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("local") LocalModel localModel) {
		localService.insertOrUpdate(localModel);
		return new RedirectView(ViewRouteHelpers.LOCAL_ROOT);
	}
	
	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") long id) {
		localService.remove(id);
		return new RedirectView(ViewRouteHelpers.LOCAL_ROOT);
	}

	public RedirectView delete(@ModelAttribute("local") Local local) {
		localService.calcularDistancia(local);
		return new RedirectView(ViewRouteHelpers.LOCAL_ROOT);
	}
}