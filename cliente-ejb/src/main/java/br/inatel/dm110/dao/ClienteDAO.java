package br.inatel.dm110.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.inatel.dm110.entities.Cliente;

@Stateless
public class ClienteDAO {
	
	@PersistenceContext(unitName = "cliente")
	private EntityManager em;
	
	public List<Cliente> getClientes() {
		return em.createQuery("from Cliente c", Cliente.class).getResultList();
	}
	
	public Cliente getCliente(String cpf) {
		return em.createQuery("from Cliente c where cpf = "+ cpf, Cliente.class).getSingleResult();
	}
	
	public void insert(Cliente cliente) {
		em.persist(cliente);
	}
	
}
