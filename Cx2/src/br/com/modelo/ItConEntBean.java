/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo;

import java.util.Objects;

/**
 *
 * @author raul
 */
public class ItConEntBean {

    private Integer cgcodigo;
    private Integer niconent;
    private String mfcodigo;
    private Double qtdvda;
    private Double valivda;
    private Double qtddev;
    private Double validev;
    private Double prcunit;
    private Integer cscodigo;
    private Integer niconsai;
    private String flag;
    private String flagtrans;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.getCgcodigo());
        hash = 83 * hash + Objects.hashCode(this.getNiconent());
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
        final ItConEntBean other = (ItConEntBean) obj;
        if (!Objects.equals(this.cgcodigo, other.cgcodigo)) {
            return false;
        }
        if (!Objects.equals(this.niconent, other.niconent)) {
            return false;
        }
        return true;
    }

    /**
     * @return the cgcodigo
     */
    public Integer getCgcodigo() {
        return cgcodigo;
    }

    /**
     * @param cgcodigo the cgcodigo to set
     */
    public void setCgcodigo(Integer cgcodigo) {
        this.cgcodigo = cgcodigo;
    }

    /**
     * @return the niconent
     */
    public Integer getNiconent() {
        return niconent;
    }

    /**
     * @param niconent the niconent to set
     */
    public void setNiconent(Integer niconent) {
        this.niconent = niconent;
    }

    /**
     * @return the mfcodigo
     */
    public String getMfcodigo() {
        return mfcodigo;
    }

    /**
     * @param mfcodigo the mfcodigo to set
     */
    public void setMfcodigo(String mfcodigo) {
        this.mfcodigo = mfcodigo;
    }

    /**
     * @return the qtdvda
     */
    public Double getQtdvda() {
        return qtdvda;
    }

    /**
     * @param qtdvda the qtdvda to set
     */
    public void setQtdvda(Double qtdvda) {
        this.qtdvda = qtdvda;
    }

    /**
     * @return the valivda
     */
    public Double getValivda() {
        return valivda;
    }

    /**
     * @param valivda the valivda to set
     */
    public void setValivda(Double valivda) {
        this.valivda = valivda;
    }

    /**
     * @return the qtddev
     */
    public Double getQtddev() {
        return qtddev;
    }

    /**
     * @param qtddev the qtddev to set
     */
    public void setQtddev(Double qtddev) {
        this.qtddev = qtddev;
    }

    /**
     * @return the validev
     */
    public Double getValidev() {
        return validev;
    }

    /**
     * @param validev the validev to set
     */
    public void setValidev(Double validev) {
        this.validev = validev;
    }

    /**
     * @return the prcunit
     */
    public Double getPrcunit() {
        return prcunit;
    }

    /**
     * @param prcunit the prcunit to set
     */
    public void setPrcunit(Double prcunit) {
        this.prcunit = prcunit;
    }

    /**
     * @return the cscodigo
     */
    public Integer getCscodigo() {
        return cscodigo;
    }

    /**
     * @param cscodigo the cscodigo to set
     */
    public void setCscodigo(Integer cscodigo) {
        this.cscodigo = cscodigo;
    }

    /**
     * @return the niconsai
     */
    public Integer getNiconsai() {
        return niconsai;
    }

    /**
     * @param niconsai the niconsai to set
     */
    public void setNiconsai(Integer niconsai) {
        this.niconsai = niconsai;
    }

    /**
     * @return the flag
     */
    public String getFlag() {
        return flag;
    }

    /**
     * @param flag the flag to set
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**
     * @return the flagtrans
     */
    public String getFlagtrans() {
        return flagtrans;
    }

    /**
     * @param flagtrans the flagtrans to set
     */
    public void setFlagtrans(String flagtrans) {
        this.flagtrans = flagtrans;
    }

}
