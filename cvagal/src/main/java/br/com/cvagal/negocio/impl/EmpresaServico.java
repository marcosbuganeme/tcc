package br.com.cvagal.negocio.impl;

import javax.inject.Inject;

import br.com.cvagal.modelo.Empresa;
import br.com.cvagal.negocio.EmpresaServicoFacade;
import br.com.cvagal.persistencia.EmpresaDAO;

/**
 * <p>
 * <b>Título:</b> EmpresaServico.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por implementar a interface responsável pelo facade da entidade <i>Empresa</i>.
 * </p>
 *
 * Data de criação: 28/11/2014
 *
 * @author marcosbuganeme
 *
 * @author Leides Rodrigues
 *
 * @version 1.0.0
 */
public class EmpresaServico extends Servico<Empresa> implements EmpresaServicoFacade {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = -4870754254118164524L;

	/** Atributo dao. */
	@Inject
	private EmpresaDAO dao;

	@Override
	public EmpresaDAO getDAO() {

		return this.dao;
	}

}
