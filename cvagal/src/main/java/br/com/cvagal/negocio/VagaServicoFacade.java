package br.com.cvagal.negocio;

import java.util.List;

import br.com.cvagal.modelo.Vaga;
import br.com.cvagal.negocio.ServicoFacade;

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
	 * Método responsável por obter a descricao da vaga.
	 *
	 * @author marcosbuganeme
	 *
	 * @param descricao
	 *            - do cargo.
	 * 
	 * @return <i>vaga consultada</i>.
	 */
	Vaga obterVagaPorDescricao(final String descricao);

	/**
	 * Método responsável por obter uma lista de vagas através do filtro.
	 *
	 * @author marcosbuganeme
	 *
	 * @param palavraFiltrada
	 *            - filtro da consulta.
	 * 
	 * @return <i>lista de vagas</i>.
	 */
	List<Vaga> autoCompleteVaga(final String palavraFiltrada);
}
