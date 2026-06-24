package br.edu.ifpb.biblioteca.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

/**
 * Classe base dos itens do acervo da biblioteca.
 * Reúne atributos comuns como id, título e autor.
 */
public abstract class Item {

    private int id;
    private String titulo;
    private String autor;

}
