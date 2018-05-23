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
public class NbmsUfDAO {

    Connection conn = null;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;
    NbmsUfBean registro;
    Conectar conectar = new Conectar();

    //----------------------------------------------------------------------------------------------------------
    public NbmsUfBean listarNbmsUf(String nbCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {

        String consultaSQL = "select * from NBMSUF where NBCODIGO = ? ";

        try {
            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setString(1, nbCodigo);
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                gravarNoRegistro();
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
    public List<NbmsUfBean> tabelaNbmsUf() throws SQLException, ClassNotFoundException, IOException, Exception {

        List<NbmsUfBean> listaNbmsUfBean = null;
        String consultaSQL = "select * from NBMSUF order by NBCODIGO ";

        try {
            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                gravarNoRegistro();
                listaNbmsUfBean.add(registro);
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
        return listaNbmsUfBean;
    }

    //-------------------------------------------------------------------------------------------
    void gravarNoRegistro() throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = new NbmsUfBean();
        registro.setNbcodigo(rs.getString("NBCODIGO"));
        registro.setUf(rs.getString("UF"));
        registro.setOrigem(rs.getString("ORIGEM"));
        registro.setAliqcred(rs.getDouble("ALIQCRED"));
        registro.setAliqdeb(rs.getDouble("ALIQDEB"));
        registro.setDataalte(rs.getDate("DATAALTE"));
    }
}
