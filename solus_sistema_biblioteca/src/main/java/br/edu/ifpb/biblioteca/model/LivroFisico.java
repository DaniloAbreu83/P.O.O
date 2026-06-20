package br.edu.ifpb.biblioteca.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import br.edu.ifpb.biblioteca.interfaces.Emprestavel;
import br.edu.ifpb.biblioteca.util.Cores;

@Data
@EqualsAndHashCode(callSuper = true)

public class LivroFisico extends Livro implements Emprestavel {

    public LivroFisico(
            int id,
            String titulo,
            String autor,
            String ISBN,
            Editora editora,
            int ano,
            int paginas,
            String edicao,
            String genero,
            String sinopse,
            String status) {

        super(
                id,
                titulo,
                autor,
                ISBN,
                editora,
                ano,
                paginas,
                edicao,
                genero,
                sinopse,
                status);
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
                "\nPáginas: " + getPaginas() +
                "\nEdição: " + getEdicao() +
                "\nGênero: " + getGenero() +
                "\nStatus: " + Cores.status(getStatus()) +
                "\n-----------------------------";
    }
}
