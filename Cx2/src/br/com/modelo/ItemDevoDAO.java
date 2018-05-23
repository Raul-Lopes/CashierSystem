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
public class ItemDevoDAO {

    private Connection conn = null;
    private Statement stm;
    private PreparedStatement pstm;
    private ResultSet rs;
    private ItemDevoBean registro;
    private final Conectar conectar = new Conectar();

    public ItemVpdvBean inserir(Connection pConn, String retornarEstoque, List<ItemDevoBean> listaItem) throws SQLException, ClassNotFoundException, IOException, Exception {

        String consultaSQL = "insert into ITEMDEVO( "
                + " CACODIGO, "
                + " DVCODIGO, "
                + " NUMITEM, "
                + " MFCODIGO, "
                + " PLCODIGO, "
                + " QTDITEM, "
                + " VALITEM, "
                + " FUCODIGO, "
                + " FUCODLAN, "
                + " ALIQICMS, "
                + " CODTRIB, "
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
                + " TIPOFAB, "
                + " IAT, "
                + " CACODCUP, "
                + " VDCODIGO, "
                + " ITEMVEND, "
                + " DATAHORACUP, "
                + " DATACUP, "
                + " NUMCUPOM, "
                + " NUMCOOCUP, "
                + " DTMOVCUP, "
                + " ECFSERIEVND ) "
                + " values ("
                + " ?, ?, ?, ?, ?, "
                + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
                + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
                + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
                + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
                + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) ";

        for (ItemDevoBean o : listaItem) {

            pstm = pConn.prepareStatement(consultaSQL);
            pstm.clearParameters();

            pstm.setString(1, o.getCacodigo());
            pstm.setInt(2, o.getDvcodigo());
            pstm.setInt(3, o.getNumitem());
            pstm.setString(4, o.getMfcodigo());
            pstm.setString(5, o.getPlcodigo());
            pstm.setDouble(6, o.getQtditem());
            pstm.setDouble(7, o.getValitem());
            pstm.setInt(8, o.getFucodigo());
            pstm.setInt(9, o.getFucodlan());
            pstm.setDouble(10, o.getAliqicms());
            pstm.setString(11, o.getCodtrib());
            pstm.setString(12, o.getNumdocum());
            pstm.setDouble(13, o.getPrcunit());
            pstm.setString(14, o.getMmfcodigo());
            pstm.setString(15, o.getNome());
            pstm.setString(16, o.getUncodigo());
            pstm.setDouble(17, o.getPrecoven());
            pstm.setDouble(18, o.getMaliqicms());
            pstm.setString(19, o.getCodorige());
            pstm.setString(20, o.getMcodtrib());
            pstm.setString(21, o.getPesavel());
            pstm.setDouble(22, o.getAliqipi());
            pstm.setString(23, o.getCodextra());
            pstm.setString(24, o.getReferenci());
            pstm.setString(25, o.getGrade());
            pstm.setString(26, o.getCor());
            pstm.setString(27, o.getTamanho());
            pstm.setString(28, o.getCodintern());
            pstm.setString(29, o.getTipotribu());
            pstm.setDouble(30, o.getPrecoven1());
            pstm.setDouble(31, o.getQtdestoq());
            pstm.setString(32, o.getPathfoto());
            pstm.setString(33, o.getAgcodigo());
            pstm.setString(34, o.getExcluido());
            pstm.setString(35, o.getFlagtrans());
            pstm.setString(36, o.getFlagtserv());
            pstm.setDouble(37, o.getDeprotot());
            pstm.setDouble(38, o.getAcprotot());
            pstm.setString(39, o.getComposto());
            pstm.setString(40, o.getCacodori());
            pstm.setString(41, o.getSetorori());
            pstm.setString(42, o.getCodrecei());
            pstm.setString(43, o.getHorarece());
            pstm.setDouble(44, o.getQtdrecei());
            pstm.setString(45, o.getTipofab());
            pstm.setString(46, o.getIat());
            pstm.setString(47, o.getCacodcup());

            if (o.getVdcodigo() != null) {
                pstm.setInt(48, o.getVdcodigo());
            } else {
                pstm.setNull(48, java.sql.Types.INTEGER);
            }

            pstm.setInt(49, o.getItemvend());
            pstm.setDate(50, new java.sql.Date(o.getDatahoracup().getTime()));
            pstm.setDate(51, new java.sql.Date(o.getDatacup().getTime()));
            pstm.setInt(52, o.getNumcupom());
            pstm.setInt(53, o.getNumcoocup());
            pstm.setDate(54, new java.sql.Date(o.getDtmovcup().getTime()));
            pstm.setString(55, o.getEcfserievnd());

            pstm.executeUpdate();
        }
            //==========================================
        //Baixa no estoque
        //==========================================
        if (retornarEstoque.equalsIgnoreCase("S")) {

            consultaSQL = "update materPdv set QTDESTOQ = ( QTDESTOQ + ? ) where mfCodigo = ?";
            for (ItemDevoBean o : listaItem) {
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
    public ItemDevoBean itemDevo(String caCodigo, Integer dvCodigo, Integer numItem) throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = null;
        String consultaSQL = "select * from ITEMDEVO "
                + " where CACODIGO = ? "
                + " and DVCODIGO = ? "
                + " and NUMITEM = ? ";

        try {

            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setString(1, caCodigo);
            pstm.setInt(2, dvCodigo);
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
    public List<ItemDevoBean> listarItemDevo() throws SQLException, ClassNotFoundException, IOException, Exception {

        List<ItemDevoBean> listaItemDevoBean = null;
        String consultaSQL = "select * from ITEMDEVO ";

        try {
            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                gravarNoRegistro();
                listaItemDevoBean.add(registro);
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
        return listaItemDevoBean;
    }

    //-------------------------------------------------------------------------------------------
    private void gravarNoRegistro() throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = new ItemDevoBean();
        registro.setCacodigo(rs.getString("CACODIGO"));
        registro.setDvcodigo(rs.getInt("DVCODIGO"));
        registro.setNumitem(rs.getInt("NUMITEM"));
        registro.setMfcodigo(rs.getString("MFCODIGO"));
        registro.setPlcodigo(rs.getString("PLCODIGO"));
        registro.setQtditem(rs.getDouble("QTDITEM"));
        registro.setValitem(rs.getDouble("VALITEM"));
        registro.setFucodigo(rs.getInt("FUCODIGO"));
        registro.setFucodlan(rs.getInt("FUCODLAN"));
        registro.setAliqicms(rs.getDouble("ALIQICMS"));
        registro.setCodtrib(rs.getString("CODTRIB"));
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
        registro.setTipofab(rs.getString("TIPOFAB"));
        registro.setIat(rs.getString("IAT"));
        registro.setCacodcup(rs.getString("CACODCUP"));
        registro.setVdcodigo(rs.getInt("VDCODIGO"));
        registro.setItemvend(rs.getInt("ITEMVEND"));
        registro.setDatahoracup(rs.getDate("DATAHORACUP"));
        registro.setDatacup(rs.getDate("DATACUP"));
        registro.setNumcupom(rs.getInt("NUMCUPOM"));
        registro.setNumcoocup(rs.getInt("NUMCOOCUP"));
        registro.setDtmovcup(rs.getDate("DTMOVCUP"));
        registro.setEcfserievnd(rs.getString("ECFSERIEVND"));

    }

}
