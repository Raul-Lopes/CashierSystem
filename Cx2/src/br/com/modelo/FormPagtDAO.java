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
public class FormPagtDAO {

    Connection conn = null;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;
    FormPagtBean registro;
    ParcfPgtDAO parcfPgtDAO = new ParcfPgtDAO();
    Conectar conectar = new Conectar();

    //----------------------------------------------------------------------------------------------------------------------------
    public FormPagtBean listarFormPagtFpCodigo(String fpCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = null;
        List<ParcfPgtBean> listaParcfPgtBean;
        String consultaSQL = "select * from FormPagt "
                + " where FPCODIGO = ? ";

        try {

            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setString(1, fpCodigo);
            rs = pstm.executeQuery();

            while (rs.next()) {

                gravarNoRegistro();

                listaParcfPgtBean = parcfPgtDAO.listaParcfPgt(fpCodigo);
                registro.setParcfPgtBeanVO(listaParcfPgtBean);

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
    public List<FormPagtBean> listarFormPagt() throws SQLException, ClassNotFoundException, IOException, Exception {

        List<FormPagtBean> listaFormPagtBean = new ArrayList<FormPagtBean>();
        List<ParcfPgtBean> listaParcfPgtBean;
        registro = null;
        String consultaSQL = "select * from FormPagt "
                + " order by FPCODIGO ";

        try {

            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            rs = pstm.executeQuery();

            while (rs.next()) {

                gravarNoRegistro();

                listaParcfPgtBean = parcfPgtDAO.listaParcfPgt(rs.getString("FPCODIGO"));
                registro.setParcfPgtBeanVO(listaParcfPgtBean);

                listaFormPagtBean.add(registro);
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
        return listaFormPagtBean;
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public List<FormPagtBean> listarFormPagt(String tipoPgto) throws SQLException, ClassNotFoundException, IOException, Exception {

        List<FormPagtBean> listaFormPagtBean = new ArrayList<FormPagtBean>();
        List<ParcfPgtBean> listaParcfPgtBean;
        registro = null;
        String consultaSQL;

        try {

            if (tipoPgto.equalsIgnoreCase("VISTA")) {
                consultaSQL = "select * from FormPagt "
                        + " where QTDPARC = 0 "
                        + " order by FPCODIGO ";
            } else { //A PRAZO
                consultaSQL = "select * from FormPagt "
                        + " where QTDPARC > 0 "
                        + " order by FPCODIGO ";
            }
            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            rs = pstm.executeQuery();

            while (rs.next()) {

                gravarNoRegistro();

                listaParcfPgtBean = parcfPgtDAO.listaParcfPgt(rs.getString("FPCODIGO"));
                registro.setParcfPgtBeanVO(listaParcfPgtBean);

                listaFormPagtBean.add(registro);
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
        return listaFormPagtBean;
    }

    //-------------------------------------------------------------------------------------------
    void gravarNoRegistro() throws SQLException, ClassNotFoundException, IOException, Exception {
 
        registro = new FormPagtBean();
        registro.setFpcodigo(rs.getString("FPCODIGO"));
        registro.setNome(rs.getString("NOME"));
        registro.setDiasentra(rs.getInt("DIASENTRA"));
        registro.setPercentra(rs.getDouble("PERCENTRA"));
        registro.setPercdesco(rs.getDouble("PERCDESCO"));
        registro.setCodespec(rs.getInt("CODESPEC"));
        registro.setClieobrig(rs.getString("CLIEOBRIG"));
        registro.setDiasparc(rs.getInt("DIASPARC"));
        registro.setQtdparc(rs.getInt("QTDPARC"));
        registro.setDataalte(rs.getDate("DATAALTE"));
        registro.setTratalim(rs.getString("TRATALIM"));
        registro.setPromissr(rs.getString("PROMISSR"));
        registro.setPedsenha(rs.getString("PEDSENHA"));
        registro.setMaxdesco(rs.getDouble("MAXDESCO"));
        registro.setMaxparce(rs.getInt("MAXPARCE"));
        registro.setMaxdiasp(rs.getInt("MAXDIASP"));
        registro.setMaxdifep(rs.getDouble("MAXDIFEP"));
        registro.setCocodigo(rs.getString("COCODIGO"));
        registro.setCecodigo(rs.getString("CECODIGO"));
        registro.setPlcodigo(rs.getString("PLCODIGO"));
        registro.setDescfin(rs.getDouble("DESCFIN"));
        registro.setGerpardfixo(rs.getString("GERPARDFIXO"));
        registro.setTipooper(rs.getString("TIPOOPER"));
        registro.setTranspos(rs.getString("TRANSPOS"));
        registro.setPedenaupos(rs.getString("PEDENAUPOS"));
        registro.setTagtef(rs.getString("TAGTEF"));
        registro.setTpcartao(rs.getString("TPCARTAO"));
        registro.setCodadmin(rs.getString("CODADMIN"));
        registro.setIndpag(rs.getString("INDPAG"));
        registro.setImpboleto(rs.getString("IMPBOLETO"));
        registro.setTpopveiculo(rs.getInt("TPOPVEICULO"));

    }

}
