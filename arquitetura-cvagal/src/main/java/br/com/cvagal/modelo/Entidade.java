package br.com.cvagal.modelo;

import java.io.Serializable;

/**
 * <p>
 * <b>Título:</b> Entidade.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Interface pai de todas as entidades.
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
public interface Entidade extends Serializable {

	/**
	 * Método responsável por obter o identificador de uma entidade.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>identificador da entidade</i>.
	 */
	Serializable getIdentificador();

	/**
	 * Método responsável por verificar se um objeto é ou não novo.<br>
	 * 
	 * A verificação consiste na existencia de valor do id do objeto, se o id tiver algum valor, o objeto é antigo, caso contrário é novo.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>True, se o objeto for novo</i>.
	 */
	boolean isNovo();
}
