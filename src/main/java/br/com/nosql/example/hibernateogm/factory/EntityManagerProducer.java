package br.com.nosql.example.hibernateogm.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * @author Diovani Bernardi da Motta Data: 12/04/2016 Classe que tem como
 *         responsabilidade criar uma fabrica de conexões através de uma unidade
 *         de persistência configurada (persistence.xml), para acesso a banco de
 *         dados NoSQL
 */
public class EntityManagerProducer {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("ogm-jpa-tutorial");

	/**
	 * Método responsável por efetuar a criação de um gerenciador de entidade,
	 * que terá como função a manipulação dos dados na camada de persistência
	 * 
	 * @return uma implemenção da interface EntityManager
	 */
	public static EntityManager createEntityManager() {
		return factory.createEntityManager();
	}

	/**
	 * Método responsável por efetuar o fechamento de um gerenciador de
	 * entidades
	 * 
	 * @param manager
	 *            o gerenciador que será encerrado
	 */
	public static void finalize(EntityManager manager) {
		manager.close();
	}
}
