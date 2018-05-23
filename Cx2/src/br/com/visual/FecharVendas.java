/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.visual;

import br.com.controle.Controle;
import br.com.modelo.FormPagtBean;
import br.com.modelo.FuncionaBean;
import br.com.modelo.ItemVpdvBean;
import br.com.modelo.LancaIpdvBean;
import br.com.modelo.LancamenBean;
import br.com.modelo.MvCaipdvBean;
import br.com.modelo.OperFiscBean;
import br.com.modelo.ParcfPgtBean;
import static br.com.visual.Caixa.ConfiguracaoBean;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.AbstractAction;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author raul
 */
public class FecharVendas extends javax.swing.JDialog {

    private final Controle controle = new Controle();
    private final LancaIpdvBean lancaIpdvBean = new LancaIpdvBean();

    private OperFiscBean operFiscBean = new OperFiscBean();
    private List<FuncionaBean> listaFuncionaBean = new ArrayList<FuncionaBean>();

    private List<OperFiscBean> listaOperFiscBean = new ArrayList<OperFiscBean>();
    private List<FormPagtBean> listaFormPagtBean = new ArrayList<FormPagtBean>();
    private List<ParcfPgtBean> listaParcfPgtBean = new ArrayList<ParcfPgtBean>();
    private List<LancamenBean> listaLancamenBean = new ArrayList<LancamenBean>();
    private List<MvCaipdvBean> listaMvCaipdvBean = new ArrayList<MvCaipdvBean>();

    private List<ParcelamentosBean> listaParcelamentosBean = new ArrayList<ParcelamentosBean>();
    private LancamenBean lancamenBean = new LancamenBean();
    private Double valorSubtotal, valorTotal, valorDesconto, valorAcrescimo, valorPago;
    private String horasVenda, emitirCupom;
    private Date dataVenda;
    private Integer codigoVendedor, proximoIdVendaPdvBean;
    private String[] observacaoVenda = new String[8];
    private Boolean cancelouVenda;
    private String[][] array = null;

    public void setValorSubtotal(Double valorSubtotal) {
        this.valorSubtotal = valorSubtotal;
    }

    public Double getValorSubtotal() {
        return valorSubtotal;
    }

    public Double getValorDesconto() {
        return valorDesconto;
    }

