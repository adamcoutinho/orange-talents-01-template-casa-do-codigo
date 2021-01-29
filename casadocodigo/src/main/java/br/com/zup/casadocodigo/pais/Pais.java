package br.com.zup.casadocodigo.pais;

import br.com.zup.casadocodigo.estado.Estado;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.List;

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

    @OneToMany(mappedBy = "pais")
    private List<Estado> estados;
    @Deprecated
    public Pais() {
    }
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Pais(@NotBlank(message = "informe o nome do país.") String nome) {
        this.nome = nome;
    }


    public boolean existeEstado(){
        return !this.getEstados().isEmpty();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Estado> getEstados() {
        return estados;
    }
}
