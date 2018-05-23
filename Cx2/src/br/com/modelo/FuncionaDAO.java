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
public class FuncionaDAO {

    Connection conn = null;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;
    FuncionaBean registro;
    TipoFuncBean tipoFuncBean;
    Conectar conectar = new Conectar();

    //----------------------------------------------------------------------------------------------------------------------------
    public FuncionaBean funcionaFuCodigo(int fuCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = null;
        String consultaSQL
                = " select F.*, T.TFCODIGO, T.NOME, T.HCCODIGO, T.DATAALTE "
                + " from Funciona F, TIPOFUNC T "
                + " where F.TFCODIGO = T.TFCODIGO"
                + " and F.FUCODIGO = ? ";

        try {

            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setInt(1, fuCodigo);
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
    public FuncionaBean acessarUsuario(int fuCodigo, String senha) throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = null;
        String consultaSQL
                = " select F.*, T.TFCODIGO as T_TFCODIGO, T.NOME as T_NOME, T.HCCODIGO as T_HCCODIGO, T.DATAALTE as T_DATAALTE "
                + " from Funciona F, TIPOFUNC T "
                + " where F.TFCODIGO = T.TFCODIGO"
                + " and F.FUCODIGO = ? "
                + " and F.SENHA = ? ";

        try {

            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setInt(1, fuCodigo);
            pstm.setString(2, senha);
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
    public List<FuncionaBean> listarFuncionaFuCodigo() throws SQLException, ClassNotFoundException, IOException, Exception {

        List<FuncionaBean> listaFuncionaBean = new ArrayList<FuncionaBean>();
        registro = null;
        String consultaSQL
                = " select F.*, T.TFCODIGO as T_TFCODIGO, T.NOME as T_NOME, T.HCCODIGO as T_HCCODIGO, T.DATAALTE as T_DATAALTE "
                + " from Funciona F, TIPOFUNC T "
                + " where F.TFCODIGO = T.TFCODIGO"
                + " order by F.NOME ";

        try {

            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            rs = pstm.executeQuery();

            while (rs.next()) {
                gravarNoRegistro();
                listaFuncionaBean.add(registro);
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
        return listaFuncionaBean;
    }

    //-------------------------------------------------------------------------------------------
    void gravarNoRegistro() throws SQLException, ClassNotFoundException, IOException, Exception {

        tipoFuncBean = new TipoFuncBean();
        tipoFuncBean.setTfCoidgo(rs.getString("T_TFCODIGO"));
        tipoFuncBean.setNome(rs.getString("T_NOME"));
        tipoFuncBean.setHcCodigo(rs.getInt("T_HCCODIGO"));
        tipoFuncBean.setDataAlte(rs.getDate("T_DATAALTE"));

        registro = new FuncionaBean();
        registro.setFucodigo(rs.getInt("FUCODIGO"));
        registro.setNome(rs.getString("NOME"));
        registro.setTfcodigo(rs.getString("TFCODIGO"));
        registro.setCpf(rs.getString("CPF"));
        registro.setIdentida(rs.getString("IDENTIDA"));
        registro.setCarttrab(rs.getString("CARTTRAB"));
        registro.setEndereco(rs.getString("ENDERECO"));
        registro.setBairro(rs.getString("BAIRRO"));
        registro.setCicodigo(rs.getInt("CICODIGO"));
        registro.setUf(rs.getString("UF"));
        registro.setCep(rs.getString("CEP"));
        registro.setTelefone(rs.getString("TELEFONE"));
        registro.setSenha(rs.getString("SENHA"));
        registro.setPerccomi(rs.getDouble("PERCCOMI"));
        registro.setPercomiprz(rs.getDouble("PERCOMIPRZ"));
        registro.setDatanasc(rs.getDate("DATANASC"));
        registro.setFicodigo(rs.getInt("FICODIGO"));
        registro.setEmcodigo(rs.getInt("EMCODIGO"));
        registro.setLocaltra(rs.getString("LOCALTRA"));
        registro.setCodintern(rs.getString("CODINTERN"));
        registro.setDataalte(rs.getDate("DATAALTE"));
        registro.setQhcodigo(rs.getInt("QHCODIGO"));
        registro.setUltimoac(rs.getDate("ULTIMOAC"));
        registro.setUltimogiro(rs.getInt("ULTIMOGIRO"));
        registro.setNivelatual(rs.getString("NIVELATUAL"));
        registro.setRptsenha(rs.getString("RPTSENHA"));
        registro.setPorteiro(rs.getString("PORTEIRO"));
        registro.setDpcodigo(rs.getInt("DPCODIGO"));
        registro.setNumregistro(rs.getString("NUMREGISTRO"));
        registro.setDataemcart(rs.getDate("DATAEMCART"));
        registro.setSeriecart(rs.getString("SERIECART"));
        registro.setHoraferia(rs.getString("HORAFERIA"));
        registro.setExtrabfr(rs.getString("EXTRABFR"));
        registro.setAdmissao(rs.getDate("ADMISSAO"));
        registro.setCargo(rs.getString("CARGO"));
        registro.setPathfoto(rs.getString("PATHFOTO"));
        registro.setExtradef(rs.getString("EXTRADEF"));
        registro.setPermiteagenda(rs.getString("PERMITEAGENDA"));
        registro.setCodfrenti(rs.getString("CODFRENTI"));
        registro.setTipoFuncBean(tipoFuncBean);

        //registro.setTpendereco(rs.getInt("TPENDERECO"));
        //registro.setNumero(rs.getInt("NUMERO"));
        //registro.setComplemento(rs.getString("COMPLEMENTO"));
    }
}





