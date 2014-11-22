package br.com.cvagal.seguranca;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cvagal.utilitarios.jsf.UtilitarioJSF;

/**
 * <p>
 * <b>Título:</b> LoginControle.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável pelo controle do login do sistema.
 * </p>
 *
 * Data de criação: 16/11/2014
 *
 * @author marcosbuganeme
 *
 * @author Leides Rodrigues
 *
 * @version 1.0.0
 */
@Named
@SessionScoped
public class LoginControle implements Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -8104167516722439878L;

	/** Constante FALHA_VALIDACAO_CREDENCIAIS. */
	private static final String FALHA_VALIDACAO_CREDENCIAIS = "credencial.invalida";

	/** Constante ABRE_LOGIN. */
	private static final String ABRE_LOGIN = "login.abrir";

	/** Constante ABRE_LOGIN. */
	private static final String FECHA_LOGIN = "login.fechar";

	/** Atributo isLoginAtivado. */
	private boolean isLoginAtivado;

	/** Atributo email. */
	private String email;

	/**
	 * Método responsável por inicializar o ciclo de vida do JSF na sexta fase (RENDER_RESPONSE).
	 *
	 * @author marcosbuganeme
	 *
	 */
	public void preRender() {

		if ("true".equals(this.getRequest().getParameter("invalid"))) {

			UtilitarioJSF.addMensagemError(LoginControle.FALHA_VALIDACAO_CREDENCIAIS);
		}
	}

	/**
	 * Método responsável por autenticar um usuário, verificando suas credenciais na base de dados.
	 *
	 * @author marcosbuganeme
	 *
	 * @throws ServletException
	 * 
	 * @throws IOException
	 */
	public void autenticar() throws ServletException, IOException {

		final RequestDispatcher dispatcher = this.getRequest().getRequestDispatcher("/j_spring_security_check");

		dispatcher.forward(this.getRequest(), this.getResponse());

		FacesContext.getCurrentInstance().responseComplete();
	}

	/**
	 * Método responsável por apresentar uma mensagem na tela quando o botão de login for acionado.
	 *
	 * @author marcosbuganeme
	 * 
	 */
	public void abreLogin() {

		if (this.isLoginAtivado) {

			UtilitarioJSF.addMensagemInfo(LoginControle.ABRE_LOGIN);

			this.isLoginAtivado = true;

		} else {

			UtilitarioJSF.addMensagemInfo(LoginControle.FECHA_LOGIN);

			this.isLoginAtivado = false;
		}
	}

	/**
	 * Retorna o valor do atributo <code>request</code>
	 *
	 * @return <code>HttpServletRequest</code>
	 */
	private HttpServletRequest getRequest() {

		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	/**
	 * Retorna o valor do atributo <code>response</code>
	 *
	 * @return <code>HttpServletResponse</code>
	 */
	private HttpServletResponse getResponse() {

		return (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
	}

	/**
	 * Retorna o valor do atributo <code>isLoginAtivado</code>
	 *
	 * @return <code>boolean</code>
	 */
	public boolean isLoginAtivado() {

		return this.isLoginAtivado;
	}

	/**
	 * Define o valor do atributo <code>isLoginAtivado</code>.
	 *
	 * @param isLoginAtivado
	 */
	public void setLoginAtivado(final boolean isLoginAtivado) {

		this.isLoginAtivado = isLoginAtivado;
	}

	/**
	 * Retorna o valor do atributo <code>email</code>
	 *
	 * @return <code>String</code>
	 */
	public String getEmail() {

		return email;
	}

	/**
	 * Define o valor do atributo <code>email</code>.
	 *
	 * @param email
	 */
	public void setEmail(String email) {

		this.email = email;
	}

}
