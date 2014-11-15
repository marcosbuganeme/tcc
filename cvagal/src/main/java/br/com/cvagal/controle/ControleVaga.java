package br.com.cvagal.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.cvagal.modelo.Vaga;

/**
 * <p>
 * <b>Título:</b> ControleVaga.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por controlar as requisições da tela de <code>Vaga</code>.
 * </p>
 *
 * Data de criação: 15/11/2014
 *
 * @author marcosbuganeme
 *
 * @author Leides Rodrigues
 *
 * @version 1.0.0
 */
@Named
@ViewScoped
public class ControleVaga implements Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1779164265112638554L;

	/** Atributo colecaoVagas. */
	private Collection<Vaga> colecaoVagas;

	/** Atributo isApresentarLogin. */
	private boolean isApresentarLogin;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public ControleVaga() {

	}

	/**
	 * Método responsável por carregar o relatório de vagas disponíveis.
	 *
	 * @author marcosbuganeme
	 *
	 */
	@PostConstruct
	public void carregarRelatorio() {

		this.colecaoVagas = new ArrayList<Vaga>(0);

		for (int i = 0; i < 20; i++) {

			final Vaga vaga = new Vaga(i, 1000.00 + i, "descricao");

			this.colecaoVagas.add(vaga);
		}
	}

	/**
	 * Retorna o valor do atributo <code>colecaoVagas</code>
	 *
	 * @return <code>Collection<Vaga></code>
	 */
	public Collection<Vaga> getColecaoVagas() {

		return this.colecaoVagas;
	}

	/**
	 * Retorna o valor do atributo <code>isApresentarLogin</code>
	 *
	 * @return <code>boolean</code>
	 */
	public boolean isApresentarLogin() {

		return this.isApresentarLogin;
	}

	/**
	 * Define o valor do atributo <code>isApresentarLogin</code>.
	 *
	 * @param isApresentarLogin
	 */
	public void setApresentarLogin(final boolean isApresentarLogin) {

		this.isApresentarLogin = isApresentarLogin;
	}

}
