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
public class PreVdPdvBean {

    private Integer vdcodigo;
    private String cacodigo;
    private String situacao;
    private String stsproc;
    private String codsolicitfarma;
    private String numautorizacao;
    private String msgproc;
    private String vdacacod;
    private Integer vdavdcod;
    private String cafechpre;
    private Integer numeronf;
    private String serienf;
    private String precanc;
    private Date datahoracup;
    private Date data;
    private Integer vendedor;
    private Integer clcodigo;
    private String nomeclie;
    private String cgcclie;
    private String cpfclie;
    private Double limcrebai;
    private Double limcresec;
    private String codintern;
    private Double desconto;
    private Double acrescimo;
    private Double valvenda;
    private Integer equipame;
    private String mscodigo;
    private Integer mecodigo;
    private Date dataamesa;
    private String confecfser;
    private String confeecf;
    private Integer confecoo;
    private Integer confecer;
    private Integer fucodigo;
    private Integer periodo;
    private String horario;
    private String ecfseque;
    private String ecfserie;
    private String ecfmarca;
    private String ecfmodelo;
    private String ecftipo;
    private String swbversao;
    private Date swbdthrgr;
    private String swbmfadic;
    private Integer numcupom;
    private Integer qtdpessoa;
    private Integer qtdcupent;
    private String horainic;
    private String horapagt;
    private Integer dav;
    private String numorcam;
    private String nome;
    private String endereco;
    private String telefone;
    private String documento;
    private Integer numerocoo;
    private String obs1;
    private String obs2;
    private String obs3;
    private String obs4;
    private String obs5;
    private String obs6;
    private String obs7;
    private String obs8;
    private Integer km;
    private String placa;
    private String baixaesto;
    private Integer clcodpai;
    private String flagtrans;
    private Integer ficodigo;
    private String setoruso;
    private Integer facodigo;
    private String centcusto;
    private String pasembarque;
    private String pasdestino;
    private String paslinha;
    private String pasagencia;
    private String pasdata;
    private String pashora;
    private String paspoltrona;
    private String pasplataforma;
    private String pastipopassagem;
    private String pasrg;
    private String pasnome;
    private String pasendereco;
    private String pasufdestino;
    private Integer paspercurso;
    private Integer pastpvenda;
    private Integer pascodard;
    private String codautoext;
    private String origem;
    private String multmesas;
    private String pafindcanc;
    private String modelodoc;
    private String pafhashver;
    private String pafhashcap;
    private Double vlrbcpis;
    private Double valorpis;
    private Double vlrpisst;
    private Double vlrbccfs;
    private Double valorcfs;
    private Double vlrcfsst;
    private Date datadamov;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.getVdcodigo());
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
        final PreVdPdvBean other = (PreVdPdvBean) obj;
        if (!Objects.equals(this.vdcodigo, other.vdcodigo)) {
            return false;
        }
        return true;
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
     * @return the situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the stsproc
     */
    public String getStsproc() {
        return stsproc;
    }

    /**
     * @param stsproc the stsproc to set
     */
    public void setStsproc(String stsproc) {
        this.stsproc = stsproc;
    }

    /**
     * @return the codsolicitfarma
     */
    public String getCodsolicitfarma() {
        return codsolicitfarma;
    }

    /**
     * @param codsolicitfarma the codsolicitfarma to set
     */
    public void setCodsolicitfarma(String codsolicitfarma) {
        this.codsolicitfarma = codsolicitfarma;
    }

    /**
     * @return the numautorizacao
     */
    public String getNumautorizacao() {
        return numautorizacao;
    }

    /**
     * @param numautorizacao the numautorizacao to set
     */
    public void setNumautorizacao(String numautorizacao) {
        this.numautorizacao = numautorizacao;
    }

    /**
     * @return the msgproc
     */
    public String getMsgproc() {
        return msgproc;
    }

    /**
     * @param msgproc the msgproc to set
     */
    public void setMsgproc(String msgproc) {
        this.msgproc = msgproc;
    }

    /**
     * @return the vdacacod
     */
    public String getVdacacod() {
        return vdacacod;
    }

    /**
     * @param vdacacod the vdacacod to set
     */
    public void setVdacacod(String vdacacod) {
        this.vdacacod = vdacacod;
    }

    /**
     * @return the vdavdcod
     */
    public Integer getVdavdcod() {
        return vdavdcod;
    }

    /**
     * @param vdavdcod the vdavdcod to set
     */
    public void setVdavdcod(Integer vdavdcod) {
        this.vdavdcod = vdavdcod;
    }

    /**
     * @return the cafechpre
     */
    public String getCafechpre() {
        return cafechpre;
    }

    /**
     * @param cafechpre the cafechpre to set
     */
    public void setCafechpre(String cafechpre) {
        this.cafechpre = cafechpre;
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
     * @return the precanc
     */
    public String getPrecanc() {
        return precanc;
    }

    /**
     * @param precanc the precanc to set
     */
    public void setPrecanc(String precanc) {
        this.precanc = precanc;
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
     * @return the vendedor
     */
    public Integer getVendedor() {
        return vendedor;
    }

    /**
     * @param vendedor the vendedor to set
     */
    public void setVendedor(Integer vendedor) {
        this.vendedor = vendedor;
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
     * @return the nomeclie
     */
    public String getNomeclie() {
        return nomeclie;
    }

    /**
     * @param nomeclie the nomeclie to set
     */
    public void setNomeclie(String nomeclie) {
        this.nomeclie = nomeclie;
    }

    /**
     * @return the cgcclie
     */
    public String getCgcclie() {
        return cgcclie;
    }

    /**
     * @param cgcclie the cgcclie to set
     */
    public void setCgcclie(String cgcclie) {
        this.cgcclie = cgcclie;
    }

    /**
     * @return the cpfclie
     */
    public String getCpfclie() {
        return cpfclie;
    }

    /**
     * @param cpfclie the cpfclie to set
     */
    public void setCpfclie(String cpfclie) {
        this.cpfclie = cpfclie;
    }

    /**
     * @return the limcrebai
     */
    public Double getLimcrebai() {
        return limcrebai;
    }

    /**
     * @param limcrebai the limcrebai to set
     */
    public void setLimcrebai(Double limcrebai) {
        this.limcrebai = limcrebai;
    }

    /**
     * @return the limcresec
     */
    public Double getLimcresec() {
        return limcresec;
    }

    /**
     * @param limcresec the limcresec to set
     */
    public void setLimcresec(Double limcresec) {
        this.limcresec = limcresec;
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
     * @return the valvenda
     */
    public Double getValvenda() {
        return valvenda;
    }

    /**
     * @param valvenda the valvenda to set
     */
    public void setValvenda(Double valvenda) {
        this.valvenda = valvenda;
    }

    /**
     * @return the equipame
     */
    public Integer getEquipame() {
        return equipame;
    }

    /**
     * @param equipame the equipame to set
     */
    public void setEquipame(Integer equipame) {
        this.equipame = equipame;
    }

    /**
     * @return the mscodigo
     */
    public String getMscodigo() {
        return mscodigo;
    }

    /**
     * @param mscodigo the mscodigo to set
     */
    public void setMscodigo(String mscodigo) {
        this.mscodigo = mscodigo;
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
     * @return the dataamesa
     */
    public Date getDataamesa() {
        return dataamesa;
    }

    /**
     * @param dataamesa the dataamesa to set
     */
    public void setDataamesa(Date dataamesa) {
        this.dataamesa = dataamesa;
    }

    /**
     * @return the confecfser
     */
    public String getConfecfser() {
        return confecfser;
    }

    /**
     * @param confecfser the confecfser to set
     */
    public void setConfecfser(String confecfser) {
        this.confecfser = confecfser;
    }

    /**
     * @return the confeecf
     */
    public String getConfeecf() {
        return confeecf;
    }

    /**
     * @param confeecf the confeecf to set
     */
    public void setConfeecf(String confeecf) {
        this.confeecf = confeecf;
    }

    /**
     * @return the confecoo
     */
    public Integer getConfecoo() {
        return confecoo;
    }

    /**
     * @param confecoo the confecoo to set
     */
    public void setConfecoo(Integer confecoo) {
        this.confecoo = confecoo;
    }

    /**
     * @return the confecer
     */
    public Integer getConfecer() {
        return confecer;
    }

    /**
     * @param confecer the confecer to set
     */
    public void setConfecer(Integer confecer) {
        this.confecer = confecer;
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
     * @return the qtdpessoa
     */
    public Integer getQtdpessoa() {
        return qtdpessoa;
    }

    /**
     * @param qtdpessoa the qtdpessoa to set
     */
    public void setQtdpessoa(Integer qtdpessoa) {
        this.qtdpessoa = qtdpessoa;
    }

    /**
     * @return the qtdcupent
     */
    public Integer getQtdcupent() {
        return qtdcupent;
    }

    /**
     * @param qtdcupent the qtdcupent to set
     */
    public void setQtdcupent(Integer qtdcupent) {
        this.qtdcupent = qtdcupent;
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
     * @return the horapagt
     */
    public String getHorapagt() {
        return horapagt;
    }

    /**
     * @param horapagt the horapagt to set
     */
    public void setHorapagt(String horapagt) {
        this.horapagt = horapagt;
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
     * @return the numorcam
     */
    public String getNumorcam() {
        return numorcam;
    }

    /**
     * @param numorcam the numorcam to set
     */
    public void setNumorcam(String numorcam) {
        this.numorcam = numorcam;
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
     * @return the documento
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(String documento) {
        this.documento = documento;
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
     * @return the obs1
     */
    public String getObs1() {
        return obs1;
    }

    /**
     * @param obs1 the obs1 to set
     */
    public void setObs1(String obs1) {
        this.obs1 = obs1;
    }

    /**
     * @return the obs2
     */
    public String getObs2() {
        return obs2;
    }

    /**
     * @param obs2 the obs2 to set
     */
    public void setObs2(String obs2) {
        this.obs2 = obs2;
    }

    /**
     * @return the obs3
     */
    public String getObs3() {
        return obs3;
    }

    /**
     * @param obs3 the obs3 to set
     */
    public void setObs3(String obs3) {
        this.obs3 = obs3;
    }

    /**
     * @return the obs4
     */
    public String getObs4() {
        return obs4;
    }

    /**
     * @param obs4 the obs4 to set
     */
    public void setObs4(String obs4) {
        this.obs4 = obs4;
    }

    /**
     * @return the obs5
     */
    public String getObs5() {
        return obs5;
    }

    /**
     * @param obs5 the obs5 to set
     */
    public void setObs5(String obs5) {
        this.obs5 = obs5;
    }

    /**
     * @return the obs6
     */
    public String getObs6() {
        return obs6;
    }

    /**
     * @param obs6 the obs6 to set
     */
    public void setObs6(String obs6) {
        this.obs6 = obs6;
    }

    /**
     * @return the obs7
     */
    public String getObs7() {
        return obs7;
    }

    /**
     * @param obs7 the obs7 to set
     */
    public void setObs7(String obs7) {
        this.obs7 = obs7;
    }

    /**
     * @return the obs8
     */
    public String getObs8() {
        return obs8;
    }

    /**
     * @param obs8 the obs8 to set
     */
    public void setObs8(String obs8) {
        this.obs8 = obs8;
    }

    /**
     * @return the km
     */
    public Integer getKm() {
        return km;
    }

    /**
     * @param km the km to set
     */
    public void setKm(Integer km) {
        this.km = km;
    }

    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
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
     * @return the clcodpai
     */
    public Integer getClcodpai() {
        return clcodpai;
    }

    /**
     * @param clcodpai the clcodpai to set
     */
    public void setClcodpai(Integer clcodpai) {
        this.clcodpai = clcodpai;
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
     * @return the ficodigo
     */
    public Integer getFicodigo() {
        return ficodigo;
    }

    /**
     * @param ficodigo the ficodigo to set
     */
    public void setFicodigo(Integer ficodigo) {
        this.ficodigo = ficodigo;
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
     * @return the facodigo
     */
    public Integer getFacodigo() {
        return facodigo;
    }

    /**
     * @param facodigo the facodigo to set
     */
    public void setFacodigo(Integer facodigo) {
        this.facodigo = facodigo;
    }

    /**
     * @return the centcusto
     */
    public String getCentcusto() {
        return centcusto;
    }

    /**
     * @param centcusto the centcusto to set
     */
    public void setCentcusto(String centcusto) {
        this.centcusto = centcusto;
    }

    /**
     * @return the pasembarque
     */
    public String getPasembarque() {
        return pasembarque;
    }

    /**
     * @param pasembarque the pasembarque to set
     */
    public void setPasembarque(String pasembarque) {
        this.pasembarque = pasembarque;
    }

    /**
     * @return the pasdestino
     */
    public String getPasdestino() {
        return pasdestino;
    }

    /**
     * @param pasdestino the pasdestino to set
     */
    public void setPasdestino(String pasdestino) {
        this.pasdestino = pasdestino;
    }

    /**
     * @return the paslinha
     */
    public String getPaslinha() {
        return paslinha;
    }

    /**
     * @param paslinha the paslinha to set
     */
    public void setPaslinha(String paslinha) {
        this.paslinha = paslinha;
    }

    /**
     * @return the pasagencia
     */
    public String getPasagencia() {
        return pasagencia;
    }

    /**
     * @param pasagencia the pasagencia to set
     */
    public void setPasagencia(String pasagencia) {
        this.pasagencia = pasagencia;
    }

    /**
     * @return the pasdata
     */
    public String getPasdata() {
        return pasdata;
    }

    /**
     * @param pasdata the pasdata to set
     */
    public void setPasdata(String pasdata) {
        this.pasdata = pasdata;
    }

    /**
     * @return the pashora
     */
    public String getPashora() {
        return pashora;
    }

    /**
     * @param pashora the pashora to set
     */
    public void setPashora(String pashora) {
        this.pashora = pashora;
    }

    /**
     * @return the paspoltrona
     */
    public String getPaspoltrona() {
        return paspoltrona;
    }

    /**
     * @param paspoltrona the paspoltrona to set
     */
    public void setPaspoltrona(String paspoltrona) {
        this.paspoltrona = paspoltrona;
    }

    /**
     * @return the pasplataforma
     */
    public String getPasplataforma() {
        return pasplataforma;
    }

    /**
     * @param pasplataforma the pasplataforma to set
     */
    public void setPasplataforma(String pasplataforma) {
        this.pasplataforma = pasplataforma;
    }

    /**
     * @return the pastipopassagem
     */
    public String getPastipopassagem() {
        return pastipopassagem;
    }

    /**
     * @param pastipopassagem the pastipopassagem to set
     */
    public void setPastipopassagem(String pastipopassagem) {
        this.pastipopassagem = pastipopassagem;
    }

    /**
     * @return the pasrg
     */
    public String getPasrg() {
        return pasrg;
    }

    /**
     * @param pasrg the pasrg to set
     */
    public void setPasrg(String pasrg) {
        this.pasrg = pasrg;
    }

    /**
     * @return the pasnome
     */
    public String getPasnome() {
        return pasnome;
    }

    /**
     * @param pasnome the pasnome to set
     */
    public void setPasnome(String pasnome) {
        this.pasnome = pasnome;
    }

    /**
     * @return the pasendereco
     */
    public String getPasendereco() {
        return pasendereco;
    }

    /**
     * @param pasendereco the pasendereco to set
     */
    public void setPasendereco(String pasendereco) {
        this.pasendereco = pasendereco;
    }

    /**
     * @return the pasufdestino
     */
    public String getPasufdestino() {
        return pasufdestino;
    }

    /**
     * @param pasufdestino the pasufdestino to set
     */
    public void setPasufdestino(String pasufdestino) {
        this.pasufdestino = pasufdestino;
    }

    /**
     * @return the paspercurso
     */
    public Integer getPaspercurso() {
        return paspercurso;
    }

    /**
     * @param paspercurso the paspercurso to set
     */
    public void setPaspercurso(Integer paspercurso) {
        this.paspercurso = paspercurso;
    }

    /**
     * @return the pastpvenda
     */
    public Integer getPastpvenda() {
        return pastpvenda;
    }

    /**
     * @param pastpvenda the pastpvenda to set
     */
    public void setPastpvenda(Integer pastpvenda) {
        this.pastpvenda = pastpvenda;
    }

    /**
     * @return the pascodard
     */
    public Integer getPascodard() {
        return pascodard;
    }

    /**
     * @param pascodard the pascodard to set
     */
    public void setPascodard(Integer pascodard) {
        this.pascodard = pascodard;
    }

    /**
     * @return the codautoext
     */
    public String getCodautoext() {
        return codautoext;
    }

    /**
     * @param codautoext the codautoext to set
     */
    public void setCodautoext(String codautoext) {
        this.codautoext = codautoext;
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
     * @return the multmesas
     */
    public String getMultmesas() {
        return multmesas;
    }

    /**
     * @param multmesas the multmesas to set
     */
    public void setMultmesas(String multmesas) {
        this.multmesas = multmesas;
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
     * @return the pafhashcap
     */
    public String getPafhashcap() {
        return pafhashcap;
    }

    /**
     * @param pafhashcap the pafhashcap to set
     */
    public void setPafhashcap(String pafhashcap) {
        this.pafhashcap = pafhashcap;
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

}
