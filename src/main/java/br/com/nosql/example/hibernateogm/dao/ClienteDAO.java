package br.com.nosql.example.hibernateogm.dao;

import java.util.List;

import br.com.nosql.example.hibernateogm.model.Cliente;

/**
 * 
 * @author Diovani Bernardi da Motta Data: 12/04/2016 Classe responsável por
 *         efetuar a consulta de dados a camada de persistência da aplicação
 */
public class ClienteDAO extends GenericDAO<Cliente> {

	public ClienteDAO() throws InterruptedException {
		super();
	}

	@Override
	public List<Cliente> findAll() {
		manager.getTransaction().begin();
		List<Cliente> clientes = manager.createQuery("select c from Cliente c",Cliente.class).getResultList();
		manager.getTransaction().commit();	
		return clientes;
	}

	@Override
	public Cliente findById(Long id) {
		manager.getTransaction().begin();
		Cliente cliente = manager.find(Cliente.class, id);
		manager.getTransaction().commit();	
		return cliente;
	}
}
