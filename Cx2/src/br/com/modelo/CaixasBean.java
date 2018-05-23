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
public class CaixasBean {

    private String cacodigo;
    private String nome;
    private Date data;
    private Integer periodo;
    private Integer fucodigo;
    private String hora;
    private Double saldo;
    private Double fechamento;
    private String leituraz;
    private String pathtxt_r;
    private Integer codecfdes;
    private String setor;
    private Date dataalte;
    private String ecfseque;
    private String ecfserie;
    private String ecfmarca;
    private String ecfmodelo;
    private String ecftipo;
    private String swbversao;
    private Date swbdthrgr;
    private String swbmfadic;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.getCacodigo());
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
        final CaixasBean other = (CaixasBean) obj;
        if (!Objects.equals(this.cacodigo, other.cacodigo)) {
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
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
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
     * @return the fechamento
     */
    public Double getFechamento() {
        return fechamento;
    }

    /**
     * @param fechamento the fechamento to set
     */
    public void setFechamento(Double fechamento) {
        this.fechamento = fechamento;
    }

    /**
     * @return the leituraz
     */
    public String getLeituraz() {
        return leituraz;
    }

    /**
     * @param leituraz the leituraz to set
     */
    public void setLeituraz(String leituraz) {
        this.leituraz = leituraz;
    }

    /**
     * @return the pathtxt_r
     */
    public String getPathtxt_r() {
        return pathtxt_r;
    }

    /**
     * @param pathtxt_r the pathtxt_r to set
     */
    public void setPathtxt_r(String pathtxt_r) {
        this.pathtxt_r = pathtxt_r;
    }

    /**
     * @return the codecfdes
     */
    public Integer getCodecfdes() {
        return codecfdes;
    }

    /**
     * @param codecfdes the codecfdes to set
     */
    public void setCodecfdes(Integer codecfdes) {
        this.codecfdes = codecfdes;
    }

    /**
     * @return the setor
     */
    public String getSetor() {
        return setor;
    }

    /**
     * @param setor the setor to set
     */
    public void setSetor(String setor) {
        this.setor = setor;
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

}
