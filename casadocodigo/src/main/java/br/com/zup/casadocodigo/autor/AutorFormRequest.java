package br.com.zup.casadocodigo.autor;

import br.com.zup.casadocodigo.validation.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorFormRequest {

    @NotBlank(message = "informe o email.")
    @Email
    @UniqueValue(domainClass = Autor.class,fieldName = "email", message = "email já existe")
    private String email;

    @NotBlank(message = "informe o nome.")
    private String nome;

    @NotBlank(message = "informe a descrição.")
    @Size(max=400, message = "descrição não pode passar mais do  que 400 caracters")
    private String descricao;


    public Autor toModel(){
        return new Autor(this.getEmail(),this.getNome(),this.getDescricao());
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
