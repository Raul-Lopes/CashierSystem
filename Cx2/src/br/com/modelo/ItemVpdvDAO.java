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
public class ItemVpdvDAO {

    Connection conn = null;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;
    ItemVpdvBean registro;
    Conectar conectar = new Conectar();

    public ItemVpdvBean inserir(Connection pConn, String baixaEstoque, List<ItemVpdvBean> listaItem) throws SQLException, ClassNotFoundException, IOException, Exception {

        String consultaSQL = "insert into itemVpdv("
                + " CACODIGO, "
                + " VDCODIGO, "
                + " NUMITEM, "
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
                + " FLAGTSERV, "
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
                + " QTDDEVOL, "
                + " DADOMAQU, "
                + " HORAPEDI, "
                + " DESCCOMP ) "
                + " values "
                + " ( ?, ?, ?, ?, ?, ?, "
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

        for (ItemVpdvBean o : listaItem) {
            pstm = pConn.prepareStatement(consultaSQL);
            pstm.clearParameters();
            pstm.setString(1, o.getCacodigo());
            pstm.setInt(2, o.getVdcodigo());
            pstm.setInt(3, o.getNumitem());
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
            pstm.setString(17, o.getMmfcodigo());
            pstm.setString(18, o.getNome());
            pstm.setString(19, o.getUncodigo());
            pstm.setDouble(20, o.getPrecoven());
            pstm.setDouble(21, o.getMaliqicms());
            pstm.setString(22, o.getCodorige());
            pstm.setString(23, o.getMcodtrib());
            pstm.setString(24, o.getPesavel());
            pstm.setDouble(25, o.getAliqipi());
            pstm.setString(26, o.getCodextra());
            pstm.setString(27, o.getReferenci());
            pstm.setString(28, o.getGrade());
            pstm.setString(29, o.getCor());
            pstm.setString(30, o.getTamanho());
            pstm.setString(31, o.getCodintern());
            pstm.setString(32, o.getTipotribu());
            pstm.setDouble(33, o.getPrecoven1());
            pstm.setDouble(34, o.getQtdestoq());
            pstm.setString(35, o.getPathfoto());
            pstm.setString(36, o.getAgcodigo());
            pstm.setString(37, o.getExcluido());
            pstm.setString(38, o.getFlagtrans());
            pstm.setString(39, o.getFlagtserv());
            pstm.setDouble(40, o.getDeprotot());
            pstm.setDouble(41, o.getAcprotot());
            pstm.setString(42, o.getComposto());
            pstm.setString(43, o.getCacodori());
            pstm.setString(44, o.getSetorori());
            pstm.setString(45, o.getCodrecei());
            pstm.setString(46, o.getHorarece());
            pstm.setDouble(47, o.getQtdrecei());
            pstm.setString(48, o.getComandaok());
            if (o.getDatacoma() != null) {
                pstm.setDate(49, new java.sql.Date(o.getDatacoma().getTime()));
            } else {
                pstm.setNull(49, java.sql.Types.DATE);
            }
            pstm.setString(50, o.getTipofab());
            pstm.setString(51, o.getIat());
            pstm.setInt(52, o.getMesaoritr());
            pstm.setInt(53, o.getMbcodigo());
            pstm.setString(54, o.getTqcodigo());
            pstm.setString(55, o.getBmcodigo());
            pstm.setString(56, o.getBicodigo());
            pstm.setString(57, o.getDescbico());
            pstm.setDouble(58, o.getEncinici());
            pstm.setDouble(59, o.getEncfinal());
            pstm.setString(60, o.getCartaopas());
            pstm.setString(61, o.getPosimesa());
            pstm.setString(62, o.getCvcodigo());
            pstm.setString(63, o.getVaspartida());
            pstm.setString(64, o.getVasvencime());
            pstm.setString(65, o.getVastipo());
            pstm.setInt(66, o.getVasfocodig());
            pstm.setString(67, o.getVascodprod());
            pstm.setString(68, o.getVasnomecid());
            pstm.setString(69, o.getOrigem());
            pstm.setInt(70, o.getMecodigo());
            pstm.setDouble(71, o.getPrecocus());
            pstm.setDouble(72, o.getPrccumed());
            pstm.setDouble(73, o.getPrccucon());
            pstm.setDouble(74, o.getPrccumec());
            pstm.setDouble(75, o.getPrecoref());
            pstm.setString(76, o.getEcfserie());
            pstm.setInt(77, o.getNumerocoo());
            pstm.setInt(78, o.getNumcupom());
            pstm.setString(79, o.getPafindcanc());
            pstm.setString(80, o.getModelodoc());
            pstm.setString(81, o.getPafhashver());
            pstm.setString(82, o.getPafhashdet());
            pstm.setString(83, o.getCstpis());
            pstm.setDouble(84, o.getVlrbcpis());
            pstm.setDouble(85, o.getAliqpis());
            pstm.setDouble(86, o.getValorpis());
            pstm.setDouble(87, o.getVlrpisst());
            pstm.setString(88, o.getCstcofin());
            pstm.setDouble(89, o.getVlrbccfs());
            pstm.setDouble(90, o.getAliqcfs());
            pstm.setDouble(91, o.getValorcfs());
            pstm.setDouble(92, o.getVlrcfsst());
            pstm.setInt(93, o.getNumitemdav());
            pstm.setDate(94, new java.sql.Date(o.getDatadamov().getTime()));
            pstm.setString(95, o.getEcfseque());
            pstm.setString(96, o.getEcfmarca());
            pstm.setString(97, o.getEcfmodelo());
            pstm.setString(98, o.getEcftipo());
            pstm.setString(99, o.getSwbversao());
            if (o.getSwbdthrgr() != null) {
                pstm.setDate(100, new java.sql.Date(o.getSwbdthrgr().getTime()));
            } else {
                pstm.setNull(100, java.sql.Types.DATE);
            }
            pstm.setString(101, o.getSwbmfadic());
            pstm.setInt(102, o.getArcodigo());
            pstm.setDouble(103, o.getQtddevol());
            pstm.setString(104, o.getDadomaqu());
            if (o.getHorapedi() != null) {
                pstm.setDate(105, new java.sql.Date(o.getHorapedi().getTime()));
            } else {
                pstm.setNull(105, java.sql.Types.DATE);
            }
            pstm.setString(106, o.getDesccomp());
            pstm.executeUpdate();

        }

        //==========================================
        //Baixa no estoque
        //==========================================
        if (baixaEstoque.equalsIgnoreCase("S")) {

            consultaSQL = "update materPdv set QTDESTOQ = ( QTDESTOQ - ? ) where mfCodigo = ?";
            for (ItemVpdvBean o : listaItem) {
                pstm = pConn.prepareStatement(consultaSQL);
                pstm.clearParameters();
                pstm.setDouble(1, o.getQtditem());
                pstm.setString(2, o.getMfcodigo());
                pstm.executeUpdate();
            }
        }

        return null;
    }

