package br.com.cvagal.persistencia.impl;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.cvagal.filtro.FiltroLazy;
import br.com.cvagal.modelo.Usuario;
import br.com.cvagal.persistencia.UsuarioDAO;

/**
 * <p>
 * <b>Título:</b> UsuarioHibernateDAO.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por implementar a interface responsável pelo repositório da entidade <i>Usuario</i>.
 * </p>
 *
 * Data de criação: 21/11/2014
 *
 * @author marcosbuganeme
 *
 * @author Leides Rodrigues
 *
 * @version 1.0.0
 */
public class UsuarioHibernateDAO extends HibernateDAO<Usuario> implements UsuarioDAO {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1973739575026708037L;

	/** Atributo manager. */
	@Inject
	private EntityManager entityManager;

	@Override
	public Usuario obterUsuarioPorEmail(final String email) {

		final Criteria criteria = this.obterCriteria();

		if (StringUtils.isNotEmpty(email)) {

			criteria.add(Restrictions.ilike("email", email, MatchMode.EXACT));
		}

		return (Usuario) criteria.uniqueResult();
	}

	@Override
	public void adicionarRestricaoLazy(final Criteria criteria, final FiltroLazy<Usuario> filtro) {

	}

	/**
	 * Retorna o valor do atributo <code>manager</code>
	 *
	 * @return <code>EntityManager</code>
	 */
	@Override
	public EntityManager getEntityManager() {

		return this.entityManager;
	}
}
