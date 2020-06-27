package com.unla.grupo1oo22020.controllers;

import java.time.LocalDate;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo1oo22020.converters.VentaConverter;
import com.unla.grupo1oo22020.entities.Venta;
import com.unla.grupo1oo22020.helpers.ViewRouteHelpers;
import com.unla.grupo1oo22020.models.LocalModel;
import com.unla.grupo1oo22020.models.ProductoModel;
import com.unla.grupo1oo22020.models.VentaModel;
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
@RequestMapping("/venta")
public class VentaController {

	@Autowired
	@Qualifier("ventaService")
	private IVentaService ventaService;

	@Autowired
	@Qualifier("detalleVentaService")
	private IDetalleVentaService detalleVentaService;

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
	@Qualifier("ventaConverter")
	private VentaConverter ventaConverter;

	@Autowired
	@Qualifier("empleadoService")
	private IEmpleadoService empleadoService;

	@Autowired
	@Qualifier("clienteService")
	private IClienteService clienteService;

	@Autowired
	@Qualifier("ventaRepository")
	private IVentaRepository ventaRepository;

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView maV = new ModelAndView(ViewRouteHelpers.VENTA_INDEX);
		maV.addObject("venta", ventaService.getAlls());
		return maV;
	}

	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.VENTA_NEW);
		mAV.addObject("venta", new VentaModel());
		mAV.addObject("locales", localService.getAlls());
		mAV.addObject("clientes", clienteService.getAlls());
		mAV.addObject("empleados", empleadoService.getAlls());
		return mAV;
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("venta") VentaModel ventaModel) {
		ventaService.setAttributes(ventaModel);
		ventaService.insert(ventaModel);
		detalleVentaService.setAttribues(ventaModel);
		VentaModel vm = new VentaModel();
		List<VentaModel> v = new ArrayList<VentaModel>();
		for (Venta venta : ventaRepository.findAll()) {
			v.add(ventaConverter.entityToModel(venta));
		}
		vm = v.get(v.size() - 1);
		vm.setTotal(detalleVentaService.getTotal(vm));

		ventaService.update(vm);
		return new RedirectView(ViewRouteHelpers.VENTA_ROOT);
	}

	@GetMapping("/reporteventas")
	public ModelAndView reporteventas() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelpers.VENTA_REPORTEVENTAS);
		mAV.addObject("local", new LocalModel());
		mAV.addObject("locales", localService.getAlls());
		return mAV;
	}

	@RequestMapping(value = "/reporteventasresultado", method = RequestMethod.POST)
	public ModelAndView reporteventasresultado(@ModelAttribute("local") LocalModel local,
			@RequestParam("desde") @DateTimeFormat(pattern = "yy-MM-dd") Date desde,
			@RequestParam("hasta") @DateTimeFormat(pattern = "yy-MM-dd") Date hasta) {
		ModelAndView mV = new ModelAndView(ViewRouteHelpers.VENTA_REPORTEVENTASRESULTADO);

		local.setIdLocal(localService.findByIdLocal(local.getIdLocal()).getIdLocal());
		LocalDate date1 = desde.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate date2 = hasta.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		List<ProductoModel> productos = localService.productosVendidosPorFechas(local, date1, date2);
		mV.addObject("producto", productos);
		return mV;
	}

}
