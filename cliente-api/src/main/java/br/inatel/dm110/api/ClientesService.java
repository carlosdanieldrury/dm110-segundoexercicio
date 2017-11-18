package br.inatel.dm110.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
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
	List<String> getClientesNames();
	
	
	@GET
	@Path("/{cpf}")
	@Produces(MediaType.APPLICATION_JSON)
	String getClienteName(@PathParam("cpf") String cpf);
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	void createCliente(@FormParam("firstName") String firstName, 
			@FormParam("lastName") String lastName,
			@FormParam("cpf") String cpf);
	
}
