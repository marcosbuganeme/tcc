package br.com.cvagal.negocio.impl;

import javax.inject.Inject;
import javax.persistence.Transient;

import br.com.cvagal.modelo.Endereco;
import br.com.cvagal.negocio.EnderecoServicoFacade;
import br.com.cvagal.persistencia.EnderecoDAO;

/**
 * <p>
 * <b>Título:</b> EnderecoServico.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b>
 * </p>
 *
 * Data de criação: 30/11/2014
 *
 * @author marcosbuganeme
 *
 * @author Leides Rodrigues
 *
 * @version 1.0.0
 */
public class EnderecoServico extends Servico<Endereco> implements EnderecoServicoFacade {

	/** Constante serialVersionUID. */
	@Transient
	private static final long serialVersionUID = -7360552328328213660L;

	/** Atributo dao. */
	@Inject
	private EnderecoDAO dao;

	@Override
	public EnderecoDAO getDAO() {

		return this.dao;
	}

}
