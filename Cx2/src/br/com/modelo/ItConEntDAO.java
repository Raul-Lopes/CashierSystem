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

/**
 *
 * @author raul
 */
public class ItConEntDAO {

    Connection conn = null;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;
    ItConEntBean registro;
private final Conectar conectarReal = new Conectar();
    //----------------------------------------------------------------------------------------------------------------------------
    public ItConEntBean ItConEnt(int cgCodigo, int niConent) throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = null;
        String consultaSQL = "select * from ItConEnt "
                + " where CGCODIGO = ? and NICONENT = ? ";
        try {

            conn = conectarReal.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setInt(1, cgCodigo);
            pstm.setInt(2, niConent);
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

    //-------------------------------------------------------------------------------------------
    void gravarNoRegistro() throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = new ItConEntBean();
        registro.setCgcodigo(rs.getInt("CGCODIGO"));
        registro.setNiconent(rs.getInt("NICONENT"));
        registro.setMfcodigo(rs.getString("MFCODIGO"));
        registro.setQtdvda(rs.getDouble("QTDVDA"));
        registro.setValivda(rs.getDouble("VALIVDA"));
        registro.setQtddev(rs.getDouble("QTDDEV"));
        registro.setValidev(rs.getDouble("VALIDEV"));
        registro.setPrcunit(rs.getDouble("PRCUNIT"));
        registro.setCscodigo(rs.getInt("CSCODIGO"));
        registro.setNiconsai(rs.getInt("NICONSAI"));
        registro.setFlag(rs.getString("FLAG"));
        registro.setFlagtrans(rs.getString("FLAGTRANS"));

    }

}
