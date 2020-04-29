package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import siststock.*;

public class TestStock {

	public static void main(String[] args) {

		Sistema s = new Sistema(new ArrayList<Local>(), new ArrayList<SolicitudStock>(), new ArrayList<Cliente>(),
				new ArrayList<Venta>(), new ArrayList<Producto>(), new ArrayList<Venta>());

		System.out.println("------------------ SISTEMA ------------------\n");
		// LOCALES ---------------------------------------
		System.out.println("Alta de Locales:");
		try {

			s.altaLocal(1, 41111111, "Balbin 2122", 22.3f, 34.6f);
			s.altaLocal(2, 42222222, "Rivadavia 234", 10.1f, 23.4f);
			s.altaLocal(3, 43333333, "Calle3 3", 73.9f, 12.4f);
			s.altaLocal(4, 44444444, "Calle4 4", 84.1f, 23.5f);
			System.out.println(s.traerListaLocales());
			System.out.println("\nBaja de local:");
			System.out.println(s.bajaLocal(4));

			System.out.println("\nVuelvo a traer la lista de Locales");
			System.out.println(s.traerListaLocales());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// MODIFICO LOCAL
		System.out.println("\nModifico Local");
		try {

			s.modificarLocal(2, 42222222, "Alvear 14", 10.1f, 23.4f);
			System.out.println(s.traerListaLocales());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n------------------------------------------------------------------");

		// ALTA EMPLEADO --------------------------------------
		System.out.println("\nAlta de empleados:");
		try {

			s.traerLocal(1).altaEmpleado("Hermida", "Pablo", 11111111, LocalDate.of(1995, 10, 1), 1, 100f,
					LocalTime.of(10, 00), LocalTime.of(18, 00), true);
			s.traerLocal(1).altaEmpleado("Romano", "Sebastian", 22222222, LocalDate.of(1994, 10, 1), 2, 200f,
					LocalTime.of(12, 10), LocalTime.of(20, 10), false);
			s.traerLocal(2).altaEmpleado("Grimberg", "Kevin", 33333333, LocalDate.of(1866, 10, 1), 3, 300f,
					LocalTime.of(13, 30), LocalTime.of(21, 30), false);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(s.traerLocal(1).traerListaEmpleados());
		System.out.println(s.traerLocal(2).traerListaEmpleados());

		// BAJA EMPLEADO --------------------------------------
		System.out.println("\nBaja de empleado con dni: 22222222");
		try {

			System.out.println(s.traerLocal(1).bajaEmpleado(22222222));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(s.traerLocal(1).traerListaEmpleados());

		// MODIFICAR EMPLEADO ----------------------------------
		System.out.println("\nModifico empleado: ");
		try {
			s.traerLocal(1).modificarEmpleado("Messi", "Lionel", 11111111, LocalDate.of(1995, 10, 1), 1, 100f,
					LocalTime.of(10, 00), LocalTime.of(18, 00), true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println(s.traerLocal(1).getListaEmpleados());

		System.out.println("\n------------------------------------------------------------------");

		// ALTA CLIENTE -----------------------------------------
		System.out.println("\nAlta de clientes:");
		try {
			s.altaCliente("Perez", "Sergio", 11111111, LocalDate.of(2000, 01, 13), "email1@gmail.com");
			s.altaCliente("Alonso", "Fernando", 22222222, LocalDate.of(2000, 02, 14), "email2@gmail.com");
			s.altaCliente("Vettel", "Sebastian", 33333333, LocalDate.of(2000, 03, 15), "email3@gmail.com");
			s.altaCliente("Hamilton", "Lewis", 44444444, LocalDate.of(2000, 04, 16), "email4@gmail.com");
			s.altaCliente("Leclerc", "Charles", 55555555, LocalDate.of(2000, 05, 17), "email5@gmail.com");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("\n");
		}
		System.out.println(s.traerListaClientes());

		// BAJA CLIENTE -----------------------------------------
		System.out.println("\nBaja de cliente con dni: 11111111");
		try {

			s.bajaCliente(11111111);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("\n");
		}
		System.out.println(s.traerListaClientes());
		System.out.println("\n");

		// MODIFICAR CLIENTE ------------------------------------
		System.out.println("Modifico cliente: ");
		try {

			s.modificarCliente("Raikkonen", "Kimi", 55555555, LocalDate.of(2000, 05, 18), "email5@gamil.com");

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		System.out.print(s.traerListaClientes());

		System.out.println("\n------------------------------------------------------------------");

		// ALTA PRODUCTO ----------------------------------------
		System.out.println("Alta de Productos: \n");
		try {

			s.altaProducto("Manaos", 50.34f, LocalDate.of(2019, 10, 12));
			s.altaProducto("Fernet", 353.99f, LocalDate.of(2019, 7, 23));
			s.altaProducto("Cola", 110.34f, LocalDate.of(2019, 10, 20));
			s.altaProducto("Peps", 999.99f, LocalDate.of(2019, 5, 6));

			System.out.println(s.traerListaProductos());
			System.out.println("\nTraigo un Producto en específico");
			System.out.println(s.traerProducto("Manaos"));

			// BAJA PRODUCTO ------------------------------------------

			System.out.println("\nDar de baja Producto");
			System.out.println(s.bajaProducto("Peps"));
			System.out.println("\nTraigo la lista de los Productos");
			System.out.println(s.traerListaProductos());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n------------------------------------------------------------------");

		// ALTA LOTE ----------------------------------------------
		System.out.println("\nAlta de lotes: ");
		try {
			s.traerLocal(1).altaLote(1, LocalDate.of(2019, 10, 1), 5000, 3000, s.traerProducto("Manaos"));
			s.traerLocal(1).altaLote(2, LocalDate.of(2019, 10, 5), 10000, 5500, s.traerProducto("Fernet"));
			s.traerLocal(2).altaLote(3, LocalDate.of(2019, 10, 10), 3000, 1000, s.traerProducto("Fernet"));
			s.traerLocal(1).altaLote(4, LocalDate.of(2019, 11, 20), 5000, 4990, s.traerProducto("Cola"));
			s.traerLocal(2).altaLote(5, LocalDate.of(2019, 12, 9), 7500, 7000, s.traerProducto("Cola"));
			s.traerLocal(2).altaLote(6, LocalDate.of(2019, 10, 1), 5000, 3000, s.traerProducto("Manaos"));
			s.traerLocal(2).altaLote(7, LocalDate.of(2019, 12, 10), 6000, 6000, s.traerProducto("Cola"));
			s.traerLocal(2).altaLote(8, LocalDate.of(2019, 12, 10), 6000, 0, s.traerProducto("Cola"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(s.traerLocal(1).traerListaLotes());
		System.out.println(s.traerLocal(2).traerListaLotes());
		System.out.println("\n------------------------------------------------------------------");
		System.out.println("\n\n\nGenero Ventas(Pedidos)\n");
		System.out.println(s.generarVenta(s.traerLocal(2), s.traerCliente(33333333), LocalDate.of(2019, 11, 7),
				s.traerLocal(2).traerEmpleado(3)));
		System.out.println(s.generarVenta(s.traerLocal(2), s.traerCliente(22222222), LocalDate.of(2019, 11, 8),
				s.traerLocal(2).traerEmpleado(3)));
		try {
			System.out.println(s.traerVenta(1).agregarDetalleVenta(s.traerProducto("Cola"), 200));
			System.out.println(s.traerVenta(1).agregarDetalleVenta(s.traerProducto("Manaos"), 300));
			System.out.println(s.traerVenta(1).agregarDetalleVenta(s.traerProducto("Fernet"), 200));
			System.out.println(s.traerVenta(2).agregarDetalleVenta(s.traerProducto("Cola"), 600));
			System.out.println(s.traerVenta(2).agregarDetalleVenta(s.traerProducto("Fernet"), 200));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n\n\nImprimo Lista Ventas\n");

		System.out.println(s.traerListaVentas());
		System.out.println("\n------------------------------------------------------------------");
		System.out.println("\n\nGENERO VENTA(Pedido) 3\n");
		System.out.println(s.generarVenta(s.traerLocal(1), s.traerCliente(22222222), LocalDate.of(2019, 11, 8),
				s.traerLocal(1).traerEmpleado(1)));
		try {
			System.out.println(s.traerVenta(3).agregarDetalleVenta(s.traerProducto("Cola"), 8500));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\nCalculo distancia locales con stock\n");
		System.out.println(s.calcularDistancia(s.traerProducto("Cola"), 8500, s.traerLocal(1)));
		System.out.println("\n\n\nGenero una solicitud de Stock\n");
		System.out.println(s.solicitudStock(s.traerProducto("Cola"), 8500, s.traerLocal(1)));
		s.generarSolicitudStock(LocalDate.of(2019, 11, 11), s.traerProducto("Cola"), 8500,
				s.traerLocal(1).traerEmpleado(1));
		System.out.println(s.traerListaSolicitudesStock());
		System.out.println("\n\nEjemplo Se Rechaza la solicitud de stock\n");
		try {
			s.respuestaSolicitudStock(s.traerLocal(2), s.traerSolicitudStock(1), s.traerLocal(2).traerEmpleado(3),
					false);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(s.traerListaSolicitudesStock());
		System.out.println("\n------------------------------------------------------------------");
		System.out.println("\n\nEjemplo Se acepta la Solicitud de Stock\n");
		try {
			s.respuestaSolicitudStock(s.traerLocal(2), s.traerSolicitudStock(1), s.traerLocal(2).traerEmpleado(3),
					true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(s.traerListaSolicitudesStock());
		System.out.println("\n\n");
		System.out.println("Se genera la venta(pedido) con el stock del otro local\n");
		System.out.println(s.generarVenta(s.traerLocal(2), s.traerCliente(22222222), LocalDate.of(2019, 11, 8),
				s.traerLocal(1).traerEmpleado(1)));
		try {
			System.out.println(s.traerVenta(4).agregarDetalleVenta(s.traerProducto("Cola"), 8500));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("\nLista de Ventas(Pedidos)");
		System.out.println(s.traerListaVentas());
		System.out.println("\n------------------------------------------------------------------");
		System.out.println("\n\n\nGenero las Facturas de los productos Vendidos\n");
		try {
			System.out.println(s.generarFactura(1));
			System.out.println(s.generarFactura(2));
			System.out.println(s.generarFactura(4));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\nTraigo los lotes Actualizados con el stock descontado de los productos vendidos\n");
		System.out.println(s.traerLocal(1).traerListaLotes());
		System.out.println(s.traerLocal(2).traerListaLotes());
		System.out.println("\n\n\nIMPRIMO FACTURAS\n\n\n");
		System.out.println(s.traerListaFacturas());
		System.out.println("\n------------------------------------------------------------------");
		System.out.println("\nCalculo el sueldo del empleado 3 del local 2 y el empleado 1 del local 1\n");
		System.out.println(s.calcularSueldoEmpleado(s.traerLocal(2).traerEmpleado(3), 5, 2));
		System.out.println(s.calcularSueldoEmpleado(s.traerLocal(1).traerEmpleado(1), 5, 2));
		System.out.println("\n------------------------------------------------------------------");
		System.out.println("\n\n\nReporte de productos vendidos\n");
		System.out
				.println(s.productosVendidos(s.traerLocal(2), LocalDate.of(2019, 11, 06), LocalDate.of(2019, 11, 10)));
		System.out.println("\n------------------------------------------------------------------");
		System.out.println("\n\n\nRanking de productos vendidos\n");
		System.out.println(s.rankingProductosVendidos());

	}
}
