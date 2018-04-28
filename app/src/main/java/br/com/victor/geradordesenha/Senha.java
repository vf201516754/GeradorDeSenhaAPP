package br.com.victor.geradordesenha;

import java.io.Serializable;
import java.util.Date;

public class Senha implements Serializable {

    private int id;
    private int numero;
    private String codigo;
    private Date dataAbertura;
    private Date dataFechamento;
    private int isActive;
    private Fila fila;
    private Servico servico;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public Fila getFila() {
        return fila;
    }

    public void setFila(Fila fila) {
        this.fila = fila;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    @Override
    public String toString() {
        return "Senha: " +
                "\nCodigo= " + codigo +
                "\nDataAbertura = " + dataAbertura +
                "\nDataFechamento = " + dataFechamento +
                "\n";
    }
}
