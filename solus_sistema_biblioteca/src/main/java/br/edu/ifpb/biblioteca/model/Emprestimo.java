package br.edu.ifpb.biblioteca.model;

import br.edu.ifpb.biblioteca.util.Cores;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

/**
 * Representa um empréstimo realizado por um usuário,
 * armazenando datas, status e informações de multa.
 */
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
            "\nMulta: R$ %.2f".formatted(multa) +
            "\nStatus: " + Cores.status(status) +
            "\n-----------------------------";         
}
}
