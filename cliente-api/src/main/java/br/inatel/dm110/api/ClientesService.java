package br.inatel.dm110.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/clientes")
public interface ClientesService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	List<Cliente> getClientes();
	
	
	@GET
	@Path("{cpf}")
	@Produces(MediaType.APPLICATION_JSON)
	Cliente getCliente(@PathParam("cpf") String cpf);
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	Cliente createCliente(Cliente cliente);
	
}
