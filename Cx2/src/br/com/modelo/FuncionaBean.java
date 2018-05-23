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
public class FuncionaBean {

    private Integer fucodigo;
    private String nome;
    private String tfcodigo;
    private String cpf;
    private String identida;
    private String carttrab;
    private String endereco;
    private String bairro;
    private Integer cicodigo;
    private String uf;
    private String cep;
    private String telefone;
    private String senha;
    private Double perccomi;
    private Double percomiprz;
    private Date datanasc;
    private Integer ficodigo;
    private Integer emcodigo;
    private String localtra;
    private String codintern;
    private Date dataalte;
    private Integer qhcodigo;
    private Date ultimoac;
    private Integer ultimogiro;
    private String nivelatual;
    private String rptsenha;
    private String porteiro;
    private Integer dpcodigo;
    private String numregistro;
    private Date dataemcart;
    private String seriecart;
    private String horaferia;
    private String extrabfr;
    private Date admissao;
    private String cargo;
    private String pathfoto;
    private String extradef;
    private String permiteagenda;
    private String codfrenti;
    private Integer tpendereco;
    private Integer numero;
    private String complemento;
    private TipoFuncBean tipoFuncBean;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.getFucodigo());
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
        final FuncionaBean other = (FuncionaBean) obj;
        if (!Objects.equals(this.fucodigo, other.fucodigo)) {
            return false;
        }
        return true;
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
     * @return the tfcodigo
     */
    public String getTfcodigo() {
        return tfcodigo;
    }

    /**
     * @param tfcodigo the tfcodigo to set
     */
    public void setTfcodigo(String tfcodigo) {
        this.tfcodigo = tfcodigo;
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
     * @return the identida
     */
    public String getIdentida() {
        return identida;
    }

    /**
     * @param identida the identida to set
     */
    public void setIdentida(String identida) {
        this.identida = identida;
    }

    /**
     * @return the carttrab
     */
    public String getCarttrab() {
        return carttrab;
    }

    /**
     * @param carttrab the carttrab to set
     */
    public void setCarttrab(String carttrab) {
        this.carttrab = carttrab;
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
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the perccomi
     */
    public Double getPerccomi() {
        return perccomi;
    }

    /**
     * @param perccomi the perccomi to set
     */
    public void setPerccomi(Double perccomi) {
        this.perccomi = perccomi;
    }

    /**
     * @return the percomiprz
     */
    public Double getPercomiprz() {
        return percomiprz;
    }

    /**
     * @param percomiprz the percomiprz to set
     */
    public void setPercomiprz(Double percomiprz) {
        this.percomiprz = percomiprz;
    }

    /**
     * @return the datanasc
     */
    public Date getDatanasc() {
        return datanasc;
    }

    /**
     * @param datanasc the datanasc to set
     */
    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
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
     * @return the emcodigo
     */
    public Integer getEmcodigo() {
        return emcodigo;
    }

    /**
     * @param emcodigo the emcodigo to set
     */
    public void setEmcodigo(Integer emcodigo) {
        this.emcodigo = emcodigo;
    }

    /**
     * @return the localtra
     */
    public String getLocaltra() {
        return localtra;
    }

    /**
     * @param localtra the localtra to set
     */
    public void setLocaltra(String localtra) {
        this.localtra = localtra;
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
     * @return the qhcodigo
     */
    public Integer getQhcodigo() {
        return qhcodigo;
    }

    /**
     * @param qhcodigo the qhcodigo to set
     */
    public void setQhcodigo(Integer qhcodigo) {
        this.qhcodigo = qhcodigo;
    }

    /**
     * @return the ultimoac
     */
    public Date getUltimoac() {
        return ultimoac;
    }

    /**
     * @param ultimoac the ultimoac to set
     */
    public void setUltimoac(Date ultimoac) {
        this.ultimoac = ultimoac;
    }

    /**
     * @return the ultimogiro
     */
    public Integer getUltimogiro() {
        return ultimogiro;
    }

    /**
     * @param ultimogiro the ultimogiro to set
     */
    public void setUltimogiro(Integer ultimogiro) {
        this.ultimogiro = ultimogiro;
    }

    /**
     * @return the nivelatual
     */
    public String getNivelatual() {
        return nivelatual;
    }

    /**
     * @param nivelatual the nivelatual to set
     */
    public void setNivelatual(String nivelatual) {
        this.nivelatual = nivelatual;
    }

    /**
     * @return the rptsenha
     */
    public String getRptsenha() {
        return rptsenha;
    }

    /**
     * @param rptsenha the rptsenha to set
     */
    public void setRptsenha(String rptsenha) {
        this.rptsenha = rptsenha;
    }

    /**
     * @return the porteiro
     */
    public String getPorteiro() {
        return porteiro;
    }

    /**
     * @param porteiro the porteiro to set
     */
    public void setPorteiro(String porteiro) {
        this.porteiro = porteiro;
    }

    /**
     * @return the dpcodigo
     */
    public Integer getDpcodigo() {
        return dpcodigo;
    }

    /**
     * @param dpcodigo the dpcodigo to set
     */
    public void setDpcodigo(Integer dpcodigo) {
        this.dpcodigo = dpcodigo;
    }

    /**
     * @return the numregistro
     */
    public String getNumregistro() {
        return numregistro;
    }

    /**
     * @param numregistro the numregistro to set
     */
    public void setNumregistro(String numregistro) {
        this.numregistro = numregistro;
    }

    /**
     * @return the dataemcart
     */
    public Date getDataemcart() {
        return dataemcart;
    }

    /**
     * @param dataemcart the dataemcart to set
     */
    public void setDataemcart(Date dataemcart) {
        this.dataemcart = dataemcart;
    }

    /**
     * @return the seriecart
     */
    public String getSeriecart() {
        return seriecart;
    }

    /**
     * @param seriecart the seriecart to set
     */
    public void setSeriecart(String seriecart) {
        this.seriecart = seriecart;
    }

    /**
     * @return the horaferia
     */
    public String getHoraferia() {
        return horaferia;
    }

    /**
     * @param horaferia the horaferia to set
     */
    public void setHoraferia(String horaferia) {
        this.horaferia = horaferia;
    }

    /**
     * @return the extrabfr
     */
    public String getExtrabfr() {
        return extrabfr;
    }

    /**
     * @param extrabfr the extrabfr to set
     */
    public void setExtrabfr(String extrabfr) {
        this.extrabfr = extrabfr;
    }

    /**
     * @return the admissao
     */
    public Date getAdmissao() {
        return admissao;
    }

    /**
     * @param admissao the admissao to set
     */
    public void setAdmissao(Date admissao) {
        this.admissao = admissao;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
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
     * @return the extradef
     */
    public String getExtradef() {
        return extradef;
    }

    /**
     * @param extradef the extradef to set
     */
    public void setExtradef(String extradef) {
        this.extradef = extradef;
    }

    /**
     * @return the permiteagenda
     */
    public String getPermiteagenda() {
        return permiteagenda;
    }

    /**
     * @param permiteagenda the permiteagenda to set
     */
    public void setPermiteagenda(String permiteagenda) {
        this.permiteagenda = permiteagenda;
    }

    /**
     * @return the codfrenti
     */
    public String getCodfrenti() {
        return codfrenti;
    }

    /**
     * @param codfrenti the codfrenti to set
     */
    public void setCodfrenti(String codfrenti) {
        this.codfrenti = codfrenti;
    }

    /**
     * @return the tpendereco
     */
    public Integer getTpendereco() {
        return tpendereco;
    }

    /**
     * @param tpendereco the tpendereco to set
     */
    public void setTpendereco(Integer tpendereco) {
        this.tpendereco = tpendereco;
    }

    /**
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the tipoFuncBean
     */
    public TipoFuncBean getTipoFuncBean() {
        return tipoFuncBean;
    }

    /**
     * @param tipoFuncBean the tipoFuncBean to set
     */
    public void setTipoFuncBean(TipoFuncBean tipoFuncBean) {
        this.tipoFuncBean = tipoFuncBean;
    }

}
