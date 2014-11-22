package br.com.cvagal.utilitarios.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * <p>
 * <b>Título:</b> ProdutorEntityManager.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por produzir uma fábrica de <code>EntityManager</code>'s.
 * </p>
 *
 * Data de criação: 16/11/2014
 *
 * @author marcosbuganeme
 *
 * @author Leides Rodrigues
 *
 * @version 1.0.0
 */
@ApplicationScoped
public class ProdutorEntityManager {

	/** Constante NOME_UNIDADE_PERSISTENCIA. */
	private static final String NOME_UNIDADE_PERSISTENCIA = "cvagalPU";

	/** Atributo factory. */
	private EntityManagerFactory factory;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public ProdutorEntityManager() {

		this.factory = Persistence.createEntityManagerFactory(ProdutorEntityManager.NOME_UNIDADE_PERSISTENCIA);
	}

	/**
	 * Método responsável por criar uma nova instância de <code>EntityManager</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>instância de <code>EntityManager</code></i>
	 */
	@Produces
	@RequestScoped
	public EntityManager criar() {

		return this.getFactory().createEntityManager();
	}

	/**
	 * Método responsável por destruir uma instância de <code>EntityManager</code>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param manager
	 */
	public void fechar(@Disposes final EntityManager manager) {

		manager.close();
	}

	/**
	 * Retorna o valor do atributo <code>factory</code>
	 *
	 * @return <code>EntityManagerFactory</code>
	 */
	public EntityManagerFactory getFactory() {

		return this.factory;
	}

}
