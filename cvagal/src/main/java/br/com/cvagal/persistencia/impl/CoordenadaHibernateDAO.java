package br.com.cvagal.persistencia.impl;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;

import br.com.cvagal.filtro.FiltroLazy;
import br.com.cvagal.modelo.Coordenada;
import br.com.cvagal.persistencia.CoordenadaDAO;

/**
 * <p>
 * <b>Título:</b> CoordenadaHibernateDAO.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por implementar a interface responsável pelo repositório da entidade <i>Coordenada</i>.
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
public class CoordenadaHibernateDAO extends HibernateDAO<Coordenada> implements CoordenadaDAO {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 2675432098375918380L;

	/** Atributo entityManager. */
	@Inject
	private EntityManager entityManager;

	@Override
	public void adicionarRestricaoLazy(final Criteria criteria, final FiltroLazy<Coordenada> filtro) {

	}

	@Override
	public EntityManager getEntityManager() {

		return this.entityManager;
	}

}
