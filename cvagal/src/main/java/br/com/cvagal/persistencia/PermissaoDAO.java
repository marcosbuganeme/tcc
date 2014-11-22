package br.com.cvagal.persistencia;

import java.io.Serializable;
import java.util.Collection;

import br.com.cvagal.modelo.Permissao;

/**
 * <p>
 * <b>Título:</b> PermissaoDAO.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Interface responsável pelo repositório da entidade <i>Permissao</i>.
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
public interface PermissaoDAO extends DAO<Permissao> {

	/**
	 * Método responsável por obter uma coleção de permissões de um determinado usuário através de seu identificador.
	 *
	 * @author marcosbuganeme
	 *
	 * @param idUsuario
	 *            - identificador unico do usuário.
	 * 
	 * @return <i>coleção de permissões vinculadas ao usuário filtrado</i>.
	 */
	Collection<Permissao> obterPermissaoPorUsuario(final Serializable idUsuario);
}
