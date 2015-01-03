package br.com.cvagal.validador;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

import com.sun.faces.util.MessageFactory;

@FacesValidator("br.com.cvagal.Comprovante")
public class CurriculoValidador implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		Part curriculoCandidato = (Part) value;

		if (curriculoCandidato != null && !"application/pdf".equals(curriculoCandidato.getContentType())) {

			Object label = MessageFactory.getLabel(context, component);

			String descricaoErro = label + " " + " não é uma extenção válida";

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, descricaoErro, descricaoErro);

			throw new ValidatorException(message);
		}
	}

}
