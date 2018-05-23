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
public class ItConSaiDAO {

    Connection conn = null;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;
    ItConSaiBean registro;
    Conectar conectar = new Conectar();

    //----------------------------------------------------------------------------------------------------------------------------
    public ItConSaiBean ItConSai(int csCodigo, int niConsai) throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = null;
        String consultaSQL = "select * from Aliquota "
                + " where CSCODIGO= ? and NICONSAI = ? ";

        try {

            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setInt(1, csCodigo);
            pstm.setInt(2, niConsai);
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

        registro = new ItConSaiBean();
        registro.setCscodigo(rs.getInt("CSCODIGO"));
        registro.setNiconsai(rs.getInt("NICONSAI"));
        registro.setMfcodigo(rs.getString("MFCODIGO"));
        registro.setQtditem(rs.getDouble("QTDITEM"));
        registro.setValitem(rs.getDouble("VALITEM"));
        registro.setPrcunit(rs.getDouble("PRCUNIT"));
        registro.setPrcorig(rs.getDouble("PRCORIG"));
        registro.setFlag(rs.getString("FLAG"));
        registro.setCgcodigo(rs.getInt("CGCODIGO"));
        registro.setQtdmov(rs.getDouble("QTDMOV"));
        registro.setFlagtrans(rs.getString("FLAGTRANS"));

    }

}
