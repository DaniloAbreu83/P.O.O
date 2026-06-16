package br.edu.ifpb.biblioteca.model;

import br.edu.ifpb.biblioteca.util.Cores;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)

public class Livro extends Item {
    private String ISBN;
    private Editora editora;
    private int ano;
    private int paginas;
    private String edicao;
    private String genero;
    private String sinopse;
    private String status;

    public Livro(int id, String titulo, String autor, String ISBN, Editora editora, int ano, int paginas, String edicao,
            String genero, String sinopse, String status) {
        super(id, titulo, autor);

        this.ISBN = ISBN;
        this.editora = editora;
        this.ano = ano;
        this.paginas = paginas;
        this.edicao = edicao;
        this.genero = genero;
        this.sinopse = sinopse;
        this.status = status;
    }

    @Override
    public String toString() {

        return "\n-----------------------------" +
                "\nID: " + getId() +
                "\nTítulo: " + getTitulo() +
                "\nAutor: " + getAutor() +
                "\nISBN: " + ISBN +
                "\nEditora: " + editora.getNome() +
                "\nAno: " + ano +
                "\nPáginas: " + paginas +
                "\nEdição: " + edicao +
                "\nGênero: " + genero +
                "\nStatus: " + Cores.status(status) +
                "\n-----------------------------";
    }

}