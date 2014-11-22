package br.com.cvagal.utilitarios.criptografia;

import java.security.MessageDigest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>
 * <b>Título:</b> UtilCriptografia.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe Responsável por criptografar informações gerais, tais como: senha, chaves, etc.
 * </p>
 *
 * Data de criação: 07/10/2014
 *
 * @author marcosbuganeme
 *
 * @version 1.0.0
 */
public class UtilCriptografia {

	/** Constante LOG. */
	private static final Log LOG = LogFactory.getLog(UtilCriptografia.class.getSimpleName());

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	private UtilCriptografia() {

	}

	/**
	 * Método responsável por Criptografar um Texto para o Formato MD5
	 *
	 * @author marcosbuganeme
	 *
	 * @param strInicial
	 *            - string que será tratada.
	 * 
	 * @return <i>senha em formato md5</i>.
	 */
	public static String obterStringMD5(final String strInicial) {

		final StringBuilder strBuilder = new StringBuilder();

		try {

			final MessageDigest digest = MessageDigest.getInstance("MD5");

			final byte[] strDigest = digest.digest(strInicial.getBytes("UTF-8"));

			for (final byte b : strDigest) {

				strBuilder.append(String.format("%02X", 0xFF & b));
			}

		} catch (final Exception e) {

			UtilCriptografia.LOG.error("MENSAGEM DE ERROR >>>>> " + e.getMessage());
		}

		return strBuilder.toString().toLowerCase();
	}
}
