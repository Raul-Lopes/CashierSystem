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
public class UnidadesBean {

    private String uncodigo;
    private String nome;
    private Date dataalte;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.getUncodigo());
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
        final UnidadesBean other = (UnidadesBean) obj;
        if (!Objects.equals(this.uncodigo, other.uncodigo)) {
            return false;
        }
        return true;
    }

    /**
     * @return the uncodigo
     */
    public String getUncodigo() {
        return uncodigo;
    }

    /**
     * @param uncodigo the uncodigo to set
     */
    public void setUncodigo(String uncodigo) {
        this.uncodigo = uncodigo;
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
