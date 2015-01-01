package br.com.cvagal.persistencia.impl;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.cvagal.filtro.FiltroLazy;
import br.com.cvagal.modelo.Vaga;
import br.com.cvagal.modelo.enums.EnumStatus;
import br.com.cvagal.persistencia.VagaDAO;

/**
 * <p>
 * <b>Título:</b> VagaHibernateDAO.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por implementar a interface responsável pelo repositório da entidade <i>Vaga</i>.
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
public class VagaHibernateDAO extends HibernateDAO<Vaga> implements VagaDAO {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 3692860768012738685L;

	/** Atributo entityManager. */
	@Inject
	private EntityManager entityManager;

	@Override
	public Vaga obterVagaPorSKU(final String sku) {

		final Criteria criteria = this.obterCriteria();

		criteria.add(Restrictions.eq("status", EnumStatus.ATIVO));

		if (StringUtils.isNotEmpty(sku)) {

			criteria.add(Restrictions.eq("sku", sku));
		}

		return (Vaga) criteria.uniqueResult();
	}

	@Override
	public void adicionarRestricaoLazy(final Criteria criteria, final FiltroLazy<Vaga> filtro) {

		criteria.add(Restrictions.eq("status", EnumStatus.ATIVO));

		if (filtro.getEnumerator() != null) {

			criteria.add(Restrictions.eq("tipoProfissional", filtro.getEnumerator()));
		}
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
