package com.example.sevletmobisiesboco.Servlet.Tabela;

public class EstabelecimentoFvObj {

    private int usuarioId;
    private int estabelecimentoId;

    //metodo construtor
    public EstabelecimentoFvObj(int usuarioId, int estabelecimentoId) {
        this.usuarioId = usuarioId;
        this.estabelecimentoId = estabelecimentoId;
    }

    //get e set

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getEstabelecimentoId() {
        return estabelecimentoId;
    }

    public void setEstabelecimentoId(int estabelecimentoId) {
        this.estabelecimentoId = estabelecimentoId;
    }
}
