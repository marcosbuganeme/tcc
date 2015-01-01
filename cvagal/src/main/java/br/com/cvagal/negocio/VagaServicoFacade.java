package br.com.cvagal.negocio;

import java.util.Collection;

import br.com.cvagal.modelo.Empresa;
import br.com.cvagal.modelo.Vaga;

/**
 * <p>
 * <b>Título:</b> VagaServicoFacade.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Interface responsável por disponibilizar os servicos da entidade <code>Vaga</code> utilizando o padrão de projeto Facade.
 * </p>
 *
 * Data de criação: 18/11/2014
 *
 * @author marcosbuganeme
 *
 * @author Leides Rodrigues
 *
 * @version 1.0.0
 */
public interface VagaServicoFacade extends ServicoFacade<Vaga> {

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

	/**
	 * Método responsável por obter uma coleção de todas as empresas.
	 *
	 * @author marcosbuganeme
	 *
	 * @return <i>coleção de empresas</i>
	 */
	Collection<Empresa> listarTodasEmpresas();
}
