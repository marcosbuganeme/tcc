package br.com.cvagal.persistencia;

import java.util.List;

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
