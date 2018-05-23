/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author raul
 */
public class ConsSaidBean {

    private Integer cscodigo;
    private Date data;
    private Integer clcodigo;
    private Double valor;
    private Date datprdev;
    private String status;
    private Integer fucodigo;
    private Integer cgcodigo;
    private String flag;
    private String flagtrans;
    private Date dtfecha;
    private String numserie;
    private String impresso;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.getCscodigo());
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
        final ConsSaidBean other = (ConsSaidBean) obj;
        if (!Objects.equals(this.cscodigo, other.cscodigo)) {
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
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the clcodigo
     */
    public Integer getClcodigo() {
        return clcodigo;
    }

    /**
     * @param clcodigo the clcodigo to set
     */
    public void setClcodigo(Integer clcodigo) {
        this.clcodigo = clcodigo;
    }

    /**
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * @return the datprdev
     */
    public Date getDatprdev() {
        return datprdev;
    }

    /**
     * @param datprdev the datprdev to set
     */
    public void setDatprdev(Date datprdev) {
        this.datprdev = datprdev;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the fucodigo
     */
    public Integer getFucodigo() {
        return fucodigo;
    }

    /**
     * @param fucodigo the fucodigo to set
     */
    public void setFucodigo(Integer fucodigo) {
        this.fucodigo = fucodigo;
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

    /**
     * @return the dtfecha
     */
    public Date getDtfecha() {
        return dtfecha;
    }

    /**
     * @param dtfecha the dtfecha to set
     */
    public void setDtfecha(Date dtfecha) {
        this.dtfecha = dtfecha;
    }

    /**
     * @return the numserie
     */
    public String getNumserie() {
        return numserie;
    }

    /**
     * @param numserie the numserie to set
     */
    public void setNumserie(String numserie) {
        this.numserie = numserie;
    }

    /**
     * @return the impresso
     */
    public String getImpresso() {
        return impresso;
    }

    /**
     * @param impresso the impresso to set
     */
    public void setImpresso(String impresso) {
        this.impresso = impresso;
    }

}
