package br.com.zup.casadocodigo.detalhelivro;

import br.com.zup.casadocodigo.livro.Livro;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.Optional;

@RestController
public class DetalheLivroController {

    @Autowired
    private EntityManager manager;

    @GetMapping("/livro/buscar/{id}")
    public ResponseEntity<?> getMethodName(@RequestBody @PathVariable("id") Long id ) throws NotFoundException {

        Optional<Livro>  livro = Optional.ofNullable(this.manager.find(Livro.class,id));

        if(livro.isPresent()){
            DetalheLivroFormResponse detalheLivroFormResponse = new DetalheLivroFormResponse(livro.get());

            return ResponseEntity.status(HttpStatus.OK).body(detalheLivroFormResponse);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }

}
