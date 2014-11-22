package br.com.cvagal.excecoes;

/**
 * <p>
 * <b>Título:</b> ValidacaoException.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por tratar as exceções que quebram a validação de dados.
 * </p>
 *
 * Data de criação: 11/19/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class ValidacaoException extends NegocioException {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -5880842421322817411L;

	public ValidacaoException() {

	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param mensagem
	 *            - mensagem da exceção.
	 */
	public ValidacaoException( final String mensagem ) {

		super(mensagem);
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param causa
	 *            - causa da exceção.
	 */
	public ValidacaoException( final Throwable causa ) {

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
	public ValidacaoException( final String mensagem, final Throwable causa ) {

		super(mensagem, causa);
	}

}
