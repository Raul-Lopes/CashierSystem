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
public class MaterPdvDAO {

    Connection conn = null;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;
    MaterPdvBean registro;
    Conectar conectar = new Conectar();

    public void alerar(Connection pConn, MaterPdvBean aliquotaBean) throws SQLException, ClassNotFoundException, IOException, Exception {

        try {
            //baixa de estoque
            String consultaSQL = "update MaterPdv set "
                    + " QTDESTOQ = ? "
                    + " where MFCODIGO = ? ";

            pstm = pConn.prepareStatement(consultaSQL);
            pstm.setDouble(1, aliquotaBean.getQtdestoq());
            pstm.setString(2, aliquotaBean.getMfcodigo());
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

    }

    //----------------------------------------------------------------------------------------------------------------------------
    public MaterPdvBean materPdvMfcodigo(String mfcodigo) throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = null;

        String consultaSQL = "select M.*, U.UNCODIGO as U_UNCODIGO, U.NOME as U_NOME, U.DATAALTE as U_DATAALTE "
                + " from MATERPDV M Inner Join UNIDADES U on M.UNCODIGO = U.UNCODIGO "
                + " where SITUACAO = 'A' and MFCODIGO = ? "
                + " order by M.NOME ";
        try {
            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setString(1, mfcodigo);
            rs = pstm.executeQuery();

            //
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

    //----------------------------------------------------------------------------------------------------------------------------
    public MaterPdvBean materPdvCodIntern(String codintern) throws SQLException, ClassNotFoundException, IOException, Exception {

        registro = null;

        String consultaSQL = "select M.*, U.UNCODIGO as U_UNCODIGO, U.NOME as U_NOME, U.DATAALTE as U_DATAALTE "
                + " from MATERPDV M Inner Join UNIDADES U on M.UNCODIGO = U.UNCODIGO "
                + " where SITUACAO = 'A' and codintern = ? "
                + " order by M.NOME ";
        try {
            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setString(1, codintern);
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
    public List<MaterPdvBean> listarMaterPdvNome(String nome) throws SQLException, ClassNotFoundException, IOException, Exception {

        List<MaterPdvBean> listaMaterPdvBean = new ArrayList<MaterPdvBean>();

        String consultaSQL = "select M.*, U.UNCODIGO as U_UNCODIGO, U.NOME as U_NOME, U.DATAALTE as U_DATAALTE "
                + " from MATERPDV M Left Join UNIDADES U on M.UNCODIGO = U.UNCODIGO "
                + " where SITUACAO = 'A' and upper(M.NOME) like ? "
                + " order by M.NOME ";

        try {
            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setString(1, nome.toUpperCase().trim());
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                gravarNoRegistro();
                listaMaterPdvBean.add(registro);
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
        return listaMaterPdvBean;
    }

    //--------------------------------------------------------------------------------------------------------------
    public List<MaterPdvBean> listarMaterPdvReferencia(String referencia) throws SQLException, ClassNotFoundException, IOException, Exception {

        List<MaterPdvBean> listaMaterPdvBean = new ArrayList<MaterPdvBean>();

        String consultaSQL = "select M.*, U.UNCODIGO as U_UNCODIGO, U.NOME as U_NOME, U.DATAALTE as U_DATAALTE "
                + " from MATERPDV M Inner Join UNIDADES U on M.UNCODIGO = U.UNCODIGO "
                + " where SITUACAO = 'A' and upper(M.REFERENCI) like ? "
                + " order by M.REFERENCI ";

        try {
            conn = conectar.conectar();
            pstm = conn.prepareStatement(consultaSQL);
            pstm.setString(1, referencia.toUpperCase().trim());
            rs = pstm.executeQuery();
            registro = null;

            while (rs.next()) {
                gravarNoRegistro();
                listaMaterPdvBean.add(registro);
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
        return listaMaterPdvBean;
    }

    //-------------------------------------------------------------------------------------------
    private void gravarNoRegistro() throws SQLException, ClassNotFoundException, IOException, Exception {

        UnidadesBean unidadesBean = new UnidadesBean();
        unidadesBean.setUncodigo(rs.getString("U_UNCODIGO"));
        unidadesBean.setNome(rs.getString("U_NOME"));
        unidadesBean.setDataalte(rs.getDate("U_DATAALTE"));

        registro = new MaterPdvBean();
        registro.setMfcodigo(rs.getString("MFCODIGO"));
        registro.setNome(rs.getString("NOME"));
        registro.setUncodigo(rs.getString("UNCODIGO"));
        registro.setUnidadeVO(unidadesBean);
        registro.setPrecoven(rs.getDouble("PRECOVEN"));
        registro.setAliqicms(rs.getDouble("ALIQICMS"));
        registro.setAlqicmse(rs.getDouble("ALQICMSE"));
        registro.setCodorige(rs.getString("CODORIGE"));
        registro.setCodtrib(rs.getString("CODTRIB"));
        registro.setCalcgorj(rs.getString("CALCGORJ"));
        registro.setCodtribe(rs.getString("CODTRIBE"));
        registro.setPesavel(rs.getString("PESAVEL"));
        registro.setLibvenda(rs.getString("LIBVENDA"));
        registro.setAliqipi(rs.getDouble("ALIQIPI"));
        registro.setCodextra(rs.getString("CODEXTRA"));
        registro.setReferenci(rs.getString("REFERENCI"));
        registro.setGrade(rs.getString("GRADE"));
        registro.setCor(rs.getString("COR"));
        registro.setTamanho(rs.getString("TAMANHO"));
        registro.setCodintern(rs.getString("CODINTERN"));
        registro.setTipotribu(rs.getString("TIPOTRIBU"));
        registro.setQtdestoq(rs.getDouble("QTDESTOQ"));
        registro.setPathfoto(rs.getString("PATHFOTO"));
        registro.setAgcodigo(rs.getString("AGCODIGO"));
        registro.setCatsmart(rs.getInt("CATSMART"));
        registro.setCodsmart(rs.getInt("CODSMART"));
        registro.setSequencia(rs.getInt("SEQUENCIA"));
        registro.setCompvda(rs.getDouble("COMPVDA"));
        registro.setPrccumed(rs.getDouble("PRCCUMED"));
        registro.setPrccucon(rs.getDouble("PRCCUCON"));
        registro.setPccumeco(rs.getDouble("PCCUMECO"));
        registro.setPrecofab(rs.getDouble("PRECOFAB"));
        registro.setPrecocus(rs.getDouble("PRECOCUS"));
        registro.setQtdnaemb(rs.getDouble("QTDNAEMB"));
        registro.setDataalte(rs.getDate("DATAALTE"));
        registro.setDtaltprc(rs.getDate("DTALTPRC"));
        registro.setDtmovest(rs.getDate("DTMOVEST"));
        registro.setFocodigo(rs.getInt("FOCODIGO"));
        registro.setUnidentr(rs.getString("UNIDENTR"));
        registro.setBasreden(rs.getDouble("BASREDEN"));
        registro.setBasredcr(rs.getDouble("BASREDCR"));
        registro.setAlcodigo(rs.getInt("ALCODIGO"));
        registro.setAlcodent(rs.getInt("ALCODENT"));
        registro.setPedecompl(rs.getString("PEDECOMPL"));
        registro.setComposto(rs.getString("COMPOSTO"));
        registro.setObs01(rs.getString("OBS01"));
        registro.setObs02(rs.getString("OBS02"));
        registro.setObs03(rs.getString("OBS03"));
        registro.setMargem(rs.getDouble("MARGEM"));
        registro.setMaxdescon(rs.getDouble("MAXDESCON"));
        registro.setQtdemin(rs.getDouble("QTDEMIN"));
        registro.setConferen(rs.getString("CONFEREN"));
        registro.setSituacao(rs.getString("SITUACAO"));
        registro.setMocodigo(rs.getString("MOCODIGO"));
        registro.setPrcmoeda(rs.getDouble("PRCMOEDA"));
        registro.setCotmoeda(rs.getDouble("COTMOEDA"));
        registro.setNbcodigo(rs.getString("NBCODIGO"));
        registro.setMedcontr(rs.getString("MEDCONTR"));
        registro.setRegminsa(rs.getString("REGMINSA"));
        registro.setBalanca(rs.getString("BALANCA"));
        registro.setQtdeconsig(rs.getDouble("QTDECONSIG"));
        registro.setMfcodide(rs.getString("MFCODIDE"));
        registro.setClasfisc(rs.getString("CLASFISC"));
        registro.setSigla(rs.getString("SIGLA"));
        registro.setVacina(rs.getString("VACINA"));
        registro.setContnserie(rs.getString("CONTNSERIE"));
        registro.setComplcozi(rs.getString("COMPLCOZI"));
        registro.setPrecoloca(rs.getDouble("PRECOLOCA"));
        registro.setPeso(rs.getDouble("PESO"));
        registro.setCofins(rs.getString("COFINS"));
        registro.setPis(rs.getString("PIS"));
        registro.setQtdedisploc(rs.getDouble("QTDEDISPLOC"));
        registro.setDiasvalid(rs.getInt("DIASVALID"));
        registro.setPrcponde(rs.getDouble("PRCPONDE"));
        registro.setTipofab(rs.getString("TIPOFAB"));
        registro.setIat(rs.getString("IAT"));
        registro.setIpicstent(rs.getString("IPICSTENT"));
        registro.setIpicstsaida(rs.getString("IPICSTSAIDA"));
        registro.setCodsefmg(rs.getString("CODSEFMG"));
        registro.setPermdesc(rs.getString("PERMDESC"));
        registro.setAtivdesc(rs.getString("ATIVDESC"));
        registro.setServmun(rs.getString("SERVMUN"));
        registro.setTipoitem(rs.getInt("TIPOITEM"));
        registro.setCodcontrv(rs.getString("CODCONTRV"));
        registro.setCodcontcc(rs.getString("CODCONTCC"));
        registro.setCodcontest(rs.getString("CODCONTEST"));
        registro.setCodcontdv(rs.getString("CODCONTDV"));
        registro.setDec5161907(rs.getString("DEC5161907"));
        registro.setUncodent(rs.getString("UNCODENT"));
        registro.setAliqcsll(rs.getDouble("ALIQCSLL"));
        registro.setAliqinss(rs.getDouble("ALIQINSS"));
        registro.setCodigoanp(rs.getString("CODIGOANP"));
        registro.setAutcodif(rs.getString("AUTCODIF"));
        registro.setAliqcide(rs.getDouble("ALIQCIDE"));
        registro.setCtrmedica(rs.getString("CTRMEDICA"));
        registro.setPafhashver(rs.getString("PAFHASHVER"));
        registro.setPafhashest(rs.getString("PAFHASHEST"));
        registro.setPafhashser(rs.getString("PAFHASHSER"));
        registro.setPafhashtri(rs.getString("PAFHASHTRI"));
        registro.setEcfserierz(rs.getString("ECFSERIERZ"));
        registro.setEstoqreduz(rs.getDouble("ESTOQREDUZ"));
        registro.setQtdembvda(rs.getDouble("QTDEMBVDA"));
        registro.setExIpi(rs.getString("EX_IPI"));
        registro.setCodLst(rs.getString("COD_LST"));
        registro.setPrevdesc(rs.getDouble("PREVDESC"));
        registro.setAtivdpre(rs.getString("ATIVDPRE"));
        registro.setCfoentra(rs.getInt("CFOENTRA"));
        registro.setCfosaida(rs.getInt("CFOSAIDA"));
        registro.setCombustivel(rs.getString("COMBUSTIVEL"));
        registro.setLocalizacao(rs.getString("LOCALIZACAO"));
        registro.setChassi(rs.getString("CHASSI"));
        registro.setPercomi(rs.getDouble("PERCOMI"));
        registro.setPercomiprz(rs.getDouble("PERCOMIPRZ"));
        registro.setBcaunticms(rs.getDouble("BCAUNTICMS"));
        registro.setNatRec(rs.getString("NAT_REC"));
        registro.setPisJuridica(rs.getString("PIS_JURIDICA"));
        registro.setCofinsJuridica(rs.getString("COFINS_JURIDICA"));
        registro.setCecodigo(rs.getString("CECODIGO"));
        registro.setLimitesec(rs.getString("LIMITESEC"));

    }
}