    public Double getValorAcrescimo() {
        return valorAcrescimo;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public String getHorasVenda() {
        return horasVenda;
    }

    public Integer getCodigoVendedor() {
        return codigoVendedor;
    }

    public String[] getObservacaoVenda() {
        return observacaoVenda;
    }

    public String getEmitirCupom() {
        return emitirCupom;
    }

    public List<LancamenBean> getListaLancamenBean() {
        return listaLancamenBean;
    }

    public Boolean getCancelouVenda() {
        return cancelouVenda;
    }

    public OperFiscBean getOperFiscBean() {
        return operFiscBean;
    }

    public List<MvCaipdvBean> getListaMvCaipdvBean() {
        return listaMvCaipdvBean;
    }

    /**
     * Creates new form Fechar
     */
    public FecharVendas(java.awt.Frame parent, boolean modal) {
        
        super(parent, modal);
        initComponents();

        ImageIcon icone = new javax.swing.ImageIcon(Constantes.SH_ICONE);
        setIconImage(icone.getImage());

        //TECLA DEL
        DelAction delAction = new DelAction();
        tabelaParcelas.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "DelAction");
        tabelaParcelas.getActionMap().put("DelAction", delAction);
        this.setPreferredSize(new Dimension(1024, 650));
        this.pack();

        //TECLA F3
        F3Action f3Action = new F3Action();
        botaoSelecionarCliente.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0), "F3Action");
        botaoSelecionarCliente.getActionMap().put("F3Action", f3Action);
        //TECLA F4
        F4Action f4Action = new F4Action();
        botaoFecharVenda.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0), "F4Action");
        botaoFecharVenda.getActionMap().put("F4Action", f4Action);

        //TECLA F5
        F5Action f5Action = new F5Action();
        botaoCancelar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0), "F5Action");
        botaoCancelar.getActionMap().put("F5Action", f5Action);

        //----------------------
        valorSubtotal = 0.0;
        valorTotal = 0.0;
        valorDesconto = 0.0;
        valorAcrescimo = 0.0;
        valorPago = 0.0;

        if (Caixa.clienPdvBean != null && Caixa.clienPdvBean.getNome() != null) {
            ftfCliente.setText(Caixa.clienPdvBean.getNome());
        }

        comboVendedor.setSelectedIndex(0);
        ftfAcrescimo.setText("0,00");
        ftfDesconto.setText("0,00");
        ftfDataVenda.setText(Biblioteca.dataAtual(1));  //dd/mm/yyyy
        ftfHorasVenda.setText(Biblioteca.horaAtual(0)); //HH:mm

        try {

            DefaultComboBoxModel modeloCombo;

            //configuracao do vendedores ---------------------------------------------------------
            listaFuncionaBean = controle.listarFuncionaFuCodigo();
            modeloCombo = new DefaultComboBoxModel();
            for (FuncionaBean o : listaFuncionaBean) {
                modeloCombo.addElement(o.getNome());
            }
            comboVendedor.setModel(modeloCombo);
            comboVendedor.setEnabled(false);
            for (int i = 0; i < listaFuncionaBean.size(); ++i) {
                if (listaFuncionaBean.get(i).getFucodigo().equals(Caixa.funcionaBean.getFucodigo())) {
                    comboVendedor.setSelectedIndex(i);
                    break;
                }
            }

            //operacao de vendas ----------------------------------------------------------------------
            listaOperFiscBean = controle.listarOperFisc();
            modeloCombo = new DefaultComboBoxModel();
            for (OperFiscBean o : listaOperFiscBean) {
                modeloCombo.addElement(o.getOfcodigo() + " - " + o.getNome());
            }
            
            comboOperacao.setModel(modeloCombo);
            //comboOperacao.setEditable(true);
            for (int i = 0; i < listaOperFiscBean.size(); ++i) {
                if (listaOperFiscBean.get(i).getOfcodigo() == 5112) {
                    comboOperacao.setSelectedIndex(i);
                    break;
                }
            }
            
            //configuracao formas pagamento ---------------------------------------------------------
            listaFormPagtBean = controle.listarFormPagt();
            modeloCombo = new DefaultComboBoxModel();
            for (FormPagtBean o : listaFormPagtBean) {
                modeloCombo.addElement(o.getNome());
            }
            comboFormasPgto.setModel(modeloCombo);
            //comboVendedor.setEnabled(false);
            for (int i = 0; i < listaFormPagtBean.size(); ++i) {
                if (listaFormPagtBean.get(i).getFpcodigo().equals("999")) { //posiciona na primeira opcao de orcamento
                    comboFormasPgto.setSelectedIndex(i);
                    break;
                }
            }
            
            //------planos de pagamentos
            comboFormasPgtoItemStateChanged(null);
            
            //id da venda------------------------------------
            proximoIdVendaPdvBean = controle.proximoId( ConfiguracaoBean.getNumeroCaixa(), "vendaPdv");

            //calcular desconto do cliente --------------------------
            calcularDesconto();

            //interface ------------------------------------------------------------            
            ftfCliente.setEnabled(false);

            //----------------------------------------------------------------------
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
        panelFaixa = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lydCabecalhoVenda = new javax.swing.JLayeredPane();
        labelCliente = new javax.swing.JLabel();
        labelVendedor = new javax.swing.JLabel();
        labelAcrescimo = new javax.swing.JLabel();
        labelDesconto = new javax.swing.JLabel();
        labelData = new javax.swing.JLabel();
        labelHora = new javax.swing.JLabel();
        ftfCliente = new javax.swing.JFormattedTextField();
        comboVendedor = new javax.swing.JComboBox();
        ftfAcrescimo = new javax.swing.JFormattedTextField();
        ftfDesconto = new javax.swing.JFormattedTextField();
        ftfDataVenda = new javax.swing.JFormattedTextField();
        ftfHorasVenda = new javax.swing.JFormattedTextField();
        botaoSelecionarCliente = new javax.swing.JButton();
        labelOperacao = new javax.swing.JLabel();
        labelFormasPgto = new javax.swing.JLabel();
        comboFormasPgto = new javax.swing.JComboBox();
        comboOperacao = new javax.swing.JComboBox();
        lydLancamentos = new javax.swing.JLayeredPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelaParcelas = new javax.swing.JTable();
        lydPrazo = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        ftfEntradas = new javax.swing.JFormattedTextField();
        botaoCalcularParcelas = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboMeiosPgto = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        ftfValorPago = new javax.swing.JFormattedTextField();
        ftfVencimentos = new javax.swing.JFormattedTextField();
        lydRodape = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        lydResumoVenda = new javax.swing.JLayeredPane();
        labelSubtotal = new javax.swing.JLabel();
        labelResumoAcrescimo = new javax.swing.JLabel();
        labelResumoDesconto = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        labelRecebido = new javax.swing.JLabel();
        labelTroco = new javax.swing.JLabel();
        labelValorSubtotal = new javax.swing.JLabel();
        labelValorAcrescimo = new javax.swing.JLabel();
        labelValorDesconto = new javax.swing.JLabel();
        labelValorTotal = new javax.swing.JLabel();
        labelValorRecebido = new javax.swing.JLabel();
        labelValorTroco = new javax.swing.JLabel();
        lydBotao = new javax.swing.JLayeredPane();
        botaoCancelar = new javax.swing.JButton();
        botaoFecharVenda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Fechar Venda");
        setIconImage(null);
        setMinimumSize(new java.awt.Dimension(1024, 650));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        panelPrincipal.setMinimumSize(new java.awt.Dimension(1014, 758));
        panelPrincipal.setPreferredSize(new java.awt.Dimension(1014, 758));
        panelPrincipal.setLayout(new java.awt.GridBagLayout());

        panelFaixa.setBackground(new java.awt.Color(102, 102, 102));
        panelFaixa.setMinimumSize(new java.awt.Dimension(1015, 50));
        panelFaixa.setPreferredSize(new java.awt.Dimension(1015, 50));
        panelFaixa.setLayout(new java.awt.GridLayout(1, 0));

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Fechamento da Venda");
        panelFaixa.add(jLabel8);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        panelPrincipal.add(panelFaixa, gridBagConstraints);

        lydCabecalhoVenda.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações da Venda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N
        lydCabecalhoVenda.setMinimumSize(new java.awt.Dimension(1015, 160));
        lydCabecalhoVenda.setLayout(new java.awt.GridBagLayout());

        labelCliente.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        labelCliente.setText("Cliente:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        lydCabecalhoVenda.add(labelCliente, gridBagConstraints);

        labelVendedor.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        labelVendedor.setText("Vendedor:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        lydCabecalhoVenda.add(labelVendedor, gridBagConstraints);

        labelAcrescimo.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        labelAcrescimo.setText("Acrescimo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        lydCabecalhoVenda.add(labelAcrescimo, gridBagConstraints);

        labelDesconto.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        labelDesconto.setText("Desconto:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        lydCabecalhoVenda.add(labelDesconto, gridBagConstraints);

        labelData.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        labelData.setText("Data:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        lydCabecalhoVenda.add(labelData, gridBagConstraints);

        labelHora.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        labelHora.setText("Hora:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        lydCabecalhoVenda.add(labelHora, gridBagConstraints);

        ftfCliente.setText("Consumidor Final");
        ftfCliente.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        ftfCliente.setMinimumSize(new java.awt.Dimension(300, 30));
        ftfCliente.setPreferredSize(new java.awt.Dimension(300, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        lydCabecalhoVenda.add(ftfCliente, gridBagConstraints);

        comboVendedor.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        comboVendedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboVendedor.setMinimumSize(new java.awt.Dimension(300, 30));
        comboVendedor.setPreferredSize(new java.awt.Dimension(300, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        lydCabecalhoVenda.add(comboVendedor, gridBagConstraints);

        ftfAcrescimo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        ftfAcrescimo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ftfAcrescimo.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        ftfAcrescimo.setMinimumSize(new java.awt.Dimension(120, 30));
        ftfAcrescimo.setPreferredSize(new java.awt.Dimension(120, 30));
        ftfAcrescimo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ftfAcrescimoFocusLost(evt);
            }
        });
        ftfAcrescimo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ftfAcrescimoKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        lydCabecalhoVenda.add(ftfAcrescimo, gridBagConstraints);

        ftfDesconto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        ftfDesconto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ftfDesconto.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        ftfDesconto.setMinimumSize(new java.awt.Dimension(120, 30));
        ftfDesconto.setPreferredSize(new java.awt.Dimension(120, 30));
        ftfDesconto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ftfDescontoKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        lydCabecalhoVenda.add(ftfDesconto, gridBagConstraints);

        ftfDataVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        ftfDataVenda.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        ftfDataVenda.setMinimumSize(new java.awt.Dimension(200, 30));
        ftfDataVenda.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        lydCabecalhoVenda.add(ftfDataVenda, gridBagConstraints);

        ftfHorasVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        ftfHorasVenda.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        ftfHorasVenda.setMinimumSize(new java.awt.Dimension(200, 30));
        ftfHorasVenda.setPreferredSize(new java.awt.Dimension(200, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        lydCabecalhoVenda.add(ftfHorasVenda, gridBagConstraints);

        botaoSelecionarCliente.setText("F3");
        botaoSelecionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSelecionarClienteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        lydCabecalhoVenda.add(botaoSelecionarCliente, gridBagConstraints);

        labelOperacao.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        labelOperacao.setText("Operação:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        lydCabecalhoVenda.add(labelOperacao, gridBagConstraints);

        labelFormasPgto.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        labelFormasPgto.setText("Formas Pgto:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        lydCabecalhoVenda.add(labelFormasPgto, gridBagConstraints);

        comboFormasPgto.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        comboFormasPgto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboFormasPgto.setMinimumSize(new java.awt.Dimension(56, 30));
        comboFormasPgto.setPreferredSize(new java.awt.Dimension(56, 30));
        comboFormasPgto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboFormasPgtoItemStateChanged(evt);
            }
        });
        comboFormasPgto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFormasPgtoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        lydCabecalhoVenda.add(comboFormasPgto, gridBagConstraints);

        comboOperacao.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        comboOperacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboOperacao.setMinimumSize(new java.awt.Dimension(56, 30));
        comboOperacao.setPreferredSize(new java.awt.Dimension(56, 30));
        comboOperacao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboOperacaoItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        lydCabecalhoVenda.add(comboOperacao, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        panelPrincipal.add(lydCabecalhoVenda, gridBagConstraints);

        lydLancamentos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lançamentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N
        lydLancamentos.setMinimumSize(new java.awt.Dimension(1015, 200));
        lydLancamentos.setName(""); // NOI18N
        lydLancamentos.setPreferredSize(new java.awt.Dimension(964, 200));
        lydLancamentos.setLayout(new java.awt.GridBagLayout());

        jScrollPane4.setMinimumSize(new java.awt.Dimension(420, 160));
        jScrollPane4.setPreferredSize(new java.awt.Dimension(420, 160));

        tabelaParcelas.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tabelaParcelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vencimento", "Valor", "Meio Pgto."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaParcelas.setPreferredSize(new java.awt.Dimension(190, 0));
        jScrollPane4.setViewportView(tabelaParcelas);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        lydLancamentos.add(jScrollPane4, gridBagConstraints);

        lydPrazo.setMinimumSize(new java.awt.Dimension(250, 160));
        lydPrazo.setPreferredSize(new java.awt.Dimension(224, 160));
        lydPrazo.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setText("Valor da Entrada:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        lydPrazo.add(jLabel1, gridBagConstraints);

        ftfEntradas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ftfEntradas.setText("0,00");
        ftfEntradas.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        ftfEntradas.setMinimumSize(new java.awt.Dimension(220, 40));
        ftfEntradas.setPreferredSize(new java.awt.Dimension(220, 40));
        ftfEntradas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ftfEntradasKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        lydPrazo.add(ftfEntradas, gridBagConstraints);

        botaoCalcularParcelas.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        botaoCalcularParcelas.setText("Gerar Parcelas");
        botaoCalcularParcelas.setMaximumSize(new java.awt.Dimension(200, 40));
        botaoCalcularParcelas.setMinimumSize(new java.awt.Dimension(220, 40));
        botaoCalcularParcelas.setPreferredSize(new java.awt.Dimension(220, 55));
        botaoCalcularParcelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCalcularParcelasActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 60, 2);
        lydPrazo.add(botaoCalcularParcelas, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        lydLancamentos.add(lydPrazo, gridBagConstraints);

        jLayeredPane1.setMinimumSize(new java.awt.Dimension(300, 160));
        jLayeredPane1.setPreferredSize(new java.awt.Dimension(284, 160));
        jLayeredPane1.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setText("Vencimento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jLayeredPane1.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setText("Meios de Pagamento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jLayeredPane1.add(jLabel3, gridBagConstraints);

        comboMeiosPgto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        comboMeiosPgto.setMinimumSize(new java.awt.Dimension(270, 30));
        comboMeiosPgto.setPreferredSize(new java.awt.Dimension(270, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jLayeredPane1.add(comboMeiosPgto, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setText("Valor Pago");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jLayeredPane1.add(jLabel4, gridBagConstraints);

        ftfValorPago.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        ftfValorPago.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ftfValorPago.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        ftfValorPago.setMinimumSize(new java.awt.Dimension(270, 30));
        ftfValorPago.setPreferredSize(new java.awt.Dimension(270, 30));
        ftfValorPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ftfValorPagoKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jLayeredPane1.add(ftfValorPago, gridBagConstraints);

        ftfVencimentos.setMinimumSize(new java.awt.Dimension(270, 30));
        ftfVencimentos.setPreferredSize(new java.awt.Dimension(270, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        jLayeredPane1.add(ftfVencimentos, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        lydLancamentos.add(jLayeredPane1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        panelPrincipal.add(lydLancamentos, gridBagConstraints);

        lydRodape.setMinimumSize(new java.awt.Dimension(1015, 150));
        lydRodape.setPreferredSize(new java.awt.Dimension(1014, 150));
        lydRodape.setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observação:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextPane1.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jScrollPane1.setViewportView(jTextPane1);

        jPanel1.add(jScrollPane1);

        lydRodape.add(jPanel1);

        lydResumoVenda.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resumo da Venda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N
        lydResumoVenda.setMinimumSize(new java.awt.Dimension(121, 140));
        lydResumoVenda.setLayout(new java.awt.GridBagLayout());

        labelSubtotal.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelSubtotal.setText("Sutotal:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        lydResumoVenda.add(labelSubtotal, gridBagConstraints);

        labelResumoAcrescimo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelResumoAcrescimo.setText("Acrescimo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        lydResumoVenda.add(labelResumoAcrescimo, gridBagConstraints);

        labelResumoDesconto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelResumoDesconto.setForeground(new java.awt.Color(255, 0, 51));
        labelResumoDesconto.setText("Desconto:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        lydResumoVenda.add(labelResumoDesconto, gridBagConstraints);

        labelTotal.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelTotal.setForeground(new java.awt.Color(51, 153, 255));
        labelTotal.setText("Total:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        lydResumoVenda.add(labelTotal, gridBagConstraints);

        labelRecebido.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelRecebido.setText("Recebido:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        lydResumoVenda.add(labelRecebido, gridBagConstraints);

        labelTroco.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelTroco.setText("Troco:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        lydResumoVenda.add(labelTroco, gridBagConstraints);

        labelValorSubtotal.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelValorSubtotal.setText("0,00");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        lydResumoVenda.add(labelValorSubtotal, gridBagConstraints);

        labelValorAcrescimo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelValorAcrescimo.setText("0,00");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        lydResumoVenda.add(labelValorAcrescimo, gridBagConstraints);

        labelValorDesconto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelValorDesconto.setForeground(new java.awt.Color(255, 0, 51));
        labelValorDesconto.setText("0,00");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        lydResumoVenda.add(labelValorDesconto, gridBagConstraints);

        labelValorTotal.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelValorTotal.setForeground(new java.awt.Color(51, 153, 255));
        labelValorTotal.setText("0,00");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        lydResumoVenda.add(labelValorTotal, gridBagConstraints);

        labelValorRecebido.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelValorRecebido.setText("0,00");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        lydResumoVenda.add(labelValorRecebido, gridBagConstraints);

        labelValorTroco.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelValorTroco.setText("0,00");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        lydResumoVenda.add(labelValorTroco, gridBagConstraints);

        lydRodape.add(lydResumoVenda);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        panelPrincipal.add(lydRodape, gridBagConstraints);

        lydBotao.setMinimumSize(new java.awt.Dimension(1015, 45));
        lydBotao.setName(""); // NOI18N
        lydBotao.setPreferredSize(new java.awt.Dimension(1014, 45));
        lydBotao.setLayout(new java.awt.GridBagLayout());

        botaoCancelar.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        botaoCancelar.setText("Cancelar (F5)");
        botaoCancelar.setMinimumSize(new java.awt.Dimension(200, 45));
        botaoCancelar.setPreferredSize(new java.awt.Dimension(200, 45));
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        lydBotao.add(botaoCancelar, gridBagConstraints);

        botaoFecharVenda.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        botaoFecharVenda.setText("Fechar Venda (F4)");
        botaoFecharVenda.setMinimumSize(new java.awt.Dimension(200, 45));
        botaoFecharVenda.setPreferredSize(new java.awt.Dimension(200, 45));
        botaoFecharVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFecharVendaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        lydBotao.add(botaoFecharVenda, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        panelPrincipal.add(lydBotao, gridBagConstraints);

        getContentPane().add(panelPrincipal);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        cancelar();
    }//GEN-LAST:event_formWindowClosing

    private void botaoFecharVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFecharVendaActionPerformed
        fechar();
    }//GEN-LAST:event_botaoFecharVendaActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void ftfAcrescimoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ftfAcrescimoFocusLost

    }//GEN-LAST:event_ftfAcrescimoFocusLost

    private void ftfAcrescimoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftfAcrescimoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) { //pressionou ENTER
            valorAcrescimo = Double.valueOf(ftfAcrescimo.getText().replace(".", "").replace(",", "."));
            resumoVenda();
        }
    }//GEN-LAST:event_ftfAcrescimoKeyPressed

    private void ftfDescontoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftfDescontoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) { //pressionou ENTER
            valorDesconto = Double.valueOf(ftfDesconto.getText().replace(".", "").replace(",", "."));
            resumoVenda();
        }
    }//GEN-LAST:event_ftfDescontoKeyPressed

    private void ftfValorPagoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftfValorPagoKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) { //pressionou ENTER

            if (valorPago >= valorTotal) {
                JOptionPane.showMessageDialog(this, "Feche a venda!", Constantes.AVISO_SISTEMA, JOptionPane.INFORMATION_MESSAGE);
                botaoFecharVenda.requestFocus();
                return;
            }

            if (ftfVencimentos.getText() == null || ftfVencimentos.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Informe a data de vencimento.", Constantes.AVISO_SISTEMA, JOptionPane.INFORMATION_MESSAGE);
                ftfVencimentos.requestFocus();
                return;
            }

            java.util.Date vencimento = null;
            ParcelamentosBean aux = new ParcelamentosBean();
            FormPagtBean aux2 = listaFormPagtBean.get(comboFormasPgto.getSelectedIndex());

            Double valorPagoAux = Double.valueOf(ftfValorPago.getText().replace(".", "").replace(",", "."));
            try {
                vencimento = Biblioteca.stringToDate(2, ftfVencimentos.getText().trim() + " 00:00:00");
            } catch (ParseException ex) {
                Loggin.logDiarioExcecao(ex, true);
            }

            //---------------------------------------
            aux.setDocumentos(Biblioteca.strzero(proximoIdVendaPdvBean, 6) + "-" + listaParcelamentosBean.size() + "/" + aux2.getQtdparc());

            if (listaParcelamentosBean.isEmpty() && (valorPagoAux + valorPago) > valorTotal) {

                valorPago = valorPago + valorPagoAux;
                valorPagoAux = valorTotal;
                aux.setValorParcelas(valorTotal);

            } else {
                aux.setValorParcelas(valorPagoAux);
                valorPago = valorPago + valorPagoAux;
            }

            aux.setEmissao(vencimento);
            aux.setVencimento(vencimento);
            aux.setCodigoMeioPgto(Integer.valueOf(array[comboMeiosPgto.getSelectedIndex()][0]));
            aux.setDescricaoMeioPgto(array[comboMeiosPgto.getSelectedIndex()][1]);

            //----------------------------------------------------------------------------
            Boolean achou = false;
            for (ParcelamentosBean o : listaParcelamentosBean) {
                if (o.getVencimento().compareTo(aux.getVencimento()) == 0 && o.getCodigoMeioPgto().equals(aux.getCodigoMeioPgto())) {

                    if (o.getValorParcelas() + valorPagoAux > valorTotal) {
                        o.setValorParcelas(o.getValorParcelas() + (valorTotal - o.getValorParcelas()));

                    } else {
                        o.setValorParcelas(o.getValorParcelas() + valorPagoAux);
                    }

                    achou = true;
                    break;
                }
            }
            if (!achou) {
                aux.setValorParcelas(valorPagoAux);
                listaParcelamentosBean.add(aux);
            }
            //----------------------------------------------------------------------------
            atualizarTabela(listaParcelamentosBean);
            resumoVenda();

            if (valorPago >= valorTotal) {
                botaoFecharVenda.requestFocus();
            }
        }
    }//GEN-LAST:event_ftfValorPagoKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        formatarTabela();

        //-------------------------------
        resumoVenda();

        ftfValorPago.setText(Biblioteca.formatarNumero(valorTotal, "#,###,##0.00"));

    }//GEN-LAST:event_formWindowOpened

    private void ftfEntradasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftfEntradasKeyPressed

    }//GEN-LAST:event_ftfEntradasKeyPressed

    private void comboFormasPgtoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboFormasPgtoItemStateChanged

        listaParcelamentosBean = new ArrayList<>();
        atualizarTabela(listaParcelamentosBean);
        valorPago = 0.0;

        if (listaFormPagtBean != null) {
            FormPagtBean o = listaFormPagtBean.get(comboFormasPgto.getSelectedIndex());
            if (o.getQtdparc() > 0) {

                if ((o.getDiasentra() != null && o.getDiasentra() > 0)) {
                    ftfEntradas.setEnabled(true); //Numero de dias para a entrada    
                    ftfValorPago.setText(Biblioteca.formatarNumero(valorTotal * o.getPercentra() / 100, "#,###,##0.00")); //Percentual Da Entrada
                } else {
                    ftfEntradas.setText("0,00"); //Percentual Da Entrada
                    ftfEntradas.setEnabled(false); //Numero de dias para a entrada
                }

                botaoCalcularParcelas.setEnabled(true);

                //valor pago
                //ftfValorPago.setEnabled(false);
                ftfValorPago.setText(Biblioteca.formatarNumero(valorTotal, "#,###,##0.00"));

                botaoCalcularParcelas.requestFocus();

                ftfVencimentos.setEditable(true);

            } else { //a vista

                ftfEntradas.setText("0,00");
                ftfEntradas.setEnabled(false);
                botaoCalcularParcelas.setEnabled(false);

                ftfVencimentos.setText(Biblioteca.dataAtual(1));  //dd/mm/yyyy

                ftfValorPago.setEnabled(true);
                ftfValorPago.requestFocus();

                ftfVencimentos.setEditable(false);
            }

            //-----------------------------------------
            //Campo que no momento do parcelamento, 
            //possibilita visualizar apenas as formas do tipo especificado.    
            array = null;
            switch (o.getCodespec()) {
                case 0:

                    array = new String[4][2];
                    array[0][0] = "1";
                    array[0][1] = "Dinheiro";

                    array[1][0] = "2";
                    array[1][1] = "Cartão";

                    array[2][0] = "3";
                    array[2][1] = "Cheque";

                    array[3][0] = "4";
                    array[3][1] = "Vale";

                    break;
                case 1: //1 - Dinheiro
                    array = new String[1][2];
                    array[0][0] = "1";
                    array[0][1] = "Dinheiro";
                    break;
                case 2: //2 - Cartão
                    array = new String[1][2];
                    array[0][0] = "2";
                    array[0][1] = "Cartão";
                    break;
                case 3: //3 - Cheque
                    array = new String[1][2];
                    array[0][0] = "3";
                    array[0][1] = "Cheque";
                    break;
                case 4: //4 - Vale
                    array = new String[1][2];
                    array[0][0] = "4";
                    array[0][1] = "Vale";
                    break;
            }

            DefaultComboBoxModel modeloCombo;
            modeloCombo = new DefaultComboBoxModel();

            for (String[] i : array) {
                modeloCombo.addElement(i[1]);
            }

            comboMeiosPgto.setModel(modeloCombo);
            comboMeiosPgto.setEditable(true);

        }
    }//GEN-LAST:event_comboFormasPgtoItemStateChanged

    private void botaoCalcularParcelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCalcularParcelasActionPerformed
        try {
            CalcularParcelas();
        } catch (Exception ex) {
            Loggin.logDiarioExcecao(ex, true);
        }
    }//GEN-LAST:event_botaoCalcularParcelasActionPerformed

    private void comboOperacaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboOperacaoItemStateChanged

        OperFiscBean aux = listaOperFiscBean.get(comboOperacao.getSelectedIndex());

        try {

            if (!aux.getVenda().equalsIgnoreCase("S")) {
                listaFormPagtBean = controle.listarFormPagt("VISTA");
            } else {//venda normal
                listaFormPagtBean = controle.listarFormPagt();
            }

            //configuracao das Formas de Pgto ---------------------------------------------------------                
            DefaultComboBoxModel modeloCombo = new DefaultComboBoxModel();
            for (FormPagtBean o : listaFormPagtBean) {
                modeloCombo.addElement(o.getNome());
            }
            comboFormasPgto.setModel(modeloCombo);
            //comboFormasPgto.setEditable(true);
            for (int i = 0; i < listaFormPagtBean.size(); ++i) {
                if (listaFormPagtBean.get(i).getFpcodigo().trim().equalsIgnoreCase("1")) { //FORMA PADRAO
                    comboFormasPgto.setSelectedIndex(i);
                    break;
                }
            }

            //----filtrar as formas de pagamento
            comboFormasPgtoItemStateChanged(null);
        } catch (Exception ex) {
            Loggin.logDiarioExcecao(ex, true);
        }

    }//GEN-LAST:event_comboOperacaoItemStateChanged

    private void botaoSelecionarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSelecionarClienteActionPerformed

        ConsultarClientes consultarClientes = new ConsultarClientes(new JFrame(), true);
        consultarClientes.setResizable(false);
        consultarClientes.setModal(true);
        consultarClientes.setVisible(true);

        Caixa.clienPdvBean = consultarClientes.getMaterPdvBean();
        ftfCliente.setText(Caixa.clienPdvBean.getNome());

        try {
            //calcular desconto
            calcularDesconto();
        } catch (Exception ex) {
            Loggin.logDiarioExcecao(ex, true);
        }

    }//GEN-LAST:event_botaoSelecionarClienteActionPerformed

    private void comboFormasPgtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFormasPgtoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboFormasPgtoActionPerformed

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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FecharVendas dialog = new FecharVendas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCalcularParcelas;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoFecharVenda;
    private javax.swing.JButton botaoSelecionarCliente;
    private javax.swing.JComboBox comboFormasPgto;
    private javax.swing.JComboBox comboMeiosPgto;
    private javax.swing.JComboBox comboOperacao;
    private javax.swing.JComboBox comboVendedor;
    private javax.swing.JFormattedTextField ftfAcrescimo;
    private javax.swing.JFormattedTextField ftfCliente;
    private javax.swing.JFormattedTextField ftfDataVenda;
    private javax.swing.JFormattedTextField ftfDesconto;
    private javax.swing.JFormattedTextField ftfEntradas;
    private javax.swing.JFormattedTextField ftfHorasVenda;
    private javax.swing.JFormattedTextField ftfValorPago;
    private javax.swing.JFormattedTextField ftfVencimentos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel labelAcrescimo;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelDesconto;
    private javax.swing.JLabel labelFormasPgto;
    private javax.swing.JLabel labelHora;
    private javax.swing.JLabel labelOperacao;
    private javax.swing.JLabel labelRecebido;
    private javax.swing.JLabel labelResumoAcrescimo;
    private javax.swing.JLabel labelResumoDesconto;
    private javax.swing.JLabel labelSubtotal;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel labelTroco;
    private javax.swing.JLabel labelValorAcrescimo;
    private javax.swing.JLabel labelValorDesconto;
    private javax.swing.JLabel labelValorRecebido;
    private javax.swing.JLabel labelValorSubtotal;
    private javax.swing.JLabel labelValorTotal;
    private javax.swing.JLabel labelValorTroco;
    private javax.swing.JLabel labelVendedor;
    private javax.swing.JLayeredPane lydBotao;
    private javax.swing.JLayeredPane lydCabecalhoVenda;
    private javax.swing.JLayeredPane lydLancamentos;
    private javax.swing.JLayeredPane lydPrazo;
    private javax.swing.JLayeredPane lydResumoVenda;
    private javax.swing.JLayeredPane lydRodape;
    private javax.swing.JPanel panelFaixa;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTable tabelaParcelas;
    // End of variables declaration//GEN-END:variables

    private void fechar() {

        String[] opcoes = {"Sim", "Não"};
        Integer escolha = JOptionPane.showOptionDialog(this, "Confirma o fechamento da venda?", Constantes.PERGUNTA_SISTEMA, JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
        if (escolha != 0) {
            return;
        }

        if (valorPago < valorTotal) {
            JOptionPane.showMessageDialog(this, "Valor pago NÃO é insuficiente para efetivar a venda. Verifique!", Constantes.AVISO_SISTEMA, JOptionPane.INFORMATION_MESSAGE);
            ftfValorPago.requestFocus();
            return;
        }

        if (listaParcelamentosBean != null && listaParcelamentosBean.size() > 0) {
            Double totalParcelas = 0.0;
            for (ParcelamentosBean o : listaParcelamentosBean) {
                totalParcelas += o.getValorParcelas();
            }

            if (!totalParcelas.equals(valorTotal)) {
                JOptionPane.showMessageDialog(this, "Soma das parcelas não corresponde ao valor da venda. Verifique!", Constantes.AVISO_SISTEMA, JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        //Se verifica o limite de crédito na venda: (S - Sim / N - Não)
        if (listaFormPagtBean.get(comboFormasPgto.getSelectedIndex()).getTratalim().equalsIgnoreCase("S")) {
            //se for a prazo    
            FormPagtBean o = listaFormPagtBean.get(comboFormasPgto.getSelectedIndex());
            if (o.getQtdparc() > 0) {

                if (Caixa.clienPdvBean == null) {
                    JOptionPane.showMessageDialog(this,
                            "Para Forma de Pagamento selecionada "
                            + "\n é necessario informar o cliente. Verifique!", Constantes.AVISO_SISTEMA, JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if (Caixa.clienPdvBean.getVlrdebito() == null) {
                    Caixa.clienPdvBean.setVlrdebito(0.0);
                }
                if (Caixa.clienPdvBean.getLimitecre() == null) {
                    Caixa.clienPdvBean.setLimitecre(0.0);
                }
                //Limite de Crédito do Cliente
                if ((valorTotal + Caixa.clienPdvBean.getVlrdebito()) > Caixa.clienPdvBean.getLimitecre()) {
                    JOptionPane.showMessageDialog(this,
                            "Limite de crédito de cliente foi atingido. Verifique!"
                            + "\n"
                            + "\n Limite de Credito: R$" + Biblioteca.formatarNumero(Caixa.clienPdvBean.getLimitecre(), "#,###,##0.00")
                            + "\n Outros débitos: R$" + Biblioteca.formatarNumero(Caixa.clienPdvBean.getVlrdebito(), "#,###,##0.00")
                            + "\n Total Venda: R$" + Biblioteca.formatarNumero(valorTotal, "#,###,##0.00")
                            + "\n", Constantes.AVISO_SISTEMA, JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
        } else {
            //Informa se o cliente será obrigatório na venda:
            if (listaFormPagtBean.get(comboFormasPgto.getSelectedIndex()).getClieobrig().equalsIgnoreCase("S")) {
                if (Caixa.clienPdvBean == null || Caixa.clienPdvBean.getClcodigo() == null) {
                    JOptionPane.showMessageDialog(this, "Para essa Forma de Pagamento, infome o cliente na venda. Verifique!", Constantes.AVISO_SISTEMA, JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
        }

        //---------------------------------------------------------------------
        operFiscBean = listaOperFiscBean.get(comboOperacao.getSelectedIndex());

        //caso nao seja venda de delolucao de mercadoria
        emitirCupom = "N";
        if (Caixa.ConfiguracaoBean.getEmitirCupom().equals("1")) {
            if (operFiscBean.getVenda().equalsIgnoreCase("S")) {
                escolha = JOptionPane.showOptionDialog(this, "Deseja emitir cupom fiscal?", Constantes.PERGUNTA_SISTEMA, JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
                if (escolha == 0) {
                    emitirCupom = "S";
                } else {
                    emitirCupom = "N";
                }
            }
        }
        try {
            dataVenda = Biblioteca.stringToDate(2, ftfDataVenda.getText().trim() + " " + ftfHorasVenda.getText().trim() + ":00");
        } catch (ParseException ex) {
            Loggin.logDiarioExcecao(ex, true);
        }

        horasVenda = ftfHorasVenda.getText() + "\n";
        codigoVendedor = listaFuncionaBean.get(comboVendedor.getSelectedIndex()).getFucodigo();

        //****************************************
        //OBSERVACAO DA VENDA
        //****************************************
        tratarObservacao();
        //****************************************

        //lancamentos finaceiros
        lancamentos();
        compoemMvCaipdvBean();
        //gravar venda ---------------       
        cancelouVenda = false;
        dispose();
    }

    //=======================
    private void resumoVenda() {

        valorTotal = valorSubtotal + valorAcrescimo - valorDesconto;

        labelValorSubtotal.setText(Biblioteca.formatarNumero(valorSubtotal, "#,###,##0.00"));
        labelValorAcrescimo.setText(Biblioteca.formatarNumero(valorAcrescimo, "#,###,##0.00"));
        labelValorDesconto.setText(Biblioteca.formatarNumero(valorDesconto, "#,###,##0.00"));
        labelValorTotal.setText(Biblioteca.formatarNumero(valorSubtotal + valorAcrescimo - valorDesconto, "#,###,##0.00"));

        labelValorRecebido.setText(Biblioteca.formatarNumero(valorPago, "#,###,##0.00"));
        if (valorPago - (valorSubtotal + valorAcrescimo - valorDesconto) > 0) {
            labelValorTroco.setText(Biblioteca.formatarNumero(valorPago - (valorSubtotal + valorAcrescimo - valorDesconto), "#,###,##0.00"));
        } else {
            labelValorTroco.setText("0,00");
        }
    }

    //=======================
    private void cancelar() {

        cancelouVenda = true;
        dispose();
    }

    private void lancamentos() {

        if (listaParcelamentosBean == null || listaParcelamentosBean.isEmpty()) {
            botaoFecharVenda.setEnabled(false);
            return;
        } else {
            botaoFecharVenda.setEnabled(true);
        }

        for (ParcelamentosBean o : listaParcelamentosBean) {

            //dataembo
            //juros
            //MOCODIGO
            //CLCODIGO
            //VECODIGO
            //EMCODIGO
            //USCODIGO
            //NOSSONUMERO
            //===============================
            lancamenBean = new LancamenBean();
            lancamenBean.setAgencia("");
            lancamenBean.setLacodigo(0); //3 LACODIGO N 12 Còdigo do lancamento 14 25
            lancamenBean.setCocodigo(""); 	//1 COCODIGO C 3 Código da Conta 1 3
            lancamenBean.setCecodigo(""); //11 CECODIGO C 2 Centro de Custo 120 121
            lancamenBean.setPlcodigo(Caixa.ConfiguracaoBean.getPlanoContas()); //2 PLCODIGO C 10 Código do Plano de Contas 4 13
            lancamenBean.setTipo(listaOperFiscBean.get(comboOperacao.getSelectedIndex()).getVenda().equalsIgnoreCase("N") ? "D" : "C"); //13 TIPO C 1 Tipo do lançamento (D-Débito ou C-Credito) 203 203
            lancamenBean.setDatalanc(o.getEmissao()); //5 DATALANC D 8 Data de Lançamento 32 39 
            lancamenBean.setDatavenc(o.getVencimento()); //6 DATAVENC D 8 Data de Vencimento 40 47	
            lancamenBean.setDataembo(null); //boleto
            lancamenBean.setValorant(0.0); //7 VALORANT N 16 2 Valor Original do Lançamento 48 63
            lancamenBean.setMoedaant("");
            lancamenBean.setMulta(0.0); //9 MULTA N 16 2 Multa 88 103
            lancamenBean.setJuros(0.0);
            lancamenBean.setDesconto(0.0); //18 DESCONTO N 16 2 Desconto 249 264
            lancamenBean.setValor(o.getValorParcelas()); //10 VALOR N 16 2 Valor do Lançamento 104 119
            lancamenBean.setMocodigo("");
            lancamenBean.setDataquit(o.getEmissao().compareTo(o.getVencimento()) == 0 ? o.getVencimento() : null); //8 DATAQUIT D 8 Data de Quitação 64 71 
            lancamenBean.setClcodigo(0); 	//4 CLCODIGO N 6 Código do Cliente 26 31 
            lancamenBean.setFocodigo(0); //15 FOCODIGO N 6 Código do Fornecedor 224 229 
            lancamenBean.setNumcheq(""); //17 NUMCHEQ C 8 Numero do Cheque 233 240 
            lancamenBean.setNumdupl(o.getDocumentos()); //19 NUMDUPL C 20 Numero da Duplicata 265 284
            lancamenBean.setModelonf(""); //26 MODELONF C 3 Modelo da Nota fiscal 510 512
            lancamenBean.setSubserienf("");
            lancamenBean.setNumeronf(0); //21 NUMERONF N 8 Serie da Nota 345 352
            lancamenBean.setSerienf(""); //27 SUBSERIENF C 3 SubSerie da Nota fiscal 513 515
            lancamenBean.setVecodigo(0);
            lancamenBean.setObs("Venda feita pelo X2");  //12 OBS C 80 Observação 123 202
            lancamenBean.setEmcodigo(0);
            lancamenBean.setUscodigo("");
            lancamenBean.setFucodigo(listaFuncionaBean.get(comboVendedor.getSelectedIndex()).getFucodigo()); //25 FUCODIGO N 5 Código do Funcionário 505 509
            lancamenBean.setPeriodo(0);
            lancamenBean.setCacodigo(Caixa.ConfiguracaoBean.getNumeroCaixa());
            lancamenBean.setCodinteg("");
            lancamenBean.setDccodigo(0);
            lancamenBean.setNreceb(0);
            lancamenBean.setNdetcaix(0);
            lancamenBean.setApcodigo(0);
            lancamenBean.setVdcodigo(0); //14 VDCODIGO N 8 216 223
            lancamenBean.setBacodigo(""); //16 BACODIGO C 3 230 232
            lancamenBean.setAgencia("");
            lancamenBean.setNumconta("");
            lancamenBean.setNossonumero(0); //24 NOSSONUMERO N 8 Código interno do lançamento 494 501
            lancamenBean.setCccodigo(0); //23 CCCODIGO N 10 375 384
            lancamenBean.setNumerocoo(0);
            lancamenBean.setDatavenda(dataVenda); //20 DATAVENDA D 8 AAAAMMDD 285 292 
            lancamenBean.setEcfserie(""); //22 SERIENF  C 3 Numero da Nota 353 355 
            lancamenBean.setCnccodigo(0);
            lancamenBean.setTipoconciliacao("");
            lancamenBean.setValororiginal(0.0);
            lancamenBean.setDescontooriginal(0.0);
            lancamenBean.setTxexpedi("");
            lancamenBean.setStatusconc("");
            lancamenBean.setMvcdata(new java.util.Date());
            lancamenBean.setMvcperiodo(0);
            lancamenBean.setMvctipo("");
            lancamenBean.setMvcfpcodigo(0);
            lancamenBean.setMvcseqespec(0);
            lancamenBean.setLcasequencia(0);
            listaLancamenBean.add(lancamenBean);
        }
    }

    private void compoemMvCaipdvBean() {

        MvCaipdvBean mvCaipdvBean;
        Integer contador = 0;
        for (ParcelamentosBean o : listaParcelamentosBean) {
 
            mvCaipdvBean = new MvCaipdvBean();
            //******************************************************
            //3  Movimentação da Venda: (Tabela-MVCAIPDV / MVPREPDV)    
            //******************************************************
            //15 SETOR C 30 Setor 92 121
            //6 CODESPEC N 8 Código da espécie de pagamento (**) 23 30        
            //17 ESPECIE C 15 Nome da Espécie de pagamento (Dinheiro; Cartão, Cheque ou Vale) 128 142        
            //63 Resevado C 32 Reservado 744 775  64 PAFHASHVER C 10 Versao do PAFECF 776 785        
            //73 Autorizador C 30 Autorizador da Transação (Vide tabela Tefs ) 861 890 
            //76 TipoFinanciamento C 20 Tipo Financeamento (Vide tabela Tefs )931 950 
            mvCaipdvBean.setCacodigo(ConfiguracaoBean.getNumeroCaixa());//1 CACODIGO C 3 Código do caixa 1 3
            mvCaipdvBean.setData(new java.util.Date());//2 DATA D 8 Data da movimentação (ddmmaaaa) 4 11
            mvCaipdvBean.setPeriodo(0);//3 PERIODO N 2 Período da movimentação 12 13
            mvCaipdvBean.setTipo("V");//4 TIPO C 1 Tipo da movimentação (*) 14 14
            mvCaipdvBean.setVdcodigo(proximoIdVendaPdvBean);//5 VDCODIGO N 8 Código da venda 15 22
            mvCaipdvBean.setFpcodigo(Integer.valueOf(listaFormPagtBean.get(comboFormasPgto.getSelectedIndex()).getFpcodigo()));//16 FPCODIGO C 6 Código da Forma de Pagamento 122 127
            mvCaipdvBean.setSeqespec(++contador);
            mvCaipdvBean.setEsppgecf(o.getDescricaoMeioPgto());
            mvCaipdvBean.setLacodigo(0);//7 LACODIGO N 8 Código do lançamento 31 38 
            mvCaipdvBean.setFucodigo(listaFuncionaBean.get(comboVendedor.getSelectedIndex()).getFucodigo()); //25 FUCODIGO N 5 Código do Funcionário 505 509
            mvCaipdvBean.setPlcodigo("");//9 PLCODIGO C 10 Código do plano de contas 45 54
            mvCaipdvBean.setValor(o.getValorParcelas());//10 VALOR N 10 2 Valor da movimentação 55 64 
            // 'Q' - PARCELA QUITADA  ' ‘ - PARCELA EM ABERTO
            mvCaipdvBean.setFormpgto(o.getEmissao().compareTo(o.getVencimento()) == 0 ? "Q" : " ");//11 FORMPAGTO C 8 Código da forma de pagamento (***) 65 72 
            mvCaipdvBean.setNumparce(listaFormPagtBean.get(comboFormasPgto.getSelectedIndex()).getQtdparc());//12 NUMPARCE N  3 Numero de parcelas fixas digitadas pelo usuário 73 75
            mvCaipdvBean.setDatacomp(dataVenda);//13 DATACOMP D 8 Data que foi registrada a movimentação (ddmmaaaa) 76 83
            mvCaipdvBean.setHoracomp(horasVenda);//14 HORACOMP A 8 Hora que foi registrada a movimentação 84 91        
            mvCaipdvBean.setSetoruso(Caixa.ConfiguracaoBean.getSetorUso());
            mvCaipdvBean.setDtcodigo(0);//68 DTCODIGO C 8 Chave da Transtef 836 843 
            mvCaipdvBean.setAutoritransacao("");
            mvCaipdvBean.setBandeira("");//74 Bandeira C 20 Bandeira da transação (Vide tabela Tefs ) 891 910 
            mvCaipdvBean.setTipopagamento(o.getDescricaoMeioPgto());//75 TipoPagamento C 20 Tipo do Pagamento (Vide tabela Tefs ) 911 930
            mvCaipdvBean.setTipofinanciamen("");
            mvCaipdvBean.setTefservidor("");//65 TefServidor C 10 Nome Aplicação TEF 786 795  
            mvCaipdvBean.setTefvlrtrefet(0.0);//26 TefVlrTrEfet N 16 2 Valor da transação 251 266 
            mvCaipdvBean.setTefvlrtrefea(0.0);//27 TefVlrTrEfeA N 16 2 Dados de transação TEF 267 282 
            mvCaipdvBean.setTefidentific("");//28 TefIdentific C  10 Dados de transação TEF 283 292
            mvCaipdvBean.setTefdadosfina("");//29 TefDadosFina C 30 Dados de transação TEF 293 322 
            mvCaipdvBean.setTefredeautor("");//30 TefRedeAutor C 8 Instituição que processou a operação 323 330
            mvCaipdvBean.setTeftiptrrede("");//31 TefTipTrRede C 5 Contém um indice que indica qual o tipo de cartão 331 335
            mvCaipdvBean.setTefnutrannsu("");//32 TefNuTranNSU C 15 Contém o NSU da Transação 336 350 
            mvCaipdvBean.setTefcodauttra("");//33 TefCodAutTra C 15 Código de autorização para as tranações de credito 351 365
            mvCaipdvBean.setTeftxvlrtran("");//34 TefTxVlrTran C 20 Dados de transação TEF 366 385     
            mvCaipdvBean.setTefdatatrans("");//35 TefDataTrans C 8 Data da transação 386 393 
            mvCaipdvBean.setTefhoratrans("");//36 TefHoraTrans C 6 Hora da transação 394 399 
            mvCaipdvBean.setTefcodmodpgt("");//37 TefCodModPgt C 10 Contém a modalidade de pagamento no formato XXNN no qual XX corresponde ao grupo da modalidade e NN ao subgrupo. 400 409
            mvCaipdvBean.setTeftxmodapgt("");//38 TefTxModaPgt C 30 Contém o texto descritivo da modalidade de pagamento que deve ser impresso no cupom fiscal 410 439 
            mvCaipdvBean.setTeftxmopgcup("");//39 TefTxMoPgCup C 20 Contém o texto descritivo da modalidade de pagamento que pode ser impresso no cupom fiscal(Ex. TEF) 440 459 
            mvCaipdvBean.setTefnsusitef("");//40 TefNSUSiTef C 15 Contém o NSU do SITEF 460 474 41 TefBimCartao C 10 Contém o as 6 primeiras posições do cartão 475 484 
            mvCaipdvBean.setTefbimcartao("");
            mvCaipdvBean.setTefnuparcela("");//42 TefNuParcela C 10 Contém o Numero de Parcela em venda parcelada 485 494
            mvCaipdvBean.setTefdtpredata("");//43 TefDtPreData C 8 Dados de transação TEF 495 502 
            mvCaipdvBean.setTefnomeopcel("");//44 TefNomeOpCel C 30 Nome da operadora de celular selecionada para a operação 503 532
            mvCaipdvBean.setTefvlrrecarg("");//45 TefVlrRecarg C 20 Valor selecionado para a recarga 533 552 
            mvCaipdvBean.setTefdddnumcel("");//46 TefDDDNumCel C 20 DDD + numero do celular a ser recarregado 553 572 
            mvCaipdvBean.setTefdigiverif("");//47 TefDigiVerif C 20 Digito verificadores 573 592 
            mvCaipdvBean.setTefceplteope("");//48 TefCepLTeOpe C 10 Cep da localidade onde esta o terminal no qual a operação esta sendo feita 593 602 
            mvCaipdvBean.setTefnsustprca("");//49 TefNsuSTPRCa C 20 Dados de transação TEF 603 622 
            mvCaipdvBean.setTefnsuhatprc("");//50 TefNsuHATPRC C 20 Dados de transação TEF 623 642 
            mvCaipdvBean.setTefcofiatrce("");//51 TefCoFiAtRCe C 20 Dados de transação TEF 643 662 
            mvCaipdvBean.setTefnumparcel("");//52 TefNumParCel C 10 Contém o numero de parcelas em venda parcelada 663 672 
            mvCaipdvBean.setTefnumterlog("");//66 TefNumTerLog C 20 Numero Logico 796 815 
            mvCaipdvBean.setTefcodafilia("");//67 TefCodAfilia C 20 Codigo da Filiacao 816 835
            mvCaipdvBean.setFlagtrans("");
            mvCaipdvBean.setFlagtserv("");
            mvCaipdvBean.setEcfseque("");//18 ECFSEQUE C 4 Sequencial do Caixa na loja 143 146
            mvCaipdvBean.setEcfserie("");//19 ECFSERIE C 20 Numero de serie da ECF 147 166 
            mvCaipdvBean.setEcfmarca("X2");//20 ECFMARCA C 25 Marca da ECF 167 191 
            mvCaipdvBean.setEcfmodelo("");//21 ECFMODELO C 25 Modelo da Ecf 192 216 
            mvCaipdvBean.setEcftipo("");//22 ECFTIPO C 15 Tipo da ECF 217 231 
            mvCaipdvBean.setSwbversao("");//23 SWBVERSAO C  10 Versão do Soft. Básico da ECF 232 241 
            mvCaipdvBean.setSwbdthrgr(new java.util.Date());//24 SWBDTHRGR D 8 Data Versão do Soft. Básico da ECF 242 249 
            mvCaipdvBean.setSwbmfadic("");//25 SWBMFADIC C 1 MFD adicional 250 250 
            mvCaipdvBean.setCoo(0);//53 COO N 8 Numero Coo 673 680  
            mvCaipdvBean.setGnf(0);//54 GNF N 8 Numero Comprovante não fiscal 681 688 
            mvCaipdvBean.setCcf(0);//55 CCF N 8 Numero Cupom 689 696 
            mvCaipdvBean.setGrg(0);//56 GRG N 8 Numero Relatório Gerencial 697 704 
            mvCaipdvBean.setCer(0);//57 CER N 8 Numero Espefico Relatório 705 712
            mvCaipdvBean.setTpvendcart("");//58 TPVENDCART C 1 Tipo de venda Cartão 713 713 
            mvCaipdvBean.setCadevoluc("");//59 CADEVOLUC C 3 Caixa que efetuou devolução 714 716  
            mvCaipdvBean.setDvcodigo(0);//60 DVCODIGO N 8 Código da devolução 717 724
            mvCaipdvBean.setOrigem("MOVIM");//61 ORIGEM C 5 Origem da Venda 725 729 
            mvCaipdvBean.setPafhashver("");
            mvCaipdvBean.setPafhashdet("");
            mvCaipdvBean.setDatadamov(new java.util.Date());//62 DATADAMOV C 14 Data da movimentação da ecf 730 743 
            mvCaipdvBean.setModelonf("");//69 MODELONF C 2 Modelo da Nota Fiscal 844 845
            mvCaipdvBean.setSerienf("");//70 SERIENF C 3 Série da Nota Fiscal 846 848 
            mvCaipdvBean.setSubserienf("");//71 SUBSERIENF C 3 Sub-série da Nota Fiscal 849 851 
            mvCaipdvBean.setNumeronf(0);//72 NUMERONF C 9 Número da Nota Fiscal 852 860 
            mvCaipdvBean.setFlagfinan("");
            listaMvCaipdvBean.add(mvCaipdvBean);
        }
    }

    //===================================================================================================
    private void CalcularParcelas() throws SQLException, ClassNotFoundException, IOException, Exception {

        int numeroParcelas = listaFormPagtBean.get(comboFormasPgto.getSelectedIndex()).getQtdparc();

        BigDecimal entrada = new BigDecimal(0);
        entrada = entrada.add(BigDecimal.valueOf(Biblioteca.removerMascara(ftfEntradas)));

        if (numeroParcelas <= 0) {
            JOptionPane.showMessageDialog(rootPane, "Quantidade de parcelas informada não é válido. Verifique!", Constantes.AVISO_SISTEMA, JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (entrada.doubleValue() >= valorTotal) {
            JOptionPane.showMessageDialog(rootPane,
                    "Valor da \"Entrada\" deve ser inferior ao \"Valor da Venda\"."
                    + "\n"
                    + "\nValor da Entrada: " + Biblioteca.formatarNumero(entrada.doubleValue(), "#,###,##0.00")
                    + "\nValor da Venda..:" + Biblioteca.formatarNumero(valorTotal, "#,###,##0.00")
                    + "\n"
                    + "\n", Constantes.AVISO_SISTEMA, JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (((valorTotal - entrada.doubleValue()) / numeroParcelas) < 0.01) {
            JOptionPane.showMessageDialog(rootPane, ""
                    + "Valores das parcelas ficará abaixo de R$ 0,01 centavo para "
                    + "\n o número de parcelas informado. Verifique!", Constantes.AVISO_SISTEMA, JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));

        //---------------------------------------------------------------------
        ftfEntradas.setEnabled(false);
        botaoCalcularParcelas.setEnabled(false);

        listaParcelamentosBean = new ArrayList<ParcelamentosBean>();
        ParcelamentosBean auxiliar;

        //achar  arredondamento
        BigDecimal arredondamento = new BigDecimal(0);
        BigDecimal parcelas = new BigDecimal(0);

        if (entrada.doubleValue() > 0) {

            double resultado = Biblioteca.truncar(((valorTotal - entrada.doubleValue()) / (numeroParcelas - 1)), 2);

            parcelas = parcelas.add(BigDecimal.valueOf(resultado));

            //se a venda for R$ 10,00 divido em 3 parcelas o resultado será 3x R$ 3,33. O R$ 0,01 que sobra, coloco na ultima parcela
            arredondamento = arredondamento.add(BigDecimal.valueOf(valorTotal - entrada.doubleValue() - (parcelas.doubleValue() * (numeroParcelas - 1))));

        } else {

            parcelas = parcelas.add(BigDecimal.valueOf(Biblioteca.truncar(valorTotal / numeroParcelas, 2)));

            //se a venda for R$ 10,00 divido em 3 parcelas o resultado será 3x R$ 3,33. O R$ 0,01 que sobra, coloco na ultima parcela
            arredondamento = arredondamento.add(BigDecimal.valueOf(valorTotal - (parcelas.doubleValue() * numeroParcelas)));
        }

        String documento;

        Calendar hoje = Calendar.getInstance();
        hoje.setTime(new java.util.Date());
        //---------------------------------------------------------------------
        for (int i = 0; i < numeroParcelas; ++i) {

            auxiliar = new ParcelamentosBean();
            documento = Biblioteca.strzero(proximoIdVendaPdvBean, 6) + "-" + Biblioteca.strzero(i + 1, 2) + "/" + Biblioteca.strzero(numeroParcelas, 2);   //000004-01/01

            auxiliar.setDocumentos(documento);

            if (i == (numeroParcelas - 1)) { //arredontamento para ultima parcela
                auxiliar.setValorParcelas(parcelas.doubleValue() + arredondamento.doubleValue());
            } else {

                if (i == 0 && entrada.doubleValue() > 0) {

                    auxiliar.setValorParcelas(entrada.doubleValue());

                } else {

                    auxiliar.setValorParcelas(parcelas.doubleValue());
                }
            }

            auxiliar.setEmissao(new java.util.Date());

            //incrementar 30 dia a cada vencimento: hoje + (30 * i) dias
            hoje.add(Calendar.DAY_OF_MONTH, listaFormPagtBean.get(comboFormasPgto.getSelectedIndex()).getParcfPgtBeanVO().get(i).getDiaslanca());
            auxiliar.setVencimento(hoje.getTime());
            auxiliar.setCodigoMeioPgto(Integer.valueOf(array[comboMeiosPgto.getSelectedIndex()][0]));
            auxiliar.setDescricaoMeioPgto(array[comboMeiosPgto.getSelectedIndex()][1]);
            listaParcelamentosBean.add(auxiliar);
        }

        //-----------------------------------------------------
        atualizarTabela(listaParcelamentosBean);
        valorPago = valorTotal;
        resumoVenda();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }

    //=============================
    private void formatarTabela() {

        // Biblioteca.preencherGrade(tableUsuarios, b);
        // seta o modo de auto-redimensionamento como desligado
        // jTableSelecionaItens.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
        // refaz o layout
        // doLayout();
        // ajuste largura das colunas
        tabelaParcelas.getColumnModel().getColumn(0).setMinWidth(120);
        tabelaParcelas.getColumnModel().getColumn(1).setMinWidth(100);
        tabelaParcelas.getColumnModel().getColumn(2).setPreferredWidth(280);

        //ajuste conteudo na celula
        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();

        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centralizado.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);

        tabelaParcelas.getColumnModel().getColumn(0).setCellRenderer(centralizado);
        tabelaParcelas.getColumnModel().getColumn(1).setCellRenderer(direita);
        tabelaParcelas.getColumnModel().getColumn(2).setCellRenderer(esquerda);
        tabelaParcelas.setFont(new java.awt.Font("Verdana", 0, 15));

        tabelaParcelas.setEnabled(true);

        //validar celulas
        MaskFormatter msk = null, msk2 = null;
        try {
            msk = new MaskFormatter("##/##/####");
            //msk.setPlaceholder("_");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro na criação de máscara no JTable.", Constantes.AVISO_SISTEMA, JOptionPane.INFORMATION_MESSAGE);
        }

        JFormattedTextField jftf = new JFormattedTextField(msk);
        tabelaParcelas.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(jftf));

        //tabelaParcelas.setAutoCreateRowSorter(true); //ORDENA AS COLUNAS DE UMA TABELA
    }

    //===================================================================================
    private void atualizarTabela(List<ParcelamentosBean> listaParcelamentosAuxliarBean) {

        ((DefaultTableModel) tabelaParcelas.getModel()).setRowCount(0);

        if (listaParcelamentosBean != null && listaParcelamentosBean.size() > 0) {

            for (ParcelamentosBean o : listaParcelamentosAuxliarBean) {

                Object[] linha = {
                    Biblioteca.dateToString(1, o.getVencimento()),
                    Biblioteca.formatarNumero(o.getValorParcelas(), "###,##0.00"),
                    o.getDescricaoMeioPgto()
                };

                ((DefaultTableModel) tabelaParcelas.getModel()).addRow(linha);
            }

            //tabelaParcelas.requestFocus();
            //tabelaParcelas.setRowSelectionInterval(0, 0); //da pau quando vazia
        } else {

            //botaoApagar.setEnabled(false);
            //botaoCalcularParcelas.setEnabled(true);
            //botaoFecharVenda.setEnabled(false);
            //botaoCalcularParcelas.requestFocus();
        }
    }

    private void deletarParcela() {

        if (tabelaParcelas.getSelectedRow() >= 0) {

            ParcelamentosBean aux = listaParcelamentosBean.get(tabelaParcelas.getSelectedRow());

            valorPago = valorPago - aux.getValorParcelas();
            listaParcelamentosBean.remove(aux);
            atualizarTabela(listaParcelamentosBean);

            if (listaParcelamentosBean.isEmpty()) {
                valorPago = 0.0;
            }
            resumoVenda();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma parcela para deletar.", Constantes.AVISO_SISTEMA, JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void tratarObservacao() {

        //****************************************
        //OBSERVACAO DA VENDA
        //****************************************
        for (int i = 0; i < 8; i++) {
            observacaoVenda[i] = ""; //limpar
        }
        int j = 0;
        String token;
        String obs = jTextPane1.getText();

        StringTokenizer st = new StringTokenizer(obs, "\r\n"); //quebra de linha, inicio de linha
        while (st.hasMoreTokens()) {

            if (j == 8) {
                break;
            }

            token = st.nextToken();

            if (token != null) {

                if (token.length() > 40) {
                    observacaoVenda[j] = token.substring(0, 39);
                } else {
                    observacaoVenda[j] = token;
                }
                ++j;
            }
        }
    }

    private void calcularDesconto() throws ClassNotFoundException, IOException, Exception {
        //desconto calculado automatico, com base na tabela de desconto por cliente.
        if (Caixa.clienPdvBean != null && Caixa.clienPdvBean.getClcodigo() > 0) {

            Double percDesc;
            for (ItemVpdvBean o : Caixa.listaItens) {
                percDesc = controle.perDescontoCliente(o.getMfcodigo(), Caixa.clienPdvBean.getClcodigo());
                valorDesconto += o.getValitem() * percDesc / 100;
            }

            if (valorDesconto > 0) {
                ftfDesconto.setText(Biblioteca.formatarNumero(valorDesconto, "#,###,##0.00"));
                ftfDesconto.setEnabled(false);
            }
        }
    }

    private void ConsultarClientes() {

        ConsultarClientes consultarClientes = new ConsultarClientes(new JFrame(), true);
        consultarClientes.setResizable(false);
        consultarClientes.setModal(true);
        consultarClientes.setVisible(true);

        Caixa.clienPdvBean = consultarClientes.getMaterPdvBean();

    }

    //================================================
    class DelAction extends AbstractAction {

        public DelAction() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            deletarParcela();
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
            fechar();
        }

    }

    //***************************************************************************
    private class F5Action extends AbstractAction {

        public F5Action() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            cancelar();
        }

    }

    class ParcelamentosBean {

        private String Documentos;
        private double ValorParcelas;
        private java.util.Date Emissao;
        private java.util.Date Vencimento;
        private Integer codigoMeioPgto;
        private String descricaoMeioPgto;

        public Date getEmissao() {
            return Emissao;
        }

        public void setEmissao(Date Emissao) {
            this.Emissao = Emissao;
        }

        public String getDocumentos() {
            return Documentos;
        }

        public void setDocumentos(String Documentos) {
            this.Documentos = Documentos;
        }

        public double getValorParcelas() {
            return ValorParcelas;
        }

        public void setValorParcelas(double ValorParcelas) {
            this.ValorParcelas = ValorParcelas;
        }

        public Date getVencimento() {
            return Vencimento;
        }

        public void setVencimento(Date Vencimento) {
            this.Vencimento = Vencimento;
        }

        public void limparAtributos(ParcelamentosBean parcelamentosBean) {

            if (parcelamentosBean == null) {
                return;
            }

            parcelamentosBean.setDocumentos("");
            parcelamentosBean.setValorParcelas(0.0);
            parcelamentosBean.setEmissao(null);
            parcelamentosBean.setVencimento(null);
            parcelamentosBean.setCodigoMeioPgto(0);
            parcelamentosBean.setDescricaoMeioPgto("");

        }

        /**
         * @return the codigoMeioPgto
         */
        public Integer getCodigoMeioPgto() {
            return codigoMeioPgto;
        }

        /**
         * @param codigoMeioPgto the codigoMeioPgto to set
         */
        public void setCodigoMeioPgto(Integer codigoMeioPgto) {
            this.codigoMeioPgto = codigoMeioPgto;
        }

        /**
         * @return the descricaoMeioPgto
         */
        public String getDescricaoMeioPgto() {
            return descricaoMeioPgto;
        }

        /**
         * @param descricaoMeioPgto the descricaoMeioPgto to set
         */
        public void setDescricaoMeioPgto(String descricaoMeioPgto) {
            this.descricaoMeioPgto = descricaoMeioPgto;
        }
    }

}
