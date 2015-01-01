package br.com.cvagal.negocio.impl;

import java.net.MalformedURLException;
import java.net.URL;

import javax.inject.Inject;
import javax.persistence.Transient;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

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
	public Endereco obterEnderecoPorCEP(final String cep) {

		Endereco endereco = null;

		URL url;

		JAXBContext jc;

		Unmarshaller u;

		try {

			jc = JAXBContext.newInstance(Endereco.class);

			u = jc.createUnmarshaller();

			url = new URL("http://www.devmedia.com.br/devware/cep/service/?cep=" + cep + "&chave=RE6A8L9CIO&formato=xml");

			endereco = (Endereco) u.unmarshal(url);

			endereco.setCep(cep);

		} catch (final MalformedURLException e) {

			e.printStackTrace();

		} catch (final JAXBException e) {

			e.printStackTrace();
		}

		return endereco;
	}

	@Override
	public EnderecoDAO getDAO() {

		return this.dao;
	}

}
