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
public class LancamenDAO {

    Connection conn = null;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;
    LancamenBean registro;
    Conectar conectar = new Conectar();

    public ItemVpdvBean inserir(Connection pConn, List<LancamenBean> listaItem) throws SQLException, ClassNotFoundException, IOException, Exception {

        String consultaSQL = "insert into LANCAMEN( "
                + " LACODIGO, "
                + " COCODIGO, "
                + " CECODIGO, "
                + " PLCODIGO, "
                + " TIPO, "
                + " DATALANC, "
                + " DATAVENC, "
                + " DATAEMBO, "
                + " VALORANT, "
                + " MOEDAANT, "
                + " MULTA, "
                + " JUROS, "
                + " DESCONTO, "
                + " VALOR, "
                + " MOCODIGO, "
                + " DATAQUIT, "
                + " CLCODIGO, "
                + " FOCODIGO, "
                + " NUMCHEQ, "
                + " NUMDUPL, "
                + " MODELONF, "
                + " SUBSERIENF, "
                + " NUMERONF, "
                + " SERIENF, "
                + " VECODIGO, "
                + " OBS, "
                + " EMCODIGO, "
                + " USCODIGO, "
                + " FUCODIGO, "
                + " PERIODO , "
                + " CACODIGO, "
                + " CODINTEG, "
//                + " DCCODIGO, "
                + " NRECEB  , "
                + " NDETCAIX, "
                + " APCODIGO, "
                + " VDCODIGO, "
                + " BACODIGO, "
                + " AGENCIA, "
                + " NUMCONTA, "
                + " NOSSONUMERO, "
                + " CCCODIGO, "
                + " NUMEROCOO  , "
                + " DATAVENDA, "
                + " ECFSERIE, "
                + " CNCCODIGO  , "
                + " TIPOCONCILIACAO, "
                + " VALORORIGINAL, "
                + " DESCONTOORIGINAL, "
                + " TXEXPEDI, "
                + " STATUSCONC, "
                + " MVCDATA , "
                + " MVCPERIODO , "
                + " MVCTIPO, "
                + " MVCFPCODIGO, "
                + " MVCSEQESPEC, "
                + " LCASEQUENCIA) "
                + " values ("
                + " ?, ?, ?, ?, ?, ?, "
                + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
                + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
                + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
                + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
                + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) ";

        for (LancamenBean o : listaItem) {
            
            pstm = pConn.prepareStatement(consultaSQL);
            pstm.clearParameters();

            pstm.setInt(1, o.getLacodigo());
            pstm.setString(2, o.getCocodigo());
            pstm.setString(3, o.getCecodigo());
            pstm.setString(4, o.getPlcodigo());
            pstm.setString(5, o.getTipo());
            if (o.getDatalanc() != null) {
                pstm.setDate(6, new java.sql.Date(o.getDatalanc().getTime()));
            } else {
                pstm.setNull(6, java.sql.Types.DATE);
            }
            if (o.getDatavenc() != null) {
                pstm.setDate(7, new java.sql.Date(o.getDatavenc().getTime()));
            } else {
                pstm.setNull(7, java.sql.Types.DATE);
            }
            if (o.getDataembo() != null) {
                pstm.setDate(8, new java.sql.Date(o.getDataembo().getTime()));
            } else {
                pstm.setNull(8, java.sql.Types.DATE);
            }
            pstm.setDouble(9, o.getValorant());
            pstm.setString(10, o.getMoedaant());
            pstm.setDouble(11, o.getMulta());
            pstm.setDouble(12, o.getJuros());
            pstm.setDouble(13, o.getDesconto());
            pstm.setDouble(14, o.getValor());
            pstm.setString(15, o.getMocodigo());
            if (o.getDataquit() != null) {
                pstm.setDate(16, new java.sql.Date(o.getDataquit().getTime()));
            } else {
                pstm.setNull(16, java.sql.Types.DATE);
            }
            pstm.setInt(17, o.getClcodigo());
            pstm.setInt(18, o.getFocodigo());
            pstm.setString(19, o.getNumcheq());
            pstm.setString(20, o.getNumdupl());
            pstm.setString(21, o.getModelonf());
            pstm.setString(22, o.getSubserienf());
            pstm.setInt(23, o.getNumeronf());
            pstm.setString(24, o.getSerienf());
            pstm.setInt(25, o.getVecodigo());
            pstm.setString(26, o.getObs());
            pstm.setInt(27, o.getEmcodigo());
            pstm.setString(28, o.getUscodigo());
            pstm.setInt(29, o.getFucodigo());
            pstm.setInt(30, o.getPeriodo());
            pstm.setString(31, o.getCacodigo());
            pstm.setString(32, o.getCodinteg());
//            pstm.setInt(33, o.getDccodigo());
            pstm.setInt(33, o.getNreceb());
            pstm.setInt(34, o.getNdetcaix());
            pstm.setInt(35, o.getApcodigo());
            pstm.setInt(36, o.getVdcodigo());
            pstm.setString(37, o.getBacodigo());
            pstm.setString(38, o.getAgencia());
            pstm.setString(39, o.getNumconta());
            pstm.setInt(40, o.getNossonumero());
            pstm.setInt(41, o.getCccodigo());
            pstm.setInt(42, o.getNumerocoo());
            pstm.setDate(43, new java.sql.Date(o.getDatavenda().getTime()));
            pstm.setString(44, o.getEcfserie());
            pstm.setInt(45, o.getCnccodigo());
            pstm.setString(46, o.getTipoconciliacao());
            pstm.setDouble(47, o.getValororiginal());
            pstm.setDouble(48, o.getDescontooriginal());
            pstm.setString(49, o.getTxexpedi());
            pstm.setString(50, o.getStatusconc());
            if (o.getMvcdata() != null) {
                pstm.setDate(51, new java.sql.Date(o.getMvcdata().getTime()));
            } else {
                pstm.setNull(51, java.sql.Types.DATE);
            }
            pstm.setInt(52, o.getMvcperiodo());
            pstm.setString(53, o.getMvctipo());
            pstm.setInt(54, o.getMvcfpcodigo());
            pstm.setInt(55, o.getMvcseqespec());
            pstm.setInt(56, o.getLcasequencia());
            pstm.executeUpdate();

        }

