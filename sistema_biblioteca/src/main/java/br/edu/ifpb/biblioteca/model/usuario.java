package br.edu.ifpb.biblioteca.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {
    private int id;
    private String nome;
    private String tipo;
    private int emprestimosAtivos;
    private boolean bloqueado;

}
