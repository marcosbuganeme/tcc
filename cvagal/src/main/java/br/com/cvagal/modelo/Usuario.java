package br.com.cvagal.modelo;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.cvagal.modelo.impl.EntidadeAbstrata;

/**
 * <p>
 * <b>Título:</b> Usuario.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por representar o ator no sistema.
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
@Table(name = "usuario")
public class Usuario extends EntidadeAbstrata {

	/** Constante serialVersionUID. */
	@Transient
	private static final long serialVersionUID = -5455224206513520796L;

	/** Atributo nome. */
	@NotEmpty
	@Column(name = "nome", nullable = false, length = 120)
	private String nome;

	/** Atributo email. */
	@NotEmpty
	@Column(name = "email", nullable = false, length = 100)
	private String email;

	/** Atributo senha. */
	@NotEmpty
	@Column(name = "senha", nullable = false, length = 32)
	private String senha;

	/** Atributo colecaoPermissoes. */
	@OneToMany(mappedBy = "usuario")
	private Collection<Permissao> colecaoPermissoes;

	public Usuario() {

	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param nome
	 * 
	 * @param email
	 * 
	 * @param senha
	 */
	public Usuario( final String nome, final String email, final String senha ) {

		this.nome = nome;

		this.email = email;

		this.senha = senha;
	}

	/**
	 * Retorna o valor do atributo <code>nome</code>
	 *
	 * @return <code>String</code>
	 */
	public String getNome() {

		return this.nome;
	}

	/**
	 * Define o valor do atributo <code>nome</code>.
	 *
	 * @param nome
	 */
	public void setNome(final String nome) {

		this.nome = nome;
	}

	/**
	 * Retorna o valor do atributo <code>email</code>
	 *
	 * @return <code>String</code>
	 */
	public String getEmail() {

		return this.email;
	}

	/**
	 * Define o valor do atributo <code>email</code>.
	 *
	 * @param email
	 */
	public void setEmail(final String email) {

		this.email = email;
	}

	/**
	 * Retorna o valor do atributo <code>senha</code>
	 *
	 * @return <code>String</code>
	 */
	public String getSenha() {

		return this.senha;
	}

	/**
	 * Define o valor do atributo <code>senha</code>.
	 *
	 * @param senha
	 */
	public void setSenha(final String senha) {

		this.senha = senha;
	}

	/**
	 * Retorna o valor do atributo <code>colecaoPermissoes</code>
	 *
	 * @return <code>Collection<Permissao></code>
	 */
	public Collection<Permissao> getColecaoPermissoes() {

		return this.colecaoPermissoes;
	}

	/**
	 * Define o valor do atributo <code>colecaoPermissoes</code>.
	 *
	 * @param colecaoPermissoes
	 */
	public void setColecaoPermissoes(final Collection<Permissao> colecaoPermissoes) {

		this.colecaoPermissoes = colecaoPermissoes;
	}
}
