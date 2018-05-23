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

/**
 *
 * @author Raul
 */
public class ProximoIdDAO {

    private Connection conn = null;
    private PreparedStatement pstm;
    private ResultSet rs;
    private final Conectar conectar = new Conectar();

    //----------------------------------------------------------------------------------------------------------------------------
    public Integer proximoId(String caCodigo, String nomeTabela) throws SQLException, ClassNotFoundException, IOException, Exception {

        Integer maxId = 0;
        String consultaSQL = "";

        if (nomeTabela.equalsIgnoreCase("DEVOLUCA")) {
            consultaSQL = "select max(DVCODIGO) as ID from DEVOLUCA where CACODIGO = ? ";
        } else if (nomeTabela.equalsIgnoreCase("ItemDevo")) {
            consultaSQL = "select max(DVCODIGO) as ID from ItemDevo where CACODIGO = ? ";
        } else if (nomeTabela.equalsIgnoreCase("Lancamen")) {
            consultaSQL = "select max(LACODIGO) as ID from Lancamen where CACODIGO = ? ";
        } else if (nomeTabela.equalsIgnoreCase("vendaPdv")) {
            consultaSQL = "select max(VDCODIGO) as ID from vendaPdv where CACODIGO = ? ";
        } else if (nomeTabela.equalsIgnoreCase("PreVdPdv")) {
            consultaSQL = "select max(VDCODIGO) as ID from PreVdPdv where CACODIGO = ? ";
        } else if (nomeTabela.equalsIgnoreCase("Orcament")) {
            //consultaSQL = "select max(ORCODIGO) as ID from Orcament where CACODIGO = ? ";
            consultaSQL = "select max(ORCODIGO) as ID from Orcament ";
        }

        try {

            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            if (!nomeTabela.equalsIgnoreCase("Orcament")) {
                pstm.setString(1, caCodigo);
            }
            rs = pstm.executeQuery();

            while (rs.next()) {
                maxId = rs.getInt("ID");
                break;
            }

            maxId = (maxId == null) ? 1 : maxId;

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Loggin.logDiarioExcecao(ex, true);
            }
        }
        return ++maxId;
    }
}
