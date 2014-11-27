package br.com.cvagal.persistencia.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.cvagal.filtro.FiltroLazy;
import br.com.cvagal.modelo.Entidade;
import br.com.cvagal.modelo.enums.EnumStatus;
import br.com.cvagal.persistencia.DAO;

/**
 * <p>
 * <b>Título:</b> HibernateDAO.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe abstrata responsável por implementar a interface PAI e prover métodos auxiliares para as classes que utilizam o padrão de projeto Repository e DAO.
 * </p>
 *
 * Data de criação: 19/11/2014
 *
 * @author marcosbuganeme
 *
 * @author Leides Rodrigues
 * 
 * @param <E>
 *            - Entidade que será manipulada pela classe concreta.
 *
 * @version 1.0.0
 */
@SuppressWarnings("unchecked")
public abstract class HibernateDAO<E extends Entidade> implements DAO<E> {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -3902070694348708493L;

	/** Atributo entityManager. */
	private EntityManager entityManager;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public HibernateDAO() {

	}

	@Override
	public E obter(final Serializable id) {

		final Class<E> entidadePersistente = this.obterTipoDaEntidade();

		return this.getEntityManager().find(entidadePersistente, id);
	}

	/**
	 * Método responsável por obter uma entidade através de generics.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>{@link Entidade} obtida</i>.
	 */
	private Class<E> obterTipoDaEntidade() {

		final Type[] tipoEntidade = ( (ParameterizedType) this.getClass().getGenericSuperclass() ).getActualTypeArguments();

		return (Class<E>) tipoEntidade[0];
	}

	@Override
	public void salvar(final E entidade) {

		this.getEntityManager().persist(entidade);
	}

	@Override
	public void mesclar(final E entidade) {

		this.getEntityManager().merge(entidade);
	}

	@Override
	public void remover(final E entidade) {

		final E entidadeObtida = this.obter(entidade.getIdentificador());

		if (entidadeObtida != null) {

			this.getEntityManager().remove(entidadeObtida);
		}
	}

	@Override
	public Collection<E> listar() {

		final Criteria criteria = this.obterCriteria();

		return criteria.list();
	}

	@Override
	public List<E> listar(final FiltroLazy<E> filtro) {

		final Criteria criteria = this.obterCriteria();

		criteria.add(Restrictions.eq("status", EnumStatus.ATIVO));

		this.adicionarRestricaoLazy(criteria, filtro);

		criteria.setFirstResult(filtro.getPrimeiroRegistro());

		criteria.setMaxResults(filtro.getQuantidadeRegistroPorPagina());

		this.adicionarPaginacao(criteria, filtro);

		return criteria.list();
	}

	@Override
	public int quantidadeRegistros(final FiltroLazy<E> filtro) {

		final Criteria criteria = this.obterCriteria();

		this.adicionarRestricaoLazy(criteria, filtro);

		criteria.setProjection(Projections.rowCount());

		return ( (Number) criteria.uniqueResult() ).intValue();
	}

	/**
	 * Método responsável por adicionar uma restrição na consulta Lazy da entidade <i>Vaga</i>.
	 *
	 * @author marcosbuganeme
	 *
	 * @param criteria
	 *            - obeto que adiciona a restrição da consulta.
	 * 
	 * @param filtro
	 *            - filtro da consulta.
	 */
	public abstract void adicionarRestricaoLazy(final Criteria criteria, final FiltroLazy<E> filtro);

	/**
	 * Método responsável por adicionar paginação a consulta.
	 *
	 * @author marcosbuganeme
	 *
	 * @param criteria
	 *            - obeto que adiciona a restrição da consulta.
	 * 
	 * @param filtro
	 *            - filtro da consulta.
	 */
	public void adicionarPaginacao(final Criteria criteria, final FiltroLazy<E> filtro) {

		if (filtro.isAscendente() && filtro.getPropriedadeOrdenacao() != null) {

			criteria.addOrder(Order.asc(filtro.getPropriedadeOrdenacao()));

		} else if (filtro.getPropriedadeOrdenacao() != null) {

			criteria.addOrder(Order.desc(filtro.getPropriedadeOrdenacao()));
		}
	}

	/**
	 * Método responsável por obter o criteria para uma entidade utilizando generics.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>criteria da entidade manipulada</i>.
	 */
	protected Criteria obterCriteria() {

		final Class<E> classePersistente = this.obterTipoDaEntidade();

		return this.getSession().createCriteria(classePersistente);
	}

	/**
	 * Retorna o valor do atributo <code>entityManager</code>
	 *
	 * @return <code>EntityManager</code>
	 */
	protected EntityManager getEntityManager() {

		return this.entityManager;
	}

	/**
	 * Retorna o valor do atributo <code>session</code>.
	 *
	 * @return <code>Session</code>.
	 */
	protected Session getSession() {

		return this.getEntityManager().unwrap(Session.class);
	}
}
