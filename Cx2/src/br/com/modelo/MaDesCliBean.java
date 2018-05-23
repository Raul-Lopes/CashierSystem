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
public class MaDesCliBean {

    private String mfcodigo;
    private Integer clcodigo;
    private Double percdesc;
    private Date dataalte;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.mfcodigo);
        hash = 71 * hash + Objects.hashCode(this.clcodigo);
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
        final MaDesCliBean other = (MaDesCliBean) obj;
        if (!Objects.equals(this.mfcodigo, other.mfcodigo)) {
            return false;
        }
        if (!Objects.equals(this.clcodigo, other.clcodigo)) {
            return false;
        }
        return true;
    }

    /**
     * @return the mfcodigo
     */
    public String getMfcodigo() {
        return mfcodigo;
    }

    /**
     * @param mfcodigo the mfcodigo to set
     */
    public void setMfcodigo(String mfcodigo) {
        this.mfcodigo = mfcodigo;
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
     * @return the percdesc
     */
    public Double getPercdesc() {
        return percdesc;
    }

    /**
     * @param percdesc the percdesc to set
     */
    public void setPercdesc(Double percdesc) {
        this.percdesc = percdesc;
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
