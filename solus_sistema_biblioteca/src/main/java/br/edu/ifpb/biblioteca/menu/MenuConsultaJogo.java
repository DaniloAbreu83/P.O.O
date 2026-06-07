package br.edu.ifpb.biblioteca.menu;

import java.util.Scanner;

import br.edu.ifpb.biblioteca.model.Jogo;
import br.edu.ifpb.biblioteca.service.BibliotecaService;

public class MenuConsultaJogo {

    public static void menuConsultaJogo(
            Scanner sc,
            BibliotecaService service) {

        System.out.println(
                "\n=== CONSULTA DE JOGOS ===");

        int id = MenuCadastro.lerInteiro(
                sc,
                "ID do jogo: ");

        Jogo jogo = service.buscarJogoPorId(id);

        if (jogo != null) {

            System.out.println(
                    "\nJogo encontrado:");

            System.out.println(jogo);

        } else {

            System.out.println(
                    "Jogo não encontrado.");
        }
    }
}
