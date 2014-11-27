package br.com.cvagal.persistencia.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.cvagal.filtro.FiltroLazy;
import br.com.cvagal.modelo.Vaga;
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
@SuppressWarnings("unchecked")
public class VagaHibernateDAO extends HibernateDAO<Vaga> implements VagaDAO {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 3692860768012738685L;

	/** Atributo entityManager. */
	@Inject
	private EntityManager entityManager;

	@Override
	public List<Vaga> autoCompleteVaga(final String palavraFiltrada) {

		final Criteria criteria = this.obterCriteria();

		this.adicionarRestricaoAutoComplete(criteria, palavraFiltrada);

		return criteria.list();
	}

	/**
	 * Método responsável por adicionar restrição para o componente autocomplete do primefaces.
	 *
	 * @author marcosbuganeme
	 *
	 * @param criteria
	 *            - objeto criteria para restrição da consulta
	 * 
	 * @param palavraFiltrada
	 *            - filtro da consulta.
	 */
	private void adicionarRestricaoAutoComplete(final Criteria criteria, final String palavraFiltrada) {

		final Disjunction or = Restrictions.disjunction();

		if (StringUtils.isNotEmpty(palavraFiltrada)) {

			or.add(Restrictions.ilike("sku", palavraFiltrada, MatchMode.START));

			or.add(Restrictions.ilike("descricao", palavraFiltrada, MatchMode.START));
		}

		criteria.add(or);
	}

	@Override
	public void adicionarRestricaoLazy(final Criteria criteria, final FiltroLazy<Vaga> filtro) {

		final Disjunction or = Restrictions.disjunction();

		if (StringUtils.isNotEmpty(filtro.getPalavraChave())) {

			or.add(Restrictions.ilike("sku", filtro.getPalavraChave(), MatchMode.ANYWHERE));

			or.add(Restrictions.ilike("descricao", filtro.getPalavraChave(), MatchMode.ANYWHERE));
		}

		criteria.add(or);
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