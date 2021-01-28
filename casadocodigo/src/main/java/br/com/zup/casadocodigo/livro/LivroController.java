package br.com.zup.casadocodigo.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/livro")
public class LivroController {


    @Autowired
    private EntityManager manager;

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<?> create(@RequestBody @Valid LivroFormRequest request) {
        Livro livro = request.toModel(this.manager);
        this.manager.persist(livro);
        return ResponseEntity.status(HttpStatus.OK).body(livro);
    }


    @GetMapping("/listar")
    public ResponseEntity<?> listarLivros() {

        Optional<List<Livro>> livros = Optional.ofNullable(manager.createQuery("SELECT l FROM Livro l ",Livro.class).getResultList());
        if(livros.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(livros.get());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }


}
