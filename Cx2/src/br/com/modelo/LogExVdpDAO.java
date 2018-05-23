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
public class LogExVdpDAO {

    private Connection conn = null;
    private Statement stm;
    private PreparedStatement pstm;
    private ResultSet rs;
    private LogExVdpBean registro;
    private final Conectar conectar = new Conectar();

    public LogExVdpBean inserir(Connection pConn, LogExVdpBean o) throws SQLException, ClassNotFoundException, IOException, Exception {

        String consultaSQL = "insert into LogExVdp( "
                + " LPCODIGO, "
                + " CACODIGO, "
                + " DATA, "
                + " HORARIO, "
                + " VENDEDOR, "
                + " MSCODIGO, "
                + " MECODIGO, "
                + " FUCODIGO, "
                + " FUCODLAN, "
                + " FUCODDES, "
                + " PERIODO, "
                + " MFCODIGO, "
                + " PLCODIGO, "
                + " QTDITEM, "
                + " VALITEM, "
                + " PRCUNIT, "
                + " UNCODIGO, "
                + " TIPO, "
                + " DESCTRIB, "
                + " NUMCUPOM, "
                + " NUMEROCOO, "
                + " FLAGTRANS, "
                + " FLAGTSERV, "
                + " COMPOSTO, "
                + " CACODORI, "
                + " SETORORI, "
                + " CODRECEI, "
                + " HORARECE, "
                + " QTDRECEI, "
                + " COMANDAOK, "
                + " DATACOMA, "
                + " CODAUTOR, "
                + " DATAREG, "
                + " TIPOVENDA, "
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
                + " ECFSEQUE, "
                + " ECFSERIE, "
                + " ECFMARCA, "
                + " ECFMODELO, "
                + " ECFTIPO, "
                + " SWBVERSAO, "
                + " SWBDTHRGR, "
                + " SWBMFADIC, "
                + " ORIGEM, "
                + " ALIQICMS, "
                + " VDCODIGO, "
                + " NUMITEM, "
                + " SEQTOTECF, "
                + " CODTRIB, "
                + " NUMDOCUM, "
                + " MMFCODIGO, "
                + " NOME, "
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
                + " DEPROTOT, "
                + " ACPROTOT, "
                + " PRECOCUS, "
                + " PRCCUMED, "
                + " PRCCUCON, "
                + " PRCCUMEC, "
                + " PRECOREF, "
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
                + " DADOMAQU, "
                + " HORAPEDI, "
                + " DESCCOMP ) "
                + " values ("
                + " ?, ?, ?, ?, "
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

        pstm = pConn.prepareStatement(consultaSQL);
        pstm.clearParameters();
        pstm.setInt(1, o.getLpcodigo());
        pstm.setString(2, o.getCacodigo());
        pstm.setDate(3, new java.sql.Date(o.getData().getTime()));
        pstm.setString(4, o.getHorario());
        pstm.setInt(5, o.getVendedor());
        pstm.setString(6, o.getMscodigo());
        pstm.setInt(7, o.getMecodigo());
        pstm.setInt(8, o.getFucodigo());
        pstm.setInt(9, o.getFucodlan());
        pstm.setInt(10, o.getFucoddes());
        pstm.setInt(11, o.getPeriodo());
        pstm.setString(12, o.getMfcodigo());
        pstm.setString(13, o.getPlcodigo());
        pstm.setDouble(14, o.getQtditem());
        pstm.setDouble(15, o.getValitem());
        pstm.setDouble(16, o.getPrcunit());
        pstm.setString(17, o.getUncodigo());
        pstm.setString(18, o.getTipo());
        pstm.setString(19, o.getDesctrib());
        pstm.setInt(20, o.getNumcupom());
        pstm.setInt(21, o.getNumerocoo());
        pstm.setString(22, o.getFlagtrans());
        pstm.setString(23, o.getFlagtserv());
        pstm.setString(24, o.getComposto());
        pstm.setString(25, o.getCacodori());
        pstm.setString(26, o.getSetorori());
        pstm.setString(27, o.getCodrecei());
        pstm.setString(28, o.getHorarece());
        pstm.setDouble(29, o.getQtdrecei());
        pstm.setString(30, o.getComandaok());
        if (o.getSwbdthrgr() != null) {
            pstm.setDate(31, new java.sql.Date(o.getDatacoma().getTime()));
        } else {
            pstm.setNull(31, java.sql.Types.DATE);
        }
        pstm.setInt(32, o.getCodautor());
        pstm.setDate(33, new java.sql.Date(o.getDatareg().getTime()));
        pstm.setInt(34, o.getTipovenda());
        pstm.setString(35, o.getTipofab());
        pstm.setString(36, o.getIat());
        pstm.setInt(37, o.getMesaoritr());
        pstm.setInt(38, o.getMbcodigo());
        pstm.setString(39, o.getTqcodigo());
        pstm.setString(40, o.getBmcodigo());
        pstm.setString(41, o.getBicodigo());
        pstm.setString(42, o.getDescbico());
        pstm.setDouble(43, o.getEncinici());
        pstm.setDouble(44, o.getEncfinal());
        pstm.setString(45, o.getCartaopas());
        pstm.setString(46, o.getPosimesa());
        pstm.setString(47, o.getCvcodigo());
        pstm.setString(48, o.getVaspartida());
        pstm.setString(49, o.getVasvencime());
        pstm.setString(50, o.getVastipo());
        pstm.setInt(51, o.getVasfocodig());
        pstm.setString(52, o.getVascodprod());
        pstm.setString(53, o.getVasnomecid());
        pstm.setString(54, o.getEcfseque());
        pstm.setString(55, o.getEcfserie());
        pstm.setString(56, o.getEcfmarca());
        pstm.setString(57, o.getEcfmodelo());
        pstm.setString(58, o.getEcftipo());
        pstm.setString(59, o.getSwbversao());

        if (o.getSwbdthrgr() != null) {
            pstm.setDate(60, new java.sql.Date(o.getSwbdthrgr().getTime()));
        } else {
            pstm.setNull(60, java.sql.Types.DATE);
        }

        pstm.setString(61, o.getSwbmfadic());
        pstm.setString(62, o.getOrigem());
        pstm.setDouble(63, o.getAliqicms());
        pstm.setInt(64, o.getVdcodigo());
        pstm.setInt(65, o.getNumitem());
        pstm.setString(66, o.getSeqtotecf());
        pstm.setString(67, o.getCodtrib());
        pstm.setString(68, o.getNumdocum());
        pstm.setString(69, o.getMmfcodigo());
        pstm.setString(70, o.getNome());
        pstm.setDouble(71, o.getPrecoven());
        pstm.setDouble(72, o.getMaliqicms());
        pstm.setString(73, o.getCodorige());
        pstm.setString(74, o.getMcodtrib());
        pstm.setString(75, o.getPesavel());
        pstm.setDouble(76, o.getAliqipi());
        pstm.setString(77, o.getCodextra());
        pstm.setString(78, o.getReferenci());
        pstm.setString(79, o.getGrade());
        pstm.setString(80, o.getCor());
        pstm.setString(81, o.getTamanho());
        pstm.setString(82, o.getCodintern());
        pstm.setString(83, o.getTipotribu());
        pstm.setDouble(84, o.getPrecoven1());
        pstm.setDouble(85, o.getQtdestoq());
        pstm.setString(86, o.getPathfoto());
        pstm.setString(87, o.getAgcodigo());
        pstm.setString(88, o.getExcluido());
        pstm.setDouble(89, o.getDeprotot());
        pstm.setDouble(90, o.getAcprotot());
        pstm.setDouble(91, o.getPrecocus());
        pstm.setDouble(92, o.getPrccumed());
        pstm.setDouble(93, o.getPrccucon());
        pstm.setDouble(94, o.getPrccumec());
        pstm.setDouble(95, o.getPrecoref());
        pstm.setString(96, o.getPafindcanc());
        pstm.setString(97, o.getModelodoc());
        pstm.setString(98, o.getPafhashver());
        pstm.setString(99, o.getPafhashdet());
        pstm.setString(100, o.getCstpis());
        pstm.setDouble(101, o.getVlrbcpis());
        pstm.setDouble(102, o.getAliqpis());
        pstm.setDouble(103, o.getValorpis());
        pstm.setDouble(104, o.getVlrpisst());
        pstm.setString(105, o.getCstcofin());
        pstm.setDouble(106, o.getVlrbccfs());
        pstm.setDouble(107, o.getAliqcfs());
        pstm.setDouble(108, o.getValorcfs());
        pstm.setDouble(109, o.getVlrcfsst());
        pstm.setInt(110, o.getNumitemdav());
        pstm.setDate(111, new java.sql.Date(o.getDatadamov().getTime()));
        pstm.setString(112, o.getDadomaqu());
        pstm.setDate(113, new java.sql.Date(o.getHorapedi().getTime()));
        pstm.setString(114, o.getDesccomp());
        pstm.executeUpdate();
        return null;
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public LogExVdpBean LogExVdp(Integer lpCodigo, String caCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = null;
        String consultaSQL = "select * from LogExVdp "
                + " where LPCODIGO = ? "
                + " and CACODIGO = ? ";
        try {

            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setInt(1, lpCodigo);
            pstm.setString(1, caCodigo);
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
    public List<LogExVdpBean> listarLogExVdp() throws SQLException, ClassNotFoundException, IOException, Exception {

        List<LogExVdpBean> listaLogExVdpBean = null;
        String consultaSQL = "select * from LogExVdp";

        try {
            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                gravarNoRegistro();
                listaLogExVdpBean.add(registro);
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
        return listaLogExVdpBean;
    }

    //---------------------------------------------------------------------------------------------------
    private void gravarNoRegistro() throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = new LogExVdpBean();
        registro.setLpcodigo(rs.getInt("LPCODIGO"));
        registro.setCacodigo(rs.getString("CACODIGO"));
        registro.setData(rs.getDate("DATA"));
        registro.setHorario(rs.getString("HORARIO"));
        registro.setVendedor(rs.getInt("VENDEDOR"));
        registro.setMscodigo(rs.getString("MSCODIGO"));
        registro.setMecodigo(rs.getInt("MECODIGO"));
        registro.setFucodigo(rs.getInt("FUCODIGO"));
        registro.setFucodlan(rs.getInt("FUCODLAN"));
        registro.setFucoddes(rs.getInt("FUCODDES"));
        registro.setPeriodo(rs.getInt("PERIODO"));
        registro.setMfcodigo(rs.getString("MFCODIGO"));
        registro.setPlcodigo(rs.getString("PLCODIGO"));
        registro.setQtditem(rs.getDouble("QTDITEM"));
        registro.setValitem(rs.getDouble("VALITEM"));
        registro.setPrcunit(rs.getDouble("PRCUNIT"));
        registro.setUncodigo(rs.getString("UNCODIGO"));
        registro.setTipo(rs.getString("TIPO"));
        registro.setDesctrib(rs.getString("DESCTRIB"));
        registro.setNumcupom(rs.getInt("NUMCUPOM"));
        registro.setNumerocoo(rs.getInt("NUMEROCOO"));
        registro.setFlagtrans(rs.getString("FLAGTRANS"));
        registro.setFlagtserv(rs.getString("FLAGTSERV"));
        registro.setComposto(rs.getString("COMPOSTO"));
        registro.setCacodori(rs.getString("CACODORI"));
        registro.setSetorori(rs.getString("SETORORI"));
        registro.setCodrecei(rs.getString("CODRECEI"));
        registro.setHorarece(rs.getString("HORARECE"));
        registro.setQtdrecei(rs.getDouble("QTDRECEI"));
        registro.setComandaok(rs.getString("COMANDAOK"));
        registro.setDatacoma(rs.getDate("DATACOMA"));
        registro.setCodautor(rs.getInt("CODAUTOR"));
        registro.setDatareg(rs.getDate("DATAREG"));
        registro.setTipovenda(rs.getInt("TIPOVENDA"));
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
        registro.setEcfseque(rs.getString("ECFSEQUE"));
        registro.setEcfserie(rs.getString("ECFSERIE"));
        registro.setEcfmarca(rs.getString("ECFMARCA"));
        registro.setEcfmodelo(rs.getString("ECFMODELO"));
        registro.setEcftipo(rs.getString("ECFTIPO"));
        registro.setSwbversao(rs.getString("SWBVERSAO"));
        registro.setSwbdthrgr(rs.getDate("SWBDTHRGR"));
        registro.setSwbmfadic(rs.getString("SWBMFADIC"));
        registro.setOrigem(rs.getString("ORIGEM"));
        registro.setAliqicms(rs.getDouble("ALIQICMS"));
        registro.setVdcodigo(rs.getInt("VDCODIGO"));
        registro.setNumitem(rs.getInt("NUMITEM"));
        registro.setSeqtotecf(rs.getString("SEQTOTECF"));
        registro.setCodtrib(rs.getString("CODTRIB"));
        registro.setNumdocum(rs.getString("NUMDOCUM"));
        registro.setMmfcodigo(rs.getString("MMFCODIGO"));
        registro.setNome(rs.getString("NOME"));
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
        registro.setDeprotot(rs.getDouble("DEPROTOT"));
        registro.setAcprotot(rs.getDouble("ACPROTOT"));
        registro.setPrecocus(rs.getDouble("PRECOCUS"));
        registro.setPrccumed(rs.getDouble("PRCCUMED"));
        registro.setPrccucon(rs.getDouble("PRCCUCON"));
        registro.setPrccumec(rs.getDouble("PRCCUMEC"));
        registro.setPrecoref(rs.getDouble("PRECOREF"));
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
        registro.setDadomaqu(rs.getString("DADOMAQU"));
        registro.setHorapedi(rs.getDate("HORAPEDI"));
        registro.setDesccomp(rs.getString("DESCCOMP"));

    }
}
