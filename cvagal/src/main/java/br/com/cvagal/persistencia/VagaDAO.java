package br.com.cvagal.persistencia;

import br.com.cvagal.modelo.Vaga;

/**
 * <p>
 * <b>Título:</b> VagaDAO.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Interface responsável pelo repositório da entidade <i>Vaga</i>.
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
public interface VagaDAO extends DAO<Vaga> {

	/**
	 * Método responsável por obter uma vaga pelo seu SKU.
	 *
	 * @author marcosbuganeme
	 *
	 * @param sku
	 *            - filtro da consulta
	 * 
	 * @return <i>vaga consultada</i>.
	 */
	Vaga obterVagaPorSKU(final String sku);
}
