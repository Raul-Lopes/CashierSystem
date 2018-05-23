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
public class DiCliNegBean {

    private String cnCodigo;
    private String nome;
    private Date data;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.getCnCodigo());
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
        final DiCliNegBean other = (DiCliNegBean) obj;
        if (!Objects.equals(this.cnCodigo, other.cnCodigo)) {
            return false;
        }
        return true;
    }

    /**
     * @return the cnCodigo
     */
    public String getCnCodigo() {
        return cnCodigo;
    }

    /**
     * @param cnCodigo the cnCodigo to set
     */
    public void setCnCodigo(String cnCodigo) {
        this.cnCodigo = cnCodigo;
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

}
