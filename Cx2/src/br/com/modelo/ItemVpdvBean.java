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
public class ItemVpdvBean {

    private String cacodigo;
    private Integer vdcodigo;
    private Integer numitem;
    private String mfcodigo;
    private String plcodigo;
    private Double qtditem;
    private Double valitem;
    private Integer fucodigo;
    private Integer fucodlan;
    private Integer fucoddes;
    private String seqtotecf;
    private Double aliqicms;
    private String codtrib;
    private String desctrib;
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
    private String comandaok;
    private Date datacoma;
    private String tipofab;
    private String iat;
    private Integer mesaoritr;
    private Integer mbcodigo;
    private String tqcodigo;
    private String bmcodigo;
    private String bicodigo;
    private String descbico;
    private Double encinici;
    private Double encfinal;
    private String cartaopas;
    private String posimesa;
    private String cvcodigo;
    private String vaspartida;
    private String vasvencime;
    private String vastipo;
    private Integer vasfocodig;
    private String vascodprod;
    private String vasnomecid;
    private String origem;
    private Integer mecodigo;
    private Double precocus;
    private Double prccumed;
    private Double prccucon;
    private Double prccumec;
    private Double precoref;
    private String ecfserie;
    private Integer numerocoo;
    private Integer numcupom;
    private String pafindcanc;
    private String modelodoc;
    private String pafhashver;
    private String pafhashdet;
    private String cstpis;
    private Double vlrbcpis;
    private Double aliqpis;
    private Double valorpis;
    private Double vlrpisst;
    private String cstcofin;
    private Double vlrbccfs;
    private Double aliqcfs;
    private Double valorcfs;
    private Double vlrcfsst;
    private Integer numitemdav;
    private Date datadamov;
    private String ecfseque;
    private String ecfmarca;
    private String ecfmodelo;
    private String ecftipo;
    private String swbversao;
    private Date swbdthrgr;
    private String swbmfadic;
    private Integer arcodigo;
    private Double qtddevol;
    private String dadomaqu;
    private Date horapedi;
    private String desccomp;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.getCacodigo());
        hash = 61 * hash + Objects.hashCode(this.getVdcodigo());
        hash = 61 * hash + Objects.hashCode(this.getNumitem());
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
        final ItemVpdvBean other = (ItemVpdvBean) obj;
        if (!Objects.equals(this.cacodigo, other.cacodigo)) {
            return false;
        }
        if (!Objects.equals(this.vdcodigo, other.vdcodigo)) {
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
     * @return the fucoddes
     */
    public Integer getFucoddes() {
        return fucoddes;
    }

    /**
     * @param fucoddes the fucoddes to set
     */
    public void setFucoddes(Integer fucoddes) {
        this.fucoddes = fucoddes;
    }

    /**
     * @return the seqtotecf
     */
    public String getSeqtotecf() {
        return seqtotecf;
    }

    /**
     * @param seqtotecf the seqtotecf to set
     */
    public void setSeqtotecf(String seqtotecf) {
        this.seqtotecf = seqtotecf;
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
     * @return the comandaok
     */
    public String getComandaok() {
        return comandaok;
    }

    /**
     * @param comandaok the comandaok to set
     */
    public void setComandaok(String comandaok) {
        this.comandaok = comandaok;
    }

    /**
     * @return the datacoma
     */
    public Date getDatacoma() {
        return datacoma;
    }

    /**
     * @param datacoma the datacoma to set
     */
    public void setDatacoma(Date datacoma) {
        this.datacoma = datacoma;
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
     * @return the mesaoritr
     */
    public Integer getMesaoritr() {
        return mesaoritr;
    }

    /**
     * @param mesaoritr the mesaoritr to set
     */
    public void setMesaoritr(Integer mesaoritr) {
        this.mesaoritr = mesaoritr;
    }

    /**
     * @return the mbcodigo
     */
    public Integer getMbcodigo() {
        return mbcodigo;
    }

    /**
     * @param mbcodigo the mbcodigo to set
     */
    public void setMbcodigo(Integer mbcodigo) {
        this.mbcodigo = mbcodigo;
    }

    /**
     * @return the tqcodigo
     */
    public String getTqcodigo() {
        return tqcodigo;
    }

    /**
     * @param tqcodigo the tqcodigo to set
     */
    public void setTqcodigo(String tqcodigo) {
        this.tqcodigo = tqcodigo;
    }

    /**
     * @return the bmcodigo
     */
    public String getBmcodigo() {
        return bmcodigo;
    }

    /**
     * @param bmcodigo the bmcodigo to set
     */
    public void setBmcodigo(String bmcodigo) {
        this.bmcodigo = bmcodigo;
    }

    /**
     * @return the bicodigo
     */
    public String getBicodigo() {
        return bicodigo;
    }

    /**
     * @param bicodigo the bicodigo to set
     */
    public void setBicodigo(String bicodigo) {
        this.bicodigo = bicodigo;
    }

    /**
     * @return the descbico
     */
    public String getDescbico() {
        return descbico;
    }

    /**
     * @param descbico the descbico to set
     */
    public void setDescbico(String descbico) {
        this.descbico = descbico;
    }

    /**
     * @return the encinici
     */
    public Double getEncinici() {
        return encinici;
    }

    /**
     * @param encinici the encinici to set
     */
    public void setEncinici(Double encinici) {
        this.encinici = encinici;
    }

    /**
     * @return the encfinal
     */
    public Double getEncfinal() {
        return encfinal;
    }

    /**
     * @param encfinal the encfinal to set
     */
    public void setEncfinal(Double encfinal) {
        this.encfinal = encfinal;
    }

    /**
     * @return the cartaopas
     */
    public String getCartaopas() {
        return cartaopas;
    }

    /**
     * @param cartaopas the cartaopas to set
     */
    public void setCartaopas(String cartaopas) {
        this.cartaopas = cartaopas;
    }

    /**
     * @return the posimesa
     */
    public String getPosimesa() {
        return posimesa;
    }

    /**
     * @param posimesa the posimesa to set
     */
    public void setPosimesa(String posimesa) {
        this.posimesa = posimesa;
    }

    /**
     * @return the cvcodigo
     */
    public String getCvcodigo() {
        return cvcodigo;
    }

    /**
     * @param cvcodigo the cvcodigo to set
     */
    public void setCvcodigo(String cvcodigo) {
        this.cvcodigo = cvcodigo;
    }

    /**
     * @return the vaspartida
     */
    public String getVaspartida() {
        return vaspartida;
    }

    /**
     * @param vaspartida the vaspartida to set
     */
    public void setVaspartida(String vaspartida) {
        this.vaspartida = vaspartida;
    }

    /**
     * @return the vasvencime
     */
    public String getVasvencime() {
        return vasvencime;
    }

    /**
     * @param vasvencime the vasvencime to set
     */
    public void setVasvencime(String vasvencime) {
        this.vasvencime = vasvencime;
    }

    /**
     * @return the vastipo
     */
    public String getVastipo() {
        return vastipo;
    }

    /**
     * @param vastipo the vastipo to set
     */
    public void setVastipo(String vastipo) {
        this.vastipo = vastipo;
    }

    /**
     * @return the vasfocodig
     */
    public Integer getVasfocodig() {
        return vasfocodig;
    }

    /**
     * @param vasfocodig the vasfocodig to set
     */
    public void setVasfocodig(Integer vasfocodig) {
        this.vasfocodig = vasfocodig;
    }

    /**
     * @return the vascodprod
     */
    public String getVascodprod() {
        return vascodprod;
    }

    /**
     * @param vascodprod the vascodprod to set
     */
    public void setVascodprod(String vascodprod) {
        this.vascodprod = vascodprod;
    }

    /**
     * @return the vasnomecid
     */
    public String getVasnomecid() {
        return vasnomecid;
    }

    /**
     * @param vasnomecid the vasnomecid to set
     */
    public void setVasnomecid(String vasnomecid) {
        this.vasnomecid = vasnomecid;
    }

    /**
     * @return the origem
     */
    public String getOrigem() {
        return origem;
    }

    /**
     * @param origem the origem to set
     */
    public void setOrigem(String origem) {
        this.origem = origem;
    }

    /**
     * @return the mecodigo
     */
    public Integer getMecodigo() {
        return mecodigo;
    }

    /**
     * @param mecodigo the mecodigo to set
     */
    public void setMecodigo(Integer mecodigo) {
        this.mecodigo = mecodigo;
    }

    /**
     * @return the precocus
     */
    public Double getPrecocus() {
        return precocus;
    }

    /**
     * @param precocus the precocus to set
     */
    public void setPrecocus(Double precocus) {
        this.precocus = precocus;
    }

    /**
     * @return the prccumed
     */
    public Double getPrccumed() {
        return prccumed;
    }

    /**
     * @param prccumed the prccumed to set
     */
    public void setPrccumed(Double prccumed) {
        this.prccumed = prccumed;
    }

    /**
     * @return the prccucon
     */
    public Double getPrccucon() {
        return prccucon;
    }

    /**
     * @param prccucon the prccucon to set
     */
    public void setPrccucon(Double prccucon) {
        this.prccucon = prccucon;
    }

    /**
     * @return the prccumec
     */
    public Double getPrccumec() {
        return prccumec;
    }

    /**
     * @param prccumec the prccumec to set
     */
    public void setPrccumec(Double prccumec) {
        this.prccumec = prccumec;
    }

    /**
     * @return the precoref
     */
    public Double getPrecoref() {
        return precoref;
    }

    /**
     * @param precoref the precoref to set
     */
    public void setPrecoref(Double precoref) {
        this.precoref = precoref;
    }

    /**
     * @return the ecfserie
     */
    public String getEcfserie() {
        return ecfserie;
    }

    /**
     * @param ecfserie the ecfserie to set
     */
    public void setEcfserie(String ecfserie) {
        this.ecfserie = ecfserie;
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
     * @return the pafindcanc
     */
    public String getPafindcanc() {
        return pafindcanc;
    }

    /**
     * @param pafindcanc the pafindcanc to set
     */
    public void setPafindcanc(String pafindcanc) {
        this.pafindcanc = pafindcanc;
    }

    /**
     * @return the modelodoc
     */
    public String getModelodoc() {
        return modelodoc;
    }

    /**
     * @param modelodoc the modelodoc to set
     */
    public void setModelodoc(String modelodoc) {
        this.modelodoc = modelodoc;
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

    /**
     * @return the cstpis
     */
    public String getCstpis() {
        return cstpis;
    }

    /**
     * @param cstpis the cstpis to set
     */
    public void setCstpis(String cstpis) {
        this.cstpis = cstpis;
    }

    /**
     * @return the vlrbcpis
     */
    public Double getVlrbcpis() {
        return vlrbcpis;
    }

    /**
     * @param vlrbcpis the vlrbcpis to set
     */
    public void setVlrbcpis(Double vlrbcpis) {
        this.vlrbcpis = vlrbcpis;
    }

    /**
     * @return the aliqpis
     */
    public Double getAliqpis() {
        return aliqpis;
    }

    /**
     * @param aliqpis the aliqpis to set
     */
    public void setAliqpis(Double aliqpis) {
        this.aliqpis = aliqpis;
    }

    /**
     * @return the valorpis
     */
    public Double getValorpis() {
        return valorpis;
    }

    /**
     * @param valorpis the valorpis to set
     */
    public void setValorpis(Double valorpis) {
        this.valorpis = valorpis;
    }

    /**
     * @return the vlrpisst
     */
    public Double getVlrpisst() {
        return vlrpisst;
    }

    /**
     * @param vlrpisst the vlrpisst to set
     */
    public void setVlrpisst(Double vlrpisst) {
        this.vlrpisst = vlrpisst;
    }

    /**
     * @return the cstcofin
     */
    public String getCstcofin() {
        return cstcofin;
    }

    /**
     * @param cstcofin the cstcofin to set
     */
    public void setCstcofin(String cstcofin) {
        this.cstcofin = cstcofin;
    }

    /**
     * @return the vlrbccfs
     */
    public Double getVlrbccfs() {
        return vlrbccfs;
    }

    /**
     * @param vlrbccfs the vlrbccfs to set
     */
    public void setVlrbccfs(Double vlrbccfs) {
        this.vlrbccfs = vlrbccfs;
    }

    /**
     * @return the aliqcfs
     */
    public Double getAliqcfs() {
        return aliqcfs;
    }

    /**
     * @param aliqcfs the aliqcfs to set
     */
    public void setAliqcfs(Double aliqcfs) {
        this.aliqcfs = aliqcfs;
    }

    /**
     * @return the valorcfs
     */
    public Double getValorcfs() {
        return valorcfs;
    }

    /**
     * @param valorcfs the valorcfs to set
     */
    public void setValorcfs(Double valorcfs) {
        this.valorcfs = valorcfs;
    }

    /**
     * @return the vlrcfsst
     */
    public Double getVlrcfsst() {
        return vlrcfsst;
    }

    /**
     * @param vlrcfsst the vlrcfsst to set
     */
    public void setVlrcfsst(Double vlrcfsst) {
        this.vlrcfsst = vlrcfsst;
    }

    /**
     * @return the numitemdav
     */
    public Integer getNumitemdav() {
        return numitemdav;
    }

    /**
     * @param numitemdav the numitemdav to set
     */
    public void setNumitemdav(Integer numitemdav) {
        this.numitemdav = numitemdav;
    }

    /**
     * @return the datadamov
     */
    public Date getDatadamov() {
        return datadamov;
    }

    /**
     * @param datadamov the datadamov to set
     */
    public void setDatadamov(Date datadamov) {
        this.datadamov = datadamov;
    }

    /**
     * @return the ecfseque
     */
    public String getEcfseque() {
        return ecfseque;
    }

    /**
     * @param ecfseque the ecfseque to set
     */
    public void setEcfseque(String ecfseque) {
        this.ecfseque = ecfseque;
    }

    /**
     * @return the ecfmarca
     */
    public String getEcfmarca() {
        return ecfmarca;
    }

    /**
     * @param ecfmarca the ecfmarca to set
     */
    public void setEcfmarca(String ecfmarca) {
        this.ecfmarca = ecfmarca;
    }

    /**
     * @return the ecfmodelo
     */
    public String getEcfmodelo() {
        return ecfmodelo;
    }

    /**
     * @param ecfmodelo the ecfmodelo to set
     */
    public void setEcfmodelo(String ecfmodelo) {
        this.ecfmodelo = ecfmodelo;
    }

    /**
     * @return the ecftipo
     */
    public String getEcftipo() {
        return ecftipo;
    }

    /**
     * @param ecftipo the ecftipo to set
     */
    public void setEcftipo(String ecftipo) {
        this.ecftipo = ecftipo;
    }

    /**
     * @return the swbversao
     */
    public String getSwbversao() {
        return swbversao;
    }

    /**
     * @param swbversao the swbversao to set
     */
    public void setSwbversao(String swbversao) {
        this.swbversao = swbversao;
    }

    /**
     * @return the swbdthrgr
     */
    public Date getSwbdthrgr() {
        return swbdthrgr;
    }

    /**
     * @param swbdthrgr the swbdthrgr to set
     */
    public void setSwbdthrgr(Date swbdthrgr) {
        this.swbdthrgr = swbdthrgr;
    }

    /**
     * @return the swbmfadic
     */
    public String getSwbmfadic() {
        return swbmfadic;
    }

    /**
     * @param swbmfadic the swbmfadic to set
     */
    public void setSwbmfadic(String swbmfadic) {
        this.swbmfadic = swbmfadic;
    }

    /**
     * @return the arcodigo
     */
    public Integer getArcodigo() {
        return arcodigo;
    }

    /**
     * @param arcodigo the arcodigo to set
     */
    public void setArcodigo(Integer arcodigo) {
        this.arcodigo = arcodigo;
    }

    /**
     * @return the qtddevol
     */
    public Double getQtddevol() {
        return qtddevol;
    }

    /**
     * @param qtddevol the qtddevol to set
     */
    public void setQtddevol(Double qtddevol) {
        this.qtddevol = qtddevol;
    }

    /**
     * @return the dadomaqu
     */
    public String getDadomaqu() {
        return dadomaqu;
    }

    /**
     * @param dadomaqu the dadomaqu to set
     */
    public void setDadomaqu(String dadomaqu) {
        this.dadomaqu = dadomaqu;
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

}
