/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.visual;

import br.com.controle.Controle;
import br.com.modelo.ClienPdvBean;
import br.com.modelo.ConfiguracaoBean;
import br.com.modelo.DevolucaBean;
import br.com.modelo.EmpresasBean;
import br.com.modelo.FuncionaBean;
import br.com.modelo.ItPrVpdvBean;
import br.com.modelo.IteOrcamBean;
import br.com.modelo.ItemDevoBean;
import br.com.modelo.ItemVpdvBean;
import br.com.modelo.LancamenBean;
import br.com.modelo.MaterPdvBean;
import br.com.modelo.MvCaipdvBean;
import br.com.modelo.OperFiscBean;
import br.com.modelo.OrcamentBean;
import br.com.modelo.PreVdPdvBean;
import br.com.modelo.VendaPdvBean;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raul
 */
public class Caixa extends javax.swing.JFrame {

    private String horasVenda, baixaEstoque, origem, emitirCupom, orcamentFormaPgto;
    private String[] observacaoVenda = new String[8];
    private Date dataVenda, orcamentDataValid;
    private FuncionaBean funcionarioItem;
    private Integer numitem, codigoVendedor;
    private final Controle controle = new Controle();
    private static VendaPdvBean vendaPdvBean = new VendaPdvBean();
    private static PreVdPdvBean preVdPdvBean = new PreVdPdvBean();
    private static OrcamentBean orcamentBean = new OrcamentBean();
    private final MvCaipdvBean mvCaipdvBean = new MvCaipdvBean();
    private Double valorTotal, valorSubtotal, valorDesconto, valorAcrescimo;
    public static ConfiguracaoBean ConfiguracaoBean = new ConfiguracaoBean();
    public static EmpresasBean empresasBean;
    static ClienPdvBean clienPdvBean = new ClienPdvBean();
    static FuncionaBean funcionaBean = new FuncionaBean();
    static List<ItemVpdvBean> listaItens;
    private List<ItPrVpdvBean> listaItPrVpdvBean;
    private List<IteOrcamBean> listaIteOrcamBean;
    private List<LancamenBean> listaLancamenBean;
    private List<MvCaipdvBean> listaMvCaipdvBean;
    static StatusCaixa statusCaixa;
    private OperFiscBean operFiscBean = new OperFiscBean();

    /**
     * Creates new form Caixa
     */
    public Caixa() {

        initComponents();

        try {

            File f = new File(System.getProperty("user.dir") + "\\lib");
            if (!f.exists()) {
                JOptionPane.showMessageDialog(null,
                        "Pasta de biliotecas do sistema não foram encontradas. "
                        + "\n Entre em contato com suporte técnico.",
                        Constantes.AVISO_SISTEMA, JOptionPane.INFORMATION_MESSAGE);
                //System.exit(0);
            }

            setExtendedState(MAXIMIZED_BOTH);
            //------------------------------------
            ConfiguracaoBean = controle.pegarConfiguracao();
            empresasBean = controle.pegarEmpresasBean();

            //controle de acesso do sistema
            Date limite = Biblioteca.stringToDate(1, "01/12/2050");
            Date hoje = new java.util.Date();
            if (hoje.compareTo(limite) > 0) {
                statusCaixa = StatusCaixa.DESATIVADO;
            } else {
                statusCaixa = StatusCaixa.LIVRE;
            }
            //**************************************************************************
            verificarAcessoBanco();
            //**************************************************************************

            //---------------
            //papel de parede
            if (ConfiguracaoBean.getPapelParede() != null) {

                File papelParede = new File(ConfiguracaoBean.getPapelParede());
                if (papelParede.exists()) {

                    BufferedImage tmpImagen = ImageIO.read(papelParede);
                    ImagemFundoPanel fondo = new ImagemFundoPanel(tmpImagen);
                    panelPrincipal.setBorder(fondo);

                } else {
                    JOptionPane.showMessageDialog(rootPane,
                            "\n Arquivo de papel de parede: " + papelParede.getPath()
                            + "\n não foi encontrado. "
                            + "\n Entre em contado com Suporte Técnico."
                            + "\n Obrigado!"
                            + "\n"
                            + "\n", Constantes.AVISO_SISTEMA, JOptionPane.INFORMATION_MESSAGE);
                }
            }

            ImageIcon icone = new javax.swing.ImageIcon(Constantes.SH_ICONE);
            setIconImage(icone.getImage());

            //Exclusão de item -------------------------------------------------------------------------------------------------------------------
            DelAction delAction = new DelAction();
            tabelaItens.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "DelAction");
            tabelaItens.getActionMap().put("DelAction", delAction);

            //TECLA F1
            F1Action f1Action = new F1Action();
            labelF1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "F1Action");
            labelF1.getActionMap().put("F1Action", f1Action);

