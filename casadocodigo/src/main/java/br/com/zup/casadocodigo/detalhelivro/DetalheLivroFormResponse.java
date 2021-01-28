package br.com.zup.casadocodigo.detalhelivro;

import br.com.zup.casadocodigo.livro.Livro;

import java.time.format.DateTimeFormatter;

public class DetalheLivroFormResponse {

    private  String titulo;
    private  String autor;
    private  String resumo;
    private  String sumario;
    private  Integer numeroPaginas;
    private  String isbn;
    private  String dataPublicacao;


    public DetalheLivroFormResponse(Livro  livro) {
        this.titulo = livro.getTitulo();
        this.autor= livro.getAutor().getNome();
        this.resumo= livro.getResumo();
        this.sumario = livro.getSumario();
        this.numeroPaginas= livro.getNumeroPaginas();
        this.isbn= livro.getIsbn();
        this.dataPublicacao= DateTimeFormatter.ofPattern("dd/MM/yyyy").format(livro.getDataPublicacao());
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }
}
