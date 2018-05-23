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
public class ItemDevoBean {

    private String cacodigo;
    private Integer dvcodigo;
    private Integer numitem;
    private String mfcodigo;
    private String plcodigo;
    private Double qtditem;
    private Double valitem;
    private Integer fucodigo;
    private Integer fucodlan;
    private Double aliqicms;
    private String codtrib;
    private String numdocum;
    private Double prcunit;
    private String mmfcodigo;
    private String nome;
    private String uncodigo;
    private Double precoven;
    private Double maliqicms;
    private String codorige;
    private String mcodtrib;
    private String pesavel;
    private Double aliqipi;
    private String codextra;
    private String referenci;
    private String grade;
    private String cor;
    private String tamanho;
    private String codintern;
    private String tipotribu;
    private Double precoven1;
    private Double qtdestoq;
    private String pathfoto;
    private String agcodigo;
    private String excluido;
    private String flagtrans;
    private String flagtserv;
    private Double deprotot;
    private Double acprotot;
    private String composto;
    private String cacodori;
    private String setorori;
    private String codrecei;
    private String horarece;
    private Double qtdrecei;
    private String tipofab;
    private String iat;
    private String cacodcup;
    private Integer vdcodigo;
    private Integer itemvend;
    private Date datahoracup;
    private Date datacup;
    private Integer numcupom;
    private Integer numcoocup;
    private Date dtmovcup;
    private String ecfserievnd;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.getCacodigo());
        hash = 97 * hash + Objects.hashCode(this.getDvcodigo());
        hash = 97 * hash + Objects.hashCode(this.getNumitem());
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
        final ItemDevoBean other = (ItemDevoBean) obj;
        if (!Objects.equals(this.cacodigo, other.cacodigo)) {
            return false;
        }
        if (!Objects.equals(this.dvcodigo, other.dvcodigo)) {
            return false;
        }
        if (!Objects.equals(this.numitem, other.numitem)) {
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
     * @return the numitem
     */
    public Integer getNumitem() {
        return numitem;
    }

    /**
     * @param numitem the numitem to set
     */
    public void setNumitem(Integer numitem) {
        this.numitem = numitem;
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
     * @return the qtditem
     */
    public Double getQtditem() {
        return qtditem;
    }

    /**
     * @param qtditem the qtditem to set
     */
    public void setQtditem(Double qtditem) {
        this.qtditem = qtditem;
    }

    /**
     * @return the valitem
     */
    public Double getValitem() {
        return valitem;
    }

    /**
     * @param valitem the valitem to set
     */
    public void setValitem(Double valitem) {
        this.valitem = valitem;
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
     * @return the fucodlan
     */
    public Integer getFucodlan() {
        return fucodlan;
    }

    /**
     * @param fucodlan the fucodlan to set
     */
    public void setFucodlan(Integer fucodlan) {
        this.fucodlan = fucodlan;
    }

    /**
     * @return the aliqicms
     */
    public Double getAliqicms() {
        return aliqicms;
    }

    /**
     * @param aliqicms the aliqicms to set
     */
    public void setAliqicms(Double aliqicms) {
        this.aliqicms = aliqicms;
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
     * @return the numdocum
     */
    public String getNumdocum() {
        return numdocum;
    }

    /**
     * @param numdocum the numdocum to set
     */
    public void setNumdocum(String numdocum) {
        this.numdocum = numdocum;
    }

    /**
     * @return the prcunit
     */
    public Double getPrcunit() {
        return prcunit;
    }

    /**
     * @param prcunit the prcunit to set
     */
    public void setPrcunit(Double prcunit) {
        this.prcunit = prcunit;
    }

    /**
     * @return the mmfcodigo
     */
    public String getMmfcodigo() {
        return mmfcodigo;
    }

    /**
     * @param mmfcodigo the mmfcodigo to set
     */
    public void setMmfcodigo(String mmfcodigo) {
        this.mmfcodigo = mmfcodigo;
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
     * @return the precoven
     */
    public Double getPrecoven() {
        return precoven;
    }

    /**
     * @param precoven the precoven to set
     */
    public void setPrecoven(Double precoven) {
        this.precoven = precoven;
    }

    /**
     * @return the maliqicms
     */
    public Double getMaliqicms() {
        return maliqicms;
    }

    /**
     * @param maliqicms the maliqicms to set
     */
    public void setMaliqicms(Double maliqicms) {
        this.maliqicms = maliqicms;
    }

    /**
     * @return the codorige
     */
    public String getCodorige() {
        return codorige;
    }

    /**
     * @param codorige the codorige to set
     */
    public void setCodorige(String codorige) {
        this.codorige = codorige;
    }

    /**
     * @return the mcodtrib
     */
    public String getMcodtrib() {
        return mcodtrib;
    }

    /**
     * @param mcodtrib the mcodtrib to set
     */
    public void setMcodtrib(String mcodtrib) {
        this.mcodtrib = mcodtrib;
    }

    /**
     * @return the pesavel
     */
    public String getPesavel() {
        return pesavel;
    }

    /**
     * @param pesavel the pesavel to set
     */
    public void setPesavel(String pesavel) {
        this.pesavel = pesavel;
    }

    /**
     * @return the aliqipi
     */
    public Double getAliqipi() {
        return aliqipi;
    }

    /**
     * @param aliqipi the aliqipi to set
     */
    public void setAliqipi(Double aliqipi) {
        this.aliqipi = aliqipi;
    }

    /**
     * @return the codextra
     */
    public String getCodextra() {
        return codextra;
    }

    /**
     * @param codextra the codextra to set
     */
    public void setCodextra(String codextra) {
        this.codextra = codextra;
    }

    /**
     * @return the referenci
     */
    public String getReferenci() {
        return referenci;
    }

    /**
     * @param referenci the referenci to set
     */
    public void setReferenci(String referenci) {
        this.referenci = referenci;
    }

    /**
     * @return the grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * @return the cor
     */
    public String getCor() {
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * @return the tamanho
     */
    public String getTamanho() {
        return tamanho;
    }

    /**
     * @param tamanho the tamanho to set
     */
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * @return the codintern
     */
    public String getCodintern() {
        return codintern;
    }

    /**
     * @param codintern the codintern to set
     */
    public void setCodintern(String codintern) {
        this.codintern = codintern;
    }

    /**
     * @return the tipotribu
     */
    public String getTipotribu() {
        return tipotribu;
    }

    /**
     * @param tipotribu the tipotribu to set
     */
    public void setTipotribu(String tipotribu) {
        this.tipotribu = tipotribu;
    }

    /**
     * @return the precoven1
     */
    public Double getPrecoven1() {
        return precoven1;
    }

    /**
     * @param precoven1 the precoven1 to set
     */
    public void setPrecoven1(Double precoven1) {
        this.precoven1 = precoven1;
    }

    /**
     * @return the qtdestoq
     */
    public Double getQtdestoq() {
        return qtdestoq;
    }

    /**
     * @param qtdestoq the qtdestoq to set
     */
    public void setQtdestoq(Double qtdestoq) {
        this.qtdestoq = qtdestoq;
    }

    /**
     * @return the pathfoto
     */
    public String getPathfoto() {
        return pathfoto;
    }

    /**
     * @param pathfoto the pathfoto to set
     */
    public void setPathfoto(String pathfoto) {
        this.pathfoto = pathfoto;
    }

    /**
     * @return the agcodigo
     */
    public String getAgcodigo() {
        return agcodigo;
    }

    /**
     * @param agcodigo the agcodigo to set
     */
    public void setAgcodigo(String agcodigo) {
        this.agcodigo = agcodigo;
    }

    /**
     * @return the excluido
     */
    public String getExcluido() {
        return excluido;
    }

    /**
     * @param excluido the excluido to set
     */
    public void setExcluido(String excluido) {
        this.excluido = excluido;
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
     * @return the deprotot
     */
    public Double getDeprotot() {
        return deprotot;
    }

    /**
     * @param deprotot the deprotot to set
     */
    public void setDeprotot(Double deprotot) {
        this.deprotot = deprotot;
    }

    /**
     * @return the acprotot
     */
    public Double getAcprotot() {
        return acprotot;
    }

    /**
     * @param acprotot the acprotot to set
     */
    public void setAcprotot(Double acprotot) {
        this.acprotot = acprotot;
    }

    /**
     * @return the composto
     */
    public String getComposto() {
        return composto;
    }

    /**
     * @param composto the composto to set
     */
    public void setComposto(String composto) {
        this.composto = composto;
    }

    /**
     * @return the cacodori
     */
    public String getCacodori() {
        return cacodori;
    }

    /**
     * @param cacodori the cacodori to set
     */
    public void setCacodori(String cacodori) {
        this.cacodori = cacodori;
    }

    /**
     * @return the setorori
     */
    public String getSetorori() {
        return setorori;
    }

    /**
     * @param setorori the setorori to set
     */
    public void setSetorori(String setorori) {
        this.setorori = setorori;
    }

    /**
     * @return the codrecei
     */
    public String getCodrecei() {
        return codrecei;
    }

    /**
     * @param codrecei the codrecei to set
     */
    public void setCodrecei(String codrecei) {
        this.codrecei = codrecei;
    }

    /**
     * @return the horarece
     */
    public String getHorarece() {
        return horarece;
    }

    /**
     * @param horarece the horarece to set
     */
    public void setHorarece(String horarece) {
        this.horarece = horarece;
    }

    /**
     * @return the qtdrecei
     */
    public Double getQtdrecei() {
        return qtdrecei;
    }

    /**
     * @param qtdrecei the qtdrecei to set
     */
    public void setQtdrecei(Double qtdrecei) {
        this.qtdrecei = qtdrecei;
    }

    /**
     * @return the tipofab
     */
    public String getTipofab() {
        return tipofab;
    }

    /**
     * @param tipofab the tipofab to set
     */
    public void setTipofab(String tipofab) {
        this.tipofab = tipofab;
    }

    /**
     * @return the iat
     */
    public String getIat() {
        return iat;
    }

    /**
     * @param iat the iat to set
     */
    public void setIat(String iat) {
        this.iat = iat;
    }

    /**
     * @return the cacodcup
     */
    public String getCacodcup() {
        return cacodcup;
    }

    /**
     * @param cacodcup the cacodcup to set
     */
    public void setCacodcup(String cacodcup) {
        this.cacodcup = cacodcup;
    }

    /**
     * @return the vdcodigo
     */
    public Integer getVdcodigo() {
        return vdcodigo;
    }

    /**
     * @param vdcodigo the vdcodigo to set
     */
    public void setVdcodigo(Integer vdcodigo) {
        this.vdcodigo = vdcodigo;
    }

    /**
     * @return the itemvend
     */
    public Integer getItemvend() {
        return itemvend;
    }

    /**
     * @param itemvend the itemvend to set
     */
    public void setItemvend(Integer itemvend) {
        this.itemvend = itemvend;
    }

    /**
     * @return the datahoracup
     */
    public Date getDatahoracup() {
        return datahoracup;
    }

    /**
     * @param datahoracup the datahoracup to set
     */
    public void setDatahoracup(Date datahoracup) {
        this.datahoracup = datahoracup;
    }

    /**
     * @return the datacup
     */
    public Date getDatacup() {
        return datacup;
    }

    /**
     * @param datacup the datacup to set
     */
    public void setDatacup(Date datacup) {
        this.datacup = datacup;
    }

    /**
     * @return the numcupom
     */
    public Integer getNumcupom() {
        return numcupom;
    }

    /**
     * @param numcupom the numcupom to set
     */
    public void setNumcupom(Integer numcupom) {
        this.numcupom = numcupom;
    }

    /**
     * @return the numcoocup
     */
    public Integer getNumcoocup() {
        return numcoocup;
    }

    /**
     * @param numcoocup the numcoocup to set
     */
    public void setNumcoocup(Integer numcoocup) {
        this.numcoocup = numcoocup;
    }

    /**
     * @return the dtmovcup
     */
    public Date getDtmovcup() {
        return dtmovcup;
    }

    /**
     * @param dtmovcup the dtmovcup to set
     */
    public void setDtmovcup(Date dtmovcup) {
        this.dtmovcup = dtmovcup;
    }

    /**
     * @return the ecfserievnd
     */
    public String getEcfserievnd() {
        return ecfserievnd;
    }

    /**
     * @param ecfserievnd the ecfserievnd to set
     */
    public void setEcfserievnd(String ecfserievnd) {
        this.ecfserievnd = ecfserievnd;
    }

}
