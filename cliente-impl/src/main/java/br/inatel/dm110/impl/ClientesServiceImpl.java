package br.inatel.dm110.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import br.inatel.dm110.api.ClientesService;
import br.inatel.dm110.interfaces.ClientesRemote;

@RequestScoped
public class ClientesServiceImpl implements ClientesService {
	
	
	@EJB(lookup = "java:app/cliente-ejb-0.1-SNAPSHOT/ClienteBeans!br.inatel.dm110.interfaces.ClientesRemote")
	private ClientesRemote clientesRemote;


	@Override
	public List<String> getClientesNames() {
		return clientesRemote.getClientesNames();
	}

	@Override
	public String getClienteName(String cpf) {
		return clientesRemote.getClienteName(cpf);
	}

	@Override
	public void createCliente(String firstName, String lastName, String cpf) {
		clientesRemote.createCliente(firstName, lastName, cpf);
	}

}
