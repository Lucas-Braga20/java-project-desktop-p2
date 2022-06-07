/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package br.unigran.restaurante.app.telas.ingredienteprato;

import br.unigran.restaurante.app.casouso.IngredientePratoUC;
import br.unigran.restaurante.app.casouso.MesaUC;
import br.unigran.restaurante.app.models.IngredientePrato;
import br.unigran.restaurante.app.models.Mesa;
import br.unigran.restaurante.app.models.Prato;
import br.unigran.restaurante.app.persistence.IngredientePratoDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucas
 */
public class IngredientePratoListagem extends javax.swing.JDialog {

    /**
     * Creates new form IngredientePratoListagem
     */
    public IngredientePratoListagem(java.awt.Frame parent, boolean modal, Prato prato) {
        super(parent, modal);
        initComponents();
        this.prato = prato;
        carregarTabela(prato);
    }
    
    DefaultTableModel tableModel;
    
    Prato prato = null;
    List<IngredientePrato> ingredientes;
    
    public void carregarTabela(Prato prato) {
        try {
            ingredientes = new IngredientePratoDAO().listarTodos(prato);
            int tamanho = ingredientes.size();
            String[] colunas = new String[] {"Ingrediente", "Quantidade", "Unidade de medida", "Valor"};
            Object[][] linhas = new Object[tamanho][colunas.length];
            for (int i = 0; i < ingredientes.size(); i++) {
                linhas[i][0] = ingredientes.get(i).getIngrediente().getDescricao();
                linhas[i][1] = ingredientes.get(i).getQuantidade();
                linhas[i][2] = ingredientes.get(i).getUnidadeMedida();
                linhas[i][3] = ingredientes.get(i).getValor();
            }
            tableModel = new DefaultTableModel(linhas, colunas) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            jTable1.setModel(tableModel);
        } catch(Exception e) {
            System.err.println("\n\nError: \n" + e);
            dispose();
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

        Cabecalho = new javax.swing.JPanel();
        MenuBotoes = new javax.swing.JPanel();
        jButtonAdicionar = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        Corpo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Rodape = new javax.swing.JPanel();
        jButtonSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem de ingredientes para o prato");

        Cabecalho.setMinimumSize(new java.awt.Dimension(800, 100));
        Cabecalho.setLayout(new java.awt.GridLayout(1, 0));

        MenuBotoes.setLayout(new java.awt.GridLayout(1, 0));

        jButtonAdicionar.setText("Adicionar ");
        jButtonAdicionar.setPreferredSize(new java.awt.Dimension(81, 40));
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });
        MenuBotoes.add(jButtonAdicionar);

        jButtonRemover.setText("Remover");
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });
        MenuBotoes.add(jButtonRemover);

        jButtonEditar.setText("Atualizar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });
        MenuBotoes.add(jButtonEditar);

        Cabecalho.add(MenuBotoes);

        getContentPane().add(Cabecalho, java.awt.BorderLayout.PAGE_START);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setCellEditor(null);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout CorpoLayout = new javax.swing.GroupLayout(Corpo);
        Corpo.setLayout(CorpoLayout);
        CorpoLayout.setHorizontalGroup(
            CorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        CorpoLayout.setVerticalGroup(
            CorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );

        getContentPane().add(Corpo, java.awt.BorderLayout.CENTER);

        Rodape.setPreferredSize(new java.awt.Dimension(800, 40));
        Rodape.setLayout(new java.awt.CardLayout());

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        Rodape.add(jButtonSair, "card2");

        getContentPane().add(Rodape, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        // TODO add your handling code here:
        new IngredientePratoCadastro(new javax.swing.JFrame(), true, prato).setVisible(true);
        carregarTabela(prato);
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
        // TODO add your handling code here:
        try {
            Integer indice = jTable1.getSelectedRow();
            new IngredientePratoUC().remover(ingredientes.get(indice).getId());
            carregarTabela(prato);
        } catch(Exception e) {
            System.err.println(e);
        }
    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        // TODO add your handling code here:
        try {
            Integer indice = jTable1.getSelectedRow();
            new IngredientePratoCadastro(new javax.swing.JFrame(), true, prato).setVisible(true);
            carregarTabela(prato);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

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
            java.util.logging.Logger.getLogger(IngredientePratoListagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngredientePratoListagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngredientePratoListagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngredientePratoListagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                IngredientePratoListagem dialog = new IngredientePratoListagem(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JPanel Cabecalho;
    private javax.swing.JPanel Corpo;
    private javax.swing.JPanel MenuBotoes;
    private javax.swing.JPanel Rodape;
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
