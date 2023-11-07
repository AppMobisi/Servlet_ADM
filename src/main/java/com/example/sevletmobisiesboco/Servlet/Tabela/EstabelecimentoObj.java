package com.example.sevletmobisiesboco.Servlet.Tabela;

public class EstabelecimentoObj {
    private String nome;
    private double nota;
    private String cep;
    private String rua;
    private String cidade;
    private String  estado;
    private String foto;
    private int  fkTpEstabelecimento;

    //metodo construtor


    public EstabelecimentoObj(String nome, double nota, String cep, String rua, String cidade, String estado, String foto, int fkTpEstabelecimento) {
        this.nome = nome;
        this.nota = nota;
        this.cep = cep;
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.foto = foto;
        this.fkTpEstabelecimento = fkTpEstabelecimento;
    }

    //get e set
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFoto() {
        return foto;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getFkTpEstabelecimento() {
        return fkTpEstabelecimento;
    }

    public void setFkTpEstabelecimento(int fkTpEstabelecimento) {
        this.fkTpEstabelecimento = fkTpEstabelecimento;
    }





}
