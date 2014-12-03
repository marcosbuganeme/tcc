package br.com.cvagal.controle;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Transient;

import br.com.cvagal.controle.formulario.EnderecoFormulario;
import br.com.cvagal.modelo.Endereco;
import br.com.cvagal.negocio.EnderecoServicoFacade;
import br.com.cvagal.visao.ManutencaoController;

/**
 * <p>
 * <b>Título:</b> EnderecoControle.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por controlar as requisições da tela de <code>Endereco</code>.
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
@Named
@ViewScoped
public class EnderecoControle extends ManutencaoController<Endereco> {

	/** Constante serialVersionUID. */
	@Transient
	private static final long serialVersionUID = -4551242988865882149L;

	/** Atributo formulario. */
	@Inject
	private EnderecoFormulario formulario;

	/** Atributo servico. */
	@Inject
	private EnderecoServicoFacade servico;

	@Override
	public void iniciarDados() {

		this.getFormulario().setEntidade(new Endereco());
	}

	@Override
	public void resetarDados() {

	}

	@Override
	public EnderecoFormulario getFormulario() {

		return this.formulario;
	}

	@Override
	protected EnderecoServicoFacade getService() {

		return this.servico;
	}

}
