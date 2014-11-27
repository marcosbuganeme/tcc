package br.com.cvagal.filtro;

import java.io.Serializable;

import br.com.cvagal.modelo.Entidade;

/**
 * <p>
 * <b>Título:</b> FiltroLazy.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por controlar a consulta de dados de uma dataTable.
 * </p>
 *
 * Data de criação: 17/11/2014
 *
 * @author marcosbuganeme
 *
 * @author Leides Rodrigues
 *
 * @version 1.0.0
 */
public class FiltroLazy<E extends Entidade> implements Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -1642456600723662156L;

	/** Atributo palavraChave. */
	private String palavraChave;

	/** Atributo objetoFiltro. */
	private E objetoFiltro;

	/** Atributo primeiroRegistro. */
	private int primeiroRegistro;

	/** Atributo quantidadeRegistroPorPagina. */
	private int quantidadeRegistroPorPagina;

	/** Atributo propriedadeOrdenacao. */
	private String propriedadeOrdenacao;

	/** Atributo isAscendente. */
	private boolean isAscendente;

	/**
	 * Retorna o valor do atributo <code>palavraChave</code>
	 *
	 * @return <code>String</code>
	 */
	public String getPalavraChave() {

		return this.palavraChave;
	}

	/**
	 * Define o valor do atributo <code>palavraChave</code>.
	 *
	 * @param palavraChave
	 */
	public void setPalavraChave(final String palavraChave) {

		this.palavraChave = palavraChave;
	}

	/**
	 * Retorna o valor do atributo <code>primeiroRegistro</code>
	 *
	 * @return <code>int</code>
	 */
	public int getPrimeiroRegistro() {

		return this.primeiroRegistro;
	}

	/**
	 * Define o valor do atributo <code>primeiroRegistro</code>.
	 *
	 * @param primeiroRegistro
	 */
	public void setPrimeiroRegistro(final int primeiroRegistro) {

		this.primeiroRegistro = primeiroRegistro;
	}

	/**
	 * Retorna o valor do atributo <code>quantidadeRegistroPorPagina</code>
	 *
	 * @return <code>int</code>
	 */
	public int getQuantidadeRegistroPorPagina() {

		return this.quantidadeRegistroPorPagina;
	}

	/**
	 * Define o valor do atributo <code>quantidadeRegistroPorPagina</code>.
	 *
	 * @param quantidadeRegistroPorPagina
	 */
	public void setQuantidadeRegistroPorPagina(final int quantidadeRegistroPorPagina) {

		this.quantidadeRegistroPorPagina = quantidadeRegistroPorPagina;
	}

	/**
	 * Retorna o valor do atributo <code>propriedadeOrdenacao</code>
	 *
	 * @return <code>String</code>
	 */
	public String getPropriedadeOrdenacao() {

		return this.propriedadeOrdenacao;
	}

	/**
	 * Define o valor do atributo <code>propriedadeOrdenacao</code>.
	 *
	 * @param propriedadeOrdenacao
	 */
	public void setPropriedadeOrdenacao(final String propriedadeOrdenacao) {

		this.propriedadeOrdenacao = propriedadeOrdenacao;
	}

	/**
	 * Retorna o valor do atributo <code>isAscendente</code>
	 *
	 * @return <code>boolean</code>
	 */
	public boolean isAscendente() {

		return this.isAscendente;
	}

	/**
	 * Define o valor do atributo <code>isAscendente</code>.
	 *
	 * @param isAscendente
	 */
	public void setAscendente(final boolean isAscendente) {

		this.isAscendente = isAscendente;
	}

	/**
	 * Retorna o valor do atributo <code>objetoFiltro</code>
	 *
	 * @return <code>E</code>
	 */
	public E getObjetoFiltro() {

		return this.objetoFiltro;
	}

	/**
	 * Define o valor do atributo <code>objetoFiltro</code>.
	 *
	 * @param objetoFiltro
	 */
	public void setObjetoFiltro(final E objetoFiltro) {

		this.objetoFiltro = objetoFiltro;
	}

}
