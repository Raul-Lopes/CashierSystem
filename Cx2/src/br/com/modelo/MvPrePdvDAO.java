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
public class MvPrePdvDAO {

    Connection conn = null;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;
    MvPrePdvBean registro;
    Conectar conectar = new Conectar();

    public MvPrePdvBean inserir(Connection pConn, MvPrePdvBean o) throws SQLException, ClassNotFoundException, IOException, Exception {

        try {

            String consultaSQL = "insert into MvPrePdv ( "
                    + " CACODIGO, "
                    + " DATA, "
                    + " PERIODO, "
                    + " TIPO, "
                    + " VDCODIGO, "
                    + " FPCODIGO, "
                    + " SEQESPEC, "
                    + " ESPPGECF, "
                    + " LACODIGO, "
                    + " FUCODIGO, "
                    + " PLCODIGO, "
                    + " VALOR, "
                    + " FORMPGTO, "
                    + " NUMPARCE, "
                    + " DATACOMP, "
                    + " HORACOMP, "
                    + " SETORUSO, "
                    + " DTCODIGO, "
                    + " AUTORITRANSACAO, "
                    + " BANDEIRA, "
                    + " TIPOPAGAMENTO, "
                    + " TIPOFINANCIAMEN, "
                    + " TEFSERVIDOR, "
                    + " TEFVLRTREFET, "
                    + " TEFVLRTREFEA, "
                    + " TEFIDENTIFIC, "
                    + " TEFDADOSFINA, "
                    + " TEFREDEAUTOR, "
                    + " TEFTIPTRREDE, "
                    + " TEFNUTRANNSU, "
                    + " TEFCODAUTTRA, "
                    + " TEFTXVLRTRAN, "
                    + " TEFDATATRANS, "
                    + " TEFHORATRANS, "
                    + " TEFCODMODPGT, "
                    + " TEFTXMODAPGT, "
                    + " TEFTXMOPGCUP, "
                    + " TEFNSUSITEF, "
                    + " TEFBIMCARTAO, "
                    + " TEFNUPARCELA, "
                    + " TEFDTPREDATA, "
                    + " TEFNOMEOPCEL, "
                    + " TEFVLRRECARG, "
                    + " TEFDDDNUMCEL, "
                    + " TEFDIGIVERIF, "
                    + " TEFCEPLTEOPE, "
                    + " TEFNSUSTPRCA, "
                    + " TEFNSUHATPRC, "
                    + " TEFCOFIATRCE, "
                    + " TEFNUMPARCEL, "
                    + " TEFNUMTERLOG, "
                    + " TEFCODAFILIA, "
                    + " FLAGTRANS, "
                    + " FLAGTSERV, "
                    + " ECFSEQUE, "
                    + " ECFSERIE, "
                    + " ECFMARCA, "
                    + " ECFMODELO, "
                    + " ECFTIPO, "
                    + " SWBVERSAO, "
                    + " SWBDTHRGR, "
                    + " SWBMFADIC, "
                    + " COO, "
                    + " GNF, "
                    + " CCF, "
                    + " GRG, "
                    + " CER, "
                    + " TPVENDCART, "
                    + " CADEVOLUC, "
                    + " DVCODIGO, "
                    + " ORIGEM, "
                    + " PAFHASHVER, "
                    + " PAFHASHDET, "
                    + " DATADAMOV, "
                    + " MODELONF, "
                    + " SERIENF, "
                    + " SUBSERIENF, "
                    + " NUMERONF, "
                    + " FLAGFINAN ) "
                    + " values ("
                    + " ?, ?, ?, ?, ?, ?, ?, ?,       "
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + " ) ";

            pstm = pConn.prepareStatement(consultaSQL);
            pstm.setString(1, o.getCacodigo());
            pstm.setDate(2, new java.sql.Date(o.getData().getTime()));
            pstm.setInt(3, o.getPeriodo());
            pstm.setString(4, o.getTipo());
            pstm.setInt(5, o.getVdcodigo());
            pstm.setInt(6, o.getFpcodigo());
            pstm.setInt(7, o.getSeqespec());
            pstm.setString(8, o.getEsppgecf());
            pstm.setInt(9, o.getLacodigo());
            pstm.setInt(10, o.getFucodigo());
            pstm.setString(11, o.getPlcodigo());
            pstm.setDouble(12, o.getValor());
            pstm.setString(13, o.getFormpgto());
            pstm.setInt(14, o.getNumparce());
            pstm.setDate(15, new java.sql.Date(o.getDatacomp().getTime()));
            pstm.setString(16, o.getHoracomp());
            pstm.setString(17, o.getSetoruso());
            pstm.setInt(18, o.getDtcodigo());
            pstm.setString(19, o.getAutoritransacao());
            pstm.setString(20, o.getBandeira());
            pstm.setString(21, o.getTipopagamento());
            pstm.setString(22, o.getTipofinanciamen());
            pstm.setString(23, o.getTefservidor());
            pstm.setDouble(24, o.getTefvlrtrefet());
            pstm.setDouble(25, o.getTefvlrtrefea());
            pstm.setString(26, o.getTefidentific());
            pstm.setString(27, o.getTefdadosfina());
            pstm.setString(28, o.getTefredeautor());
            pstm.setString(29, o.getTeftiptrrede());
            pstm.setString(30, o.getTefnutrannsu());
            pstm.setString(31, o.getTefcodauttra());
            pstm.setString(32, o.getTeftxvlrtran());
            pstm.setString(33, o.getTefdatatrans());
            pstm.setString(34, o.getTefhoratrans());
            pstm.setString(35, o.getTefcodmodpgt());
            pstm.setString(36, o.getTeftxmodapgt());
            pstm.setString(37, o.getTeftxmopgcup());
            pstm.setString(38, o.getTefnsusitef());
            pstm.setString(39, o.getTefbimcartao());
            pstm.setString(40, o.getTefnuparcela());
            pstm.setString(41, o.getTefdtpredata());
            pstm.setString(42, o.getTefnomeopcel());
            pstm.setString(43, o.getTefvlrrecarg());
            pstm.setString(44, o.getTefdddnumcel());
            pstm.setString(45, o.getTefdigiverif());
            pstm.setString(46, o.getTefceplteope());
            pstm.setString(47, o.getTefnsustprca());
            pstm.setString(48, o.getTefnsuhatprc());
            pstm.setString(49, o.getTefcofiatrce());
            pstm.setString(50, o.getTefnumparcel());
            pstm.setString(51, o.getTefnumterlog());
            pstm.setString(52, o.getTefcodafilia());
            pstm.setString(53, o.getFlagtrans());
            pstm.setString(54, o.getFlagtserv());
            pstm.setString(55, o.getEcfseque());
            pstm.setString(56, o.getEcfserie());
            pstm.setString(57, o.getEcfmarca());
            pstm.setString(58, o.getEcfmodelo());
            pstm.setString(59, o.getEcftipo());
            pstm.setString(60, o.getSwbversao());
            pstm.setDate(61, new java.sql.Date(o.getSwbdthrgr().getTime()));
            pstm.setString(62, o.getSwbmfadic());
            pstm.setInt(63, o.getCoo());
            pstm.setInt(64, o.getGnf());
            pstm.setInt(65, o.getCcf());
            pstm.setInt(66, o.getGrg());
            pstm.setInt(67, o.getCer());
            pstm.setString(68, o.getTpvendcart());
            pstm.setString(69, o.getCadevoluc());
            pstm.setInt(70, o.getDvcodigo());
            pstm.setString(71, o.getOrigem());
            pstm.setString(72, o.getPafhashver());
            pstm.setString(73, o.getPafhashdet());
            pstm.setDate(74, new java.sql.Date(o.getDatadamov().getTime()));
            pstm.setString(75, o.getModelonf());
            pstm.setString(76, o.getSerienf());
            pstm.setString(77, o.getSubserienf());
            pstm.setInt(78, o.getNumeronf());
            pstm.executeUpdate();

        } finally {

            //System.out.println("Closing database resources and rolling back any changes we made to the database.");
            //Now that we're all finished, let's release database resources.
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (pConn != null) {
                    pConn.rollback();
                }
                if (pConn != null && !conn.isClosed()) {
                    pConn.close();
                }
            } catch (Exception ex) {
                Loggin.logDiarioExcecao(ex, true);
            }
        }

