package br.com.zup.casadocodigo.fluxo.compraparcial;

import br.com.zup.casadocodigo.estado.Estado;
import br.com.zup.casadocodigo.pais.Pais;

import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FluxoFormRequest {

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
    @NotNull(message = "pais não pode ser nulo.")
    private Long idPais;
    @NotNull(message = "estado não pode ser nulo.")
    private Long  idEstado;
    @NotBlank(message = "informe um telefone.")
    private String telefone;
    @NotBlank(message = "informe um cep.")
    private String cep;

    public DadosPessoais toModel(EntityManager manager) {
        Pais pais = manager.find(Pais.class,this.idPais);
        Estado estado = manager.find(Estado.class,this.idEstado);
        return new DadosPessoais(this.email,
                this.nome,
                this.sobrenome,
                this.documento,
                this.endereco,
                this.complemento,
                this.cidade,
                pais,
                estado,
                this.telefone,
                this.cep);
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

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}
