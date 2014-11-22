package br.com.cvagal.seguranca;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.cvagal.modelo.Permissao;
import br.com.cvagal.modelo.Usuario;
import br.com.cvagal.persistencia.PermissaoDAO;
import br.com.cvagal.persistencia.UsuarioDAO;
import br.com.cvagal.utilitarios.cdi.CDIServiceLocator;

/**
 * <p>
 * <b>Título:</b> AppUserDetailsService.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por realizar a autenticação do usuário no sistema.
 * </p>
 *
 * Data de criação: 06/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class UsuarioLogadoService implements UserDetailsService {

	/** Atributo usuarioDAO. */
	private UsuarioDAO usuarioDAO;

	/** Atributo permissaoDAO. */
	private PermissaoDAO permissaoDAO;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public UsuarioLogadoService() {

		this.usuarioDAO = CDIServiceLocator.getBean(UsuarioDAO.class);

		this.permissaoDAO = CDIServiceLocator.getBean(PermissaoDAO.class);
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {

		final Usuario usuario = this.usuarioDAO.obterUsuarioPorEmail(email);

		final Collection<Permissao> colecaoPermissaoUsuario = this.permissaoDAO.obterPermissaoPorUsuario(usuario.getIdentificador());

		usuario.setColecaoPermissoes(colecaoPermissaoUsuario);

		UsuarioSistema usuarioLogado = null;

		if (usuario != null) {

			usuarioLogado = new UsuarioSistema(usuario, this.getPermissoes(usuario));
		}

		return usuarioLogado;
	}

	/**
	 * Método responsável por obter as permissões vinculadas a um usuário.
	 *
	 * @author marcosbuganeme
	 *
	 * @param usuario
	 *            - usuário que será verificado.
	 * 
	 * @return <i>coleção de permissões vinculadas ao usuário</i>.
	 */
	private Collection<? extends GrantedAuthority> getPermissoes(final Usuario usuario) {

		final List<SimpleGrantedAuthority> colecaoPermissoes = new ArrayList<SimpleGrantedAuthority>();

		for (final Permissao permissao : usuario.getColecaoPermissoes()) {

			colecaoPermissoes.add(new SimpleGrantedAuthority(permissao.getPermissao().toString()));
		}

		return colecaoPermissoes;
	}
}
