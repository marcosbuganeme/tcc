package br.com.cvagal.persistencia.impl;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Transient;

import org.hibernate.Criteria;

import br.com.cvagal.filtro.FiltroLazy;
import br.com.cvagal.modelo.Endereco;
import br.com.cvagal.persistencia.EnderecoDAO;

/**
 * <p>
 * <b>Título:</b> EnderecoHibernateDAO.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por implementar a interface responsável pelo repositório da entidade <i>Endereco</i>.
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
public class EnderecoHibernateDAO extends HibernateDAO<Endereco> implements EnderecoDAO {

	/** Constante serialVersionUID. */
	@Transient
	private static final long serialVersionUID = -2728831361463604478L;

	/** Atributo entityManager. */
	@Inject
	private EntityManager entityManager;

	@Override
	public void adicionarRestricaoLazy(final Criteria criteria, final FiltroLazy<Endereco> filtro) {

	}

	@Override
	public EntityManager getEntityManager() {

		return this.entityManager;
	}

}
