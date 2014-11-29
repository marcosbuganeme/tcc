package br.com.cvagal.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.cvagal.modelo.Empresa;
import br.com.cvagal.negocio.EmpresaServicoFacade;
import br.com.cvagal.utilitarios.cdi.CDIServiceLocator;

/**
 * <p>
 * <b>Título:</b> EmpresaConversor.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por converter a entidade <code>Empresa</code> do estado objeto puro para um objeto do tipo String e vice versa.
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
@FacesConverter(forClass = Empresa.class)
public class EmpresaConversor implements Converter {

	/** Atributo servicoFacade. */
	private final EmpresaServicoFacade servicoFacade;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public EmpresaConversor() {

		this.servicoFacade = CDIServiceLocator.getBean(EmpresaServicoFacade.class);
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	public Object getAsObject(final FacesContext context, final UIComponent component, final String value) {

		Empresa empresaRetornada = null;

		if (value != null) {

			final Long identificador = new Long(value);

			empresaRetornada = this.servicoFacade.obter(identificador);
		}

		return empresaRetornada;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public String getAsString(final FacesContext context, final UIComponent component, final Object value) {

		if (value != null) {

			final Empresa empresaConvertida = (Empresa) value;

			return empresaConvertida.getIdentificador() == null ? null : empresaConvertida.getIdentificador().toString();
		}

		return "";
	}

}
