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
public class ItConSaiBean {

    private Integer cscodigo;
    private Integer niconsai;
    private String mfcodigo;
    private Double qtditem;
    private Double valitem;
    private Double prcunit;
    private Double prcorig;
    private String flag;
    private Integer cgcodigo;
    private Double qtdmov;
    private String flagtrans;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.cscodigo);
        hash = 37 * hash + Objects.hashCode(this.niconsai);
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
        final ItConSaiBean other = (ItConSaiBean) obj;
        if (!Objects.equals(this.cscodigo, other.cscodigo)) {
            return false;
        }
        if (!Objects.equals(this.niconsai, other.niconsai)) {
            return false;
        }
        return true;
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
     * @return the qtditem
     */
    public Double getQtditem() {
        return qtditem;
    }

    /**
     * @param qtditem the qtditem to set
     */
    public void setQtditem(Double qtditem) {
        this.qtditem = qtditem;
    }

    /**
     * @return the valitem
     */
    public Double getValitem() {
        return valitem;
    }

    /**
     * @param valitem the valitem to set
     */
    public void setValitem(Double valitem) {
        this.valitem = valitem;
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
     * @return the prcorig
     */
    public Double getPrcorig() {
        return prcorig;
    }

    /**
     * @param prcorig the prcorig to set
     */
    public void setPrcorig(Double prcorig) {
        this.prcorig = prcorig;
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
     * @return the qtdmov
     */
    public Double getQtdmov() {
        return qtdmov;
    }

    /**
     * @param qtdmov the qtdmov to set
     */
    public void setQtdmov(Double qtdmov) {
        this.qtdmov = qtdmov;
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
