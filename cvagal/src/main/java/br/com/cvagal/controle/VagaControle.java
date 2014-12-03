package br.com.cvagal.controle;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.cvagal.controle.formulario.VagaFormulario;
import br.com.cvagal.filtro.FiltroLazy;
import br.com.cvagal.modelo.Empresa;
import br.com.cvagal.modelo.Vaga;
import br.com.cvagal.modelo.enuns.EnumTipoProfissional;
import br.com.cvagal.negocio.VagaServicoFacade;
import br.com.cvagal.utilitarios.UtilitarioJSF;
import br.com.cvagal.visao.ManutencaoController;

/**
 * <p>
 * <b>Título:</b> ControleVaga.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por controlar as requisições da tela de <code>Vaga</code>.
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
@Named
@ViewScoped
public class VagaControle extends ManutencaoController<Vaga> {

	/** Constante serialVersionUID. */
	@Transient
	private static final long serialVersionUID = 1779164265112638554L;

	/** Atributo servico. */
	@Inject
	private VagaServicoFacade servico;

	/** Atributo formulario. */
	@Inject
	private VagaFormulario formulario;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public VagaControle() {

	}

	/**
	 * Método responsável por renderizar uma mensagem em um pop-up de exibição quando o botão de swith for ativado.
	 *
	 * @author marcosbuganeme
	 *
	 * @param event
	 *            - evento de seleção.
	 */
	public void selecionarColunaDataTable(final SelectEvent event) {

		UtilitarioJSF.addMensagemInfo("Vaga de SKU " + ( (Vaga) event.getObject() ).getSku() + " selecionada!!");
	}

	/**
	 * Método responsável por listar as vagas através do componente autocomplete do primefaces.
	 *
	 * @author marcosbuganeme
	 *
	 * @param filtro
	 *            - filtro do autocomplete.
	 * 
	 * @return <i>lista de vagas</i>.
	 */
	public List<Vaga> autoCompleteVaga(final String filtro) {

		this.getFormulario().setPalavraChave(new String(filtro));

		return this.getService().autoCompleteVaga(filtro);
	}

	/**
	 * Método responsável por obter uma coleção com todas as empresas.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>coleção de empresas</i>
	 */
	public Collection<Empresa> preencherComboBoxEmpresa() {

		return this.getService().listarTodasEmpresas();
	}

	/**
	 * Método responsável por obter uma coleção com todos as qualificações profissionais.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>coleção com qualificações profissionais</i>.
	 */
	public List<EnumTipoProfissional> preencherComboBoxQualificacaoProfissional() {

		return Arrays.asList(EnumTipoProfissional.values());
	}

	@PostConstruct
	@Override
	public void iniciarDados() {

		this.getFormulario().setFiltro(new FiltroLazy<Vaga>());

		VagaControle.this.getFormulario().setModelo(new LazyDataModel<Vaga>() {

			/** Constante serialVersionUID. */
			private static final long serialVersionUID = -7288345241332212848L;

			@Override
			public List<Vaga> load(final int first, final int pageSize, final String sortField, final SortOrder sortOrder, final Map<String, Object> filters) {

				VagaControle.this.getFormulario().getFiltro().setPrimeiroRegistro(first);

				VagaControle.this.getFormulario().getFiltro().setQuantidadeRegistroPorPagina(pageSize);

				VagaControle.this.getFormulario().getFiltro().setAscendente(SortOrder.ASCENDING.equals(sortOrder));

				VagaControle.this.getFormulario().getFiltro().setPropriedadeOrdenacao(sortField);

				if (StringUtils.isNotEmpty(VagaControle.this.getFormulario().getPalavraChave())) {

					VagaControle.this.getFormulario().getFiltro().setPalavraChave(VagaControle.this.getFormulario().getPalavraChave());
				}

				if (VagaControle.this.getFormulario().getTipoProfissional() != null) {

					VagaControle.this.getFormulario().getFiltro().setEnumerator(VagaControle.this.getFormulario().getTipoProfissional());
				}

				final int rowcount = VagaControle.this.getService().quantidadeRegistros(VagaControle.this.getFormulario().getFiltro());

				this.setRowCount(rowcount);

				return VagaControle.this.getService().listar(VagaControle.this.getFormulario().getFiltro());
			}
		});
	}

	@Override
	public void resetarDados() {

		this.getFormulario().setPalavraChave(new String());

		this.getFormulario().getFiltro().setPalavraChave(new String());

		this.getFormulario().getFiltro().setEnumerator(null);

		this.getFormulario().setTipoProfissional(null);
	}

	@Override
	public VagaFormulario getFormulario() {

		return this.formulario;
	}

	@Override
	protected VagaServicoFacade getService() {

		return this.servico;
	}
}
