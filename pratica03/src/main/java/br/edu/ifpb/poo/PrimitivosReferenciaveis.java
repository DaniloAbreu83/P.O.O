package br.edu.ifpb.poo;

public class PrimitivosReferenciaveis {
    public static void main(String[] args) {
        int a = 50;
        int b = a;
        b = 100;
        System.out.println("valor de a = " + a);
        System.out.println("valor de b = " + b);
    }

}
