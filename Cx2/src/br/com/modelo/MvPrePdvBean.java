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
public class MvPrePdvBean {

    private String cacodigo;
    private Date data;
    private Integer periodo;
    private String tipo;
    private Integer vdcodigo;
    private Integer fpcodigo;
    private Integer seqespec;
    private String esppgecf;
    private Integer lacodigo;
    private Integer fucodigo;
    private String plcodigo;
    private Double valor;
    private String formpgto;
    private Integer numparce;
    private Date datacomp;
    private String horacomp;
    private String setoruso;
    private Integer dtcodigo;
    private String autoritransacao;
    private String bandeira;
    private String tipopagamento;
    private String tipofinanciamen;
    private String tefservidor;
    private Double tefvlrtrefet;
    private Double tefvlrtrefea;
    private String tefidentific;
    private String tefdadosfina;
    private String tefredeautor;
    private String teftiptrrede;
    private String tefnutrannsu;
    private String tefcodauttra;
    private String teftxvlrtran;
    private String tefdatatrans;
    private String tefhoratrans;
    private String tefcodmodpgt;
    private String teftxmodapgt;
    private String teftxmopgcup;
    private String tefnsusitef;
    private String tefbimcartao;
    private String tefnuparcela;
    private String tefdtpredata;
    private String tefnomeopcel;
    private String tefvlrrecarg;
    private String tefdddnumcel;
    private String tefdigiverif;
    private String tefceplteope;
    private String tefnsustprca;
    private String tefnsuhatprc;
    private String tefcofiatrce;
    private String tefnumparcel;
    private String tefnumterlog;
    private String tefcodafilia;
    private String flagtrans;
    private String flagtserv;
    private String ecfseque;
    private String ecfserie;
    private String ecfmarca;
    private String ecfmodelo;
    private String ecftipo;
    private String swbversao;
    private Date swbdthrgr;
    private String swbmfadic;
    private Integer coo;
    private Integer gnf;
    private Integer ccf;
    private Integer grg;
    private Integer cer;
    private String tpvendcart;
    private String cadevoluc;
    private Integer dvcodigo;
    private String origem;
    private String pafhashver;
    private String pafhashdet;
    private Date datadamov;
    private String modelonf;
    private String serienf;
    private String subserienf;
    private Integer numeronf;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.getCacodigo());
        hash = 23 * hash + Objects.hashCode(this.getData());
        hash = 23 * hash + Objects.hashCode(this.getPeriodo());
        hash = 23 * hash + Objects.hashCode(this.getTipo());
        hash = 23 * hash + Objects.hashCode(this.getVdcodigo());
        hash = 23 * hash + Objects.hashCode(this.getFpcodigo());
        hash = 23 * hash + Objects.hashCode(this.getSeqespec());
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
        final MvPrePdvBean other = (MvPrePdvBean) obj;
        if (!Objects.equals(this.cacodigo, other.cacodigo)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.periodo, other.periodo)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.vdcodigo, other.vdcodigo)) {
            return false;
        }
        if (!Objects.equals(this.fpcodigo, other.fpcodigo)) {
            return false;
        }
        if (!Objects.equals(this.seqespec, other.seqespec)) {
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
     * @return the fpcodigo
     */
    public Integer getFpcodigo() {
        return fpcodigo;
    }

    /**
     * @param fpcodigo the fpcodigo to set
     */
    public void setFpcodigo(Integer fpcodigo) {
        this.fpcodigo = fpcodigo;
    }

    /**
     * @return the seqespec
     */
    public Integer getSeqespec() {
        return seqespec;
    }

    /**
     * @param seqespec the seqespec to set
     */
    public void setSeqespec(Integer seqespec) {
        this.seqespec = seqespec;
    }

    /**
     * @return the esppgecf
     */
    public String getEsppgecf() {
        return esppgecf;
    }

    /**
     * @param esppgecf the esppgecf to set
     */
    public void setEsppgecf(String esppgecf) {
        this.esppgecf = esppgecf;
    }

    /**
     * @return the lacodigo
     */
    public Integer getLacodigo() {
        return lacodigo;
    }

    /**
     * @param lacodigo the lacodigo to set
     */
    public void setLacodigo(Integer lacodigo) {
        this.lacodigo = lacodigo;
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
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * @return the formpgto
     */
    public String getFormpgto() {
        return formpgto;
    }

    /**
     * @param formpgto the formpgto to set
     */
    public void setFormpgto(String formpgto) {
        this.formpgto = formpgto;
    }

    /**
     * @return the numparce
     */
    public Integer getNumparce() {
        return numparce;
    }

    /**
     * @param numparce the numparce to set
     */
    public void setNumparce(Integer numparce) {
        this.numparce = numparce;
    }

    /**
     * @return the datacomp
     */
    public Date getDatacomp() {
        return datacomp;
    }

    /**
     * @param datacomp the datacomp to set
     */
    public void setDatacomp(Date datacomp) {
        this.datacomp = datacomp;
    }

    /**
     * @return the horacomp
     */
    public String getHoracomp() {
        return horacomp;
    }

    /**
     * @param horacomp the horacomp to set
     */
    public void setHoracomp(String horacomp) {
        this.horacomp = horacomp;
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
     * @return the dtcodigo
     */
    public Integer getDtcodigo() {
        return dtcodigo;
    }

    /**
     * @param dtcodigo the dtcodigo to set
     */
    public void setDtcodigo(Integer dtcodigo) {
        this.dtcodigo = dtcodigo;
    }

    /**
     * @return the autoritransacao
     */
    public String getAutoritransacao() {
        return autoritransacao;
    }

    /**
     * @param autoritransacao the autoritransacao to set
     */
    public void setAutoritransacao(String autoritransacao) {
        this.autoritransacao = autoritransacao;
    }

    /**
     * @return the bandeira
     */
    public String getBandeira() {
        return bandeira;
    }

    /**
     * @param bandeira the bandeira to set
     */
    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    /**
     * @return the tipopagamento
     */
    public String getTipopagamento() {
        return tipopagamento;
    }

    /**
     * @param tipopagamento the tipopagamento to set
     */
    public void setTipopagamento(String tipopagamento) {
        this.tipopagamento = tipopagamento;
    }

    /**
     * @return the tipofinanciamen
     */
    public String getTipofinanciamen() {
        return tipofinanciamen;
    }

    /**
     * @param tipofinanciamen the tipofinanciamen to set
     */
    public void setTipofinanciamen(String tipofinanciamen) {
        this.tipofinanciamen = tipofinanciamen;
    }

    /**
     * @return the tefservidor
     */
    public String getTefservidor() {
        return tefservidor;
    }

    /**
     * @param tefservidor the tefservidor to set
     */
    public void setTefservidor(String tefservidor) {
        this.tefservidor = tefservidor;
    }

    /**
     * @return the tefvlrtrefet
     */
    public Double getTefvlrtrefet() {
        return tefvlrtrefet;
    }

    /**
     * @param tefvlrtrefet the tefvlrtrefet to set
     */
    public void setTefvlrtrefet(Double tefvlrtrefet) {
        this.tefvlrtrefet = tefvlrtrefet;
    }

    /**
     * @return the tefvlrtrefea
     */
    public Double getTefvlrtrefea() {
        return tefvlrtrefea;
    }

    /**
     * @param tefvlrtrefea the tefvlrtrefea to set
     */
    public void setTefvlrtrefea(Double tefvlrtrefea) {
        this.tefvlrtrefea = tefvlrtrefea;
    }

    /**
     * @return the tefidentific
     */
    public String getTefidentific() {
        return tefidentific;
    }

    /**
     * @param tefidentific the tefidentific to set
     */
    public void setTefidentific(String tefidentific) {
        this.tefidentific = tefidentific;
    }

    /**
     * @return the tefdadosfina
     */
    public String getTefdadosfina() {
        return tefdadosfina;
    }

    /**
     * @param tefdadosfina the tefdadosfina to set
     */
    public void setTefdadosfina(String tefdadosfina) {
        this.tefdadosfina = tefdadosfina;
    }

    /**
     * @return the tefredeautor
     */
    public String getTefredeautor() {
        return tefredeautor;
    }

    /**
     * @param tefredeautor the tefredeautor to set
     */
    public void setTefredeautor(String tefredeautor) {
        this.tefredeautor = tefredeautor;
    }

    /**
     * @return the teftiptrrede
     */
    public String getTeftiptrrede() {
        return teftiptrrede;
    }

    /**
     * @param teftiptrrede the teftiptrrede to set
     */
    public void setTeftiptrrede(String teftiptrrede) {
        this.teftiptrrede = teftiptrrede;
    }

    /**
     * @return the tefnutrannsu
     */
    public String getTefnutrannsu() {
        return tefnutrannsu;
    }

    /**
     * @param tefnutrannsu the tefnutrannsu to set
     */
    public void setTefnutrannsu(String tefnutrannsu) {
        this.tefnutrannsu = tefnutrannsu;
    }

    /**
     * @return the tefcodauttra
     */
    public String getTefcodauttra() {
        return tefcodauttra;
    }

    /**
     * @param tefcodauttra the tefcodauttra to set
     */
    public void setTefcodauttra(String tefcodauttra) {
        this.tefcodauttra = tefcodauttra;
    }

    /**
     * @return the teftxvlrtran
     */
    public String getTeftxvlrtran() {
        return teftxvlrtran;
    }

    /**
     * @param teftxvlrtran the teftxvlrtran to set
     */
    public void setTeftxvlrtran(String teftxvlrtran) {
        this.teftxvlrtran = teftxvlrtran;
    }

    /**
     * @return the tefdatatrans
     */
    public String getTefdatatrans() {
        return tefdatatrans;
    }

    /**
     * @param tefdatatrans the tefdatatrans to set
     */
    public void setTefdatatrans(String tefdatatrans) {
        this.tefdatatrans = tefdatatrans;
    }

    /**
     * @return the tefhoratrans
     */
    public String getTefhoratrans() {
        return tefhoratrans;
    }

    /**
     * @param tefhoratrans the tefhoratrans to set
     */
    public void setTefhoratrans(String tefhoratrans) {
        this.tefhoratrans = tefhoratrans;
    }

    /**
     * @return the tefcodmodpgt
     */
    public String getTefcodmodpgt() {
        return tefcodmodpgt;
    }

    /**
     * @param tefcodmodpgt the tefcodmodpgt to set
     */
    public void setTefcodmodpgt(String tefcodmodpgt) {
        this.tefcodmodpgt = tefcodmodpgt;
    }

    /**
     * @return the teftxmodapgt
     */
    public String getTeftxmodapgt() {
        return teftxmodapgt;
    }

    /**
     * @param teftxmodapgt the teftxmodapgt to set
     */
    public void setTeftxmodapgt(String teftxmodapgt) {
        this.teftxmodapgt = teftxmodapgt;
    }

    /**
     * @return the teftxmopgcup
     */
    public String getTeftxmopgcup() {
        return teftxmopgcup;
    }

    /**
     * @param teftxmopgcup the teftxmopgcup to set
     */
    public void setTeftxmopgcup(String teftxmopgcup) {
        this.teftxmopgcup = teftxmopgcup;
    }

    /**
     * @return the tefnsusitef
     */
    public String getTefnsusitef() {
        return tefnsusitef;
    }

    /**
     * @param tefnsusitef the tefnsusitef to set
     */
    public void setTefnsusitef(String tefnsusitef) {
        this.tefnsusitef = tefnsusitef;
    }

    /**
     * @return the tefbimcartao
     */
    public String getTefbimcartao() {
        return tefbimcartao;
    }

    /**
     * @param tefbimcartao the tefbimcartao to set
     */
    public void setTefbimcartao(String tefbimcartao) {
        this.tefbimcartao = tefbimcartao;
    }

    /**
     * @return the tefnuparcela
     */
    public String getTefnuparcela() {
        return tefnuparcela;
    }

    /**
     * @param tefnuparcela the tefnuparcela to set
     */
    public void setTefnuparcela(String tefnuparcela) {
        this.tefnuparcela = tefnuparcela;
    }

    /**
     * @return the tefdtpredata
     */
    public String getTefdtpredata() {
        return tefdtpredata;
    }

    /**
     * @param tefdtpredata the tefdtpredata to set
     */
    public void setTefdtpredata(String tefdtpredata) {
        this.tefdtpredata = tefdtpredata;
    }

    /**
     * @return the tefnomeopcel
     */
    public String getTefnomeopcel() {
        return tefnomeopcel;
    }

    /**
     * @param tefnomeopcel the tefnomeopcel to set
     */
    public void setTefnomeopcel(String tefnomeopcel) {
        this.tefnomeopcel = tefnomeopcel;
    }

    /**
     * @return the tefvlrrecarg
     */
    public String getTefvlrrecarg() {
        return tefvlrrecarg;
    }

    /**
     * @param tefvlrrecarg the tefvlrrecarg to set
     */
    public void setTefvlrrecarg(String tefvlrrecarg) {
        this.tefvlrrecarg = tefvlrrecarg;
    }

    /**
     * @return the tefdddnumcel
     */
    public String getTefdddnumcel() {
        return tefdddnumcel;
    }

    /**
     * @param tefdddnumcel the tefdddnumcel to set
     */
    public void setTefdddnumcel(String tefdddnumcel) {
        this.tefdddnumcel = tefdddnumcel;
    }

    /**
     * @return the tefdigiverif
     */
    public String getTefdigiverif() {
        return tefdigiverif;
    }

    /**
     * @param tefdigiverif the tefdigiverif to set
     */
    public void setTefdigiverif(String tefdigiverif) {
        this.tefdigiverif = tefdigiverif;
    }

    /**
     * @return the tefceplteope
     */
    public String getTefceplteope() {
        return tefceplteope;
    }

    /**
     * @param tefceplteope the tefceplteope to set
     */
    public void setTefceplteope(String tefceplteope) {
        this.tefceplteope = tefceplteope;
    }

    /**
     * @return the tefnsustprca
     */
    public String getTefnsustprca() {
        return tefnsustprca;
    }

    /**
     * @param tefnsustprca the tefnsustprca to set
     */
    public void setTefnsustprca(String tefnsustprca) {
        this.tefnsustprca = tefnsustprca;
    }

    /**
     * @return the tefnsuhatprc
     */
    public String getTefnsuhatprc() {
        return tefnsuhatprc;
    }

    /**
     * @param tefnsuhatprc the tefnsuhatprc to set
     */
    public void setTefnsuhatprc(String tefnsuhatprc) {
        this.tefnsuhatprc = tefnsuhatprc;
    }

    /**
     * @return the tefcofiatrce
     */
    public String getTefcofiatrce() {
        return tefcofiatrce;
    }

    /**
     * @param tefcofiatrce the tefcofiatrce to set
     */
    public void setTefcofiatrce(String tefcofiatrce) {
        this.tefcofiatrce = tefcofiatrce;
    }

    /**
     * @return the tefnumparcel
     */
    public String getTefnumparcel() {
        return tefnumparcel;
    }

    /**
     * @param tefnumparcel the tefnumparcel to set
     */
    public void setTefnumparcel(String tefnumparcel) {
        this.tefnumparcel = tefnumparcel;
    }

    /**
     * @return the tefnumterlog
     */
    public String getTefnumterlog() {
        return tefnumterlog;
    }

    /**
     * @param tefnumterlog the tefnumterlog to set
     */
    public void setTefnumterlog(String tefnumterlog) {
        this.tefnumterlog = tefnumterlog;
    }

    /**
     * @return the tefcodafilia
     */
    public String getTefcodafilia() {
        return tefcodafilia;
    }

    /**
     * @param tefcodafilia the tefcodafilia to set
     */
    public void setTefcodafilia(String tefcodafilia) {
        this.tefcodafilia = tefcodafilia;
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
     * @return the coo
     */
    public Integer getCoo() {
        return coo;
    }

    /**
     * @param coo the coo to set
     */
    public void setCoo(Integer coo) {
        this.coo = coo;
    }

    /**
     * @return the gnf
     */
    public Integer getGnf() {
        return gnf;
    }

    /**
     * @param gnf the gnf to set
     */
    public void setGnf(Integer gnf) {
        this.gnf = gnf;
    }

    /**
     * @return the ccf
     */
    public Integer getCcf() {
        return ccf;
    }

    /**
     * @param ccf the ccf to set
     */
    public void setCcf(Integer ccf) {
        this.ccf = ccf;
    }

    /**
     * @return the grg
     */
    public Integer getGrg() {
        return grg;
    }

    /**
     * @param grg the grg to set
     */
    public void setGrg(Integer grg) {
        this.grg = grg;
    }

    /**
     * @return the cer
     */
    public Integer getCer() {
        return cer;
    }

    /**
     * @param cer the cer to set
     */
    public void setCer(Integer cer) {
        this.cer = cer;
    }

    /**
     * @return the tpvendcart
     */
    public String getTpvendcart() {
        return tpvendcart;
    }

    /**
     * @param tpvendcart the tpvendcart to set
     */
    public void setTpvendcart(String tpvendcart) {
        this.tpvendcart = tpvendcart;
    }

    /**
     * @return the cadevoluc
     */
    public String getCadevoluc() {
        return cadevoluc;
    }

    /**
     * @param cadevoluc the cadevoluc to set
     */
    public void setCadevoluc(String cadevoluc) {
        this.cadevoluc = cadevoluc;
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
