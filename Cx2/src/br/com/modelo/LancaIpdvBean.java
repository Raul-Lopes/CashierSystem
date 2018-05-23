/*CACODIGO, DATA, PERIODO, TIPO, VDCODIGO, FPCODIGO, SEQESPEC, SEQUENCIA);
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
public class LancaIpdvBean {

    private String cacodigo;
    private Date data;
    private Integer periodo;
    private String tipo;
    private Integer vdcodigo;
    private Integer fpcodigo;
    private Integer seqespec;
    private Integer sequencia;
    private Date datalanc;
    private Double valor;
    private String situacao;
    private String banco;
    private String conta;
    private String agencia;
    private String numcheque;
    private String telefone;
    private String cgccpf;
    private String flagtrans;
    private String flagtserv;
    private String modelonf;
    private String serienf;
    private String subserienf;
    private Integer numeronf;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.getCacodigo());
        hash = 11 * hash + Objects.hashCode(this.getData());
        hash = 11 * hash + Objects.hashCode(this.getPeriodo());
        hash = 11 * hash + Objects.hashCode(this.getTipo());
        hash = 11 * hash + Objects.hashCode(this.getVdcodigo());
        hash = 11 * hash + Objects.hashCode(this.getFpcodigo());
        hash = 11 * hash + Objects.hashCode(this.getSeqespec());
        hash = 11 * hash + Objects.hashCode(this.getSequencia());
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
        final LancaIpdvBean other = (LancaIpdvBean) obj;
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
        if (!Objects.equals(this.sequencia, other.sequencia)) {
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
     * @return the sequencia
     */
    public Integer getSequencia() {
        return sequencia;
    }

    /**
     * @param sequencia the sequencia to set
     */
    public void setSequencia(Integer sequencia) {
        this.sequencia = sequencia;
    }

    /**
     * @return the datalanc
     */
    public Date getDatalanc() {
        return datalanc;
    }

    /**
     * @param datalanc the datalanc to set
     */
    public void setDatalanc(Date datalanc) {
        this.datalanc = datalanc;
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
     * @return the banco
     */
    public String getBanco() {
        return banco;
    }

    /**
     * @param banco the banco to set
     */
    public void setBanco(String banco) {
        this.banco = banco;
    }

    /**
     * @return the conta
     */
    public String getConta() {
        return conta;
    }

    /**
     * @param conta the conta to set
     */
    public void setConta(String conta) {
        this.conta = conta;
    }

    /**
     * @return the agencia
     */
    public String getAgencia() {
        return agencia;
    }

    /**
     * @param agencia the agencia to set
     */
    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    /**
     * @return the numcheque
     */
    public String getNumcheque() {
        return numcheque;
    }

    /**
     * @param numcheque the numcheque to set
     */
    public void setNumcheque(String numcheque) {
        this.numcheque = numcheque;
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
     * @return the cgccpf
     */
    public String getCgccpf() {
        return cgccpf;
    }

    /**
     * @param cgccpf the cgccpf to set
     */
    public void setCgccpf(String cgccpf) {
        this.cgccpf = cgccpf;
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
