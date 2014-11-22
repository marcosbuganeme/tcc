package br.com.cvagal.modelo.impl;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.cvagal.modelo.Entidade;
import br.com.cvagal.modelo.enums.EnumStatus;

/**
 * <p>
 * <b>Título:</b> EntidadeAbstrata.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe abstrata responsável por implementar a interface <code>Entidade</code> e por prover atributos em comuns as demais entidades do modelo.
 * </p>
 *
 * Data de criação: 19/11/2014
 *
 * @author marcosbuganeme
 *
 * @author Leides Rodrigues
 *
 * @version 1.0.0
 */
@MappedSuperclass
public class EntidadeAbstrata implements Entidade {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 3352607351185510548L;

	/** Atributo id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** Atributo status. */
	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private EnumStatus status;

	/** Atributo dataCriacao. */
	@Temporal(TemporalType.DATE)
	@Column(name = "data_criacao", nullable = false, updatable = false)
	private Date dataCriacao;

	/** Atributo dataModificacao. */
	@Temporal(TemporalType.DATE)
	@Column(name = "data_modificacao")
	private Date dataModificacao;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public EntidadeAbstrata() {

	}

	/**
	 * Método responsável por controlar as datas de criação e alteração de um objeto do sistema.
	 *
	 * @author marcosbuganeme
	 *
	 */
	@PrePersist
	@PreUpdate
	private void executar() {

		this.status = EnumStatus.ATIVO;

		if (this.dataCriacao == null) {

			this.dataCriacao = new Date();
		}

		this.dataModificacao = new Date();
	}

	@Override
	public Serializable getIdentificador() {

		return this.id;
	}

	@Override
	public boolean isNovo() {

		return this.getIdentificador() == null;
	}

	/**
	 * Retorna o valor do atributo <code>dataCriacao</code>
	 *
	 * @return <code>Date</code>
	 */
	public Date getDataCriacao() {

		return this.dataCriacao;
	}

	/**
	 * Retorna o valor do atributo <code>dataModificacao</code>
	 *
	 * @return <code>Date</code>
	 */
	public Date getDataModificacao() {

		return this.dataModificacao;
	}

	@Override
	public int hashCode() {

		final int numeroPrimo = 31;

		int resultado = 1;

		resultado = numeroPrimo * resultado + ( ( this.getIdentificador() == null ) ? 0 : this.getIdentificador().hashCode() );

		return resultado;
	}

	@Override
	public boolean equals(final Object obj) {

		if (this == obj) {

			return true;
		}

		if (obj == null) {

			return false;
		}

		if (!( obj instanceof EntidadeAbstrata )) {

			return false;
		}
		final EntidadeAbstrata other = (EntidadeAbstrata) obj;

		if (this.getIdentificador() == null) {

			if (other.getIdentificador() != null) {

				return false;
			}

		} else if (!this.getIdentificador().equals(other.getIdentificador())) {

			return false;
		}

		return true;
	}

}
