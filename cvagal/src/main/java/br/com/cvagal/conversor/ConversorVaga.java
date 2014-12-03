package br.com.cvagal.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang3.StringUtils;

import br.com.cvagal.modelo.Vaga;
import br.com.cvagal.negocio.VagaServicoFacade;
import br.com.cvagal.utilitarios.cdi.CDIServiceLocator;

@FacesConverter("br.com.cvgal.conversor.conversorVaga")
public class ConversorVaga implements Converter {

	/** Atributo servicoFacade. */
	private VagaServicoFacade servicoFacade;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public ConversorVaga() {

		this.servicoFacade = CDIServiceLocator.getBean(VagaServicoFacade.class);
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

		Vaga vagaRetornada = null;

		if (StringUtils.isNotEmpty(value)) {

			vagaRetornada =	this.servicoFacade.obterVagaPorSKU(value);
		}

		return vagaRetornada;
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

			final Vaga vagaRetornada = (Vaga) value;

			return vagaRetornada != null ? vagaRetornada.getSku() : null;
		}

		return null;
	}

}
