package br.com.cvagal.negocio.impl;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import br.com.cvagal.excecoes.NegocioException;
import br.com.cvagal.excecoes.RegistroJaExisteException;
import br.com.cvagal.modelo.Usuario;
import br.com.cvagal.negocio.UsuarioServicoFacade;
import br.com.cvagal.persistencia.UsuarioDAO;
import br.com.cvagal.utilitarios.Transacao;
import br.com.cvagal.utilitarios.criptografia.UtilCriptografia;

/**
 * <p>
 * <b>Título:</b> UsuarioServico.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por implementar a interface responsável pelo facade da entidade <i>Usuario</i>.
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
public class UsuarioServico extends Servico<Usuario> implements UsuarioServicoFacade {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 4170667390899033616L;

	/** Constante REGISTRO_DE_EMAIL_JA_EXISTE. */
	private static final String REGISTRO_DE_EMAIL_JA_EXISTE = "email.existente";

	/** Atributo dao. */
	@Inject
	private UsuarioDAO dao;

	@Override
	public Usuario obterUsuarioPorEmail(String email) {

		return this.getDAO().obterUsuarioPorEmail(email);
	}

	@Override
	@Transacao
	public void salvar(final Usuario usuario) throws NegocioException {

		if (usuario != null && !StringUtils.isEmpty(usuario.getSenha())) {

			if (this.isEmailUsuarioJaExiste(usuario)) {

				throw new RegistroJaExisteException(UsuarioServico.REGISTRO_DE_EMAIL_JA_EXISTE);
			}

			final String senhaCriptografada = UtilCriptografia.obterStringMD5(usuario.getSenha());

			usuario.setSenha(senhaCriptografada);

			this.getDAO().salvar(usuario);
		}
	}

	@Override
	public boolean isEmailUsuarioJaExiste(Usuario usuario) {

		final Usuario usuarioObtido = this.obterUsuarioPorEmail(usuario.getEmail());

		if (usuarioObtido != null) {

			return true;
		}

		return false;
	}

	@Override
	public UsuarioDAO getDAO() {

		return this.dao;
	}
}
