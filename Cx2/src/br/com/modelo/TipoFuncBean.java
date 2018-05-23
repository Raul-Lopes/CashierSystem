/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo;

/**
 *
 * @author raul
 */
public class TipoFuncBean {

    private String tfCoidgo;
    private String nome;
    private Integer hcCodigo;
    private java.util.Date dataAlte;

    /**
     * @return the tfCoidgo
     */
    public String getTfCoidgo() {
        return tfCoidgo;
    }

    /**
     * @param tfCoidgo the tfCoidgo to set
     */
    public void setTfCoidgo(String tfCoidgo) {
        this.tfCoidgo = tfCoidgo;
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
     * @return the hcCodigo
     */
    public Integer getHcCodigo() {
        return hcCodigo;
    }

    /**
     * @param hcCodigo the hcCodigo to set
     */
    public void setHcCodigo(Integer hcCodigo) {
        this.hcCodigo = hcCodigo;
    }

    /**
     * @return the dataAlte
     */
    public java.util.Date getDataAlte() {
        return dataAlte;
    }

    /**
     * @param dataAlte the dataAlte to set
     */
    public void setDataAlte(java.util.Date dataAlte) {
        this.dataAlte = dataAlte;
    }

}
