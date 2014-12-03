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

import br.com.cvagal.modelo.enuns.EnumTipoTelefone;
import br.com.cvagal.modelo.impl.EntidadeAbstrata;

/**
 * <p>
 * <b>Título:</b> Telefone.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por representar o telefone do candidato no sistema.
 * </p>
 *
 * Data de criação: 30/11/2014
 *
 * @author marcosbuganeme
 *
 * @author Leides Rodrigues
 *
 * @version 1.0.0
 */
@Entity
@Table(name = "telefone")
public class Telefone extends EntidadeAbstrata {

	/** Constante serialVersionUID. */
	@Transient
	private static final long serialVersionUID = -5928223745973591880L;

	/** Atributo candidato. */
	@ManyToOne(optional = false, targetEntity = Candidato.class)
	@JoinColumn(name = "id_candidato", foreignKey = @ForeignKey(name = "FK_TB_TELEFONE_CANDIDATO"), nullable = false)
	private Candidato candidato;

	/** Atributo ddd. */
	@Column(name = "ddd", length = 3, nullable = false)
	private String ddd;

	/** Atributo tipoTelefone. */
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_telefone", length = 20, nullable = false)
	private EnumTipoTelefone tipoTelefone;

	/** Atributo numero. */
	@Column(name = "numero", length = 9, nullable = false)
	private String numero;

	public Telefone() {

	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param candidato
	 * 
	 * @param ddd
	 * 
	 * @param tipoTelefone
	 * 
	 * @param numero
	 */
	public Telefone( final Candidato candidato, final String ddd, final EnumTipoTelefone tipoTelefone, final String numero ) {

		this.candidato = candidato;

		this.ddd = ddd;

		this.tipoTelefone = tipoTelefone;

		this.numero = numero;
	}

	/**
	 * Retorna o valor do atributo <code>candidato</code>
	 *
	 * @return <code>Candidato</code>
	 */
	public Candidato getCandidato() {

		return this.candidato;
	}

	/**
	 * Define o valor do atributo <code>candidato</code>.
	 *
	 * @param candidato
	 */
	public void setCandidato(final Candidato candidato) {

		this.candidato = candidato;
	}

	/**
	 * Retorna o valor do atributo <code>ddd</code>
	 *
	 * @return <code>String</code>
	 */
	public String getDdd() {

		return this.ddd;
	}

	/**
	 * Define o valor do atributo <code>ddd</code>.
	 *
	 * @param ddd
	 */
	public void setDdd(final String ddd) {

		this.ddd = ddd;
	}

	/**
	 * Retorna o valor do atributo <code>tipoTelefone</code>
	 *
	 * @return <code>EnumTipoTelefone</code>
	 */
	public EnumTipoTelefone getTipoTelefone() {

		return this.tipoTelefone;
	}

	/**
	 * Define o valor do atributo <code>tipoTelefone</code>.
	 *
	 * @param tipoTelefone
	 */
	public void setTipoTelefone(final EnumTipoTelefone tipoTelefone) {

		this.tipoTelefone = tipoTelefone;
	}

	/**
	 * Retorna o valor do atributo <code>numero</code>
	 *
	 * @return <code>String</code>
	 */
	public String getNumero() {

		return this.numero;
	}

	/**
	 * Define o valor do atributo <code>numero</code>.
	 *
	 * @param numero
	 */
	public void setNumero(final String numero) {

		this.numero = numero;
	}

}
