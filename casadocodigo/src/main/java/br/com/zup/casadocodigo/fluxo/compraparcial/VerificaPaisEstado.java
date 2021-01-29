package br.com.zup.casadocodigo.fluxo.compraparcial;

import br.com.zup.casadocodigo.estado.Estado;
import br.com.zup.casadocodigo.pais.Pais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import java.util.Optional;

@Component
public class VerificaPaisEstado implements Validator {
    @Autowired
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> kclass) {
        return FluxoFormRequest.class.isAssignableFrom(kclass);
    }

    @Override
    public void validate(Object target, Errors errors) {

        FluxoFormRequest request = (FluxoFormRequest) target;

        Optional<Estado> estado = request.toEstado(manager);

        Optional<Pais> pais = request.toPais(manager);
        if (!pais.isEmpty()) {
            if (!estado.get().pertencePais(pais.get())) {
                errors.rejectValue("idEstado", null, "Estado não pertence ao país.");
            }
        }
    }
}
