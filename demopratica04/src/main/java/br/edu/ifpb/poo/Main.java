package br.edu.ifpb.poo;

public class Main {
    public static void main(String[] args) {
        double celsius = 25.0;
        ConversorTemperatura conversor = new ConversorTemperatura();
        double fahrenheit = conversor.celsiusParaFhrenheit(celsius);
        System.out.println(celsius + "°C equivalente a " + fahrenheit + "°F");;
    }
}