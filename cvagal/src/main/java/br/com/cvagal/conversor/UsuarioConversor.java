package br.com.cvagal.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.cvagal.modelo.Usuario;
import br.com.cvagal.negocio.UsuarioServicoFacade;
import br.com.cvagal.utilitarios.cdi.CDIServiceLocator;

/**
 * <p>
 * <b>Título:</b> UsuarioConverter.java
 * </p>
 *
 * <p>
 * <b>Descrição:</b> Classe responsável por converter a entidade <code>Usuario</code> do estado objeto puro para um objeto do tipo String e vice versa.
 * </p>
 *
 * Data de criação: 27/11/2014
 *
 * @author marcosbuganeme
 * 
 * @author Leides Rodrigues
 *
 * @version 1.0.0
 */
@FacesConverter(forClass = Usuario.class)
public class UsuarioConversor implements Converter {

	/** Atributo servicoFacade. */
	private final UsuarioServicoFacade servicoFacade;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public UsuarioConversor() {

		this.servicoFacade = CDIServiceLocator.getBean(UsuarioServicoFacade.class);
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

		Usuario usuarioRetornado = null;

		if (value != null) {

			final Long identificador = new Long(value);

			usuarioRetornado = this.servicoFacade.obter(identificador);
		}

		return usuarioRetornado;
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

			final Usuario usuarioConvertido = (Usuario) value;

			return usuarioConvertido.getIdentificador() == null ? null : usuarioConvertido.getIdentificador().toString();
		}

		return "";
	}

}
