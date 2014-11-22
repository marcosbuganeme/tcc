package br.com.cvagal.excecoes;

/**
 * <p>
 * <b>Título:</b> NegocioException.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável pelo tratamento de exceções que quebram as regras de negócio vinculadas a uma entidade.
 * </p>
 *
 * Data de criação: 19/11/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class NegocioException extends RuntimeException {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 8340946321394558031L;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public NegocioException() {

	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param mensagem
	 *            - mensagem da exceção.
	 */
	public NegocioException( final String mensagem ) {

		super(mensagem);
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param causa
	 *            - causa da exceção.
	 */
	public NegocioException( final Throwable causa ) {

		super(causa);
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param mensagem
	 *            - mensagem da exceção.
	 * 
	 * @param causa
	 *            - causa da exceção
	 */
	public NegocioException( final String mensagem, final Throwable causa ) {

		super(mensagem, causa);
	}
}
