package br.edu.ifpb.biblioteca.util;

import br.edu.ifpb.biblioteca.service.BibliotecaService;

public class InterfaceUtils {

    public static void exibirResumo(BibliotecaService service) {

        System.out.println();

        System.out.println(Cores.CIANO +
                "╔═════════════════════════════════╗");

        System.out.printf(
                "║ %-31s ║%n",
                "RESUMO DO SISTEMA");

        System.out.println(
                "╠═════════════════════════════════╣");

        System.out.printf(
                "║ %-31s ║%n",
                "Usuários cadastrados: " + service.getTotalUsuarios());

        System.out.printf(
                "║ %-31s ║%n",
                "Itens disponíveis: " + service.getTotalItensDisponiveis());

        System.out.printf(
                "║ %-31s ║%n",
                "Empréstimos em aberto: " + service.getTotalEmprestimosEmAberto());

        System.out.println(
                "╚═════════════════════════════════╝"
                        + Cores.RESET);

    }
}
