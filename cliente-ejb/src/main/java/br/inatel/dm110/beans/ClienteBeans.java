package br.inatel.dm110.beans;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.inatel.dm110.dao.ClienteDAO;
import br.inatel.dm110.entities.Cliente;
import br.inatel.dm110.interfaces.ClientesLocal;
import br.inatel.dm110.interfaces.ClientesRemote;


@Stateless
@Local(ClientesLocal.class)
@Remote(ClientesRemote.class)
public class ClienteBeans implements ClientesLocal, ClientesRemote {
	
	@EJB
	private ClienteDAO clienteDAO;
	
	@Override
	public List<Cliente> getClientes() {
		return clienteDAO.getClientes().stream().collect(Collectors.toList());
	}

	@Override
	public Cliente getCliente(String cpf) {
		return clienteDAO.getCliente(cpf);
	}

	@Override
	public Cliente createCliente(Cliente cliente) {
		return clienteDAO.insert(cliente);
	}

	

}
