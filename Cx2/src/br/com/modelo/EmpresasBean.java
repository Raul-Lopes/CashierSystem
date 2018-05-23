/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo;

import java.util.Objects;

/**
 *
 * @author raul
 */
public class EmpresasBean {

    private Integer emcodigo;
    private String nomeempr;
    private String nometela;
    private String cgc;
    private String inscrica;
    private String endereco;
    private String bairro;
    private Integer cicodigo;
    private String uf;
    private String cep;
    private String telefone;
    private String funcSab;
    private String funcDom;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.getEmcodigo());
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
        final EmpresasBean other = (EmpresasBean) obj;
        if (!Objects.equals(this.emcodigo, other.emcodigo)) {
            return false;
        }
        return true;
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
     * @return the nomeempr
     */
    public String getNomeempr() {
        return nomeempr;
    }

    /**
     * @param nomeempr the nomeempr to set
     */
    public void setNomeempr(String nomeempr) {
        this.nomeempr = nomeempr;
    }

    /**
     * @return the nometela
     */
    public String getNometela() {
        return nometela;
    }

    /**
     * @param nometela the nometela to set
     */
    public void setNometela(String nometela) {
        this.nometela = nometela;
    }

    /**
     * @return the cgc
     */
    public String getCgc() {
        return cgc;
    }

    /**
     * @param cgc the cgc to set
     */
    public void setCgc(String cgc) {
        this.cgc = cgc;
    }

    /**
     * @return the inscrica
     */
    public String getInscrica() {
        return inscrica;
    }

    /**
     * @param inscrica the inscrica to set
     */
    public void setInscrica(String inscrica) {
        this.inscrica = inscrica;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
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
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the funcsab
     */
    public String getFuncSab() {
        return funcSab;
    }

    /**
     * @param funcSab the funcsab to set
     */
    public void setFuncSab(String funcSab) {
        this.funcSab = funcSab;
    }

    /**
     * @return the funcDom
     */
    public String getFuncDom() {
        return funcDom;
    }

    /**
     * @param funcDom the funcDom to set
     */
    public void setFuncDom(String funcDom) {
        this.funcDom = funcDom;
    }

}
