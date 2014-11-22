package br.com.cvagal.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.cvagal.modelo.enuns.EnumPermissao;
import br.com.cvagal.modelo.impl.EntidadeAbstrata;

/**
 * <p>
 * <b>Título:</b> Permissao.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por representar a permissão do ator no sistema.
 * </p>
 *
 * Data de criação: 16/11/2014
 *
 * @author marcosbuganeme
 *
 * @author Leides Rodrigues
 *
 * @version 1.0.0
 */
@Entity
@Table(name = "permissao")
public class Permissao extends EntidadeAbstrata {

	/** Constante serialVersionUID. */
	@Transient
	private static final long serialVersionUID = 4168822922840779410L;

	/** Atributo permissao. */
	@Enumerated(EnumType.STRING)
	@Column(name = "permissao", length = 20, nullable = false)
	private EnumPermissao permissao;

	/** Atributo usuario. */
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_usuario", nullable = false, foreignKey = @ForeignKey(name = "FK_USUARIO_PERMISSAO"))
	private Usuario usuario;

	public Permissao() {

	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param usuario
	 * 
	 * @param permissao
	 */
	public Permissao( final Usuario usuario, final EnumPermissao permissao ) {

		this.usuario = usuario;

		this.permissao = permissao;
	}

	/**
	 * Retorna o valor do atributo <code>permissao</code>
	 *
	 * @return <code>EnumPermissao</code>
	 */
	public EnumPermissao getPermissao() {

		return this.permissao;
	}

	/**
	 * Define o valor do atributo <code>permissao</code>.
	 *
	 * @param permissao
	 */
	public void setPermissao(final EnumPermissao permissao) {

		this.permissao = permissao;
	}

	/**
	 * Retorna o valor do atributo <code>usuario</code>
	 *
	 * @return <code>Usuario</code>
	 */
	public Usuario getUsuario() {

		return this.usuario;
	}

	/**
	 * Define o valor do atributo <code>usuario</code>.
	 *
	 * @param usuario
	 */
	public void setUsuario(final Usuario usuario) {

		this.usuario = usuario;
	}
}
