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
import java.util.Date;
import java.util.List;

/**
 *
 * @author Raul
 */
public class OrcamentDAO {

    private Connection conn = null;
    private Statement stm;
    private PreparedStatement pstm;
    private ResultSet rs;
    private OrcamentBean registro;
    private final Conectar conectar = new Conectar();
    private final IteOrcamDAO iteOrcamDAO = new IteOrcamDAO();

    public void fecharOrcamento(OrcamentBean o, List<IteOrcamBean> listaItem) throws SQLException, ClassNotFoundException, IOException, Exception {

        try {

            conn = conectar.conectar();
            conn.setAutoCommit(false);
            //******************************************************
            //cabecalho
            //******************************************************
            inserir(conn, o);
            //itens do orcamento
            iteOrcamDAO.inserir(conn, listaItem);

            conn.commit();
            conn.setAutoCommit(true);

        } catch (Exception ex) {
            Loggin.logDiarioExcecao(ex, true);

        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (Exception ex) {
                Loggin.logDiarioExcecao(ex, true);
            }

        }

    }

    public void inserir(Connection pConn, OrcamentBean orcamentBean) throws SQLException, ClassNotFoundException, IOException, Exception {

        //baixa de estoque
        String consultaSQL = "insert into orcament ("
                + " ORCODIGO, "
                + " DATA, "
                + " FUCODIGO, "
                + " CLCODIGO, "
                + " TIPO, "
                + " NOME, "
                + " CNPJ, "
                + " CPF, "
                + " ENDERECO, "
                + " BAIRRO, "
                + " CICODIGO, "
                + " CEP, "
                + " UF, "
                + " TELEFONE, "
                + " CUIDADOS, "
                + " FPCODIGO, "
                + " TIPOPRECO, "
                + " DESCONTO, "
                + " ACRESCIMO, "
                + " VALORTOT, "
                + " DATAVALID, "
                + " DTPARAENT, "
                + " TOTALIPI, "
                + " NUMPEDCLI, "
                + " SITUACAO, "
                + " QTDITENS, "
                + " OPCODIGO, "
                + " OBSERVA1, "
                + " OBSERVA2, "
                + " OBSERVA3, "
                + " OBSERVA4, "
                + " OBSERVA5, "
                + " TOTFRETE, "
                + " TOTICMS, "
                + " PRAZO, "
                + " CACODIGO, "
                + " VDCODIGO, "
                + " NUMEROCOO, "
                + " NUMEROCCF, "
                + " MDCODIGO, "
                + " MCCODIGO, "
                + " ANO, "
                + " DATAAPRO, "
                + " FUAPROVA, "
                + " DATACONF, "
                + " FUCONFER, "
                + " SERIE, "
                + " FLAGTRANS, "
                + " NUMPLACA, "
                + " NUMRENAVAM, "
                + " ORCODPAI, "
                + " OBSCLI, "
                + " DAV, "
                + " MODELONF, "
                + " SERIENF, "
                + " SUBSERIENF, "
                + " NUMERONF, "
                + " CVCODIGO "
                + ") values ("
                + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                + "?, ?, ?, ?, ?, ?, ?, ? )";

        pstm = pConn.prepareStatement(consultaSQL);
        pstm.setInt(1, orcamentBean.getOrcodigo());
        pstm.setDate(2, new java.sql.Date(orcamentBean.getData().getTime()));
        pstm.setInt(3, orcamentBean.getFucodigo());
        pstm.setInt(4, orcamentBean.getClcodigo());
        pstm.setString(5, orcamentBean.getTipo());
        pstm.setString(6, orcamentBean.getNome());
        pstm.setString(7, orcamentBean.getCnpj());
        pstm.setString(8, orcamentBean.getCpf());
        pstm.setString(9, orcamentBean.getEndereco());
        pstm.setString(10, orcamentBean.getBairro());
        pstm.setInt(11, orcamentBean.getCicodigo());
        pstm.setString(12, orcamentBean.getCep());
        pstm.setString(13, orcamentBean.getUf());
        pstm.setString(14, orcamentBean.getTelefone());
        pstm.setString(15, orcamentBean.getCuidados());
        pstm.setString(16, orcamentBean.getFpcodigo());
        pstm.setString(17, orcamentBean.getTipopreco());
        pstm.setDouble(18, orcamentBean.getDesconto());
        pstm.setDouble(19, orcamentBean.getAcrescimo());
        pstm.setDouble(20, orcamentBean.getValortot());

        if (orcamentBean.getDatavalid() != null) {
            pstm.setDate(21, new java.sql.Date(orcamentBean.getDatavalid().getTime()));
        } else {
            pstm.setNull(21, java.sql.Types.DATE);
        }

        if (orcamentBean.getDtparaent() != null) {
            pstm.setDate(22, new java.sql.Date(orcamentBean.getDtparaent().getTime()));
        } else {
            pstm.setNull(22, java.sql.Types.DATE);
        }

        pstm.setDouble(23, orcamentBean.getTotalipi());
        pstm.setString(24, orcamentBean.getNumpedcli());
        pstm.setString(25, orcamentBean.getSituacao());
        pstm.setInt(26, orcamentBean.getQtditens());
        pstm.setInt(27, orcamentBean.getOpcodigo());
        pstm.setString(28, orcamentBean.getObserva1());
        pstm.setString(29, orcamentBean.getObserva2());
        pstm.setString(30, orcamentBean.getObserva3());
        pstm.setString(31, orcamentBean.getObserva4());
        pstm.setString(32, orcamentBean.getObserva5());
        pstm.setDouble(33, orcamentBean.getTotfrete());
        pstm.setDouble(34, orcamentBean.getToticms());
        pstm.setString(35, orcamentBean.getPrazo());
        pstm.setString(36, orcamentBean.getCacodigo());
        pstm.setInt(37, orcamentBean.getVdcodigo());
        pstm.setInt(38, orcamentBean.getNumerocoo());
        pstm.setInt(39, orcamentBean.getNumeroccf());
        pstm.setInt(40, orcamentBean.getMdcodigo());
        pstm.setInt(41, orcamentBean.getMccodigo());
        pstm.setString(42, orcamentBean.getAno());

        if (orcamentBean.getDataapro() != null) {
            pstm.setDate(43, new java.sql.Date(orcamentBean.getDataapro().getTime()));
        } else {
            pstm.setNull(43, java.sql.Types.DATE);
        }

        pstm.setInt(44, orcamentBean.getFuaprova());

        if (orcamentBean.getDataconf() != null) {
            pstm.setDate(45, new java.sql.Date(orcamentBean.getDataconf().getTime()));
        } else {
            pstm.setNull(45, java.sql.Types.DATE);
        }

        pstm.setInt(46, orcamentBean.getFuconfer());
        pstm.setString(47, orcamentBean.getSerie());
        pstm.setString(48, orcamentBean.getFlagtrans());
        pstm.setString(49, orcamentBean.getNumplaca());
        pstm.setString(50, orcamentBean.getNumrenavam());
        pstm.setInt(51, orcamentBean.getOrcodpai());

        if (orcamentBean.getObscli() != null) {
            pstm.setBlob(52, orcamentBean.getObscli());
        } else {
            pstm.setNull(52, java.sql.Types.BLOB);
        }

        pstm.setInt(53, orcamentBean.getDav());
        pstm.setString(54, orcamentBean.getModelonf());
        pstm.setString(55, orcamentBean.getSerienf());
        pstm.setString(56, orcamentBean.getSubserienf());
        pstm.setInt(57, orcamentBean.getNumeronf());
        pstm.setInt(58, orcamentBean.getCvcodigo());
        pstm.executeUpdate();

    }

