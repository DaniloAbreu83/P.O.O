package br.edu.ifpb.biblioteca.util;

public class Cores {

    public static final String RESET = "\u001B[0m";

    public static final String VERDE = "\u001B[32m";
    public static final String VERMELHO = "\u001B[31m";
    public static final String AMARELO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String CIANO = "\u001B[36m";

    public static void sucesso(String mensagem) {

        System.out.println(
                VERDE +
                        "[SUCESSO] " +
                        mensagem +
                        RESET);
    }

    public static void erro(String mensagem) {

        System.out.println(
                VERMELHO +
                        "[ERRO] " +
                        mensagem +
                        RESET);
    }

    public static void aviso(String mensagem) {

        System.out.println(
                AMARELO +
                        "[AVISO] " +
                        mensagem +
                        RESET);
    }

    public static void info(String mensagem) {

        System.out.println(
                AZUL +
                        "[INFO] " +
                        mensagem +
                        RESET);
    }

    public static String status(String status) {

        switch (status.toUpperCase()) {

            case "DISPONIVEL":
                return VERDE + status + RESET;

            case "EMPRESTADO":
                return AMARELO + status + RESET;

            case "DEVOLVIDO":
                return AZUL + status + RESET;

            case "BLOQUEADO":
                return VERMELHO + status + RESET;

            default:
                return status;
        }
    }
}
