/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controle;

import br.com.modelo.AliquotasBean;
import br.com.modelo.AliquotasDAO;
import br.com.modelo.CaixasBean;
import br.com.modelo.CaixasDAO;
import br.com.modelo.CentCustBean;
import br.com.modelo.CentCustDAO;
import br.com.modelo.CidadesBean;
import br.com.modelo.CidadesDAO;
import br.com.modelo.ClienPdvBean;
import br.com.modelo.ClienPdvDAO;
import br.com.modelo.ConSenTrBean;
import br.com.modelo.ConSenTrDAO;
import br.com.modelo.ConfiguracaoBean;
import br.com.modelo.ConfiguracaoDAO;
import br.com.modelo.ContasBean;
import br.com.modelo.ContasDAO;
import br.com.modelo.DevolucaBean;
import br.com.modelo.DevolucaDAO;
import br.com.modelo.DiCliNegBean;
import br.com.modelo.DiCliNegDAO;
import br.com.modelo.EmpresasBean;
import br.com.modelo.EmpresasDAO;
import br.com.modelo.FormPagtBean;
import br.com.modelo.FormPagtDAO;
import br.com.modelo.FuncionaBean;
import br.com.modelo.FuncionaDAO;
import br.com.modelo.ItConEntBean;
import br.com.modelo.ItConEntDAO;
import br.com.modelo.ItConSaiBean;
import br.com.modelo.ItConSaiDAO;
import br.com.modelo.ItPrVpdvBean;
import br.com.modelo.ItPrVpdvDAO;
import br.com.modelo.IteOrcamBean;
import br.com.modelo.IteOrcamDAO;
import br.com.modelo.IteVcPdvBean;
import br.com.modelo.IteVcPdvDAO;
import br.com.modelo.ItemDevoBean;
import br.com.modelo.ItemDevoDAO;
import br.com.modelo.ItemVpdvBean;
import br.com.modelo.ItemVpdvDAO;
import br.com.modelo.LancaIpdvBean;
import br.com.modelo.LancaIpdvDAO;
import br.com.modelo.LancamenBean;
import br.com.modelo.LanclPdvBean;
import br.com.modelo.LanclPdvDAO;
import br.com.modelo.LogExVdpBean;
import br.com.modelo.LogExVdpDAO;
import br.com.modelo.MaDesCliDAO;
import br.com.modelo.MaterPdvBean;
import br.com.modelo.MaterPdvDAO;
import br.com.modelo.MvCaipdvBean;
import br.com.modelo.MvCaipdvDAO;
import br.com.modelo.MvPrePdvBean;
import br.com.modelo.MvPrePdvDAO;
import br.com.modelo.NbmsUfBean;
import br.com.modelo.NbmsUfDAO;
import br.com.modelo.OperFiscBean;
import br.com.modelo.OperFiscDAO;
import br.com.modelo.OrcamentBean;
import br.com.modelo.OrcamentDAO;
import br.com.modelo.ParcfPgtBean;
import br.com.modelo.ParcfPgtDAO;
import br.com.modelo.PlanContBean;
import br.com.modelo.PlanContDAO;
import br.com.modelo.PreVdPdvBean;
import br.com.modelo.PreVdPdvDAO;
import br.com.modelo.ProximoIdDAO;
import br.com.modelo.VdaCaPdvBean;
import br.com.modelo.VdaCaPdvDAO;
import br.com.modelo.VendaPdvBean;
import br.com.modelo.VendaPdvDAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author raul
 */
public class Controle {

