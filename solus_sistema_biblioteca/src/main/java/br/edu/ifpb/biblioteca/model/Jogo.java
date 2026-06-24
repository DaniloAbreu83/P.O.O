package br.edu.ifpb.biblioteca.model;

import br.edu.ifpb.biblioteca.interfaces.Emprestavel;
import br.edu.ifpb.biblioteca.interfaces.Vendavel;
import br.edu.ifpb.biblioteca.util.Cores;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

/**
 * Representa um jogo cadastrado no sistema,
 * podendo ser emprestado ou vendido.
 */
public class Jogo implements Emprestavel, Vendavel {

    private int id;
    private String nome;
    private String tipoJogo;
    private int quantidadePecas;
    private double preco;
    private String status;

    public Jogo(int id, String nome, String tipoJogo, int quantidadePecas, double preco, String status) {
        this.id = id;
        this.nome = nome;
        this.tipoJogo = tipoJogo;
        this.quantidadePecas = quantidadePecas;
        this.preco = preco;
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
    public boolean vender() {
        return true;
    }

    @Override
    public String toString() {

        return "\n-----------------------------" +
                "\nID: " + id +
                "\nNome: " + nome +
                "\nTipo: " + tipoJogo +
                "\nQuantidade de Peças: " + quantidadePecas +
                "\nPreço: R$ %.2f".formatted(preco) +
                "\nStatus: " + Cores.status(status) +
                "\n-----------------------------";
    }
}
