/*
package com.unla.grupo1oo22020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo1oo22020.helpers.ViewRouteHelpers;
import com.unla.grupo1oo22020.models.SolicitudStockModel;
import com.unla.grupo1oo22020.services.ILocalService;
import com.unla.grupo1oo22020.services.IProductoService;
import com.unla.grupo1oo22020.services.ISolicitudStockService;


@Controller
@RequestMapping("/solicitudStock")
public class SolicitudStockController {

	@Autowired
	@Qualifier("solicitudStockService")
	private ISolicitudStockService pedidoService;
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	
	@Autowired
	@Qualifier("sucursalService")
	private ILocalService localService;
	
	@GetMapping("")
	public ModelAndView index() {
		
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.SOLICITUDSTOCK_INDEX);
		mAV.addObject("solicitudStock", solicitudStockService.getAll());
		mAV.addObject("local", localService.getAll());
		mAV.addObject("producto", localService.getAll());
		return mAV;
	}
	
	
	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.SOLICITUDSTOCK_STOCK);
		mAV.addObject("solicitudStock", new SolicitudStockModel());
		mAV.addObject("venta", ventaService.getAll());
		mAV.addObject("local", localService.getAll());
		mAV.addObject("producto", productoService.getAll());
		return mAV;
	}
	
	//-------------------------Generar pedido con stock
	@GetMapping("/create/")
	public RedirectView create(
			@RequestParam(value = "idVenta", required = false) long idVenta,
			@RequestParam(value = "idSucursal", required = false) long idSucursal,
			@RequestParam(value = "idProducto", required = false) long idProducto,
			@RequestParam(value = "cantidad", required = false) int cantidad) {
		
		ventaService.generarPedidoConStockPropio(ventaService.findById(idVenta), productoService.findById(idProducto), sucursalService.findById(idSucursal), cantidad);
		
		return new RedirectView(ViewRouteHelper.PEDIDO_ROOT);
	}
	
	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") long id) {
		
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PEDIDO_UPDATE);
		mAV.addObject("pedido", pedidoService.findById(id));
		mAV.addObject("productos", productoService.getAll());
		return mAV;
		
	}
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("pedido") PedidoModel pedidoModel) {
		
		pedidoService.update(pedidoModel);
		return new RedirectView(ViewRouteHelper.PEDIDO_ROOT);
	}
	
	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id")long id) {
		pedidoService.remove(id);
		return new RedirectView(ViewRouteHelper.PEDIDO_ROOT);
	}
}
*/