    private final ConfiguracaoDAO configuracaoDAO = new ConfiguracaoDAO();
    private final ProximoIdDAO proximoIdDAO = new ProximoIdDAO();
    private final MaterPdvDAO materPdvDAO = new MaterPdvDAO();
    private final ClienPdvDAO clienPdvDAO = new ClienPdvDAO();
    private final ParcfPgtDAO parcfPgtDAO = new ParcfPgtDAO();
    private final PlanContDAO planContDAO = new PlanContDAO();
    private final NbmsUfDAO nbmsUfDAO = new NbmsUfDAO();
    private final MaDesCliDAO maDesCliDAO = new MaDesCliDAO();
    private final LanclPdvDAO lanclPdvDAO = new LanclPdvDAO();
    private final FuncionaDAO funcionaDAO = new FuncionaDAO();
    private final FormPagtDAO formPagtDAO = new FormPagtDAO();
    private final EmpresasDAO empresasDAO = new EmpresasDAO();
    private final CidadesDAO cidadesDAO = new CidadesDAO();
    private final AliquotasDAO aliquotasDAO = new AliquotasDAO();
    private final ContasDAO contasDAO = new ContasDAO();
    private final ConSenTrDAO conSenTrDAO = new ConSenTrDAO();
    private final LancaIpdvDAO lancaIpdvDAO = new LancaIpdvDAO();
    private final ItConEntDAO itConEntDAO = new ItConEntDAO();
    private final ItConSaiDAO itConSaiDAO = new ItConSaiDAO();
    //-----
    private final ItemVpdvDAO itemVpdvDAO = new ItemVpdvDAO();
    private final IteVcPdvDAO iteVcPdvDAO = new IteVcPdvDAO();
    private final ItPrVpdvDAO itPrVpdvDAO = new ItPrVpdvDAO();
    private final MvCaipdvDAO mvCaipdvDAO = new MvCaipdvDAO();
    private final MvPrePdvDAO mvPrePdvDAO = new MvPrePdvDAO();
    private final PreVdPdvDAO preVdPdvDAO = new PreVdPdvDAO();
    private final VdaCaPdvDAO vdaCaPdvDAO = new VdaCaPdvDAO();
    private final VendaPdvDAO vendaPdvDAO = new VendaPdvDAO();
    private final OperFiscDAO operFiscDAO = new OperFiscDAO();
    private final CaixasDAO caixasDAO = new CaixasDAO();
    private final DevolucaDAO devolucaDAO = new DevolucaDAO();
    private final ItemDevoDAO itemDevoDAO = new ItemDevoDAO();
    private final DiCliNegDAO diCliNegDAO = new DiCliNegDAO();
    private final LogExVdpDAO logExVdpDAO = new LogExVdpDAO();
    private final CentCustDAO centCustDAO = new CentCustDAO();
    private final OrcamentDAO orcamentDAO = new OrcamentDAO();
    private final IteOrcamDAO iteOrcamDAO = new IteOrcamDAO();

    //----------------------------------------------------------------------------------------------------------------------------
    public Integer proximoId( String caCodigo, String nomeTabela) throws SQLException, ClassNotFoundException, IOException, Exception {
        return proximoIdDAO.proximoId(caCodigo, nomeTabela);
    }

    //--------------------------------------------------------------------------------------------------------------
    public ConfiguracaoBean pegarConfiguracao() throws Exception {
        return configuracaoDAO.pegarConfiguracao();
    }

    public void salvarConfig(ConfiguracaoBean config) throws Exception {
        configuracaoDAO.salvarConfig(config);
    }

    //--------------------------------------------------------------------------------------------------------------
    public void alerar(Connection pConn, MaterPdvBean aliquotaBean) throws SQLException, ClassNotFoundException, IOException, Exception {
        materPdvDAO.alerar(pConn, aliquotaBean);
    }

    public MaterPdvBean materPdvMfcodigo(String mfcodigo) throws SQLException, ClassNotFoundException, IOException, Exception {
        return materPdvDAO.materPdvMfcodigo(mfcodigo);
    }

    public MaterPdvBean materPdvCodIntern(String codintern) throws SQLException, ClassNotFoundException, IOException, Exception {
        return materPdvDAO.materPdvCodIntern(codintern);
    }

    public List<MaterPdvBean> listarMaterPdvNome(String nome) throws SQLException, ClassNotFoundException, IOException, Exception {
        return materPdvDAO.listarMaterPdvNome(nome);
    }

