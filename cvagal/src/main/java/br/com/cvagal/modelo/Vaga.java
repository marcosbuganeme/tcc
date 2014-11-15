package br.com.cvagal.modelo;

import java.io.Serializable;

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
public class Vaga implements Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 6658516677796258655L;

	private int id;

	private Double salario;

	private String descricao;

	public Vaga() {

	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param id
	 * @param salario
	 * @param descricao
	 */
	public Vaga( final int id, final Double salario, final String descricao ) {

		this.id = id;

		this.salario = salario;

		this.descricao = descricao;
	}

	/**
	 * Retorna o valor do atributo <code>salario</code>
	 *
	 * @return <code>Double</code>
	 */
	public Double getSalario() {

		return this.salario;
	}

	/**
	 * Define o valor do atributo <code>salario</code>.
	 *
	 * @param salario
	 */
	public void setSalario(final Double salario) {

		this.salario = salario;
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
	 * Retorna o valor do atributo <code>id</code>
	 *
	 * @return <code>int</code>
	 */
	public int getId() {

		return this.id;
	}

}
