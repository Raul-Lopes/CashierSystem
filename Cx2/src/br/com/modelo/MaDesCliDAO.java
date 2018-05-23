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
public class MaDesCliDAO {

    Connection conn = null;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;
    MaDesCliBean registro;
    Conectar conectar = new Conectar();

    //-----------------------------------------------------------------------------------------------------------------------------------
    public Double perDescontoCliente(String mfCodigo, Integer clCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {

        //tabela de desconto personalizada
        double perDesconto = 0.0;
        registro = null;
        String consultaSQL = "select * from MaDesCli where MFCODIGO = ? and CLCODIGO = ?";

        try {

            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setString(1, mfCodigo);
            pstm.setInt(2, clCodigo);
            rs = pstm.executeQuery();

            while (rs.next()) {
                gravarNoRegistro();
                break;
            }

            if (perDesconto != 0.0) {
                perDesconto = registro.getPercdesc();
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
        return perDesconto;
    }

    //-------------------------------------------------------------------------------------------
    void gravarNoRegistro() throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = new MaDesCliBean();
        registro.setMfcodigo(rs.getString("MFCODIGO"));
        registro.setClcodigo(rs.getInt("CLCODIGO"));
        registro.setPercdesc(rs.getDouble("PERCDESC"));
        registro.setDataalte(rs.getDate("DATAALTE"));

    }
}
