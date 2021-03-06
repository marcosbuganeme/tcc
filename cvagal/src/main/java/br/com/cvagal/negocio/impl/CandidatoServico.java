package br.com.cvagal.negocio.impl;

import javax.inject.Inject;
import javax.persistence.Transient;

import br.com.cvagal.modelo.Candidato;
import br.com.cvagal.negocio.CandidatoServicoFacade;
import br.com.cvagal.persistencia.CandidatoDAO;

/**
 * <p>
 * <b>Título:</b> CandidatoServico.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por implementar a interface responsável pelo facade da entidade <i>Candidato</i>.
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
public class CandidatoServico extends Servico<Candidato> implements CandidatoServicoFacade {

	/** Constante serialVersionUID. */
	@Transient
	private static final long serialVersionUID = 3559296240913724436L;

	/** Atributo dao. */
	@Inject
	private CandidatoDAO dao;

	@Override
	public CandidatoDAO getDAO() {

		return this.dao;
	}

}
