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
public class ContasBean {

    private String cocodigo;
    private String nome;
    private String agencia;
    private String numconta;
    private Integer dvagencia;
    private Integer dvconta;
    private Double saldo;
    private Integer emcodigo;
    private String codcontab;
    private Date dataalte;
    private String numbanco;
    private String carteira;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.getCocodigo());
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
        final ContasBean other = (ContasBean) obj;
        return Objects.equals(this.cocodigo, other.cocodigo);
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
     * @return the agencia
     */
    public String getAgencia() {
        return agencia;
    }

    /**
     * @param agencia the agencia to set
     */
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    /**
     * @return the numconta
     */
    public String getNumconta() {
        return numconta;
    }

    /**
     * @param numconta the numconta to set
     */
    public void setNumconta(String numconta) {
        this.numconta = numconta;
    }

    /**
     * @return the dvagencia
     */
    public Integer getDvagencia() {
        return dvagencia;
    }

    /**
     * @param dvagencia the dvagencia to set
     */
    public void setDvagencia(Integer dvagencia) {
        this.dvagencia = dvagencia;
    }

    /**
     * @return the dvconta
     */
    public Integer getDvconta() {
        return dvconta;
    }

    /**
     * @param dvconta the dvconta to set
     */
    public void setDvconta(Integer dvconta) {
        this.dvconta = dvconta;
    }

    /**
     * @return the saldo
     */
    public Double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
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
     * @return the codcontab
     */
    public String getCodcontab() {
        return codcontab;
    }

    /**
     * @param codcontab the codcontab to set
     */
    public void setCodcontab(String codcontab) {
        this.codcontab = codcontab;
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
     * @return the numbanco
     */
    public String getNumbanco() {
        return numbanco;
    }

    /**
     * @param numbanco the numbanco to set
     */
    public void setNumbanco(String numbanco) {
        this.numbanco = numbanco;
    }

    /**
     * @return the carteira
     */
    public String getCarteira() {
        return carteira;
    }

    /**
     * @param carteira the carteira to set
     */
    public void setCarteira(String carteira) {
        this.carteira = carteira;
    }

}
