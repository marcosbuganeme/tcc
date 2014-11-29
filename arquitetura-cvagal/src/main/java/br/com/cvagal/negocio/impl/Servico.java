package br.com.cvagal.negocio.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.cvagal.excecoes.RegistroNaoExisteException;
import br.com.cvagal.filtro.FiltroLazy;
import br.com.cvagal.modelo.Entidade;
import br.com.cvagal.negocio.ServicoFacade;
import br.com.cvagal.persistencia.DAO;
import br.com.cvagal.utilitarios.Transacao;

/**
 * <p>
 * <b>Título:</b> Servico.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe abstrata responsável por implementar a interface PAI de Servico e prover métodos auxiliares para as classes que utilizam o padrão de projeto FACADE.
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
public abstract class Servico<E extends Entidade> implements ServicoFacade<E> {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -2115726914896345572L;

	/** Constante LOG. */
	private static final Log LOG = LogFactory.getLog(Servico.class);

	/** Constante MENSAGEM_REGISTRO_NAO_EXISTE. */
	private static final String MENSAGEM_REGISTRO_NAO_EXISTE = "registro.nao.existe";

	/**
	 * Método responsável por obter o dao da entidade manipulada.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>o dao da entidade manipulada</i>.
	 */
	public abstract DAO<E> getDAO();

	@Override
	public E obter(final Serializable id) {

		final E entidadeObtida = this.getDAO().obter(id);

		if (entidadeObtida == null) {

			Servico.LOG.error("Registro não encontrado");

			throw new RegistroNaoExisteException(Servico.MENSAGEM_REGISTRO_NAO_EXISTE);
		}

		return entidadeObtida;
	}

	@Override
	@Transacao
	public void salvar(final E entidade) {

		if (entidade != null) {

			this.getDAO().salvar(entidade);
		}
	}

	@Override
	@Transacao
	public void mesclar(final E entidade) {

		if (entidade != null) {

			this.getDAO().mesclar(entidade);
		}
	}

	@Override
	@Transacao
	public void remover(final E entidade) {

		if (entidade != null) {

			this.getDAO().remover(entidade);
		}
	}

	@Override
	public Collection<E> listar() {

		return this.getDAO().listar();
	}

	@Override
	public List<E> listar(final FiltroLazy<E> filtro) {

		return this.getDAO().listar(filtro);
	}

	@Override
	public int quantidadeRegistros(final FiltroLazy<E> filtro) {

		return this.getDAO().quantidadeRegistros(filtro);
	}
}
