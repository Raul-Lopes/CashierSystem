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
import br.com.modelo.ParcfPgtBean;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author raul
 */
public class FecharOrcamento extends javax.swing.JDialog {

    private final Controle controle = new Controle();

    private List<FuncionaBean> listaFuncionaBean = new ArrayList<FuncionaBean>();
    private List<FormPagtBean> listaFormPagtBean = new ArrayList<FormPagtBean>();
    private List<ParcfPgtBean> listaParcfPgtBean = new ArrayList<ParcfPgtBean>();
    private Double valorSubtotal, valorTotal, valorDesconto, valorAcrescimo, valorPago;
    private String horasVenda, orcamentFormaPgto;
    private Date dataVenda, orcamentDataValid;
    private Integer codigoVendedor;
    private String[] observacaoVenda = new String[8];
    private Boolean cancelouVenda;

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

    public Boolean getCancelouVenda() {
        return cancelouVenda;
    }

    public String getOrcamentFormaPgto() {
        return orcamentFormaPgto;
    }

    public Date getOrcamentDataValid() {
        return orcamentDataValid;
    }

    /**
     * Creates new form Fechar
     */
    public FecharOrcamento(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        ImageIcon icone = new javax.swing.ImageIcon(Constantes.SH_ICONE);
        setIconImage(icone.getImage());
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

        valorSubtotal = 0.0;
        valorTotal = 0.0;
        valorDesconto = 0.0;
        valorAcrescimo = 0.0;
        valorPago = 0.0;

        //----------------------
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
            //comboVendedor.setEnabled(false);
            for (int i = 0; i < listaFuncionaBean.size(); ++i) {
                if (listaFuncionaBean.get(i).getFucodigo().equals(Caixa.funcionaBean.getFucodigo())) {
                    comboVendedor.setSelectedIndex(i);
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
        labelFormasPgto = new javax.swing.JLabel();
        comboFormasPgto = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        ftfValorPago = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
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
        setMinimumSize(new java.awt.Dimension(1024, 450));
        setPreferredSize(new java.awt.Dimension(1024, 450));
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
        jLabel8.setText("Fechamento Orçamento");
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
        lydCabecalhoVenda.setMinimumSize(new java.awt.Dimension(1015, 180));
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
        ftfCliente.setMinimumSize(new java.awt.Dimension(300, 35));
        ftfCliente.setPreferredSize(new java.awt.Dimension(300, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        lydCabecalhoVenda.add(ftfCliente, gridBagConstraints);

        comboVendedor.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        comboVendedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboVendedor.setMinimumSize(new java.awt.Dimension(300, 35));
        comboVendedor.setPreferredSize(new java.awt.Dimension(300, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        lydCabecalhoVenda.add(comboVendedor, gridBagConstraints);

        ftfAcrescimo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        ftfAcrescimo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ftfAcrescimo.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        ftfAcrescimo.setMinimumSize(new java.awt.Dimension(120, 35));
        ftfAcrescimo.setPreferredSize(new java.awt.Dimension(120, 35));
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
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        lydCabecalhoVenda.add(ftfAcrescimo, gridBagConstraints);

        ftfDesconto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        ftfDesconto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ftfDesconto.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        ftfDesconto.setMinimumSize(new java.awt.Dimension(120, 35));
        ftfDesconto.setPreferredSize(new java.awt.Dimension(120, 35));
        ftfDesconto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ftfDescontoKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        lydCabecalhoVenda.add(ftfDesconto, gridBagConstraints);

        ftfDataVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        ftfDataVenda.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        ftfDataVenda.setMinimumSize(new java.awt.Dimension(200, 35));
        ftfDataVenda.setPreferredSize(new java.awt.Dimension(200, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        lydCabecalhoVenda.add(ftfDataVenda, gridBagConstraints);

        ftfHorasVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        ftfHorasVenda.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        ftfHorasVenda.setMinimumSize(new java.awt.Dimension(200, 35));
        ftfHorasVenda.setPreferredSize(new java.awt.Dimension(200, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        lydCabecalhoVenda.add(ftfHorasVenda, gridBagConstraints);

        botaoSelecionarCliente.setText("...");
        botaoSelecionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSelecionarClienteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 5, 1);
        lydCabecalhoVenda.add(botaoSelecionarCliente, gridBagConstraints);

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
        comboFormasPgto.setMinimumSize(new java.awt.Dimension(56, 35));
        comboFormasPgto.setPreferredSize(new java.awt.Dimension(56, 35));
        comboFormasPgto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboFormasPgtoItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        lydCabecalhoVenda.add(comboFormasPgto, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel4.setText("Vr. Pago:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        lydCabecalhoVenda.add(jLabel4, gridBagConstraints);

        ftfValorPago.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        ftfValorPago.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ftfValorPago.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        ftfValorPago.setMinimumSize(new java.awt.Dimension(120, 35));
        ftfValorPago.setPreferredSize(new java.awt.Dimension(120, 35));
        ftfValorPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ftfValorPagoKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        lydCabecalhoVenda.add(ftfValorPago, gridBagConstraints);

        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Enter para sair do campo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        lydCabecalhoVenda.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(1, 1, 1, 1);
        panelPrincipal.add(lydCabecalhoVenda, gridBagConstraints);

        lydRodape.setMinimumSize(new java.awt.Dimension(1015, 160));
        lydRodape.setPreferredSize(new java.awt.Dimension(1014, 153));
        lydRodape.setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Observação:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextPane1.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jScrollPane1.setViewportView(jTextPane1);

        jPanel1.add(jScrollPane1);

        lydRodape.add(jPanel1);

        lydResumoVenda.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resumo do Orçamento:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N
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

        lydBotao.setMinimumSize(new java.awt.Dimension(1015, 50));
        lydBotao.setName(""); // NOI18N
        lydBotao.setPreferredSize(new java.awt.Dimension(1014, 49));
        lydBotao.setLayout(new java.awt.GridBagLayout());

        botaoCancelar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
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

        botaoFecharVenda.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        botaoFecharVenda.setText("Fechar Orçamento (F4)");
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

            valorPago = Double.valueOf(ftfValorPago.getText().replace(".", "").replace(",", "."));

            resumoVenda();

            if (valorPago >= valorTotal) {
                JOptionPane.showMessageDialog(this, "Valores lançados são suficiente para fechar a venda.", Constantes.AVISO_SISTEMA, JOptionPane.INFORMATION_MESSAGE);
                botaoFecharVenda.requestFocus();
            }
        }
    }//GEN-LAST:event_ftfValorPagoKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        //-------------------------------
        resumoVenda();

        ftfValorPago.setText(Biblioteca.formatarNumero(valorTotal, "#,###,##0.00"));

    }//GEN-LAST:event_formWindowOpened

    private void comboFormasPgtoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboFormasPgtoItemStateChanged

        valorPago = 0.0;

        if (listaFormPagtBean != null) {
            FormPagtBean o = listaFormPagtBean.get(comboFormasPgto.getSelectedIndex());
            if (o.getQtdparc() > 0) {

                if ((o.getDiasentra() != null && o.getDiasentra() > 0)) {
                    ftfValorPago.setText(Biblioteca.formatarNumero(valorTotal * o.getPercentra() / 100, "#,###,##0.00")); //Percentual Da Entrada
                }

                //valor pago
                //ftfValorPago.setEnabled(false);
                ftfValorPago.setText(Biblioteca.formatarNumero(valorTotal, "#,###,##0.00"));

            } else { //a vista

                ftfValorPago.setEnabled(true);
                ftfValorPago.requestFocus();
            }

        }
    }//GEN-LAST:event_comboFormasPgtoItemStateChanged

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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FecharOrcamento dialog = new FecharOrcamento(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoFecharVenda;
    private javax.swing.JButton botaoSelecionarCliente;
    private javax.swing.JComboBox comboFormasPgto;
    private javax.swing.JComboBox comboVendedor;
    private javax.swing.JFormattedTextField ftfAcrescimo;
    private javax.swing.JFormattedTextField ftfCliente;
    private javax.swing.JFormattedTextField ftfDataVenda;
    private javax.swing.JFormattedTextField ftfDesconto;
    private javax.swing.JFormattedTextField ftfHorasVenda;
    private javax.swing.JFormattedTextField ftfValorPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel labelAcrescimo;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelDesconto;
    private javax.swing.JLabel labelFormasPgto;
    private javax.swing.JLabel labelHora;
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
    private javax.swing.JLayeredPane lydResumoVenda;
    private javax.swing.JLayeredPane lydRodape;
    private javax.swing.JPanel panelFaixa;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables

    private void fechar() {

        String[] opcoes = {"Sim", "Não"};
        Integer escolha = JOptionPane.showOptionDialog(this, "Confirma o fechamento do orçamento?", Constantes.PERGUNTA_SISTEMA, JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
        if (escolha != 0) {
            return;
        }

        if (ftfDataVenda.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe uma data. Verifique!", Constantes.AVISO_SISTEMA, JOptionPane.INFORMATION_MESSAGE);
            ftfDataVenda.requestFocus();
            return;
        }
        
        if (valorPago < valorTotal) {
            JOptionPane.showMessageDialog(this, "Valor pago NÃO é insuficiente para efetivar o orçamento. Verifique!", Constantes.AVISO_SISTEMA, JOptionPane.INFORMATION_MESSAGE);
            ftfValorPago.requestFocus();
            return;
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
                            + "\n Limite de Crédito: R$" + Biblioteca.formatarNumero(Caixa.clienPdvBean.getLimitecre(), "#,###,##0.00")
                            + "\n Outros débitos: R$" + Biblioteca.formatarNumero(Caixa.clienPdvBean.getVlrdebito(), "#,###,##0.00")
                            + "\n Total Venda: R$" + Biblioteca.formatarNumero(valorTotal, "#,###,##0.00")
                            + "\n", Constantes.AVISO_SISTEMA, JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
        } else {
            //Informa se o cliente será obrigatório na venda:
            if (Caixa.clienPdvBean == null || Caixa.clienPdvBean.getClcodigo() == null) {
                JOptionPane.showMessageDialog(this, "Infome o cliente no orçamento.", Constantes.AVISO_SISTEMA, JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        try {
            dataVenda = Biblioteca.stringToDate(2, ftfDataVenda.getText().trim() + " 00:00:00");
        } catch (Exception ex) {
            Loggin.logDiarioExcecao(ex, true);
        }

        orcamentDataValid = dataVenda;
        horasVenda = ftfHorasVenda.getText();
        codigoVendedor = listaFuncionaBean.get(comboVendedor.getSelectedIndex()).getFucodigo();
        orcamentFormaPgto = listaFormPagtBean.get(comboFormasPgto.getSelectedIndex()).getFpcodigo();

        //****************************************
        //OBSERVACAO DA VENDA
        //****************************************
        tratarObservacao();
        //****************************************

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

        //***************************************************************************
        //desconto calculado automatico, com base na tabela de desconto por cliente.
        //***************************************************************************
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

    //=======================

    private void cancelar() {

        cancelouVenda = true;
        dispose();
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
}
