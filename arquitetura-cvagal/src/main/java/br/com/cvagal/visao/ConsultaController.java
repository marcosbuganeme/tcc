package br.com.cvagal.visao;

import br.com.cvagal.modelo.Entidade;
import br.com.cvagal.negocio.ServicoFacade;
import br.com.cvagal.visao.formulario.Formulario;

/**
 * <p>
 * <b>Título:</b> ConsultaController.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b>
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
public abstract class ConsultaController<E extends Entidade> extends Controller {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -3302539776907955447L;

	/**
	 * Retorna o valor do atributo <code>formulario</code>
	 *
	 * @return <code>Formulario<E></code>
	 */
	public abstract Formulario<E> getFormulario();

	/**
	 * Retorna o valor do atributo <code>service</code>
	 *
	 * @return <code>ServiceFacade</code>
	 */
	protected abstract ServicoFacade<E> getService();

}
