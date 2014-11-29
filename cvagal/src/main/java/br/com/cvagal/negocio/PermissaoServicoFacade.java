package br.com.cvagal.negocio;

import java.util.Collection;

import br.com.cvagal.modelo.Permissao;
import br.com.cvagal.modelo.Usuario;

/**
 * <p>
 * <b>Título:</b> PermissaoServicoFacade.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Interface responsável por disponibilizar os servicos da entidade <code>Permissao</code> utilizando o padrão de projeto Facade.
 * </p>
 *
 * Data de criação: 27/11/2014
 *
 * @author marcosbuganeme
 *
 * @author Leides Rodrigues
 *
 * @version 1.0.0
 */
public interface PermissaoServicoFacade extends ServicoFacade<Permissao> {

	/**
	 * Método responsável por obter uma coleção de dados de todos os usuários para serem listados em uma comboBox da tela da entidade <code>Permissao</code> ECDU06.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>coleção de usuários</i>
	 */
	Collection<Usuario> listarTodosUsuarios();
}
