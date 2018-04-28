package br.com.victor.geradordesenha;

import java.io.Serializable;

public class Fila implements Serializable{
    private int id;
    private  String nome;
    private String sigla;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    @Override
    public String toString() {
        return "Servico: " +
                "\nTipo = " + nome +
                "\n";
    }
}
