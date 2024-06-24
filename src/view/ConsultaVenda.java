package view;

import control.ControleCliente;
import control.ControleProduto;
import control.ControleVenda;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.Cliente;
import model.bean.Venda;


public class ConsultaVenda extends javax.swing.JFrame {

    ControleCliente ctrlCli;
    ControleProduto ctrlProd;
    ControleVenda ctrlVenda;
    
    ArrayList<Cliente> listCli;
    
    DefaultTableModel model;

    public ConsultaVenda() {
        initComponents();
        
        this.cmbBuscaAno.setEnabled(false);
        this.cmbBuscaMes.setEnabled(false);
        
        ctrlCli = ControleCliente.getInstancia();
        ctrlProd = ControleProduto.getInstancia();
        ctrlVenda = new ControleVenda();
        listCli = new ArrayList<>();
        model = (DefaultTableModel) this.jTable1.getModel();
        
        try {
            listCli = ctrlCli.buscarCliente();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Falha ao carregar lista de Clientes. Reinicie a janela!");
        }
        
        Iterator itCli = listCli.iterator();
        while (itCli.hasNext()) {
            if (this.cmbBuscaCliente.getComponentCount() == 0) {
                this.cmbBuscaCliente.addItem("Todos");
            }
            
            Cliente cli = (Cliente) itCli.next();
            this.cmbBuscaCliente.addItem(cli.getNome());
        }
    }
    
    public void limpa(){
        this.txtNumVenda.setText("");
        this.cmbBuscaCliente.setSelectedIndex(0);
        this.cmbBuscaAno.setSelectedIndex(0);
        this.cmbBuscaMes.setSelectedIndex(0);
        this.model.setNumRows(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNumVenda = new javax.swing.JTextField();
        lblNumVenda = new javax.swing.JLabel();
        lblBuscaCliente = new javax.swing.JLabel();
        cmbBuscaCliente = new javax.swing.JComboBox<>();
        lblBuscaMes = new javax.swing.JLabel();
        cmbBuscaMes = new javax.swing.JComboBox<>();
        lblBuscaAno = new javax.swing.JLabel();
        cmbBuscaAno = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnDetalhesVenda = new javax.swing.JButton();
        btnExcluirVenda = new javax.swing.JButton();
        btnCadastrarVenda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Vendas");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        txtNumVenda.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblNumVenda.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNumVenda.setForeground(new java.awt.Color(255, 255, 255));
        lblNumVenda.setText("Nº Venda:");

        lblBuscaCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblBuscaCliente.setForeground(new java.awt.Color(255, 255, 255));
        lblBuscaCliente.setText("Cliente:");

        cmbBuscaCliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbBuscaCliente.setForeground(new java.awt.Color(153, 153, 255));
        cmbBuscaCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos" }));

        lblBuscaMes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblBuscaMes.setForeground(new java.awt.Color(255, 255, 255));
        lblBuscaMes.setText("Mês:");
        lblBuscaMes.setToolTipText("");

        cmbBuscaMes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbBuscaMes.setForeground(new java.awt.Color(153, 153, 255));
        cmbBuscaMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));

        lblBuscaAno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblBuscaAno.setForeground(new java.awt.Color(255, 255, 255));
        lblBuscaAno.setText("Ano:");

        cmbBuscaAno.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbBuscaAno.setForeground(new java.awt.Color(153, 153, 255));
        cmbBuscaAno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019" }));

        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(153, 153, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnLimpar.setForeground(new java.awt.Color(153, 153, 255));
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº Venda", "Cliente", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
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
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(35);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(180);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(135);
        }

        btnDetalhesVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDetalhesVenda.setForeground(new java.awt.Color(153, 153, 255));
        btnDetalhesVenda.setText("Detalhes");
        btnDetalhesVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesVendaActionPerformed(evt);
            }
        });

        btnExcluirVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExcluirVenda.setForeground(new java.awt.Color(153, 153, 255));
        btnExcluirVenda.setText("Excluir");
        btnExcluirVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirVendaActionPerformed(evt);
            }
        });

        btnCadastrarVenda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCadastrarVenda.setForeground(new java.awt.Color(153, 153, 255));
        btnCadastrarVenda.setText("Cadastrar");
        btnCadastrarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarVendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblBuscaCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbBuscaCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnDetalhesVenda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnExcluirVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnCadastrarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblNumVenda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNumVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblBuscaMes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbBuscaMes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblBuscaAno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbBuscaAno, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBuscaCliente)
                    .addComponent(cmbBuscaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumVenda)
                    .addComponent(txtNumVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBuscaMes)
                    .addComponent(cmbBuscaMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBuscaAno)
                    .addComponent(cmbBuscaAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(btnLimpar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDetalhesVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnExcluirVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(btnCadastrarVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        ArrayList<Venda> resultVendas = new ArrayList<>();
        resultVendas = ctrlVenda.buscaVenda();

        this.model.setNumRows(0);

        if (resultVendas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há vendas cadastradas!");
            return;
        }

        //Máscara de data
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd / MMMM / yy");

        Iterator it = resultVendas.iterator();
        while (it.hasNext()) {
            Venda registro = new Venda();
            registro = (Venda) it.next();

            // Check if the string length is at least 10 before calling substring
            if (registro.getDataVenda().length() >= 10) {
                LocalDate data = LocalDate.parse(registro.getDataVenda().substring(0, 10));
                String dataFormatada = data.format(formato);

                Cliente cli = new Cliente();

                if (this.cmbBuscaCliente.getSelectedIndex() != registro.getIdCliente() && this.cmbBuscaCliente.getSelectedIndex() != 0) {
                    continue;
                }

                if (!this.txtNumVenda.getText().equals(String.valueOf(registro.getCodVenda())) && !"".equals(this.txtNumVenda.getText())) {
                    continue;
                }

                try {
                    cli = ctrlCli.buscarCliente("id_cliente", registro.getIdCliente());
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultaVenda.class.getName()).log(Level.SEVERE, null, ex);
                }

                this.model.addRow(new Object[]{registro.getCodVenda(), cli.getNome(), dataFormatada});
            } else {
                // Handle the case where the date string is shorter than expected
                JOptionPane.showMessageDialog(null, "Data inválida para a venda com código: " + registro.getCodVenda());
            }
        }

        if (this.model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado!");
        }
    }
//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpa();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnExcluirVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirVendaActionPerformed
        int codVenda, index;
        index = this.jTable1.getSelectedRow();
        
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um item da tabela");
            return;
        }
        
        codVenda = (int) this.jTable1.getValueAt(index, 0);
        
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Excluir",JOptionPane.YES_NO_OPTION);
        
        if (resposta == JOptionPane.YES_OPTION) {
            ctrlVenda.excluiVenda(codVenda);
            
            limpa();
            
            //Atualiza a lista
            ArrayList<Venda> resultVendas = new ArrayList<>();
            resultVendas = ctrlVenda.buscaVenda();
        
            this.model.setNumRows(0);
        
            Iterator it = resultVendas.iterator();
            while (it.hasNext()) {
                Venda registro = new Venda();
                registro = (Venda) it.next();

                Cliente cli = new Cliente();

                try {
                    cli = ctrlCli.buscarCliente("id_cliente", registro.getIdCliente());
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultaVenda.class.getName()).log(Level.SEVERE, null, ex);
                }

                this.model.addRow(new Object[]{registro.getCodVenda(), cli.getNome(), registro.getDataVenda()});
            }
        }          
    }//GEN-LAST:event_btnExcluirVendaActionPerformed

    private void btnCadastrarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarVendaActionPerformed
        new Cad_Venda().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCadastrarVendaActionPerformed

    private void btnDetalhesVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesVendaActionPerformed
        int index = this.jTable1.getSelectedRow();
        
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um item na tabela");
            return;
        }
        
        int codVenda = (int) this.jTable1.getValueAt(index, 0);
        
        new DetalheVenda(codVenda).setVisible(true);
    }//GEN-LAST:event_btnDetalhesVendaActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCadastrarVenda;
    private javax.swing.JButton btnDetalhesVenda;
    private javax.swing.JButton btnExcluirVenda;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JComboBox<String> cmbBuscaAno;
    private javax.swing.JComboBox<String> cmbBuscaCliente;
    private javax.swing.JComboBox<String> cmbBuscaMes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblBuscaAno;
    private javax.swing.JLabel lblBuscaCliente;
    private javax.swing.JLabel lblBuscaMes;
    private javax.swing.JLabel lblNumVenda;
    private javax.swing.JTextField txtNumVenda;
    // End of variables declaration//GEN-END:variables
}
