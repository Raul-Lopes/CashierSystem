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
public class VdaCaPdvDAO {

    private Connection conn = null;
    private Statement stm;
    private PreparedStatement pstm;
    private ResultSet rs;
    private VdaCaPdvBean registro;
    private final Conectar conectar = new Conectar();

    public VdaCaPdvBean inserir(Connection pConn, VdaCaPdvBean o) throws SQLException, ClassNotFoundException, IOException, Exception {

        try {

            String consultaSQL = "insert into VdaCaPdv "
                    + " ( CACODIGO, "
                    + " VDCODIGO, "
                    + " DATACANC, "
                    + " CODAUTOR, "
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
                    + " values("
                    + " ?, ?, ?, ?, ?, ?, "
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                    + " )";

            pstm = pConn.prepareStatement(consultaSQL);
            pstm.setString(1, o.getCacodigo());
            pstm.setInt(2, o.getVdcodigo());
            pstm.setDate(3, new java.sql.Date(o.getDatacanc().getTime()));
            pstm.setInt(4, o.getCodautor());
            pstm.setDate(5, new java.sql.Date(o.getDatahoracup().getTime()));
            pstm.setDate(6, new java.sql.Date(o.getData().getTime()));
            pstm.setInt(7, o.getVendedor());
            pstm.setInt(8, o.getClcodigo());
            pstm.setString(9, o.getNomeclie());
            pstm.setString(10, o.getCgcclie());
            pstm.setString(11, o.getCpfclie());
            pstm.setDouble(12, o.getLimcrebai());
            pstm.setDouble(13, o.getLimcresec());
            pstm.setString(14, o.getCodintern());
            pstm.setDouble(15, o.getDesconto());
            pstm.setDouble(16, o.getAcrescimo());
            pstm.setDouble(17, o.getValvenda());
            pstm.setInt(18, o.getEquipame());
            pstm.setString(19, o.getMscodigo());
            pstm.setInt(20, o.getMecodigo());
            pstm.setDate(21, new java.sql.Date(o.getDataamesa().getTime()));
            pstm.setString(22, o.getConfecfser());
            pstm.setString(23, o.getConfeecf());
            pstm.setInt(24, o.getConfecoo());
            pstm.setInt(25, o.getConfecer());
            pstm.setInt(26, o.getFucodigo());
            pstm.setInt(27, o.getPeriodo());
            pstm.setString(28, o.getHorario());
            pstm.setString(29, o.getEcfseque());
            pstm.setString(30, o.getEcfserie());
            pstm.setString(31, o.getEcfmarca());
            pstm.setString(32, o.getEcfmodelo());
            pstm.setString(33, o.getEcftipo());
            pstm.setString(34, o.getSwbversao());
            pstm.setDate(35, new java.sql.Date(o.getSwbdthrgr().getTime()));
            pstm.setString(36, o.getSwbmfadic());
            pstm.setInt(37, o.getNumcupom());
            pstm.setInt(38, o.getQtdpessoa());
            pstm.setInt(39, o.getQtdcupent());
            pstm.setString(40, o.getHorainic());
            pstm.setString(41, o.getHorapagt());
            pstm.setInt(42, o.getDav());
            pstm.setString(43, o.getNumorcam());
            pstm.setString(44, o.getNome());
            pstm.setString(45, o.getEndereco());
            pstm.setString(46, o.getTelefone());
            pstm.setString(47, o.getDocumento());
            pstm.setInt(48, o.getNumerocoo());
            pstm.setString(49, o.getObs1());
            pstm.setString(50, o.getObs2());
            pstm.setString(51, o.getObs3());
            pstm.setString(52, o.getObs4());
            pstm.setString(53, o.getObs5());
            pstm.setString(54, o.getObs6());
            pstm.setString(55, o.getObs7());
            pstm.setString(56, o.getObs8());
            pstm.setInt(57, o.getKm());
            pstm.setString(58, o.getPlaca());
            pstm.setString(59, o.getBaixaesto());
            pstm.setInt(60, o.getClcodpai());
            pstm.setString(61, o.getFlagtrans());
            pstm.setString(62, o.getFlagtserv());
            pstm.setInt(63, o.getFicodigo());
            pstm.setString(64, o.getSetoruso());
            pstm.setInt(65, o.getFacodigo());
            pstm.setString(66, o.getCentcusto());
            pstm.setString(67, o.getPasembarque());
            pstm.setString(68, o.getPasdestino());
            pstm.setString(69, o.getPaslinha());
            pstm.setString(70, o.getPasagencia());
            pstm.setString(71, o.getPasdata());
            pstm.setString(72, o.getPashora());
            pstm.setString(73, o.getPaspoltrona());
            pstm.setString(74, o.getPasplataforma());
            pstm.setString(75, o.getPastipopassagem());
            pstm.setString(76, o.getPasrg());
            pstm.setString(77, o.getPasnome());
            pstm.setString(78, o.getPasendereco());
            pstm.setString(79, o.getPasufdestino());
            pstm.setInt(80, o.getPaspercurso());
            pstm.setInt(81, o.getPastpvenda());
            pstm.setInt(82, o.getPascodard());
            pstm.setString(83, o.getCodautoext());
            pstm.setString(84, o.getOrigem());
            pstm.setString(85, o.getMultmesas());
            pstm.setString(86, o.getPafindcanc());
            pstm.setString(87, o.getModelodoc());
            pstm.setString(88, o.getPafhashver());
            pstm.setString(89, o.getPafhashcap());
            pstm.setDouble(90, o.getVlrbcpis());
            pstm.setDouble(91, o.getValorpis());
            pstm.setDouble(92, o.getVlrpisst());
            pstm.setDouble(93, o.getVlrbccfs());
            pstm.setDouble(94, o.getValorcfs());
            pstm.setDouble(95, o.getVlrcfsst());
            pstm.setDate(96, new java.sql.Date(o.getDatadamov().getTime()));
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

    //---------------------------------------------------------------------------------------------------------------------------------------------
    public VdaCaPdvBean listarVdaCaPdv(String caCodigo, int vdCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = null;
        String consultaSQL = "select * from VdaCaPdv "
                + " where CACODIGO = ? and VDCODIGO = ? ";

        try {

            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setString(1, caCodigo);
            pstm.setInt(2, vdCodigo);
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
    public List<VdaCaPdvBean> listarVdaCaPdv() throws SQLException, ClassNotFoundException, IOException, Exception {

        List<VdaCaPdvBean> listaVdaCaPdvBean = null;
        String consultaSQL = "select * from VdaCaPdv ";

        try {
            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                gravarNoRegistro();
                listaVdaCaPdvBean.add(registro);
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
        return listaVdaCaPdvBean;
    }

    //---------------------------------------------------------------------------------------------------
    private void gravarNoRegistro() throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = new VdaCaPdvBean();
        registro.setCacodigo(rs.getString("CACODIGO"));
        registro.setVdcodigo(rs.getInt("VDCODIGO"));
        registro.setDatacanc(rs.getDate("DATACANC"));
        registro.setCodautor(rs.getInt("CODAUTOR"));
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
