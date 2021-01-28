package br.com.zup.casadocodigo.pais;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "pais")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_pais")
    @SequenceGenerator(name = "sequence_pais",sequenceName = "sq_pais",allocationSize = 1)
    private Long id;

    @NotBlank(message = "informe o nome do país.")
    @Column(unique = true)
    private String nome;
    @Deprecated
    public Pais() {
    }

    public Pais(@NotBlank(message = "informe o nome do país.") String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
