/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo;

import java.sql.Blob;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author raul
 */
public class FormPagtBean {

    private String fpcodigo;
    private String nome;
    private Integer diasentra;
    private Double percentra;
    private Double percdesco;
    private Integer codespec;
    private String clieobrig;
    private Integer diasparc;
    private Integer qtdparc;
    private Date dataalte;
    private String tratalim;
    private String promissr;
    private String pedsenha;
    private Double maxdesco;
    private Integer maxparce;
    private Integer maxdiasp;
    private Double maxdifep;
    private String cocodigo;
    private String cecodigo;
    private String plcodigo;
    private Double descfin;
    private String gerpardfixo;
    private String tipooper;
    private String transpos;
    private String pedenaupos;
    private String tagtef;
    private String tpcartao;
    private String codadmin;
    private String indpag;
    private String impboleto;
    private Integer tpopveiculo;
    private List<ParcfPgtBean > parcfPgtBeanVO ;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.getFpcodigo());
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
        final FormPagtBean other = (FormPagtBean) obj;
        if (!Objects.equals(this.fpcodigo, other.fpcodigo)) {
            return false;
        }
        return true;
    }

    /**
     * @return the fpcodigo
     */
    public String getFpcodigo() {
        return fpcodigo;
    }

    /**
     * @param fpcodigo the fpcodigo to set
     */
    public void setFpcodigo(String fpcodigo) {
        this.fpcodigo = fpcodigo;
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
     * @return the diasentra
     */
    public Integer getDiasentra() {
        return diasentra;
    }

    /**
     * @param diasentra the diasentra to set
     */
    public void setDiasentra(Integer diasentra) {
        this.diasentra = diasentra;
    }

    /**
     * @return the percentra
     */
    public Double getPercentra() {
        return percentra;
    }

    /**
     * @param percentra the percentra to set
     */
    public void setPercentra(Double percentra) {
        this.percentra = percentra;
    }

    /**
     * @return the percdesco
     */
    public Double getPercdesco() {
        return percdesco;
    }

    /**
     * @param percdesco the percdesco to set
     */
    public void setPercdesco(Double percdesco) {
        this.percdesco = percdesco;
    }

    /**
     * @return the codespec
     */
    public Integer getCodespec() {
        return codespec;
    }

    /**
     * @param codespec the codespec to set
     */
    public void setCodespec(Integer codespec) {
        this.codespec = codespec;
    }

    /**
     * @return the clieobrig
     */
    public String getClieobrig() {
        return clieobrig;
    }

    /**
     * @param clieobrig the clieobrig to set
     */
    public void setClieobrig(String clieobrig) {
        this.clieobrig = clieobrig;
    }

    /**
     * @return the diasparc
     */
    public Integer getDiasparc() {
        return diasparc;
    }

    /**
     * @param diasparc the diasparc to set
     */
    public void setDiasparc(Integer diasparc) {
        this.diasparc = diasparc;
    }

    /**
     * @return the qtdparc
     */
    public Integer getQtdparc() {
        return qtdparc;
    }

    /**
     * @param qtdparc the qtdparc to set
     */
    public void setQtdparc(Integer qtdparc) {
        this.qtdparc = qtdparc;
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
     * @return the tratalim
     */
    public String getTratalim() {
        return tratalim;
    }

    /**
     * @param tratalim the tratalim to set
     */
    public void setTratalim(String tratalim) {
        this.tratalim = tratalim;
    }

    /**
     * @return the promissr
     */
    public String getPromissr() {
        return promissr;
    }

    /**
     * @param promissr the promissr to set
     */
    public void setPromissr(String promissr) {
        this.promissr = promissr;
    }

    /**
     * @return the pedsenha
     */
    public String getPedsenha() {
        return pedsenha;
    }

    /**
     * @param pedsenha the pedsenha to set
     */
    public void setPedsenha(String pedsenha) {
        this.pedsenha = pedsenha;
    }

    /**
     * @return the maxdesco
     */
    public Double getMaxdesco() {
        return maxdesco;
    }

    /**
     * @param maxdesco the maxdesco to set
     */
    public void setMaxdesco(Double maxdesco) {
        this.maxdesco = maxdesco;
    }

    /**
     * @return the maxparce
     */
    public Integer getMaxparce() {
        return maxparce;
    }

    /**
     * @param maxparce the maxparce to set
     */
    public void setMaxparce(Integer maxparce) {
        this.maxparce = maxparce;
    }

    /**
     * @return the maxdiasp
     */
    public Integer getMaxdiasp() {
        return maxdiasp;
    }

    /**
     * @param maxdiasp the maxdiasp to set
     */
    public void setMaxdiasp(Integer maxdiasp) {
        this.maxdiasp = maxdiasp;
    }

    /**
     * @return the maxdifep
     */
    public Double getMaxdifep() {
        return maxdifep;
    }

    /**
     * @param maxdifep the maxdifep to set
     */
    public void setMaxdifep(Double maxdifep) {
        this.maxdifep = maxdifep;
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
     * @return the cecodigo
     */
    public String getCecodigo() {
        return cecodigo;
    }

    /**
     * @param cecodigo the cecodigo to set
     */
    public void setCecodigo(String cecodigo) {
        this.cecodigo = cecodigo;
    }

    /**
     * @return the plcodigo
     */
    public String getPlcodigo() {
        return plcodigo;
    }

    /**
     * @param plcodigo the plcodigo to set
     */
    public void setPlcodigo(String plcodigo) {
        this.plcodigo = plcodigo;
    }

    /**
     * @return the descfin
     */
    public Double getDescfin() {
        return descfin;
    }

    /**
     * @param descfin the descfin to set
     */
    public void setDescfin(Double descfin) {
        this.descfin = descfin;
    }

    /**
     * @return the gerpardfixo
     */
    public String getGerpardfixo() {
        return gerpardfixo;
    }

    /**
     * @param gerpardfixo the gerpardfixo to set
     */
    public void setGerpardfixo(String gerpardfixo) {
        this.gerpardfixo = gerpardfixo;
    }

    /**
     * @return the tipooper
     */
    public String getTipooper() {
        return tipooper;
    }

    /**
     * @param tipooper the tipooper to set
     */
    public void setTipooper(String tipooper) {
        this.tipooper = tipooper;
    }

    /**
     * @return the transpos
     */
    public String getTranspos() {
        return transpos;
    }

    /**
     * @param transpos the transpos to set
     */
    public void setTranspos(String transpos) {
        this.transpos = transpos;
    }

    /**
     * @return the pedenaupos
     */
    public String getPedenaupos() {
        return pedenaupos;
    }

    /**
     * @param pedenaupos the pedenaupos to set
     */
    public void setPedenaupos(String pedenaupos) {
        this.pedenaupos = pedenaupos;
    }

    /**
     * @return the tagtef
     */
    public String getTagtef() {
        return tagtef;
    }

    /**
     * @param tagtef the tagtef to set
     */
    public void setTagtef(String tagtef) {
        this.tagtef = tagtef;
    }

    /**
     * @return the tpcartao
     */
    public String getTpcartao() {
        return tpcartao;
    }

    /**
     * @param tpcartao the tpcartao to set
     */
    public void setTpcartao(String tpcartao) {
        this.tpcartao = tpcartao;
    }

    /**
     * @return the codadmin
     */
    public String getCodadmin() {
        return codadmin;
    }

    /**
     * @param codadmin the codadmin to set
     */
    public void setCodadmin(String codadmin) {
        this.codadmin = codadmin;
    }

    /**
     * @return the indpag
     */
    public String getIndpag() {
        return indpag;
    }

    /**
     * @param indpag the indpag to set
     */
    public void setIndpag(String indpag) {
        this.indpag = indpag;
    }

    /**
     * @return the impboleto
     */
    public String getImpboleto() {
        return impboleto;
    }

    /**
     * @param impboleto the impboleto to set
     */
    public void setImpboleto(String impboleto) {
        this.impboleto = impboleto;
    }

    /**
     * @return the tpopveiculo
     */
    public Integer getTpopveiculo() {
        return tpopveiculo;
    }

    /**
     * @param tpopveiculo the tpopveiculo to set
     */
    public void setTpopveiculo(Integer tpopveiculo) {
        this.tpopveiculo = tpopveiculo;
    }

    /**
     * @return the parcfPgtBeanVO
     */
    public List<ParcfPgtBean > getParcfPgtBeanVO() {
        return parcfPgtBeanVO;
    }

    /**
     * @param parcfPgtBeanVO the parcfPgtBeanVO to set
     */
    public void setParcfPgtBeanVO(List<ParcfPgtBean > parcfPgtBeanVO) {
        this.parcfPgtBeanVO = parcfPgtBeanVO;
    }

}
