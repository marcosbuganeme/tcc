package br.com.cvagal.controle.formulario;

import br.com.cvagal.modelo.Vaga;
import br.com.cvagal.modelo.enuns.EnumTipoProfissional;
import br.com.cvagal.visao.formulario.Formulario;

/**
 * <p>
 * <b>Título:</b> VagaFormulario.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por conter os atributos em comum da camada de visão da entidade <i>Vaga</i>.
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
public class VagaFormulario extends Formulario<Vaga> {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 2755902946593533095L;

	/** Atributo palavraChave. */
	private String palavraChave;

	/** Atributo tipoProfissional. */
	private EnumTipoProfissional tipoProfissional;

	/**
	 * Retorna o valor do atributo <code>palavraChave</code>
	 *
	 * @return <code>String</code>
	 */
	@Override
	public String getPalavraChave() {

		return this.palavraChave;
	}

	/**
	 * Define o valor do atributo <code>palavraChave</code>.
	 *
	 * @param palavraChave
	 */
	@Override
	public void setPalavraChave(final String palavraChave) {

		this.palavraChave = palavraChave;
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
