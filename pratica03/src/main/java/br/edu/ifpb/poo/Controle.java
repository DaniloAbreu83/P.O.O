package br.edu.ifpb.poo;

public class Controle {
    public static void main2(String[] args) {
        int[] numeros = { 1, 2, 3, 4, 5 };
        for (int num : numeros) {
            System.out.println(num);
        }
        String texto;
        texto = "Programa Java, Orientado a Objetos";
        System.out.println(texto.length());
        System.out.println("Maiúsculo: " + texto.toUpperCase());
        System.out.println("Minúsculo: " + texto.toLowerCase());
        System.out.println("Contém Java? " + texto.contains("Java"));
        System.out.println("Substituição: " + texto.replace("Java", "Python"));
        System.out.println("Substring: " + texto.substring(0, 11));
    }

    public static void main (String[] args) {
        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String ("Java");
        String s4 = "JAVA";

        System.out.println("s1 == s2:" + (s1 == s2));
        System.out.println("s1 == s3:" + (s1 == s3));
        System.out.println("s1.equals(s2):" + s1.equals(s2));
        System.out.println("s1.equals(s3):" + s1.equals(s4));
        System.out.println("s1.equalsIngnoreCase(s4):" + s1.equalsIgnoreCase(s4));
        System.out.println("s1.equals");

    }
}
