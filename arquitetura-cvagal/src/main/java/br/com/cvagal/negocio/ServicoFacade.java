package br.com.cvagal.negocio;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import br.com.cvagal.filtro.FiltroLazy;
import br.com.cvagal.modelo.Entidade;

/**
 * <p>
 * <b>Título:</b> ServicoFacade.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Interface pai de todas as classes de serviço.
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
public interface ServicoFacade<E extends Entidade> extends Serializable {

	/**
	 * Método responsável por obter uma entidade através de seu identificador.
	 *
	 * @author marcosbuganeme
	 *
	 * @param id
	 *            - identificador da entidade.
	 * 
	 * @return <i>entidade pesquisada</i>.
	 */
	E obter(final Serializable id);

	/**
	 * Método responsável por salvar uma entidade.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que sofrerá a ação.
	 */
	void salvar(final E entidade);

	/**
	 * Método responsável por mesclar { SALVAR ou ALTERAR } uma entidade.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que sofrerá a ação.
	 */
	void mesclar(final E entidade);

	/**
	 * Método responsável por remover uma entidade.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que sofrerá a ação.
	 */
	void remover(final E entidade);

	/**
	 * Método responsável por obter todos os registros da entidade do tipo da coleção.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>coleção de dados da entidade</i>.
	 */
	Collection<E> listar();

	/**
	 * Método responsável por listar uma entidade com o designer pattern lazy.
	 *
	 * @author marcosbuganeme
	 *
	 * @param filtro
	 *            - objeto que irá filtrar os dados.
	 *
	 * @return <i>lista de dados da entidade</i>.
	 */
	List<E> listar(final FiltroLazy<E> filtro);

	/**
	 * Método responsável por obter a quantidade de registros na consulta.
	 *
	 * @author marcosbuganeme
	 *
	 * @param filtro
	 *            - objeto filtro da consulta.
	 * 
	 * @return <i>quantidade de registros</i>.
	 */
	int quantidadeRegistros(final FiltroLazy<E> filtro);
}
