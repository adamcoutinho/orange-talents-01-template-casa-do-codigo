package br.com.zup.casadocodigo.estado;

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
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    private EntityManager manager;

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<?> create(@RequestBody @Valid EstadoFormRequest request) {
        Estado estado = request.toModel(manager);
        manager.persist(estado);
        return ResponseEntity.status(HttpStatus.OK).body(estado);
    }
}
