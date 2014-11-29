package br.com.cvagal.controle;

import java.util.Arrays;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.cvagal.controle.formulario.EmpresaFormulario;
import br.com.cvagal.modelo.Empresa;
import br.com.cvagal.modelo.enuns.EnumEspecialidadeMercado;
import br.com.cvagal.negocio.EmpresaServicoFacade;
import br.com.cvagal.visao.ManutencaoController;

/**
 * <p>
 * <b>Título:</b> EmpresaControle.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por controlar as requisições da tela de <code>Empresa</code>.
 * </p>
 *
 * Data de criação: 28/11/2014
 *
 * @author marcosbuganeme
 *
 * @author Leides Rodrigues
 *
 * @version 1.0.0
 */
@Named
@ViewScoped
public class EmpresaControle extends ManutencaoController<Empresa> {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 5225751719817347832L;

	/** Atributo formulario. */
	@Inject
	private EmpresaFormulario formulario;

	/** Atributo servico. */
	@Inject
	private EmpresaServicoFacade servico;

	/**
	 * Método responsável por obter uma coleção das especialidades que uma empresa pode ter.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>coleção de especialidades</i>.
	 */
	public Collection<EnumEspecialidadeMercado> preencherComboBoxEspecialidade() {

		return Arrays.asList(EnumEspecialidadeMercado.values());
	}

	@Override
	@PostConstruct
	public void iniciarDados() {

		this.getFormulario().setEntidade(new Empresa());
	}

	@Override
	public void resetarDados() {

	}

	@Override
	public EmpresaFormulario getFormulario() {

		return this.formulario;
	}

	@Override
	protected EmpresaServicoFacade getService() {

		return this.servico;
	}

}
