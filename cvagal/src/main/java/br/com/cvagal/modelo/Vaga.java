package br.com.cvagal.modelo;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.cvagal.modelo.enuns.EnumTipoProfissional;
import br.com.cvagal.modelo.impl.EntidadeAbstrata;

/**
 * <p>
 * <b>Título:</b> Vaga.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por conter as caracteristicas de uma vaga.
 * </p>
 *
 * Data de criação: 15/11/2014
 *
 * @author marcosbuganeme
 *
 * @author Leides Rodrigues
 *
 * @version 1.0.0
 */
@Entity
@Table(name = "vaga")
public class Vaga extends EntidadeAbstrata {

	/** Constante serialVersionUID. */
	@Transient
	private static final long serialVersionUID = 6658516677796258655L;

	/** Atributo empresa. */
	@NotNull
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_empresa", foreignKey = @ForeignKey(name = "FK_EMPRESA_TB_VAGA"))
	private Empresa empresa;

	/** Atributo colecaoCandidatos. */
	@ManyToMany
	@JoinTable(name = "inscricao", joinColumns = @JoinColumn(name = "id_vaga"), inverseJoinColumns = @JoinColumn(name = "id_candidato"))
	private Collection<Candidato> colecaoCandidatos;

	/** Atributo sku. */
	@NotEmpty
	@Column(name = "sku", nullable = false, length = 10)
	private String sku;

	/** Atributo tipoProfissional. */
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "perfil_profissao", length = 40)
	private EnumTipoProfissional tipoProfissional;

	/** Atributo descricao. */
	@NotEmpty
	@Column(name = "descricao", nullable = false, length = 100)
	private String descricao;

	/** Atributo salario. */
	@NotNull
	@Column(name = "salario", nullable = false, precision = 8, scale = 2)
	private BigDecimal salario;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public Vaga() {

	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param empresa
	 * 
	 * @param sku
	 * 
	 * @param tipoProfissional
	 * 
	 * @param descricao
	 * 
	 * @param salario
	 */
	public Vaga( final Empresa empresa, final String sku, final EnumTipoProfissional tipoProfissional, final String descricao, final BigDecimal salario ) {

		this.empresa = empresa;

		this.sku = sku;

		this.tipoProfissional = tipoProfissional;

		this.descricao = descricao;

		this.salario = salario;
	}

	/**
	 * Retorna o valor do atributo <code>sku</code>
	 *
	 * @return <code>String</code>
	 */
	public String getSku() {

		return this.sku;
	}

	/**
	 * Define o valor do atributo <code>sku</code>.
	 *
	 * @param sku
	 */
	public void setSku(final String sku) {

		this.sku = sku;
	}

	/**
	 * Retorna o valor do atributo <code>descricao</code>
	 *
	 * @return <code>String</code>
	 */
	public String getDescricao() {

		return this.descricao;
	}

	/**
	 * Define o valor do atributo <code>descricao</code>.
	 *
	 * @param descricao
	 */
	public void setDescricao(final String descricao) {

		this.descricao = descricao;
	}

	/**
	 * Retorna o valor do atributo <code>salario</code>
	 *
	 * @return <code>BigDecimal</code>
	 */
	public BigDecimal getSalario() {

		return this.salario;
	}

	/**
	 * Define o valor do atributo <code>salario</code>.
	 *
	 * @param salario
	 */
	public void setSalario(final BigDecimal salario) {

		this.salario = salario;
	}

	/**
	 * Retorna o valor do atributo <code>empresa</code>
	 *
	 * @return <code>Empresa</code>
	 */
	public Empresa getEmpresa() {

		return this.empresa;
	}

	/**
	 * Define o valor do atributo <code>empresa</code>.
	 *
	 * @param empresa
	 */
	public void setEmpresa(final Empresa empresa) {

		this.empresa = empresa;
	}

	/**
	 * Retorna o valor do atributo <code>colecaoCandidatos</code>
	 *
	 * @return <code>Collection<Candidato></code>
	 */
	public Collection<Candidato> getColecaoCandidatos() {

		return this.colecaoCandidatos;
	}

	/**
	 * Define o valor do atributo <code>colecaoCandidatos</code>.
	 *
	 * @param colecaoCandidatos
	 */
	public void setColecaoCandidatos(final Collection<Candidato> colecaoCandidatos) {

		this.colecaoCandidatos = colecaoCandidatos;
	}

	/**
	 * Retorna o valor do atributo <code>tipoProfissional</code>
	 *
	 * @return <code>EnumTipoProfissional</code>
	 */
	public EnumTipoProfissional getTipoProfissional() {

		return this.tipoProfissional;
	}

	/**
	 * Define o valor do atributo <code>tipoProfissional</code>.
	 *
	 * @param tipoProfissional
	 */
	public void setTipoProfissional(final EnumTipoProfissional tipoProfissional) {

		this.tipoProfissional = tipoProfissional;
	}

}
