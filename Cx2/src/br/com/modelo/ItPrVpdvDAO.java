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
public class ItPrVpdvDAO {

    Connection conn = null;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;
    ItPrVpdvBean registro;
    Conectar conectar = new Conectar();

    public ItPrVpdvBean inserir(Connection pConn, List<ItPrVpdvBean> listaItem) throws SQLException, ClassNotFoundException, IOException, Exception {

        if (listaItem == null || listaItem.isEmpty()) {
            return null;
        }

        //baixa de estoque
        try {
            String consultaSQL = "Insert into ItPrVpdv "
                    + " ( VDCODIGO, "
                    + " NUMITEM, "
                    + " CACODIGO, "
                    + " MFCODIGO, "
                    + " PLCODIGO, "
                    + " QTDITEM, "
                    + " VALITEM, "
                    + " FUCODIGO, "
                    + " FUCODLAN, "
                    + " FUCODDES, "
                    + " SEQTOTECF, "
                    + " ALIQICMS, "
                    + " CODTRIB, "
                    + " DESCTRIB, "
                    + " NUMDOCUM, "
                    + " PRCUNIT, "
                    + " PRECOSUBPC, "
                    + " PRECOSUBMS, "
                    + " MMFCODIGO, "
                    + " NOME, "
                    + " UNCODIGO, "
                    + " PRECOVEN, "
                    + " MALIQICMS, "
                    + " CODORIGE, "
                    + " MCODTRIB, "
                    + " PESAVEL, "
                    + " ALIQIPI, "
                    + " CODEXTRA, "
                    + " REFERENCI, "
                    + " GRADE, "
                    + " COR, "
                    + " TAMANHO, "
                    + " CODINTERN, "
                    + " TIPOTRIBU, "
                    + " PRECOVEN1, "
                    + " QTDESTOQ, "
                    + " PATHFOTO, "
                    + " AGCODIGO, "
                    + " EXCLUIDO, "
                    + " FLAGTRANS, "
                    + " DEPROTOT, "
                    + " ACPROTOT, "
                    + " COMPOSTO, "
                    + " CACODORI, "
                    + " SETORORI, "
                    + " CODRECEI, "
                    + " HORARECE, "
                    + " QTDRECEI, "
                    + " COMANDAOK, "
                    + " DATACOMA, "
                    + " TIPOFAB, "
                    + " IAT, "
                    + " MESAORITR, "
                    + " MBCODIGO, "
                    + " TQCODIGO, "
                    + " BMCODIGO, "
                    + " BICODIGO, "
                    + " DESCBICO, "
                    + " ENCINICI, "
                    + " ENCFINAL, "
                    + " CARTAOPAS, "
                    + " POSIMESA, "
                    + " CVCODIGO, "
                    + " VASPARTIDA, "
                    + " VASVENCIME, "
                    + " VASTIPO, "
                    + " VASFOCODIG, "
                    + " VASCODPROD, "
                    + " VASNOMECID, "
                    + " ORIGEM, "
                    + " MECODIGO, "
                    + " PRECOCUS, "
                    + " PRCCUMED, "
                    + " PRCCUCON, "
                    + " PRCCUMEC, "
                    + " PRECOREF, "
                    + " ECFSERIE, "
                    + " NUMEROCOO, "
                    + " NUMCUPOM, "
                    + " PAFINDCANC, "
                    + " MODELODOC, "
                    + " PAFHASHVER, "
                    + " PAFHASHDET, "
                    + " CSTPIS, "
                    + " VLRBCPIS, "
                    + " ALIQPIS, "
                    + " VALORPIS, "
                    + " VLRPISST, "
                    + " CSTCOFIN, "
                    + " VLRBCCFS, "
                    + " ALIQCFS, "
                    + " VALORCFS, "
                    + " VLRCFSST, "
                    + " NUMITEMDAV, "
                    + " DATADAMOV, "
                    + " ECFSEQUE, "
                    + " ECFMARCA, "
                    + " ECFMODELO, "
                    + " ECFTIPO, "
                    + " SWBVERSAO, "
                    + " SWBDTHRGR, "
                    + " SWBMFADIC, "
                    + " ARCODIGO, "
                    + " DADOMAQU, "
                    + " HORAPEDI, "
                    + " DESCCOMP, "
                    + " QTDMEDSOLIC, "
                    + " QTDMEDAUTOR, "
                    + " STSPROC, "
                    + " MSGPROC ) "
                    + " values ( "
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

            for (ItPrVpdvBean o : listaItem) {

                pstm = pConn.prepareStatement(consultaSQL);
                pstm.setInt(1, o.getVdcodigo());
                pstm.setInt(2, o.getNumitem());
                pstm.setString(3, o.getCacodigo());
                pstm.setString(4, o.getMfcodigo());
                pstm.setString(5, o.getPlcodigo());
                pstm.setDouble(6, o.getQtditem());
                pstm.setDouble(7, o.getValitem());
                pstm.setInt(8, o.getFucodigo());
                pstm.setInt(9, o.getFucodlan());
                pstm.setInt(10, o.getFucoddes());
                pstm.setString(11, o.getSeqtotecf());
                pstm.setDouble(12, o.getAliqicms());
                pstm.setString(13, o.getCodtrib());
                pstm.setString(14, o.getDesctrib());
                pstm.setString(15, o.getNumdocum());
                pstm.setDouble(16, o.getPrcunit());
                pstm.setDouble(17, o.getPrecosubpc());
                pstm.setDouble(18, o.getPrecosubms());
                pstm.setString(19, o.getMmfcodigo());
                pstm.setString(20, o.getNome());
                pstm.setString(21, o.getUncodigo());
                pstm.setDouble(22, o.getPrecoven());
                pstm.setDouble(23, o.getMaliqicms());
                pstm.setString(24, o.getCodorige());
                pstm.setString(25, o.getMcodtrib());
                pstm.setString(26, o.getPesavel());
                pstm.setDouble(27, o.getAliqipi());
                pstm.setString(28, o.getCodextra());
                pstm.setString(29, o.getReferenci());
                pstm.setString(30, o.getGrade());
                pstm.setString(31, o.getCor());
                pstm.setString(32, o.getTamanho());
                pstm.setString(33, o.getCodintern());
                pstm.setString(34, o.getTipotribu());
                pstm.setDouble(35, o.getPrecoven1());
                pstm.setDouble(36, o.getQtdestoq());
                pstm.setString(37, o.getPathfoto());
                pstm.setString(38, o.getAgcodigo());
                pstm.setString(39, o.getExcluido());
                pstm.setString(40, o.getFlagtrans());
                pstm.setDouble(41, o.getDeprotot());
                pstm.setDouble(42, o.getAcprotot());
                pstm.setString(43, o.getComposto());
                pstm.setString(44, o.getCacodori());
                pstm.setString(45, o.getSetorori());
                pstm.setString(46, o.getCodrecei());
                pstm.setString(47, o.getHorarece());
                pstm.setDouble(48, o.getQtdrecei());
                pstm.setString(49, o.getComandaok());

                if (o.getDatacoma() != null) {
                    pstm.setDate(50, new java.sql.Date(o.getDatacoma().getTime()));
                } else {
                    pstm.setNull(50, java.sql.Types.DATE);
                }

                pstm.setString(51, o.getTipofab());
                pstm.setString(52, o.getIat());
                pstm.setInt(53, o.getMesaoritr());
                pstm.setInt(54, o.getMbcodigo());
                pstm.setString(55, o.getTqcodigo());
                pstm.setString(56, o.getBmcodigo());
                pstm.setString(57, o.getBicodigo());
                pstm.setString(58, o.getDescbico());
                pstm.setDouble(59, o.getEncinici());
                pstm.setDouble(60, o.getEncfinal());
                pstm.setString(61, o.getCartaopas());
                pstm.setString(62, o.getPosimesa());
                pstm.setString(63, o.getCvcodigo());
                pstm.setString(64, o.getVaspartida());
                pstm.setString(65, o.getVasvencime());
                pstm.setString(66, o.getVastipo());
                pstm.setInt(67, o.getVasfocodig());
                pstm.setString(68, o.getVascodprod());
                pstm.setString(69, o.getVasnomecid());
                pstm.setString(70, o.getOrigem());
                pstm.setInt(71, o.getMecodigo());
                pstm.setDouble(72, o.getPrecocus());
                pstm.setDouble(73, o.getPrccumed());
                pstm.setDouble(74, o.getPrccucon());
                pstm.setDouble(75, o.getPrccumec());
                pstm.setDouble(76, o.getPrecoref());
                pstm.setString(77, o.getEcfserie());
                pstm.setInt(78, o.getNumerocoo());
                pstm.setInt(79, o.getNumcupom());
                pstm.setString(80, o.getPafindcanc());
                pstm.setString(81, o.getModelodoc());
                pstm.setString(82, o.getPafhashver());
                pstm.setString(83, o.getPafhashdet());
                pstm.setString(84, o.getCstpis());
                pstm.setDouble(85, o.getVlrbcpis());
                pstm.setDouble(86, o.getAliqpis());
                pstm.setDouble(87, o.getValorpis());
                pstm.setDouble(88, o.getVlrpisst());
                pstm.setString(89, o.getCstcofin());
                pstm.setDouble(90, o.getVlrbccfs());
                pstm.setDouble(91, o.getAliqcfs());
                pstm.setDouble(92, o.getValorcfs());
                pstm.setDouble(93, o.getVlrcfsst());
                pstm.setInt(94, o.getNumitemdav());
                if (o.getDatadamov() != null) {
                    pstm.setDate(95, new java.sql.Date(o.getDatadamov().getTime()));
                } else {
                    pstm.setNull(95, java.sql.Types.DATE);
                }

                pstm.setString(96, o.getEcfseque());
                pstm.setString(97, o.getEcfmarca());
                pstm.setString(98, o.getEcfmodelo());
                pstm.setString(99, o.getEcftipo());
                pstm.setString(100, o.getSwbversao());
                if (o.getSwbdthrgr() != null) {
                    pstm.setDate(101, new java.sql.Date(o.getSwbdthrgr().getTime()));
                } else {
                    pstm.setNull(101, java.sql.Types.DATE);
                }

                pstm.setString(102, o.getSwbmfadic());
                pstm.setInt(103, o.getArcodigo());
                pstm.setString(104, o.getDadomaqu());
                if (o.getHorapedi() != null) {
                    pstm.setDate(105, new java.sql.Date(o.getHorapedi().getTime()));
                } else {
                    pstm.setNull(105, java.sql.Types.DATE);
                }
                pstm.setString(106, o.getDesccomp());
                pstm.setDouble(107, o.getQtdmedsolic());
                pstm.setDouble(108, o.getQtdmedautor());
                pstm.setString(109, o.getStsproc());
                pstm.setString(110, o.getMsgproc());
                pstm.executeUpdate();
            }

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
                    //pConn.rollback();
                }
//                if (pConn != null && !conn.isClosed()) {
//                    pConn.close();
//                }
            } catch (Exception ex) {
                Loggin.logDiarioExcecao(ex, true);
            }
        }
        return null;
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public ItPrVpdvBean itPrVpdv(int vdCodigo, int numItem) throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = null;
        String consultaSQL = "select * from ItPrVpdv "
                + " where VDCODIGO = ? "
                + " and NUMITEM = ? ";

        try {

            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setInt(1, vdCodigo);
            pstm.setInt(2, numItem);
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

    //-----------------------------------------------------------------------------------------------------------------------------
    public List<ItPrVpdvBean> listarItPrVpdv(String plCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {

        List<ItPrVpdvBean> listaItPrVpdvBean = null;
        String consultaSQL = "select * from ItPrVpdv "
                + " where PLCODIGO = ? "
                + " order by VDCODIGO, NUMITEM";

        try {
            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setString(1, plCodigo);
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                gravarNoRegistro();
                listaItPrVpdvBean.add(registro);
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
        return listaItPrVpdvBean;
    }

    //-------------------------------------------------------------------------------------------
    private void gravarNoRegistro() throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = new ItPrVpdvBean();
        registro.setVdcodigo(rs.getInt("VDCODIGO"));
        registro.setNumitem(rs.getInt("NUMITEM"));
        registro.setCacodigo(rs.getString("CACODIGO"));
        registro.setMfcodigo(rs.getString("MFCODIGO"));
        registro.setPlcodigo(rs.getString("PLCODIGO"));
        registro.setQtditem(rs.getDouble("QTDITEM"));
        registro.setValitem(rs.getDouble("VALITEM"));
        registro.setFucodigo(rs.getInt("FUCODIGO"));
        registro.setFucodlan(rs.getInt("FUCODLAN"));
        registro.setFucoddes(rs.getInt("FUCODDES"));
        registro.setSeqtotecf(rs.getString("SEQTOTECF"));
        registro.setAliqicms(rs.getDouble("ALIQICMS"));
        registro.setCodtrib(rs.getString("CODTRIB"));
        registro.setDesctrib(rs.getString("DESCTRIB"));
        registro.setNumdocum(rs.getString("NUMDOCUM"));
        registro.setPrcunit(rs.getDouble("PRCUNIT"));
        registro.setPrecosubpc(rs.getDouble("PRECOSUBPC"));
        registro.setPrecosubms(rs.getDouble("PRECOSUBMS"));
        registro.setMmfcodigo(rs.getString("MMFCODIGO"));
        registro.setNome(rs.getString("NOME"));
        registro.setUncodigo(rs.getString("UNCODIGO"));
        registro.setPrecoven(rs.getDouble("PRECOVEN"));
        registro.setMaliqicms(rs.getDouble("MALIQICMS"));
        registro.setCodorige(rs.getString("CODORIGE"));
        registro.setMcodtrib(rs.getString("MCODTRIB"));
        registro.setPesavel(rs.getString("PESAVEL"));
        registro.setAliqipi(rs.getDouble("ALIQIPI"));
        registro.setCodextra(rs.getString("CODEXTRA"));
        registro.setReferenci(rs.getString("REFERENCI"));
        registro.setGrade(rs.getString("GRADE"));
        registro.setCor(rs.getString("COR"));
        registro.setTamanho(rs.getString("TAMANHO"));
        registro.setCodintern(rs.getString("CODINTERN"));
        registro.setTipotribu(rs.getString("TIPOTRIBU"));
        registro.setPrecoven1(rs.getDouble("PRECOVEN1"));
        registro.setQtdestoq(rs.getDouble("QTDESTOQ"));
        registro.setPathfoto(rs.getString("PATHFOTO"));
        registro.setAgcodigo(rs.getString("AGCODIGO"));
        registro.setExcluido(rs.getString("EXCLUIDO"));
        registro.setFlagtrans(rs.getString("FLAGTRANS"));
        registro.setDeprotot(rs.getDouble("DEPROTOT"));
        registro.setAcprotot(rs.getDouble("ACPROTOT"));
        registro.setComposto(rs.getString("COMPOSTO"));
        registro.setCacodori(rs.getString("CACODORI"));
        registro.setSetorori(rs.getString("SETORORI"));
        registro.setCodrecei(rs.getString("CODRECEI"));
        registro.setHorarece(rs.getString("HORARECE"));
        registro.setQtdrecei(rs.getDouble("QTDRECEI"));
        registro.setComandaok(rs.getString("COMANDAOK"));
        registro.setDatacoma(rs.getDate("DATACOMA"));
        registro.setTipofab(rs.getString("TIPOFAB"));
        registro.setIat(rs.getString("IAT"));
        registro.setMesaoritr(rs.getInt("MESAORITR"));
        registro.setMbcodigo(rs.getInt("MBCODIGO"));
        registro.setTqcodigo(rs.getString("TQCODIGO"));
        registro.setBmcodigo(rs.getString("BMCODIGO"));
        registro.setBicodigo(rs.getString("BICODIGO"));
        registro.setDescbico(rs.getString("DESCBICO"));
        registro.setEncinici(rs.getDouble("ENCINICI"));
        registro.setEncfinal(rs.getDouble("ENCFINAL"));
        registro.setCartaopas(rs.getString("CARTAOPAS"));
        registro.setPosimesa(rs.getString("POSIMESA"));
        registro.setCvcodigo(rs.getString("CVCODIGO"));
        registro.setVaspartida(rs.getString("VASPARTIDA"));
        registro.setVasvencime(rs.getString("VASVENCIME"));
        registro.setVastipo(rs.getString("VASTIPO"));
        registro.setVasfocodig(rs.getInt("VASFOCODIG"));
        registro.setVascodprod(rs.getString("VASCODPROD"));
        registro.setVasnomecid(rs.getString("VASNOMECID"));
        registro.setOrigem(rs.getString("ORIGEM"));
        registro.setMecodigo(rs.getInt("MECODIGO"));
        registro.setPrecocus(rs.getDouble("PRECOCUS"));
        registro.setPrccumed(rs.getDouble("PRCCUMED"));
        registro.setPrccucon(rs.getDouble("PRCCUCON"));
        registro.setPrccumec(rs.getDouble("PRCCUMEC"));
        registro.setPrecoref(rs.getDouble("PRECOREF"));
        registro.setEcfserie(rs.getString("ECFSERIE"));
        registro.setNumerocoo(rs.getInt("NUMEROCOO"));
        registro.setNumcupom(rs.getInt("NUMCUPOM"));
        registro.setPafindcanc(rs.getString("PAFINDCANC"));
        registro.setModelodoc(rs.getString("MODELODOC"));
        registro.setPafhashver(rs.getString("PAFHASHVER"));
        registro.setPafhashdet(rs.getString("PAFHASHDET"));
        registro.setCstpis(rs.getString("CSTPIS"));
        registro.setVlrbcpis(rs.getDouble("VLRBCPIS"));
        registro.setAliqpis(rs.getDouble("ALIQPIS"));
        registro.setValorpis(rs.getDouble("VALORPIS"));
        registro.setVlrpisst(rs.getDouble("VLRPISST"));
        registro.setCstcofin(rs.getString("CSTCOFIN"));
        registro.setVlrbccfs(rs.getDouble("VLRBCCFS"));
        registro.setAliqcfs(rs.getDouble("ALIQCFS"));
        registro.setValorcfs(rs.getDouble("VALORCFS"));
        registro.setVlrcfsst(rs.getDouble("VLRCFSST"));
        registro.setNumitemdav(rs.getInt("NUMITEMDAV"));
        registro.setDatadamov(rs.getDate("DATADAMOV"));
        registro.setEcfseque(rs.getString("ECFSEQUE"));
        registro.setEcfmarca(rs.getString("ECFMARCA"));
        registro.setEcfmodelo(rs.getString("ECFMODELO"));
        registro.setEcftipo(rs.getString("ECFTIPO"));
        registro.setSwbversao(rs.getString("SWBVERSAO"));
        registro.setSwbdthrgr(rs.getDate("SWBDTHRGR"));
        registro.setSwbmfadic(rs.getString("SWBMFADIC"));
        registro.setArcodigo(rs.getInt("ARCODIGO"));
        registro.setDadomaqu(rs.getString("DADOMAQU"));
        registro.setHorapedi(rs.getDate("HORAPEDI"));
        registro.setDesccomp(rs.getString("DESCCOMP"));
        registro.setQtdmedsolic(rs.getDouble("QTDMEDSOLIC"));
        registro.setQtdmedautor(rs.getDouble("QTDMEDAUTOR"));
        registro.setStsproc(rs.getString("STSPROC"));
        registro.setMsgproc(rs.getString("MSGPROC"));

    }
}
