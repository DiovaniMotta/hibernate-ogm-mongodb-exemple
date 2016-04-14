package br.com.nosql.example.hibernateogm.dao;

import java.util.List;

import br.com.nosql.example.hibernateogm.model.Cidade;

/**
 * 
 * @author Diovani Bernardi da Motta Data: 12/04/2016 Classe responsável por
 *         efetuar a consulta de dados a camada de persistência da aplicação
 */
public class CidadeDAO extends GenericDAO<Cidade> {

	public CidadeDAO() throws InterruptedException {
		super();
	}

	@Override
	public List<Cidade> findAll() {
		manager.getTransaction().begin();
		List<Cidade> cidades = manager.createQuery("select c from Cidade c",Cidade.class).getResultList();
		manager.getTransaction().commit();	
		return cidades;
	}

	@Override
	public Cidade findById(Long id) {
		manager.getTransaction().begin();
		Cidade cidade = manager.find(Cidade.class, id);
		manager.getTransaction().commit();	
		return cidade;
	
	}
}
