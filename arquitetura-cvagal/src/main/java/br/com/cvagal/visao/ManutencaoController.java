package br.com.cvagal.visao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.cvagal.excecoes.NegocioException;
import br.com.cvagal.modelo.Entidade;
import br.com.cvagal.utilitarios.UtilitarioJSF;

/**
 * <p>
 * <b>Título:</b> ManutencaoController.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe abstrata responsável pelo controle da manutenção dos dados { SALVAR, MESCLAR, REMOVER }.
 * </p>
 *
 * Data de criação: 19/11/2014
 *
 * @author marcosbuganeme
 *
 * @author Leides Rodrigues
 * 
 * @param <E>
 *            - Entidade que será manipulada pela classe concreta.
 *
 * @version 1.0.0
 */
public abstract class ManutencaoController<E extends Entidade> extends ConsultaController<E> {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1881709737734080194L;

	/** Constante LOG. */
	private static final Log LOG = LogFactory.getLog(ManutencaoController.class);

	/** Constante MSG_SALVAR_SUCESSO. */
	private static final String MSG_SALVAR_SUCESSO = "registro.salvo";

	/** Constante MSG_SALVAR_SUCESSO. */
	private static final String MSG_ALTERAR_SUCESSO = "registro.alterado";

	/** Constante MSG_EXCLUIR_SUCESSO. */
	private static final String MSG_EXCLUIR_SUCESSO = "registro.remover";

	/**
	 * Método responsável por persistir o objeto parametrizado na base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que será persistido.
	 * 
	 * @throws NegocioException
	 */
	public void salvar() {

		try {

			this.getService().salvar(this.getFormulario().getEntidade());

			final String mensagemSalvar = this.getMessage(ManutencaoController.MSG_SALVAR_SUCESSO);

			UtilitarioJSF.addMensagemInfo(mensagemSalvar);

			this.resetarDados();

		} catch (final NegocioException negocioException) {

			UtilitarioJSF.addMensagemError(this.getMessage(negocioException.getMessage()));

			ManutencaoController.LOG.error("ERRO MÉTODO SALVAR() " + this.getClass().getSimpleName(), negocioException.getCause());
		}
	}

	/**
	 * Método responsável por mesclar um objeto (Salvar e/ou alterar). <br>
	 * Merge: Verifica se o objeto existe na base de dados, caso exista, ele altera, caso não exista, ele salva.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que será persistido/alterado.
	 */
	public void mesclar() {

		try {

			this.getService().mesclar(this.getFormulario().getEntidade());

			final String mensagemMesclar = this.getMessage(ManutencaoController.MSG_ALTERAR_SUCESSO);

			UtilitarioJSF.addMensagemInfo(mensagemMesclar);

			this.resetarDados();

		} catch (final NegocioException negocioException) {

			UtilitarioJSF.addMensagemError(this.getMessage(negocioException.getMessage()));

			ManutencaoController.LOG.error("ERRO MÉTODO MESCLAR()" + this.getClass().getSimpleName(), negocioException.getCause());
		}
	}

	/**
	 * Método responsável por remover um objeto da base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @param entidade
	 *            - objeto que será persistido/alterado.
	 */
	public void remover() {

		try {

			this.getService().remover(this.getFormulario().getEntidade());

			final String mensagemExcluir = this.getMessage(ManutencaoController.MSG_EXCLUIR_SUCESSO);

			UtilitarioJSF.addMensagemInfo(mensagemExcluir);

		} catch (final NegocioException negocioException) {

			UtilitarioJSF.addMensagemError(this.getMessage(negocioException.getMessage()));

			ManutencaoController.LOG.error("ERRO MÉTODO REMOVER() DA CLASSE ::: " + this.getClass().getSimpleName() + ".java", negocioException.getCause());
		}
	}

}
