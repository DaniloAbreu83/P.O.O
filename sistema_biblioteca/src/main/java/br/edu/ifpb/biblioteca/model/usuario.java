package br.edu.ifpb.biblioteca.model;

public class Usuario {
    private int id;
    private String nome;
    private String tipo;
    private int imprestimosAtivo;
    private boolean bloqueado;

    public Usuario( int id, String nome, String tipo, int imprestimosAtivos, boolean bloqueado) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.imprestimosAtivo = imprestimosAtivos;
        this.bloqueado = bloqueado;
    }

    public int getid(){
        return id;
    }

    public String getnome(){
        return nome;
    }

    public String tipo(){
        return tipo;
    }

    public int getimprestimosAtivo(){
        return imprestimosAtivo;
    }

    public boolean getbloqueado(){
        return bloqueado;
    }

    @Override
    public String toString() {
        return "Usuario{" +
        "id=" + id +
        ", nome ='" + nome + '\'' +
        ", tipo='" + tipo + '\'' +
        ", imprestimosAtivo=" + imprestimosAtivo +
        ", bloqueado=" + bloqueado +
        '}';
    }

}
