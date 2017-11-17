package br.inatel.dm110.interfaces;

import java.util.List;

public interface Clientes {

	List<Cliente> getClientes();
	
	Cliente getCliente(String cpf);
	
	Cliente createCliente(Cliente cliente);
}
