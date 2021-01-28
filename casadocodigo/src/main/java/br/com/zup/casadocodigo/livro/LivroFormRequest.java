package br.com.zup.casadocodigo.livro;

import br.com.zup.casadocodigo.autor.Autor;
import br.com.zup.casadocodigo.categoria.Categoria;
import br.com.zup.casadocodigo.validation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroFormRequest {
    @NotBlank(message = "informe o título.")
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo", message = "Título já existe.")
    private String titulo;
    @NotBlank(message = "informe o resumo.")
    @Size(max = 500, message = "só é permitido no máximo 500 caracteres.")
    private String resumo;

    private String sumario;
    @Min(20)
    private BigDecimal preco;
    @Min(value = 100 , message = "mínimo de páginas é 100.")
    private Integer numeroPaginas;

    @UniqueValue(domainClass = Livro.class, fieldName = "isbn", message = "Isbn já existe.")
    @NotBlank(message = "informe o isbn.")
    private String isbn;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy",shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull(message = "categoria é obrigatória.")
    private Long idCategoria;

    @NotNull(message = "autor é obrigatório.")
    private Long idAutor;

    public Livro toModel(EntityManager manager){

        Categoria categoria = manager.find(Categoria.class, this.idCategoria);

        Autor autor = manager.find(Autor.class,this.idAutor);

        return new Livro(this.titulo,this.resumo,this.sumario,this.preco,this.numeroPaginas,this.isbn,this.dataPublicacao,categoria,autor);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public Long getIdAutor() {
        return idAutor;
    }
}
