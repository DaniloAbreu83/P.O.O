package br.edu.ifpb.biblioteca.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Emprestimo {
    private int idUsuario;
    private String tituloItem;
    private String tipoItem;
    private int prazoDias;
    private int diasAtraso;
    private double multa;
    private String status;
    private String statusMulta;

}


