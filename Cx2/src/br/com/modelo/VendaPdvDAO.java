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
import java.util.Date;
import java.util.List;

/**
 *
 * @author raul
 */
public class VendaPdvDAO {

    private Connection conn = null;
    private Statement stm;
    private PreparedStatement pstm;
    private ResultSet rs;
    private VendaPdvBean registro;
    private final ItemVpdvDAO itemVpdvDAO = new ItemVpdvDAO();
    private final PreVdPdvDAO preVdPdvDAO = new PreVdPdvDAO();
    private final ItPrVpdvDAO itPrVpdvDAO = new ItPrVpdvDAO();
    private final LancamenDAO lancamenDAO = new LancamenDAO();
    private final MvCaipdvDAO mvCaipdvDAO = new MvCaipdvDAO();
    private final Conectar conectar = new Conectar();

    public void fecharVenda(VendaPdvBean o, List<ItemVpdvBean> listaItem, List<LancamenBean> listaLancamenBean, List<MvCaipdvBean> listaMvCaipdvBean) throws SQLException, ClassNotFoundException, IOException, Exception {

        try {
            conn = conectar.conectar();
            conn.setAutoCommit(false);
            //******************************************************
            //cabecalho
            //******************************************************
            inserir(conn, o);
            //itens da venda
            itemVpdvDAO.inserir(conn, o.getBaixaesto(), listaItem);

            //******************************************************
            //Lancamentos
            //******************************************************
            lancamenDAO.inserir(conn, listaLancamenBean);

            //******************************************************
            //Merda
            //******************************************************
            mvCaipdvDAO.inserir(conn, listaMvCaipdvBean);

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

    }

    public void cancelarVenda(VendaPdvBean o) throws SQLException, ClassNotFoundException, IOException, Exception {

        try {

            List<ItemVpdvBean> listaItemVpdvBean = itemVpdvDAO.listaItemVpdv(o.getCacodigo(), o.getVdcodigo());

            //----------------------
            conn = conectar.conectar();
            conn.setAutoCommit(false);
            //cabecalho                       mudar status da venda
            //inserir(conn, o);

            //itens da venda
            itemVpdvDAO.cancelarItensVenda(conn, o.getBaixaesto(), listaItemVpdvBean);
            conn.commit();
            conn.setAutoCommit(true);
        } catch (java.sql.SQLException e) {
            if (conn != null) {
                //conn.rollback();
            }
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

    }

    public VendaPdvBean inserir(Connection pConn, VendaPdvBean o) throws SQLException, ClassNotFoundException, IOException, Exception {

        
        String consultaSQL = "insert into VendaPdv ( "
                + " CACODIGO, "
                + " VDCODIGO, "
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
                + " FLAGTSERV, "
                + " FLAGFINAN, "
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
                + " values ("
                + " ?, ?, ?, ?, ?, "
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
        pstm.setString(1, o.getCacodigo());
        pstm.setInt(2, o.getVdcodigo());
        pstm.setDate(3, new java.sql.Date(o.getDatahoracup().getTime()));
        pstm.setDate(4, new java.sql.Date(o.getData().getTime()));
        pstm.setInt(5, o.getVendedor());
        pstm.setInt(6, o.getClcodigo());
        pstm.setString(7, o.getNomeclie());
        pstm.setString(8, o.getCgcclie());
        pstm.setString(9, o.getCpfclie());
        pstm.setDouble(10, o.getLimcrebai());
        pstm.setDouble(11, o.getLimcresec());
        pstm.setString(12, o.getCodintern());
        pstm.setDouble(13, o.getDesconto());
        pstm.setDouble(14, o.getAcrescimo());
        pstm.setDouble(15, o.getValvenda());
        pstm.setInt(16, o.getEquipame());
        pstm.setString(17, o.getMscodigo());
        pstm.setInt(18, o.getMecodigo());
        pstm.setDate(19, new java.sql.Date(o.getDataamesa().getTime()));
        pstm.setString(20, o.getConfecfser());
        pstm.setString(21, o.getConfeecf());
        pstm.setInt(22, o.getConfecoo());
        pstm.setInt(23, o.getConfecer());
        pstm.setInt(24, o.getFucodigo());
        pstm.setInt(25, o.getPeriodo());
        pstm.setString(26, o.getHorario());
        pstm.setString(27, o.getEcfseque());
        pstm.setString(28, o.getEcfserie());
        pstm.setString(29, o.getEcfmarca());
        pstm.setString(30, o.getEcfmodelo());
        pstm.setString(31, o.getEcftipo());
        pstm.setString(32, o.getSwbversao());

        if (o.getSwbdthrgr() != null) {
            pstm.setDate(33, new java.sql.Date(o.getSwbdthrgr().getTime()));
        } else {
            pstm.setNull(33, java.sql.Types.DATE);
        }

        pstm.setString(34, o.getSwbmfadic());
        pstm.setInt(35, o.getNumcupom());
        pstm.setInt(36, o.getQtdpessoa());

        if (o.getSwbdthrgr() != null) {
            pstm.setInt(37, o.getQtdcupent());
        } else {
            pstm.setNull(37, java.sql.Types.INTEGER);
        }

        pstm.setString(38, o.getHorainic());
        pstm.setString(39, o.getHorapagt());
        pstm.setInt(40, o.getDav());
        pstm.setString(41, o.getNumorcam());
        pstm.setString(42, o.getNome());
        pstm.setString(43, o.getEndereco());
        pstm.setString(44, o.getTelefone());
        pstm.setString(45, o.getDocumento());
        pstm.setInt(46, o.getNumerocoo());
        pstm.setString(47, o.getObs1());
        pstm.setString(48, o.getObs2());
        pstm.setString(49, o.getObs3());
        pstm.setString(50, o.getObs4());
        pstm.setString(51, o.getObs5());
        pstm.setString(52, o.getObs6());
        pstm.setString(53, o.getObs7());
        pstm.setString(54, o.getObs8());
        pstm.setInt(55, o.getKm());
        pstm.setString(56, o.getPlaca());
        pstm.setString(57, o.getBaixaesto());
        pstm.setInt(58, o.getClcodpai());

        if (o.getFlagtrans() != null) {
            pstm.setString(59, o.getFlagtrans());
        } else {
            pstm.setNull(59, java.sql.Types.VARCHAR);
        }

        if (o.getFlagtrans() != null) {
            pstm.setString(60, o.getFlagtserv());
        } else {
            pstm.setNull(60, java.sql.Types.VARCHAR);
        }

        if (o.getFlagtrans() != null) {
            pstm.setString(61, o.getFlagfinan());
        } else {
            pstm.setNull(61, java.sql.Types.VARCHAR);
        }

        pstm.setInt(62, o.getFicodigo());
        pstm.setString(63, o.getSetoruso());

        if (o.getFlagtrans() != null) {
            pstm.setInt(64, o.getFacodigo());
        } else {
            pstm.setNull(64, java.sql.Types.INTEGER);
        }

        pstm.setString(65, o.getCentcusto());
        pstm.setString(66, o.getPasembarque());
        pstm.setString(67, o.getPasdestino());
        pstm.setString(68, o.getPaslinha());
        pstm.setString(69, o.getPasagencia());
        pstm.setString(70, o.getPasdata());
        pstm.setString(71, o.getPashora());
        pstm.setString(72, o.getPaspoltrona());
        pstm.setString(73, o.getPasplataforma());
        pstm.setString(74, o.getPastipopassagem());
        pstm.setString(75, o.getPasrg());
        pstm.setString(76, o.getPasnome());
        pstm.setString(77, o.getPasendereco());
        pstm.setString(78, o.getPasufdestino());
        pstm.setInt(79, o.getPaspercurso());
        pstm.setInt(80, o.getPastpvenda());
        pstm.setInt(81, o.getPascodard());
        pstm.setString(82, o.getCodautoext());
        pstm.setString(83, o.getOrigem());
        pstm.setString(84, o.getMultmesas());
        pstm.setString(85, o.getPafindcanc());
        pstm.setString(86, o.getModelodoc());
        pstm.setString(87, o.getPafhashver());
        pstm.setString(88, o.getPafhashcap());
        pstm.setDouble(89, o.getVlrbcpis());
        pstm.setDouble(90, o.getValorpis());
        pstm.setDouble(91, o.getVlrpisst());
        pstm.setDouble(92, o.getVlrbccfs());
        pstm.setDouble(93, o.getValorcfs());
        pstm.setDouble(94, o.getVlrcfsst());
        pstm.setDate(95, new java.sql.Date(o.getDatadamov().getTime()));
        pstm.executeUpdate();

        return null;
    }

    //--------------------------------------------------------------------------------------------------------------
    public VendaPdvBean vendaPdv(int vdcodigo) throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = null;
        String consultaSQL = "select * from VendaPdv "
                + " where vdcodigo = ? ";

        try {

            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setInt(1, vdcodigo);
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
    public List<VendaPdvBean> listarVendaPdv() throws SQLException, ClassNotFoundException, IOException, Exception {

        List<VendaPdvBean> listaVendaPdvBean = new ArrayList<VendaPdvBean>();;
        String consultaSQL = "select * from VendaPdv order by NOME";

        try {
            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                gravarNoRegistro();
                listaVendaPdvBean.add(registro);
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
        return listaVendaPdvBean;
    }

    //--------------------------------------------------------------------------------------------------------------
    public List<VendaPdvBean> listarVendaPdv(Date periodoInicial, Date periodoFinal) throws SQLException, ClassNotFoundException, IOException, Exception {

        List<VendaPdvBean> listaVendaPdvBean = new ArrayList<VendaPdvBean>();;
        String consultaSQL = "select * from VendaPdv "
                + " where DATA Between ? and ? "
                + " order by DATA ";

        try {
            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setDate(1, new java.sql.Date(periodoInicial.getTime()));
            pstm.setDate(2, new java.sql.Date(periodoFinal.getTime()));
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                gravarNoRegistro();
                listaVendaPdvBean.add(registro);
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
        return listaVendaPdvBean;
    }

    //--------------------------------------------------------------------------------------------------------------
    public List<VendaPdvBean> listarVendaPdv(String nomeClie) throws SQLException, ClassNotFoundException, IOException, Exception {

        List<VendaPdvBean> listaVendaPdvBean = new ArrayList<VendaPdvBean>();
        String consultaSQL = "select * from VendaPdv "
                + " where upper(NOMECLIE) like ? "
                + " order by NOMECLIE ";

        try {
            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setString(1, nomeClie.toUpperCase());
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                gravarNoRegistro();
                listaVendaPdvBean.add(registro);
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
        return listaVendaPdvBean;
    }

    //--------------------------------------------------------------------------------------------------------------
    public List<VendaPdvBean> listarVendaPdv(Date periodoInicial, Date periodoFinal, String nomeClie) throws SQLException, ClassNotFoundException, IOException, Exception {

        List<VendaPdvBean> listaVendaPdvBean = new ArrayList<VendaPdvBean>();;
        String consultaSQL = "select * from VendaPdv "
                + " where DATA Between ? and ? "
                + " and upper(NOMECLIE) like ? "
                + " order by NOMECLIE ";

        try {
            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setDate(1, new java.sql.Date(periodoInicial.getTime()));
            pstm.setDate(2, new java.sql.Date(periodoFinal.getTime()));
            pstm.setString(3, nomeClie.toUpperCase());
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                gravarNoRegistro();
                listaVendaPdvBean.add(registro);
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
        return listaVendaPdvBean;
    }

    //--------------------------------------------------------------------------------------------------------------
    public List<VendaPdvBean> listarVendaPdvCpf(String cpf) throws SQLException, ClassNotFoundException, IOException, Exception {

        List<VendaPdvBean> listaVendaPdvBean = new ArrayList<VendaPdvBean>();;
        String consultaSQL = "select * from VendaPdv "
                + " where CPFCLIE = ? "
                + " order by DATA ";

        try {
            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setString(1, cpf);
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                gravarNoRegistro();
                listaVendaPdvBean.add(registro);
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
        return listaVendaPdvBean;
    }

    //--------------------------------------------------------------------------------------------------------------
    public List<VendaPdvBean> listarVendaPdvCpf(Date periodoInicial, Date periodoFinal, String cpf) throws SQLException, ClassNotFoundException, IOException, Exception {

        List<VendaPdvBean> listaVendaPdvBean = new ArrayList<VendaPdvBean>();;
        String consultaSQL = "select * from VendaPdv "
                + " where DATA Between ? and ? "
                + " and CPFCLIE = ? "
                + " order by DATA ";

        try {
            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setDate(1, new java.sql.Date(periodoInicial.getTime()));
            pstm.setDate(2, new java.sql.Date(periodoFinal.getTime()));
            pstm.setString(3, cpf);
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                gravarNoRegistro();
                listaVendaPdvBean.add(registro);
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
        return listaVendaPdvBean;
    }

    //--------------------------------------------------------------------------------------------------------------
    public List<VendaPdvBean> listarVendaPdvCgc(String cgc) throws SQLException, ClassNotFoundException, IOException, Exception {

        List<VendaPdvBean> listaVendaPdvBean = new ArrayList<VendaPdvBean>();;
        String consultaSQL = "select * from VendaPdv "
                + " where CGCCLIE = ? "
                + " order by DATA ";

        try {
            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setString(1, cgc);
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                gravarNoRegistro();
                listaVendaPdvBean.add(registro);
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
        return listaVendaPdvBean;
    }

    //--------------------------------------------------------------------------------------------------------------
    public List<VendaPdvBean> listarVendaPdvCgc(Date periodoInicial, Date periodoFinal, String cgc) throws SQLException, ClassNotFoundException, IOException, Exception {

        List<VendaPdvBean> listaVendaPdvBean = new ArrayList<VendaPdvBean>();;
        String consultaSQL = "select * from VendaPdv "
                + " where DATA Between ? and ? "
                + " and CGCCLIE = ? "
                + " order by DATA ";

        try {
            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setDate(1, new java.sql.Date(periodoInicial.getTime()));
            pstm.setDate(2, new java.sql.Date(periodoFinal.getTime()));
            pstm.setString(3, cgc);
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                gravarNoRegistro();
                listaVendaPdvBean.add(registro);
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
        return listaVendaPdvBean;
    }

    //-------------------------------------------------------------------------------------------
    private void gravarNoRegistro() throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = new VendaPdvBean();
        registro.setCacodigo(rs.getString("CACODIGO"));
        registro.setVdcodigo(rs.getInt("VDCODIGO"));
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
        registro.setFlagtserv(rs.getString("FLAGTSERV"));
        registro.setFlagfinan(rs.getString("FLAGFINAN"));
        
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

        //registro.setPasplataforma(rs.getString("MAPASPLATAFORMA"));
        //registro.setPastipopassagem(rs.getString("AGEMPASTIPOPASSAGEM"));
        registro.setPasrg(rs.getString("PASRG"));
        registro.setPasnome(rs.getString("PASNOME"));
        registro.setPasendereco(rs.getString("PASENDERECO"));
        //registro.setPasufdestino(rs.getString("OPASUFDESTINO"));
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
