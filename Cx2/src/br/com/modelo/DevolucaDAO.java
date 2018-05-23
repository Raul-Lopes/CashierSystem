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
import java.util.List;

/**
 *
 * @author raul
 */
public class DevolucaDAO {

    private Connection conn = null;
    private Statement stm;
    private PreparedStatement pstm;
    private ResultSet rs;
    private DevolucaBean registro;
    private final Conectar conectar = new Conectar();
    ItemDevoDAO itemDevoDAO = new ItemDevoDAO();

    public void fecharVendaDevolucao(DevolucaBean o, String retornarEstoque, List<ItemDevoBean> listaItem) throws SQLException, ClassNotFoundException, IOException, Exception {

        try {

            conn = conectar.conectar();
            conn.setAutoCommit(false);
            //******************************************************
            //cabecalho
            //******************************************************
            inserir(conn, o);
            //itens da venda
            itemDevoDAO.inserir(conn, retornarEstoque, listaItem);

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

    public DevolucaBean inserir(Connection pConn, DevolucaBean o) throws SQLException, ClassNotFoundException, IOException, Exception {

        try {
            //baixa de estoque
            String consultaSQL = "insert into DEVOLUCA ( "
                    + " CACODIGO, "
                    + " DVCODIGO, "
                    + " DATA, "
                    + " VALDEVOL, "
                    + " FUCODIGO, "
                    + " PERIODO, "
                    + " HORARIO, "
                    + " HORAINIC, "
                    + " BAIXAESTO, "
                    + " FLAGTRANS, "
                    + " FLAGTSERV, "
                    + " SETORUSO, "
                    + " NUREGESP, "
                    + " NUMEROCOO, "
                    + " NUCOOCTVL, "
                    + " CLCODIGO, "
                    + " TIPO, "
                    + " CGC, "
                    + " CPF, "
                    + " NOME, "
                    + " TELEFONE, "
                    + " FANTASIA, "
                    + " ENDERECO, "
                    + " TPENDERECOCOM, "
                    + " COMPLEMENTOCOM, "
                    + " NUMEROCOM, "
                    + " BAIRRO, "
                    + " CICODIGO, "
                    + " NOMECIDADE, "
                    + " UF, "
                    + " CEP, "
                    + " MODELONF, "
                    + " SERIENF, "
                    + " SUBSERIENF, "
                    + " NUMERONF ) "
                    + " values ("
                    + " ?, ?, ?, ?, ?, "
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

            pstm = pConn.prepareStatement(consultaSQL);
            pstm.setString(1, o.getCacodigo());
            pstm.setInt(2, o.getDvcodigo());
            pstm.setDate(3, new java.sql.Date(o.getData().getTime()));
            pstm.setDouble(4, o.getValdevol());
            pstm.setInt(5, o.getFucodigo());
            pstm.setInt(6, o.getPeriodo());
            pstm.setString(7, o.getHorario());
            pstm.setString(8, o.getHorainic());
            pstm.setString(9, o.getBaixaesto());
            pstm.setString(10, o.getFlagtrans());
            pstm.setString(11, o.getFlagtserv());
            pstm.setString(12, o.getSetoruso());
            pstm.setString(13, o.getNuregesp());
            pstm.setInt(14, o.getNumerocoo());
            pstm.setInt(15, o.getNucooctvl());
            pstm.setInt(16, o.getClcodigo());
            pstm.setString(17, o.getTipo());
            pstm.setString(18, o.getCgc());
            pstm.setString(19, o.getCpf());
            pstm.setString(20, o.getNome());
            pstm.setString(21, o.getTelefone());
            pstm.setString(22, o.getFantasia());
            pstm.setString(23, o.getEndereco());
            pstm.setInt(24, o.getTpenderecocom());
            pstm.setString(25, o.getComplementocom());
            pstm.setInt(26, o.getNumerocom());
            pstm.setString(27, o.getBairro());
            pstm.setInt(28, o.getCicodigo());
            pstm.setString(29, o.getNomecidade());
            pstm.setString(30, o.getUf());
            pstm.setString(31, o.getCep());
            pstm.setString(32, o.getModelonf());
            pstm.setString(33, o.getSerienf());
            pstm.setString(34, o.getSubserienf());
            pstm.setInt(35, o.getNumeronf());

            pstm.executeUpdate();

        } catch (Exception ex) {
            Loggin.logDiarioExcecao(ex, true);

        }

        return null;
    }

    //-------------------------------------------------------------------------------------------------------------------------------------------------
    public DevolucaBean devoluca(String caCodigo, Integer dvCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = null;
        String consultaSQL = "select * from DEVOLUCA "
                + " where CACODIGO = ? "
                + " and DVCODIGO = ? ";

        try {

            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setString(1, caCodigo);
            pstm.setInt(2, dvCodigo);
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
                    conn.rollback();
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
    public List<DevolucaBean> listarDevoluca() throws SQLException, ClassNotFoundException, IOException, Exception {

        List<DevolucaBean> listaDevolucaBean = null;
        String consultaSQL = "select * from DEVOLUCA ";

        try {

            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                gravarNoRegistro();
                listaDevolucaBean.add(registro);
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
                    conn.rollback();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (Exception ex) {
                Loggin.logDiarioExcecao(ex, true);
            }
        }
        return listaDevolucaBean;
    }

    //-------------------------------------------------------------------------------------------
    private void gravarNoRegistro() throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = new DevolucaBean();
        registro.setCacodigo(rs.getString("CACODIGO"));
        registro.setDvcodigo(rs.getInt("DVCODIGO"));
        registro.setData(rs.getDate("DATA"));
        registro.setValdevol(rs.getDouble("VALDEVOL"));
        registro.setFucodigo(rs.getInt("FUCODIGO"));
        registro.setPeriodo(rs.getInt("PERIODO"));
        registro.setHorario(rs.getString("HORARIO"));
        registro.setHorainic(rs.getString("HORAINIC"));
        registro.setBaixaesto(rs.getString("BAIXAESTO"));
        registro.setFlagtrans(rs.getString("FLAGTRANS"));
        registro.setFlagtserv(rs.getString("FLAGTSERV"));
        registro.setSetoruso(rs.getString("SETORUSO"));
        registro.setNuregesp(rs.getString("NUREGESP"));
        registro.setNumerocoo(rs.getInt("NUMEROCOO"));
        registro.setNucooctvl(rs.getInt("NUCOOCTVL"));
        registro.setClcodigo(rs.getInt("CLCODIGO"));
        registro.setTipo(rs.getString("TIPO"));
        registro.setCgc(rs.getString("CGC"));
        registro.setCpf(rs.getString("CPF"));
        registro.setNome(rs.getString("NOME"));
        registro.setTelefone(rs.getString("TELEFONE"));
        registro.setFantasia(rs.getString("FANTASIA"));
        registro.setEndereco(rs.getString("ENDERECO"));
        registro.setTpenderecocom(rs.getInt("TPENDERECOCOM"));
        registro.setComplementocom(rs.getString("COMPLEMENTOCOM"));
        registro.setNumerocom(rs.getInt("NUMEROCOM"));
        registro.setBairro(rs.getString("BAIRRO"));
        registro.setCicodigo(rs.getInt("CICODIGO"));
        registro.setNomecidade(rs.getString("NOMECIDADE"));
        registro.setUf(rs.getString("UF"));
        registro.setCep(rs.getString("CEP"));
        registro.setModelonf(rs.getString("MODELONF"));
        registro.setSerienf(rs.getString("SERIENF"));
        registro.setSubserienf(rs.getString("SUBSERIENF"));
        registro.setNumeronf(rs.getInt("NUMERONF"));

    }

}
