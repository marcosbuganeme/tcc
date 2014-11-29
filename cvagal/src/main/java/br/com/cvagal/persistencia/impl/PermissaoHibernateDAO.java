package br.com.cvagal.persistencia.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.cvagal.filtro.FiltroLazy;
import br.com.cvagal.modelo.Permissao;
import br.com.cvagal.persistencia.PermissaoDAO;

/**
 * <p>
 * <b>Título:</b> PermissaoHibernateDAO.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por implementar a interface responsável pelo repositório da entidade <i>Permissao</i>.
 * </p>
 *
 * Data de criação: 19/11/2014
 *
 * @author marcosbuganeme
 *
 * @author Leides Rodrigues
 *
 * @version 1.0.0
 */
@SuppressWarnings("unchecked")
public class PermissaoHibernateDAO extends HibernateDAO<Permissao> implements PermissaoDAO {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 8059727322464084104L;

	/** Atributo manager. */
	@Inject
	private EntityManager manager;

	@Override
	public Collection<Permissao> obterPermissaoPorUsuario(final Serializable idUsuario) {

		final Criteria criteria = this.obterCriteria();

		if (idUsuario != null) {

			criteria.createAlias("usuario", "u");

			criteria.add(Restrictions.eq("u.id", idUsuario));
		}

		return criteria.list();
	}

	@Override
	public void adicionarRestricaoLazy(final Criteria criteria, final FiltroLazy<Permissao> filtro) {

	}

	@Override
	public EntityManager getEntityManager() {

		return this.manager;
	}

	@Override
	public Session getSession() {

		return this.getEntityManager().unwrap(Session.class);
	}
}
