package br.edu.ifpb.biblioteca.menu;

import br.edu.ifpb.biblioteca.util.Cores;

public class CabecalhoMenu {

    public static void exibir(String local) {

        System.out.println();
        System.out.println(Cores.CIANO + "==================================" + Cores.RESET);
        System.out.println(Cores.CIANO + "SOLUS - SISTEMA DE BIBLIOTECA" + Cores.RESET);
        System.out.println(Cores.CIANO + "LOCAL: " + local + Cores.RESET);
        System.out.println(Cores.CIANO + "==================================" + Cores.RESET);
        
    }
}
