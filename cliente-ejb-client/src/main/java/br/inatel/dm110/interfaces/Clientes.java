package br.inatel.dm110.interfaces;

import java.util.List;

public interface Clientes {

	List<String> getClientesNames();
	
	String getClienteName(String cpf);
	
	void createCliente(String firstName, String lastName, String cpf);
}
