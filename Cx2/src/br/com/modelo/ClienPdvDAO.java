/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo;

import br.com.banco.Conectar;
import br.com.visual.Loggin;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author raul
 */
public class ClienPdvDAO {

    Connection conn = null;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;
    ClienPdvBean registro;
    Conectar conectar = new Conectar();

    public void alerar(Connection pConn, ClienPdvBean clienPdvBean) throws SQLException, ClassNotFoundException, IOException, Exception {

        //baixa de estoque
        try {
            String consultaSQL = "update ClienPdv set "
                    + " VLRDEBITO = ? "
                    + " where SITUACAO = 'A' and CLCODIGO = ? ";

            pstm = pConn.prepareStatement(consultaSQL);
            pstm.setDouble(1, clienPdvBean.getVlrdebito());
            pstm.setInt(2, clienPdvBean.getClcodigo());
            pstm.executeUpdate();

        } finally {

            //System.out.println("Closing database resources and rolling back any changes we made to the database.");
            //Now that we're all finished, let's release database resources.
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (pConn != null) {
                    pConn.rollback();
                }
                if (pConn != null && !conn.isClosed()) {
                    pConn.close();
                }
        } catch (Exception ex) {
            Loggin.logDiarioExcecao(ex, true);
            }
        }
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public ClienPdvBean clienPdvClcodigo(int clcodigo) throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = null;
        String consultaSQL = "select * from ClienPdv "
                + " where SITUACAO = 'A' and CLCODIGO = ? ";

