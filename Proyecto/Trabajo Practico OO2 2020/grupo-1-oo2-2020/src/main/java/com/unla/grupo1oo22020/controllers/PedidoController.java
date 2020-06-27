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
import com.unla.grupo1oo22020.models.PedidoModel;
import com.unla.grupo1oo22020.repositories.IPedidoRepository;
import com.unla.grupo1oo22020.repositories.IVentaRepository;
import com.unla.grupo1oo22020.services.IClienteService;
import com.unla.grupo1oo22020.services.IEmpleadoService;
import com.unla.grupo1oo22020.services.ILocalService;
import com.unla.grupo1oo22020.services.ILoteService;
import com.unla.grupo1oo22020.services.IPedidoService;
import com.unla.grupo1oo22020.services.IProductoService;
import com.unla.grupo1oo22020.services.IVentaService;
import com.unla.grupo1oo22020.services.IDetalleVentaService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	@Qualifier("pedidoService")
	private IPedidoService pedidoService;

	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;

	@Autowired
	@Qualifier("localService")
	private ILocalService localService;

	@Autowired
	@Qualifier("loteService")
	private ILoteService loteService;

	@Autowired
	@Qualifier("empleadoService")
	private IEmpleadoService empleadoService;

	@Autowired
	@Qualifier("clienteService")
	private IClienteService clienteService;

	@Autowired
	@Qualifier("pedidoRepository")
	private IPedidoRepository pedidoRepository;

	@Autowired
	@Qualifier("ventaRepository")
	private IVentaRepository ventaRepository;

	@Autowired
	@Qualifier("ventaService")
	private IVentaService ventaService;

	@Autowired
	@Qualifier("detalleVentaService")
	private IDetalleVentaService detalleVentaService;

	private ModelAndView maV;

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView maV = new ModelAndView(ViewRouteHelpers.PEDIDO_INDEX);
		maV.addObject("pedido", pedidoService.getAll());
		return maV;
	}

	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView maV = new ModelAndView(ViewRouteHelpers.PEDIDO_NEW);
		maV.addObject("pedido", new PedidoModel());
		maV.addObject("producto", productoService.getAlls());
		maV.addObject("locales", localService.getAlls());
		maV.addObject("empleado", empleadoService.getAlle());
		maV.addObject("cliente", clienteService.getAlls());
		return maV;
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("pedido") PedidoModel pedidoModel) {
		pedidoService.setAttributes(pedidoModel);
		if (pedidoService.validarConsumo(pedidoModel)) {
			pedidoModel.setResuelto(true);
			pedidoService.insert(pedidoModel);
		} else {
			pedidoModel.setResuelto(false);
			pedidoService.insert(pedidoModel);
		}
		return new RedirectView(ViewRouteHelpers.PEDIDO_ROOT);
	}

	@PostMapping("/generarVenta/{idPedido}")
	public RedirectView generarVenta(@PathVariable("idPedido") long idPedido) {
		return new RedirectView(ViewRouteHelpers.VENTA_ROOT);

	}

	@PostMapping("/solicitarLocal/{idPedido}")
	public RedirectView solicitarLocal(@PathVariable("idPedido") long idPedido) {
		return new RedirectView(ViewRouteHelpers.SOLICITUDSTOCK_ROOT);
	}

	@GetMapping("/{idPedido}")
	public ModelAndView get(@PathVariable("idPedido") long idPedido) {
		ModelAndView maV = new ModelAndView(ViewRouteHelpers.PEDIDO_UPDATE);
		maV.addObject("pedido", pedidoService.findByIdPedido(idPedido));
		maV.addObject("producto", productoService.getAlls());
		maV.addObject("locales", localService.getAlls());
		maV.addObject("empleado", empleadoService.getAlle());
		maV.addObject("cliente", clienteService.getAlls());
		return maV;
	}

	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("pedido") PedidoModel pedidoModel) {
		if (pedidoService.validarConsumo(pedidoModel)) {
			pedidoService.update(pedidoModel);
			pedidoService.consumoStock(pedidoModel);
		}
		return new RedirectView(ViewRouteHelpers.PEDIDO_ROOT);
	}

	@PostMapping("/delete/{idPedido}")
	public RedirectView delete(@PathVariable("idPedido") long idPedido) {
		pedidoService.remove(idPedido);
		return new RedirectView(ViewRouteHelpers.PEDIDO_ROOT);
	}

}