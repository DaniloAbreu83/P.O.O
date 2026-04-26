package br.edu.ifpb.poo;

public class Pescador {

    String nome;

    public static void main(String[] args) {
        Pescador p1 = new Pescador();
        p1.nome = "Carlos";

        Pescador p2 = p1;

        p2.nome = "Jose";
        
        System.out.println("p1 = " + p1.nome);
        System.out.println("p2 = " + p2.nome);
    }
}
