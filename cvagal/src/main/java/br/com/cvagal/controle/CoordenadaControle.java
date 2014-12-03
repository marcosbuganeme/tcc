package br.com.cvagal.controle;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Transient;

import br.com.cvagal.controle.formulario.CoordenadaFormulario;
import br.com.cvagal.modelo.Coordenada;
import br.com.cvagal.negocio.CoordenadaServicoFacade;
import br.com.cvagal.visao.ManutencaoController;

/**
 * <p>
 * <b>Título:</b> CoordenadaControle.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por controlar as requisições da tela de <code>Coordenada</code>.
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
public class CoordenadaControle extends ManutencaoController<Coordenada> {

	/** Constante serialVersionUID. */
	@Transient
	private static final long serialVersionUID = 8042917013959077994L;

	/** Atributo formulario. */
	@Inject
	private CoordenadaFormulario formulario;

	/** Atributo servico. */
	@Inject
	private CoordenadaServicoFacade servico;

	@Override
	public void iniciarDados() {

		this.getFormulario().setEntidade(new Coordenada());
	}

	@Override
	public void resetarDados() {

	}

	@Override
	public CoordenadaFormulario getFormulario() {

		return this.formulario;
	}

	@Override
	protected CoordenadaServicoFacade getService() {

		return this.servico;
	}

}
