package br.com.cvagal.modelo;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.cvagal.modelo.enuns.EnumEspecialidadeMercado;
import br.com.cvagal.modelo.impl.EntidadeAbstrata;

/**
 * <p>
 * <b>Título:</b> Empresa.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por representar as empresas que serão parceiras do portal no sistema.
 * </p>
 *
 * Data de criação: 28/11/2014
 *
 * @author marcosbuganeme
 *
 * @author Leides Rodrigues
 *
 * @version 1.0.0
 */
@Entity
@Table(name = "empresa")
public class Empresa extends EntidadeAbstrata {

	/** Constante serialVersionUID. */
	@Transient
	private static final long serialVersionUID = -2291253854788346372L;

	/** Atributo nome. */
	@NotEmpty
	@Column(name = "nome", length = 150, nullable = false)
	private String nome;

	@NotEmpty
	@Column(name = "cnpj", length = 18, nullable = false)
	private String cnpj;

	@Enumerated(EnumType.STRING)
	@Column(name = "especialidade", length = 40, nullable = false)
	private EnumEspecialidadeMercado especialidade;

	/** Atributo colecaoVagas. */
	@OneToMany(mappedBy = "empresa")
	private Collection<Vaga> colecaoVagas;

	public Empresa() {

	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param nome
	 * 
	 * @param cnpj
	 * 
	 * @param especialidade
	 */
	public Empresa( final String nome, final String cnpj, final EnumEspecialidadeMercado especialidade ) {

		this.nome = nome;

		this.cnpj = cnpj;

		this.especialidade = especialidade;
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
	 * Retorna o valor do atributo <code>especialidade</code>
	 *
	 * @return <code>EnumEspecialidadeMercado</code>
	 */
	public EnumEspecialidadeMercado getEspecialidade() {

		return this.especialidade;
	}

	/**
	 * Define o valor do atributo <code>especialidade</code>.
	 *
	 * @param especialidade
	 */
	public void setEspecialidade(final EnumEspecialidadeMercado especialidade) {

		this.especialidade = especialidade;
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
	 * Retorna o valor do atributo <code>cnpj</code>
	 *
	 * @return <code>String</code>
	 */
	public String getCnpj() {

		return this.cnpj;
	}

	/**
	 * Define o valor do atributo <code>cnpj</code>.
	 *
	 * @param cnpj
	 */
	public void setCnpj(final String cnpj) {

		this.cnpj = cnpj;
	}

}
