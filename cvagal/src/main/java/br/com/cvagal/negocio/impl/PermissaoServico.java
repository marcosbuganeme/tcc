package br.com.cvagal.negocio.impl;

import java.util.Collection;

import javax.inject.Inject;

import br.com.cvagal.modelo.Permissao;
import br.com.cvagal.modelo.Usuario;
import br.com.cvagal.negocio.PermissaoServicoFacade;
import br.com.cvagal.persistencia.PermissaoDAO;
import br.com.cvagal.persistencia.UsuarioDAO;

/**
 * <p>
 * <b>Título:</b> PermissaoServico.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por implementar a interface responsável pelo facade da entidade <i>Permissao</i>.
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
public class PermissaoServico extends Servico<Permissao> implements PermissaoServicoFacade {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -4871974995384817618L;

	/** Atributo dao. */
	@Inject
	private PermissaoDAO dao;

	/** Atributo usuarioDAO. */
	@Inject
	private UsuarioDAO usuarioDAO;

	@Override
	public Collection<Usuario> listarTodosUsuarios() {

		return this.usuarioDAO.listar();
	}

	@Override
	public PermissaoDAO getDAO() {

		return this.dao;
	}
}
