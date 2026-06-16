package br.edu.ifpb.biblioteca.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import br.edu.ifpb.biblioteca.interfaces.Emprestavel;
import br.edu.ifpb.biblioteca.util.Cores;

@Data
@EqualsAndHashCode(callSuper = true)

public class AudioLivro extends Livro implements Emprestavel {

    private int duracaoMinutos;

    public AudioLivro(
            int id,
            String titulo,
            String autor,
            String ISBN,
            Editora editora,
            int ano,
            String edicao,
            String genero,
            String sinopse,
            String status,
            int duracaoMinutos) {

        super(
                id,
                titulo,
                autor,
                ISBN,
                editora,
                ano,
                0, // audiolivro não possui páginas
                edicao,
                genero,
                sinopse,
                status);

        this.duracaoMinutos = duracaoMinutos;
    }

    @Override
    public boolean emprestar() {
        return true;
    }

    @Override
    public boolean devolver() {
        return true;
    }

    @Override
    public String toString() {

        return "\n-----------------------------" +
                "\nID: " + getId() +
                "\nTítulo: " + getTitulo() +
                "\nAutor: " + getAutor() +
                "\nISBN: " + getISBN() +
                "\nEditora: " + getEditora().getNome() +
                "\nAno: " + getAno() +
                "\nDuração: " + duracaoMinutos + " minutos" +
                "\nEdição: " + getEdicao() +
                "\nGênero: " + getGenero() +
                "\nStatus: " + Cores.status(getStatus()) +
                "\n-----------------------------";
    }
}
