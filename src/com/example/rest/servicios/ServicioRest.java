package com.example.rest.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.rest.dao.ClienteModel;
import com.example.rest.dao.ComprobanteModel;
import com.example.rest.dao.MarcaModel;
import com.example.rest.dao.PaisModel;
import com.example.rest.dao.PedidoModel;
import com.example.rest.dao.ProductoModel;
import com.example.rest.dao.ProveedorModel;
import com.example.rest.dao.TipoReclamoModel;
import com.example.rest.dao.UbigeoModel;
import com.example.rest.dao.UsuarioModel;
import com.example.rest.entidades.Cliente;
import com.example.rest.entidades.Comprobante;
import com.example.rest.entidades.Pedido;
import com.example.rest.entidades.Producto;
import com.example.rest.entidades.Ubigeo;
import com.example.rest.entidades.Usuario;

import lombok.extern.apachecommons.CommonsLog;

@Path("/servicios")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
@CommonsLog
public class ServicioRest {

	private UsuarioModel daoUser = new UsuarioModel();
	private MarcaModel daoMarca = new MarcaModel();
	private UbigeoModel daoUbigeo = new UbigeoModel();
	private PaisModel daoPais = new PaisModel();
	private ProveedorModel daoProveedor = new ProveedorModel();
	private ClienteModel daoCliente = new ClienteModel();
	private PedidoModel daoPedido = new PedidoModel();
	private ProductoModel daoProducto = new ProductoModel();
	private ComprobanteModel daoComprobante = new ComprobanteModel();
	private TipoReclamoModel daoTipoReclamo = new TipoReclamoModel();
	
	@POST
	@Path("/pedido")
	public Response registroPedido(Pedido obj) {
		log.info("rest -> registroPedido ");
		return Response.ok(daoPedido.inserta(obj)).build();
	}

	@POST
	@Path("/cliente")
	public Response registroCliente(Cliente obj) {
		log.info("rest -> registroCliente");
		return Response.ok(daoCliente.insertaCliente(obj)).build();
	}

	@POST
	@Path("/producto")
	public Response registroProducto(Producto obj) {
		log.info("rest -> registroProducto");
		return Response.ok(daoProducto.insertaProducto(obj)).build();
	}

	@POST
	@Path("/comprobante")
	public Response registroComprobante(Comprobante obj) {
		log.info("rest -> registroComprobante");
		return Response.ok(daoComprobante.inserta(obj)).build();
	}

	@GET
	@Path("/login")
	public Response login(Usuario obj) {
		log.info("rest -> login ");
		return Response.ok(daoUser.login(obj)).build();
	}

	@GET
	@Path("/listaTipoReclamo")
	public Response listaTipoReclamo() {
		log.info("rest -> listaTipoReclamo");
		return Response.ok(daoTipoReclamo.listaTipoReclamo()).build();
	}

	
	@GET
	@Path("/listaMarca")
	public Response listaMarca() {
		log.info("rest -> listaMarca");
		return Response.ok(daoMarca.listarMarcaTodos()).build();
	}
	
	@GET
	@Path("/listaUsuario")
	public Response listaUsuario() {
		log.info("rest ->listaUsuario ");
		return Response.ok(daoUser.listarTodos()).build();
	}
	

	@GET
	@Path("/listaPais")
	public Response listaPais() {
		log.info("rest -> listaPais");
		return Response.ok(daoPais.listaPais()).build();
	}

	@GET
	@Path("/listaProveedor")
	public Response listarProveedor() {
		log.info("rest -> listarProveedor");
		return Response.ok(daoProveedor.listaProveedor()).build();
	}

	@GET
	@Path("/listaProducto")
	public Response listaProducto() {
		log.info("rest -> listaProducto");
		return Response.ok(daoProducto.listarProductoTodos()).build();
	}
	
	@GET
	@Path("/listaProductoPorNombre/{filtro}")
	public Response listaProductoPorNombre(@PathParam("filtro") String filtro) {
		log.info("rest -> listaProductoPorNombre");
		return Response.ok(daoProducto.listarProductoPorNombre(filtro)).build();
	}
	
	
	@GET
	@Path("/listaCliente")
	public Response listaCliente() {
		log.info("rest -> listaCliente");
		return Response.ok(daoCliente.listarClienteTodos()).build();
	}
	
	@GET
	@Path("/listaClientePorNombre/{filtro}")
	public Response listaClientePorNombre(@PathParam("filtro") String filtro) {
		log.info("rest -> listaClientePorNombre");
		return Response.ok(daoCliente.listarClientePorNombre(filtro)).build();
	}
	
	@GET
	@Path("/listaComprobante")
	public Response listaComprobante() {
		log.info("rest -> listaComprobante");
		return Response.ok(daoComprobante.listaComprobante()).build();
	}
	@GET
	@Path("/listaComprobante/{comprobante}")
	public Response listaComprobantePorId(@PathParam("comprobante") int idPedido) {
		log.info("rest -> listaComprobantePorId");
		return Response.ok(daoComprobante.listaComprobantePorId(idPedido)).build();
	}
	@GET
	@Path("/listaComprobantePorCliente/{cliente}")
	public Response listaComprobanteCliente(@PathParam("cliente") int idCliente) {
		log.info("rest -> listaComprobanteCliente");
		return Response.ok(daoComprobante.listaComprobantePorCliente(idCliente)).build();
	}
	

	@GET
	@Path("/listaPedido")
	public Response listaPedido() {
		log.info("rest -> listaPedido");
		return Response.ok(daoPedido.listaPedido()).build();
	}
	
	@GET
	@Path("/listaPedido/{pedido}")
	public Response listaPedidoPorId(@PathParam("pedido") int idPedido) {
		log.info("rest -> listaPedidoPorId");
		return Response.ok(daoPedido.listaPedidoPorId(idPedido)).build();
	}
	@GET
	@Path("/listaPedidoPorCliente/{cliente}")
	public Response listaPedidoPorCliente(@PathParam("cliente") int idCliente) {
		log.info("rest -> listaPedidoPorCliente");
		return Response.ok(daoPedido.listaPedidoporCliente(idCliente)).build();
	}
	
	@GET
	@Path("/departamentos")
	public Response listarDepartamentos() {
		log.info("rest -> listarDepartamentos");
		return Response.ok(daoUbigeo.listarDepartamentos()).build();
	}

	@GET
	@Path("/provincias/{depa}")
	public Response listarProvincias(@PathParam("depa") String idDepa) {
		log.info("rest ->  listarProvincias");
		Ubigeo obj = new Ubigeo();
		obj.setDepartamento(idDepa);
		return Response.ok(daoUbigeo.listarProvincia(obj)).build();
	}

	@GET
	@Path("/distritos/{depa}/{pro}")
	public Response listarDistritos(@PathParam("depa") String idDepa, @PathParam("pro") String idPro) {
		log.info("rest -> listarDistritos");
		Ubigeo obj = new Ubigeo();
		obj.setDepartamento(idDepa);
		obj.setProvincia(idPro);
		return Response.ok(daoUbigeo.listarDistrito(obj)).build();
	}
}