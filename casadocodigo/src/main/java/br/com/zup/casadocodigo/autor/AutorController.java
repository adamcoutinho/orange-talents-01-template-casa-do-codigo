package br.com.zup.casadocodigo.autor;

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
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private EntityManager manager;

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<?> create(@RequestBody @Valid AutorFormRequest request) {
        Autor autor = request.toModel();

        manager.persist(autor);

        return ResponseEntity.status(HttpStatus.OK).body(autor);
    }

}
