/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo;

import java.sql.Blob;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Raul
 */
public class IteOrcamBean {

    private Integer orcodigo;
    private Integer numitem;
    private Integer dav;
    private String mfcodigo;
    private String nome;
    private String uncodigo;
    private Double aliqicms;
    private String codtrib;
    private String desctrib;
    private Double qtditem;
    private Double prcunit;
    private Double valitem;
    private Double aliqipi;
    private Double qtdret;
    private Double valret;
    private Integer fucodigo;
    private String tipotribu;
    private Double desconto;
    private Double percdesc;
    private Double acrescimo;
    private Double percacres;
    private String flagtrans;
    private String servmun;
    private Integer fuautor;
    private Double deprotot;
    private Double acprotot;
    private String excluido;
    private Date dataalte;
    private Date dataincl;
    private Double qtdpecas;
    private Double diametro;
    private Blob obs;
    private Double comprimento;
    private Date horapedi;
    private String desccomp;
    private String pafhashver;
    private String pafhashdet;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.getOrcodigo());
        hash = 89 * hash + Objects.hashCode(this.getNumitem());
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
        final IteOrcamBean other = (IteOrcamBean) obj;
        if (!Objects.equals(this.orcodigo, other.orcodigo)) {
            return false;
        }
        if (!Objects.equals(this.numitem, other.numitem)) {
            return false;
        }
        return true;
    }

    /**
     * @return the orcodigo
     */
    public Integer getOrcodigo() {
        return orcodigo;
    }

    /**
     * @param orcodigo the orcodigo to set
     */
    public void setOrcodigo(Integer orcodigo) {
        this.orcodigo = orcodigo;
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
     * @return the dav
     */
    public Integer getDav() {
        return dav;
    }

    /**
     * @param dav the dav to set
     */
    public void setDav(Integer dav) {
        this.dav = dav;
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
     * @return the desctrib
     */
    public String getDesctrib() {
        return desctrib;
    }

    /**
     * @param desctrib the desctrib to set
     */
    public void setDesctrib(String desctrib) {
        this.desctrib = desctrib;
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
     * @return the qtdret
     */
    public Double getQtdret() {
        return qtdret;
    }

    /**
     * @param qtdret the qtdret to set
     */
    public void setQtdret(Double qtdret) {
        this.qtdret = qtdret;
    }

    /**
     * @return the valret
     */
    public Double getValret() {
        return valret;
    }

    /**
     * @param valret the valret to set
     */
    public void setValret(Double valret) {
        this.valret = valret;
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
     * @return the desconto
     */
    public Double getDesconto() {
        return desconto;
    }

    /**
     * @param desconto the desconto to set
     */
    public void setDesconto(Double desconto) {
        this.desconto = desconto;
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
     * @return the acrescimo
     */
    public Double getAcrescimo() {
        return acrescimo;
    }

    /**
     * @param acrescimo the acrescimo to set
     */
    public void setAcrescimo(Double acrescimo) {
        this.acrescimo = acrescimo;
    }

    /**
     * @return the percacres
     */
    public Double getPercacres() {
        return percacres;
    }

    /**
     * @param percacres the percacres to set
     */
    public void setPercacres(Double percacres) {
        this.percacres = percacres;
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
     * @return the servmun
     */
    public String getServmun() {
        return servmun;
    }

    /**
     * @param servmun the servmun to set
     */
    public void setServmun(String servmun) {
        this.servmun = servmun;
    }

    /**
     * @return the fuautor
     */
    public Integer getFuautor() {
        return fuautor;
    }

    /**
     * @param fuautor the fuautor to set
     */
    public void setFuautor(Integer fuautor) {
        this.fuautor = fuautor;
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
     * @return the dataincl
     */
    public Date getDataincl() {
        return dataincl;
    }

    /**
     * @param dataincl the dataincl to set
     */
    public void setDataincl(Date dataincl) {
        this.dataincl = dataincl;
    }

    /**
     * @return the qtdpecas
     */
    public Double getQtdpecas() {
        return qtdpecas;
    }

    /**
     * @param qtdpecas the qtdpecas to set
     */
    public void setQtdpecas(Double qtdpecas) {
        this.qtdpecas = qtdpecas;
    }

    /**
     * @return the diametro
     */
    public Double getDiametro() {
        return diametro;
    }

    /**
     * @param diametro the diametro to set
     */
    public void setDiametro(Double diametro) {
        this.diametro = diametro;
    }

    /**
     * @return the obs
     */
    public Blob getObs() {
        return obs;
    }

    /**
     * @param obs the obs to set
     */
    public void setObs(Blob obs) {
        this.obs = obs;
    }

    /**
     * @return the comprimento
     */
    public Double getComprimento() {
        return comprimento;
    }

    /**
     * @param comprimento the comprimento to set
     */
    public void setComprimento(Double comprimento) {
        this.comprimento = comprimento;
    }

    /**
     * @return the horapedi
     */
    public Date getHorapedi() {
        return horapedi;
    }

    /**
     * @param horapedi the horapedi to set
     */
    public void setHorapedi(Date horapedi) {
        this.horapedi = horapedi;
    }

    /**
     * @return the desccomp
     */
    public String getDesccomp() {
        return desccomp;
    }

    /**
     * @param desccomp the desccomp to set
     */
    public void setDesccomp(String desccomp) {
        this.desccomp = desccomp;
    }

    /**
     * @return the pafhashver
     */
    public String getPafhashver() {
        return pafhashver;
    }

    /**
     * @param pafhashver the pafhashver to set
     */
    public void setPafhashver(String pafhashver) {
        this.pafhashver = pafhashver;
    }

    /**
     * @return the pafhashdet
     */
    public String getPafhashdet() {
        return pafhashdet;
    }

    /**
     * @param pafhashdet the pafhashdet to set
     */
    public void setPafhashdet(String pafhashdet) {
        this.pafhashdet = pafhashdet;
    }

}
