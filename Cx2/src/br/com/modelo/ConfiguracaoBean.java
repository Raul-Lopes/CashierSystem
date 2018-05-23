/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo;

/**
 *
 * @author Raul
 */
public class ConfiguracaoBean {

    private String papelParede;
    private String numeroCaixa;
    private String setorUso;
    private String emitirCupom;
    private String planoContas;
    private String modoImpremeVenda;
    private String centCusto;
    private String tipoMovimento;
    private String funcionarioItem;

    public String getModoImpremeVenda() {
        return modoImpremeVenda;
    }

    public void setModoImpremeVenda(String modoImpremeVenda) {
        this.modoImpremeVenda = modoImpremeVenda;
    }

    /**
     * @return the papelParede
     */
    public String getPapelParede() {
        return papelParede;
    }

    /**
     * @param papelParede the papelParede to set
     */
    public void setPapelParede(String papelParede) {
        this.papelParede = papelParede;
    }

    /**
     * @return the numeroCaixa
     */
    public String getNumeroCaixa() {
        return numeroCaixa;
    }

    /**
     * @param numeroCaixa the numeroCaixa to set
     */
    public void setNumeroCaixa(String numeroCaixa) {
        this.numeroCaixa = numeroCaixa;
    }

    /**
     * @return the setorUso
     */
    public String getSetorUso() {
        return setorUso;
    }

    /**
     * @param setorUso the setorUso to set
     */
    public void setSetorUso(String setorUso) {
        this.setorUso = setorUso;
    }

    /**
     * @return the emitirCupom
     */
    public String getEmitirCupom() {
        return emitirCupom;
    }

    /**
     * @param emitirCupom the emitirCupom to set
     */
    public void setEmitirCupom(String emitirCupom) {
        this.emitirCupom = emitirCupom;
    }

    /**
     * @return the planoContas
     */
    public String getPlanoContas() {
        return planoContas;
    }

    /**
     * @param planoContas the planoContas to set
     */
    public void setPlanoContas(String planoContas) {
        this.planoContas = planoContas;
    }

    /**
     * @return the centCusto
     */
    public String getCentCusto() {
        return centCusto;
    }

    /**
     * @param centCusto the centCusto to set
     */
    public void setCentCusto(String centCusto) {
        this.centCusto = centCusto;
    }

    public String getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(String tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public String getFuncionarioItem() {
        return funcionarioItem;
    }

    public void setFuncionarioItem(String funcionarioItem) {
        this.funcionarioItem = funcionarioItem;
    }
    
    
}
