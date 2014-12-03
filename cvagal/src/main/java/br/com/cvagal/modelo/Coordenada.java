package br.com.cvagal.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.cvagal.modelo.impl.EntidadeAbstrata;

/**
 * <p>
 * <b>Título:</b> Coordenada.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por representar a geolocalização de um <code>Endereco</code>.
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
@Table(name = "coordenada")
public class Coordenada extends EntidadeAbstrata {

	/** Constante serialVersionUID. */
	@Transient
	private static final long serialVersionUID = 9071743467043395829L;

	/** Atributo endereco. */
	@NotNull
	@OneToOne(optional = false, targetEntity = Endereco.class)
	@JoinColumn(name = "id_endereco", nullable = false)
	private Endereco endereco;

	/** Atributo latitude. */
	@NotEmpty
	@Column(name = "latitude", nullable = false)
	private String latitude;

	/** Atributo longitude. */
	@NotEmpty
	@Column(name = "longitude", nullable = false)
	private String longitude;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public Coordenada() {

	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param endereco
	 * 
	 * @param latitude
	 * 
	 * @param longitude
	 */
	public Coordenada( final Endereco endereco, final String latitude, final String longitude ) {

		this.endereco = endereco;

		this.latitude = latitude;

		this.longitude = longitude;
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
	 * Retorna o valor do atributo <code>latitude</code>
	 *
	 * @return <code>String</code>
	 */
	public String getLatitude() {

		return this.latitude;
	}

	/**
	 * Define o valor do atributo <code>latitude</code>.
	 *
	 * @param latitude
	 */
	public void setLatitude(final String latitude) {

		this.latitude = latitude;
	}

	/**
	 * Retorna o valor do atributo <code>longitude</code>
	 *
	 * @return <code>String</code>
	 */
	public String getLongitude() {

		return this.longitude;
	}

	/**
	 * Define o valor do atributo <code>longitude</code>.
	 *
	 * @param longitude
	 */
	public void setLongitude(final String longitude) {

		this.longitude = longitude;
	}

}
