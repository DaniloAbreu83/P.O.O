package br.edu.ifpb.biblioteca.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public abstract class Item {

    private int id;
    private String titulo;
    private String autor;

}
