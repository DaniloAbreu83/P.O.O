package br.edu.ifpb.biblioteca.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.biblioteca.model.Jogo;
import br.edu.ifpb.biblioteca.model.Venda;

public class VendaService {

    private List<Venda> vendas = new ArrayList<>();

    public boolean realizarVendaJogo(Jogo jogo) {

        if (jogo == null) {
            return false;
        }

        if (!jogo.getStatus().equalsIgnoreCase("DISPONIVEL")) {
            return false;
        }

        Venda venda = new Venda(
                vendas.size() + 1,
                jogo,
                jogo.getPreco(),
                LocalDate.now());

        vendas.add(venda);

        jogo.setStatus("VENDIDO");

        return true;
    }

    public List<Venda> listarVendas() {
        return vendas;
    }
}