            //TECLA F2
            F2Action f2Action = new F2Action();
            labelF2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), "F2Action");
            labelF2.getActionMap().put("F2Action", f2Action);

            //TECLA F3
            F3Action f3Action = new F3Action();
            labelF3.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0), "F3Action");
            labelF3.getActionMap().put("F3Action", f3Action);

            //TECLA F4
            F4Action f4Action = new F4Action();
            labelF4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0), "F4Action");
            labelF4.getActionMap().put("F4Action", f4Action);

            //TECLA F5
            F5Action f5Action = new F5Action();
            labelF5.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0), "F5Action");
            labelF5.getActionMap().put("F5Action", f5Action);

            //TECLA F6
            F6Action f6Action = new F6Action();
            labelF6.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0), "F6Action");
            labelF6.getActionMap().put("F6Action", f6Action);

            //TECLA F7
            F7Action f7Action = new F7Action();
            labelF7.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0), "F7Action");
            labelF7.getActionMap().put("F7Action", f7Action);

            //TECLA ESC
            ESCAction escAction = new ESCAction();
            labelEsc.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESCAction");
            labelEsc.getActionMap().put("ESCAction", escAction);

            AcessoUsuario acessoUsuario = new AcessoUsuario(new JFrame(), true);
            acessoUsuario.setResizable(false);
            acessoUsuario.setModal(true);
            acessoUsuario.setVisible(true);
            if (acessoUsuario.getFuncionaBean() == null || acessoUsuario.getFuncionaBean().getFucodigo() == null) {
                System.exit(0);
            } else {
                funcionaBean = acessoUsuario.getFuncionaBean();
            }

            //**************************************************************************
            //************** CONFIG DA BARRA STATUS ************************************
            //**************************************************************************
            //HABILITAR DEPOIS - senao o debugador so fica rodando aqui
            Thread clockThread = new Thread(new DataHoras(), "Clock thread");
            clockThread.setDaemon(true);
            clockThread.start();
            labelNumCaixa.setText("Caixa Nº: " + ConfiguracaoBean.getNumeroCaixa());
            labelOperador.setText("Operador: " + funcionaBean.getNome());

            //usado fechamento da venda -----------------------------------------------            
            origem = "MOVIM";

            //-----------------------------
            formatarTabelaItens();

            //-----------
            telaInicial();

            //************************************
            //area de teste
            //************************************
            //************************************
        } catch (Exception ex) {
            Loggin.logDiarioExcecao(ex, true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelPrincipal = new javax.swing.JPanel();
        labelStatusCaixa = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaItens = new javax.swing.JTable();
        lydEntradas = new javax.swing.JLayeredPane();
        lydQuantidade = new javax.swing.JLayeredPane();
        ftfQuantidade = new javax.swing.JFormattedTextField();
        lydItem = new javax.swing.JLayeredPane();
        ftfCodigoItem = new javax.swing.JFormattedTextField();
        lydSobreSistema = new javax.swing.JLayeredPane();
        labelSubtotal1 = new javax.swing.JLabel();
        lydSubtotal = new javax.swing.JLayeredPane();
        labelSubtotal = new javax.swing.JLabel();
        lydLegenda = new javax.swing.JLayeredPane();
        labelF1 = new javax.swing.JLabel();
        labelF2 = new javax.swing.JLabel();
        labelF3 = new javax.swing.JLabel();
        labelF4 = new javax.swing.JLabel();
        labelF5 = new javax.swing.JLabel();
        labelF6 = new javax.swing.JLabel();
        labelF7 = new javax.swing.JLabel();
        labelEsc = new javax.swing.JLabel();
        separador = new javax.swing.JSeparator();
        panelBarraSatus = new javax.swing.JPanel();
        labelSistema = new javax.swing.JLabel();
        labelHoras = new javax.swing.JLabel();
        labelDataAtual = new javax.swing.JLabel();
        labelNumCaixa = new javax.swing.JLabel();
        labelOperador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("   X2 Sistemas de Informação  versão: 2.01");
        setMinimumSize(new java.awt.Dimension(1024, 768));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        panelPrincipal.setName(""); // NOI18N
        panelPrincipal.setPreferredSize(new java.awt.Dimension(1024, 798));

        labelStatusCaixa.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        labelStatusCaixa.setForeground(new java.awt.Color(255, 255, 0));
        labelStatusCaixa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelStatusCaixa.setText("CAIXA LIVRE");
        labelStatusCaixa.setMaximumSize(new java.awt.Dimension(102, 40));
        labelStatusCaixa.setMinimumSize(new java.awt.Dimension(102, 40));
        labelStatusCaixa.setPreferredSize(new java.awt.Dimension(102, 40));

        tabelaItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descricação", "Unidade", "Quantidade", "Valor", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaItens);

        lydEntradas.setLayout(new java.awt.GridLayout(1, 0));

        lydQuantidade.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quantidade:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        lydQuantidade.setPreferredSize(new java.awt.Dimension(350, 87));
        lydQuantidade.setLayout(new java.awt.GridLayout(1, 0));

        ftfQuantidade.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ftfQuantidade.setText("1");
        ftfQuantidade.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        ftfQuantidade.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ftfQuantidadeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ftfQuantidadeFocusLost(evt);
            }
        });
        ftfQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ftfQuantidadeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ftfQuantidadeKeyReleased(evt);
            }
        });
        lydQuantidade.add(ftfQuantidade);

        lydEntradas.add(lydQuantidade);

        lydItem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Código/Código de Barras:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        lydItem.setPreferredSize(new java.awt.Dimension(350, 98));
        lydItem.setLayout(new java.awt.GridLayout(1, 0));

        ftfCodigoItem.setBorder(null);
        ftfCodigoItem.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ftfCodigoItem.setFont(new java.awt.Font("Verdana", 0, 48)); // NOI18N
        ftfCodigoItem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ftfCodigoItemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ftfCodigoItemFocusLost(evt);
            }
        });
        ftfCodigoItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ftfCodigoItemKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ftfCodigoItemKeyReleased(evt);
            }
        });
        lydItem.add(ftfCodigoItem);

        lydEntradas.add(lydItem);

        lydSobreSistema.setLayout(new java.awt.GridLayout(1, 0));

        labelSubtotal1.setFont(new java.awt.Font("Verdana", 2, 24)); // NOI18N
        labelSubtotal1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSubtotal1.setText("X2 - Commercial System");
        labelSubtotal1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lydSobreSistema.add(labelSubtotal1);

        lydSubtotal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Subtotal:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        lydSubtotal.setLayout(new java.awt.GridLayout(1, 0));

        labelSubtotal.setFont(new java.awt.Font("Verdana", 0, 48)); // NOI18N
        labelSubtotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelSubtotal.setText("R$ 1000,00");
        lydSubtotal.add(labelSubtotal);

        lydLegenda.setMinimumSize(new java.awt.Dimension(18, 18));
        lydLegenda.setPreferredSize(new java.awt.Dimension(1020, 20));
        lydLegenda.setLayout(new java.awt.GridBagLayout());

        labelF1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelF1.setText("| F1-Ajuda");
        labelF1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelF1MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        lydLegenda.add(labelF1, gridBagConstraints);

        labelF2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelF2.setText("| F2-Consultar Item");
        labelF2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelF2MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        lydLegenda.add(labelF2, gridBagConstraints);

        labelF3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelF3.setText("| F3-Consultar Clientes");
        labelF3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelF3MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        lydLegenda.add(labelF3, gridBagConstraints);

        labelF4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelF4.setText("| F4-Fechar Venda/Orcamento");
        labelF4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelF4MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        lydLegenda.add(labelF4, gridBagConstraints);

        labelF5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelF5.setText("| F5-Cancelar");
        labelF5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelF5MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        lydLegenda.add(labelF5, gridBagConstraints);

        labelF6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelF6.setText("| F6-Calculadora");
        labelF6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelF6MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        lydLegenda.add(labelF6, gridBagConstraints);

        labelF7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelF7.setText("| F7-Opções");
        labelF7.setToolTipText("");
        labelF7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelF7MouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        lydLegenda.add(labelF7, gridBagConstraints);

        labelEsc.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelEsc.setText("| ESC - Sair");
        labelEsc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelEscMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        lydLegenda.add(labelEsc, gridBagConstraints);

        panelBarraSatus.setPreferredSize(new java.awt.Dimension(724, 20));
        panelBarraSatus.setLayout(new java.awt.GridBagLayout());

        labelSistema.setText("   X2 Sistemas de Informatica  versão: 2.01");
        labelSistema.setMaximumSize(new java.awt.Dimension(250, 14));
        labelSistema.setMinimumSize(new java.awt.Dimension(250, 14));
        labelSistema.setPreferredSize(new java.awt.Dimension(250, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        panelBarraSatus.add(labelSistema, gridBagConstraints);

        labelHoras.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelHoras.setText("15:17");
        labelHoras.setMaximumSize(new java.awt.Dimension(40, 14));
        labelHoras.setMinimumSize(new java.awt.Dimension(40, 14));
        labelHoras.setPreferredSize(new java.awt.Dimension(40, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        panelBarraSatus.add(labelHoras, gridBagConstraints);

        labelDataAtual.setText("19 Janeiro de 2015");
        labelDataAtual.setMaximumSize(new java.awt.Dimension(300, 14));
        labelDataAtual.setMinimumSize(new java.awt.Dimension(300, 14));
        labelDataAtual.setPreferredSize(new java.awt.Dimension(300, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        panelBarraSatus.add(labelDataAtual, gridBagConstraints);

        labelNumCaixa.setText("Nº Caixa: 56");
        labelNumCaixa.setMaximumSize(new java.awt.Dimension(100, 14));
        labelNumCaixa.setMinimumSize(new java.awt.Dimension(100, 14));
        labelNumCaixa.setPreferredSize(new java.awt.Dimension(100, 14));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        panelBarraSatus.add(labelNumCaixa, gridBagConstraints);

        labelOperador.setText("Operardor: Juliana Paes Santos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        panelBarraSatus.add(labelOperador, gridBagConstraints);

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelStatusCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lydEntradas)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addComponent(lydSobreSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lydSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(lydLegenda, javax.swing.GroupLayout.DEFAULT_SIZE, 1204, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(panelBarraSatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(separador)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(labelStatusCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lydEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(lydSobreSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                        .addComponent(lydSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(lydLegenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBarraSatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(panelPrincipal);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void labelF4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelF4MouseClicked
        try {
            fecharMovimentacao();
        } catch (Exception ex) {
            Loggin.logDiarioExcecao(ex, true);
        }
    }//GEN-LAST:event_labelF4MouseClicked

    private void labelF3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelF3MouseClicked
        ConsultarClientes();
    }//GEN-LAST:event_labelF3MouseClicked

    private void labelF2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelF2MouseClicked
        ConsultarItens();
    }//GEN-LAST:event_labelF2MouseClicked

    private void labelF6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelF6MouseClicked
        teclouF6Calculadora();
    }//GEN-LAST:event_labelF6MouseClicked

    private void labelF1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelF1MouseClicked
        labelF1Ajuda();
    }//GEN-LAST:event_labelF1MouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        teclouESC();
    }//GEN-LAST:event_formWindowClosing

    private void labelEscMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEscMouseClicked
        teclouESC();
    }//GEN-LAST:event_labelEscMouseClicked

    private void ftfCodigoItemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftfCodigoItemKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) { //pressionou ENTER
            lancarItens();
        }
    }//GEN-LAST:event_ftfCodigoItemKeyPressed

    private void labelF5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelF5MouseClicked
        teclouF5();
    }//GEN-LAST:event_labelF5MouseClicked

    private void labelF7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelF7MouseClicked
        teclouF7();
    }//GEN-LAST:event_labelF7MouseClicked

    private void ftfQuantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftfQuantidadeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) { //pressionou ENTER
            ftfCodigoItem.requestFocus();
        }
    }//GEN-LAST:event_ftfQuantidadeKeyPressed

    private void ftfQuantidadeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ftfQuantidadeFocusGained
        ftfQuantidade.setBackground(Color.yellow);
        ftfQuantidade.selectAll();
    }//GEN-LAST:event_ftfQuantidadeFocusGained

    private void ftfCodigoItemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftfCodigoItemKeyReleased

        //validando digitacao
        if (evt.getKeyCode() != KeyEvent.VK_ESCAPE && evt.getKeyCode() != KeyEvent.VK_MULTIPLY) {
            if (evt.getKeyChar() != '￿' && evt.getKeyChar() != ',' && evt.getKeyChar() != '.' && evt.getKeyChar() != '1' && evt.getKeyChar() != '2' && evt.getKeyChar() != '3' && evt.getKeyChar() != '4' && evt.getKeyChar() != '5' && evt.getKeyChar() != '6' && evt.getKeyChar() != '7' && evt.getKeyChar() != '8' && evt.getKeyChar() != '9' && evt.getKeyChar() != '0') {
                ftfCodigoItem.setText("");
            }
        }

        //pressionou * calculando a quantidade
        if (evt.getKeyCode() == KeyEvent.VK_MULTIPLY) {
            String qtd = ftfCodigoItem.getText().substring(0, ftfCodigoItem.getText().length() - 1);
            ftfQuantidade.setText(qtd);
            ftfCodigoItem.setText("");
        }
    }//GEN-LAST:event_ftfCodigoItemKeyReleased

    private void ftfQuantidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftfQuantidadeKeyReleased

        //validando digitacao
        if (evt.getKeyCode() != KeyEvent.VK_ESCAPE && evt.getKeyCode() != KeyEvent.VK_MULTIPLY) {
            if (evt.getKeyChar() != '￿' && evt.getKeyChar() != ',' && evt.getKeyChar() != '.' && evt.getKeyChar() != '1' && evt.getKeyChar() != '2' && evt.getKeyChar() != '3' && evt.getKeyChar() != '4' && evt.getKeyChar() != '5' && evt.getKeyChar() != '6' && evt.getKeyChar() != '7' && evt.getKeyChar() != '8' && evt.getKeyChar() != '9' && evt.getKeyChar() != '0') {
                ftfQuantidade.setText("");
            }
        }
    }//GEN-LAST:event_ftfQuantidadeKeyReleased

    private void ftfCodigoItemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ftfCodigoItemFocusGained
        ftfCodigoItem.setBackground(Color.yellow);
    }//GEN-LAST:event_ftfCodigoItemFocusGained

    private void ftfCodigoItemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ftfCodigoItemFocusLost
        ftfCodigoItem.setBackground(Color.white);
    }//GEN-LAST:event_ftfCodigoItemFocusLost

    private void ftfQuantidadeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ftfQuantidadeFocusLost
        ftfQuantidade.setBackground(Color.white);
    }//GEN-LAST:event_ftfQuantidadeFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            Loggin.logDiarioExcecao(ex, true);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Caixa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField ftfCodigoItem;
    private javax.swing.JFormattedTextField ftfQuantidade;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDataAtual;
    private javax.swing.JLabel labelEsc;
    private javax.swing.JLabel labelF1;
    private javax.swing.JLabel labelF2;
    private javax.swing.JLabel labelF3;
    private javax.swing.JLabel labelF4;
    private javax.swing.JLabel labelF5;
    private javax.swing.JLabel labelF6;
    private javax.swing.JLabel labelF7;
    private javax.swing.JLabel labelHoras;
    private javax.swing.JLabel labelNumCaixa;
    private javax.swing.JLabel labelOperador;
    private javax.swing.JLabel labelSistema;
    private javax.swing.JLabel labelStatusCaixa;
    private javax.swing.JLabel labelSubtotal;
    private javax.swing.JLabel labelSubtotal1;
    private javax.swing.JLayeredPane lydEntradas;
    private javax.swing.JLayeredPane lydItem;
    private javax.swing.JLayeredPane lydLegenda;
    private javax.swing.JLayeredPane lydQuantidade;
    private javax.swing.JLayeredPane lydSobreSistema;
    private javax.swing.JLayeredPane lydSubtotal;
    private javax.swing.JPanel panelBarraSatus;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JSeparator separador;
    private javax.swing.JTable tabelaItens;
    // End of variables declaration//GEN-END:variables

    private boolean lancarItens() {

        Boolean ok = false;
        MaterPdvBean materPdvBean;
        try {

            if (ftfCodigoItem.getText() != null && !ftfCodigoItem.getText().isEmpty()) {

                String codigoItem = Biblioteca.removerCaracteresEspeciais(ftfCodigoItem.getText());

                materPdvBean = controle.materPdvMfcodigo(codigoItem);

                if (materPdvBean != null && !materPdvBean.getMfcodigo().isEmpty()) {

                    //-----------------------------------------------
                    if (listaItens == null || listaItens.isEmpty()) {
                        abrirVenda();
                    }
                    //--------------------------------------------
                    if (ConfiguracaoBean.getFuncionarioItem().equalsIgnoreCase("1")) {
                        ConsultarFuncionario consultarFuncionario = new ConsultarFuncionario(new JFrame(), true);
                        consultarFuncionario.setResizable(false);
                        consultarFuncionario.setModal(true);
                        consultarFuncionario.setFuncionaBean(funcionarioItem);
                        consultarFuncionario.setVisible(true);

                        funcionarioItem = consultarFuncionario.getFuncionaBean();
                        if (funcionarioItem == null) {
                            return ok;
                        }
                    }

                    ok = compoemItemVpdvBean(materPdvBean);
                    if (ok) {//mostrar na tela
                        atualizarTela(listaItens.get(listaItens.size() - 1)); //ultimo item lancado
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Produto não encontrado.", Constantes.AVISO_SISTEMA, JOptionPane.WARNING_MESSAGE);
                }

            } else {

                ftfQuantidade.selectAll();
                ftfQuantidade.requestFocus();
            }

        } catch (Exception ex) {
            Loggin.logDiarioExcecao(ex, true);
        }
        return ok;
    }

    private Boolean compoemItemVpdvBean(MaterPdvBean materPdvBean) {

        Boolean ok = false;
        ItemVpdvBean itemVpdvBean = new ItemVpdvBean();

        Double quantidade = Double.valueOf(ftfQuantidade.getText());

        if (statusCaixa == StatusCaixa.DESATIVADO) {
            labelStatusCaixa.setText("Ativar Sistema");
        } else {
            labelStatusCaixa.setText(materPdvBean.getNome());
        }

        //*******************************************
        //Itens da Venda: (Tabela-ITEMVPDV / ITPRVPDV)
        //*******************************************
        itemVpdvBean.setCacodigo(ConfiguracaoBean.getNumeroCaixa());//35 CACODIGO C 3 Código do caixa 390 392          
        itemVpdvBean.setVdcodigo(null);//1 VDCODIGO N 8 Código da venda S 1 8 
        itemVpdvBean.setNumitem(++numitem);//2 NUMITEM N 3 Numero do item da venda S 9 11 
        itemVpdvBean.setMfcodigo(materPdvBean.getMfcodigo());//3 MFCODIGO C 13 Código do produto S 12 24 
        itemVpdvBean.setPlcodigo(ConfiguracaoBean.getPlanoContas());//4 PLCODIGO C 10 Código do plano de contas 25 34
        itemVpdvBean.setQtditem(quantidade);//5 QTDITEM N 10 3 Quantidade do item S 35 44 
        itemVpdvBean.setValitem(materPdvBean.getPrecoven() * quantidade);//6 VALITEM N 10 2 Valor do total do item S 45 54
        itemVpdvBean.setFucodigo((funcionarioItem != null && funcionarioItem.getFucodigo() != null) ? funcionarioItem.getFucodigo() : 0);//7 FUCODIGO N 6 Código do funcionário 55 60
        itemVpdvBean.setFucodlan(1);//74 FUCODLAN N 6 Garçom que realizou o pedido do item 853 858        
        itemVpdvBean.setFucoddes(0);//59 FUCODDES C 6 Identificação do Funcionário que deu o desconto 641 646         
        itemVpdvBean.setSeqtotecf("");//91 SEQTOTECF C 2 Sequencial do Totalizador na ECF 1061 1062 
        itemVpdvBean.setAliqicms(materPdvBean.getAliqicms());//8 ALIQICMS N 4 2 Alíquota de ICMS S 61 64         
        itemVpdvBean.setCodtrib(materPdvBean.getCodtrib());//9 CODTRIB C 1 Código de tributação S 65 65
        itemVpdvBean.setDesctrib("");//60 DESCTRIB C 3 Descrição da Tributação 647 649          
        itemVpdvBean.setNumdocum("");//10 NUMDOC C 15 Número do documento S 66 80 
        itemVpdvBean.setPrcunit(materPdvBean.getPrecoven());//11 PRCUNIT N 16 3 Preço unitário do item S 81 96         
        itemVpdvBean.setMmfcodigo(materPdvBean.getMfcodigo());//12 MMFCODIGO C 13 Código do Produto Para Venda S 97 109 
        itemVpdvBean.setNome(materPdvBean.getNome());//42 NOME C 64 Nome do material completo 458 521                                      
        itemVpdvBean.setUncodigo(materPdvBean.getUncodigo());//14 UNCODIGO C 2 Código da Unidade S 150 151 
        itemVpdvBean.setPrecoven(materPdvBean.getPrecoven());//15 PRECOVEN N 10 2 Preço de Venda Do Produto S 152 161 
        itemVpdvBean.setMaliqicms(0.0);//16 MALIQICMS N 4 2 Alíquota de ICMS S 162 165
        itemVpdvBean.setCodorige(materPdvBean.getCodorige());//17 CODORIGE C 1 Código de Origem Do Produto S 166 166 
        itemVpdvBean.setMcodtrib("");//18 MCODTRIB C 1 Código de Tributação S 167 167 
        itemVpdvBean.setPesavel(materPdvBean.getPesavel());//19 PESAVEL C 1 Produto Pesável (S - Sim / N - Não) S 168 168            
        itemVpdvBean.setAliqipi(materPdvBean.getAliqipi());//21 ALIQIPI N 4 2 Alíquota de IPI S 170 173  
        itemVpdvBean.setCodextra(materPdvBean.getCodextra());//22 CODEXTRA C 13 Código do Produto com Suporte Físico (Extra) 174 186               
        itemVpdvBean.setReferenci(materPdvBean.getReferenci());//23 REFERENCI C 20 Código de Referencia do Produto 187 206      
        itemVpdvBean.setGrade(materPdvBean.getGrade());//24 GRADE C 11 Grade de Tamanho do Produto 207 217        
        itemVpdvBean.setCor(materPdvBean.getCor());//25 COR C 10 Código Cor do Produto 218 227         
        itemVpdvBean.setTamanho(materPdvBean.getTamanho());//26 TAMANHO C 6 Tamanho do Produto 228 233      
        itemVpdvBean.setCodintern(materPdvBean.getCodintern());//27 CODINTERN C 13 Código Interno no Sistema de Retaguarda 234 246        
        itemVpdvBean.setTipotribu(materPdvBean.getTipotribu());//28 TIPOTRIB C 1 Tipo de Tributação: (P - Produto / S - Serviço) S 247 247       
        itemVpdvBean.setPrecoven1(materPdvBean.getPrecoven());//29 PRECOVEN1 N 10 3 Preço de Venda com 3 casas decimais (Se preenchido será assumido como o preço de venda) 248 257        
        itemVpdvBean.setQtdestoq(materPdvBean.getQtdestoq());
        itemVpdvBean.setPathfoto(materPdvBean.getPathfoto());//31 PATHFOTO C 80 Caminho onde o sistema buscará a foto do produto 274 353        
        itemVpdvBean.setAgcodigo(materPdvBean.getAgcodigo());//32 AGCODIGO C 16 Agrupamento do produto 354 369 
        itemVpdvBean.setExcluido("N");//101 EXCLUIDO C 1 Se o item foi excluído 1171 1171
        itemVpdvBean.setFlagtrans("N"); //rogerio
        itemVpdvBean.setFlagtserv("N"); //rogerio
        itemVpdvBean.setDeprotot(0.0);//33 DEPROTOT N 10 2 Valor do rateio do desconto da venda para este item 370 379
        itemVpdvBean.setAcprotot(0.0);//34 ACPROTOT N 10 2 Valor do rateio do acréscimo da venda para este item 380 389         
        itemVpdvBean.setComposto(materPdvBean.getComposto());//36 COMPOSTO C 1 Produto Composto 393 393   
        itemVpdvBean.setCacodori(ConfiguracaoBean.getNumeroCaixa());//37 CACODORI C 3 Caixa de Origem 394 396        
        itemVpdvBean.setSetorori("");//38 SETORORI C 30 Setor de origem 397 426
        itemVpdvBean.setCodrecei("");//39 CODRECEI C 13 Código da receita 427 439         
        itemVpdvBean.setHorarece("");//40 HORARECE C 8 Hora da receita 440 447         
        itemVpdvBean.setQtdrecei(0.0);//41 QTDRECEI N 10 3 Quantidade da receita 448 457        
        itemVpdvBean.setComandaok("N");//43 COMANDAOK C 1 Se a comanda finalizou OK 522 522         
        itemVpdvBean.setDatacoma(null);//44 DATACOMA D 8 Data de Emissão da Comanda 523 530                 
        itemVpdvBean.setTipofab(materPdvBean.getTipofab());//46 TIPOFAB C 1 Tipo de Propriedade P-própria/T-terceiros 537 537         
        itemVpdvBean.setIat(materPdvBean.getIat());//47 IAT C 1 Índice de Arredondamento ou Truncamento 538 538         
        itemVpdvBean.setMesaoritr(0);//48 MESAORITR C 8 Número da Mesa de Origem 539 546         
        itemVpdvBean.setMbcodigo(0);//49 MBCODIGO C 8 Código do Item de movimentação da Tabela MoviBico 547 554

        //posto combustivel
        itemVpdvBean.setTqcodigo("");//50 TQCODIGO C 3 Código do Tanque 555 557         
        itemVpdvBean.setBmcodigo("");//51 BMCODIGO C 3 Código da Bomba 558 560         
        itemVpdvBean.setBicodigo("");//52 BICODIGO C 6 Código do Bico 561 566         
        itemVpdvBean.setDescbico("");//53 DESCBICO C 6 Descrição do Bico 567 572          
        itemVpdvBean.setEncinici(0.0);//54 ENCINICi N 16 3 Encerrante Inicial 573 588         
        itemVpdvBean.setEncfinal(0.0);//55 ENCFINAL N 16 3 Encerrante Final 589 604         

        itemVpdvBean.setCartaopas("");//56 CARTAOPAS C 20 Cartão de Passagem 605 624         
        itemVpdvBean.setPosimesa("");//57 POSIMESA C 10 Posição da mesa 625 634         
        itemVpdvBean.setCvcodigo("");//58 CVCODIGO C 6 Código do Convênio 635 640        
        itemVpdvBean.setVaspartida("");//61 VASPARTIDA C 10 Dados da Vacina 650 659
        itemVpdvBean.setVasvencime("");//62 VASVENCIME C 7 Dados da Vacina 660 666         
        itemVpdvBean.setVastipo("");//63 VASTIPO C 20 Dados da Vacina 667 686                 
        itemVpdvBean.setVasfocodig(0);//64 VASFOCODIG N 8 Dados da Vacina 687 694    
        itemVpdvBean.setVascodprod("");//65 VASCODPROD C 15 Dados da Vacina 695 709
        itemVpdvBean.setVasnomecid("");//66 VASNOMECID C 50 Dados da Vacina 710 759
        itemVpdvBean.setOrigem(origem);//67 ORIGEM C 5 Origem da Venda 760 764                
        itemVpdvBean.setMecodigo(0);//68 MECODIGO N 8 Código da Mesa 765 772       
        itemVpdvBean.setPrecocus(materPdvBean.getPrecocus());//69 PRECOCUS N 16 6 Preço de custo 773 788     
        itemVpdvBean.setPrccumed(materPdvBean.getPrccumed());//70 PRCCUMED N 16 6 Preço de custo Medio 789 804  
        itemVpdvBean.setPrccucon(materPdvBean.getPrccucon());//71 PRCCUCON N 16 6 Preço de custo contábil 805 820      
        itemVpdvBean.setPrccumec(0.0);//72 PRCCUMEC N 16 6 Preço de custo Medio Contábil 821 836
        itemVpdvBean.setPrecoref(0.0);//73 PRECOREF N 16 6 Preço de referência 837 852        

        //dados da impressora
        itemVpdvBean.setEcfserie("X2");//75 ECFSERIE C 20 Numero de serie da ecf 859 878    
        itemVpdvBean.setNumerocoo(0);//76 NUMEROCOO N 6 Numero do COO 879 884        
        itemVpdvBean.setNumcupom(0);//77 NUMCUPOM N 6 Numero do Cupom 885 890 
        itemVpdvBean.setPafindcanc("");//78 PAFINDCANC C 1 Indicador de cancelamento 891 891        
        itemVpdvBean.setModelodoc("");//79 MODELODOC C 3 Modelo do documento 892 894   
        itemVpdvBean.setPafhashver("");//102 PAFHASHVER C 10 Versao do PAFECF 1172 1181        
        itemVpdvBean.setPafhashdet("");

        itemVpdvBean.setCstpis("");//81 CSTPIS C 3 CST do Pis 927 929         
        itemVpdvBean.setVlrbcpis(0.0);//82 VLRBCPIS N 16 3 Valor da Base do Pis 930 945         
        itemVpdvBean.setAliqpis(0.0);//83 ALIQPIS N 16 3 Aliquota de Pis 946 961       
        itemVpdvBean.setValorpis(0.0);//84 VALORPIS N 16 3 Valor do Pis 962 977         
        itemVpdvBean.setVlrpisst(0.0);//85 VLRPISST N 16 3 Valor da ST do Pis 978 993      
        itemVpdvBean.setCstcofin("");//86 CSTCOFIN C 3 CST do Cofins 994 996          
        itemVpdvBean.setVlrbccfs(0.0);//87 VLRBCCFS N 16 3 Valor da Base do Cofins 997 1012
        itemVpdvBean.setAliqcfs(0.0);//88 ALIQCFS N 16 3 Aliquota de Cofins 1013 1028     
        itemVpdvBean.setValorcfs(0.0);//89 VALORCFS N 16 3 Valor do Cofins 1029 1044      
        itemVpdvBean.setVlrcfsst(0.0);//90 VLRCFSST N 16 3 Valor da ST do Cofins  1045 1060        

        itemVpdvBean.setNumitemdav(0);//92 NUMITEMDAV N 6 Numero do item do DAV 1063 1068  
        itemVpdvBean.setDatadamov(new java.util.Date());//93 DATADAMOV  C 14 Data da Movimentação da ECF 1069 1082         
        itemVpdvBean.setEcfseque("");//94 ECFSEQUE C 4 Sequencial do ECF da Loja 1083 1086         
        itemVpdvBean.setEcfmarca("");//95 ECFMARCA C 25 Marca ECF 1087 1111         
        itemVpdvBean.setEcfmodelo("");//96 ECFMODELO C 25 Modelo ECF 1112 1136          
        itemVpdvBean.setEcftipo("");//97 ECFTIPO C 15 Tipo do ECF 1137 1151   
        itemVpdvBean.setSwbversao("");//98 SWBVERSAO C 10 Versão do Soft.Básico da ECF 1152 1161        
        itemVpdvBean.setSwbdthrgr(null);//99 SWBDTHRGR D 8 Data da Versão do Soft.Básico da ECF 1162 1169 
        itemVpdvBean.setSwbmfadic("N");//100 SWBMFADIC C 1 MF adicional 1170 1170         
        itemVpdvBean.setArcodigo(0);
        itemVpdvBean.setQtddevol(0.0);
        itemVpdvBean.setDadomaqu("");//103 DADOMAQU C 30 Reservado não utilizado 1182 1211
        itemVpdvBean.setHorapedi(null);
        itemVpdvBean.setDesccomp("");

        //-----------------------------
        listaItens.add(itemVpdvBean);
        valorSubtotal += materPdvBean.getPrecoven() * quantidade;
        valorTotal += materPdvBean.getPrecoven() * quantidade;
        //funcionarioItem = null; deixar o ultimo vendedor selecionado como padrao para proximo lancamento
        ok = true;
        return ok;
    }

    public void compoemVendaPdvBean() throws Exception {

        Integer proximoIdVendaPdvBean = controle.proximoId(ConfiguracaoBean.getNumeroCaixa(), "vendaPdv");

        //********************************************
        //Capa da Venda: (Tabela-VENDAPDV / PREVDPDV)
        //********************************************
        //36 CLCODIGO2 N 9 Código aumentado do Cliente. (Para base com código de cliente com até 9 dígitos. Se vier preenchido será assumido como código do cliente) FK 603 611
        //37 CLCODPAI2 N 9 Código aumentado do Cliente Pai. (Para base com código de cliente com até 9 dígitos. Se vier preenchido será assumido como código do cliente) FK 612 620
        //95 NUMORCAM C 10 Número do Orçamento 1637 1646
        vendaPdvBean = new VendaPdvBean();
        vendaPdvBean.setCacodigo(ConfiguracaoBean.getNumeroCaixa()); //código do caixa
        vendaPdvBean.setVdcodigo(proximoIdVendaPdvBean); //1 VDCODIGO N 8 Código da venda  S 1 8 
        vendaPdvBean.setDatahoracup(new java.util.Date());//71 DATAHORACUP C 14 Data - Hora cupom 1344 1357 
        vendaPdvBean.setData(dataVenda); //2 DATA D 8 Data da venda (ddmmaaaa) S 9 16 
        vendaPdvBean.setVendedor(codigoVendedor); //3 VENDEDOR N 6 Código do vendedor S 17 22
        vendaPdvBean.setClcodigo((clienPdvBean != null && clienPdvBean.getClcodigo() != null) ? clienPdvBean.getClcodigo() : 0);//4 CLCODIGO N 6 Código do cliente S 23 28
        vendaPdvBean.setNomeclie((clienPdvBean != null && clienPdvBean.getNome() != null) ? clienPdvBean.getNome() : "");//40 NOMECLIE C 50 Nome do Cliente 657 706
        vendaPdvBean.setCgcclie((clienPdvBean != null && clienPdvBean.getCgc() != null) ? clienPdvBean.getCgc() : "");//41 CGCCLIE C 14 CNPJ do Cliente 707 720
        vendaPdvBean.setCpfclie((clienPdvBean != null && clienPdvBean.getCpf() != null) ? clienPdvBean.getCpf() : "");//42 CPFCLIE C 11 CPF do Cliente 721 731
        vendaPdvBean.setLimcrebai(0.0);//72 LIMCREBAI N 16 2 Limite de crédito baixado 1358 1373
        vendaPdvBean.setLimcresec(0.0); //89 LIMCRESEC N 16 2 Limite de crédito SECUNDÁRIO baixado 1567 1582
        vendaPdvBean.setCodintern((clienPdvBean != null && clienPdvBean.getCodintern() != null) ? clienPdvBean.getCodintern() : "");//15 CODINTERN C 20 Código interno do cliente 91 110
        vendaPdvBean.setDesconto(valorDesconto);//5 DESCONTO N 10 2 Valor do desconto da venda S 29 38
        vendaPdvBean.setAcrescimo(valorAcrescimo);//6 ACRESCIMO N 10 2 Valor do acréscimo da venda S 39 48
        vendaPdvBean.setValvenda(valorTotal);//7 VALVENDA N 10 2 Valor total da venda S 49 58
        vendaPdvBean.setEquipame(1);//39 EQUIPAME N 6 Código da fatura 651 656
        vendaPdvBean.setMscodigo("0");//8 MSCODIGO C 3 Código da mesa 59 61 
        vendaPdvBean.setMecodigo(0);//35 MECODIGO C 9 Código da Cartela 594 602 

        vendaPdvBean.setDataamesa(new java.util.Date()); //90 DATAAMESA D 14 Data da abertura da Mesa 1583 1596
        vendaPdvBean.setConfecfser(""); //91 CONFECFSER C 20 Reservado(não utilizado). 1597 1616
        vendaPdvBean.setConfeecf(""); //92 CONFEECF C 4 Reservado(não utilizado). 1617 1620
        vendaPdvBean.setConfecoo(0); //93 CONFECOO C 8 Reservado(não utilizado). 1621 1628
        vendaPdvBean.setConfecer(0); //94 CONFECER C 8 Reservado(não utilizado). 1629 1636

        vendaPdvBean.setFucodigo(codigoVendedor);//10 FUCODIGO N 6 Código do funcionário S 65 70        
        vendaPdvBean.setPeriodo(1);//11 PERIODO N 2 Período de venda S 71 72
        vendaPdvBean.setHorario(horasVenda);//12 HORARIO C 8 Horário da venda S 73 80
        vendaPdvBean.setEcfseque("  ");//44 ECFSEQUE C 4 Sequencial do ECF 745 748 
        vendaPdvBean.setEcfserie("X2");//45 ECFSERIE C 20 Número de Série do ECF 749 768 
        vendaPdvBean.setEcfmarca("");//46 ECFMARCA C 25 Marca do ECF 769 793 
        vendaPdvBean.setEcfmodelo("");//47 ECFMODELO C 25 Modelo do ECF 794 818
        vendaPdvBean.setEcftipo("");//48 ECFTIPO C 15 Tipo do ECF 819 833
        vendaPdvBean.setSwbversao(""); //49 SWVERSAO C 10 Versão do Software do ECF 834 843 
        vendaPdvBean.setSwbdthrgr(null);//50 SWBDTHRGR D 8 Data do Software do ECF 844 851 
        vendaPdvBean.setSwbmfadic("");//51 SWBMFADIC C 1 Adicional do Software do ECF 852 852 

        vendaPdvBean.setNumcupom(0);//13 NUMCUPOM C 8 Numero do cupom S 81 88 
        vendaPdvBean.setQtdpessoa(1);//73 QTDPESSOA N 6 Quantidade de pessoas de divisão do total da mesa 1374 1379 
        vendaPdvBean.setQtdcupent(null);//14 QTDCUPENT N 2 Quantidades de cupons de entrega 89 90 
        vendaPdvBean.setHorainic(horasVenda);//16 HORAINIC C 8 Hora inicial da venda 111 118
        vendaPdvBean.setHorapagt(horasVenda); //74 HORAPAGT C 8 Hora de Pagamento 1380 1387 
        vendaPdvBean.setDav(0);//43 DAV C 13 Número do DAV 732 744 
        vendaPdvBean.setNumorcam(""); //17 NUMORCAM C 6 Número do Orçamento S 119 124
        vendaPdvBean.setNome((clienPdvBean != null && clienPdvBean.getNome() != null) ? clienPdvBean.getNome() : "");//18 NOME A 40 Nome do cliente 125 164
        vendaPdvBean.setEndereco((clienPdvBean != null && clienPdvBean.getEndereco() != null) ? clienPdvBean.getEndereco() : "");//19 ENDEREÇO C 40 Endereço do cliente 165 204
        vendaPdvBean.setTelefone((clienPdvBean != null && clienPdvBean.getFoneCel() != null) ? clienPdvBean.getFoneCel() : "");//20 TELEFONE C 18 Telefone do cliente 205 222
        vendaPdvBean.setDocumento("");//21 DOCUMENTO C 14 Número do documento do cliente 223 236
        vendaPdvBean.setNumerocoo(0);//22 NUMEROCOO N 8 Número do COO do cupom fiscal 237 244 

        vendaPdvBean.setObs1(observacaoVenda[0]); //23 OBS1 C 40 Observação da venda 245 284
        vendaPdvBean.setObs2(observacaoVenda[1]); //24 OBS2 C 40 Observação da venda 285 324 
        vendaPdvBean.setObs3(observacaoVenda[2]); //25 OBS3 C 40 Observação da venda 325 364 
        vendaPdvBean.setObs4(observacaoVenda[3]); //26 OBS4 C 40 Observação da venda 365 404 
        vendaPdvBean.setObs5(observacaoVenda[4]); //27 OBS5 C 40 Observação da venda 405 444
        vendaPdvBean.setObs6(observacaoVenda[5]); //28 OBS6 C 40 Observação da venda 445 484 
        vendaPdvBean.setObs7(observacaoVenda[6]); //29 OBS7 C 40 Observação da venda 485 524
        vendaPdvBean.setObs8(observacaoVenda[7]); //30 OBS8 C 40 Observação da venda 525 564 
        vendaPdvBean.setKm(0);//31 KM N 7 Quilometragem do veiculo 565 571
        vendaPdvBean.setPlaca("");//32 PLACA C 10 Placa do veiculo 572 581
        vendaPdvBean.setBaixaesto(baixaEstoque); //75 BAIXAESTO C 1 Baixou estoque S/N 1388 1388 
        vendaPdvBean.setClcodpai((clienPdvBean != null && clienPdvBean.getClcodpai() != null) ? clienPdvBean.getClcodpai() : 0);//33 CLCODPAI N 6 Código do cliente responsável pelo cliente desta venda 582 587
        vendaPdvBean.setFlagtrans(null);
        vendaPdvBean.setFlagtserv(null);
        vendaPdvBean.setFlagfinan(null);
        vendaPdvBean.setFicodigo(0);//34 FICODIGO N 6 Código da filial (#) 588 593 

        //PASSAGEM
        vendaPdvBean.setSetoruso(Caixa.ConfiguracaoBean.getSetorUso());//38 SETORUSO C 30 Nome do Setor utilizado no Caixa 621 650 
        vendaPdvBean.setFacodigo(null);  //76 FACODIGO N 8 Código da fatura 1389 1396
        vendaPdvBean.setCentcusto(Caixa.ConfiguracaoBean.getCentCusto()); //77 CENTCUSTO C 14 Código Centro Custo 1397 1410 
        vendaPdvBean.setPasembarque("");//52 PASEMBARQUE C 60 Campo para Segmento Passagem 853 912 
        vendaPdvBean.setPasdestino("");//53 PASDESTINO C 60 Campo para Segmento Passagem 913 972
        vendaPdvBean.setPaslinha("");//54 PASLINHA C 60 Campo para Segmento Passagem 973 1032
        vendaPdvBean.setPasagencia("");//55 PASAGENCIA C 60 Campo para Segmento Passagem 1033 1092 
        vendaPdvBean.setPasdata("");//56 PASDATA C 10 Campo para Segmento Passagem 1093 1102 
        vendaPdvBean.setPashora("");//57 PASHORA C 8 Campo para Segmento Passagem 1103 1110        
        vendaPdvBean.setPaspoltrona("");//58 PASPOLTRONA C 4 Campo para Segmento Passagem 1111 1114 
        vendaPdvBean.setPasplataforma("");//59 PASPLATAFORMA C 6 Campo para Segmento Passagem 1115 1120 
        vendaPdvBean.setPastipopassagem("");//60 PASTIPOPASSAGEM C 1 Campo para Segmento Passagem 1121 1121 
        vendaPdvBean.setPasrg("");//61 PASRG C 29 Campo para Segmento Passagem 1122 1150
        vendaPdvBean.setPasnome("");//62 PASNOME C 60 Campo para Segmento Passagem 1151 1210 
        vendaPdvBean.setPasendereco("");//63 PASENDERECO C 80 Campo para Segmento Passagem 1211 1290 
        vendaPdvBean.setPasufdestino(""); //64 PASUFDESTINO C 2 Campo para Segmento Passagem 1291 1292         
        vendaPdvBean.setPaspercurso(0);//65 PASPERCURSO N 6 Campo para Segmento Passagem 1293 1298 
        vendaPdvBean.setPastpvenda(0);//66 PASTPVENDA N 6 Campo para Segmento Passagem 1299 1304 
        vendaPdvBean.setPascodard(0);//68 PASCODARD N 8 Campo para Segmento Passagem 1330 1337 
        vendaPdvBean.setCodautoext("");//67 CODAUTOEXT C 25 Código de autorização externa 1305 1329 

        vendaPdvBean.setOrigem("MOVIM");//69 ORIGEM C 5 Origem da Venda 1338 1342 
        vendaPdvBean.setMultmesas("N");//70 MULTMESAS C 1 Fechamento multi mesas 1343 1343 
        vendaPdvBean.setPafindcanc("N"); //78 PAFINDCANC C 1 Indicador de Cancelamento 1411 1411 
        vendaPdvBean.setModelodoc("2D"); //79 MODELODOC C 3 Modelo do documento 1412 1414 
        vendaPdvBean.setPafhashver("4.01"); //88 PAFHASHVER C 10 Versao do PAFECF 1557 1566
        vendaPdvBean.setPafhashcap(""); //80 PAFHASHCAP C 32 Reservado(não utilizado). 1415 1446 
        vendaPdvBean.setVlrbcpis(0.0); //81 VLRBCPIS N 16 3 Reservado(não utilizado). 1447 1462
        vendaPdvBean.setValorpis(0.0); //82 VALORPIS N 16 3 Reservado(não utilizado). 1463 1478 
        vendaPdvBean.setVlrpisst(0.0); //83 VLRPISST N 16 3 Reservado(não utilizado). 1479 1494
        vendaPdvBean.setVlrbccfs(0.0); //84 VLRBCCFS N 16 3 Reservado(não utilizado). 1495 1510
        vendaPdvBean.setValorcfs(0.0); //85 VALORCFS N 16 3 Reservado(não utilizado). 1511 1526 
        vendaPdvBean.setVlrcfsst(0.0); //86 VLRCFSST N 16 3 Reservado(não utilizado). 1527 1542
        vendaPdvBean.setDatadamov(new java.util.Date()); //87 DATADAMOV C 14 Data da Movimentação da ECF 1543 1556

        //************************************************
        //informar numero da venda para os itens
        //************************************************
        for (ItemVpdvBean o : listaItens) {
            o.setVdcodigo(vendaPdvBean.getVdcodigo()); //1 VDCODIGO N 8 Código da venda S 1 8 
        }

        //************************************************
        //informar numero da venda para as parcelas
        //************************************************
        if (listaLancamenBean != null && !listaLancamenBean.isEmpty()) {

            Integer proximoIdLancamenBean = controle.proximoId(ConfiguracaoBean.getNumeroCaixa(), "Lancamen");

            for (LancamenBean o : listaLancamenBean) {

                o.setLacodigo(proximoIdLancamenBean);
                o.setVdcodigo(vendaPdvBean.getVdcodigo()); //1 VDCODIGO N 8 Código da venda S 1 8 
                o.setClcodigo((clienPdvBean != null && clienPdvBean.getClcodigo() != null) ? clienPdvBean.getClcodigo() : 0);//4 CLCODIGO N 6 Código do cliente S 23 28            
                o.setCacodigo(ConfiguracaoBean.getNumeroCaixa());
                o.setCecodigo(ConfiguracaoBean.getCentCusto());

                //----------------------------------------------
                ++proximoIdLancamenBean;

            }
        }
    }

    private void compoemPreVdPdvBean() throws Exception {

        Integer proximoIdPreVdPdvBean = controle.proximoId(ConfiguracaoBean.getNumeroCaixa(), "PreVdPdv");

        //**********************************************    
        //Capa da Venda: (Tabela-VENDAPDV / PREVDPDV)
        //**********************************************
        //36 CLCODIGO2 N 9 Código aumentado do Cliente. (Para base com código de cliente com até 9 dígitos. Se vier preenchido será assumido como código do cliente) FK 603 611
        //37 CLCODPAI2 N 9 Código aumentado do Cliente Pai. (Para base com código de cliente com até 9 dígitos. Se vier preenchido será assumido como código do cliente) FK 612 620
        preVdPdvBean.setVdcodigo(proximoIdPreVdPdvBean); //1 VDCODIGO N 8 Código da venda  S 1 8                
        preVdPdvBean.setCacodigo(ConfiguracaoBean.getNumeroCaixa());//9 CACODIGO C 3 Código do caixa S 62 64
        preVdPdvBean.setSituacao("");
        preVdPdvBean.setStsproc("");
        preVdPdvBean.setCodsolicitfarma("");
        preVdPdvBean.setNumautorizacao("");
        preVdPdvBean.setMsgproc("");
        preVdPdvBean.setVdacacod("");
        preVdPdvBean.setVdavdcod(0);
        preVdPdvBean.setCafechpre("");
        preVdPdvBean.setNumeronf(0);
        preVdPdvBean.setSerienf("");
        preVdPdvBean.setPrecanc("");
        preVdPdvBean.setDatahoracup(new java.util.Date());//71 DATAHORACUP C 14 Data - Hora cupom 1344 1357 
        preVdPdvBean.setData(dataVenda);//2 DATA D 8 Data da venda (ddmmaaaa) S 9 16 
        preVdPdvBean.setVendedor(codigoVendedor);//3 VENDEDOR N 6 Código do vendedor S 17 22
        preVdPdvBean.setClcodigo((clienPdvBean != null && clienPdvBean.getClcodigo() != null) ? clienPdvBean.getClcodigo() : 0);//4 CLCODIGO N 6 Código do cliente S 23 28
        preVdPdvBean.setNomeclie((clienPdvBean != null && clienPdvBean.getNome() != null) ? clienPdvBean.getNome() : "");//40 NOMECLIE C 50 Nome do Cliente 657 706
        preVdPdvBean.setCgcclie((clienPdvBean != null && clienPdvBean.getCgc() != null) ? clienPdvBean.getCgc() : "");//41 CGCCLIE C 14 CNPJ do Cliente 707 720
        preVdPdvBean.setCpfclie((clienPdvBean != null && clienPdvBean.getCpf() != null) ? clienPdvBean.getCpf() : "");//42 CPFCLIE C 11 CPF do Cliente 721 731                
        preVdPdvBean.setLimcrebai(0.0);//72 LIMCREBAI N 16 2 Limite de crédito baixado 1358 1373
        preVdPdvBean.setLimcresec(0.0);//89 LIMCRESEC N 16 2 Limite de crédito SECUNDÁRIO baixado 1567 1582
        preVdPdvBean.setCodintern((clienPdvBean != null && clienPdvBean.getCodintern() != null) ? clienPdvBean.getCodintern() : "");//15 CODINTERN C 20 Código interno do cliente 91 110
        preVdPdvBean.setDesconto(valorDesconto);//5 DESCONTO N 10 2 Valor do desconto da venda S 29 38
        preVdPdvBean.setAcrescimo(valorAcrescimo);//6 ACRESCIMO N 10 2 Valor do acréscimo da venda S 39 48
        preVdPdvBean.setValvenda(valorTotal);//7 VALVENDA N 10 2 Valor total da venda S 49 58
        preVdPdvBean.setEquipame(1);//39 EQUIPAME N 6 Código da fatura 651 656
        preVdPdvBean.setMscodigo("0");//8 MSCODIGO C 3 Código da mesa 59 61 
        preVdPdvBean.setMecodigo(0);//35 MECODIGO C 9 Código da Cartela 594 602 
        preVdPdvBean.setDataamesa(new java.util.Date());//90 DATAAMESA D 14 Data da abertura da Mesa 1583 1596
        preVdPdvBean.setConfecfser("");//91 CONFECFSER C 20 Reservado(não utilizado). 1597 1616
        preVdPdvBean.setConfeecf("");//92 CONFEECF C 4 Reservado(não utilizado). 1617 1620
        preVdPdvBean.setConfecoo(0);//93 CONFECOO C 8 Reservado(não utilizado). 1621 1628
        preVdPdvBean.setConfecer(0);//94 CONFECER C 8 Reservado(não utilizado). 1629 1636
        preVdPdvBean.setFucodigo(codigoVendedor);//10 FUCODIGO N 6 Código do funcionário S 65 70        
        preVdPdvBean.setPeriodo(1);//11 PERIODO N 2 Período de venda S 71 72
        preVdPdvBean.setHorario(horasVenda);//12 HORARIO C 8 Horário da venda S 73 80
        preVdPdvBean.setEcfseque("  ");//44 ECFSEQUE C 4 Sequencial do ECF 745 748 
        preVdPdvBean.setEcfserie("X2");//45 ECFSERIE C 20 Número de Série do ECF 749 768 
        preVdPdvBean.setEcfmarca("");//46 ECFMARCA C 25 Marca do ECF 769 793 
        preVdPdvBean.setEcfmodelo("");//47 ECFMODELO C 25 Modelo do ECF 794 818
        preVdPdvBean.setEcftipo("");//48 ECFTIPO C 15 Tipo do ECF 819 833
        preVdPdvBean.setSwbversao(""); //49 SWVERSAO C 10 Versão do Software do ECF 834 843 
        preVdPdvBean.setSwbdthrgr(null);//50 SWBDTHRGR D 8 Data do Software do ECF 844 851 
        preVdPdvBean.setSwbmfadic("");//51 SWBMFADIC C 1 Adicional do Software do ECF 852 852         
        preVdPdvBean.setNumcupom(0);//13 NUMCUPOM C 8 Numero do cupom S 81 88 
        preVdPdvBean.setQtdpessoa(1);//73 QTDPESSOA N 6 Quantidade de pessoas de divisão do total da mesa 1374 1379 
        preVdPdvBean.setQtdcupent(0);//14 QTDCUPENT N 2 Quantidades de cupons de entrega 89 90 
        preVdPdvBean.setHorainic(horasVenda);//16 HORAINIC C 8 Hora inicial da venda 111 118
        preVdPdvBean.setHorapagt(horasVenda); //74 HORAPAGT C 8 Hora de Pagamento 1380 1387 
        preVdPdvBean.setDav(0);//43 DAV C 13 Número do DAV 732 744 
        preVdPdvBean.setNumorcam(""); //17 NUMORCAM C 6 Número do Orçamento S 119 124
        preVdPdvBean.setNome((clienPdvBean != null && clienPdvBean.getNome() != null) ? clienPdvBean.getNome() : "");//18 NOME A 40 Nome do cliente 125 164
        preVdPdvBean.setEndereco((clienPdvBean != null && clienPdvBean.getEndereco() != null) ? clienPdvBean.getEndereco() : "");//19 ENDEREÇO C 40 Endereço do cliente 165 204
        preVdPdvBean.setTelefone((clienPdvBean != null && clienPdvBean.getFoneCel() != null) ? clienPdvBean.getFoneCel() : "");//20 TELEFONE C 18 Telefone do cliente 205 222
        preVdPdvBean.setDocumento("");//21 DOCUMENTO C 14 Número do documento do cliente 223 236
        preVdPdvBean.setNumerocoo(0);//22 NUMEROCOO N 8 Número do COO do cupom fiscal 237 244 
        preVdPdvBean.setObs1(observacaoVenda[0]); //23 OBS1 C 40 Observação da venda 245 284
        preVdPdvBean.setObs2(observacaoVenda[1]); //24 OBS2 C 40 Observação da venda 285 324 
        preVdPdvBean.setObs3(observacaoVenda[2]); //25 OBS3 C 40 Observação da venda 325 364 
        preVdPdvBean.setObs4(observacaoVenda[3]); //26 OBS4 C 40 Observação da venda 365 404 
        preVdPdvBean.setObs5(observacaoVenda[4]); //27 OBS5 C 40 Observação da venda 405 444
        preVdPdvBean.setObs6(observacaoVenda[5]); //28 OBS6 C 40 Observação da venda 445 484 
        preVdPdvBean.setObs7(observacaoVenda[6]); //29 OBS7 C 40 Observação da venda 485 524
        preVdPdvBean.setObs8(observacaoVenda[7]); //30 OBS8 C 40 Observação da venda 525 564 
        preVdPdvBean.setKm(0);//31 KM N 7 Quilometragem do veiculo 565 571
        preVdPdvBean.setPlaca("");//32 PLACA C 10 Placa do veiculo 572 581
        preVdPdvBean.setBaixaesto("");//75 BAIXAESTO C 1 Baixou estoque S/N 1388 1388 
        preVdPdvBean.setClcodpai(0);//33 CLCODPAI N 6 Código do cliente responsável pelo cliente desta venda 582 587
        preVdPdvBean.setFlagtrans("");
        preVdPdvBean.setFicodigo(0);//34 FICODIGO N 6 Código da filial (#) 588 593 
        preVdPdvBean.setKm(0);//31 KM N 7 Quilometragem do veiculo 565 571
        preVdPdvBean.setPlaca("");//32 PLACA C 10 Placa do veiculo 572 581
        preVdPdvBean.setBaixaesto(baixaEstoque); //75 BAIXAESTO C 1 Baixou estoque S/N 1388 1388 
        preVdPdvBean.setClcodpai((clienPdvBean != null && clienPdvBean.getClcodpai() != null) ? clienPdvBean.getClcodpai() : 0);//33 CLCODPAI N 6 Código do cliente responsável pelo cliente desta venda 582 587
        preVdPdvBean.setFlagtrans(null);
        preVdPdvBean.setFacodigo(0);//76 FACODIGO N 8 Código da fatura 1389 1396 
        preVdPdvBean.setSetoruso(Caixa.ConfiguracaoBean.getSetorUso());//38 SETORUSO C 30 Nome do Setor utilizado no Caixa 621 650 
        preVdPdvBean.setCentcusto(Caixa.ConfiguracaoBean.getCentCusto()); //77 CENTCUSTO C 14 Código Centro Custo 1397 1410 
        preVdPdvBean.setPasembarque("");//52 PASEMBARQUE C 60 Campo para Segmento Passagem 853 912 
        preVdPdvBean.setPasembarque("");//52 PASEMBARQUE C 60 Campo para Segmento Passagem 853 912 
        preVdPdvBean.setPasdestino("");//53 PASDESTINO C 60 Campo para Segmento Passagem 913 972
        preVdPdvBean.setPaslinha("");//54 PASLINHA C 60 Campo para Segmento Passagem 973 1032
        preVdPdvBean.setPasagencia("");//55 PASAGENCIA C 60 Campo para Segmento Passagem 1033 1092 
        preVdPdvBean.setPasdata("");//56 PASDATA C 10 Campo para Segmento Passagem 1093 1102 
        preVdPdvBean.setPashora("");//57 PASHORA C 8 Campo para Segmento Passagem 1103 1110        
        preVdPdvBean.setPaspoltrona("");//58 PASPOLTRONA C 4 Campo para Segmento Passagem 1111 1114 
        preVdPdvBean.setPasplataforma("");//59 PASPLATAFORMA C 6 Campo para Segmento Passagem 1115 1120 
        preVdPdvBean.setPastipopassagem("");//60 PASTIPOPASSAGEM C 1 Campo para Segmento Passagem 1121 1121 
        preVdPdvBean.setPasrg("");//61 PASRG C 29 Campo para Segmento Passagem 1122 1150
        preVdPdvBean.setPasnome("");//62 PASNOME C 60 Campo para Segmento Passagem 1151 1210 
        preVdPdvBean.setPasendereco("");//63 PASENDERECO C 80 Campo para Segmento Passagem 1211 1290 
        preVdPdvBean.setPasufdestino(""); //64 PASUFDESTINO C 2 Campo para Segmento Passagem 1291 1292         
        preVdPdvBean.setPaspercurso(0);//65 PASPERCURSO N 6 Campo para Segmento Passagem 1293 1298 
        preVdPdvBean.setPastpvenda(0);//66 PASTPVENDA N 6 Campo para Segmento Passagem 1299 1304 
        preVdPdvBean.setPascodard(0);//68 PASCODARD N 8 Campo para Segmento Passagem 1330 1337 
        preVdPdvBean.setCodautoext("");//67 CODAUTOEXT C 25 Código de autorização externa 1305 1329 
        preVdPdvBean.setPasdestino("");//53 PASDESTINO C 60 Campo para Segmento Passagem 913 972
        preVdPdvBean.setPaslinha("");//54 PASLINHA C 60 Campo para Segmento Passagem 973 1032
        preVdPdvBean.setPasagencia("");//55 PASAGENCIA C 60 Campo para Segmento Passagem 1033 1092 
        preVdPdvBean.setPasdata("");//56 PASDATA C 10 Campo para Segmento Passagem 1093 1102 
        preVdPdvBean.setPashora("");//57 PASHORA C 8 Campo para Segmento Passagem 1103 1110  
        preVdPdvBean.setPaspoltrona("");//58 PASPOLTRONA C 4 Campo para Segmento Passagem 1111 1114 
        preVdPdvBean.setPasplataforma("");//59 PASPLATAFORMA C 6 Campo para Segmento Passagem 1115 1120 
        preVdPdvBean.setPastipopassagem("");//60 PASTIPOPASSAGEM C 1 Campo para Segmento Passagem 1121 1121 
        preVdPdvBean.setPasrg("");//61 PASRG C 29 Campo para Segmento Passagem 1122 1150 
        preVdPdvBean.setPasnome("");//62 PASNOME C 60 Campo para Segmento Passagem 1151 1210 
        preVdPdvBean.setPasendereco("");//63 PASENDERECO C 80 Campo para Segmento Passagem 1211 1290 
        preVdPdvBean.setPasufdestino("");//64 PASUFDESTINO C 2 Campo para Segmento Passagem 1291 1292 
        preVdPdvBean.setPaspercurso(0);//65 PASPERCURSO N 6 Campo para Segmento Passagem 1293 1298
        preVdPdvBean.setPastpvenda(0);//66 PASTPVENDA N 6 Campo para Segmento Passagem 1299 1304 
        preVdPdvBean.setPascodard(0);//68 PASCODARD N 8 Campo para Segmento Passagem 1330 1337 
        preVdPdvBean.setCodautoext("");//67 CODAUTOEXT C 25 Código de autorização externa 1305 1329 
        preVdPdvBean.setOrigem("MOVIM");//69 ORIGEM C 5 Origem da Venda 1338 1342 
        preVdPdvBean.setMultmesas("N");//70 MULTMESAS C 1 Fechamento multi mesas 1343 1343 
        preVdPdvBean.setPafindcanc("N");//78 PAFINDCANC C 1 Indicador de Cancelamento 1411 1411 
        preVdPdvBean.setModelodoc("2D");//79 MODELODOC C 3 Modelo do documento 1412 1414 
        preVdPdvBean.setPafhashver("4.01");//88 PAFHASHVER C 10 Versao do PAFECF 1557 1566
        preVdPdvBean.setPafhashcap("");//80 PAFHASHCAP C 32 Reservado(não utilizado). 1415 1446 
        preVdPdvBean.setVlrbcpis(0.0);//81 VLRBCPIS N 16 3 Reservado(não utilizado). 1447 1462
        preVdPdvBean.setValorpis(0.0);//82 VALORPIS N 16 3 Reservado(não utilizado). 1463 1478
        preVdPdvBean.setVlrpisst(0.0);//83 VLRPISST N 16 3 Reservado(não utilizado). 1479 1494
        preVdPdvBean.setVlrbccfs(0.0);//84 VLRBCCFS N 16 3 Reservado(não utilizado). 1495 1510
        preVdPdvBean.setValorcfs(0.0);//85 VALORCFS N 16 3 Reservado(não utilizado). 1511 1526 
        preVdPdvBean.setVlrcfsst(0.0);//86 VLRCFSST N 16 3 Reservado(não utilizado). 1527 1542
        preVdPdvBean.setDatadamov(new java.util.Date());//87 DATADAMOV C 14 Data da Movimentação da ECF 1543 1556

    }

    private void compoemOrcamentBean() throws Exception {

        Integer proximoOrcamentBean = controle.proximoId(ConfiguracaoBean.getNumeroCaixa(), "Orcament");
        //*******************************************
        //Orçamento: (Tabela-ORCAMENT)
        //*******************************************
        orcamentBean = new OrcamentBean();
        orcamentBean.setOrcodigo(proximoOrcamentBean);
        orcamentBean.setData(dataVenda);
        orcamentBean.setFucodigo(codigoVendedor); //codigo do funcionario
        orcamentBean.setClcodigo((clienPdvBean != null && clienPdvBean.getClcodigo() != null) ? clienPdvBean.getClcodigo() : 0);//4 CLCODIGO N 6 Código do cliente S 23 28
        orcamentBean.setTipo((clienPdvBean != null && clienPdvBean.getTipo() != null) ? clienPdvBean.getTipo() : "F");//4 CLCODIGO N 6 Código do cliente S 23 28
        orcamentBean.setNome((clienPdvBean != null && clienPdvBean.getNome() != null) ? clienPdvBean.getNome() : "");//40 NOMECLIE C 50 Nome do Cliente 657 706;
        orcamentBean.setCnpj((clienPdvBean != null && clienPdvBean.getCgc() != null) ? clienPdvBean.getCgc() : "");//41 CGCCLIE C 14 CNPJ do Cliente 707 720
        orcamentBean.setCpf((clienPdvBean != null && clienPdvBean.getCpf() != null) ? clienPdvBean.getCpf() : "");//42 CPFCLIE C 11 CPF do Cliente 721 731
        orcamentBean.setEndereco((clienPdvBean != null && clienPdvBean.getEndereco() != null) ? clienPdvBean.getEndereco() : "");//19 ENDEREÇO C 40 Endereço do cliente 165 204
        orcamentBean.setBairro((clienPdvBean != null && clienPdvBean.getBairro() != null) ? clienPdvBean.getBairro() : "");
        orcamentBean.setCicodigo((clienPdvBean != null && clienPdvBean.getCicodigo() != null) ? clienPdvBean.getCicodigo() : 0); //codigo cidade
        orcamentBean.setCep((clienPdvBean != null && clienPdvBean.getCep() != null) ? clienPdvBean.getCep() : "");
        orcamentBean.setUf((clienPdvBean != null && clienPdvBean.getUf() != null) ? clienPdvBean.getUf() : "");
        orcamentBean.setTelefone((clienPdvBean != null && clienPdvBean.getFoneCel() != null) ? clienPdvBean.getFoneCel() : "");//20 TELEFONE C 18 Telefone do cliente 205 222
        orcamentBean.setCuidados(""); //Aos cuidados de:
        orcamentBean.setFpcodigo(orcamentFormaPgto); //Código da forma de pagamento
        orcamentBean.setTipopreco("V"); //Cliente comprou com preço (A - Atacado / V - Varejo)
        orcamentBean.setDesconto(valorDesconto);
        orcamentBean.setAcrescimo(valorAcrescimo);
        orcamentBean.setValortot(valorTotal);
        orcamentBean.setDatavalid(orcamentDataValid); //validade
        orcamentBean.setDtparaent(null); //data entrega
        orcamentBean.setTotalipi(0.0);
        orcamentBean.setNumpedcli(""); //Numero de pedido de cliente
        orcamentBean.setSituacao("E"); //Situação do orçamento: E - Em espera; C - Confirmado; P - Perdido; L - Cancelado
        orcamentBean.setQtditens(listaItens.size());
        orcamentBean.setOpcodigo(0); //Código do Orçamento Padrão
        orcamentBean.setObserva1(observacaoVenda[0]);
        orcamentBean.setObserva2(observacaoVenda[1]);
        orcamentBean.setObserva3(observacaoVenda[2]);
        orcamentBean.setObserva4(observacaoVenda[3]);
        orcamentBean.setObserva5(observacaoVenda[4]);
        orcamentBean.setTotfrete(0.0);
        orcamentBean.setToticms(0.0);
        orcamentBean.setPrazo("");
        orcamentBean.setCacodigo(ConfiguracaoBean.getNumeroCaixa()); //Código do caixa que confirmou o orçamento
        orcamentBean.setVdcodigo(0);  //Código da venda que confirmou o orçamento
        orcamentBean.setNumerocoo(0);
        orcamentBean.setNumeroccf(0);
        orcamentBean.setMdcodigo(0); //Código do Modelo
        orcamentBean.setMccodigo(0); //Código da Marca
        orcamentBean.setAno("");
        orcamentBean.setDataapro(null); //Data de aprovação
        orcamentBean.setFuaprova(0); //Código do Funcionário que aprovou
        orcamentBean.setDataconf(null); //Data de conferencia
        orcamentBean.setFuconfer(0); //Código do Funcionário que conferiu
        orcamentBean.setSerie("");
        orcamentBean.setFlagtrans("");
        orcamentBean.setNumplaca("");
        orcamentBean.setNumrenavam("");
        orcamentBean.setOrcodpai(0);
        orcamentBean.setObscli(null); //Observação Cliente
        orcamentBean.setDav(0);
        orcamentBean.setModelonf("");
        orcamentBean.setSerienf("");
        orcamentBean.setSubserienf("");
        orcamentBean.setNumeronf(0);
        orcamentBean.setCvcodigo(0);

    }

    private void compoemItPrVpdvBean() throws Exception {

        ItPrVpdvBean itPrVpdvBean;

        //************************************************
        //capturar itens da pre-venda
        //************************************************
        for (ItemVpdvBean o : listaItens) {

            itPrVpdvBean = new ItPrVpdvBean();

            //********************************************
            //Itens da Venda: (Tabela-ITEMVPDV / ITPRVPDV)
            //********************************************
            //13 NOME C 40 Descrição do Produto S 110 149    
            //20 CFCODIGO C 1 Reservado S 169 169            
            //30 QTDESTOQU N 16 6 Quantidade em estoque do produto 258 273           
            //45 HORACOMA C 6 Hora de Emissão da Comanda 531 536        
            //80 Reservado C 32 Reservado 895 926        
            //85 VLRVALORCFSPISST N 16 3 Valor da ST do Pis 978 993        
            itPrVpdvBean.setVdcodigo(preVdPdvBean.getVdcodigo());//1 VDCODIGO N 8 Código da venda S 1 8 
            itPrVpdvBean.setNumitem(o.getNumitem());//2 NUMITEM N 3 Numero do item da venda S 9 11 
            itPrVpdvBean.setCacodigo(o.getCacodigo());//35 CACODIGO C 3 Código do caixa 390 392
            itPrVpdvBean.setMfcodigo(o.getMfcodigo());//3 MFCODIGO C 13 Código do produto S 12 24 
            itPrVpdvBean.setPlcodigo(o.getPlcodigo());//4 PLCODIGO C 10 Código do plano de contas 25 34
            itPrVpdvBean.setQtditem(o.getQtditem());//5 QTDITEM N 10 3 Quantidade do item S 35 44 
            itPrVpdvBean.setValitem(o.getValitem());//6 VALITEM N 10 2 Valor do total do item S 45 54
            itPrVpdvBean.setFucodigo(o.getFucodigo());//7 FUCODIGO N 6 Código do funcionário 55 60
            itPrVpdvBean.setFucodlan(o.getFucodlan());//74 FUCODLAN N 6 Garçom que realizou o pedido do item 853 858        
            itPrVpdvBean.setFucoddes(o.getFucoddes());//59 FUCODDES C 6 Identificação do Funcionário que deu o desconto 641 646  
            itPrVpdvBean.setSeqtotecf(o.getSeqtotecf());//91 SEQTOTECF C 2 Sequencial do Totalizador na ECF 1061 1062         
            itPrVpdvBean.setAliqicms(o.getAliqicms());//8 ALIQICMS N 4 2 Alíquota de ICMS S 61 64 
            itPrVpdvBean.setCodtrib(o.getCodtrib());//9 CODTRIB C 1 Código de tributação S 65 65 
            itPrVpdvBean.setDesctrib(o.getDesctrib());//60 DESCTRIB C 3 Descrição da Tributação 647 649 
            itPrVpdvBean.setNumdocum(o.getNumdocum());//10 NUMDOC C 15 Número do documento S 66 80 
            itPrVpdvBean.setPrcunit(o.getPrcunit());//11 PRCUNIT N 16 3 Preço unitário do item S 81 96 
            itPrVpdvBean.setPrecosubpc(0.0);
            itPrVpdvBean.setPrecosubms(0.0);
            itPrVpdvBean.setMmfcodigo(o.getMmfcodigo());//12 MMFCODIGO C 13 Código do Produto Para Venda S 97 109 
            itPrVpdvBean.setNome(o.getNome());//42 NOME C 64 Nome do material completo 458 521     
            itPrVpdvBean.setUncodigo(o.getUncodigo());//14 UNCODIGO C 2 Código da Unidade S 150 151 
            itPrVpdvBean.setPrecoven(o.getPrecoven());//15 PRECOVEN N 10 2 Preço de Venda Do Produto S 152 161 
            itPrVpdvBean.setMaliqicms(o.getMaliqicms());//16 MALIQICMS N 4 2 Alíquota de ICMS S 162 165
            itPrVpdvBean.setCodorige(o.getCodorige());//17 CODORIGE C 1 Código de Origem Do Produto S 166 166 
            itPrVpdvBean.setMcodtrib(o.getMcodtrib());//18 MCODTRIB C 1 Código de Tributação S 167 167 
            itPrVpdvBean.setPesavel(o.getPesavel());//19 PESAVEL C 1 Produto Pesável (S - Sim / N - Não) S 168 168    
            itPrVpdvBean.setAliqipi(o.getAliqipi());//21 ALIQIPI N 4 2 Alíquota de IPI S 170 173  
            itPrVpdvBean.setCodextra(o.getCodextra());//22 CODEXTRA C 13 Código do Produto com Suporte Físico (Extra) 174 186       
            itPrVpdvBean.setReferenci(o.getReferenci());//23 REFERENCI C 20 Código de Referencia do Produto 187 206      
            itPrVpdvBean.setGrade(o.getGrade());//24 GRADE C 11 Grade de Tamanho do Produto 207 217        
            itPrVpdvBean.setCor(o.getCor());//25 COR C 10 Código Cor do Produto 218 227         
            itPrVpdvBean.setTamanho(o.getTamanho());//26 TAMANHO C 6 Tamanho do Produto 228 233      
            itPrVpdvBean.setCodintern(o.getCodintern());//27 CODINTERN C 13 Código Interno no Sistema de Retaguarda 234 246        
            itPrVpdvBean.setTipotribu(o.getTipotribu());//28 TIPOTRIB C 1 Tipo de Tributação: (P - Produto / S - Serviço) S 247 247       
            itPrVpdvBean.setPrecoven1(o.getPrecoven1());//29 PRECOVEN1 N 10 3 Preço de Venda com 3 casas decimais (Se preenchido será assumido como o preço de venda) 248 257        
            itPrVpdvBean.setQtdestoq(o.getQtdestoq());
            itPrVpdvBean.setPathfoto(o.getPathfoto());//31 PATHFOTO C 80 Caminho onde o sistema buscará a foto do produto 274 353        
            itPrVpdvBean.setAgcodigo(o.getAgcodigo());//32 AGCODIGO C 16 Agrupamento do produto 354 369
            itPrVpdvBean.setExcluido(o.getExcluido());//101 EXCLUIDO C 1 Se o item foi excluído 1171 1171
            itPrVpdvBean.setFlagtrans(o.getFlagtrans());
            itPrVpdvBean.setDeprotot(o.getDeprotot());//33 DEPROTOT N 10 2 Valor do rateio do desconto da venda para este item 370 379
            itPrVpdvBean.setAcprotot(o.getAcprotot());//34 ACPROTOT N 10 2 Valor do rateio do acréscimo da venda para este item 380 389         
            itPrVpdvBean.setComposto(o.getComposto());//36 COMPOSTO C 1 Produto Composto 393 393         
            itPrVpdvBean.setCacodori(o.getCacodori());//37 CACODORI C 3 Caixa de Origem 394 396    
            itPrVpdvBean.setSetorori(o.getSetorori());//38 SETORORI C 30 Setor de origem 397 426         
            itPrVpdvBean.setCodrecei(o.getCodrecei());//39 CODRECEI C 13 Código da receita 427 439         
            itPrVpdvBean.setHorarece(o.getHorarece());//40 HORARECE C 8 Hora da receita 440 447         
            itPrVpdvBean.setQtdrecei(o.getQtdrecei());//41 QTDRECEI N 10 3 Quantidade da receita 448 457

            itPrVpdvBean.setComandaok(o.getComandaok());//43 COMANDAOK C 1 Se a comanda finalizou OK 522 522
            itPrVpdvBean.setDatacoma(o.getDatacoma());//44 DATACOMA D 8 Data de Emissão da Comanda 523 530         
            itPrVpdvBean.setTipofab(o.getTipofab());//46 TIPOFAB C 1 Tipo de Propriedade P-própria/T-terceiros 537 537  
            itPrVpdvBean.setIat(o.getIat());//47 IAT C 1 Índice de Arredondamento ou Truncamento 538 538        
            itPrVpdvBean.setMesaoritr(o.getMesaoritr());//48 MESAORITR C 8 Número da Mesa de Origem 539 546 
            itPrVpdvBean.setMbcodigo(o.getMbcodigo());//49 MBCODIGO C 8 Código do Item de movimentação da Tabela MoviBico 547 554
            itPrVpdvBean.setTqcodigo(o.getTqcodigo());//50 TQCODIGO C 3 Código do Tanque 555 557    
            itPrVpdvBean.setBmcodigo(o.getBmcodigo());//51 BMCODIGO C 3 Código da Bomba 558 560     
            itPrVpdvBean.setBicodigo(o.getBicodigo());//52 BICODIGO C 6 Código do Bico 561 566  
            itPrVpdvBean.setDescbico(o.getDescbico());//53 DESCBICO C 6 Descrição do Bico 567 572 
            itPrVpdvBean.setEncinici(o.getEncinici());//54 ENCINICi N 16 3 Encerrante Inicial 573 588         
            itPrVpdvBean.setEncfinal(o.getEncfinal());//55 ENCFINAL N 16 3 Encerrante Final 589 604
            itPrVpdvBean.setCartaopas(o.getCartaopas());//56 CARTAOPAS C 20 Cartão de Passagem 605 624         

            itPrVpdvBean.setPosimesa(o.getPosimesa());//57 POSIMESA C 10 Posição da mesa 625 634
            itPrVpdvBean.setCvcodigo(o.getCvcodigo());//58 CVCODIGO C 6 Código do Convênio 635 640   
            itPrVpdvBean.setVaspartida(o.getVaspartida());//61 VASPARTIDA C 10 Dados da Vacina 650 659 
            itPrVpdvBean.setVasvencime(o.getVasvencime());//62 VASVENCIME C 7 Dados da Vacina 660 666      
            itPrVpdvBean.setVastipo(o.getVastipo());//63 VASTIPO C 20 Dados da Vacina 667 686
            itPrVpdvBean.setVasfocodig(o.getVasfocodig());//64 VASFOCODIG N 8 Dados da Vacina 687 694      
            itPrVpdvBean.setVascodprod(o.getVascodprod());//65 VASCODPROD C 15 Dados da Vacina 695 709   
            itPrVpdvBean.setVasnomecid(o.getVasnomecid());//66 VASNOMECID C 50 Dados da Vacina 710 759         
            itPrVpdvBean.setOrigem(o.getOrigem());//67 ORIGEM C 5 Origem da Venda 760 764        
            itPrVpdvBean.setMecodigo(o.getMecodigo());//68 MECODIGO N 8 Código da Mesa 765 772        
            itPrVpdvBean.setPrecocus(o.getPrecocus());//69 PRECOCUS N 16 6 Preço de custo 773 788        
            itPrVpdvBean.setPrccumed(o.getPrccumed());//70 PRCCUMED N 16 6 Preço de custo Medio 789 804        
            itPrVpdvBean.setPrccucon(o.getPrccucon());//71 PRCCUCON N 16 6 Preço de custo contábil 805 820        
            itPrVpdvBean.setPrccumec(o.getPrccumec());//72 PRCCUMEC N 16 6 Preço de custo Medio Contábil 821 836
            itPrVpdvBean.setPrecoref(o.getPrecoref());//73 PRECOREF N 16 6 Preço de referência 837 852        
            itPrVpdvBean.setEcfserie(o.getEcfserie());//75 ECFSERIE C 20 Numero de serie da ecf 859 878         
            itPrVpdvBean.setNumerocoo(o.getNumerocoo());//76 NUMEROCOO N 6 Numero do COO 879 884        
            itPrVpdvBean.setNumcupom(o.getNumcupom());//77 NUMCUPOM N 6 Numero do Cupom 885 890         
            itPrVpdvBean.setPafindcanc(o.getPafindcanc());//78 PAFINDCANC C 1 Indicador de cancelamento 891 891        
            itPrVpdvBean.setModelodoc(o.getModelodoc());//79 MODELODOC C 3 Modelo do documento 892 894          
            itPrVpdvBean.setPafhashver(o.getPafhashver());//102 PAFHASHVER C 10 Versao do PAFECF 1172 1181        
            itPrVpdvBean.setPafhashdet(o.getPafhashdet());

            itPrVpdvBean.setCstpis(o.getCstpis());//81 CSTPIS C 3 CST do Pis 927 929         
            itPrVpdvBean.setVlrbcpis(o.getVlrbcpis());//82 VLRBCPIS N 16 3 Valor da Base do Pis 930 945         
            itPrVpdvBean.setAliqpis(o.getAliqpis());//83 ALIQPIS N 16 3 Aliquota de Pis 946 961         
            itPrVpdvBean.setValorpis(o.getValorpis());//84 VALORPIS N 16 3 Valor do Pis 962 977         
            itPrVpdvBean.setVlrpisst(o.getVlrpisst());
            itPrVpdvBean.setCstcofin(o.getCstcofin());//86 CSTCOFIN C 3 CST do Cofins 994 996          

            itPrVpdvBean.setVlrbccfs(o.getVlrbccfs());//87 VLRBCCFS N 16 3 Valor da Base do Cofins 997 1012         
            itPrVpdvBean.setAliqcfs(o.getAliqcfs());//88 ALIQCFS N 16 3 Aliquota de Cofins 1013 1028         
            itPrVpdvBean.setValorcfs(o.getValorcfs());//89 VALORCFS N 16 3 Valor do Cofins 1029 1044         
            itPrVpdvBean.setVlrcfsst(o.getVlrcfsst());//90 VLRCFSST N 16 3 Valor da ST do Cofins  1045 1060        
            itPrVpdvBean.setNumitemdav(o.getNumitemdav());//92 NUMITEMDAV N 6 Numero do item do DAV 1063 1068         
            itPrVpdvBean.setDatadamov(o.getDatadamov());//93 DATADAMOV  C 14 Data da Movimentação da ECF 1069 1082         
            itPrVpdvBean.setEcfseque(o.getEcfseque());//94 ECFSEQUE C 4 Sequencial do ECF da Loja 1083 1086         
            itPrVpdvBean.setEcfmarca(o.getEcfmarca());//95 ECFMARCA C 25 Marca ECF 1087 1111         
            itPrVpdvBean.setEcfmodelo(o.getEcfmodelo());//96 ECFMODELO C 25 Modelo ECF 1112 1136          
            itPrVpdvBean.setEcftipo(o.getEcftipo());//97 ECFTIPO C 15 Tipo do ECF 1137 1151         
            itPrVpdvBean.setSwbversao(o.getSwbversao());//98 SWBVERSAO C 10 Versão do Soft.Básico da ECF 1152 1161        
            itPrVpdvBean.setSwbdthrgr(o.getSwbdthrgr());//99 SWBDTHRGR D 8 Data da Versão do Soft.Básico da ECF 1162 1169  
            itPrVpdvBean.setSwbmfadic(o.getSwbmfadic());//100 SWBMFADIC C 1 MF adicional 1170 1170         
            itPrVpdvBean.setArcodigo(o.getArcodigo());

            itPrVpdvBean.setDadomaqu(o.getDadomaqu());//103 DADOMAQU C 30 Reservado não utilizado 1182 1211
            itPrVpdvBean.setHorapedi(o.getHorapedi());
            itPrVpdvBean.setDesccomp(o.getDesccomp());
            itPrVpdvBean.setQtdmedsolic(0.0);
            itPrVpdvBean.setQtdmedautor(0.0);
            itPrVpdvBean.setStsproc("");
            itPrVpdvBean.setMsgproc("");

            listaItPrVpdvBean.add(itPrVpdvBean);

        }
    }

    private void compoemIteOrcamBean() throws Exception {

        IteOrcamBean iteOrcamBean;

        //************************************************
        //compor itens do orcamento
        //************************************************
        for (ItemVpdvBean o : listaItens) {

            iteOrcamBean = new IteOrcamBean();

            //********************************************
            //Itens de Orçamento: (Tabela-ITEORCAM)
            //********************************************
            iteOrcamBean.setOrcodigo(orcamentBean.getOrcodigo());
            iteOrcamBean.setNumitem(o.getNumitem());
            iteOrcamBean.setDav(0);
            iteOrcamBean.setMfcodigo(o.getMfcodigo());
            iteOrcamBean.setNome(o.getNome());
            iteOrcamBean.setUncodigo(o.getUncodigo());
            iteOrcamBean.setAliqicms(o.getAliqicms());
            iteOrcamBean.setCodtrib(o.getCodtrib());
            iteOrcamBean.setDesctrib(o.getDesctrib());
            iteOrcamBean.setQtditem(o.getQtditem());
            iteOrcamBean.setPrcunit(o.getPrcunit());
            iteOrcamBean.setValitem(o.getValitem());
            iteOrcamBean.setAliqipi(o.getAliqipi());
            iteOrcamBean.setQtdret(0.0);
            iteOrcamBean.setValret(0.0);
            iteOrcamBean.setFucodigo(o.getFucodigo());
            iteOrcamBean.setTipotribu(o.getTipotribu());
            iteOrcamBean.setDesconto(0.0);
            iteOrcamBean.setPercdesc(0.0);
            iteOrcamBean.setAcrescimo(0.0);
            iteOrcamBean.setPercacres(0.0);
            iteOrcamBean.setFlagtrans("");

            iteOrcamBean.setServmun("");
            iteOrcamBean.setFuautor(0);
            iteOrcamBean.setDeprotot(0.0);
            iteOrcamBean.setAcprotot(0.0);
            iteOrcamBean.setExcluido("");
            iteOrcamBean.setDataalte(null);
            iteOrcamBean.setDataincl(new java.util.Date());
            iteOrcamBean.setQtdpecas(0.0);
            iteOrcamBean.setDiametro(0.0);
            iteOrcamBean.setObs(null);
            iteOrcamBean.setComprimento(0.0);
            iteOrcamBean.setHorapedi(null);
            iteOrcamBean.setDesccomp("");
            iteOrcamBean.setPafhashver("");
            iteOrcamBean.setPafhashdet("");

            //----------------------------------
            listaIteOrcamBean.add(iteOrcamBean);
        }
    }

    private DevolucaBean compoemDevolucaBean() throws ClassNotFoundException, IOException, Exception {

        Integer proximoIdDevolucaBean = controle.proximoId(ConfiguracaoBean.getNumeroCaixa(), "Devoluca");

        DevolucaBean devolucaBean = new DevolucaBean();
        devolucaBean.setCacodigo(ConfiguracaoBean.getNumeroCaixa());
        devolucaBean.setDvcodigo(proximoIdDevolucaBean);
        devolucaBean.setData(dataVenda);
        devolucaBean.setValdevol(valorTotal);
        devolucaBean.setFucodigo(codigoVendedor);
        devolucaBean.setPeriodo(0);
        devolucaBean.setHorario(horasVenda);

        devolucaBean.setHorainic("");
        devolucaBean.setBaixaesto(baixaEstoque);
        devolucaBean.setFlagtrans("");
        devolucaBean.setFlagtserv("");
        devolucaBean.setSetoruso("");
        devolucaBean.setNuregesp("");
        devolucaBean.setNumerocoo(0);
        devolucaBean.setNucooctvl(0);

        devolucaBean.setClcodigo((clienPdvBean != null && clienPdvBean.getClcodigo() != null) ? clienPdvBean.getClcodigo() : 0);//4 CLCODIGO N 6 Código do cliente S 23 28
        devolucaBean.setTipo((clienPdvBean != null && clienPdvBean.getTipo() != null) ? clienPdvBean.getTipo() : "");
        devolucaBean.setCgc((clienPdvBean != null && clienPdvBean.getCgc() != null) ? clienPdvBean.getCgc() : "");//41 CGCCLIE C 14 CNPJ do Cliente 707 720
        devolucaBean.setCpf((clienPdvBean != null && clienPdvBean.getCpf() != null) ? clienPdvBean.getCpf() : "");//42 CPFCLIE C 11 CPF do Cliente 721 731                       
        devolucaBean.setNome((clienPdvBean != null && clienPdvBean.getNome() != null) ? clienPdvBean.getNome() : "");//18 NOME A 40 Nome do cliente 125 164
        devolucaBean.setTelefone((clienPdvBean != null && clienPdvBean.getFoneCel() != null) ? clienPdvBean.getFoneCel() : "");//20 TELEFONE C 18 Telefone do cliente 205 222
        devolucaBean.setFantasia((clienPdvBean != null && clienPdvBean.getFantasia() != null) ? clienPdvBean.getFantasia() : "");
        devolucaBean.setEndereco((clienPdvBean != null && clienPdvBean.getEndereco() != null) ? clienPdvBean.getEndereco() : "");//19 ENDEREÇO C 40 Endereço do cliente 165 204
        devolucaBean.setTpenderecocom((clienPdvBean != null && clienPdvBean.getTpenderecocom() != null) ? clienPdvBean.getTpenderecocom() : 0);
        devolucaBean.setComplementocom((clienPdvBean != null && clienPdvBean.getComplementocom() != null) ? clienPdvBean.getComplementocom() : "");

        devolucaBean.setNumerocom((clienPdvBean != null && clienPdvBean.getNumerocom() != null) ? clienPdvBean.getNumerocom() : 0);
        devolucaBean.setBairro((clienPdvBean != null && clienPdvBean.getBairro() != null) ? clienPdvBean.getBairro() : "");
        devolucaBean.setCicodigo((clienPdvBean != null && clienPdvBean.getCicodigo() != null) ? clienPdvBean.getCicodigo() : 0);
        devolucaBean.setNomecidade("MOEMA");
        devolucaBean.setUf((clienPdvBean != null && clienPdvBean.getUf() != null) ? clienPdvBean.getUf() : "");
        devolucaBean.setCep((clienPdvBean != null && clienPdvBean.getCep() != null) ? clienPdvBean.getCep() : "");

        devolucaBean.setModelonf("");
        devolucaBean.setSerienf("");
        devolucaBean.setSubserienf("");
        devolucaBean.setNumeronf(0);

        return devolucaBean;
    }

    private List<ItemDevoBean> CompoemItemDevoBean() throws ClassNotFoundException, IOException, Exception {

        ItemDevoBean itemDevoBean;
        List<ItemDevoBean> listaItemDevoBean = new ArrayList<>();
        Integer proximoIdItemDevoBean = controle.proximoId(ConfiguracaoBean.getNumeroCaixa(), "ItemDevo");

        for (ItemVpdvBean o : listaItens) {

            itemDevoBean = new ItemDevoBean();
            itemDevoBean.setCacodigo(ConfiguracaoBean.getNumeroCaixa());
            itemDevoBean.setDvcodigo(proximoIdItemDevoBean);
            itemDevoBean.setNumitem(o.getNumitem());
            itemDevoBean.setMfcodigo(o.getMfcodigo());
            itemDevoBean.setPlcodigo(o.getPlcodigo());
            itemDevoBean.setQtditem(o.getQtditem());
            itemDevoBean.setValitem(o.getValitem());
            itemDevoBean.setFucodigo(o.getFucodigo());
            itemDevoBean.setFucodlan(o.getFucodlan());
            itemDevoBean.setAliqicms(o.getAliqicms());
            itemDevoBean.setCodtrib(o.getCodtrib());
            itemDevoBean.setNumdocum(o.getNumdocum());
            itemDevoBean.setPrcunit(o.getPrcunit());
            itemDevoBean.setMmfcodigo(o.getMmfcodigo());
            itemDevoBean.setNome(o.getNome());
            itemDevoBean.setUncodigo(o.getUncodigo());
            itemDevoBean.setPrecoven(o.getPrecoven());
            itemDevoBean.setMaliqicms(o.getMaliqicms());
            itemDevoBean.setCodorige(o.getCodorige());
            itemDevoBean.setMcodtrib(o.getMcodtrib());
            itemDevoBean.setPesavel(o.getPesavel());
            itemDevoBean.setAliqipi(o.getAliqipi());
            itemDevoBean.setCodextra(o.getCodextra());
            itemDevoBean.setReferenci(o.getReferenci());
            itemDevoBean.setGrade(o.getGrade());
            itemDevoBean.setCor(o.getCor());
            itemDevoBean.setTamanho(o.getTamanho());
            itemDevoBean.setCodintern(o.getCodintern());
            itemDevoBean.setTipotribu(o.getTipotribu());
            itemDevoBean.setPrecoven1(o.getPrecoven1());
            itemDevoBean.setQtdestoq(o.getQtdestoq());
            itemDevoBean.setPathfoto(o.getPathfoto());
            itemDevoBean.setPathfoto(o.getPathfoto());
            itemDevoBean.setAgcodigo(o.getAgcodigo());
            itemDevoBean.setExcluido(o.getExcluido());
            itemDevoBean.setFlagtrans(o.getFlagtrans());
            itemDevoBean.setFlagtserv(o.getFlagtserv());
            itemDevoBean.setDeprotot(o.getDeprotot());
            itemDevoBean.setAcprotot(o.getAcprotot());
            itemDevoBean.setComposto(o.getComposto());
            itemDevoBean.setCacodori(o.getCacodori());
            itemDevoBean.setSetorori(o.getSetorori());
            itemDevoBean.setCodrecei(o.getCodrecei());
            itemDevoBean.setHorarece(o.getHorarece());
            itemDevoBean.setQtdrecei(o.getQtdrecei());
            itemDevoBean.setTipofab(o.getTipofab());
            itemDevoBean.setIat(o.getIat());
            itemDevoBean.setCacodcup("");
            itemDevoBean.setVdcodigo(o.getVdcodigo());
            itemDevoBean.setItemvend(0);
            itemDevoBean.setDatahoracup(dataVenda);
            itemDevoBean.setDatacup(dataVenda);
            itemDevoBean.setNumcupom(0);
            itemDevoBean.setNumcoocup(0);
            itemDevoBean.setDtmovcup(dataVenda);
            itemDevoBean.setEcfserievnd("");

            listaItemDevoBean.add(itemDevoBean);
            ++proximoIdItemDevoBean;
        }

        return listaItemDevoBean;
    }

    private void telaInicial() {

        if (statusCaixa != StatusCaixa.DESATIVADO) {
            statusCaixa = StatusCaixa.LIVRE;
        }

        vendaPdvBean = null;
        preVdPdvBean = null;
        listaItens = null;
        listaItPrVpdvBean = null;
        listaLancamenBean = null;
        listaMvCaipdvBean = null;
        listaIteOrcamBean = null;
        orcamentBean = null;
        clienPdvBean = null;    //cadastro de cliente
        valorTotal = 0.0;
        valorSubtotal = 0.0;
        valorDesconto = 0.0;
        valorAcrescimo = 0.0;

        //-----------------------------------------
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ((DefaultTableModel) tabelaItens.getModel()).setRowCount(0); //limpar tabela

                if (null != statusCaixa) {
                    switch (statusCaixa) {
                        case LIVRE:
                            labelStatusCaixa.setText("Caixa Livre");
                            break;
                        case DESATIVADO:
                            labelStatusCaixa.setText("Ativar Sistema");
                            break;
                        case VENDA_NORMAL:
                            labelStatusCaixa.setText("Venda em Andamento");
                            break;
                        case ORCAMENTO:
                            labelStatusCaixa.setText("Orçamento em Andamento");
                            break;
                        default:
                            break;
                    }
                }

                labelSubtotal.setText("0,00");
                ftfQuantidade.setText("1");

                ftfCodigoItem.setText("");
                ftfCodigoItem.requestFocus();
            }
        });
    }

    private void abrirVenda() {

        if (statusCaixa != StatusCaixa.DESATIVADO) {
            statusCaixa = OpcaoOperacao();
        }

        //-----------------
        if (vendaPdvBean == null) {
            vendaPdvBean = new VendaPdvBean();
        }

        if (preVdPdvBean == null) {
            preVdPdvBean = new PreVdPdvBean();
        }
        if (listaItens == null || listaItens.isEmpty()) { //primeiro item da venda
            listaItens = new ArrayList<ItemVpdvBean>();
        }

        if (listaItPrVpdvBean == null || listaItPrVpdvBean.isEmpty()) {
            listaItPrVpdvBean = new ArrayList<ItPrVpdvBean>();
        }

        if (listaLancamenBean == null || listaLancamenBean.isEmpty()) { //primeiro item da venda
            listaLancamenBean = new ArrayList<LancamenBean>();
        }

        if (listaMvCaipdvBean == null || listaMvCaipdvBean.isEmpty()) { //primeiro item da venda
            listaMvCaipdvBean = new ArrayList<MvCaipdvBean>();
        }

        if (listaIteOrcamBean == null || listaIteOrcamBean.isEmpty()) {
            listaIteOrcamBean = new ArrayList<IteOrcamBean>();
        }

        funcionarioItem = null;
        numitem = 0;
        emitirCupom = "N";
        valorTotal = 0.0;
        valorSubtotal = 0.0;
        valorDesconto = 0.0;
        valorAcrescimo = 0.0;

        if (null != statusCaixa) {
            switch (statusCaixa) {
                case LIVRE:
                    labelStatusCaixa.setText("Caixa Livre");
                    break;
                case DESATIVADO:
                    labelStatusCaixa.setText("Ativar Sistema");
                    break;
                case VENDA_NORMAL:
                    labelStatusCaixa.setText("Venda em Andamento");
                    break;
                case ORCAMENTO:
                    labelStatusCaixa.setText("Orçamento em Andamento");
                    break;
                default:
                    break;
            }
        }

    }

    private void atualizarTela(ItemVpdvBean item) {

        //adicionando item na tabela de lista de selecao (itens vendidos)
        DefaultTableModel modeloTabela;
        modeloTabela = ((DefaultTableModel) tabelaItens.getModel());

        String colunaCodigo = item.getMfcodigo();
        String colunaDescricao = item.getNome();
        String colunaUnidades = item.getUncodigo();
        String colunaQuantidade = Biblioteca.formatarNumero(Biblioteca.truncar(item.getQtditem(), 3), "#,###,##0." + Biblioteca.repete("0", 3));
        String colunaValor = Biblioteca.formatarNumero(Biblioteca.truncar(item.getPrecoven(), 2), "R$ #,###,##0." + Biblioteca.repete("0", 2));
        //String colunaDescontoItem = Biblioteca.formatarNumero(Biblioteca.truncar(vendasItensBean.getValorDesconto(), Caixa.configuracaoBean.getDecimaisValor()), "R$ #,###,##0.00");
        //String colunaAcrescimoItem = Biblioteca.formatarNumero(Biblioteca.truncar(vendasItensBean.getValorAcrescimo(), Caixa.configuracaoBean.getDecimaisValor()), "R$ #,###,##0.00");
        String colunaValorSubtotal = Biblioteca.formatarNumero(Biblioteca.truncar(item.getValitem(), 2), "R$ #,###,##0." + Biblioteca.repete("0", 2));

        Object[] x = new Object[]{
            colunaCodigo,
            colunaDescricao,
            colunaUnidades,
            colunaQuantidade,
            colunaValor,
            colunaValorSubtotal
        };

        modeloTabela.addRow(x);

        //---------------------------------------------
        labelSubtotal.setText(Biblioteca.formatarNumero(Biblioteca.truncar(valorSubtotal, 2), "R$#,###,##0." + Biblioteca.repete("0", 2)));
        ftfQuantidade.setText("1");
        ftfCodigoItem.setText("");
    }

    //=============================================================
    private void atualizarTabela(List<ItemVpdvBean> listaItemAux) {

        ((DefaultTableModel) tabelaItens.getModel()).setRowCount(0);

        if (listaItemAux != null && listaItemAux.size() > 0) {

            for (ItemVpdvBean o : listaItemAux) {
                String colunaCodigo = o.getMfcodigo();
                String colunaDescricao = o.getNome();
                String colunaUnidades = o.getUncodigo();
                String colunaQuantidade = Biblioteca.formatarNumero(Biblioteca.truncar(o.getQtditem(), 3), "#,###,##0." + Biblioteca.repete("0", 3));
                String colunaValor = Biblioteca.formatarNumero(Biblioteca.truncar(o.getPrecoven(), 2), "R$ #,###,##0." + Biblioteca.repete("0", 2));
                //String colunaDescontoItem = Biblioteca.formatarNumero(Biblioteca.truncar(vendasItensBean.getValorDesconto(), Caixa.configuracaoBean.getDecimaisValor()), "R$ #,###,##0.00");
                //String colunaAcrescimoItem = Biblioteca.formatarNumero(Biblioteca.truncar(vendasItensBean.getValorAcrescimo(), Caixa.configuracaoBean.getDecimaisValor()), "R$ #,###,##0.00");
                String colunaValorSubtotal = Biblioteca.formatarNumero(Biblioteca.truncar(o.getValitem(), 2), "R$ #,###,##0." + Biblioteca.repete("0", 2));

                Object[] linha = {
                    colunaCodigo,
                    colunaDescricao,
                    colunaUnidades,
                    colunaQuantidade,
                    colunaValor,
                    colunaValorSubtotal
                };

                ((DefaultTableModel) tabelaItens.getModel()).addRow(linha);
            }

            //tabelaParcelas.requestFocus();
            //tabelaParcelas.setRowSelectionInterval(0, 0); //da pau quando vazia
        }
        //---------------------------------------------
        labelSubtotal.setText(Biblioteca.formatarNumero(Biblioteca.truncar(valorSubtotal, 2), "R$#,###,##0." + Biblioteca.repete("0", 2)));
        ftfQuantidade.setText("1");

        if (null != statusCaixa) {
            switch (statusCaixa) {
                case LIVRE:
                    labelStatusCaixa.setText("Caixa Livre");
                    break;
                case DESATIVADO:
                    labelStatusCaixa.setText("Ativar Sistema");
                    break;
                case VENDA_NORMAL:
                    labelStatusCaixa.setText("Venda em Andamento");
                    break;
                case ORCAMENTO:
                    labelStatusCaixa.setText("Orçamento em Andamento");
                    break;
                default:
                    break;
            }
        }

        ftfCodigoItem.requestFocus();
    }

    //==================================
    private void formatarTabelaItens() {

        /**
         * ******************************************************************
         **
         ********************************************************************
         */
        //tabelaItens.getTableHeader().setPreferredSize(new Dimension(1124, 25));
        //tabelaItens.setAutoResizeMode (JTable.AUTO_RESIZE_OFF); //Para mostrar scroll vertical e horizontal: 
        tabelaItens.getTableHeader().setFont(new java.awt.Font("Verdana", 0, 18));
        tabelaItens.setFont(new java.awt.Font("Verdana", 0, 18));
        //tabelaItens.setAutoCreateRowSorter(true); //ORDENA AS COLUNAS DE UMA TABELA

        //colunaCodigo
        tabelaItens.getColumnModel().getColumn(0).setMinWidth(100);
        tabelaItens.getColumnModel().getColumn(0).setMaxWidth(100);
        tabelaItens.getColumnModel().getColumn(0).setPreferredWidth(100);

        //colunaDescricao
        //tabelaItens.getColumnModel().getColumn(1).setMinWidth(700);
        //tabelaItens.getColumnModel().getColumn(1).setMaxWidth(1100);
        tabelaItens.getColumnModel().getColumn(1).setPreferredWidth(1300);

        //colunaUnidades()
        tabelaItens.getColumnModel().getColumn(2).setMinWidth(80);
        tabelaItens.getColumnModel().getColumn(2).setMaxWidth(150);
        tabelaItens.getColumnModel().getColumn(2).setPreferredWidth(100);

        //colunaQuantidade()
        tabelaItens.getColumnModel().getColumn(3).setMinWidth(120);
        tabelaItens.getColumnModel().getColumn(3).setMaxWidth(250);
        tabelaItens.getColumnModel().getColumn(3).setPreferredWidth(120);

        //colunaValor()
        tabelaItens.getColumnModel().getColumn(4).setMinWidth(120);
        tabelaItens.getColumnModel().getColumn(4).setMaxWidth(250);
        tabelaItens.getColumnModel().getColumn(4).setPreferredWidth(150);

        //colunaValorSubtotal()
        tabelaItens.getColumnModel().getColumn(5).setMinWidth(120);
        tabelaItens.getColumnModel().getColumn(5).setMaxWidth(250);
        tabelaItens.getColumnModel().getColumn(5).setPreferredWidth(150);

        //ajuste conteudo na celula
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();

        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);

        tabelaItens.getColumnModel().getColumn(0).setCellRenderer(direita);
        tabelaItens.getColumnModel().getColumn(1).setCellRenderer(esquerda);
        tabelaItens.getColumnModel().getColumn(2).setCellRenderer(esquerda);
        tabelaItens.getColumnModel().getColumn(3).setCellRenderer(direita);
        tabelaItens.getColumnModel().getColumn(4).setCellRenderer(direita);
        tabelaItens.getColumnModel().getColumn(5).setCellRenderer(direita);
    }

    //=============================================================================================================
    private void teclouESC() {

        if (null == statusCaixa) {

            Biblioteca.beep();

            String[] opcoes = {"Sim", "Não"};
            Integer escolha = JOptionPane.showOptionDialog(this, "Deseja sair do sistema?", Constantes.PERGUNTA_SISTEMA,
                    JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

            if (escolha == 0) {
                System.exit(0);
            }
        } else //sair
        {
            switch (statusCaixa) {
                case VENDA_NORMAL:
                    JOptionPane.showMessageDialog(rootPane, "Existe uma venda em andamento.", Constantes.AVISO_SISTEMA, JOptionPane.WARNING_MESSAGE);
                    break;
                case ORCAMENTO:
                    JOptionPane.showMessageDialog(rootPane, "Existe um orçamento em andamento.", Constantes.AVISO_SISTEMA, JOptionPane.WARNING_MESSAGE);
                    break;
                default:
                    Biblioteca.beep();
                    String[] opcoes = {"Sim", "Não"};
                    Integer escolha = JOptionPane.showOptionDialog(this, "Deseja sair do sistema?", Constantes.PERGUNTA_SISTEMA,
                            JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
                    if (escolha == 0) {
                        System.exit(0);
                    }
                    break;
            }
        }
    }

    //=======================================================
    private void labelF1Ajuda() {

        SobreSistema sobreSistema = new SobreSistema(new JFrame(), true);
        sobreSistema.setResizable(false);
        sobreSistema.setModal(true);
        sobreSistema.setVisible(true);
    }

    private boolean ConsultarItens() {

        Boolean ok = false;

        //----------------------------------
        ConsultarItens consultarItens = new ConsultarItens(new JFrame(), true);
        consultarItens.setResizable(false);
        consultarItens.setModal(true);
        consultarItens.setVisible(true);

        //---------------------------------------------------------------------
        MaterPdvBean materPdvBean = consultarItens.getMaterPdvBean();

        if (materPdvBean != null && !materPdvBean.getMfcodigo().isEmpty()) {

            //-----------------------------------------------
            if (listaItens == null || listaItens.isEmpty()) {
                abrirVenda();
            }

            //--------------------------------------------
            if (ConfiguracaoBean.getFuncionarioItem().equalsIgnoreCase("1")) {

                ConsultarFuncionario consultarFuncionario = new ConsultarFuncionario(new JFrame(), true);
                consultarFuncionario.setResizable(false);
                consultarFuncionario.setModal(true);
                consultarFuncionario.setFuncionaBean(funcionarioItem);
                consultarFuncionario.setVisible(true);

                //-------------------------------------------------------
                funcionarioItem = consultarFuncionario.getFuncionaBean();
                if (funcionarioItem == null) {
                    return ok;
                }

            }

            ok = compoemItemVpdvBean(materPdvBean);

            if (ok) {//mostrar na tela
                atualizarTela(listaItens.get(listaItens.size() - 1)); //ultimo item lancado
            }

        }

        return ok;
    }

    private void ConsultarClientes() {

        ConsultarClientes consultarClientes = new ConsultarClientes(new JFrame(), true);
        consultarClientes.setResizable(false);
        consultarClientes.setModal(true);
        consultarClientes.setVisible(true);

        clienPdvBean = consultarClientes.getMaterPdvBean();

    }

    private void deletarItem() {

        if (tabelaItens.getSelectedRow() >= 0) {

            ItemVpdvBean aux = listaItens.get(tabelaItens.getSelectedRow());

            valorSubtotal -= aux.getPrecoven() * aux.getQtditem();
            valorTotal -= aux.getPrecoven() * aux.getQtditem();
            listaItens.remove(aux);

            //--------------------------
            atualizarTabela(listaItens);

        }
    }

    private void fecharMovimentacao() throws SQLException, ClassNotFoundException, IOException, Exception {

        try {

            if (listaItens == null || listaItens.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Não encontrei nenhum item de venda lançado. Verifique!",
                        Constantes.AVISO_SISTEMA, JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            if (statusCaixa == StatusCaixa.DESATIVADO) {
                JOptionPane.showMessageDialog(this,
                        "Sistema não ativado. Entre em contato com suporte técnico.",
                        Constantes.AVISO_SISTEMA, JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            //******************************************************************
            //VENDA & VENDA DE DEVOLUCAO
            //******************************************************************
            if (statusCaixa == StatusCaixa.VENDA_NORMAL) {

                FecharVendas fecharVendas = new FecharVendas(new JFrame(), true);
                fecharVendas.setValorSubtotal(valorSubtotal);
                fecharVendas.setResizable(false);
                fecharVendas.setModal(true);
                fecharVendas.setVisible(true);

                //cancelamento de venda --------------
                if (fecharVendas.getCancelouVenda()) {
                    return;
                }

                //-----------------------------------------------
                valorAcrescimo = fecharVendas.getValorAcrescimo();
                valorDesconto = fecharVendas.getValorDesconto();
                valorTotal = fecharVendas.getValorTotal();

                dataVenda = fecharVendas.getDataVenda();
                horasVenda = fecharVendas.getHorasVenda();
                codigoVendedor = fecharVendas.getCodigoVendedor();
                observacaoVenda = fecharVendas.getObservacaoVenda();
                operFiscBean = fecharVendas.getOperFiscBean();
                listaLancamenBean = fecharVendas.getListaLancamenBean();
                emitirCupom = fecharVendas.getEmitirCupom();
                baixaEstoque = operFiscBean.getBaixaest();
                listaMvCaipdvBean = fecharVendas.getListaMvCaipdvBean();

                if (operFiscBean.getVenda().equalsIgnoreCase("S")) {

                    //-------------------------------------------------
                    compoemVendaPdvBean(); //compoem cabecalho da venda

                    //gravar venda no banco ------------------------------------------------------------
                    controle.fecharVenda(vendaPdvBean, listaItens, listaLancamenBean, listaMvCaipdvBean);

                    //gerar pre-venda -------------------------------------
                    if (emitirCupom.equalsIgnoreCase("S")) {
                        //compoem pre-venda
                        compoemPreVdPdvBean();
                        compoemItPrVpdvBean();

                        //MERDA;
                        controle.emitirCupom(preVdPdvBean, listaItPrVpdvBean);

                        JOptionPane.showMessageDialog(this,
                                "Número da Pre-venda: " + preVdPdvBean.getVdcodigo(),
                                Constantes.AVISO_SISTEMA, JOptionPane.INFORMATION_MESSAGE);
                    }

                    //impressao da venda -----------------------------------------------------------------
                    //Geral.imprimeVenda(Caixa.ConfiguracaoBean.getNumeroCaixa(), vendaPdvBean.getVdcodigo());
                } else { //venda de devolucao de mercadoria

                    DevolucaBean devolucaBean = compoemDevolucaBean();
                    //itens
                    //tens de Devolução : (Tabela-ITEMDEVO)
                    //select * from ITEMDEVO
                    List<ItemDevoBean> listaItemDevoBean = CompoemItemDevoBean();

                    //gravar venda no banco ---------------------------------------------------------------------------
                    controle.fecharVendaDevolucao(devolucaBean, "S", listaItemDevoBean);
                }
            }

            //*******************************************
            //ORCAMENTO
            //*******************************************
            if (statusCaixa == StatusCaixa.ORCAMENTO) {

                FecharOrcamento fecharOrcamento = new FecharOrcamento(new JFrame(), true);
                fecharOrcamento.setValorSubtotal(valorSubtotal);
                fecharOrcamento.setResizable(false);
                fecharOrcamento.setModal(true);
                fecharOrcamento.setVisible(true);

                //cancelamento de venda --------------
                if (fecharOrcamento.getCancelouVenda()) {
                    return;
                }

                //-----------------------------------------------
                valorAcrescimo = fecharOrcamento.getValorAcrescimo();
                valorDesconto = fecharOrcamento.getValorDesconto();
                valorTotal = fecharOrcamento.getValorTotal();
                dataVenda = fecharOrcamento.getDataVenda();
                orcamentDataValid = fecharOrcamento.getOrcamentDataValid();
                orcamentFormaPgto = fecharOrcamento.getOrcamentFormaPgto();
                horasVenda = fecharOrcamento.getHorasVenda();
                codigoVendedor = fecharOrcamento.getCodigoVendedor();
                observacaoVenda = fecharOrcamento.getObservacaoVenda();
                operFiscBean = null;
                listaLancamenBean = null;
                emitirCupom = null;
                baixaEstoque = null;
                listaMvCaipdvBean = null;

                //-----------------------------------------------------
                compoemOrcamentBean(); //compoem cabecalho do orcamento
                compoemIteOrcamBean();
                controle.fecharOrcamento(orcamentBean, listaIteOrcamBean);

                //impressao da venda -------------------------------------------
                //Geral.imprimeOrcamento(orcamentBean.getOrcodigo());
                if (Caixa.ConfiguracaoBean.getModoImpremeVenda().equals("0")) {
                    //caso nao imprima, exibir o numero do orcamento
                    JOptionPane.showMessageDialog(this,
                            "Número do orçamento: " + orcamentBean.getOrcodigo(),
                            Constantes.AVISO_SISTEMA, JOptionPane.INFORMATION_MESSAGE);
                }
            }

            //*******************
            telaInicial();
            //*******************

        } catch (Exception ex) {
            Loggin.logDiarioExcecao(ex, true);
        }
    }

    private void teclouF5() {

        if (listaItens == null || listaItens.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Não encontrei nenhum item de venda lançado. Verifique!",
                    Constantes.AVISO_SISTEMA, JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String[] opcoes = {"Sim", "Não"};
        Integer escolha = JOptionPane.showOptionDialog(this, "Confirma o cancelamento da venda?", Constantes.PERGUNTA_SISTEMA,
                JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

        if (escolha != 0) {
            return;
        }

        //------------
        telaInicial();
    }

    //============================================================================
    private void teclouF6Calculadora() {
        try {
            Runtime.getRuntime().exec("calc.exe");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "A calculadora não foi encontrada." + ex.getMessage(), Constantes.AVISO_SISTEMA, JOptionPane.WARNING_MESSAGE);
        }
    }

    private void teclouF7() {

        if (listaItens != null && listaItens.size() > 0) {
            JOptionPane.showMessageDialog(this,
                    "Desculpa!"
                    + "\n Existe uma venda em andamento."
                    + "\n"
                    + "\n Pressione:"
                    + "\n (F4) para finalizar ou "
                    + "\n (F5) cancelar a venda", Constantes.AVISO_SISTEMA, JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        MenuOpcoes menuOpcoes = new MenuOpcoes(new JFrame(), true);
        menuOpcoes.setResizable(false);
        menuOpcoes.setModal(true);
        menuOpcoes.setVisible(true);
    }

    private void verificarAcessoBanco() {

        File f = new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "acesso.properties");

        if (!f.exists()) {
            ConfigurarAcessoBD configurarAcesso = new ConfigurarAcessoBD(new JFrame(), true);
            configurarAcesso.setResizable(false);
            configurarAcesso.setModal(true);
            configurarAcesso.setVisible(true);

            this.repaint();
        }
    }

    private StatusCaixa OpcaoOperacao() {

        StatusCaixa operacao = StatusCaixa.LIVRE;

        if (ConfiguracaoBean.getTipoMovimento().equalsIgnoreCase("0")) {
            operacao = StatusCaixa.VENDA_NORMAL;
        } else if (ConfiguracaoBean.getTipoMovimento().equalsIgnoreCase("1")) {
            operacao = StatusCaixa.ORCAMENTO;
        } else if (ConfiguracaoBean.getTipoMovimento().equalsIgnoreCase("2")) {

            TipoMovimentacao tipoMovimentacao = new TipoMovimentacao(new JFrame(), true);
            tipoMovimentacao.setResizable(false);
            tipoMovimentacao.setModal(true);
            tipoMovimentacao.setVisible(true);
            operacao = tipoMovimentacao.getOperacao();

        } else {

            JOptionPane.showMessageDialog(this,
                    "Sistema não configurado. Verifique!", Constantes.AVISO_SISTEMA,
                    JOptionPane.INFORMATION_MESSAGE);
        }

        return operacao;
    }

    //***************************************************************************
    private class ESCAction extends AbstractAction {

        public ESCAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            teclouESC();
        }
    }

    //================================================
    class DelAction extends AbstractAction {

        public DelAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            deletarItem();
        }
    }

    //=======================================================
    private class F1Action extends AbstractAction {

        public F1Action() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            labelF1Ajuda();
        }

    }

    //***************************************************************************
    private class F2Action extends AbstractAction {

        public F2Action() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            ConsultarItens();
        }
    }

    //***************************************************************************
    private class F3Action extends AbstractAction {

        public F3Action() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            ConsultarClientes();
        }
    }

    //***************************************************************************
    private class F4Action extends AbstractAction {

        public F4Action() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                fecharMovimentacao();
            } catch (Exception ex) {
                Loggin.logDiarioExcecao(ex, true);
            }
        }
    }

    //***************************************************************************
    private class F5Action extends AbstractAction {

        public F5Action() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            teclouF5();
        }

    }

    //***************************************************************************
    private class F6Action extends AbstractAction {

        public F6Action() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            teclouF6Calculadora();
        }
    }

    //***************************************************************************
    private class F7Action extends AbstractAction {

        public F7Action() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            teclouF7();
        }
    }

    //***************************************************************************
    //DATA E HORA NA BARRA DE STATUS
    //***************************************************************************
    private class DataHoras implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    labelHoras.setText(Biblioteca.horaAtual(0));
                    labelDataAtual.setText(Biblioteca.dataExtenso());
                    Thread.sleep(5 * 1000); //atualizar a cada 5 segundo
                }
            } catch (InterruptedException ex) {
                Loggin.logDiarioExcecao(ex, true);
            }
        }
    }

}
