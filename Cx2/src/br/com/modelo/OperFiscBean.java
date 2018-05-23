/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo;

import java.util.Date;

/**
 *
 * @author raul
 */
public class OperFiscBean {

    private int ofcodigo;
    private String tiponf;
    private String nome;
    private String regicms;
    private String baixaest;
    private String venda;
    private Date dataalte;
    private String calcpiscofins;
    private String atzcustos;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.getOfcodigo();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OperFiscBean other = (OperFiscBean) obj;
        if (this.getOfcodigo() != other.getOfcodigo()) {
            return false;
        }
        return true;
    }

    /**
     * @return the ofcodigo
     */
    public int getOfcodigo() {
        return ofcodigo;
    }

    /**
     * @param ofcodigo the ofcodigo to set
     */
    public void setOfcodigo(int ofcodigo) {
        this.ofcodigo = ofcodigo;
    }

    /**
     * @return the tiponf
     */
    public String getTiponf() {
        return tiponf;
    }

    /**
     * @param tiponf the tiponf to set
     */
    public void setTiponf(String tiponf) {
        this.tiponf = tiponf;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the regicms
     */
    public String getRegicms() {
        return regicms;
    }

    /**
     * @param regicms the regicms to set
     */
    public void setRegicms(String regicms) {
        this.regicms = regicms;
    }

    /**
     * @return the baixaest
     */
    public String getBaixaest() {
        return baixaest;
    }

    /**
     * @param baixaest the baixaest to set
     */
    public void setBaixaest(String baixaest) {
        this.baixaest = baixaest;
    }

    /**
     * @return the venda
     */
    public String getVenda() {
        return venda;
    }

    /**
     * @param venda the venda to set
     */
    public void setVenda(String venda) {
        this.venda = venda;
    }

    /**
     * @return the dataalte
     */
    public Date getDataalte() {
        return dataalte;
    }

    /**
     * @param dataalte the dataalte to set
     */
    public void setDataalte(Date dataalte) {
        this.dataalte = dataalte;
    }

    /**
     * @return the calcpiscofins
     */
    public String getCalcpiscofins() {
        return calcpiscofins;
    }

    /**
     * @param calcpiscofins the calcpiscofins to set
     */
    public void setCalcpiscofins(String calcpiscofins) {
        this.calcpiscofins = calcpiscofins;
    }

    /**
     * @return the atzcustos
     */
    public String getAtzcustos() {
        return atzcustos;
    }

    /**
     * @param atzcustos the atzcustos to set
     */
    public void setAtzcustos(String atzcustos) {
        this.atzcustos = atzcustos;
    }

}
