package br.com.zup.casadocodigo.fluxo.compraparcial;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class DadosPessoaisCpfCnpjBindValidator implements Validator {

    @Override
    public boolean supports(Class<?> kclass) {
        return FluxoFormRequest.class.isAssignableFrom(kclass);
    }

    @Override
    public void validate(Object documentObject, Errors errors) {

        FluxoFormRequest fluxoFormRequest = (FluxoFormRequest) documentObject;
        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);

        CNPJValidator cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);

        if (!(cpfValidator.isValid(fluxoFormRequest.getDocumento(), null) || cnpjValidator.isValid(fluxoFormRequest.getDocumento(), null))) {
            errors.rejectValue("documento", null, "cpf ou cnpj inválido.");
        }


    }


}
