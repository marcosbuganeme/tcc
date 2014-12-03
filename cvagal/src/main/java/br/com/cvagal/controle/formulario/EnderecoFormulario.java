package br.com.cvagal.controle.formulario;

import javax.persistence.Transient;

import br.com.cvagal.modelo.Endereco;
import br.com.cvagal.visao.formulario.Formulario;

/**
 * <p>
 * <b>Título:</b> EnderecoFormulario.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por conter os atributos em comum da camada de visão da entidade <i>Endereco</i>.
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
public class EnderecoFormulario extends Formulario<Endereco> {

	/** Constante serialVersionUID. */
	@Transient
	private static final long serialVersionUID = -6553599597113511966L;

}
