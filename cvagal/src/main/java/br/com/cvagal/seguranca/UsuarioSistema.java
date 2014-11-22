package br.com.cvagal.seguranca;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import br.com.cvagal.modelo.Usuario;

/**
 * <p>
 * <b>Título:</b> UsuarioSistema.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por representar o usuário logado do sistema.
 * </p>
 *
 * Data de criação: 07/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class UsuarioSistema extends User {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -2604485583611244745L;

	/** Atributo usuario. */
	private Usuario usuario;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param usuario
	 * 
	 * @param authorities
	 */
	public UsuarioSistema( final Usuario usuario, final Collection<? extends GrantedAuthority> authorities ) {

		super(usuario.getEmail(), usuario.getSenha(), authorities);

		this.usuario = usuario;
	}

	/**
	 * Retorna o valor do atributo <code>usuario</code>
	 *
	 * @return <code>Usuario</code>
	 */
	public Usuario getUsuario() {

		return this.usuario;
	}

}
