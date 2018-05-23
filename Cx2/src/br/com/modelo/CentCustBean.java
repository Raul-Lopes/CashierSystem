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
 * @author Raul
 */
public class CentCustBean {

    private String cecodigo;
    private String nome;
    private String pai;
    private Integer emcodigo;
    private Date dataalte;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.getCecodigo());
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
        final CentCustBean other = (CentCustBean) obj;
        if (!Objects.equals(this.cecodigo, other.cecodigo)) {
            return false;
        }
        return true;
    }

    /**
     * @return the cecodigo
     */
    public String getCecodigo() {
        return cecodigo;
    }

    /**
     * @param cecodigo the cecodigo to set
     */
    public void setCecodigo(String cecodigo) {
        this.cecodigo = cecodigo;
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
     * @return the pai
     */
    public String getPai() {
        return pai;
    }

    /**
     * @param pai the pai to set
     */
    public void setPai(String pai) {
        this.pai = pai;
    }

    /**
     * @return the emcodigo
     */
    public Integer getEmcodigo() {
        return emcodigo;
    }

    /**
     * @param emcodigo the emcodigo to set
     */
    public void setEmcodigo(Integer emcodigo) {
        this.emcodigo = emcodigo;
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

}
