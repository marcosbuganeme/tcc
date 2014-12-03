package br.com.cvagal.persistencia.impl;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Transient;

import org.hibernate.Criteria;

import br.com.cvagal.filtro.FiltroLazy;
import br.com.cvagal.modelo.Candidato;
import br.com.cvagal.persistencia.CandidatoDAO;

/**
 * <p>
 * <b>Título:</b> CandidatoHibernateDAO.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por implementar a interface responsável pelo repositório da entidade <i>Candidato </i>.
 * </p>
 *
 * Data de criação: 30/11/2014
 *
 * @author marcosbuganeme
 *
 * @author Leides Rodrigues
 *
 * @version 1.0.0
 */
public class CandidatoHibernateDAO extends HibernateDAO<Candidato> implements CandidatoDAO {

	/** Constante serialVersionUID. */
	@Transient
	private static final long serialVersionUID = 2480488399162040868L;

	/** Atributo entityManager. */
	@Inject
	private EntityManager entityManager;

	@Override
	public void adicionarRestricaoLazy(final Criteria criteria, final FiltroLazy<Candidato> filtro) {

	}

	/**
	 * Retorna o valor do atributo <code>entityManager</code>
	 *
	 * @return <code>EntityManager</code>
	 */
	@Override
	public EntityManager getEntityManager() {

		return this.entityManager;
	}

}
