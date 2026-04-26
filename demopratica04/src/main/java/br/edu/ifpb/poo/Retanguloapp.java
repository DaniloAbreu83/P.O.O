package br.edu.ifpb.poo;

public class Retanguloapp {
    public static void main(String[] args) {
        Retangulo r = new Retangulo(5.0, 3.0);

        System.out.println("Retangulo: Ret(Base = 5.0, Alttura = 3.0)");
        System.out.println("> Area: " + r.calcularArea());
        System.out.println("> Perimetro: " + r.calcularPerimetro());
    }
}
