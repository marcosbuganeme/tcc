package br.com.cvagal.utilitarios.jsf;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 * <p>
 * <b>Título:</b> UtilitarioJSF.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por prover funções utilitárias para manipulação dos dados da camada de visão com o frameWork JSF.
 * </p>
 *
 * Data de criação: 173/11/2014
 *
 * @author marcosbuganeme
 * 
 * @author Leides Rodrigues
 *
 * @version 1.0.0
 */
public final class UtilitarioJSF implements Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -7078284550447961938L;

	public static boolean isPostback() {

		return FacesContext.getCurrentInstance().isPostback();
	}

	public static boolean isNotPostback() {

		return !UtilitarioJSF.isPostback();
	}

	/**
	 * Método responsável por exibir uma mensagem de acordo com a severidade repassada.
	 *
	 * @author marcosbuganeme
	 *
	 * @param mensagem
	 *            - corpo da mensagem que será exibida na tela.
	 * 
	 * @param severidade
	 *            - gravidade da mensagem que será exibida.
	 */
	private static void exibirMensagemJSF(final String mensagem, final Severity severidade) {

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severidade, mensagem, mensagem));
	}

	/**
	 * Método responsável por adicionar uma mensagem do tipo INFO na tela do usuário.
	 *
	 * @author marcosbuganeme
	 *
	 * @param mensagem
	 *            - INFO que será exibida na tela do usuário.
	 */
	public static void addMensagemInfo(final String mensagem) {

		UtilitarioJSF.exibirMensagemJSF(mensagem, FacesMessage.SEVERITY_INFO);
	}

	/**
	 * Método responsável por adicionar uma mensagem do tipo WARN na tela do usuário.
	 *
	 * @author marcosbuganeme
	 *
	 * @param mensagem
	 *            - WARN que será exibida na tela do usuário.
	 */
	public static void addMensagemWarn(final String mensagem) {

		UtilitarioJSF.exibirMensagemJSF(mensagem, FacesMessage.SEVERITY_WARN);
	}

	/**
	 * Método responsável por adicionar uma mensagem do tipo ERROR na tela do usuário.
	 *
	 * @author marcosbuganeme
	 *
	 * @param mensagem
	 *            - ERROR que será exibida na tela do usuário.
	 */
	public static void addMensagemError(final String mensagem) {

		UtilitarioJSF.exibirMensagemJSF(mensagem, FacesMessage.SEVERITY_ERROR);
	}

}
