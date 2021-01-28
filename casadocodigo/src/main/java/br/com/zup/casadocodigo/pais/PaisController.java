package br.com.zup.casadocodigo.pais;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @Autowired
    private EntityManager manager;

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<?> create(@RequestBody @Valid PaisFormRequest request) {

        Pais pais = request.toModel();

        this.manager.persist(pais);

        return ResponseEntity.status(HttpStatus.OK).body(pais);
    }
}
