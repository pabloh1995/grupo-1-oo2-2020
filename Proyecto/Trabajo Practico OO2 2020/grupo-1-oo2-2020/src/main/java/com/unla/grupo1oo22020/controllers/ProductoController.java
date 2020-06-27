package com.unla.grupo1oo22020.controllers;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo1oo22020.helpers.ViewRouteHelpers;
import com.unla.grupo1oo22020.models.ProductoModel;
import com.unla.grupo1oo22020.services.IDetalleVentaService;
import com.unla.grupo1oo22020.services.IPedidoService;
import com.unla.grupo1oo22020.services.IProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;

	@Autowired
	@Qualifier("pedidoService")
	private IPedidoService pedidoService;

	@Autowired
	@Qualifier("detalleVentaService")
	private IDetalleVentaService detalleVentaService;

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.PRODUCTO_INDEX);
		mAV.addObject("producto", productoService.getAlls());
		return mAV;
	}

	@PreAuthorize("hasRole( 'ROLE_ADMIN' )" + " || hasRole('ROLE_GERENTE')")
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.PRODUCTO_NEW);
		mAV.addObject("producto", new ProductoModel());

		return mAV;
	}

	@PreAuthorize("hasRole( 'ROLE_ADMIN' )" + " || hasRole('ROLE_GERENTE')")
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("producto") ProductoModel productoModel) {
		productoService.insertOrUpdate(productoModel);
		return new RedirectView(ViewRouteHelpers.PRODUCTO_ROOT);
	}

	@PreAuthorize("hasRole( 'ROLE_ADMIN' )" + " || hasRole('ROLE_GERENTE')")
	@PostMapping("/delete/{id}")
	public RedirectView eliminar(@PathVariable("id") long idProducto, RedirectAttributes redirectAttrs) {
		redirectAttrs.addFlashAttribute("mensaje", "Eliminado correctamente").addFlashAttribute("clase", "warning");
		productoService.remove(idProducto);
		return new RedirectView(ViewRouteHelpers.PRODUCTO_ROOT);
	}

	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") long idProducto) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.PRODUCTO_UPDATE);
		mAV.addObject("producto", productoService.findByIdProducto(idProducto));
		return mAV;
	}

	@PreAuthorize("hasRole( 'ROLE_ADMIN' )" + " || hasRole('ROLE_GERENTE')")
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("producto") ProductoModel productoModel) {
		productoService.insertOrUpdate(productoModel);
		return new RedirectView(ViewRouteHelpers.PRODUCTO_ROOT);
	}

	@GetMapping("/rankingproductosvendidos")
	public ModelAndView rankingproductosvendidos() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.PRODUCTO_RANKINGPRODUCTOSVENDIDOS);
		mAV.addObject("rankingproductos", detalleVentaService.rankingproductosvendidos());
		return mAV;
	}

	@PostMapping("/back")
	public RedirectView back() {

		return new RedirectView(ViewRouteHelpers.PRODUCTO_ROOT);
	}

}
