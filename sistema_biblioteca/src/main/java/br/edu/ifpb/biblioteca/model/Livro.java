package br.edu.ifpb.biblioteca.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Livro {
    private String ISBN;
    private String titulo;
    private String autor;
    private String editora;
    private int ano;
    private int paginas;
    private String edicao;
    private String genero;
    private String sinopse;
    private String status;
}