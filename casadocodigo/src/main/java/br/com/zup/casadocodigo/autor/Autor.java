package br.com.zup.casadocodigo.autor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_autor")
    @SequenceGenerator(name = "sequence_autor",sequenceName = "sq_autor",allocationSize = 1)
    private Long id;

    private LocalDateTime instant = LocalDateTime.now();

    @NotBlank
    @Email(message = "email não possui formato valido.")
    @Column(unique = true)
    private String email;
    @NotBlank(message = "informe o nome.")
    private String nome;

    @NotBlank(message = "informe a descrição.")
    @Size(max=400, message = "descrição não pode passar mais do  que 400 caracters")
    private String descricao;

    @Deprecated
    public Autor() {
    }

    public Autor(@NotBlank @Email(message = "email não possui formato valido.") String email, @NotBlank(message = "informe o nome.") String nome, @NotBlank(message = "informe a descrição.") @Size(max = 400, message = "descrição não pode passar mais do  que 400 caracters") String descricao) {
        this.email = email;
        this.nome = nome;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "instant=" + instant +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    public LocalDateTime getInstant() {
        return instant;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