        return null;
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public LancamenBean listarClienPdvClcodigo(int laCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = null;
        String consultaSQL = "select * from Lancamen "
                + " where LACODIGO = ? ";

        try {

            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setInt(1, laCodigo);
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

        registro = new LancamenBean();
        registro.setLacodigo(rs.getInt("LACODIGO"));
        registro.setCocodigo(rs.getString("COCODIGO"));
        registro.setCecodigo(rs.getString("CECODIGO"));
        registro.setPlcodigo(rs.getString("PLCODIGO"));
        registro.setTipo(rs.getString("TIPO"));
        registro.setDatalanc(rs.getDate("DATALANC"));
        registro.setDatavenc(rs.getDate("DATAVENC"));
        registro.setDataembo(rs.getDate("DATAEMBO"));
        registro.setValorant(rs.getDouble("VALORANT"));
        registro.setMoedaant(rs.getString("MOEDAANT"));
        registro.setMulta(rs.getDouble("MULTA"));
        registro.setJuros(rs.getDouble("JUROS"));
        registro.setDesconto(rs.getDouble("DESCONTO"));
        registro.setValor(rs.getDouble("VALOR"));
        registro.setMocodigo(rs.getString("MOCODIGO"));
        registro.setDataquit(rs.getDate("DATAQUIT"));
        registro.setClcodigo(rs.getInt("CLCODIGO"));
        registro.setFocodigo(rs.getInt("FOCODIGO"));
        registro.setNumcheq(rs.getString("NUMCHEQ"));
        registro.setNumdupl(rs.getString("NUMDUPL"));
        registro.setModelonf(rs.getString("MODELONF"));
        registro.setSubserienf(rs.getString("SUBSERIENF"));
        registro.setNumeronf(rs.getInt("NUMERONF"));
        registro.setSerienf(rs.getString("SERIENF"));
        registro.setVecodigo(rs.getInt("VECODIGO"));
        registro.setObs(rs.getString("OBS"));
        registro.setEmcodigo(rs.getInt("EMCODIGO"));
        registro.setUscodigo(rs.getString("USCODIGO"));
        registro.setFucodigo(rs.getInt("FUCODIGO"));
        registro.setPeriodo(rs.getInt("PERIODO"));
        registro.setCacodigo(rs.getString("CACODIGO"));
        registro.setCodinteg(rs.getString("CODINTEG"));
        registro.setDccodigo(rs.getInt("DCCODIGO"));
        registro.setNreceb(rs.getInt("NRECEB"));
        registro.setNdetcaix(rs.getInt("NDETCAIX"));
        registro.setApcodigo(rs.getInt("APCODIGO"));
        registro.setVdcodigo(rs.getInt("VDCODIGO"));
        registro.setBacodigo(rs.getString("BACODIGO"));
        registro.setAgencia(rs.getString("AGENCIA"));
        registro.setNumconta(rs.getString("NUMCONTA"));
        registro.setNossonumero(rs.getInt("NOSSONUMERO"));
        registro.setCccodigo(rs.getInt("CCCODIGO"));
        registro.setNumerocoo(rs.getInt("NUMEROCOO"));
        registro.setDatavenda(rs.getDate("DATAVENDA"));
        registro.setEcfserie(rs.getString("ECFSERIE"));
        registro.setCnccodigo(rs.getInt("CNCCODIGO"));
        registro.setTipoconciliacao(rs.getString("TIPOCONCILIACAO"));
        registro.setValororiginal(rs.getDouble("VALORORIGINAL"));
        registro.setDescontooriginal(rs.getDouble("DESCONTOORIGINA"));
        registro.setTxexpedi(rs.getString("TXEXPEDI"));
        registro.setStatusconc(rs.getString("STATUSCONC"));
        registro.setMvcdata(rs.getDate("MVCDATA"));
        registro.setMvcperiodo(rs.getInt("MVCPERIODO"));
        registro.setMvctipo(rs.getString("MVCTIPO"));
        registro.setMvcfpcodigo(rs.getInt("MVCFPCODIGO"));
        registro.setMvcseqespec(rs.getInt("MVCSEQESPEC"));
        registro.setLcasequencia(rs.getInt("LCASEQUENCIA"));

    }
}
