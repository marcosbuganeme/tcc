package br.com.cvagal.excecoes;

/**
 * <p>
 * <b>Título:</b> RegistroNaoExisteException.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por tratar as exceções de validação para dados que não existem.
 * </p>
 *
 * Data de criação: 11/19/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class RegistroNaoExisteException extends ValidacaoException {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -6686012867204626060L;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public RegistroNaoExisteException() {

	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param mensagem
	 *            - mensagem da exceção.
	 */
	public RegistroNaoExisteException( final String mensagem ) {

		super(mensagem);
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param causa
	 *            - causa da exceção.
	 */
	public RegistroNaoExisteException( final Throwable causa ) {

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
	public RegistroNaoExisteException( final String mensagem, final Throwable causa ) {

		super(mensagem, causa);
	}

}
