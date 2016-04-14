package br.com.nosql.example.hibernateogm.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;

import br.com.nosql.example.hibernateogm.factory.EntityManagerProducer;

/**
 * 
 * @author Diovani Bernardi da Motta Data: 12/04/2016 Classe responsável por
 *         implementar os métodos comuns para a manipulação de dados na camada
 *         de persitência
 * 
 * @param <T>
 *            o tipo de dado a ser retornado pelas consultas a dados
 */
public abstract class GenericDAO<T> {

	protected EntityManager manager;

	public GenericDAO() throws InterruptedException {
		manager = EntityManagerProducer.createEntityManager();
		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(manager);
		fullTextEntityManager.createIndexer().startAndWait();
	}

	/**
	 * Método responsável por persistir um objeto mapeado na camada de
	 * persistência
	 * 
	 * @param object
	 *            o objeto a ser persistido
	 */
	public void save(T object) {
		manager.getTransaction().begin();
		manager.persist(object);
		manager.getTransaction().commit();
	}

	/**
	 * Método responsável por atualizar um objeto mapeado na camada de
	 * persistência
	 * 
	 * @param object
	 *            o objeto a ser atualizado
	 */
	public void merge(T object) {
		manager.getTransaction().begin();
		manager.merge(object);
		manager.getTransaction().commit();
	}

	/**
	 * Método responsável por excluir um objeto mapeado na camada de
	 * persistência
	 * 
	 * @param object
	 *            o objeto a ser excluído
	 */
	public void remove(T object) {
		manager.getTransaction().begin();
		manager.remove(object);
		manager.getTransaction().commit();
	}

	/**
	 * Método responsável por executar uma consulta a dados e retornar todos os
	 * objetos persistidos na base de dados
	 * 
	 * @return uma lista de objetos definido pelo usuario
	 */
	public abstract List<T> findAll();

	/**
	 * Método responsável por executar a consulta a dados usando como parâmetro
	 * o identificador unico de cada objeto persistente
	 * 
	 * @param id
	 *            o idenficador unico do objeto
	 * @return um unico objeto definido pelo usuário
	 */
	public abstract T findById(Long id);

}
