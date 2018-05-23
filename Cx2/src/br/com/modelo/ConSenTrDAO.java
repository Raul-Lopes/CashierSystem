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
public class ConSenTrDAO {

    Connection conn = null;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;
    ConSenTrBean registro;
    Conectar conectar = new Conectar();

    //----------------------------------------------------------------------------------------------------------------------------
    public ConSenTrBean conSenTrCgCodigo(int cgCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = null;
        String consultaSQL = "select * from ConSenTr "
                + " where CGCODIGO = ? ";

        try {

            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setInt(1, cgCodigo);
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

        registro = new ConSenTrBean();
        registro.setCgcodigo(rs.getInt("CGCODIGO"));
        registro.setData(rs.getDate("DATA"));
        registro.setClcodigo(rs.getInt("CLCODIGO"));
        registro.setValor(rs.getDouble("VALOR"));
        registro.setDatprdev(rs.getDate("DATPRDEV"));
        registro.setNumserie(rs.getString("NUMSERIE"));
        registro.setStatus(rs.getString("STATUS"));
        registro.setFucodigo(rs.getInt("FUCODIGO"));
        registro.setCscodigo(rs.getInt("CSCODIGO"));
        registro.setOrcodigo(rs.getInt("ORCODIGO"));
        registro.setFlag(rs.getString("FLAG"));
        registro.setFlagtrans(rs.getString("FLAGTRANS"));

    }

}
