package br.com.nosql.example.hibernateogm.dao;

import java.util.List;

import br.com.nosql.example.hibernateogm.model.Historico;

/**
 * 
 * @author Diovani Bernardi da Motta Data: 12/04/2016 Classe responsável por
 *         efetuar a consulta de dados a camada de persistência da aplicação
 */
public class HistoricoDAO extends GenericDAO<Historico> {

	public HistoricoDAO() throws InterruptedException {
		super();
	}

	@Override
	public List<Historico> findAll() {
		manager.getTransaction().begin();
		List<Historico> historicos = manager.createQuery("select h from Historico h",Historico.class).getResultList();
		manager.getTransaction().commit();	
		return historicos;	
	}

	@Override
	public Historico findById(Long id) {
		manager.getTransaction().begin();
		Historico historico = manager.find(Historico.class, id);
		manager.getTransaction().commit();
		return historico;
	}
}
