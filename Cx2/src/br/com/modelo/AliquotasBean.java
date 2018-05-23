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
public class AliquotasBean {

    private Integer alcodigo;
    private String nome;
    private Double percaliq;
    private String codtrib;
    private String origem;
    private Date dataalte;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.alcodigo);
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
        final AliquotasBean other = (AliquotasBean) obj;
        if (!Objects.equals(this.alcodigo, other.alcodigo)) {
            return false;
        }
        return true;
    }

    /**
     * @return the alcodigo
     */
    public Integer getAlcodigo() {
        return alcodigo;
    }

    /**
     * @param alcodigo the alcodigo to set
     */
    public void setAlcodigo(Integer alcodigo) {
        this.alcodigo = alcodigo;
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
     * @return the percaliq
     */
    public Double getPercaliq() {
        return percaliq;
    }

    /**
     * @param percaliq the percaliq to set
     */
    public void setPercaliq(Double percaliq) {
        this.percaliq = percaliq;
    }

    /**
     * @return the codtrib
     */
    public String getCodtrib() {
        return codtrib;
    }

    /**
     * @param codtrib the codtrib to set
     */
    public void setCodtrib(String codtrib) {
        this.codtrib = codtrib;
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
