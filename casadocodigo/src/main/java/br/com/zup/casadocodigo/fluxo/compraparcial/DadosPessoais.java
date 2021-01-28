package br.com.zup.casadocodigo.fluxo.compraparcial;

import br.com.zup.casadocodigo.estado.Estado;
import br.com.zup.casadocodigo.pais.Pais;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "dados_pessoais")
public class DadosPessoais {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_dados_pessoais")
    @SequenceGenerator(name = "sequence_dados_pessoais", sequenceName = "sq_dados_pessoais", allocationSize = 1)
    private Long id;

    @NotBlank(message = "informe um email.")
    @Email(message = "email não possui formato valido.")
    private String email;
    @NotBlank(message = "informe o nome.")
    private String nome;
    @NotBlank(message = "informe um sobrenome.")
    private String sobrenome;
    @NotBlank(message = "informe cpf/cnpj.")
    private String documento;
    @NotBlank(message = "informe um endereço.")
    private String endereco;
    @NotBlank(message = "informe um complemento.")
    private String complemento;
    @NotBlank(message = "informe uma cidade.")
    private String cidade;
    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull(message = "pais não pode ser nulo.")
    private Pais pais;
    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull(message = "estado não pode ser nulo.")
    private Estado estado;
    @NotBlank(message = "informe um telefone.")
    private String telefone;
    @NotBlank(message = "informe um cep.")
    private String cep;

    public DadosPessoais(@NotBlank(message = "informe um email.") @Email(message = "email não possui formato valido.") String email, @NotBlank(message = "informe o nome.") String nome, @NotBlank(message = "informe um sobrenome.") String sobrenome, @NotBlank(message = "informe cpf/cnpj.") String documento, @NotBlank(message = "informe um endereço.") String endereco, @NotBlank(message = "informe um complemento.") String complemento, @NotBlank(message = "informe uma cidade.") String cidade, @NotNull(message = "pais não pode ser nulo.") Pais pais, @NotNull(message = "estado não pode ser nulo.") Estado estado, @NotBlank(message = "informe um telefone.") String telefone, @NotBlank(message = "informe um cep.") String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }


    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Pais getPais() {
        return pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }


}
