package br.com.zup.casadocodigo.pais;

import br.com.zup.casadocodigo.validation.UniqueValue;

import javax.validation.constraints.NotBlank;

public class PaisFormRequest {

    @NotBlank(message = "infome o nome do país.")
    @UniqueValue(domainClass = Pais.class,fieldName = "nome", message = "país já existe.")
    private String nome;

    public Pais toModel() {
        return new Pais(this.nome);
    }

    public String getNome() {
        return nome;
    }
}
