package com.unla.grupo1oo22020.controllers;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

import com.unla.grupo1oo22020.converters.PedidoConverter;
import com.unla.grupo1oo22020.entities.Pedido;
import com.unla.grupo1oo22020.entities.Producto;
import com.unla.grupo1oo22020.helpers.ViewRouteHelpers;
import com.unla.grupo1oo22020.models.PedidoModel;
import com.unla.grupo1oo22020.repositories.IPedidoRepository;
import com.unla.grupo1oo22020.services.IClienteService;
import com.unla.grupo1oo22020.services.IEmpleadoService;
import com.unla.grupo1oo22020.services.ILocalService;
import com.unla.grupo1oo22020.services.ILoteService;
import com.unla.grupo1oo22020.services.IPedidoService;
import com.unla.grupo1oo22020.services.IProductoService;

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
	@Qualifier("pedidoConverter")
	private PedidoConverter pedidoConverter;
	
	
	
	@GetMapping("")
	public ModelAndView index() {
		ModelAndView maV = new ModelAndView(ViewRouteHelpers.PEDIDO_INDEX);
		maV.addObject("pedido", pedidoService.getAlls());
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
		if(pedidoService.validarConsumo(pedidoModel.getLocal(), pedidoModel.getProducto(), pedidoModel.getCantidad())){
			pedidoModel.setResuelto(true);
			pedidoService.insert(pedidoModel);
		}
		else {
			pedidoModel.setResuelto(false);
			pedidoService.insert(pedidoModel);
		}
		return new RedirectView(ViewRouteHelpers.PEDIDO_ROOT);
	}
	
	@PostMapping("/generarVenta/{idPedido}")
	public RedirectView generarVenta(@PathVariable("idPedido") long idPedido, PedidoModel pedidoModel, HttpServletRequest request, RedirectAttributes redirectAttrs) {
		//LA IDEA ES QUE AL GENERAR LA VENTA, SE GUARDE ESE PEDIDO COMO UNA VENTA
		//QUE SE DESCUENTE DEL LOTE LA CANTIDAD VENDIDA
		//QUE SE BORRE ESE PEDIDO DE LA LISTA DE PEDIDOS

		//indicamos venta generada
        redirectAttrs
        .addFlashAttribute("mensaje", "Venta realizada correctamente")
        .addFlashAttribute("clase", "success");
        
        return new RedirectView(ViewRouteHelpers.PEDIDO_ROOT);
		
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
		pedidoService.setAttributes(pedidoModel);
		if(pedidoService.validarConsumo(pedidoModel.getLocal(), pedidoModel.getProducto(), pedidoModel.getCantidad())){
			pedidoModel.setResuelto(true);
			pedidoService.insert(pedidoModel);
			//pedidoService.consumoStock(pedidoModel);
		}
		else {
			pedidoModel.setResuelto(false);
			pedidoService.insert(pedidoModel);
		}
		return new RedirectView(ViewRouteHelpers.PEDIDO_ROOT);
	}
	
    /*@PostMapping(value = "/terminar")
    public String terminarVenta(HttpServletRequest request, RedirectAttributes redirectAttrs) {
        ArrayList<Pedido> pedidos = this.obtenerPedidos(request);
        // Si no hay pedidos o está vacío, regresamos inmediatamente
        if (pedidos == null || pedidos.size() <= 0) {
            return "redirect:/pedido/";
        }
        Pedido p = pedidoRepository.save(new Pedido());
        // Recorrer el carrito
        for (Pedido pedido : pedidos) {
            // Obtener el producto fresco desde la base de datos
            Producto prod = productoRepository.findById(productoParaVender.getId()).orElse(null);
            if (p == null) continue; // Si es nulo o no existe, ignoramos el siguiente código con continue
            // Le restamos existencia
            p.restarExistencia(productoParaVender.getCantidad());
            // Lo guardamos con la existencia ya restada
            productosRepository.save(p);
            // Creamos un nuevo producto que será el que se guarda junto con la venta
            ProductoVendido productoVendido = new ProductoVendido(productoParaVender.getCantidad(), productoParaVender.getPrecio(), productoParaVender.getNombre(), productoParaVender.getCodigo(), v);
            // Y lo guardamos
            productosVendidosRepository.save(productoVendido);
        }

        // Al final limpiamos el carrito
        this.limpiarCarrito(request);
        // e indicamos una venta exitosa
        redirectAttrs
                .addFlashAttribute("mensaje", "Venta realizada correctamente")
                .addFlashAttribute("clase", "success");
        return "redirect:/vender/";
    }
    
    private ArrayList<Pedido> obtenerPedidos(HttpServletRequest request) {
        ArrayList<Pedido> pedidos = (ArrayList<Pedido>) request.getSession().getAttribute("pedidos");
        if (pedidos == null) {
            pedidos = new ArrayList<>();
        }
        return pedidos;
    }*/
	

	
	@PostMapping("/delete/{idPedido}")
	public RedirectView delete(@PathVariable("idPedido") long idPedido) {
		pedidoService.remove(idPedido);
		return new RedirectView(ViewRouteHelpers.PEDIDO_ROOT);
		}
		
	
}