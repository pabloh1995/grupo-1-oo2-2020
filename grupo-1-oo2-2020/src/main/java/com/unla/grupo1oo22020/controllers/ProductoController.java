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

import com.unla.grupo1oo22020.entities.Producto;
import com.unla.grupo1oo22020.helpers.ViewRouteHelpers;
import com.unla.grupo1oo22020.models.ProductoModel;
import com.unla.grupo1oo22020.services.ILoteService;
import com.unla.grupo1oo22020.services.IProductoService;


@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	
	@Autowired
	@Qualifier("loteService")
	private ILoteService loteService;
	
	/*@Autowired
	@Qualifier("venderService")
	private IVenderService venderService;*/
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.PRODUCTO_INDEX);
		mAV.addObject("producto", productoService.getAll());
		//mAV.addObject("producto", new ProductoModel());
		
		return mAV;
	}
	
	@GetMapping("/new")
	public ModelAndView crear() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.PRODUCTO_NEW);
		mAV.addObject("producto", new Producto());
		
		return mAV;
	}
		
	
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute(name="producto") ProductoModel producto, RedirectAttributes redirectAttrs) {
		int i=0;
		boolean encontrado = false;
		
		while(i<productoService.getAll().size() && !encontrado){
			Producto p = productoService.getAll().get(i);
				if(p.getNombre().equalsIgnoreCase(producto.getNombre())){
					encontrado = true;
				}
			i++;
		}
		if(!encontrado){
			productoService.insertOrUpdate(producto);
			redirectAttrs
				.addFlashAttribute("mensaje","Agregado Correctamente.")
				.addFlashAttribute("clase", "success");
		}else{
			redirectAttrs
				.addFlashAttribute("mensaje","No se pudo agregar, ya existe un producto con ese nombre.")
				.addFlashAttribute("clase", "warning");
		}
		return new RedirectView(ViewRouteHelpers.PRODUCTO_ROOT);
	}
	
	
	
	@PostMapping("/delete/{id}")
	public RedirectView eliminar(@PathVariable("id") long idProducto, RedirectAttributes redirectAttrs) {
        redirectAttrs
        	.addFlashAttribute("mensaje", "Eliminado correctamente")
        	.addFlashAttribute("clase", "warning");
		productoService.remove(idProducto);
		return new RedirectView(ViewRouteHelpers.PRODUCTO_ROOT);
	}

	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") long idProducto) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.PRODUCTO_UPDATE);
		mAV.addObject("producto", productoService.findByIdProducto(idProducto));
		return mAV;
	}
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("producto") ProductoModel productoModel) {
		productoService.insertOrUpdate(productoModel);
		return new RedirectView(ViewRouteHelpers.PRODUCTO_ROOT);
	}
	
	/*@PostMapping("/update")
	public RedirectView update(@ModelAttribute("producto") ProductoModel productoModel, RedirectAttributes redirectAttrs) {
		int i=0;
		boolean encontrado = false;
		
		while(i<productoService.getAll().size() && !encontrado){
			Producto p = productoService.getAll().get(i);
				if(p.getNombre() == productoModel.getNombre()){
					encontrado = true;
				}
			i++;
		}
		if(!encontrado){
			productoService.insertOrUpdate(productoModel);
			redirectAttrs
				.addFlashAttribute("mensaje","Agregado Correctamente.")
				.addFlashAttribute("clase", "success");
		}else{
			redirectAttrs
				.addFlashAttribute("mensaje","No se pudo modificar, ya existe un producto con ese nombre.")
				.addFlashAttribute("clase", "warning");
		}
		return new RedirectView(ViewRouteHelpers.PRODUCTO_ROOT);
	}*/
	
	
	
	@PostMapping("/back")
	public RedirectView back() {
		
		return new RedirectView(ViewRouteHelpers.PRODUCTO_ROOT);
	}

}
