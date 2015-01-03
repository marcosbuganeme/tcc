package br.com.cvagal.modelo;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.cvagal.modelo.impl.EntidadeAbstrata;

/**
 * <p>
 * <b>Título:</b> Candidato.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por conter as caracteristicas do candidato que irá concorrer a uma vaga.
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
@Entity
@Table(name = "candidato")
@XmlRootElement(name = "candidato")
public class Candidato extends EntidadeAbstrata {

	/** Constante serialVersionUID. */
	@Transient
	private static final long serialVersionUID = 807427412200657431L;

	/** Atributo vaga. */
	@ManyToMany(mappedBy = "colecaoCandidatos")
	private Collection<Vaga> colecaoVagas;

	/** Atributo endereco. */
	@OneToOne(mappedBy = "candidato")
	private Endereco endereco;

	/** Atributo colecaoTelefones. */
	@OneToMany(mappedBy = "candidato")
	private Collection<Telefone> colecaoTelefones;

	/** Atributo nome. */
	@Column(name = "nome")
	private String nome;

	/** Atributo dataNascimento. */
	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento", nullable = false)
	private Date dataNascimento;

	/** Atributo cpf. */
	@Column(name = "cpf", length = 14, nullable = false)
	private String cpf;

	/** Atributo curriculo. */
	@Lob
	@Column(name = "curriculo")
	private byte[] curriculo;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public Candidato() {

	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param endereco
	 * 
	 * @param nome
	 * 
	 * @param dataNascimento
	 * 
	 * @param cpf
	 */
	public Candidato( final Endereco endereco, final String nome, final Date dataNascimento, final String cpf ) {

		this.endereco = endereco;

		this.nome = nome;

		this.dataNascimento = dataNascimento;

		this.cpf = cpf;
	}

	/**
	 * Retorna o valor do atributo <code>colecaoVagas</code>
	 *
	 * @return <code>Collection<Vaga></code>
	 */
	public Collection<Vaga> getColecaoVagas() {

		return this.colecaoVagas;
	}

	/**
	 * Define o valor do atributo <code>colecaoVagas</code>.
	 *
	 * @param colecaoVagas
	 */
	public void setColecaoVagas(final Collection<Vaga> colecaoVagas) {

		this.colecaoVagas = colecaoVagas;
	}

	/**
	 * Retorna o valor do atributo <code>endereco</code>
	 *
	 * @return <code>Endereco</code>
	 */
	public Endereco getEndereco() {

		return this.endereco;
	}

	/**
	 * Define o valor do atributo <code>endereco</code>.
	 *
	 * @param endereco
	 */
	public void setEndereco(final Endereco endereco) {

		this.endereco = endereco;
	}

	/**
	 * Retorna o valor do atributo <code>colecaoTelefones</code>
	 *
	 * @return <code>Collection<Telefone></code>
	 */
	public Collection<Telefone> getColecaoTelefones() {

		return this.colecaoTelefones;
	}

	/**
	 * Define o valor do atributo <code>colecaoTelefones</code>.
	 *
	 * @param colecaoTelefones
	 */
	public void setColecaoTelefones(final Collection<Telefone> colecaoTelefones) {

		this.colecaoTelefones = colecaoTelefones;
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
	 * Retorna o valor do atributo <code>dataNascimento</code>
	 *
	 * @return <code>Date</code>
	 */
	public Date getDataNascimento() {

		return this.dataNascimento;
	}

	/**
	 * Define o valor do atributo <code>dataNascimento</code>.
	 *
	 * @param dataNascimento
	 */
	public void setDataNascimento(final Date dataNascimento) {

		this.dataNascimento = dataNascimento;
	}

	/**
	 * Retorna o valor do atributo <code>cpf</code>
	 *
	 * @return <code>String</code>
	 */
	public String getCpf() {

		return this.cpf;
	}

	/**
	 * Define o valor do atributo <code>cpf</code>.
	 *
	 * @param cpf
	 */
	public void setCpf(final String cpf) {

		this.cpf = cpf;
	}

	/**
	 * Retorna o valor do atributo <code>curriculo</code>
	 *
	 * @return <code>byte[]</code>
	 */
	public byte[] getCurriculo() {

		return this.curriculo;
	}

	/**
	 * Define o valor do atributo <code>curriculo</code>.
	 *
	 * @param curriculo
	 */
	public void setCurriculo(final byte[] curriculo) {

		this.curriculo = curriculo;
	}

}