        return null;
    }

    //---------------------------------------------------------------------------------------------------------------------------
    public MvPrePdvBean mvPrePdv(MvPrePdvBean mvCaipdvBean) throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = null;
        String consultaSQL = "select * from MvPrePdv "
                + " where CACODIGO  = ? "
                + " DATA      = ? "
                + " PERIODO   = ? "
                + " TIPO      = ? "
                + " VDCODIGO  = ? "
                + " FPCODIGO  = ? "
                + " SEQESPEC  = ? ";

        try {

            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setString(1, mvCaipdvBean.getCacodigo());
            pstm.setDate(2, new java.sql.Date(mvCaipdvBean.getData().getTime()));
            pstm.setInt(3, mvCaipdvBean.getPeriodo());
            pstm.setString(4, mvCaipdvBean.getTipo());
            pstm.setInt(5, mvCaipdvBean.getVdcodigo());
            pstm.setInt(6, mvCaipdvBean.getFpcodigo());
            pstm.setInt(7, mvCaipdvBean.getSeqespec());
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

    //--------------------------------------------------------------------------------------------------------------
    public List<MvPrePdvBean> listarMvPrePdv() throws SQLException, ClassNotFoundException, IOException, Exception {

        List<MvPrePdvBean> listaMvPrePdvBean = null;
        String consultaSQL = "select * from MvPrePdv order by DATA";

        try {
            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                gravarNoRegistro();
                listaMvPrePdvBean.add(registro);
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
        return listaMvPrePdvBean;
    }

    //-------------------------------------------------------------------------------------------
    private void gravarNoRegistro() throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = new MvPrePdvBean();
        registro.setCacodigo(rs.getString("CACODIGO"));
        registro.setData(rs.getDate("DATA"));
        registro.setPeriodo(rs.getInt("PERIODO"));
        registro.setTipo(rs.getString("TIPO"));
        registro.setVdcodigo(rs.getInt("VDCODIGO"));
        registro.setFpcodigo(rs.getInt("FPCODIGO"));
        registro.setSeqespec(rs.getInt("SEQESPEC"));
        registro.setEsppgecf(rs.getString("ESPPGECF"));
        registro.setLacodigo(rs.getInt("LACODIGO"));
        registro.setFucodigo(rs.getInt("FUCODIGO"));
        registro.setPlcodigo(rs.getString("PLCODIGO"));
        registro.setValor(rs.getDouble("VALOR"));
        registro.setFormpgto(rs.getString("FORMPGTO"));
        registro.setNumparce(rs.getInt("NUMPARCE"));
        registro.setDatacomp(rs.getDate("DATACOMP"));
        registro.setHoracomp(rs.getString("HORACOMP"));
        registro.setSetoruso(rs.getString("SETORUSO"));
        registro.setDtcodigo(rs.getInt("DTCODIGO"));
        registro.setAutoritransacao(rs.getString("AUTORITRANSACAO"));
        registro.setBandeira(rs.getString("BANDEIRA"));
        registro.setTipopagamento(rs.getString("TIPOPAGAMENTO"));
        registro.setTipofinanciamen(rs.getString("TIPOFINANCIAMEN"));
        registro.setTefservidor(rs.getString("TEFSERVIDOR"));
        registro.setTefvlrtrefet(rs.getDouble("TEFVLRTREFET"));
        registro.setTefvlrtrefea(rs.getDouble("TEFVLRTREFEA"));
        registro.setTefidentific(rs.getString("TEFIDENTIFIC"));
        registro.setTefdadosfina(rs.getString("TEFDADOSFINA"));
        registro.setTefredeautor(rs.getString("TEFREDEAUTOR"));
        registro.setTeftiptrrede(rs.getString("TEFTIPTRREDE"));
        registro.setTefnutrannsu(rs.getString("TEFNUTRANNSU"));
        registro.setTefcodauttra(rs.getString("TEFCODAUTTRA"));
        registro.setTeftxvlrtran(rs.getString("TEFTXVLRTRAN"));
        registro.setTefdatatrans(rs.getString("TEFDATATRANS"));
        registro.setTefhoratrans(rs.getString("TEFHORATRANS"));
        registro.setTefcodmodpgt(rs.getString("TEFCODMODPGT"));
        registro.setTeftxmodapgt(rs.getString("TEFTXMODAPGT"));
        registro.setTeftxmopgcup(rs.getString("TEFTXMOPGCUP"));
        registro.setTefnsusitef(rs.getString("TEFNSUSITEF"));
        registro.setTefbimcartao(rs.getString("TEFBIMCARTAO"));
        registro.setTefnuparcela(rs.getString("TEFNUPARCELA"));
        registro.setTefdtpredata(rs.getString("TEFDTPREDATA"));
        registro.setTefnomeopcel(rs.getString("TEFNOMEOPCEL"));
        registro.setTefvlrrecarg(rs.getString("TEFVLRRECARG"));
        registro.setTefdddnumcel(rs.getString("TEFDDDNUMCEL"));
        registro.setTefdigiverif(rs.getString("TEFDIGIVERIF"));
        registro.setTefceplteope(rs.getString("TEFCEPLTEOPE"));
        registro.setTefnsustprca(rs.getString("TEFNSUSTPRCA"));
        registro.setTefnsuhatprc(rs.getString("TEFNSUHATPRC"));
        registro.setTefcofiatrce(rs.getString("TEFCOFIATRCE"));
        registro.setTefnumparcel(rs.getString("TEFNUMPARCEL"));
        registro.setTefnumterlog(rs.getString("TEFNUMTERLOG"));
        registro.setTefcodafilia(rs.getString("TEFCODAFILIA"));
        registro.setFlagtrans(rs.getString("FLAGTRANS"));
        registro.setFlagtserv(rs.getString("FLAGTSERV"));
        registro.setEcfseque(rs.getString("ECFSEQUE"));
        registro.setEcfserie(rs.getString("ECFSERIE"));
        registro.setEcfmarca(rs.getString("ECFMARCA"));
        registro.setEcfmodelo(rs.getString("ECFMODELO"));
        registro.setEcftipo(rs.getString("ECFTIPO"));
        registro.setSwbversao(rs.getString("SWBVERSAO"));
        registro.setSwbdthrgr(rs.getDate("SWBDTHRGR"));
        registro.setSwbmfadic(rs.getString("SWBMFADIC"));
        registro.setCoo(rs.getInt("COO"));
        registro.setGnf(rs.getInt("GNF"));
        registro.setCcf(rs.getInt("CCF"));
        registro.setGrg(rs.getInt("GRG"));
        registro.setCer(rs.getInt("CER"));
        registro.setTpvendcart(rs.getString("TPVENDCART"));
        registro.setCadevoluc(rs.getString("CADEVOLUC"));
        registro.setDvcodigo(rs.getInt("DVCODIGO"));
        registro.setOrigem(rs.getString("ORIGEM"));
        registro.setPafhashver(rs.getString("PAFHASHVER"));
        registro.setPafhashdet(rs.getString("PAFHASHDET"));
        registro.setDatadamov(rs.getDate("DATADAMOV"));
        registro.setModelonf(rs.getString("MODELONF"));
        registro.setSerienf(rs.getString("SERIENF"));
        registro.setSubserienf(rs.getString("SUBSERIENF"));
        registro.setNumeronf(rs.getInt("NUMERONF"));

    }

}
