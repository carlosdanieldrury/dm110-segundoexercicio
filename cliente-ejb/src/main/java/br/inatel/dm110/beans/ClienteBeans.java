package br.inatel.dm110.beans;

import java.util.ArrayList;
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
	public List<String> getClientesNames() {
		
		List<Cliente> list = clienteDAO.getClientes();
		
		List<String> names = new ArrayList<String>();
		
		for (Cliente cliente : list) {
			names.add(cat(cliente.getFirstName(), cliente.getLastName()));
		}
		
		return names;
	}

	@Override
	public String getClienteName(String cpf) {
		Cliente clienteEntity = clienteDAO.getCliente(cpf);
		String name = clienteEntity.getFirstName() + clienteEntity.getLastName();
		return name;
	}

	@Override
	public void createCliente(String firstName, String lastName, String cpf) {
		Cliente clienteEntity = new Cliente();
		clienteEntity.setFirstName(firstName);
		clienteEntity.setLastName(lastName);
		clienteEntity.setCpf(cpf);
		clienteDAO.insert(clienteEntity);
	}
	
	private String cat(String a, String b) {
        a += b;
        return a;
    }
	

}
