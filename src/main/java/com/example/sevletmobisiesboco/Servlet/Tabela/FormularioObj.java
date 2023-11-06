package com.example.sevletmobisiesboco.Servlet.Tabela;

public class FormularioObj {

    private int iRampa;
    private int iCorrimao;
    private int iBanheiro;
    private int iVagaPreferencial;
    private int Fk_Estabelecimento_iId;
    private int  Fk_usuario_iId;

    //metodo construtor

    public FormularioObj(int iRampa, int iCorrimao, int iBanheiro, int iVagaPreferencial, int Fk_Estabelecimento_iId, int  Fk_usuario_iId) {
        this.iRampa = iRampa;
        this.iCorrimao = iCorrimao;
        this.iBanheiro = iBanheiro;
        this.iVagaPreferencial = iVagaPreferencial;
        this.Fk_Estabelecimento_iId = Fk_Estabelecimento_iId;
        this.Fk_usuario_iId = Fk_usuario_iId;
    }

    //get e set


    public int getFk_Estabelecimento_iId() {
        return Fk_Estabelecimento_iId;
    }

    public void setFk_Estabelecimento_iId(int fk_Estabelecimento_iId) {
        Fk_Estabelecimento_iId = fk_Estabelecimento_iId;
    }

    public int getFk_usuario_iId() {
        return Fk_usuario_iId;
    }

    public void setFk_usuario_iId(int fk_usuario_iId) {
        Fk_usuario_iId = fk_usuario_iId;
    }

    public int getiRampa() {
        return iRampa;
    }

    public void setiRampa(int iRampa) {
        this.iRampa = iRampa;
    }

    public int getiCorrimao() {
        return iCorrimao;
    }

    public void setiCorrimao(int iCorrimao) {
        this.iCorrimao = iCorrimao;
    }

    public int getiBanheiro() {
        return iBanheiro;
    }

    public void setiBanheiro(int iBanheiro) {
        this.iBanheiro = iBanheiro;
    }

    public int getiVagaPreferencial() {
        return iVagaPreferencial;
    }

    public void setiVagaPreferencial(int iVagaPreferencial) {
        this.iVagaPreferencial = iVagaPreferencial;
    }
}
