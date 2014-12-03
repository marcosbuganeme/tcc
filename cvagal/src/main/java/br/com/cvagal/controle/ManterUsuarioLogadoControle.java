package br.com.cvagal.controle;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.Transient;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import br.com.cvagal.modelo.Permissao;
import br.com.cvagal.modelo.enuns.EnumPermissao;
import br.com.cvagal.seguranca.UsuarioSistema;

/**
 * <p>
 * <b>Título:</b> ManterUsuarioLogadoControle.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por controlar as requisições da tela de <code>Usuario</code> <code>Permissao</code>.
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
@Named
@RequestScoped
public class ManterUsuarioLogadoControle implements Serializable {

	/** Constante serialVersionUID. */
	@Transient
	private static final long serialVersionUID = 6695817819537779743L;

	/**
	 * Método responsável por obter o nome do usuário logado.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>nome do usuário logado</i>.
	 */
	public String getNomeUsuarioLogado() {

		String nomeUsuarioLogado = null;

		final UsuarioSistema usuarioSistema = this.obterUsuarioLogado();

		if (usuarioSistema != null) {

			nomeUsuarioLogado = usuarioSistema.getUsuario().getNome();
		}

		return nomeUsuarioLogado;
	}

	/**
	 * Método responsável por verificar se o usuário logado é do tipo ADMINISTRADOR.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>true, se o usuário for um supervisor</i>.
	 */
	public boolean isSupervisor() {

		final UsuarioSistema user = this.obterUsuarioLogado();

		for (final Permissao permissao : user.getUsuario().getColecaoPermissoes()) {

			if (permissao.getPermissao().equals(EnumPermissao.SUPERVISOR)) {

				return true;
			}
		}

		return false;
	}

	/**
	 * Método responsável por obter o usuário logado no sistema.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>usuário logado</i>.
	 */
	private UsuarioSistema obterUsuarioLogado() {

		UsuarioSistema usuarioSistema = null;

		final UsernamePasswordAuthenticationToken user = (UsernamePasswordAuthenticationToken) FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();

		if (user != null) {

			usuarioSistema = (UsuarioSistema) user.getPrincipal();
		}

		return usuarioSistema;
	}

}
