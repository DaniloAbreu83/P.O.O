package br.edu.ifpb.biblioteca.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import br.edu.ifpb.biblioteca.interfaces.Emprestavel;
import br.edu.ifpb.biblioteca.util.Cores;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)

public class Revista extends Item implements Emprestavel {
    private String ISSN;
    private int volume;
    private int numero;
    private Editora editora;
    private LocalDate dataPublicacao;
    private String status;

    public Revista(int id, String titulo, String autor, String ISSN, int volume, int numero, Editora editora,
            LocalDate dataPublicacao, String status) {
        super(id, titulo, autor);
        this.ISSN = ISSN;
        this.volume = volume;
        this.numero = numero;
        this.editora = editora;
        this.dataPublicacao = dataPublicacao;
        this.status = status;
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
                "\nISSN: " + ISSN +
                "\nVolume: " + volume +
                "\nNúmero: " + numero +
                "\nEditora: " + editora.getNome() +
                "\nData de Publicação: " + dataPublicacao +
                "\nStatus: " + Cores.status(status)+
                "\n-----------------------------";
    }

}
