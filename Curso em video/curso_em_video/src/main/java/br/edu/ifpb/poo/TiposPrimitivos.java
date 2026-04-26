package br.edu.ifpb.poo;

import java.util.Scanner;

public class TiposPrimitivos {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        float n1 = teclado.nextFloat();
        float n2 = teclado.nextFloat();
        float m = (n1 + n2)/2;
        System.out.println("Sua media é: " + m);
        if (m >= 9.0) {
            System.out.println("Parabéns");
        }
        else {
            System.out.println("Estude mais na proxima prova");
        }    teclado.close();
    }


}
