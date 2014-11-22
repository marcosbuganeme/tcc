package br.com.cvagal.visao.formulario;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.primefaces.model.LazyDataModel;

import br.com.cvagal.filtro.FiltroLazy;
import br.com.cvagal.modelo.Entidade;

/**
 * <p>
 * <b>Título:</b> Formulario.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe abstracta responsável por manter o controle sobre os atributos utilizados na camada de visão.
 * </p>
 *
 * Data de criação: 19/11/2014
 *
 * @author marcosbuganeme
 *
 * @author Leides Rodrigues
 * 
 * @param <E>
 *            - Entidade manipulada pela classe concreta.
 *
 * @version 1.0.0
 */
@SuppressWarnings("unchecked")
public abstract class Formulario<E extends Entidade> implements Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -8214181174304132461L;

	/** Constante LOG. */
	private static final Log LOG = LogFactory.getLog(Formulario.class);

	/** Atributo entidade. */
	private E entidade;

	/** Atributo modelo. */
	private LazyDataModel<E> modelo;

	/** Atributo filtro. */
	private FiltroLazy filtro;

	/** Atributo palavraChave. */
	private String palavraChave;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param classe
	 */
	public Formulario( final Class<E> classe ) {

		try {

			this.entidade = classe.newInstance();

		} catch (InstantiationException | IllegalAccessException exception) {

			Formulario.LOG.error("ERROR na inicialização das variáveis do formulário. CAUSA :::" + exception.getCause() + " ::::: CLASSE RESPONSÁVEL" + this.getClass().getSimpleName());
		}
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public <F> Formulario() {

		try {

			this.entidade = this.obterTipoEntidade().newInstance();

		} catch (InstantiationException | IllegalAccessException exception) {

			Formulario.LOG.error("ERROR na inicialização das variáveis do formulário. CAUSA :::" + exception.getCause() + " ::::: CLASSE RESPONSÁVEL" + this.getClass().getSimpleName());
		}
	}

	/**
	 * Método responsável por obter o tipo da classe que representa a entidade.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>tipo da classe que representa a entidade</i>
	 */
	private Class<E> obterTipoEntidade() {

		final Type[] tipoEntidade = ( (ParameterizedType) this.getClass().getGenericSuperclass() ).getActualTypeArguments();

		return (Class<E>) tipoEntidade[0];
	}

	/**
	 * Retorna o valor do atributo <code>entidade</code>
	 *
	 * @return <code>E</code>
	 */
	public E getEntidade() {

		return this.entidade;
	}

	/**
	 * Define o valor do atributo <code>entidade</code>.
	 *
	 * @param entidade
	 */
	public void setEntidade(final E entidade) {

		this.entidade = entidade;
	}

	/**
	 * Retorna o valor do atributo <code>modelo</code>
	 *
	 * @return <code>LazyDataModel<E></code>
	 */
	public LazyDataModel<E> getModelo() {

		return this.modelo;
	}

	/**
	 * Define o valor do atributo <code>modelo</code>.
	 *
	 * @param modelo
	 */
	public void setModelo(final LazyDataModel<E> modelo) {

		this.modelo = modelo;
	}

	/**
	 * Retorna o valor do atributo <code>filtro</code>
	 *
	 * @return <code>FiltroLazy</code>
	 */
	public FiltroLazy getFiltro() {

		return this.filtro;
	}

	/**
	 * Define o valor do atributo <code>filtro</code>.
	 *
	 * @param filtro
	 */
	public void setFiltro(final FiltroLazy filtro) {

		this.filtro = filtro;
	}

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

}
