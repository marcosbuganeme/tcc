package br.com.cvagal.persistencia.impl;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;

import br.com.cvagal.filtro.FiltroLazy;
import br.com.cvagal.modelo.Empresa;
import br.com.cvagal.persistencia.EmpresaDAO;

/**
 * <p>
 * <b>Título:</b> EmpresaHibernateDAO.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por implementar a interface responsável pelo repositório da entidade <i>Empresa</i>.
 * </p>
 *
 * Data de criação: 28/11/2014
 *
 * @author marcosbuganeme
 *
 * @author Leides Rodrigues
 *
 * @version 1.0.0
 */
public class EmpresaHibernateDAO extends HibernateDAO<Empresa> implements EmpresaDAO {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 8536501656498517217L;

	/** Atributo entityManager. */
	@Inject
	private EntityManager entityManager;

	@Override
	public void adicionarRestricaoLazy(final Criteria criteria, final FiltroLazy<Empresa> filtro) {

	}

	/**
	 * Retorna o valor do atributo <code>entityManager</code>
	 *
	 * @return <code>EntityManager</code>
	 */
	@Override
	protected EntityManager getEntityManager() {

		return this.entityManager;
	}

}
