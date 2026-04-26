package br.edu.ifpb.poo;

public class SubnetApp {
    public static void main(String[] args) {
        int[] ip = { 192, 168, 0, 1 };
        int[] mask = { 255, 255, 255, 0 };

        Subnet s = new Subnet(ip, mask);
        System.out.println(s);
        int[] rede = s.calculaRede();
        System.out.println("rede: " + ip[0] + "." + ip[1] + "." + ip[2] + "." + ip[3]);
    }

}