    public ItemVpdvBean cancelarItensVenda(Connection pConn, String baixaEstoque, List<ItemVpdvBean> listaItem) throws SQLException, ClassNotFoundException, IOException, Exception {

        String consultaSQL;
        //==========================================
        //Retorno para estoque
        //==========================================
        if (baixaEstoque.equalsIgnoreCase("S")) {

            consultaSQL = "update materPdv set QTDESTOQ = ( QTDESTOQ + ? ) where mfCodigo = ?";
            for (ItemVpdvBean o : listaItem) {
                pstm = pConn.prepareStatement(consultaSQL);
                pstm.clearParameters();
                pstm.setDouble(1, o.getQtditem());
                pstm.setString(2, o.getMfcodigo());
                pstm.executeUpdate();
            }
        }

        return null;
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public ItemVpdvBean itemVpdvBean(String caCodigo, int vdCodigo, int numItem) throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = null;
        String consultaSQL = "select * from ItemVpdv "
                + " where CACODIGO = ? "
                + " and VDCODIGO   = ? "
                + " and NUMITEM    = ? ";

        try {

            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setString(1, caCodigo);
            pstm.setInt(2, vdCodigo);
            pstm.setInt(3, numItem);

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
    public List<ItemVpdvBean> listaItemVpdv(String caCodigo, Integer vdCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {

        List<ItemVpdvBean> listaItemVpdvBean = new ArrayList<ItemVpdvBean>();
        String consultaSQL = "select * from ItemVpdv "
                + " where CACODIGO = ? "
                + " and VDCODIGO = ? "
                + " order by CACODIGO, VDCODIGO, NUMITEM ";

        try {

            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setString(1, caCodigo);
            pstm.setInt(2, vdCodigo);
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                gravarNoRegistro();
                listaItemVpdvBean.add(registro);
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
        return listaItemVpdvBean;
    }

    //-------------------------------------------------------------------------------------------
    void gravarNoRegistro() throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = new ItemVpdvBean();
        registro.setCacodigo(rs.getString("CACODIGO"));
        registro.setVdcodigo(rs.getInt("VDCODIGO"));
        registro.setNumitem(rs.getInt("NUMITEM"));
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
        registro.setFlagtserv(rs.getString("FLAGTSERV"));
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
        registro.setQtddevol(rs.getDouble("QTDDEVOL"));
        registro.setDadomaqu(rs.getString("DADOMAQU"));
        registro.setHorapedi(rs.getDate("HORAPEDI"));
        registro.setDesccomp(rs.getString("DESCCOMP"));

    }

}
