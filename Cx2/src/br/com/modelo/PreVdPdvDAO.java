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
public class PreVdPdvDAO {

    private Connection conn = null;
    private Statement stm;
    private PreparedStatement pstm;
    private ResultSet rs;
    private PreVdPdvBean registro;
    private ItPrVpdvDAO itPrVpdvDAO = new ItPrVpdvDAO();
    private final Conectar conectar = new Conectar();

    public PreVdPdvBean emitirCupom(PreVdPdvBean o, List<ItPrVpdvBean> listaItPrVpdvBean) throws SQLException, ClassNotFoundException, IOException, Exception {
        try {
            conn = conectar.conectar();
            conn.setAutoCommit(false);

            //******************************************************
            //pre-venda
            //******************************************************
            inserir(conn, o);
            //itens da pre-venda
            itPrVpdvDAO.inserir(conn, listaItPrVpdvBean);

            conn.commit();
            conn.setAutoCommit(true);
        } catch (Exception ex) {
            Loggin.logDiarioExcecao(ex, true);

        } finally {

            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (Exception ex) {
                Loggin.logDiarioExcecao(ex, true);
            }

        }

        return null;
    }

    public PreVdPdvBean inserir(Connection pConn, PreVdPdvBean o) throws SQLException, ClassNotFoundException, IOException, Exception {

        if (o == null) {
            return null;
        }
        try {
            //baixa de estoque
            String consultaSQL = "insert into PreVdPdv ( "
                    + " VDCODIGO, "
                    + " CACODIGO, "
                    + " SITUACAO, "
                    + " STSPROC, "
                    + " CODSOLICITFARMA, "
                    + " NUMAUTORIZACAO, "
                    + " MSGPROC, "
                    + " VDACACOD, "
                    + " VDAVDCOD, "
                    + " CAFECHPRE, "
                    + " NUMERONF, "
                    + " SERIENF, "
                    + " PRECANC, "
                    + " DATAHORACUP, "
                    + " DATA, "
                    + " VENDEDOR, "
                    + " CLCODIGO, "
                    + " NOMECLIE, "
                    + " CGCCLIE, "
                    + " CPFCLIE, "
                    + " LIMCREBAI, "
                    + " LIMCRESEC, "
                    + " CODINTERN, "
                    + " DESCONTO, "
                    + " ACRESCIMO, "
                    + " VALVENDA, "
                    + " EQUIPAME, "
                    + " MSCODIGO, "
                    + " MECODIGO, "
                    + " DATAAMESA, "
                    + " CONFECFSER, "
                    + " CONFEECF, "
                    + " CONFECOO, "
                    + " CONFECER, "
                    + " FUCODIGO, "
                    + " PERIODO, "
                    + " HORARIO, "
                    + " ECFSEQUE, "
                    + " ECFSERIE, "
                    + " ECFMARCA, "
                    + " ECFMODELO, "
                    + " ECFTIPO, "
                    + " SWBVERSAO, "
                    + " SWBDTHRGR, "
                    + " SWBMFADIC, "
                    + " NUMCUPOM, "
                    + " QTDPESSOA, "
                    + " QTDCUPENT, "
                    + " HORAINIC, "
                    + " HORAPAGT, "
                    + " DAV, "
                    + " NUMORCAM, "
                    + " NOME, "
                    + " ENDERECO, "
                    + " TELEFONE, "
                    + " DOCUMENTO, "
                    + " NUMEROCOO, "
                    + " OBS1, "
                    + " OBS2, "
                    + " OBS3, "
                    + " OBS4, "
                    + " OBS5, "
                    + " OBS6, "
                    + " OBS7, "
                    + " OBS8, "
                    + " KM, "
                    + " PLACA, "
                    + " BAIXAESTO, "
                    + " CLCODPAI, "
                    + " FLAGTRANS, "
                    + " FICODIGO, "
                    + " SETORUSO, "
                    + " FACODIGO, "
                    + " CENTCUSTO, "
                    + " PASEMBARQUE, "
                    + " PASDESTINO, "
                    + " PASLINHA, "
                    + " PASAGENCIA, "
                    + " PASDATA, "
                    + " PASHORA, "
                    + " PASPOLTRONA, "
                    + " PASPLATAFORMA, "
                    + " PASTIPOPASSAGEM, "
                    + " PASRG, "
                    + " PASNOME, "
                    + " PASENDERECO, "
                    + " PASUFDESTINO, "
                    + " PASPERCURSO, "
                    + " PASTPVENDA, "
                    + " PASCODARD, "
                    + " CODAUTOEXT, "
                    + " ORIGEM, "
                    + " MULTMESAS, "
                    + " PAFINDCANC, "
                    + " MODELODOC, "
                    + " PAFHASHVER, "
                    + " PAFHASHCAP, "
                    + " VLRBCPIS, "
                    + " VALORPIS, "
                    + " VLRPISST, "
                    + " VLRBCCFS, "
                    + " VALORCFS, "
                    + " VLRCFSST, "
                    + " DATADAMOV ) "
                    + " values( "
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
            pstm.setInt(1, o.getVdcodigo());
            pstm.setString(2, o.getCacodigo());
            pstm.setString(3, o.getSituacao());
            pstm.setString(4, o.getStsproc());
            pstm.setString(5, o.getCodsolicitfarma());
            pstm.setString(6, o.getNumautorizacao());
            pstm.setString(7, o.getMsgproc());
            pstm.setString(8, o.getVdacacod());
            pstm.setInt(9, o.getVdavdcod());
            pstm.setString(10, o.getCafechpre());
            pstm.setInt(11, o.getNumeronf());
            pstm.setString(12, o.getSerienf());
            pstm.setString(13, o.getPrecanc());
            pstm.setDate(14, new java.sql.Date(o.getDatahoracup().getTime()));
            pstm.setDate(15, new java.sql.Date(o.getData().getTime()));
            pstm.setInt(16, o.getVendedor());
            pstm.setInt(17, o.getClcodigo());
            pstm.setString(18, o.getNomeclie());
            pstm.setString(19, o.getCgcclie());
            pstm.setString(20, o.getCpfclie());
            pstm.setDouble(21, o.getLimcrebai());
            pstm.setDouble(22, o.getLimcresec());
            pstm.setString(23, o.getCodintern());
            pstm.setDouble(24, o.getDesconto());
            pstm.setDouble(25, o.getAcrescimo());
            pstm.setDouble(26, o.getValvenda());
            pstm.setInt(27, o.getEquipame());
            pstm.setString(28, o.getMscodigo());
            pstm.setInt(29, o.getMecodigo());
            pstm.setDate(30, new java.sql.Date(o.getDataamesa().getTime()));
            pstm.setString(31, o.getConfecfser());
            pstm.setString(32, o.getConfeecf());
            pstm.setInt(33, o.getConfecoo());
            pstm.setInt(34, o.getConfecer());
            pstm.setInt(35, o.getFucodigo());
            pstm.setInt(36, o.getPeriodo());
            pstm.setString(37, o.getHorario());
            pstm.setString(38, o.getEcfseque());
            pstm.setString(39, o.getEcfserie());
            pstm.setString(40, o.getEcfmarca());
            pstm.setString(41, o.getEcfmodelo());
            pstm.setString(42, o.getEcftipo());
            pstm.setString(43, o.getSwbversao());

            if (o.getSwbdthrgr() != null) {
                pstm.setDate(44, new java.sql.Date(o.getSwbdthrgr().getTime()));
            } else {
                pstm.setNull(44, java.sql.Types.DATE);
            }

            pstm.setString(45, o.getSwbmfadic());
            pstm.setInt(46, o.getNumcupom());
            pstm.setInt(47, o.getQtdpessoa());
            pstm.setInt(48, o.getQtdcupent());

            pstm.setString(49, o.getHorainic());
            pstm.setString(50, o.getHorapagt());

            pstm.setInt(51, o.getDav());
            pstm.setString(52, o.getNumorcam());
            pstm.setString(53, o.getNome());
            pstm.setString(54, o.getEndereco());
            pstm.setString(55, o.getTelefone());
            pstm.setString(56, o.getDocumento());
            pstm.setInt(57, o.getNumerocoo());
            pstm.setString(58, o.getObs1());
            pstm.setString(59, o.getObs2());
            pstm.setString(60, o.getObs3());
            pstm.setString(61, o.getObs4());
            pstm.setString(62, o.getObs5());
            pstm.setString(63, o.getObs6());
            pstm.setString(64, o.getObs7());
            pstm.setString(65, o.getObs8());
            pstm.setInt(66, o.getKm());
            pstm.setString(67, o.getPlaca());
            pstm.setString(68, o.getBaixaesto());
            pstm.setInt(69, o.getClcodpai());
            pstm.setString(70, o.getFlagtrans());
            pstm.setInt(71, o.getFicodigo());
            pstm.setString(72, o.getSetoruso());
            pstm.setInt(73, o.getFacodigo());
            pstm.setString(74, o.getCentcusto());
            pstm.setString(75, o.getPasembarque());
            pstm.setString(76, o.getPasdestino());
            pstm.setString(77, o.getPaslinha());
            pstm.setString(78, o.getPasagencia());
            pstm.setString(79, o.getPasdata());
            pstm.setString(80, o.getPashora());
            pstm.setString(81, o.getPaspoltrona());
            pstm.setString(82, o.getPasplataforma());
            pstm.setString(83, o.getPastipopassagem());
            pstm.setString(84, o.getPasrg());
            pstm.setString(85, o.getPasnome());
            pstm.setString(86, o.getPasendereco());
            pstm.setString(87, o.getPasufdestino());
            pstm.setInt(88, o.getPaspercurso());
            pstm.setInt(89, o.getPastpvenda());
            pstm.setInt(90, o.getPascodard());
            pstm.setString(91, o.getCodautoext());
            pstm.setString(92, o.getOrigem());
            pstm.setString(93, o.getMultmesas());
            pstm.setString(94, o.getPafindcanc());
            pstm.setString(95, o.getModelodoc());
            pstm.setString(96, o.getPafhashver());
            pstm.setString(97, o.getPafhashcap());
            pstm.setDouble(98, o.getVlrbcpis());
            pstm.setDouble(99, o.getValorpis());
            pstm.setDouble(100, o.getVlrpisst());
            pstm.setDouble(101, o.getVlrbccfs());
            pstm.setDouble(102, o.getValorcfs());
            pstm.setDouble(103, o.getVlrcfsst());
            pstm.setDate(104, new java.sql.Date(o.getDatadamov().getTime()));
            pstm.executeUpdate();

        } catch (Exception ex) {
            Loggin.logDiarioExcecao(ex, true);
//        } finally {

            //System.out.println("Closing database resources and rolling back any changes we made to the database.");
            //Now that we're all finished, let's release database resources.
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//                if (pstm != null) {
//                    pstm.close();
//                }
//                if (pConn != null) {
//                    pConn.rollback();
//                }
//                if (pConn != null && !conn.isClosed()) {
//                    pConn.close();
//                }
//            } catch (java.sql.SQLException e) {
//                e.printStackTrace();
//            }
        }

        return null;
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public PreVdPdvBean preVdPdv(int vdCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = null;
        String consultaSQL = "select * from PreVdPdv "
                + " where VDCODIGO = ? ";

        try {

            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setInt(1, vdCodigo);
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
    public List<PreVdPdvBean> listarPreVdPdv() throws SQLException, ClassNotFoundException, IOException, Exception {

        List<PreVdPdvBean> listaPreVdPdvBean = null;
        String consultaSQL = "select * from PreVdPdv ";

        try {
            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                gravarNoRegistro();
                listaPreVdPdvBean.add(registro);
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
        return listaPreVdPdvBean;
    }

    //-------------------------------------------------------------------------------------------
    private void gravarNoRegistro() throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = new PreVdPdvBean();
        registro.setVdcodigo(rs.getInt("VDCODIGO"));
        registro.setCacodigo(rs.getString("CACODIGO"));
        registro.setSituacao(rs.getString("SITUACAO"));
        registro.setStsproc(rs.getString("STSPROC"));
        registro.setCodsolicitfarma(rs.getString("CODSOLICITFARMA"));
        registro.setNumautorizacao(rs.getString("NUMAUTORIZACAO"));
        registro.setMsgproc(rs.getString("MSGPROC"));
        registro.setVdacacod(rs.getString("VDACACOD"));
        registro.setVdavdcod(rs.getInt("VDAVDCOD"));
        registro.setCafechpre(rs.getString("CAFECHPRE"));
        registro.setNumeronf(rs.getInt("NUMERONF"));
        registro.setSerienf(rs.getString("SERIENF"));
        registro.setPrecanc(rs.getString("PRECANC"));
        registro.setDatahoracup(rs.getDate("DATAHORACUP"));
        registro.setData(rs.getDate("DATA"));
        registro.setVendedor(rs.getInt("VENDEDOR"));
        registro.setClcodigo(rs.getInt("CLCODIGO"));
        registro.setNomeclie(rs.getString("NOMECLIE"));
        registro.setCgcclie(rs.getString("CGCCLIE"));
        registro.setCpfclie(rs.getString("CPFCLIE"));
        registro.setLimcrebai(rs.getDouble("LIMCREBAI"));
        registro.setLimcresec(rs.getDouble("LIMCRESEC"));
        registro.setCodintern(rs.getString("CODINTERN"));
        registro.setDesconto(rs.getDouble("DESCONTO"));
        registro.setAcrescimo(rs.getDouble("ACRESCIMO"));
        registro.setValvenda(rs.getDouble("VALVENDA"));
        registro.setEquipame(rs.getInt("EQUIPAME"));
        registro.setMscodigo(rs.getString("MSCODIGO"));
        registro.setMecodigo(rs.getInt("MECODIGO"));
        registro.setDataamesa(rs.getDate("DATAAMESA"));
        registro.setConfecfser(rs.getString("CONFECFSER"));
        registro.setConfeecf(rs.getString("CONFEECF"));
        registro.setConfecoo(rs.getInt("CONFECOO"));
        registro.setConfecer(rs.getInt("CONFECER"));
        registro.setFucodigo(rs.getInt("FUCODIGO"));
        registro.setPeriodo(rs.getInt("PERIODO"));
        registro.setHorario(rs.getString("HORARIO"));
        registro.setEcfseque(rs.getString("ECFSEQUE"));
        registro.setEcfserie(rs.getString("ECFSERIE"));
        registro.setEcfmarca(rs.getString("ECFMARCA"));
        registro.setEcfmodelo(rs.getString("ECFMODELO"));
        registro.setEcftipo(rs.getString("ECFTIPO"));
        registro.setSwbversao(rs.getString("SWBVERSAO"));
        registro.setSwbdthrgr(rs.getDate("SWBDTHRGR"));
        registro.setSwbmfadic(rs.getString("SWBMFADIC"));
        registro.setNumcupom(rs.getInt("NUMCUPOM"));
        registro.setQtdpessoa(rs.getInt("QTDPESSOA"));
        registro.setQtdcupent(rs.getInt("QTDCUPENT"));
        registro.setHorainic(rs.getString("HORAINIC"));
        registro.setHorapagt(rs.getString("HORAPAGT"));
        registro.setDav(rs.getInt("DAV"));
        registro.setNumorcam(rs.getString("NUMORCAM"));
        registro.setNome(rs.getString("NOME"));
        registro.setEndereco(rs.getString("ENDERECO"));
        registro.setTelefone(rs.getString("TELEFONE"));
        registro.setDocumento(rs.getString("DOCUMENTO"));
        registro.setNumerocoo(rs.getInt("NUMEROCOO"));
        registro.setObs1(rs.getString("OBS1"));
        registro.setObs2(rs.getString("OBS2"));
        registro.setObs3(rs.getString("OBS3"));
        registro.setObs4(rs.getString("OBS4"));
        registro.setObs5(rs.getString("OBS5"));
        registro.setObs6(rs.getString("OBS6"));
        registro.setObs7(rs.getString("OBS7"));
        registro.setObs8(rs.getString("OBS8"));
        registro.setKm(rs.getInt("KM"));
        registro.setPlaca(rs.getString("PLACA"));
        registro.setBaixaesto(rs.getString("BAIXAESTO"));
        registro.setClcodpai(rs.getInt("CLCODPAI"));
        registro.setFlagtrans(rs.getString("FLAGTRANS"));
        registro.setFicodigo(rs.getInt("FICODIGO"));
        registro.setSetoruso(rs.getString("SETORUSO"));
        registro.setFacodigo(rs.getInt("FACODIGO"));
        registro.setCentcusto(rs.getString("CENTCUSTO"));
        registro.setPasembarque(rs.getString("PASEMBARQUE"));
        registro.setPasdestino(rs.getString("PASDESTINO"));
        registro.setPaslinha(rs.getString("PASLINHA"));
        registro.setPasagencia(rs.getString("PASAGENCIA"));
        registro.setPasdata(rs.getString("PASDATA"));
        registro.setPashora(rs.getString("PASHORA"));
        registro.setPaspoltrona(rs.getString("PASPOLTRONA"));
        registro.setPasplataforma(rs.getString("PASPLATAFORMA"));
        registro.setPastipopassagem(rs.getString("PASTIPOPASSAGEM"));
        registro.setPasrg(rs.getString("PASRG"));
        registro.setPasnome(rs.getString("PASNOME"));
        registro.setPasendereco(rs.getString("PASENDERECO"));
        registro.setPasufdestino(rs.getString("PASUFDESTINO"));
        registro.setPaspercurso(rs.getInt("PASPERCURSO"));
        registro.setPastpvenda(rs.getInt("PASTPVENDA"));
        registro.setPascodard(rs.getInt("PASCODARD"));
        registro.setCodautoext(rs.getString("CODAUTOEXT"));
        registro.setOrigem(rs.getString("ORIGEM"));
        registro.setMultmesas(rs.getString("MULTMESAS"));
        registro.setPafindcanc(rs.getString("PAFINDCANC"));
        registro.setModelodoc(rs.getString("MODELODOC"));
        registro.setPafhashver(rs.getString("PAFHASHVER"));
        registro.setPafhashcap(rs.getString("PAFHASHCAP"));
        registro.setVlrbcpis(rs.getDouble("VLRBCPIS"));
        registro.setValorpis(rs.getDouble("VALORPIS"));
        registro.setVlrpisst(rs.getDouble("VLRPISST"));
        registro.setVlrbccfs(rs.getDouble("VLRBCCFS"));
        registro.setValorcfs(rs.getDouble("VALORCFS"));
        registro.setVlrcfsst(rs.getDouble("VLRCFSST"));
        registro.setDatadamov(rs.getDate("DATADAMOV"));
    }

}
