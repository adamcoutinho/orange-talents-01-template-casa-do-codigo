package br.com.zup.casadocodigo.fluxo.compraparcial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.validation.Valid;

@RestController
@RequestMapping("/fluxo")
public class FluxoController {

    @Autowired
    private EntityManager manager;

    @Autowired
    private DadosPessoaisCpfCnpjBindValidator documentoCpnCnpjValidator;

    @Autowired
    private VerificaPaisEstado verificaPaisEstado;

    @InitBinder
    public void InitBinder(WebDataBinder binder){
        binder.addValidators(this.documentoCpnCnpjValidator,this.verificaPaisEstado);
    }

    @PostMapping("/cadastro-parcial")
    public ResponseEntity<?> create(@RequestBody @Valid FluxoFormRequest request) {

        DadosPessoais dadosPessoais  =request.toModel(this.manager);

        return ResponseEntity.status(HttpStatus.OK).body(dadosPessoais);
    }


}
