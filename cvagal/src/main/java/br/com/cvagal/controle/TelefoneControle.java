package br.com.cvagal.controle;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Transient;

import br.com.cvagal.controle.formulario.TelefoneFormulario;
import br.com.cvagal.modelo.Telefone;
import br.com.cvagal.negocio.TelefoneServicoFacade;
import br.com.cvagal.visao.ManutencaoController;

/**
 * <p>
 * <b>Título:</b> TelefoneControle.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por controlar as requisições da tela de <code>Telefone</code>.
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
public class TelefoneControle extends ManutencaoController<Telefone> {

	/** Constante serialVersionUID. */
	@Transient
	private static final long serialVersionUID = 2387233269571917620L;

	/** Atributo formulario. */
	@Inject
	private TelefoneFormulario formulario;

	/** Atributo servico. */
	@Inject
	private TelefoneServicoFacade servico;

	@Override
	public void iniciarDados() {

	}

	@Override
	public void resetarDados() {

	}

	@Override
	public TelefoneFormulario getFormulario() {

		return this.formulario;
	}

	@Override
	protected TelefoneServicoFacade getService() {

		return this.servico;
	}

}
