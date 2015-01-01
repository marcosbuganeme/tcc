package br.com.cvagal.negocio.impl;

import java.util.Collection;

import javax.inject.Inject;

import br.com.cvagal.modelo.Empresa;
import br.com.cvagal.modelo.Vaga;
import br.com.cvagal.negocio.VagaServicoFacade;
import br.com.cvagal.persistencia.EmpresaDAO;
import br.com.cvagal.persistencia.VagaDAO;

/**
 * <p>
 * <b>Título:</b> VagaServico.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por implementar a interface responsável pelo facade da entidade <i>Vaga</i>.
 * </p>
 *
 * Data de criação: 21/11/2014
 *
 * @author marcosbuganeme
 *
 * @author Leides Rodrigues
 *
 * @version 1.0.0
 */
public class VagaServico extends Servico<Vaga> implements VagaServicoFacade {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -7168038611427652238L;

	/** Atributo dao. */
	@Inject
	private VagaDAO dao;

	/** Atributo empresaDAO. */
	@Inject
	private EmpresaDAO empresaDAO;

	@Override
	public Vaga obterVagaPorSKU(final String sku) {

		return this.getDAO().obterVagaPorSKU(sku);
	}

	@Override
	public Collection<Empresa> listarTodasEmpresas() {

		return this.empresaDAO.listar();
	}

	@Override
	public VagaDAO getDAO() {

		return this.dao;
	}
}
