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
public class LanclPdvBean {

    private Integer lccodigo;
    private Integer clcodigo;
    private Double valor;
    private Date datavenc;
    private String tipo;

    /**
     * @return the lccodigo
     */
    public Integer getLccodigo() {
        return lccodigo;
    }

    /**
     * @param lccodigo the lccodigo to set
     */
    public void setLccodigo(Integer lccodigo) {
        this.lccodigo = lccodigo;
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
     * @return the datavenc
     */
    public Date getDatavenc() {
        return datavenc;
    }

    /**
     * @param datavenc the datavenc to set
     */
    public void setDatavenc(Date datavenc) {
        this.datavenc = datavenc;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
