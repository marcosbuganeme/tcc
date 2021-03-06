package br.com.cvagal.controle;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Transient;
import javax.servlet.http.Part;

import br.com.cvagal.controle.formulario.CandidatoFormulario;
import br.com.cvagal.modelo.Candidato;
import br.com.cvagal.modelo.Telefone;
import br.com.cvagal.negocio.CandidatoServicoFacade;
import br.com.cvagal.utilitarios.UtilitarioJSF;
import br.com.cvagal.visao.ManutencaoController;

/**
 * <p>
 * <b>Título:</b> CandidatoControle.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b>
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
public class CandidatoControle extends ManutencaoController<Candidato> {

	/** Constante serialVersionUID. */
	@Transient
	private static final long serialVersionUID = -5158352896048564580L;

	/** Constante CAMPOS_OBRIGATORIOS_TELEFONE_NAO_PREENCHIDOS. */
	@Transient
	private static final String CAMPOS_OBRIGATORIOS_TELEFONE_NAO_PREENCHIDOS = "validacao.campos.obrigatorios.telefone";

	/** Atributo formulario. */
	@Inject
	private CandidatoFormulario formulario;

	/** Atributo servico. */
	@Inject
	private CandidatoServicoFacade servico;

	/** Atributo vagaControle. */
	@Inject
	private VagaControle vagaControle;

	/** Atributo curriculo. */
	private transient Part curriculo;

	public void uploadCurriculo(ActionEvent evento) {

		if (this.curriculo != null) {

			try (InputStream is = this.curriculo.getInputStream(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {

				int leitura = -1;

				byte[] buffer = new byte[1024];

				while (( leitura = is.read(buffer) ) != -1) {

					out.write(buffer, 0, leitura);
				}
				
				this.getFormulario().getEntidade().setCurriculo(out.toByteArray());

			} catch (final Exception e) {

				throw new RuntimeException("Erro ao fazer o upload do arquivo");
			}
		}
	}

	/**
	 * Método responsável por adicionar um telefone a uma lista de telefones.
	 *
	 * @author marcosbuganeme
	 *
	 */
	public void adicionarTelefone() {

		if (this.getFormulario().getTelefone() != null) {

			this.getFormulario().getColecaoTelefones().add(this.getFormulario().getTelefone());

			this.resetarDados();

		} else {

			final String camposObrigatoriosNaoPreenchidos = CandidatoControle.CAMPOS_OBRIGATORIOS_TELEFONE_NAO_PREENCHIDOS;

			UtilitarioJSF.addMensagemError(this.getMessage(camposObrigatoriosNaoPreenchidos));
		}
	}

	public void removerTelefone() {

		if (this.getFormulario().getTelefone() != null) {

			this.getFormulario().getColecaoTelefones().remove(this.getFormulario().getTelefone());
		}
	}

	/**
	 * Método responsável por verificar se a coleção de telefones está vazia. <br>
	 * Renderiza o componente datatable dependendo da situação.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>True, se a coleção estiver vazia</i>.
	 */
	public boolean isColecaoTelefoneVazio() {

		if (this.getFormulario().getColecaoTelefones().size() != 0) {

			return false;
		}

		return true;
	}

	@Override
	@PostConstruct
	public void iniciarDados() {

		// this.getFormulario().setEntidade(new Candidato());
		//
		// this.getFormulario().setTelefone(new Telefone());
		//
		// this.getFormulario().setColecaoTelefones(new ArrayList<Telefone>(0));
		//
		// this.getFormulario().setEndereco(new Endereco());
		//
		// this.getFormulario().getEndereco().setCoordenada(new Coordenada());
		//
		// this.getFormulario().setCoordenada(new Coordenada());

		this.getFormulario().setVaga(this.vagaControle.getFormulario().getVagaSelecionada());
	}

	@Override
	public void resetarDados() {

		this.getFormulario().setTelefone(new Telefone());
	}

	@Override
	public CandidatoFormulario getFormulario() {

		return this.formulario;
	}

	@Override
	protected CandidatoServicoFacade getService() {

		return this.servico;
	}

	/**
	 * Retorna o valor do atributo <code>curriculo</code>
	 *
	 * @return <code>Part</code>
	 */
	public Part getCurriculo() {

		return this.curriculo;
	}

	/**
	 * Define o valor do atributo <code>curriculo</code>.
	 *
	 * @param curriculo
	 */
	public void setCurriculo(final Part curriculo) {

		this.curriculo = curriculo;
	}

}
