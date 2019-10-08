package com.example.consultacepbyluc;

public class Endereço {

    private String bairro;
    private String cidade;
    private String logradouro;

    public Endereço(String bairro, String cidade, String logradouro) {
        this.bairro = bairro;
        this.cidade = cidade;
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

}
