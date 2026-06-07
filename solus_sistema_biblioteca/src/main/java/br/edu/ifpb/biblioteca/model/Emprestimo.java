package br.edu.ifpb.biblioteca.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Emprestimo {

    private int id;

    private Usuario usuario;

    private String tituloItem;

    private LocalDate dataEmprestimo;

    private LocalDate dataPrevistaDevolucao;

    private LocalDate dataDevolucao;

    private double multa;

    private String status;


@Override
public String toString() {
    return "\n-----------------------------" +
            "\nID: " + id +
            "\nUsuário: " + usuario.getNome() +
            "\nTítulo: " + tituloItem +
            "\nData Empréstimo: " + dataEmprestimo +
            "\nData Prevista: " + dataPrevistaDevolucao +
            "\nData Devolução: " + dataDevolucao +
            "\nMulta: R$ " + multa +
            "\nStatus: " + status +
            "\n-----------------------------";         
}
}
