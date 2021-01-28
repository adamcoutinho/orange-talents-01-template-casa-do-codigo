package br.com.zup.casadocodigo.estado;

import br.com.zup.casadocodigo.pais.Pais;
import br.com.zup.casadocodigo.validation.UniqueValue;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

public class EstadoFormRequest {

    @NotNull(message = "id do país não pode ser nulo")
    private Long idPais;
    @UniqueValue(domainClass = Estado.class,fieldName = "nome",message = "estado já existe.")
    private String nome;


    public  Estado toModel(EntityManager manager){
        Pais pais = manager.find(Pais.class,idPais);
        return new Estado(this.nome, pais);
    }

    public Long getIdPais() {
        return idPais;
    }

    public String getNome() {
        return nome;
    }
}
