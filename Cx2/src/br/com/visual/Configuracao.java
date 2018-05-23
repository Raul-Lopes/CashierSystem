/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.visual;

import br.com.controle.Controle;
import br.com.modelo.CaixasBean;
import br.com.modelo.CentCustBean;
import br.com.modelo.PlanContBean;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author raul
 */
public class Configuracao extends javax.swing.JDialog {

    Controle controle = new Controle();
    List<CaixasBean> listaCaixasBean = new ArrayList<>();
    private List<PlanContBean> listaPlanContBean = new ArrayList<>();
    private List<CentCustBean> listaCentCustBean = new ArrayList<>();

    /**
     * Creates new form MovimentacaoVendas
     * @param parent
     */
    public Configuracao(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        try {

            ImageIcon icone = new javax.swing.ImageIcon(Constantes.SH_ICONE);
            setIconImage(icone.getImage());

            DefaultComboBoxModel modeloCombo;

            //configuracao do caixa ---------------------------------------------------------
            listaCaixasBean = controle.listaCaixas();
            modeloCombo = new DefaultComboBoxModel();
            for (CaixasBean o : listaCaixasBean) {
                modeloCombo.addElement(o.getCacodigo() + " - " + o.getNome());
            }

            comboNumeroCx.setModel(modeloCombo);

            for (int i = 0; i < listaCaixasBean.size(); ++i) {
                if (listaCaixasBean.get(i).getCacodigo().equals(Caixa.ConfiguracaoBean.getNumeroCaixa())) {
                    comboNumeroCx.setSelectedIndex(i);
                    break;
                }
            }

            //setor uso ---------------------------------------------------------
            if (Caixa.ConfiguracaoBean.getSetorUso().equalsIgnoreCase("loja")) {
                comboSetorUso.setSelectedIndex(0); //loja    
            } else {
                comboSetorUso.setSelectedIndex(0); //loja
            }

            //configuracao do plano de contas ---------------------------------------------------------
            listaPlanContBean = controle.listaPlanCont();
            modeloCombo = new DefaultComboBoxModel();
            for (PlanContBean o : listaPlanContBean) {
                modeloCombo.addElement(o.getNome());
            }
            comboPlanoContas.setModel(modeloCombo);

            for (int i = 0; i < listaPlanContBean.size(); ++i) {
                if (listaPlanContBean.get(i).getPlcodigo().trim().equalsIgnoreCase(Caixa.ConfiguracaoBean.getPlanoContas())) {
                    comboPlanoContas.setSelectedIndex(i);
                    break;
                }
            }

            //centro de custo-----------------------------------------
            listaCentCustBean = controle.tabelaCentCust();
            modeloCombo = new DefaultComboBoxModel();
            for (CentCustBean o : listaCentCustBean) {
                modeloCombo.addElement(o.getNome());
            }
            comboCentCusto.setModel(modeloCombo);

            for (int i = 0; i < listaCentCustBean.size(); ++i) {
                if (listaCentCustBean.get(i).getCecodigo().trim().equalsIgnoreCase(Caixa.ConfiguracaoBean.getCentCusto())) {
                    comboCentCusto.setSelectedIndex(i);
                    break;
                }
            }

            //emitir cupom fiscal ------------------------------------
            if (Caixa.ConfiguracaoBean.getEmitirCupom() != null) {
                jComboBox1.setSelectedIndex(Integer.valueOf(Caixa.ConfiguracaoBean.getEmitirCupom()));
            }

            //modo impressao da venda ------------------------------------
            if (Caixa.ConfiguracaoBean.getModoImpremeVenda() != null) {
                jComboBox2.setSelectedIndex(Integer.valueOf(Caixa.ConfiguracaoBean.getModoImpremeVenda()));
            }

            //tipo de movimentacao de venda  ------------------------------------
            if (Caixa.ConfiguracaoBean.getTipoMovimento() != null) {
                jComboBox3.setSelectedIndex(Integer.valueOf(Caixa.ConfiguracaoBean.getTipoMovimento()));
            }

            //informar funcionario a cada item lancado --------------------------------------------
            if (Caixa.ConfiguracaoBean.getFuncionarioItem() != null) {
                jComboBox4.setSelectedIndex(Integer.valueOf(Caixa.ConfiguracaoBean.getFuncionarioItem()));
            }

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

        panelPrincipal = new javax.swing.JPanel();
        tdbCabecalho = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        labelNumeroCaixa = new javax.swing.JLabel();
        comboNumeroCx = new javax.swing.JComboBox();
        comboPlanoContas = new javax.swing.JComboBox();
        labelPlanoContas = new javax.swing.JLabel();
        comboSetorUso = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        comboCentCusto = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        panelBotoes = new javax.swing.JPanel();
        botaoSalvar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tdbCabecalho.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Configuração do Sistema", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        jButton4.setText("papel de parede");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        labelNumeroCaixa.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelNumeroCaixa.setText("Número do Caixa:");

        comboNumeroCx.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        comboNumeroCx.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboNumeroCx.setMinimumSize(new java.awt.Dimension(200, 30));
        comboNumeroCx.setPreferredSize(new java.awt.Dimension(200, 30));
        comboNumeroCx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNumeroCxActionPerformed(evt);
            }
        });

        comboPlanoContas.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        comboPlanoContas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        labelPlanoContas.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        labelPlanoContas.setText("Plano Contas:");

        comboSetorUso.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        comboSetorUso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Loja" }));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Setor Uso:");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Emite Cupom no fechamento da venda:");

        jComboBox1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NAO", "SIM" }));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Modo Impressão da Venda/Orcamento:");

        jComboBox2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pré-visualizar venda", "Selecionar impressora", "Enviar para impressora padrão", "Não Imprimir" }));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Centro de Custo:");

        comboCentCusto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        comboCentCusto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("Tipo de Movimentação");

        jComboBox3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Apenas Vendas", "Apenas Orçamentos", "Vendas/Orçamentos" }));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setText("Informar Funconario a cada item?");

        jComboBox4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NAO", "SIM" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel1))
                            .addGap(324, 324, 324))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(labelPlanoContas)
                            .addGap(303, 303, 303)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 979, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelNumeroCaixa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboCentCusto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboPlanoContas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboNumeroCx, 0, 848, Short.MAX_VALUE)
                                    .addComponent(comboSetorUso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboNumeroCx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNumeroCaixa))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(comboSetorUso, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboPlanoContas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPlanoContas))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(comboCentCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addComponent(jLabel5))
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        tdbCabecalho.addTab("Vendas", jPanel1);

        panelBotoes.setPreferredSize(new java.awt.Dimension(0, 40));

        botaoSalvar.setText("Salvar/Sair");
        botaoSalvar.setMaximumSize(new java.awt.Dimension(150, 30));
        botaoSalvar.setMinimumSize(new java.awt.Dimension(150, 30));
        botaoSalvar.setPreferredSize(new java.awt.Dimension(150, 30));
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        botaoCancelar.setText("Cancelar");
        botaoCancelar.setMaximumSize(new java.awt.Dimension(150, 30));
        botaoCancelar.setMinimumSize(new java.awt.Dimension(150, 30));
        botaoCancelar.setPreferredSize(new java.awt.Dimension(150, 30));
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotoesLayout = new javax.swing.GroupLayout(panelBotoes);
        panelBotoes.setLayout(panelBotoesLayout);
        panelBotoesLayout.setHorizontalGroup(
            panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBotoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelBotoesLayout.setVerticalGroup(
            panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tdbCabecalho)
                    .addComponent(panelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, 1016, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tdbCabecalho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed

        Caixa.ConfiguracaoBean.setNumeroCaixa(listaCaixasBean.get(comboNumeroCx.getSelectedIndex()).getCacodigo());
        Caixa.ConfiguracaoBean.setEmitirCupom(jComboBox1.getSelectedIndex() + "");
        Caixa.ConfiguracaoBean.setModoImpremeVenda(jComboBox2.getSelectedIndex() + "");
        Caixa.ConfiguracaoBean.setTipoMovimento(jComboBox3.getSelectedIndex() + "");
        Caixa.ConfiguracaoBean.setFuncionarioItem(jComboBox4.getSelectedIndex() + "");
        Caixa.ConfiguracaoBean.setPlanoContas(listaPlanContBean.get(comboPlanoContas.getSelectedIndex()).getPlcodigo());
        Caixa.ConfiguracaoBean.setCentCusto(listaCentCustBean.get(comboCentCusto.getSelectedIndex()).getCecodigo());

        //Geral.PapelParedeConfig(System.getProperty("user.dir") + System.getProperty("file.separator") + "c.jpg");
        //Caixa.ConfiguracaoBean.setPapelParede("P:\\CX2\\Projeto\\Cx2\\Cx2\\c.jpg");
        try {
            //salvar no arquivo de texto
            controle.salvarConfig(Caixa.ConfiguracaoBean);
        } catch (Exception ex) {
            Loggin.logDiarioExcecao(ex, true);
        }

        dispose();

    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Criação do file chooser.  
        JFileChooser fileChooser = new JFileChooser();
        // Seta o título do diálogo.  
        fileChooser.setDialogTitle("Selecione o arquivo fonte");
        // Define o filtro de seleção.  
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Arquivo imagem (*.jpg)", "jpg"));
        fileChooser.setAcceptAllFileFilterUsed(false);
        // Impede seleções múltiplas.  
        fileChooser.setMultiSelectionEnabled(false);
        //titulo do botao na caixa
        fileChooser.setApproveButtonText("Selecionar");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        // Exibe o diálogo.  
        Integer returnVal = fileChooser.showDialog(panelPrincipal, null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {

            Caixa.ConfiguracaoBean.setPapelParede(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void comboNumeroCxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNumeroCxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboNumeroCxActionPerformed

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
                Configuracao dialog = new Configuracao(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JComboBox comboCentCusto;
    private javax.swing.JComboBox comboNumeroCx;
    private javax.swing.JComboBox comboPlanoContas;
    private javax.swing.JComboBox comboSetorUso;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelNumeroCaixa;
    private javax.swing.JLabel labelPlanoContas;
    private javax.swing.JPanel panelBotoes;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTabbedPane tdbCabecalho;
    // End of variables declaration//GEN-END:variables

    private void cancelar() {
        dispose();
    }
}
