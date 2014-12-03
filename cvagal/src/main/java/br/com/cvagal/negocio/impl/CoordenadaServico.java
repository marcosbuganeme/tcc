package br.com.cvagal.negocio.impl;

import javax.inject.Inject;
import javax.persistence.Transient;

import br.com.cvagal.modelo.Coordenada;
import br.com.cvagal.negocio.CoordenadaServicoFacade;
import br.com.cvagal.persistencia.CoordenadaDAO;

/**
 * <p>
 * <b>Título:</b> CoordenadaServico.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por implementar a interface responsável pelo facade da entidade <i>Coordenada</i>.
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
public class CoordenadaServico extends Servico<Coordenada> implements CoordenadaServicoFacade {

	/** Constante serialVersionUID. */
	@Transient
	private static final long serialVersionUID = 4487015280645481766L;

	/** Atributo dao. */
	@Inject
	private CoordenadaDAO dao;

	@Override
	public CoordenadaDAO getDAO() {

		return this.dao;
	}

}
