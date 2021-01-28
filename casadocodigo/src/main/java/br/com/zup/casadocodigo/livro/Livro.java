package br.com.zup.casadocodigo.livro;

import br.com.zup.casadocodigo.autor.Autor;
import br.com.zup.casadocodigo.categoria.Categoria;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_livro")
    @SequenceGenerator(name = "sequence_livro",sequenceName = "sq_livro",allocationSize = 1)
    private Long id;

    @NotBlank(message = "Informe o título.")
    @Column(unique = true)
    private String titulo;

    @NotBlank(message = "informe o resumo.")
    @Size(max = 500)
    private String resumo;

    private String sumario;

    @Positive( message = "tem que ser valor positivo.")
    @Min(value = 20,message = "mínimo é 20.00.")
    private BigDecimal preco;

    @Min(value = 100,message = "número mínimo de páginas é 100.")
    private Integer numeroPaginas;

    @NotBlank(message = "informe o isbn.")
    @Column(unique = true)
    private String isbn;

    @Future(message = "informe uma data posterior a data atual.")
    @JsonFormat(pattern = "dd/MM/yyyy",shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull(message = "categoria é obrigatória.")
    @ManyToOne
    private Categoria categoria;

    @NotNull(message = "autor é obrigatório.")
    @ManyToOne
    private Autor autor;
    @Deprecated
    public Livro() {
    }

    public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario, @Positive @Min(20) BigDecimal preco, @Min(100) Integer numeroPaginas, @NotBlank String isbn, @Future LocalDate dataPublicacao, @NotNull Categoria categoria, @NotNull Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", preço=" + preco +
                ", numeroPaginas=" + numeroPaginas +
                ", isbn='" + isbn + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                ", categoria=" + categoria.getNome() +
                ", autor=" + autor.getNome() +
                '}';
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

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }
}
