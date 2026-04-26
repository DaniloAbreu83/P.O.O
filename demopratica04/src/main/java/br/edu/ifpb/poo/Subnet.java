package br.edu.ifpb.poo;

public class Subnet {
    private int[] ip;
    private int[] mask;

    public Subnet(int[] ip, int[] mask) {
        this.ip = ip;
        this.mask = mask;
    }

    public int[] calculaRede() {
        int[] network = new int[4];
        for (int i = 0; i < 4; i++) {
            network[i] = ip[i] & mask[i];
        }
        return network;
    }

    public String toString() {
        return "ip: " + ip[0] + "." + ip[1] + "." + ip[2] + "." + ip[3] +
                "\nMáscara: " + mask[0] + "." + mask[1] + "." + mask[2] + "." + mask[3];
    }
}
