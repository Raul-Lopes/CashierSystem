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
public class CidadesBean {

    private Integer cicodigo;
    private String nome;
    private String uf;
    private String cep;
    private String codibge;
    private Date dataalte;
    private String codpais;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.getCicodigo());
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
        final CidadesBean other = (CidadesBean) obj;
        if (!Objects.equals(this.cicodigo, other.cicodigo)) {
            return false;
        }
        return true;
    }

    /**
     * @return the cicodigo
     */
    public Integer getCicodigo() {
        return cicodigo;
    }

    /**
     * @param cicodigo the cicodigo to set
     */
    public void setCicodigo(Integer cicodigo) {
        this.cicodigo = cicodigo;
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
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the codibge
     */
    public String getCodibge() {
        return codibge;
    }

    /**
     * @param codibge the codibge to set
     */
    public void setCodibge(String codibge) {
        this.codibge = codibge;
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
     * @return the codpais
     */
    public String getCodpais() {
        return codpais;
    }

    /**
     * @param codpais the codpais to set
     */
    public void setCodpais(String codpais) {
        this.codpais = codpais;
    }

}
