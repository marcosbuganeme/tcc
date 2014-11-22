package br.com.cvagal.visao.bundle.excecao;

/**
 * <p>
 * <b>Título:</b> ResourceBundleFactoryException.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável pelo tratamento de exceções vinculadas a obtenção do <code>ResourceBundle</code> para aplicação.
 * </p>
 *
 * Data de criação: 19/11/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class ResourceBundleFactoryException extends RuntimeException {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -6643021740000841111L;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public ResourceBundleFactoryException() {

		super();
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param mensagem
	 *            - mensagem da exceção.
	 */
	public ResourceBundleFactoryException( final String mensagem ) {

		super(mensagem);
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param causa
	 *            - causa da exceção.
	 */
	public ResourceBundleFactoryException( final Throwable causa ) {

		super(causa);
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param mensagem
	 *            - mensagem da exceção.
	 * 
	 * @param causa
	 *            - causa da exceção.
	 */
	public ResourceBundleFactoryException( final String mensagem, final Throwable causa ) {

		super(mensagem, causa);
	}
}
