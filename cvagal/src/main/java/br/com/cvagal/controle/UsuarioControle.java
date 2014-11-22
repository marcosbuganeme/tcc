package br.com.cvagal.controle;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.cvagal.controle.formulario.UsuarioFormulario;
import br.com.cvagal.modelo.Usuario;
import br.com.cvagal.negocio.UsuarioServicoFacade;
import br.com.cvagal.visao.ManutencaoController;

/**
 * <p>
 * <b>Título:</b> UsuarioControle.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b>
 * </p>
 *
 * Data de criação: 21/11/2014
 *
 * @author marcosbuganeme
 *
 * @author Leides Rodrigues
 *
 * @version 1.0.0
 */
/**
 * <p>
 * <b>Título:</b> UsuarioControle.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por controlar as requisições da tela de <code>Usuario</code>.
 * </p>
 *
 * Data de criação: 18/11/2014
 *
 * @author marcosbuganeme
 *
 * @author Leides Rodrigues
 *
 * @version 1.0.0
 */
@Named
@ViewScoped
public class UsuarioControle extends ManutencaoController<Usuario> {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -5091974248422466103L;

	/** Atributo formulario. */
	@Inject
	private UsuarioFormulario formulario;

	/** Atributo servico. */
	@Inject
	private UsuarioServicoFacade servico;

	@Override
	@PostConstruct
	public void iniciarDados() {

	}

	@Override
	public void resetarDados() {

	}

	@Override
	public UsuarioFormulario getFormulario() {

		return this.formulario;
	}

	@Override
	protected UsuarioServicoFacade getService() {

		return this.servico;
	}
}
