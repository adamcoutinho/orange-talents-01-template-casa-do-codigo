package br.com.zup.casadocodigo.categoria;

import br.com.zup.casadocodigo.validation.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CategoriaFormRequest {

    @NotBlank(message = "informe o nome.")
    @UniqueValue(domainClass = Categoria.class,fieldName = "nome",message = "categoria já existe.")
    private String nome;

    public Categoria toModel() {
        return new Categoria(this.nome);
    }

    public String getNome() {
        return nome;
    }
}
