package br.inatel.dm110.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.inatel.dm110.entities.ClienteEntity;

public class ClienteDAO {
	
	@PersistenceContext(unitName = "clientes")
	private EntityManager em;
	
	public List<ClienteEntity> getClientes() {
		return em.createQuery("from Cliente c", ClienteEntity.class).getResultList();
	}
	
	public ClienteEntity getCliente(String cpf) {
		return (ClienteEntity) em.createQuery("from Cliente c where cpf = "+ cpf, ClienteEntity.class);
	}
	
	public void insert(ClienteEntity cliente) {
		em.persist(cliente);
	}
	
}
