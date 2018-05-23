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
public class ParcfPgtBean {

    private String fpcodigo;
    private Integer sequencia;
    private Integer diaslanca;
    private Double percparce;
    private Date dataalte;
    private String cocodigo;
    private String cecodigo;
    private String plcodigo;
    private Double juros;

    /**
     * @return the fpcodigo
     */
    public String getFpcodigo() {
        return fpcodigo;
    }

    /**
     * @param fpcodigo the fpcodigo to set
     */
    public void setFpcodigo(String fpcodigo) {
        this.fpcodigo = fpcodigo;
    }

    /**
     * @return the sequencia
     */
    public Integer getSequencia() {
        return sequencia;
    }

    /**
     * @param sequencia the sequencia to set
     */
    public void setSequencia(Integer sequencia) {
        this.sequencia = sequencia;
    }

    /**
     * @return the diaslanca
     */
    public Integer getDiaslanca() {
        return diaslanca;
    }

    /**
     * @param diaslanca the diaslanca to set
     */
    public void setDiaslanca(Integer diaslanca) {
        this.diaslanca = diaslanca;
    }

    /**
     * @return the percparce
     */
    public Double getPercparce() {
        return percparce;
    }

    /**
     * @param percparce the percparce to set
     */
    public void setPercparce(Double percparce) {
        this.percparce = percparce;
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
     * @return the cocodigo
     */
    public String getCocodigo() {
        return cocodigo;
    }

    /**
     * @param cocodigo the cocodigo to set
     */
    public void setCocodigo(String cocodigo) {
        this.cocodigo = cocodigo;
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
     * @return the plcodigo
     */
    public String getPlcodigo() {
        return plcodigo;
    }

    /**
     * @param plcodigo the plcodigo to set
     */
    public void setPlcodigo(String plcodigo) {
        this.plcodigo = plcodigo;
    }

    /**
     * @return the juros
     */
    public Double getJuros() {
        return juros;
    }

    /**
     * @param juros the juros to set
     */
    public void setJuros(Double juros) {
        this.juros = juros;
    }

}
