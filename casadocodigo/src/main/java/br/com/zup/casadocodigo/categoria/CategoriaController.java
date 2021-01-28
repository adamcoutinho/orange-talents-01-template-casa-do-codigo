package br.com.zup.casadocodigo.categoria;

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
@RequestMapping("/categoria")
public class CategoriaController {


    @Autowired
    private EntityManager manager;

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<?> create(@RequestBody @Valid CategoriaFormRequest request) {
        Categoria categoria = request.toModel();
        this.manager.persist(categoria);
        return ResponseEntity.status(HttpStatus.OK).body(categoria);
    }


}
