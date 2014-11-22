package br.com.cvagal.excecoes;

/**
 * <p>
 * <b>Título:</b> RegistroJaExisteException.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por tratar as exceções de validação de persistência em dados que já existem.
 * </p>
 *
 * Data de criação: 19/11/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class RegistroJaExisteException extends ValidacaoException {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -3112657310178371059L;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public RegistroJaExisteException() {

	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param mensagem
	 *            - mensagem da exceção.
	 */
	public RegistroJaExisteException( final String mensagem ) {

		super(mensagem);
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param causa
	 *            - causa da exceção.
	 */
	public RegistroJaExisteException( final Throwable causa ) {

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
	public RegistroJaExisteException( final String mensagem, final Throwable causa ) {

		super(mensagem, causa);
	}

}
