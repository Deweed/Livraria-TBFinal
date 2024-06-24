package view;

import control.ControleCliente;
import control.ControleItemVenda;
import control.ControleProduto;
import control.ControleVenda;
import java.awt.event.ItemEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.Cliente;
import model.bean.ItemVenda;
import model.bean.Produtos;
import model.bean.Venda;

public class Cad_Venda extends javax.swing.JFrame {

    ControleCliente ctrlCli;
    ControleProduto ctrlProd;
    ControleVenda ctrlVenda;
    ArrayList<Produtos> listProd;
    ArrayList<Cliente> listCli;
    
    float preco = (float) 0.0;
    
    Cliente cliSelecionado;
    Venda venda;
    ControleItemVenda ctrlItemVenda;
    ArrayList<ItemVenda> listItemVenda;
    
    DefaultTableModel model;
    public Cad_Venda() {
        initComponents();
        ctrlCli = ControleCliente.getInstancia();
        ctrlProd = ControleProduto.getInstancia();
        ctrlVenda = new ControleVenda();
        ctrlItemVenda = new ControleItemVenda();
        model = (DefaultTableModel) this.jTable1.getModel();
        
        try {
            listCli = ctrlCli.buscarCliente();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao carregar lista de Clientes. Reinicie a janela!");
        }
        
        Iterator itCli = listCli.iterator();
        while (itCli.hasNext()) {
            if (this.cmbCliente.getComponentCount() == 0) {
                this.cmbCliente.addItem("Selecione");
            }
            
            Cliente cli = (Cliente) itCli.next();
            this.cmbCliente.addItem(cli.getNome());
        }
        
        try {
            listProd = ctrlProd.buscarProduto();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao carregar lista de Produtos. Reinicie a janela!");
        }

        Iterator itProd = listProd.iterator();
        while (itProd.hasNext()) {
            if (this.cmbProduto.getComponentCount() == 0) {
                this.cmbProduto.addItem("Selecione");
                System.out.println("1");
            }

            Produtos prod = (Produtos) itProd.next();
            this.cmbProduto.addItem(prod.getTitulo());
        }
        
        this.btnInserirCliente.setEnabled(false);
        this.cmbProduto.setEnabled(false);
        this.btnInserirProd.setEnabled(false);
        this.txtQtdProd.setEnabled(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cmbProduto = new javax.swing.JComboBox<>();
        lblProduto = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblCpfCli = new javax.swing.JLabel();
        lblNomeCli = new javax.swing.JLabel();
        cmbCliente = new javax.swing.JComboBox<>();
        lblCliente = new javax.swing.JLabel();
        txtNomeCli = new javax.swing.JTextField();
        txtCpfCli = new javax.swing.JTextField();
        lblCodProd = new javax.swing.JLabel();
        txtCodProd = new javax.swing.JTextField();
        lblGeneroProd = new javax.swing.JLabel();
        txtGeneroProd = new javax.swing.JTextField();
        lblTituloProd = new javax.swing.JLabel();
        txtTituloProd = new javax.swing.JTextField();
        lblPrecoProd = new javax.swing.JLabel();
        lblQtdProd = new javax.swing.JLabel();
        txtQtdProd = new javax.swing.JTextField();
        btnInserirProd = new javax.swing.JButton();
        btnInserirCliente = new javax.swing.JButton();
        txtPrecoProd = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        lblTituloVenda = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cmbProduto.setForeground(new java.awt.Color(153, 153, 255));
        cmbProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        cmbProduto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbProdutoItemStateChanged(evt);
            }
        });

        lblProduto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblProduto.setForeground(new java.awt.Color(255, 255, 255));
        lblProduto.setText("Produto");

        jSeparator1.setToolTipText("");
        jSeparator1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblCpfCli.setForeground(new java.awt.Color(255, 255, 255));
        lblCpfCli.setText("CPF:");

        lblNomeCli.setForeground(new java.awt.Color(255, 255, 255));
        lblNomeCli.setText("Nome:");

        cmbCliente.setForeground(new java.awt.Color(153, 153, 255));
        cmbCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione" }));
        cmbCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbClienteItemStateChanged(evt);
            }
        });

        lblCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCliente.setForeground(new java.awt.Color(255, 255, 255));
        lblCliente.setText("Cliente");

        txtNomeCli.setEditable(false);
        txtNomeCli.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtCpfCli.setEditable(false);
        txtCpfCli.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblCodProd.setForeground(new java.awt.Color(255, 255, 255));
        lblCodProd.setText("Cód.:");

        txtCodProd.setEditable(false);
        txtCodProd.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblGeneroProd.setForeground(new java.awt.Color(255, 255, 255));
        lblGeneroProd.setText("Genero:");

        txtGeneroProd.setEditable(false);
        txtGeneroProd.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblTituloProd.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloProd.setText("Título:");

        txtTituloProd.setEditable(false);
        txtTituloProd.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lblPrecoProd.setForeground(new java.awt.Color(255, 255, 255));
        lblPrecoProd.setText("Preço Unit.:");

        lblQtdProd.setForeground(new java.awt.Color(255, 255, 255));
        lblQtdProd.setText("Qtd.:");

        btnInserirProd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnInserirProd.setForeground(new java.awt.Color(153, 153, 255));
        btnInserirProd.setText("Inserir Produto");
        btnInserirProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirProdActionPerformed(evt);
            }
        });

        btnInserirCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnInserirCliente.setForeground(new java.awt.Color(153, 153, 255));
        btnInserirCliente.setText("Inserir Cliente");
        btnInserirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirClienteActionPerformed(evt);
            }
        });

        txtPrecoProd.setEditable(false);
        txtPrecoProd.setBorder(null);
        txtPrecoProd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txtPrecoProd.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtPrecoProd.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTituloProd)
                        .addGap(18, 18, 18)
                        .addComponent(txtTituloProd, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnInserirCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnInserirProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblPrecoProd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPrecoProd, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblQtdProd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQtdProd))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCodProd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblGeneroProd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGeneroProd))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lblProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCpfCli)
                                    .addComponent(lblNomeCli))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCpfCli)
                                    .addComponent(txtNomeCli))))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente)
                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpfCli)
                    .addComponent(txtCpfCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeCli)
                    .addComponent(txtNomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(btnInserirCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProduto))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodProd)
                    .addComponent(txtCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGeneroProd)
                    .addComponent(txtGeneroProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTituloProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTituloProd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecoProd)
                    .addComponent(txtPrecoProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQtdProd)
                    .addComponent(txtQtdProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(btnInserirProd)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblTituloVenda.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTituloVenda.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloVenda.setText("Tabela de Vendas");
        lblTituloVenda.setMaximumSize(new java.awt.Dimension(232, 29));
        lblTituloVenda.setMinimumSize(new java.awt.Dimension(232, 29));

        jScrollPane1.setForeground(new java.awt.Color(153, 153, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod", "Título", "Qtd", "Preco Unit", "Preco Tot"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(40);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
            jTable1.getColumnModel().getColumn(1).setMinWidth(200);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(200);
            jTable1.getColumnModel().getColumn(2).setMinWidth(40);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(40);
            jTable1.getColumnModel().getColumn(3).setMinWidth(70);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(70);
            jTable1.getColumnModel().getColumn(4).setMinWidth(70);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(70);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(70);
        }

        btnExcluir.setBackground(new java.awt.Color(255, 153, 153));
        btnExcluir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnFinalizar.setBackground(new java.awt.Color(102, 255, 204));
        btnFinalizar.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        btnFinalizar.setForeground(new java.awt.Color(255, 255, 255));
        btnFinalizar.setText("Finalizar");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Selecione o Item para excluir");

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Clique em finalizar para gerar a Nota de Venda");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTituloVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addComponent(btnFinalizar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTituloVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addComponent(btnFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbClienteItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {

            Cliente cliSelecionado = new Cliente();

            if (this.cmbCliente.getSelectedIndex() != 0) {
                cliSelecionado = listCli.get(this.cmbCliente.getSelectedIndex()-1);

                this.txtNomeCli.setText(cliSelecionado.getNome());
                this.txtCpfCli.setText(cliSelecionado.getCpf());
            } else {
                this.txtNomeCli.setText("");
                this.txtCpfCli.setText("");
            }

            this.btnInserirCliente.setEnabled(true);
        }     
    }//GEN-LAST:event_cmbClienteItemStateChanged

    private void cmbProdutoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbProdutoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {

            Produtos prodSelecionado = new Produtos();

            if (this.cmbProduto.getSelectedIndex() != 0) {
                prodSelecionado = listProd.get(this.cmbProduto.getSelectedIndex()-1);
                               
                this.txtCodProd.setText(String.valueOf(prodSelecionado.getCod_prod()));
                this.txtGeneroProd.setText(prodSelecionado.getGenero());
                this.txtTituloProd.setText(prodSelecionado.getTitulo());
                this.txtPrecoProd.setText(String.valueOf(prodSelecionado.getPrecoUni()));
                this.preco = prodSelecionado.getPrecoUni();
                     
                if (!"".equals(txtPrecoProd.getText())) {
                    BigDecimal preco = new BigDecimal(txtPrecoProd.getText().replace(",", "."));
                    NumberFormat formatoPreco = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));

                    String valorFormatado = formatoPreco.format(preco);
                    this.txtPrecoProd.setText(valorFormatado);
                } else {
                    this.txtPrecoProd.setValue(null);
                }
                
            } else {
                this.txtCodProd.setText("");
                this.txtGeneroProd.setText("");
                this.txtTituloProd.setText("");
                this.txtPrecoProd.setText("");
            }

            this.txtQtdProd.setEnabled(true);
            this.btnInserirProd.setEnabled(true);
        } 
    }//GEN-LAST:event_cmbProdutoItemStateChanged

    private void btnInserirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirClienteActionPerformed
        cliSelecionado = new Cliente();
        cliSelecionado = listCli.get(this.cmbCliente.getSelectedIndex()-1);
        
        venda = new Venda(cliSelecionado.getId_cliente());
        
        this.cmbProduto.setEnabled(true);
        
        this.cmbCliente.setEnabled(false);
        this.btnInserirCliente.setEnabled(false);
    }//GEN-LAST:event_btnInserirClienteActionPerformed

    private void btnInserirProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirProdActionPerformed
               
        if(!"".equals(this.txtQtdProd.getText()) && !this.txtQtdProd.getText().equals("0")){
            ItemVenda item = new ItemVenda();

            item.setCodProd(Integer.parseInt(this.txtCodProd.getText()));
            item.setPrecoUnit(this.preco);
            item.setQtd(Integer.parseInt(this.txtQtdProd.getText()));

            //criando uma variável NumberFormat para inserir o tipo de moeda local (R$ ##,##)
            NumberFormat valor2 = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

            this.model.addRow(new Object[]{item.getCodProd(),this.txtTituloProd.getText(),item.getQtd(),valor2.format(item.getPrecoUnit()),valor2.format(item.getQtd()*item.getPrecoUnit())});

            this.txtCodProd.setText("");
            this.txtQtdProd.setText("");
            this.txtPrecoProd.setText("");
            this.txtGeneroProd.setText("");
            this.txtTituloProd.setText("");
            this.cmbProduto.setSelectedIndex(0);
        }else{
            JOptionPane.showMessageDialog(null, "Informe uma quantidade válida!", "Erro", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnInserirProdActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int index = this.jTable1.getSelectedRow();
        
        try {
            this.model.removeRow(index);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Selecione um item na tabela", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        try {
            ctrlVenda.insereVenda(this.venda.getIdCliente());
        } catch (SQLException ex) {
        }
        
        venda = ctrlVenda.buscaVenda("id_cliente", this.venda.getIdCliente());
        int linha = 0;
        listItemVenda = new ArrayList<>();
        
        while (linha < this.jTable1.getRowCount()) {
            ItemVenda item = new ItemVenda();
            item.setCodProd((int) this.jTable1.getValueAt(linha, 0));
            item.setCodVenda(venda.getCodVenda());
            String preco = (String) this.jTable1.getValueAt(linha, 3);
            preco = preco.replace(",", ".");
            item.setPrecoUnit(Float.parseFloat(preco.substring(3,preco.length())));
            item.setQtd((int) this.jTable1.getValueAt(linha, 2));
            this.listItemVenda.add(item);
            
            linha++;
        }
        
        ctrlItemVenda.inserirItemVenda(listItemVenda);
        
        JOptionPane.showMessageDialog(null, "Venda Cadastrada com Sucesso!");
        this.dispose();
    }//GEN-LAST:event_btnFinalizarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Cad_Venda().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnInserirCliente;
    private javax.swing.JButton btnInserirProd;
    private javax.swing.JComboBox<String> cmbCliente;
    private javax.swing.JComboBox<String> cmbProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblCodProd;
    private javax.swing.JLabel lblCpfCli;
    private javax.swing.JLabel lblGeneroProd;
    private javax.swing.JLabel lblNomeCli;
    private javax.swing.JLabel lblPrecoProd;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JLabel lblQtdProd;
    private javax.swing.JLabel lblTituloProd;
    private javax.swing.JLabel lblTituloVenda;
    private javax.swing.JTextField txtCodProd;
    private javax.swing.JTextField txtCpfCli;
    private javax.swing.JTextField txtGeneroProd;
    private javax.swing.JTextField txtNomeCli;
    private javax.swing.JFormattedTextField txtPrecoProd;
    private javax.swing.JTextField txtQtdProd;
    private javax.swing.JTextField txtTituloProd;
    // End of variables declaration//GEN-END:variables

}
