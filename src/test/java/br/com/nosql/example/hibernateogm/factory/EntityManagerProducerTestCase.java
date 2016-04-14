package br.com.nosql.example.hibernateogm.factory;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;

import org.junit.Test;

/**
 * 
 * @author Diovani Bernardi da Motta Data: 12/04/2016 Teste Unitário Responsável
 *         por verificar se foi possível conectar-se ao banco de dados do
 *         MongoDB
 */
public class EntityManagerProducerTestCase {

	@Test
	public void testCreateEntityManager() {
		EntityManager entityManager = EntityManagerProducer.createEntityManager();
		assertNotNull(entityManager);
	}
}
