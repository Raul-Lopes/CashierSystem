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
public class LanclPdvDAO {

    Connection conn = null;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;
    LanclPdvBean registro;
    Conectar conectar = new Conectar();

    //----------------------------------------------------------------------------------------------------------------------------
    public LanclPdvBean listarLanclPdv(int lcCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = null;
        String consultaSQL = "select * from LanclPdv "
                + " where LCCODIGO = ? ";

        try {

            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setDouble(1, lcCodigo);
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

        registro = new LanclPdvBean();
        registro.setLccodigo(rs.getInt("LCCODIGO"));
        registro.setClcodigo(rs.getInt("CLCODIGO"));
        registro.setValor(rs.getDouble("VALOR"));
        registro.setDatavenc(rs.getDate("DATAVENC"));
        registro.setTipo(rs.getString("TIPO"));

    }
}
