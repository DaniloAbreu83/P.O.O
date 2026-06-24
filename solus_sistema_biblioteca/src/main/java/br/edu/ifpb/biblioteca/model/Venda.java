package br.edu.ifpb.biblioteca.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

/**
 * Representa uma venda realizada pelo sistema,
 * registrando item vendido, valor e data da operação.
 */
public class Venda {
    private int id;
    private Jogo jogo;
    private double valorVenda;
    private LocalDate dataVenda;

    @Override
public String toString() {

    return "\n-----------------------------" +
           "\nID Venda: " + id +
           "\nJogo: " + jogo.getNome() +
           "\nValor: R$ %.2f".formatted(valorVenda) +
           "\nData: " + dataVenda +
           "\n-----------------------------";
}
}