        try {

            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setInt(1, clcodigo);
            rs = pstm.executeQuery();

            while (rs.next()) {
                gravarNoRegistro();
                break;
            }

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    //conn.rollback();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
        } catch (Exception ex) {
            Loggin.logDiarioExcecao(ex, true);
            }
        }
        return registro;
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public Double clienTotalVencido(int clcodigo, java.util.Date dataReferencia) throws SQLException, ClassNotFoundException, IOException, Exception {
        //a vencidos
        registro = null;
        Double valor = 0.0;
        String consultaSQL
                = " select sum(valor) as valor, sum(MULTA) as multa, sum(JUROS) as juros, sum(DESCONTO) as desconto from LANCAMEN "
                + " where TIPO = 'C' "
                + " and CLCODIGO = ? "
                + " and DATAVENC < ? "
                + " and DATAQUIT is null";

        try {

            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setInt(1, clcodigo);
            pstm.setDate(2, new java.sql.Date(dataReferencia.getTime()));
            rs = pstm.executeQuery();

            while (rs.next()) {
                valor = rs.getDouble("valor");
                break;
            }

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    //conn.rollback();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
        } catch (Exception ex) {
            Loggin.logDiarioExcecao(ex, true);
            }
        }
        return valor;
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public Double clienTotalAvencer(int clcodigo, java.util.Date dataReferencia) throws SQLException, ClassNotFoundException, IOException, Exception {
        //a vencer
        registro = null;
        Double valor = 0.0;
        String consultaSQL
                = " select sum(valor) as valor, sum(MULTA) as multa, sum(JUROS) as juros, sum(DESCONTO) as desconto from LANCAMEN "
                + " where TIPO = 'C' "
                + " and CLCODIGO = ? "
                + " and DATAVENC >= ? "
                + " and DATAQUIT is null";

        try {

            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setInt(1, clcodigo);
            pstm.setDate(2, new java.sql.Date(dataReferencia.getTime()));
            rs = pstm.executeQuery();

            while (rs.next()) {
                valor = rs.getDouble("valor");
                break;
            }

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    //conn.rollback();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
        } catch (Exception ex) {
            Loggin.logDiarioExcecao(ex, true);
            }
        }
        return valor;
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public Double clienTotalApagar(int clcodigo) throws SQLException, ClassNotFoundException, IOException, Exception {

        //a pagar
        registro = null;
        Double valor = 0.0;
        String consultaSQL;
        try {
            consultaSQL
                    = " select sum(valor) as valor, sum(MULTA) as multa, sum(JUROS) as juros, sum(DESCONTO) as desconto from LANCAMEN "
                    + " where TIPO = 'C' "
                    + " and CLCODIGO = ? "
                    //+ " and DATAVENC >= ? "
                    + " and DATAQUIT is null";
            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setInt(1, clcodigo);
            rs = pstm.executeQuery();

            while (rs.next()) {
                valor = rs.getDouble("valor")
                        + rs.getDouble("multa")
                        + rs.getDouble("juros")
                        - rs.getDouble("desconto");
                break;
            }

            //debitos----------------------------
            consultaSQL
                    = " select sum(valor) as valor, sum(MULTA) as multa, sum(JUROS) as juros, sum(DESCONTO) as desconto from LANCAMEN "
                    + " where TIPO = 'D' "
                    + " and CLCODIGO = ? "
                    //+ " and DATAVENC >= ? "
                    + " and DATAQUIT is null";
            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setInt(1, clcodigo);
            rs = pstm.executeQuery();

            while (rs.next()) {
                valor = valor - (rs.getDouble("valor")
                        + rs.getDouble("multa")
                        + rs.getDouble("juros")
                        - rs.getDouble("desconto"));
                break;
            }
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    //conn.rollback();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
        } catch (Exception ex) {
            Loggin.logDiarioExcecao(ex, true);
            }
        }
        return valor;
    }

    //-------------------------------------------------------------------------------------------------------------------------
    public List<ClienPdvBean> listarClienPdvNome(String nome) throws SQLException, ClassNotFoundException, IOException, Exception {

        List<ClienPdvBean> listaClienPdvBean = new ArrayList<ClienPdvBean>();
        String consultaSQL = "select * from ClienPdv where SITUACAO = 'A' and upper(NOME) like ? order by NOME";

        try {

            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setString(1, nome.toUpperCase());
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                gravarNoRegistro();
                listaClienPdvBean.add(registro);
            }

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    //conn.rollback();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
        } catch (Exception ex) {
            Loggin.logDiarioExcecao(ex, true);
            }
        }
        return listaClienPdvBean;
    }

    //-------------------------------------------------------------------------------------------------------------------------
    public List<ClienPdvBean> listarClienPdvFantasia(String fantasia) throws SQLException, ClassNotFoundException, IOException, Exception {

        List<ClienPdvBean> listaClienPdvBean = new ArrayList<ClienPdvBean>();
        String consultaSQL = "select * from ClienPdv where SITUACAO = 'A' and upper(FANTASIA) like ? order by NOME";

        try {

            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setString(1, fantasia.toUpperCase().toUpperCase());
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                gravarNoRegistro();
                listaClienPdvBean.add(registro);
            }

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    //conn.rollback();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
        } catch (Exception ex) {
            Loggin.logDiarioExcecao(ex, true);
            }
        }
        return listaClienPdvBean;
    }

    //-------------------------------------------------------------------------------------------------------------------------
    public List<ClienPdvBean> listarClienPdvCpf(String cpf) throws SQLException, ClassNotFoundException, IOException, Exception {

        List<ClienPdvBean> listaClienPdvBean = new ArrayList<ClienPdvBean>();
        String consultaSQL = "select * from ClienPdv where SITUACAO = 'A' and CPF = ? order by NOME";

        try {

            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setString(1, cpf);
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                gravarNoRegistro();
                listaClienPdvBean.add(registro);
            }

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    //conn.rollback();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
        } catch (Exception ex) {
            Loggin.logDiarioExcecao(ex, true);
            }
        }
        return listaClienPdvBean;
    }

    //-------------------------------------------------------------------------------------------------------------------------
    public List<ClienPdvBean> listarClienPdvCgc(String cgc) throws SQLException, ClassNotFoundException, IOException, Exception {

        List<ClienPdvBean> listaClienPdvBean = new ArrayList<ClienPdvBean>();
        String consultaSQL = "select * from ClienPdv where SITUACAO = 'A' and CGC = ? order by NOME";

        try {

            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setString(1, cgc);
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                gravarNoRegistro();
                listaClienPdvBean.add(registro);
            }

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    //conn.rollback();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
        } catch (Exception ex) {
            Loggin.logDiarioExcecao(ex, true);
            }
        }
        return listaClienPdvBean;
    }

    //-------------------------------------------------------------------------------------------
    void gravarNoRegistro() throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = new ClienPdvBean();
        registro.setClcodigo(rs.getInt("CLCODIGO"));
        registro.setTipo(rs.getString("TIPO"));
        registro.setNome(rs.getString("NOME"));
        registro.setFantasia(rs.getString("FANTASIA"));
        registro.setSituacao(rs.getString("SITUACAO"));
        registro.setVip(rs.getString("VIP"));
        registro.setEndereco(rs.getString("ENDERECO"));
        registro.setBairro(rs.getString("BAIRRO"));
        registro.setCicodigo(rs.getInt("CICODIGO"));
        registro.setUf(rs.getString("UF"));
        registro.setCep(rs.getString("CEP"));
        registro.setCoendere(rs.getString("COENDERE"));
        registro.setCobairro(rs.getString("COBAIRRO"));
        registro.setCocicodigo(rs.getInt("COCICODIGO"));
        registro.setCouf(rs.getString("COUF"));
        registro.setCocep(rs.getString("COCEP"));
        registro.setTelefone(rs.getString("TELEFONE"));
        registro.setContato(rs.getString("CONTATO"));
        registro.setFax(rs.getString("FAX"));
        registro.setCaixapos(rs.getString("CAIXAPOS"));
        registro.setWeb(rs.getString("WEB"));
        registro.setEmail(rs.getString("EMAIL"));
        registro.setEmailpedido(rs.getString("EMAILPEDIDO"));
        registro.setCgc(rs.getString("CGC"));
        registro.setCpf(rs.getString("CPF"));
        registro.setInscrica(rs.getString("INSCRICA"));
        registro.setIdentida(rs.getString("IDENTIDA"));
        registro.setRacodigo(rs.getInt("RACODIGO"));
        registro.setObs(rs.getString("OBS"));
        registro.setFucodigo(rs.getInt("FUCODIGO"));
        registro.setEmcodigo(rs.getInt("EMCODIGO"));
        //registro.setDatanasc(rs.getDate("DATANASC"));
        registro.setFicodigo(rs.getInt("FICODIGO"));
        registro.setMkcodigo(rs.getInt("MKCODIGO"));
        registro.setEndenvrec(rs.getString("ENDENVREC"));
        registro.setBaienvrec(rs.getString("BAIENVREC"));
        registro.setCienvrec(rs.getInt("CIENVREC"));
        registro.setUfenvrec(rs.getString("UFENVREC"));
        registro.setCepenvrec(rs.getString("CEPENVREC"));
        registro.setEmpresa(rs.getString("EMPRESA"));
        registro.setBanco(rs.getString("BANCO"));
        registro.setComentariov(rs.getString("COMENTARIOV"));
        registro.setValorMaxv(rs.getDouble("VALOR_MAXV"));
        registro.setValorMinv(rs.getDouble("VALOR_MINV"));
        registro.setAnov(rs.getInt("ANOV"));
        registro.setAno(rs.getInt("ANO"));
        registro.setMvcodigov(rs.getInt("MVCODIGOV"));
        registro.setMrcodigov(rs.getInt("MRCODIGOV"));
        registro.setFoneCom(rs.getString("FONE_COM"));
        registro.setFoneCel(rs.getString("FONE_CEL"));
        registro.setSexo(rs.getString("SEXO"));
        registro.setCargo(rs.getString("CARGO"));
        registro.setProfissao(rs.getString("PROFISSAO"));
        registro.setLimitecre(rs.getDouble("LIMITECRE"));
        registro.setLimitesec(rs.getDouble("LIMITESEC"));
        registro.setVlrdebito(rs.getDouble("VLRDEBITO"));
        registro.setCadlocal(rs.getString("CADLOCAL"));
        registro.setCodintern(rs.getString("CODINTERN"));
        registro.setDesfolha(rs.getString("DESFOLHA"));
        registro.setClcodpai(rs.getInt("CLCODPAI"));
        registro.setDataalte(rs.getDate("DATAALTE"));
        //registro.setDatacada(rs.getDate("DATACADA"));
        registro.setReferencia(rs.getString("REFERENCIA"));
        registro.setSenha(rs.getString("SENHA"));
        registro.setPathfoto(rs.getString("PATHFOTO"));
        registro.setApcicms(rs.getString("APCICMS"));
        registro.setCompraatacado(rs.getString("COMPRAATACADO"));
        registro.setOrgexpiden(rs.getString("ORGEXPIDEN"));
        registro.setUfemiiden(rs.getString("UFEMIIDEN"));
        registro.setProdcodigo(rs.getString("PRODCODIGO"));
        registro.setNomepai(rs.getString("NOMEPAI"));
        registro.setNomemae(rs.getString("NOMEMAE"));
        registro.setDiafixpagamento(rs.getInt("DIAFIXPAGAMENTO"));
        registro.setAdiantamento(rs.getDouble("ADIANTAMENTO"));
        registro.setFlagtrans(rs.getString("FLAGTRANS"));
        registro.setObsexib(rs.getString("OBSEXIB"));
        registro.setCodibge(rs.getString("CODIBGE"));
        registro.setCodcontab(rs.getString("CODCONTAB"));
        registro.setTpenderecocom(rs.getInt("TPENDERECOCOM"));
        registro.setTpenderecocobr(rs.getInt("TPENDERECOCOBR"));
        registro.setTpenderecorec(rs.getInt("TPENDERECOREC"));
        registro.setComplementocom(rs.getString("COMPLEMENTOCOM"));
        registro.setComplementocobr(rs.getString("COMPLEMENTOCOBR"));
        registro.setComplementorec(rs.getString("COMPLEMENTOREC"));
        registro.setNumerocom(rs.getInt("NUMEROCOM"));
        registro.setNumerocobr(rs.getInt("NUMEROCOBR"));
        registro.setNumerorec(rs.getInt("NUMEROREC"));
        registro.setInscmun(rs.getString("INSCMUN"));
        registro.setDedupis(rs.getString("DEDUPIS"));
        registro.setDeducofins(rs.getString("DEDUCOFINS"));
        registro.setDeducsll(rs.getString("DEDUCSLL"));
        registro.setDeduinss(rs.getString("DEDUINSS"));
        registro.setDeduissqn(rs.getString("DEDUISSQN"));
        registro.setHistCli(rs.getString("HIST_CLI"));
        registro.setSuframa(rs.getString("SUFRAMA"));
        registro.setNomedep(rs.getString("NOMEDEP"));
        registro.setCpfdepen(rs.getString("CPFDEPEN"));
        registro.setDocdepen(rs.getString("DOCDEPEN"));
        registro.setNomedep2(rs.getString("NOMEDEP2"));
        registro.setCpfdepen2(rs.getString("CPFDEPEN2"));
        registro.setDocdepen2(rs.getString("DOCDEPEN2"));
        registro.setNomedep3(rs.getString("NOMEDEP3"));
        registro.setCpfdepen3(rs.getString("CPFDEPEN3"));
        registro.setDocdepen3(rs.getString("DOCDEPEN3"));
        registro.setAliqcsll(rs.getDouble("ALIQCSLL"));
        registro.setAliqinss(rs.getDouble("ALIQINSS"));
        registro.setAliqirrf(rs.getDouble("ALIQIRRF"));
    }
}
