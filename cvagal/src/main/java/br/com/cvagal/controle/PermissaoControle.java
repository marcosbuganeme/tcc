package br.com.cvagal.controle;

import java.util.Arrays;
import java.util.Collection;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.cvagal.controle.formulario.PermissaoFormulario;
import br.com.cvagal.modelo.Permissao;
import br.com.cvagal.modelo.Usuario;
import br.com.cvagal.modelo.enuns.EnumPermissao;
import br.com.cvagal.negocio.PermissaoServicoFacade;
import br.com.cvagal.visao.ManutencaoController;

/**
 * <p>
 * <b>Título:</b> PermissaoControle.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por controlar as requisições da tela de <code>Permissao</code>.
 * </p>
 *
 * Data de criação: 27/11/2014
 *
 * @author marcosbuganeme
 *
 * @author Leides Rodrigues
 *
 * @version 1.0.0
 */
@Named
@ViewScoped
public class PermissaoControle extends ManutencaoController<Permissao> {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 2862284746988289668L;

	/** Atributo formulario. */
	@Inject
	private PermissaoFormulario formulario;

	/** Atributo servico. */
	@Inject
	private PermissaoServicoFacade servico;

	/**
	 * Método responsável por obter uma coleção de permissões possíveis.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>coleção de permissões</i>.
	 */
	public Collection<EnumPermissao> preencherComboBoxPermissao() {

		return Arrays.asList(EnumPermissao.values());
	}

	/**
	 * Método responsável por obter uma coleção de todos os usuários.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>coleção de usuários</i>.
	 */
	public Collection<Usuario> preencherComboBoxUsuario() {

		return this.getService().listarTodosUsuarios();
	}

	@Override
	public void iniciarDados() {

	}

	@Override
	public void resetarDados() {

	}

	@Override
	public PermissaoFormulario getFormulario() {

		return this.formulario;
	}

	@Override
	protected PermissaoServicoFacade getService() {

		return this.servico;
	}
}
