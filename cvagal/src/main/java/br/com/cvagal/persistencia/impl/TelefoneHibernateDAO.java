package br.com.cvagal.persistencia.impl;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Transient;

import org.hibernate.Criteria;

import br.com.cvagal.filtro.FiltroLazy;
import br.com.cvagal.modelo.Telefone;
import br.com.cvagal.persistencia.TelefoneDAO;

/**
 * <p>
 * <b>Título:</b> TelefoneHibernateDAO.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por implementar a interface responsável pelo repositório da entidade <i>Telefone</i>.
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
public class TelefoneHibernateDAO extends HibernateDAO<Telefone> implements TelefoneDAO {

	/** Constante serialVersionUID. */
	@Transient
	private static final long serialVersionUID = -5098582068924772304L;

	/** Atributo entityManager. */
	@Inject
	private EntityManager entityManager;

	@Override
	public void adicionarRestricaoLazy(final Criteria criteria, final FiltroLazy<Telefone> filtro) {

	}

	@Override
	public EntityManager getEntityManager() {

		return this.entityManager;
	}

}
