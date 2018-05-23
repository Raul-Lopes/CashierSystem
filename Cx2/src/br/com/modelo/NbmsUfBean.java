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
public class NbmsUfBean {

    private String nbcodigo;
    private String uf;
    private String origem;
    private Double aliqcred;
    private Double aliqdeb;
    private Date dataalte;

    /**
     * @return the nbcodigo
     */
    public String getNbcodigo() {
        return nbcodigo;
    }

    /**
     * @param nbcodigo the nbcodigo to set
     */
    public void setNbcodigo(String nbcodigo) {
        this.nbcodigo = nbcodigo;
    }

    /**
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * @return the origem
     */
    public String getOrigem() {
        return origem;
    }

    /**
     * @param origem the origem to set
     */
    public void setOrigem(String origem) {
        this.origem = origem;
    }

    /**
     * @return the aliqcred
     */
    public Double getAliqcred() {
        return aliqcred;
    }

    /**
     * @param aliqcred the aliqcred to set
     */
    public void setAliqcred(Double aliqcred) {
        this.aliqcred = aliqcred;
    }

    /**
     * @return the aliqdeb
     */
    public Double getAliqdeb() {
        return aliqdeb;
    }

    /**
     * @param aliqdeb the aliqdeb to set
     */
    public void setAliqdeb(Double aliqdeb) {
        this.aliqdeb = aliqdeb;
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
