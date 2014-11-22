package br.com.cvagal.persistencia;

import br.com.cvagal.modelo.Usuario;

/**
 * <p>
 * <b>Título:</b> UsuarioDAO.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Interface responsável pelo repositório da entidade <i>Usuario</i>.
 * </p>
 *
 * Data de criação: 18/11/2014
 *
 * @author marcosbuganeme
 *
 * @author Leides Rodrigues
 *
 * @version 1.0.0
 */
public interface UsuarioDAO extends DAO<Usuario> {

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
}
