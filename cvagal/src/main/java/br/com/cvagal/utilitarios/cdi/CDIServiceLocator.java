package br.com.cvagal.utilitarios.cdi;

import java.util.Set;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>
 * <b>Título:</b> CDIServiceLocator.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por recuperar um objeto não CDI e o transformar em um Bean gerenciado CDI.
 * </p>
 *
 * Data de criação: 17/11/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class CDIServiceLocator {

	/** Constante LOG. */
	private static final Log LOG = LogFactory.getLog(CDIServiceLocator.class.getSimpleName());

	/** Constante JNDI_CDI. */
	private static final String JNDI_CDI = "java:comp/env/BeanManager";

	/** Constante EXCECAO_BEAN_NAO_CONVETIDO. */
	private static final String EXCECAO_BEAN_NAO_CONVETIDO = "Não pôde encontrar BeanManager no JNDI";

	/**
	 * Método responsável por obter um bean CDI através do contexto da aplicação.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>um bean gerenciado pelo CDI</i>.
	 */
	private static BeanManager getBeanManager() {

		try {

			final InitialContext initialContext = new InitialContext();

			return (BeanManager) initialContext.lookup(CDIServiceLocator.JNDI_CDI);

		} catch (final NamingException e) {

			CDIServiceLocator.LOG.error(" MENSAGEM DE ERRO >>>> " + e.getMessage());

			throw new RuntimeException(CDIServiceLocator.EXCECAO_BEAN_NAO_CONVETIDO);
		}
	}

	/**
	 * Método responsável por obter um bean gerenciado pelo CDI através da classe parametrizada.
	 *
	 * @author marcosbuganeme
	 *
	 * @param clazz
	 *            - classe que será obtida.
	 * 
	 * @return <i>bean gerenciado pelo CDI</i>.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(final Class<T> clazz) {

		final BeanManager bm = CDIServiceLocator.getBeanManager();

		final Set<Bean<?>> beans = bm.getBeans(clazz);

		if (beans == null || beans.isEmpty()) {

			return null;
		}

		final Bean<T> bean = (Bean<T>) beans.iterator().next();

		final CreationalContext<T> ctx = bm.createCreationalContext(bean);

		final T o = (T) bm.getReference(bean, clazz, ctx);

		return o;
	}

}
