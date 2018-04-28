package br.com.victor.geradordesenha;

import java.io.Serializable;

public class Senha implements Serializable {

    private String codigo;
    private String dataAbertura;
    private String dataFechamento;
    private String servico;
    private String fila;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(String dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    @Override
    public String toString() {
        return "Senha{" +
                "\ncodigo='" + codigo + '\'' +
                "\ndataAbertura='" + dataAbertura + '\'' +
                "\ndataFechamento='" + dataFechamento + '\'' +
                "\nservico='" + servico + '\'' +
                "\nfila='" + fila + '\'' +
                "\n}";
    }
}
