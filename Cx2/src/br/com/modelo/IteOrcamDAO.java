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
 * @author Raul
 */
public class IteOrcamDAO {

    private Connection conn = null;
    private Statement stm;
    private PreparedStatement pstm;
    private ResultSet rs;
    private IteOrcamBean registro;
    private final Conectar conectar = new Conectar();

    public void inserir(Connection pConn, List<IteOrcamBean> listaIteOrcamBean) throws SQLException, ClassNotFoundException, IOException, Exception {

        //baixa de estoque
//        try {
        String consultaSQL = "insert into ITEORCAM ("
                + " ORCODIGO, "
                + " NUMITEM, "
                + " DAV, "
                + " MFCODIGO, "
                + " NOME, "
                + " UNCODIGO, "
                + " ALIQICMS, "
                + " CODTRIB, "
                + " DESCTRIB, "
                + " QTDITEM, "
                + " PRCUNIT, "
                + " VALITEM, "
                + " ALIQIPI, "
                + " QTDRET, "
                + " VALRET, "
                + " FUCODIGO, "
                + " TIPOTRIBU, "
                + " DESCONTO, "
                + " PERCDESC, "
                + " ACRESCIMO, "
                + " PERCACRES, "
                + " FLAGTRANS, "
                + " SERVMUN, "
                + " FUAUTOR, "
                + " DEPROTOT, "
                + " ACPROTOT, "
                + " EXCLUIDO, "
                + " DATAALTE, "
                + " DATAINCL, "
                + " QTDPECAS, "
                + " DIAMETRO, "
                + " OBS, "
                + " COMPRIMENTO, "
                + " HORAPEDI, "
                + " DESCCOMP, "
                + " PAFHASHVER, "
                + " PAFHASHDET "
                + ") values ("
                + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                + "?, ?, ?, ?, ?, ?, ? )";

        for (IteOrcamBean iteOrcamBean : listaIteOrcamBean) {

            pstm = pConn.prepareStatement(consultaSQL);
            pstm.setInt(1, iteOrcamBean.getOrcodigo());
            pstm.setInt(2, iteOrcamBean.getNumitem());
            pstm.setInt(3, iteOrcamBean.getDav());
            pstm.setString(4, iteOrcamBean.getMfcodigo());
            pstm.setString(5, iteOrcamBean.getNome());
            pstm.setString(6, iteOrcamBean.getUncodigo());
            pstm.setDouble(7, iteOrcamBean.getAliqicms());
            pstm.setString(8, iteOrcamBean.getCodtrib());
            pstm.setString(9, iteOrcamBean.getDesctrib());
            pstm.setDouble(10, iteOrcamBean.getQtditem());
            pstm.setDouble(11, iteOrcamBean.getPrcunit());
            pstm.setDouble(12, iteOrcamBean.getValitem());
            pstm.setDouble(13, iteOrcamBean.getAliqipi());
            pstm.setDouble(14, iteOrcamBean.getQtdret());
            pstm.setDouble(15, iteOrcamBean.getValret());
            pstm.setInt(16, iteOrcamBean.getFucodigo());
            pstm.setString(17, iteOrcamBean.getTipotribu());
            pstm.setDouble(18, iteOrcamBean.getDesconto());
            pstm.setDouble(19, iteOrcamBean.getPercdesc());
            pstm.setDouble(20, iteOrcamBean.getAcrescimo());
            pstm.setDouble(21, iteOrcamBean.getPercacres());
            pstm.setString(22, iteOrcamBean.getFlagtrans());
            pstm.setString(23, iteOrcamBean.getServmun());
            pstm.setInt(24, iteOrcamBean.getFuautor());
            pstm.setDouble(25, iteOrcamBean.getDeprotot());
            pstm.setDouble(26, iteOrcamBean.getAcprotot());
            pstm.setString(27, iteOrcamBean.getExcluido());

            if (iteOrcamBean.getDataalte() != null) {
                pstm.setDate(28, new java.sql.Date(iteOrcamBean.getDataalte().getTime()));
            } else {
                pstm.setNull(28, java.sql.Types.DATE);
            }

            if (iteOrcamBean.getDataincl() != null) {
                pstm.setDate(29, new java.sql.Date(iteOrcamBean.getDataincl().getTime()));
            } else {
                pstm.setNull(29, java.sql.Types.DATE);
            }

            pstm.setDouble(30, iteOrcamBean.getQtdpecas());
            pstm.setDouble(31, iteOrcamBean.getDiametro());

            if (iteOrcamBean.getObs() != null) {
                pstm.setBlob(32, iteOrcamBean.getObs());
            } else {
                pstm.setNull(32, java.sql.Types.BLOB);
            }

            pstm.setDouble(33, iteOrcamBean.getComprimento());
            if (iteOrcamBean.getHorapedi() != null) {
                pstm.setDate(34, new java.sql.Date(iteOrcamBean.getHorapedi().getTime()));
            } else {
                pstm.setNull(34, java.sql.Types.DATE);
            }
            pstm.setString(35, iteOrcamBean.getDesccomp());
            pstm.setString(36, iteOrcamBean.getPafhashver());
            pstm.setString(37, iteOrcamBean.getPafhashdet());
            pstm.executeUpdate();
        }
//        } finally {
//
//            //System.out.println("Closing database resources and rolling back any changes we made to the database.");
//            //Now that we're all finished, let's release database resources.
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//                if (pstm != null) {
//                    pstm.close();
//                }
//                if (pConn != null) {
//                    //pConn.rollback();
//                }
//                if (pConn != null && !conn.isClosed()) {
//                    pConn.close();
//                }
//            } catch (java.sql.SQLException e) {
//                e.printStackTrace();
//            }
//        }
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public IteOrcamBean IteOrcam(int orcodigo, int numItem) throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = null;
        String consultaSQL = "select * from ITEORCAM where ORCODIGO = ? and NUMITEM = ? ";

        try {

            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setInt(1, orcodigo);
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

    //--------------------------------------------------------------------------------------------------------------
    public List<IteOrcamBean> listarIteOrcam(int orcodigo) throws SQLException, ClassNotFoundException, IOException, Exception {

        List<IteOrcamBean> listaIteOrcamBean = new ArrayList<IteOrcamBean>();
        String consultaSQL = "select * from ITEORCAM "
                + " where ORCODIGO = ? "
                + " order by NOME";

        try {
            
            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setInt(1, orcodigo);
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                gravarNoRegistro();
                listaIteOrcamBean.add(registro);
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
        return listaIteOrcamBean;
    }

    //---------------------------------------------------------------------------------------------------
    private void gravarNoRegistro() throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = new IteOrcamBean();
        registro.setOrcodigo(rs.getInt("ORCODIGO"));
        registro.setNumitem(rs.getInt("NUMITEM"));
        registro.setDav(rs.getInt("DAV"));
        registro.setMfcodigo(rs.getString("MFCODIGO"));
        registro.setNome(rs.getString("NOME"));
        registro.setUncodigo(rs.getString("UNCODIGO"));
        registro.setAliqicms(rs.getDouble("ALIQICMS"));
        registro.setCodtrib(rs.getString("CODTRIB"));
        registro.setDesctrib(rs.getString("DESCTRIB"));
        registro.setQtditem(rs.getDouble("QTDITEM"));
        registro.setPrcunit(rs.getDouble("PRCUNIT"));
        registro.setValitem(rs.getDouble("VALITEM"));
        registro.setAliqipi(rs.getDouble("ALIQIPI"));
        registro.setQtdret(rs.getDouble("QTDRET"));
        registro.setValret(rs.getDouble("VALRET"));
        registro.setFucodigo(rs.getInt("FUCODIGO"));
        registro.setTipotribu(rs.getString("TIPOTRIBU"));
        registro.setDesconto(rs.getDouble("DESCONTO"));
        registro.setPercdesc(rs.getDouble("PERCDESC"));
        registro.setAcrescimo(rs.getDouble("ACRESCIMO"));
        registro.setPercacres(rs.getDouble("PERCACRES"));
        registro.setFlagtrans(rs.getString("FLAGTRANS"));
        registro.setServmun(rs.getString("SERVMUN"));
        registro.setFuautor(rs.getInt("FUAUTOR"));
        registro.setDeprotot(rs.getDouble("DEPROTOT"));
        registro.setAcprotot(rs.getDouble("ACPROTOT"));
        registro.setExcluido(rs.getString("EXCLUIDO"));
        registro.setDataalte(rs.getDate("DATAALTE"));
        registro.setDataincl(rs.getDate("DATAINCL"));
        registro.setQtdpecas(rs.getDouble("QTDPECAS"));
        registro.setDiametro(rs.getDouble("DIAMETRO"));
        registro.setObs(rs.getBlob("OBS"));
        registro.setComprimento(rs.getDouble("COMPRIMENTO"));
        registro.setHorapedi(rs.getDate("HORAPEDI"));
        registro.setDesccomp(rs.getString("DESCCOMP"));
        registro.setPafhashver(rs.getString("PAFHASHVER"));
        registro.setPafhashdet(rs.getString("PAFHASHDET"));

    }
}
