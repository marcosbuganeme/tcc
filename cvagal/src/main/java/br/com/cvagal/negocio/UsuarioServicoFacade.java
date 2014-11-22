package br.com.cvagal.negocio;

import br.com.cvagal.modelo.Usuario;

/**
 * <p>
 * <b>Título:</b> UsuarioServicoFacade.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Interface responsável por disponibilizar os servicos da entidade <code>Usuario</code> utilizando o padrão de projeto Facade.
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
public interface UsuarioServicoFacade extends ServicoFacade<Usuario> {

	/**
	 * Método responsável por obter um usuário através de seu email.
	 *
	 * @author marcosbuganeme
	 *
	 * @param email
	 *            - filtro da consulta.
	 * 
	 * @return <i>usuário filtrado pelo email</i>.
	 */
	Usuario obterUsuarioPorEmail(final String email);

	/**
	 * Método responsável por verificar se um determinado usuário já existe através de seu e-mail.
	 *
	 * @author marcosbuganeme
	 *
	 * @param usuario
	 *            - filtro da consulta.
	 * 
	 * @return <i>True, email já existe</i>.
	 */
	boolean isEmailUsuarioJaExiste(final Usuario usuario);
}
