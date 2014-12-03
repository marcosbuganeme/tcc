package br.com.cvagal.negocio.impl;

import javax.inject.Inject;
import javax.persistence.Transient;

import br.com.cvagal.modelo.Telefone;
import br.com.cvagal.negocio.TelefoneServicoFacade;
import br.com.cvagal.persistencia.TelefoneDAO;

/**
 * <p>
 * <b>Título:</b> TelefoneServico.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por implementar a interface responsável pelo facade da entidade <i>Telefone</i>.
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
public class TelefoneServico extends Servico<Telefone> implements TelefoneServicoFacade {

	/** Constante serialVersionUID. */
	@Transient
	private static final long serialVersionUID = 8878546279979677767L;

	/** Atributo dao. */
	@Inject
	private TelefoneDAO dao;

	@Override
	public TelefoneDAO getDAO() {

		return this.dao;
	}

}
