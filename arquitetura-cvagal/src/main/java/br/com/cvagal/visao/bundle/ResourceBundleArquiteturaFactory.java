package br.com.cvagal.visao.bundle;

import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import br.com.cvagal.visao.bundle.excecao.ResourceBundleFactoryException;

/**
 * <p>
 * <b>Título:</b> ResourceBundleArquiteturaFactory.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe abstrata responsável por prover uma fábrica de criação para <code>ResourceBundle</code>, dizendo para o bundle de onde serão obtidas as mensagens.
 * </p>
 *
 * Data de criação: 24/09/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public abstract class ResourceBundleArquiteturaFactory {

	/** Constante LOG. */
	private static Log LOG = LogFactory.getLog(ResourceBundleArquiteturaFactory.class);

	/** Constante ERRO_INSTANCIA_BUNDLE. */
	private static final String ERRO_INSTANCIA_BUNDLE = "Erro na instanciação do resourceBundle :: ";

	/** Constante ERRO_CLASSE_CORRENTE. */
	private static final String ERRO_CLASSE_CORRENTE = "Erro na classe ResourceBundleArquiteturaFactory :: ";

	/**
	 * Método responsável por criar o <code>ResourceBundle</code> para a aplicação.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i><code>ResourceBundle</code> da aplicação</i>.
	 */
	public abstract ResourceBundle getResourceBundle();

	/**
	 * Método responsável por obter <code>ResourceBundle</code> da aplicação apartir do factory parametrizado.
	 *
	 * @author marcosbuganeme
	 *
	 * @param factoryClass
	 *            - classe que irá prover o <code>ResourceBundle</code>.
	 * 
	 * @return <i><code>ResourceBundle</code> para a aplicação</i>.
	 */
	public static ResourceBundle getBundle(final Class<? extends ResourceBundleArquiteturaFactory> factoryClass) throws ResourceBundleFactoryException {

		try {

			return factoryClass.newInstance().getResourceBundle();

		} catch (final Throwable exception) {

			if (exception instanceof ResourceBundleFactoryException) {

				ResourceBundleArquiteturaFactory.LOG.error(ResourceBundleArquiteturaFactory.ERRO_INSTANCIA_BUNDLE + exception.getMessage(), exception);
			}

			ResourceBundleArquiteturaFactory.LOG.error(ResourceBundleArquiteturaFactory.ERRO_CLASSE_CORRENTE + exception.getMessage(), exception);
		}

		return null;
	}

}