    public List<MaterPdvBean> listarMaterPdvReferencia(String referencia) throws SQLException, ClassNotFoundException, IOException, Exception {
        return materPdvDAO.listarMaterPdvReferencia(referencia);
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public void alerar(Connection pConn, ClienPdvBean clienPdvBean) throws SQLException, ClassNotFoundException, IOException, Exception {
        clienPdvDAO.alerar(pConn, clienPdvBean);
    }

    public ClienPdvBean clienPdvClcodigo(int clcodigo) throws SQLException, ClassNotFoundException, IOException, Exception {
        return clienPdvDAO.clienPdvClcodigo(clcodigo);
    }

    public List<ClienPdvBean> listarClienPdvNome(String nome) throws SQLException, ClassNotFoundException, IOException, Exception {
        return clienPdvDAO.listarClienPdvNome(nome);
    }

    public List<ClienPdvBean> listarClienPdvFantasia(String fantasia) throws SQLException, ClassNotFoundException, IOException, Exception {
        return clienPdvDAO.listarClienPdvFantasia(fantasia);
    }

    public List<ClienPdvBean> listarClienPdvCpf(String cpf) throws SQLException, ClassNotFoundException, IOException, Exception {
        return clienPdvDAO.listarClienPdvCpf(cpf);
    }

    public List<ClienPdvBean> listarClienPdvCgc(String cgc) throws SQLException, ClassNotFoundException, IOException, Exception {
        return clienPdvDAO.listarClienPdvCgc(cgc);
    }

    public Double clienTotalApagar(int clcodigo) throws SQLException, ClassNotFoundException, IOException, Exception {
        return clienPdvDAO.clienTotalApagar(clcodigo);
    }

    public Double clienTotalAvencer(int clcodigo, java.util.Date dataReferencia) throws SQLException, ClassNotFoundException, IOException, Exception {
        return clienPdvDAO.clienTotalAvencer(clcodigo, dataReferencia);
    }

    public Double clienTotalVencido(int clcodigo, java.util.Date dataReferencia) throws SQLException, ClassNotFoundException, IOException, Exception {
        return clienPdvDAO.clienTotalVencido(clcodigo, dataReferencia);
    }

    //--------------------------------------------------------------------------------------------------------------
    public ParcfPgtBean parcfPgtFpCodigo(String fpCodigo, String sequencia) throws SQLException, ClassNotFoundException, IOException, Exception {
        return parcfPgtDAO.parcfPgtFpCodigo(fpCodigo, sequencia);
    }

    public List<ParcfPgtBean> listaParcfPgt(String fpCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {
        return parcfPgtDAO.listaParcfPgt(fpCodigo);
    }

    //--------------------------------------------------------------------------------------------------------------
    public PlanContBean clienPdvPlCodigo(String plCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {
        return planContDAO.PlanContPlCodigo(plCodigo);
    }

    public List<PlanContBean> listaPlanCont() throws SQLException, ClassNotFoundException, IOException, Exception {
        return planContDAO.listaPlanCont();
    }

    //----------------------------------------------------------------------------------------------------------
    public NbmsUfBean listarNbmsUf(String nbCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {
        return nbmsUfDAO.listarNbmsUf(nbCodigo);
    }

    public List<NbmsUfBean> tabelaNbmsUf() throws SQLException, ClassNotFoundException, IOException, Exception {
        return nbmsUfDAO.tabelaNbmsUf();
    }

    //-----------------------------------------------------------------------------------------------------------------------------------
    public Double perDescontoCliente(String mfCodigo, Integer clCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {
        return maDesCliDAO.perDescontoCliente(mfCodigo, clCodigo);
    }

    //--------------------------------------------------------------------------------------------------------------------
    public LanclPdvBean listarLanclPdv(int lcCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {
        return lanclPdvDAO.listarLanclPdv(lcCodigo);
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public FuncionaBean funcionaFuCodigo(int fuCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {
        return funcionaDAO.funcionaFuCodigo(fuCodigo);
    }

    public FuncionaBean acessarUsuario(int fuCodigo, String senha) throws SQLException, ClassNotFoundException, IOException, Exception {
        return funcionaDAO.acessarUsuario(fuCodigo, senha);
    }

    public List<FuncionaBean> listarFuncionaFuCodigo() throws SQLException, ClassNotFoundException, IOException, Exception {
        return funcionaDAO.listarFuncionaFuCodigo();
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public FormPagtBean listarFormPagtFpCodigo(String fpCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {
        return formPagtDAO.listarFormPagtFpCodigo(fpCodigo);
    }

    public List<FormPagtBean> listarFormPagt() throws SQLException, ClassNotFoundException, IOException, Exception {
        return formPagtDAO.listarFormPagt();
    }

    public List<FormPagtBean> listarFormPagt(String tipoPgto) throws SQLException, ClassNotFoundException, IOException, Exception {
        return formPagtDAO.listarFormPagt(tipoPgto);
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public EmpresasBean listarEmpresasEmCodigo(int emCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {
        return empresasDAO.listarEmpresasEmCodigo(emCodigo);
    }

    public EmpresasBean pegarEmpresasBean() {
        return empresasDAO.pegarEmpresasBean();
    }

    //--------------------------------------------------------------------------------------------------------------------------
    public CidadesBean listarCidadesCiCodigo(int ciCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {
        return cidadesDAO.listarCidadesCiCodigo(ciCodigo);
    }

    //--------------------------------------------------------------------------------------------------------------
    public AliquotasBean listarAliquotaAlcodigo(int alcodigo) throws SQLException, ClassNotFoundException, IOException, Exception {
        return aliquotasDAO.listarAliquotaAlcodigo(alcodigo);
    }

    public List<AliquotasBean> tabelaAliquota() throws SQLException, ClassNotFoundException, IOException, Exception {
        return aliquotasDAO.tabelaAliquota();
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public ContasBean contascoCodigo(String coCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {
        return contasDAO.contascoCodigo(coCodigo);
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public ConSenTrBean conSenTrCgCodigo(int cgCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {
        return conSenTrDAO.conSenTrCgCodigo(cgCodigo);
    }

    //----------------------------------------------------------------------------------------------------------------
    public LancaIpdvBean LancaIpdv(LancaIpdvBean lancaIpdvBean) throws SQLException, ClassNotFoundException, IOException, Exception {
        return lancaIpdvDAO.LancaIpdv(lancaIpdvBean);
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public ItConEntBean itConEnt(int cgCodigo, int niConent) throws SQLException, ClassNotFoundException, IOException, Exception {
        return itConEntDAO.ItConEnt(cgCodigo, niConent);
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public ItConSaiBean ItConSai(int csCodigo, int niConsai) throws SQLException, ClassNotFoundException, IOException, Exception {
        return itConSaiDAO.ItConSai(csCodigo, niConsai);
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public ItemVpdvBean inserir(Connection pConn, String baixaEstoque, List<ItemVpdvBean> listaItem) throws SQLException, ClassNotFoundException, IOException, Exception {
        return itemVpdvDAO.inserir(pConn, baixaEstoque, listaItem);
    }

    public ItemVpdvBean retornoEstoque(String baixaEstoque, Connection pConn, List<ItemVpdvBean> listaItem) throws SQLException, ClassNotFoundException, IOException, Exception {
        return itemVpdvDAO.cancelarItensVenda(pConn, baixaEstoque, listaItem);
    }

    public ItemVpdvBean itemVpdvBean(String caCodigo, int vdCodigo, int numItem) throws SQLException, ClassNotFoundException, IOException, Exception {
        return itemVpdvDAO.itemVpdvBean(caCodigo, vdCodigo, numItem);
    }

    public List<ItemVpdvBean> listaItemVpdv(String caCodigo, Integer vdCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {
        return itemVpdvDAO.listaItemVpdv(caCodigo, vdCodigo);
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public IteVcPdvBean inserir(Connection pConn, IteVcPdvBean o) throws SQLException, ClassNotFoundException, IOException, Exception {
        return iteVcPdvDAO.inserir(pConn, o);
    }

    public IteVcPdvBean iteVcPdv(String caCodigo, int vdCodigo, int numItem) throws SQLException, ClassNotFoundException, IOException, Exception {
        return iteVcPdvDAO.iteVcPdv(caCodigo, vdCodigo, numItem);
    }

    public List<IteVcPdvBean> listarIteVcPdv(String mfCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {
        return iteVcPdvDAO.listarIteVcPdv(mfCodigo);
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public ItPrVpdvBean inserir(Connection pConn, List<ItPrVpdvBean> listaItem) throws SQLException, ClassNotFoundException, IOException, Exception {
        return itPrVpdvDAO.inserir(pConn, listaItem);
    }

    public ItPrVpdvBean itPrVpdv(int vdCodigo, int numItem) throws SQLException, ClassNotFoundException, IOException, Exception {
        return itPrVpdvDAO.itPrVpdv(vdCodigo, numItem);
    }

    public List<ItPrVpdvBean> listarItPrVpdv(String plCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {
        return itPrVpdvDAO.listarItPrVpdv(plCodigo);
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public MvCaipdvBean inserirMvCaipdv(Connection pConn, List<MvCaipdvBean> listaMvCaipdvBean) throws SQLException, ClassNotFoundException, IOException, Exception {
        return mvCaipdvDAO.inserir(pConn, listaMvCaipdvBean);
    }

    public MvCaipdvBean mvCaipdv(MvCaipdvBean mvCaipdvBean) throws SQLException, ClassNotFoundException, IOException, Exception {
        return mvCaipdvDAO.mvCaipdv(mvCaipdvBean);
    }

    public List<MvCaipdvBean> listarMvCaipdv() throws SQLException, ClassNotFoundException, IOException, Exception {
        return mvCaipdvDAO.listarMvCaipdv();
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public MvPrePdvBean inserir(Connection pConn, MvPrePdvBean o) throws SQLException, ClassNotFoundException, IOException, Exception {
        return mvPrePdvDAO.inserir(pConn, o);
    }

    public MvPrePdvBean mvPrePdv(MvPrePdvBean mvCaipdvBean) throws SQLException, ClassNotFoundException, IOException, Exception {
        return mvPrePdvDAO.mvPrePdv(mvCaipdvBean);
    }

    public List<MvPrePdvBean> listarMvPrePdv() throws SQLException, ClassNotFoundException, IOException, Exception {
        return mvPrePdvDAO.listarMvPrePdv();
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public PreVdPdvBean inserir(Connection pConn, PreVdPdvBean o) throws SQLException, ClassNotFoundException, IOException, Exception {
        return preVdPdvDAO.inserir(pConn, o);
    }

    public PreVdPdvBean emitirCupom(PreVdPdvBean o, List<ItPrVpdvBean> listaItPrVpdvBean) throws SQLException, ClassNotFoundException, IOException, Exception {
        return preVdPdvDAO.emitirCupom(o, listaItPrVpdvBean);
    }

    public PreVdPdvBean preVdPdv(int vdCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {
        return preVdPdvDAO.preVdPdv(vdCodigo);
    }

    public List<PreVdPdvBean> listarPreVdPdv() throws SQLException, ClassNotFoundException, IOException, Exception {
        return preVdPdvDAO.listarPreVdPdv();
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public VdaCaPdvBean inserir(Connection pConn, VdaCaPdvBean o) throws SQLException, ClassNotFoundException, IOException, Exception {
        return vdaCaPdvDAO.inserir(pConn, o);
    }

    public VdaCaPdvBean listarAliquotaAlcodigo(String caCodigo, int vdCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {
        return vdaCaPdvDAO.listarVdaCaPdv(caCodigo, vdCodigo);
    }

    public List<VdaCaPdvBean> listarVdaCaPdv() throws SQLException, ClassNotFoundException, IOException, Exception {
        return vdaCaPdvDAO.listarVdaCaPdv();
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public VendaPdvBean inserir(Connection pConn, VendaPdvBean o) throws SQLException, ClassNotFoundException, IOException, Exception {
        return vendaPdvDAO.inserir(pConn, o);
    }

    public void fecharVenda(VendaPdvBean o, List<ItemVpdvBean> listaItem, List<LancamenBean> listaLancamenBean, List<MvCaipdvBean> listaMvCaipdvBean) throws SQLException, ClassNotFoundException, IOException, Exception {
        vendaPdvDAO.fecharVenda(o, listaItem, listaLancamenBean, listaMvCaipdvBean);
    }

    public void cancelarVenda(VendaPdvBean o) throws SQLException, ClassNotFoundException, IOException, Exception {
        vendaPdvDAO.cancelarVenda(o);
    }

    public VendaPdvBean vendaPdv(int alcodigo) throws SQLException, ClassNotFoundException, IOException, Exception {
        return vendaPdvDAO.vendaPdv(alcodigo);
    }

    public List<VendaPdvBean> listarVendaPdv() throws SQLException, ClassNotFoundException, IOException, Exception {
        return vendaPdvDAO.listarVendaPdv();
    }

    public List<VendaPdvBean> listarVendaPdv(Date periodoInicial, Date periodoFinal) throws SQLException, ClassNotFoundException, IOException, Exception {
        return vendaPdvDAO.listarVendaPdv(periodoInicial, periodoFinal);
    }

    public List<VendaPdvBean> listarVendaPdv(String nome) throws SQLException, ClassNotFoundException, IOException, Exception {
        return vendaPdvDAO.listarVendaPdv(nome);
    }

    public List<VendaPdvBean> listarVendaPdv(Date periodoInicial, Date periodoFinal, String nome) throws SQLException, ClassNotFoundException, IOException, Exception {
        return vendaPdvDAO.listarVendaPdv(periodoInicial, periodoFinal, nome);
    }

    public List<VendaPdvBean> listarVendaPdvCpf(String cpf) throws SQLException, ClassNotFoundException, IOException, Exception {
        return vendaPdvDAO.listarVendaPdvCpf(cpf);
    }

    public List<VendaPdvBean> listarVendaPdvCpf(Date periodoInicial, Date periodoFinal, String cpf) throws SQLException, ClassNotFoundException, IOException, Exception {
        return vendaPdvDAO.listarVendaPdvCpf(periodoInicial, periodoFinal, cpf);
    }

    public List<VendaPdvBean> listarVendaPdvCgc(String cgc) throws SQLException, ClassNotFoundException, IOException, Exception {
        return vendaPdvDAO.listarVendaPdvCgc(cgc);
    }

    public List<VendaPdvBean> listarVendaPdvCgc(Date periodoInicial, Date periodoFinal, String cgc) throws SQLException, ClassNotFoundException, IOException, Exception {
        return vendaPdvDAO.listarVendaPdvCgc(periodoInicial, periodoFinal, cgc);
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public OperFiscBean operFiscOfcodigo(int ofcodigo) throws SQLException, ClassNotFoundException, IOException, Exception {
        return operFiscDAO.operFiscOfcodigo(ofcodigo);
    }

    public List<OperFiscBean> listarOperFisc() throws SQLException, ClassNotFoundException, IOException, Exception {
        return operFiscDAO.listarOperFisc();
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public CaixasBean caixasCacodigo(String caCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {
        return caixasDAO.caixasCacodigo(caCodigo);
    }

    public List<CaixasBean> listaCaixas() throws SQLException, ClassNotFoundException, IOException, Exception {
        return caixasDAO.listaCaixas();
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public DevolucaBean inserir(Connection pConn, DevolucaBean o) throws SQLException, ClassNotFoundException, IOException, Exception {
        return devolucaDAO.inserir(pConn, o);
    }

    public DevolucaBean devoluca(String caCodigo, Integer dvCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {
        return devolucaDAO.devoluca(caCodigo, dvCodigo);
    }

    public List<DevolucaBean> listarDevoluca() throws SQLException, ClassNotFoundException, IOException, Exception {
        return devolucaDAO.listarDevoluca();
    }

    public void fecharVendaDevolucao(DevolucaBean o, String retornarEstoque, List<ItemDevoBean> listaItem) throws SQLException, ClassNotFoundException, IOException, Exception {
        devolucaDAO.fecharVendaDevolucao(o, retornarEstoque, listaItem);
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public ItemVpdvBean inserirItemDevoBean(Connection pConn, String retornarEstoque, List<ItemDevoBean> listaItem) throws SQLException, ClassNotFoundException, IOException, Exception {
        return itemDevoDAO.inserir(pConn, retornarEstoque, listaItem);
    }

    public ItemDevoBean itemDevo(String caCodigo, Integer dvCodigo, Integer numItem) throws SQLException, ClassNotFoundException, IOException, Exception {
        return itemDevoDAO.itemDevo(caCodigo, dvCodigo, numItem);
    }

    public List<ItemDevoBean> listarItemDevo() throws SQLException, ClassNotFoundException, IOException, Exception {
        return itemDevoDAO.listarItemDevo();
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public DiCliNegBean DiCliNeg(String cnCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {
        return diCliNegDAO.DiCliNeg(cnCodigo);
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public LogExVdpBean inserir(Connection pConn, LogExVdpBean o) throws SQLException, ClassNotFoundException, IOException, Exception {
        return logExVdpDAO.inserir(pConn, o);
    }

    public LogExVdpBean LogExVdp(Integer lpCodigo, String caCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {
        return logExVdpDAO.LogExVdp(lpCodigo, caCodigo);
    }

    public List<LogExVdpBean> listarLogExVdp() throws SQLException, ClassNotFoundException, IOException, Exception {
        return logExVdpDAO.listarLogExVdp();
    }

    //----------------------------------------------------------------------------------------------------------------------------
    public CentCustBean listarCentCustCecodigo(String ceCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {
        return centCustDAO.listarCentCustCecodigo(ceCodigo);
    }

    public List<CentCustBean> tabelaCentCust() throws SQLException, ClassNotFoundException, IOException, Exception {
        return centCustDAO.tabelaCentCust();
    }

    //-------------------------------------------------------
    public void inserir(Connection pConn, OrcamentBean orcamentBean) throws SQLException, ClassNotFoundException, IOException, Exception {
        orcamentDAO.inserir(pConn, orcamentBean);
    }

    public OrcamentBean Orcament(int orcodigo) throws SQLException, ClassNotFoundException, IOException, Exception {
        return orcamentDAO.Orcament(orcodigo);
    }

    public List<OrcamentBean> listarOrcament() throws SQLException, ClassNotFoundException, IOException, Exception {
        return orcamentDAO.listarOrcament();
    }

    public void fecharOrcamento(OrcamentBean o, List<IteOrcamBean> listaItem) throws SQLException, ClassNotFoundException, IOException, Exception {
        orcamentDAO.fecharOrcamento(o, listaItem);
    }

        public List<OrcamentBean> listarOrcament(Date periodoInicial, Date periodoFinal) throws SQLException, ClassNotFoundException, IOException, Exception {
            return orcamentDAO.listarOrcament(periodoInicial, periodoFinal);
        }
        public List<OrcamentBean> listarOrcament(String nome) throws SQLException, ClassNotFoundException, IOException, Exception {
            return orcamentDAO.listarOrcament(nome);
        }

        public List<OrcamentBean> listarOrcament(Date periodoInicial, Date periodoFinal, String nome) throws SQLException, ClassNotFoundException, IOException, Exception {
            return orcamentDAO.listarOrcament(periodoInicial, periodoFinal, nome);
        }
    
    public List<OrcamentBean> listarOrcamentoCpf(String cpf) throws SQLException, ClassNotFoundException, IOException, Exception {
        return orcamentDAO.listarOrcamentoCpf(cpf);
    }

    public List<OrcamentBean> listarOrcamentoCpf(Date periodoInicial, Date periodoFinal, String cpf) throws SQLException, ClassNotFoundException, IOException, Exception {
        return orcamentDAO.listarOrcamentoCpf(periodoInicial, periodoFinal, cpf);
    }

    public List<OrcamentBean> listarOrcamentoCgc(String cgc) throws SQLException, ClassNotFoundException, IOException, Exception {
        return orcamentDAO.listarOrcamentoCgc(cgc);
    }

    public List<OrcamentBean> listarOrcamentoCgc(Date periodoInicial, Date periodoFinal, String cgc) throws SQLException, ClassNotFoundException, IOException, Exception {
        return orcamentDAO.listarOrcamentoCgc(periodoInicial, periodoFinal, cgc);
    }        
    //----------------------------------------------------------
    public List<IteOrcamBean> listarIteOrcam(int orcodigo) throws SQLException, ClassNotFoundException, IOException, Exception {
        return iteOrcamDAO.listarIteOrcam(orcodigo);
    }

    public IteOrcamBean IteOrcam(int orcodigo, int numItem) throws SQLException, ClassNotFoundException, IOException, Exception {
        return iteOrcamDAO.IteOrcam(orcodigo, numItem);
    }

    public void inserirIteOrcam(Connection pConn, List<IteOrcamBean> listaIteOrcamBean) throws SQLException, ClassNotFoundException, IOException, Exception {
        iteOrcamDAO.inserir(pConn, listaIteOrcamBean);
    }

}
