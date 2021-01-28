package br.com.zup.casadocodigo.estado;

import br.com.zup.casadocodigo.pais.Pais;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "estado")
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_estado")
    @SequenceGenerator(name = "sequence_estado",sequenceName = "sq_estado",allocationSize = 1)
    private Long id;

    @NotBlank(message = "informe o estado.")
    @Column(unique = true)
    private String nome;

    @NotNull(message = "informe o país.")
    @ManyToOne
    private Pais pais;

    @Deprecated
    public Estado() {
    }

    public Estado(@NotBlank(message = "informe o estado.") String nome, @NotNull Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public String getNome() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }
}
