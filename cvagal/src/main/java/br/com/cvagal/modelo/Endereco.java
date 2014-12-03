package br.com.cvagal.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.cvagal.modelo.impl.EntidadeAbstrata;

@Entity
@Table(name = "endereco")
@XmlRootElement(name = "webservicecep")
public class Endereco extends EntidadeAbstrata {

	/** Constante serialVersionUID. */
	@Transient
	private static final long serialVersionUID = -5976802862924548859L;

	/** Atributo candidato. */
	@OneToOne(optional = false, targetEntity = Candidato.class)
	@JoinColumn(name = "id_candidato", foreignKey = @ForeignKey(name = "FK_TB_ENDERECO_CANDIDATO"), nullable = false)
	private Candidato candidato;

	/** Atributo coordenada. */
	@OneToOne(mappedBy = "endereco")
	private Coordenada coordenada;

	/** Atributo uf. */
	@Column(name = "uf", nullable = false)
	private String uf;

	/** Atributo estado. */
	@Column(name = "estado", nullable = false)
	private String estado;

	/** Atributo cidade. */
	@Column(name = "cidade", nullable = false)
	private String cidade;

	/** Atributo bairro. */
	@Column(name = "bairro", nullable = false)
	private String bairro;

	/** Atributo logradouro. */
	@Column(name = "logradouro", nullable = false)
	private String logradouro;

	/** Atributo logradouro_curto. */
	@Column(name = "logradouro_curto", nullable = false)
	private String logradouro_curto;

	/** Atributo numero. */
	@Column(name = "numero")
	private int numero;

	/** Atributo complemento. */
	@Column(name = "complemento")
	private String complemento;

	/** Atributo cep. */
	@Column(name = "cep")
	private String cep;

	/** Atributo resultado_txt. */
	@Column(name = "resultado_txt")
	private String resultado_txt;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public Endereco() {

	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param candidato
	 * 
	 * @param cep
	 * 
	 * @param coordenada
	 */
	public Endereco( final Candidato candidato, final String cep, final Coordenada coordenada ) {

		this.candidato = candidato;

		this.cep = cep;

		this.coordenada = coordenada;
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
	 * Retorna o valor do atributo <code>uf</code>
	 *
	 * @return <code>String</code>
	 */
	public String getUf() {

		return this.uf;
	}

	/**
	 * Define o valor do atributo <code>uf</code>.
	 *
	 * @param uf
	 */
	public void setUf(final String uf) {

		this.uf = uf;
	}

	/**
	 * Retorna o valor do atributo <code>estado</code>
	 *
	 * @return <code>String</code>
	 */
	public String getEstado() {

		return this.estado;
	}

	/**
	 * Define o valor do atributo <code>estado</code>.
	 *
	 * @param estado
	 */
	public void setEstado(final String estado) {

		this.estado = estado;
	}

	/**
	 * Retorna o valor do atributo <code>cidade</code>
	 *
	 * @return <code>String</code>
	 */
	public String getCidade() {

		return this.cidade;
	}

	/**
	 * Define o valor do atributo <code>cidade</code>.
	 *
	 * @param cidade
	 */
	public void setCidade(final String cidade) {

		this.cidade = cidade;
	}

	/**
	 * Retorna o valor do atributo <code>bairro</code>
	 *
	 * @return <code>String</code>
	 */
	public String getBairro() {

		return this.bairro;
	}

	/**
	 * Define o valor do atributo <code>bairro</code>.
	 *
	 * @param bairro
	 */
	public void setBairro(final String bairro) {

		this.bairro = bairro;
	}

	/**
	 * Retorna o valor do atributo <code>logradouro</code>
	 *
	 * @return <code>String</code>
	 */
	public String getLogradouro() {

		return this.logradouro;
	}

	/**
	 * Define o valor do atributo <code>logradouro</code>.
	 *
	 * @param logradouro
	 */
	public void setLogradouro(final String logradouro) {

		this.logradouro = logradouro;
	}

	/**
	 * Retorna o valor do atributo <code>logradouro_curto</code>
	 *
	 * @return <code>String</code>
	 */
	public String getLogradouro_curto() {

		return this.logradouro_curto;
	}

	/**
	 * Define o valor do atributo <code>logradouro_curto</code>.
	 *
	 * @param logradouro_curto
	 */
	public void setLogradouro_curto(final String logradouro_curto) {

		this.logradouro_curto = logradouro_curto;
	}

	/**
	 * Retorna o valor do atributo <code>numero</code>
	 *
	 * @return <code>int</code>
	 */
	public int getNumero() {

		return this.numero;
	}

	/**
	 * Define o valor do atributo <code>numero</code>.
	 *
	 * @param numero
	 */
	public void setNumero(final int numero) {

		this.numero = numero;
	}

	/**
	 * Retorna o valor do atributo <code>complemento</code>
	 *
	 * @return <code>String</code>
	 */
	public String getComplemento() {

		return this.complemento;
	}

	/**
	 * Define o valor do atributo <code>complemento</code>.
	 *
	 * @param complemento
	 */
	public void setComplemento(final String complemento) {

		this.complemento = complemento;
	}

	/**
	 * Retorna o valor do atributo <code>cep</code>
	 *
	 * @return <code>String</code>
	 */
	public String getCep() {

		return this.cep;
	}

	/**
	 * Define o valor do atributo <code>cep</code>.
	 *
	 * @param cep
	 */
	public void setCep(final String cep) {

		this.cep = cep;
	}

	/**
	 * Retorna o valor do atributo <code>resultado_txt</code>
	 *
	 * @return <code>String</code>
	 */
	public String getResultado_txt() {

		return this.resultado_txt;
	}

	/**
	 * Define o valor do atributo <code>resultado_txt</code>.
	 *
	 * @param resultado_txt
	 */
	public void setResultado_txt(final String resultado_txt) {

		this.resultado_txt = resultado_txt;
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

}
