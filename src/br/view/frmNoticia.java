/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.view;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import br.model.bean.Noticia;
import br.model.dao.NoticiaDAO;

/**
 *
 * @author 
 */
public class frmNoticia extends javax.swing.JFrame {


    enum PHASE {
        NONE,
        NEW,
        VIEW,
        EDIT
    }

    PHASE registerPhase = PHASE.NONE;

    public frmNoticia() {
        initComponents();
        this.getContentPane().setBackground(new Color(20, 20, 20));
        populateNewsTable();
    }

    private boolean checkParameters() {
        if (txtTitle.getText().isEmpty() || txtNews.getText().isEmpty() || txtDate.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Algum campo está vazio.");
            return false;
        }
        return true;
    }

    private void populateNewsTable() {
        DefaultTableModel model = (DefaultTableModel) tableNews.getModel();
        model.setNumRows(0);

        NoticiaDAO dao = new NoticiaDAO();

        dao.findAll().forEach((n) -> {
            model.addRow(new Object[]{
                n.getId(),
                n.getTitulo(),
                n.getNoticias(),
                n.getDataPublicacao()
            });
        });
    }

    private void populateNewsTableCustom() {
        DefaultTableModel model = (DefaultTableModel) tableNews.getModel();
        model.setNumRows(0);

        NoticiaDAO dao = new NoticiaDAO();

        dao.findAllByFilter(String.valueOf(comboSearch.getSelectedItem()), txtSearch.getText()).forEach((n) -> {
            model.addRow(new Object[]{
                n.getId(),
                n.getTitulo(),
                n.getNoticias(),
                n.getDataPublicacao()
            });
        });

    }

