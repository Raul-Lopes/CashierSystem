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
public class OrcamentBean {

    private Integer orcodigo;
    private Date data;
    private Integer fucodigo;
    private Integer clcodigo;
    private String tipo;
    private String nome;
    private String cnpj;
    private String cpf;
    private String endereco;
    private String bairro;
    private Integer cicodigo;
    private String cep;
    private String uf;
    private String telefone;
    private String cuidados;
    private String fpcodigo;
    private String tipopreco;
    private Double desconto;
    private Double acrescimo;
    private Double valortot;
    private Date datavalid;
    private Date dtparaent;
    private Double totalipi;
    private String numpedcli;
    private String situacao;
    private Integer qtditens;
    private Integer opcodigo;
    private String observa1;
    private String observa2;
    private String observa3;
    private String observa4;
    private String observa5;
    private Double totfrete;
    private Double toticms;
    private String prazo;
    private String cacodigo;
    private Integer vdcodigo;
    private Integer numerocoo;
    private Integer numeroccf;
    private Integer mdcodigo;
    private Integer mccodigo;
    private String ano;
    private Date dataapro;
    private Integer fuaprova;
    private Date dataconf;
    private Integer fuconfer;
    private String serie;
    private String flagtrans;
    private String numplaca;
    private String numrenavam;
    private Integer orcodpai;
    private Blob obscli;
    private Integer dav;
    private String modelonf;
    private String serienf;
    private String subserienf;
    private Integer numeronf;
    private Integer cvcodigo;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.getOrcodigo());
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
        final OrcamentBean other = (OrcamentBean) obj;
        if (!Objects.equals(this.orcodigo, other.orcodigo)) {
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
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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
     * @return the cuidados
     */
    public String getCuidados() {
        return cuidados;
    }

    /**
     * @param cuidados the cuidados to set
     */
    public void setCuidados(String cuidados) {
        this.cuidados = cuidados;
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
     * @return the tipopreco
     */
    public String getTipopreco() {
        return tipopreco;
    }

    /**
     * @param tipopreco the tipopreco to set
     */
    public void setTipopreco(String tipopreco) {
        this.tipopreco = tipopreco;
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
     * @return the valortot
     */
    public Double getValortot() {
        return valortot;
    }

    /**
     * @param valortot the valortot to set
     */
    public void setValortot(Double valortot) {
        this.valortot = valortot;
    }

    /**
     * @return the datavalid
     */
    public Date getDatavalid() {
        return datavalid;
    }

    /**
     * @param datavalid the datavalid to set
     */
    public void setDatavalid(Date datavalid) {
        this.datavalid = datavalid;
    }

    /**
     * @return the dtparaent
     */
    public Date getDtparaent() {
        return dtparaent;
    }

    /**
     * @param dtparaent the dtparaent to set
     */
    public void setDtparaent(Date dtparaent) {
        this.dtparaent = dtparaent;
    }

    /**
     * @return the totalipi
     */
    public Double getTotalipi() {
        return totalipi;
    }

    /**
     * @param totalipi the totalipi to set
     */
    public void setTotalipi(Double totalipi) {
        this.totalipi = totalipi;
    }

    /**
     * @return the numpedcli
     */
    public String getNumpedcli() {
        return numpedcli;
    }

    /**
     * @param numpedcli the numpedcli to set
     */
    public void setNumpedcli(String numpedcli) {
        this.numpedcli = numpedcli;
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
     * @return the qtditens
     */
    public Integer getQtditens() {
        return qtditens;
    }

    /**
     * @param qtditens the qtditens to set
     */
    public void setQtditens(Integer qtditens) {
        this.qtditens = qtditens;
    }

    /**
     * @return the opcodigo
     */
    public Integer getOpcodigo() {
        return opcodigo;
    }

    /**
     * @param opcodigo the opcodigo to set
     */
    public void setOpcodigo(Integer opcodigo) {
        this.opcodigo = opcodigo;
    }

    /**
     * @return the observa1
     */
    public String getObserva1() {
        return observa1;
    }

    /**
     * @param observa1 the observa1 to set
     */
    public void setObserva1(String observa1) {
        this.observa1 = observa1;
    }

    /**
     * @return the observa2
     */
    public String getObserva2() {
        return observa2;
    }

    /**
     * @param observa2 the observa2 to set
     */
    public void setObserva2(String observa2) {
        this.observa2 = observa2;
    }

    /**
     * @return the observa3
     */
    public String getObserva3() {
        return observa3;
    }

    /**
     * @param observa3 the observa3 to set
     */
    public void setObserva3(String observa3) {
        this.observa3 = observa3;
    }

    /**
     * @return the observa4
     */
    public String getObserva4() {
        return observa4;
    }

    /**
     * @param observa4 the observa4 to set
     */
    public void setObserva4(String observa4) {
        this.observa4 = observa4;
    }

    /**
     * @return the observa5
     */
    public String getObserva5() {
        return observa5;
    }

    /**
     * @param observa5 the observa5 to set
     */
    public void setObserva5(String observa5) {
        this.observa5 = observa5;
    }

    /**
     * @return the totfrete
     */
    public Double getTotfrete() {
        return totfrete;
    }

    /**
     * @param totfrete the totfrete to set
     */
    public void setTotfrete(Double totfrete) {
        this.totfrete = totfrete;
    }

    /**
     * @return the toticms
     */
    public Double getToticms() {
        return toticms;
    }

    /**
     * @param toticms the toticms to set
     */
    public void setToticms(Double toticms) {
        this.toticms = toticms;
    }

    /**
     * @return the prazo
     */
    public String getPrazo() {
        return prazo;
    }

    /**
     * @param prazo the prazo to set
     */
    public void setPrazo(String prazo) {
        this.prazo = prazo;
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
     * @return the numeroccf
     */
    public Integer getNumeroccf() {
        return numeroccf;
    }

    /**
     * @param numeroccf the numeroccf to set
     */
    public void setNumeroccf(Integer numeroccf) {
        this.numeroccf = numeroccf;
    }

    /**
     * @return the mdcodigo
     */
    public Integer getMdcodigo() {
        return mdcodigo;
    }

    /**
     * @param mdcodigo the mdcodigo to set
     */
    public void setMdcodigo(Integer mdcodigo) {
        this.mdcodigo = mdcodigo;
    }

    /**
     * @return the mccodigo
     */
    public Integer getMccodigo() {
        return mccodigo;
    }

    /**
     * @param mccodigo the mccodigo to set
     */
    public void setMccodigo(Integer mccodigo) {
        this.mccodigo = mccodigo;
    }

    /**
     * @return the ano
     */
    public String getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(String ano) {
        this.ano = ano;
    }

    /**
     * @return the dataapro
     */
    public Date getDataapro() {
        return dataapro;
    }

    /**
     * @param dataapro the dataapro to set
     */
    public void setDataapro(Date dataapro) {
        this.dataapro = dataapro;
    }

    /**
     * @return the fuaprova
     */
    public Integer getFuaprova() {
        return fuaprova;
    }

    /**
     * @param fuaprova the fuaprova to set
     */
    public void setFuaprova(Integer fuaprova) {
        this.fuaprova = fuaprova;
    }

    /**
     * @return the dataconf
     */
    public Date getDataconf() {
        return dataconf;
    }

    /**
     * @param dataconf the dataconf to set
     */
    public void setDataconf(Date dataconf) {
        this.dataconf = dataconf;
    }

    /**
     * @return the fuconfer
     */
    public Integer getFuconfer() {
        return fuconfer;
    }

    /**
     * @param fuconfer the fuconfer to set
     */
    public void setFuconfer(Integer fuconfer) {
        this.fuconfer = fuconfer;
    }

    /**
     * @return the serie
     */
    public String getSerie() {
        return serie;
    }

    /**
     * @param serie the serie to set
     */
    public void setSerie(String serie) {
        this.serie = serie;
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
     * @return the numplaca
     */
    public String getNumplaca() {
        return numplaca;
    }

    /**
     * @param numplaca the numplaca to set
     */
    public void setNumplaca(String numplaca) {
        this.numplaca = numplaca;
    }

    /**
     * @return the numrenavam
     */
    public String getNumrenavam() {
        return numrenavam;
    }

    /**
     * @param numrenavam the numrenavam to set
     */
    public void setNumrenavam(String numrenavam) {
        this.numrenavam = numrenavam;
    }

    /**
     * @return the orcodpai
     */
    public Integer getOrcodpai() {
        return orcodpai;
    }

    /**
     * @param orcodpai the orcodpai to set
     */
    public void setOrcodpai(Integer orcodpai) {
        this.orcodpai = orcodpai;
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

    /**
     * @return the cvcodigo
     */
    public Integer getCvcodigo() {
        return cvcodigo;
    }

    /**
     * @param cvcodigo the cvcodigo to set
     */
    public void setCvcodigo(Integer cvcodigo) {
        this.cvcodigo = cvcodigo;
    }

    /**
     * @return the obscli
     */
    public Blob getObscli() {
        return obscli;
    }

    /**
     * @param obscli the obscli to set
     */
    public void setObscli(Blob obscli) {
        this.obscli = obscli;
    }

}