    //----------------------------------------------------------------------------------------------------------------------------
    public OrcamentBean Orcament(int orcodigo) throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = null;
        String consultaSQL = "select * from Orcament where ORCODIGO = ?";

        try {

            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setInt(1, orcodigo);
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

    //--------------------------------------------------------------------------------------------------------------
    public List<OrcamentBean> listarOrcament() throws SQLException, ClassNotFoundException, IOException, Exception {

        List<OrcamentBean> listaOrcamentBean = new ArrayList<OrcamentBean>();
        String consultaSQL = "select * from Orcament order by ORCODIGO";

        try {
            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                gravarNoRegistro();
                listaOrcamentBean.add(registro);
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
        return listaOrcamentBean;
    }

    //--------------------------------------------------------------------------------------------------------------
    public List<OrcamentBean> listarOrcament(Date periodoInicial, Date periodoFinal) throws SQLException, ClassNotFoundException, IOException, Exception {

        List<OrcamentBean> listaOrcamentBean = new ArrayList<OrcamentBean>();;
        String consultaSQL = "select * from Orcament "
                + " where DATA Between ? and ? "
                + " order by DATA ";

        try {
            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setDate(1, new java.sql.Date(periodoInicial.getTime()));
            pstm.setDate(2, new java.sql.Date(periodoFinal.getTime()));
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                gravarNoRegistro();
                listaOrcamentBean.add(registro);
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
        return listaOrcamentBean;
    }

    //--------------------------------------------------------------------------------------------------------------
    public List<OrcamentBean> listarOrcament(String nome) throws SQLException, ClassNotFoundException, IOException, Exception {

        List<OrcamentBean> listaOrcamentBean = new ArrayList<OrcamentBean>();
        String consultaSQL = "select * from Orcament "
                + " where upper(NOME) like ? "
                + " order by NOME ";

        try {
            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setString(1, nome.toUpperCase());
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                gravarNoRegistro();
                listaOrcamentBean.add(registro);
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
        return listaOrcamentBean;
    }

    //--------------------------------------------------------------------------------------------------------------
    public List<OrcamentBean> listarOrcament(Date periodoInicial, Date periodoFinal, String nome) throws SQLException, ClassNotFoundException, IOException, Exception {

        List<OrcamentBean> listaOrcamentBean = new ArrayList<OrcamentBean>();
        String consultaSQL = "select * from Orcament "
                + " where DATA Between ? and ? "
                + " and upper(NOME) like ? "
                + " order by NOME ";

        try {
            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setDate(1, new java.sql.Date(periodoInicial.getTime()));
            pstm.setDate(2, new java.sql.Date(periodoFinal.getTime()));
            pstm.setString(3, nome.toUpperCase());
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                gravarNoRegistro();
                listaOrcamentBean.add(registro);
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
        return listaOrcamentBean;
    }

    //--------------------------------------------------------------------------------------------------------------
    public List<OrcamentBean> listarOrcamentoCpf(String cpf) throws SQLException, ClassNotFoundException, IOException, Exception {

        List<OrcamentBean> listaOrcamentBean = new ArrayList<OrcamentBean>();
        String consultaSQL = "select * from Orcament "
                + " where CPF = ? "
                + " order by DATA ";

        try {
            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setString(1, cpf);
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                gravarNoRegistro();
                listaOrcamentBean.add(registro);
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
        return listaOrcamentBean;
    }

    //--------------------------------------------------------------------------------------------------------------
    public List<OrcamentBean> listarOrcamentoCpf(Date periodoInicial, Date periodoFinal, String cpf) throws SQLException, ClassNotFoundException, IOException, Exception {

        List<OrcamentBean> listaOrcamentBean = new ArrayList<OrcamentBean>();
        String consultaSQL = "select * from Orcament "
                + " where DATA Between ? and ? "
                + " and CPF = ? "
                + " order by DATA ";

        try {
            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setDate(1, new java.sql.Date(periodoInicial.getTime()));
            pstm.setDate(2, new java.sql.Date(periodoFinal.getTime()));
            pstm.setString(3, cpf);
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                gravarNoRegistro();
                listaOrcamentBean.add(registro);
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
        return listaOrcamentBean;
    }

    //--------------------------------------------------------------------------------------------------------------
    public List<OrcamentBean> listarOrcamentoCgc(String cgc) throws SQLException, ClassNotFoundException, IOException, Exception {

        List<OrcamentBean> listaOrcamentBean = new ArrayList<OrcamentBean>();
        String consultaSQL = "select * from Orcament "
                + " where CNPJ = ? "
                + " order by DATA ";

        try {
            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setString(1, cgc);
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                gravarNoRegistro();
                listaOrcamentBean.add(registro);
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
        return listaOrcamentBean;
    }

    //--------------------------------------------------------------------------------------------------------------
    public List<OrcamentBean> listarOrcamentoCgc(Date periodoInicial, Date periodoFinal, String cgc) throws SQLException, ClassNotFoundException, IOException, Exception {

        List<OrcamentBean> listaOrcamentBean = new ArrayList<OrcamentBean>();
        String consultaSQL = "select * from Orcament "
                + " where DATA Between ? and ? "
                + " and CNPJ = ? "
                + " order by DATA ";

        try {
            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setDate(1, new java.sql.Date(periodoInicial.getTime()));
            pstm.setDate(2, new java.sql.Date(periodoFinal.getTime()));
            pstm.setString(3, cgc);
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                gravarNoRegistro();
                listaOrcamentBean.add(registro);
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
        return listaOrcamentBean;
    }

    //---------------------------------------------------------------------------------------------------
    private void gravarNoRegistro() throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = new OrcamentBean();
        registro.setOrcodigo(rs.getInt("ORCODIGO"));
        registro.setData(rs.getDate("DATA"));
        registro.setFucodigo(rs.getInt("FUCODIGO"));
        registro.setClcodigo(rs.getInt("CLCODIGO"));
        registro.setTipo(rs.getString("TIPO"));
        registro.setNome(rs.getString("NOME"));
        registro.setCnpj(rs.getString("CNPJ"));
        registro.setCpf(rs.getString("CPF"));
        registro.setEndereco(rs.getString("ENDERECO"));
        registro.setBairro(rs.getString("BAIRRO"));
        registro.setCicodigo(rs.getInt("CICODIGO"));
        registro.setCep(rs.getString("CEP"));
        registro.setUf(rs.getString("UF"));
        registro.setTelefone(rs.getString("TELEFONE"));
        registro.setCuidados(rs.getString("CUIDADOS"));
        registro.setFpcodigo(rs.getString("FPCODIGO"));
        registro.setTipopreco(rs.getString("TIPOPRECO"));
        registro.setDesconto(rs.getDouble("DESCONTO"));
        registro.setAcrescimo(rs.getDouble("ACRESCIMO"));
        registro.setValortot(rs.getDouble("VALORTOT"));
        registro.setDatavalid(rs.getDate("DATAVALID"));
        registro.setDtparaent(rs.getDate("DTPARAENT"));
        registro.setTotalipi(rs.getDouble("TOTALIPI"));
        registro.setNumpedcli(rs.getString("NUMPEDCLI"));
        registro.setSituacao(rs.getString("SITUACAO"));
        registro.setQtditens(rs.getInt("QTDITENS"));
        registro.setOpcodigo(rs.getInt("OPCODIGO"));
        registro.setObserva1(rs.getString("OBSERVA1"));
        registro.setObserva2(rs.getString("OBSERVA2"));
        registro.setObserva3(rs.getString("OBSERVA3"));
        registro.setObserva4(rs.getString("OBSERVA4"));
        registro.setObserva5(rs.getString("OBSERVA5"));
        registro.setTotfrete(rs.getDouble("TOTFRETE"));
        registro.setToticms(rs.getDouble("TOTICMS"));
        registro.setPrazo(rs.getString("PRAZO"));
        registro.setCacodigo(rs.getString("CACODIGO"));
        registro.setVdcodigo(rs.getInt("VDCODIGO"));
        registro.setNumerocoo(rs.getInt("NUMEROCOO"));
        registro.setNumeroccf(rs.getInt("NUMEROCCF"));
        registro.setMdcodigo(rs.getInt("MDCODIGO"));
        registro.setMccodigo(rs.getInt("MCCODIGO"));
        registro.setAno(rs.getString("ANO"));
        registro.setDataapro(rs.getDate("DATAAPRO"));
        registro.setFuaprova(rs.getInt("FUAPROVA"));
        registro.setDataconf(rs.getDate("DATACONF"));
        registro.setFuconfer(rs.getInt("FUCONFER"));
        registro.setSerie(rs.getString("SERIE"));
        registro.setFlagtrans(rs.getString("FLAGTRANS"));
        registro.setNumplaca(rs.getString("NUMPLACA"));
        registro.setNumrenavam(rs.getString("NUMRENAVAM"));
        registro.setOrcodpai(rs.getInt("ORCODPAI"));
        registro.setObscli(rs.getBlob("OBSCLI"));
        registro.setDav(rs.getInt("DAV"));
        registro.setModelonf(rs.getString("MODELONF"));
        registro.setSerienf(rs.getString("SERIENF"));
        registro.setSubserienf(rs.getString("SUBSERIENF"));
        registro.setNumeronf(rs.getInt("NUMERONF"));
        registro.setCvcodigo(rs.getInt("CVCODIGO"));

    }
}
