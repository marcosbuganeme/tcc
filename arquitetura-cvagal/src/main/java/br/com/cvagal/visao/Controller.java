package br.com.cvagal.visao;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import br.com.cvagal.visao.bundle.ResourceBundleArquitetura;
import br.com.cvagal.visao.bundle.ResourceBundleArquiteturaFactory;

/**
 * <p>
 * <b>Título:</b> Controller.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe abstrata responsável por controlar o fluxo de navegação do sistema.
 * </p>
 *
 * Data de criação: 19/11/2014
 *
 * @author marcosbuganeme
 *
 * @author Leides Rodrigues
 *
 * @version 1.0.0
 */
public abstract class Controller implements Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 7501085783470576978L;

	/**
	 * Método responsável por inicializar os dados do controlador.
	 *
	 * @author marcosbuganeme
	 */
	public abstract void iniciarDados();

	/**
	 * Método responsável por resetar os dados do controlador.
	 *
	 * @author marcosbuganeme
	 */
	public abstract void resetarDados();

	/**
	 * Método responsável por retornar a mensagem vinculada a chave passada como parâmetro.
	 * 
	 * @author marcosbuganeme
	 * 
	 * @param keyMessage
	 *            - Chave da mensagem.
	 * 
	 * @return <i>mensagem a ser exibida na tela</i>.
	 */
	public String getMessage(final String keyMessage) {

		return this.getBundle().getString(keyMessage);
	}

	/**
	 * Método responsável por retornar a mensagem vinculada a chave passada como parâmetro.
	 * 
	 * @author marcosbuganeme
	 * 
	 * @param keyMessage
	 *            - Chave da mensagem.
	 * 
	 * @param parametro
	 *            - Parâmetros da mensagem.
	 * 
	 * @return mensagem a ser exibida na tela.
	 */
	public String getMessage(final String keyMessage, final Object[] parametro) {

		final String mensagem = this.getBundle().getString(keyMessage);

		return MessageFormat.format(mensagem, parametro);
	}

	/**
	 * Método responsável por retornar as mensagens vinculadas as chaves passadas como parâmetro.
	 * 
	 * @author marcosbuganeme
	 * 
	 * @param keyMessages
	 *            Chaves das mensagem.
	 * 
	 * @return mensagens a serem exibidas na tela.
	 */
	public String[] getMessages(final String... keyMessages) {

		final String[] mensagens = new String[keyMessages.length];

		for (int indice = 0; indice < keyMessages.length; indice++) {

			mensagens[indice] = this.getBundle().getString(keyMessages[indice]);
		}

		return mensagens;
	}

	/**
	 * Retorna o valor do atributo bundle.
	 * 
	 * @return <code>ResourceBundle</code> Arquivo de mensagens da arquitetura.
	 */
	protected ResourceBundle getBundle() {

		return ResourceBundleArquiteturaFactory.getBundle(this.getResourceBundleFactory());
	}

	/**
	 * Obtem o ResourceBundleFactory para o controlador
	 * 
	 * @return ResourceBundleFactory para o controlador
	 * 
	 * @see ResourceBundleArquiteturaFactory
	 */
	protected Class<? extends ResourceBundleArquiteturaFactory> getResourceBundleFactory() {

		return ResourceBundleArquitetura.class;
	}

}
