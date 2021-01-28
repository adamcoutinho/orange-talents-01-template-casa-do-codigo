package br.com.zup.casadocodigo.categoria;

import br.com.zup.casadocodigo.livro.Livro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_categoria")
    @SequenceGenerator(name = "sequence_categoria",sequenceName = "sq_categoria",allocationSize = 1)
    private Long id;

    @NotBlank(message = "informe o nome.")
    @Column(unique = true)
    private String nome;

    @Deprecated
    public Categoria() {
    }

    public Categoria(@NotBlank(message = "informe o nome.") String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
