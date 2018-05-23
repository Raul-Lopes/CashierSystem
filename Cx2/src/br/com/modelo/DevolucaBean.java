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
public class DevolucaBean {

    private String cacodigo;
    private Integer dvcodigo;    
    private Date data;
    private Double valdevol;
    private Integer fucodigo;
    private Integer periodo;
    private String horario;
    private String horainic;
    private String baixaesto;
    private String flagtrans;
    private String flagtserv;
    private String setoruso;
    private String nuregesp;
    private Integer numerocoo;
    private Integer nucooctvl;
    private Integer clcodigo;
    private String tipo;
    private String cgc;
    private String cpf;
    private String nome;
    private String telefone;
    private String fantasia;
    private String endereco;
    private Integer tpenderecocom;
    private String complementocom;
    private Integer numerocom;
    private String bairro;
    private Integer cicodigo;
    private String nomecidade;
    private String uf;
    private String cep;
    private String modelonf;
    private String serienf;
    private String subserienf;
    private Integer numeronf;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.cacodigo);
        hash = 37 * hash + Objects.hashCode(this.dvcodigo);
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
        final DevolucaBean other = (DevolucaBean) obj;
        if (!Objects.equals(this.cacodigo, other.cacodigo)) {
            return false;
        }
        if (!Objects.equals(this.dvcodigo, other.dvcodigo)) {
            return false;
        }
        return true;
    }

    /**
     * @return the cacodigo
     */
    public String getCacodigo() {
        return cacodigo;
    }

    /**
     * @param cacodigo the cacodigo to set
     */
    public void setCacodigo(String cacodigo) {
        this.cacodigo = cacodigo;
    }

    /**
     * @return the dvcodigo
     */
    public Integer getDvcodigo() {
        return dvcodigo;
    }

    /**
     * @param dvcodigo the dvcodigo to set
     */
    public void setDvcodigo(Integer dvcodigo) {
        this.dvcodigo = dvcodigo;
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

    /**
     * @return the valdevol
     */
    public Double getValdevol() {
        return valdevol;
    }

    /**
     * @param valdevol the valdevol to set
     */
    public void setValdevol(Double valdevol) {
        this.valdevol = valdevol;
    }

    /**
     * @return the fucodigo
     */
    public Integer getFucodigo() {
        return fucodigo;
    }

    /**
     * @param fucodigo the fucodigo to set
     */
    public void setFucodigo(Integer fucodigo) {
        this.fucodigo = fucodigo;
    }

    /**
     * @return the periodo
     */
    public Integer getPeriodo() {
        return periodo;
    }

    /**
     * @param periodo the periodo to set
     */
    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    /**
     * @return the horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * @return the horainic
     */
    public String getHorainic() {
        return horainic;
    }

    /**
     * @param horainic the horainic to set
     */
    public void setHorainic(String horainic) {
        this.horainic = horainic;
    }

    /**
     * @return the baixaesto
     */
    public String getBaixaesto() {
        return baixaesto;
    }

    /**
     * @param baixaesto the baixaesto to set
     */
    public void setBaixaesto(String baixaesto) {
        this.baixaesto = baixaesto;
    }

    /**
     * @return the flagtrans
     */
    public String getFlagtrans() {
        return flagtrans;
    }

    /**
     * @param flagtrans the flagtrans to set
     */
    public void setFlagtrans(String flagtrans) {
        this.flagtrans = flagtrans;
    }

    /**
     * @return the flagtserv
     */
    public String getFlagtserv() {
        return flagtserv;
    }

    /**
     * @param flagtserv the flagtserv to set
     */
    public void setFlagtserv(String flagtserv) {
        this.flagtserv = flagtserv;
    }

    /**
     * @return the setoruso
     */
    public String getSetoruso() {
        return setoruso;
    }

    /**
     * @param setoruso the setoruso to set
     */
    public void setSetoruso(String setoruso) {
        this.setoruso = setoruso;
    }

    /**
     * @return the nuregesp
     */
    public String getNuregesp() {
        return nuregesp;
    }

    /**
     * @param nuregesp the nuregesp to set
     */
    public void setNuregesp(String nuregesp) {
        this.nuregesp = nuregesp;
    }

    /**
     * @return the numerocoo
     */
    public Integer getNumerocoo() {
        return numerocoo;
    }

    /**
     * @param numerocoo the numerocoo to set
     */
    public void setNumerocoo(Integer numerocoo) {
        this.numerocoo = numerocoo;
    }

    /**
     * @return the nucooctvl
     */
    public Integer getNucooctvl() {
        return nucooctvl;
    }

    /**
     * @param nucooctvl the nucooctvl to set
     */
    public void setNucooctvl(Integer nucooctvl) {
        this.nucooctvl = nucooctvl;
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
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
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
     * @return the fantasia
     */
    public String getFantasia() {
        return fantasia;
    }

    /**
     * @param fantasia the fantasia to set
     */
    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
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
     * @return the tpenderecocom
     */
    public Integer getTpenderecocom() {
        return tpenderecocom;
    }

    /**
     * @param tpenderecocom the tpenderecocom to set
     */
    public void setTpenderecocom(Integer tpenderecocom) {
        this.tpenderecocom = tpenderecocom;
    }

    /**
     * @return the complementocom
     */
    public String getComplementocom() {
        return complementocom;
    }

    /**
     * @param complementocom the complementocom to set
     */
    public void setComplementocom(String complementocom) {
        this.complementocom = complementocom;
    }

    /**
     * @return the numerocom
     */
    public Integer getNumerocom() {
        return numerocom;
    }

    /**
     * @param numerocom the numerocom to set
     */
    public void setNumerocom(Integer numerocom) {
        this.numerocom = numerocom;
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
     * @return the nomecidade
     */
    public String getNomecidade() {
        return nomecidade;
    }

    /**
     * @param nomecidade the nomecidade to set
     */
    public void setNomecidade(String nomecidade) {
        this.nomecidade = nomecidade;
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
     * @return the modelonf
     */
    public String getModelonf() {
        return modelonf;
    }

    /**
     * @param modelonf the modelonf to set
     */
    public void setModelonf(String modelonf) {
        this.modelonf = modelonf;
    }

    /**
     * @return the serienf
     */
    public String getSerienf() {
        return serienf;
    }

    /**
     * @param serienf the serienf to set
     */
    public void setSerienf(String serienf) {
        this.serienf = serienf;
    }

    /**
     * @return the subserienf
     */
    public String getSubserienf() {
        return subserienf;
    }

    /**
     * @param subserienf the subserienf to set
     */
    public void setSubserienf(String subserienf) {
        this.subserienf = subserienf;
    }

    /**
     * @return the numeronf
     */
    public Integer getNumeronf() {
        return numeronf;
    }

    /**
     * @param numeronf the numeronf to set
     */
    public void setNumeronf(Integer numeronf) {
        this.numeronf = numeronf;
    }

}