    private void updateControls(PHASE phase) {
        switch (phase) {
            case NONE:
       
                txtTitle.setEditable(false);
                txtNews.setEditable(false);
                txtDate.setEditable(false);

      
                btNew.setEnabled(true);
                btSave.setEnabled(false);
                btEdit.setEnabled(false);
                btDelete.setEnabled(false);
                btCancel.setEnabled(false);

                txtId.setText("");
                txtTitle.setText("");
                txtNews.setText("");
                txtDate.setText("");

                break;

            case NEW:
           
                txtTitle.setEditable(true);
                txtNews.setEditable(true);
                txtDate.setEditable(true);

         
                btNew.setEnabled(false);
                btSave.setEnabled(true);
                btEdit.setEnabled(false);
                btDelete.setEnabled(false);
                btCancel.setEnabled(true);
                break;

            case VIEW:
             
                txtTitle.setEditable(false);
                txtNews.setEditable(false);
                txtDate.setEditable(false);

          
                btNew.setEnabled(false);
                btSave.setEnabled(false);
                btEdit.setEnabled(true);
                btDelete.setEnabled(true);
                btCancel.setEnabled(true);
                break;

            case EDIT:
           
                txtTitle.setEditable(true);
                txtNews.setEditable(true);
                txtDate.setEditable(true);

            
                btNew.setEnabled(false);
                btSave.setEnabled(true);
                btEdit.setEnabled(false);
                btDelete.setEnabled(false);
                btCancel.setEnabled(true);
                break;

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

        tabcFornecedores = new javax.swing.JTabbedPane();
        tabFornecedoresReg = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        lbId = new javax.swing.JLabel();
        lbTitle = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        lbNews = new javax.swing.JLabel();
        txtNews = new javax.swing.JTextField();
        lbDate = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        btNew = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        btEdit = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        tabFornecedoresList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableNews = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        comboSearch = new javax.swing.JComboBox<>();
        btSearch = new javax.swing.JButton();
        btSearchReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabFornecedoresReg.setBackground(new java.awt.Color(0, 0, 204));

        txtId.setEditable(false);

        lbId.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbId.setForeground(new java.awt.Color(153, 153, 153));
        lbId.setText("ID");

        lbTitle.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(153, 153, 153));
        lbTitle.setText("Título");

        txtTitle.setEditable(false);

        lbNews.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbNews.setForeground(new java.awt.Color(153, 153, 153));
        lbNews.setText("Noticias");

        txtNews.setEditable(false);

        lbDate.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbDate.setForeground(new java.awt.Color(153, 153, 153));
        lbDate.setText("Data Publicação");

        txtDate.setEditable(false);
        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });

        btNew.setText("novo");
        btNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNewActionPerformed(evt);
            }
        });

        btSave.setText("salvar");
        btSave.setEnabled(false);
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        btEdit.setText("editar");
        btEdit.setEnabled(false);
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });

        btDelete.setText("excluir");
        btDelete.setEnabled(false);
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        btCancel.setText("cancelar");
        btCancel.setEnabled(false);
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabFornecedoresRegLayout = new javax.swing.GroupLayout(tabFornecedoresReg);
        tabFornecedoresReg.setLayout(tabFornecedoresRegLayout);
        tabFornecedoresRegLayout.setHorizontalGroup(
            tabFornecedoresRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabFornecedoresRegLayout.createSequentialGroup()
                .addGroup(tabFornecedoresRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabFornecedoresRegLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(tabFornecedoresRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabFornecedoresRegLayout.createSequentialGroup()
                                .addComponent(lbTitle)
                                .addGap(169, 169, 169)
                                .addComponent(lbId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbDate)
                            .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(tabFornecedoresRegLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabFornecedoresRegLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtNews, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabFornecedoresRegLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbNews))
                    .addGroup(tabFornecedoresRegLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(tabFornecedoresRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btNew)
                            .addComponent(btSave))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabFornecedoresRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabFornecedoresRegLayout.createSequentialGroup()
                                .addComponent(btEdit)
                                .addGap(18, 18, 18)
                                .addComponent(btDelete))
                            .addComponent(btCancel))))
                .addGap(291, 302, Short.MAX_VALUE))
        );
        tabFornecedoresRegLayout.setVerticalGroup(
            tabFornecedoresRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabFornecedoresRegLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(tabFornecedoresRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTitle)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbNews)
                .addGap(8, 8, 8)
                .addComponent(txtNews, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tabFornecedoresRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNew)
                    .addComponent(btEdit)
                    .addComponent(btDelete))
                .addGap(18, 18, 18)
                .addGroup(tabFornecedoresRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSave)
                    .addComponent(btCancel))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        tabcFornecedores.addTab("cadastrar", tabFornecedoresReg);

        tabFornecedoresList.setBackground(new java.awt.Color(0, 0, 204));

        tableNews.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "titulo", "noticias", "data publicação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableNews.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableNewsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableNews);

        comboSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "id", "titulo", "noticias", "dataPublicacao" }));

        btSearch.setText("Search");
        btSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchActionPerformed(evt);
            }
        });

        btSearchReset.setText("reset");
        btSearchReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabFornecedoresListLayout = new javax.swing.GroupLayout(tabFornecedoresList);
        tabFornecedoresList.setLayout(tabFornecedoresListLayout);
        tabFornecedoresListLayout.setHorizontalGroup(
            tabFornecedoresListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
            .addGroup(tabFornecedoresListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSearchReset)
                .addContainerGap())
        );
        tabFornecedoresListLayout.setVerticalGroup(
            tabFornecedoresListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabFornecedoresListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabFornecedoresListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSearch)
                    .addComponent(btSearchReset))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
        );

        tabcFornecedores.addTab("listar", tabFornecedoresList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabcFornecedores)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabcFornecedores)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tableNewsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableNewsMouseClicked

        if (tableNews.getSelectedRow() != -1) {

            txtId.setText(tableNews.getValueAt(tableNews.getSelectedRow(), 0).toString());
            txtTitle.setText(tableNews.getValueAt(tableNews.getSelectedRow(), 1).toString());
            txtNews.setText(tableNews.getValueAt(tableNews.getSelectedRow(), 2).toString());
            txtDate.setText(tableNews.getValueAt(tableNews.getSelectedRow(), 3).toString());

            

            registerPhase = PHASE.VIEW;
            updateControls(registerPhase);

            tabcFornecedores.setSelectedIndex(0);
        }
    }//GEN-LAST:event_tableNewsMouseClicked

    private void btNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNewActionPerformed
        registerPhase = PHASE.NEW;
        updateControls(registerPhase);
    }//GEN-LAST:event_btNewActionPerformed

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        if (checkParameters()) {
            Noticia n = new Noticia();
            NoticiaDAO dao = new NoticiaDAO ();
            switch (registerPhase) {
                case EDIT:
                    n.setId(Integer.parseInt(txtId.getText()));
                case NEW:
                    n.setTitulo(txtTitle.getText());
                    n.setNoticias(txtNews.getText());
                    n.setDataPublicacao(txtDate.getText());


                    dao.save(n); 
                    break;
            }

            registerPhase = PHASE.NONE;
            updateControls(registerPhase);
            populateNewsTable();
        }
    }//GEN-LAST:event_btSaveActionPerformed

    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        registerPhase = PHASE.EDIT;
        updateControls(registerPhase);
    }//GEN-LAST:event_btEditActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        NoticiaDAO dao = new NoticiaDAO ();

        dao.remove(Integer.parseInt(txtId.getText())); //deleta o user

        registerPhase = PHASE.NONE;
        updateControls(registerPhase);

        populateNewsTable();
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        registerPhase = PHASE.NONE;
        updateControls(registerPhase);
    }//GEN-LAST:event_btCancelActionPerformed

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchActionPerformed
        if (txtSearch.getText() != "") {
            populateNewsTableCustom();
        }
    }//GEN-LAST:event_btSearchActionPerformed

    private void btSearchResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchResetActionPerformed
        populateNewsTable();
    }//GEN-LAST:event_btSearchResetActionPerformed

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateActionPerformed

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
            java.util.logging.Logger.getLogger(frmNoticia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmNoticia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmNoticia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmNoticia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmNoticia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btNew;
    private javax.swing.JButton btSave;
    private javax.swing.JButton btSearch;
    private javax.swing.JButton btSearchReset;
    private javax.swing.JComboBox<String> comboSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDate;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbNews;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPanel tabFornecedoresList;
    private javax.swing.JPanel tabFornecedoresReg;
    private javax.swing.JTabbedPane tabcFornecedores;
    private javax.swing.JTable tableNews;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNews;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
