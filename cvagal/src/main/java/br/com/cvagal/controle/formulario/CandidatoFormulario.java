package br.com.cvagal.controle.formulario;

import java.util.Collection;

import javax.persistence.Transient;

import br.com.cvagal.modelo.Candidato;
import br.com.cvagal.modelo.Coordenada;
import br.com.cvagal.modelo.Endereco;
import br.com.cvagal.modelo.Telefone;
import br.com.cvagal.visao.formulario.Formulario;

/**
 * <p>
 * <b>Título:</b> CandidatoFormulario.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por conter os atributos em comum da camada de visão da entidade <i>Candidato</i>.
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
public class CandidatoFormulario extends Formulario<Candidato> {

	/** Constante serialVersionUID. */
	@Transient
	private static final long serialVersionUID = 3472546146561514048L;

	/** Atributo endereco. */
	private Endereco endereco;

	/** Atributo telefone. */
	private Telefone telefone;

	/** Atributo colecaoTelefones. */
	private Collection<Telefone> colecaoTelefones;

	/** Atributo coordenada. */
	private Coordenada coordenada;

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
	 * Retorna o valor do atributo <code>coordenada</code>
	 *
	 * @return <code>Coordenada</code>
	 */
	public Coordenada getCoordenada() {

		return this.coordenada;
	}

	/**
	 * Define o valor do atributo <code>coordenada</code>.
	 *
	 * @param coordenada
	 */
	public void setCoordenada(final Coordenada coordenada) {

		this.coordenada = coordenada;
	}

	/**
	 * Retorna o valor do atributo <code>telefone</code>
	 *
	 * @return <code>Telefone</code>
	 */
	public Telefone getTelefone() {

		return this.telefone;
	}

	/**
	 * Define o valor do atributo <code>telefone</code>.
	 *
	 * @param telefone
	 */
	public void setTelefone(final Telefone telefone) {

		this.telefone = telefone;
	}

}
