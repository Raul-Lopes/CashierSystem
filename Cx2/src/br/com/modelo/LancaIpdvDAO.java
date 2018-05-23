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
public class LancaIpdvDAO {

    Connection conn = null;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;
    LancaIpdvBean registro;
    Conectar conectar = new Conectar();

    //----------------------------------------------------------------------------------------------------------------
    public LancaIpdvBean LancaIpdv(LancaIpdvBean lancaIpdvBean) throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = null;
        String consultaSQL = "select * from LancaIpdv "
                + " where CACODIGO = ? "
                + " and DATA         = ? "
                + " and PERIODO      = ? "
                + " and TIPO         = ? "
                + " and VDCODIGO     = ? "
                + " and FPCODIGO     = ? "
                + " and SEQESPEC     = ? "
                + " and SEQUENCIA    = ? ";

        try {

            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setString(1, lancaIpdvBean.getCacodigo());
            pstm.setDate(2, new java.sql.Date(lancaIpdvBean.getData().getTime()));
            pstm.setInt(3, lancaIpdvBean.getPeriodo());
            pstm.setString(4, lancaIpdvBean.getTipo());
            pstm.setInt(5, lancaIpdvBean.getVdcodigo());
            pstm.setInt(6, lancaIpdvBean.getFpcodigo());
            pstm.setInt(7, lancaIpdvBean.getSeqespec());
            pstm.setInt(8, lancaIpdvBean.getSequencia());
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

        registro = new LancaIpdvBean();
        registro.setCacodigo(rs.getString("CACODIGO"));
        registro.setData(rs.getDate("DATA"));
        registro.setPeriodo(rs.getInt("PERIODO"));
        registro.setTipo(rs.getString("TIPO"));
        registro.setVdcodigo(rs.getInt("VDCODIGO"));
        registro.setFpcodigo(rs.getInt("FPCODIGO"));
        registro.setSeqespec(rs.getInt("SEQESPEC"));
        registro.setSequencia(rs.getInt("SEQUENCIA"));
        registro.setDatalanc(rs.getDate("DATALANC"));
        registro.setValor(rs.getDouble("VALOR"));
        registro.setSituacao(rs.getString("SITUACAO"));
        registro.setBanco(rs.getString("BANCO"));
        registro.setConta(rs.getString("CONTA"));
        registro.setAgencia(rs.getString("AGENCIA"));
        registro.setNumcheque(rs.getString("NUMCHEQUE"));
        registro.setTelefone(rs.getString("TELEFONE"));
        registro.setCgccpf(rs.getString("CGCCPF"));
        registro.setFlagtrans(rs.getString("FLAGTRANS"));
        registro.setFlagtserv(rs.getString("FLAGTSERV"));
        registro.setModelonf(rs.getString("MODELONF"));
        registro.setSerienf(rs.getString("SERIENF"));
        registro.setSubserienf(rs.getString("SUBSERIENF"));
        registro.setNumeronf(rs.getInt("NUMERONF"));

    }

}
