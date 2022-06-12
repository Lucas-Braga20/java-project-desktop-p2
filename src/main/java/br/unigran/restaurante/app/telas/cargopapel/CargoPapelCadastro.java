/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package br.unigran.restaurante.app.telas.cargopapel;

import br.unigran.restaurante.app.builder.CargoPapelBuilder;
import br.unigran.restaurante.app.casouso.CargoPapelUC;
import br.unigran.restaurante.app.enums.Papel;
import br.unigran.restaurante.app.models.Cargo;
import br.unigran.restaurante.app.models.CargoPapel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class CargoPapelCadastro extends javax.swing.JDialog {

    /**
     * Creates new form CargoPapelCadastro
     */
    public CargoPapelCadastro(java.awt.Frame parent, boolean modal, Cargo cargo) {
        super(parent, modal);
        this.cargo = cargo;
        initComponents();
        carregarPapeis();
    }
    
    Cargo cargo;
    
    public void carregarPapeis() {
        try {
            List<String> papeis = new ArrayList<String>();
            for (int i = 0; i < Papel.values().length; i++) {
                papeis.add(Papel.values()[i].toString());
            }
            jComboBoxPapel.setModel(new DefaultComboBoxModel(papeis.toArray()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Houve um erro, tente novamente!\n"+e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
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
        jLabelTitulo = new javax.swing.JLabel();
        Corpo = new javax.swing.JPanel();
        jLabelPapel = new javax.swing.JLabel();
        jComboBoxPapel = new javax.swing.JComboBox<>();
        Rodape = new javax.swing.JPanel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de papel no cargo");
        setPreferredSize(new java.awt.Dimension(800, 600));

        Cabecalho.setPreferredSize(new java.awt.Dimension(800, 40));

        jLabelTitulo.setText("Cadastrar papel no cargo");

        javax.swing.GroupLayout CabecalhoLayout = new javax.swing.GroupLayout(Cabecalho);
        Cabecalho.setLayout(CabecalhoLayout);
        CabecalhoLayout.setHorizontalGroup(
            CabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(CabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CabecalhoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabelTitulo)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        CabecalhoLayout.setVerticalGroup(
            CabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(CabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(CabecalhoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabelTitulo)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(Cabecalho, java.awt.BorderLayout.PAGE_START);

        jLabelPapel.setText("Papel");

        jComboBoxPapel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxPapel.setPreferredSize(new java.awt.Dimension(72, 35));

        javax.swing.GroupLayout CorpoLayout = new javax.swing.GroupLayout(Corpo);
        Corpo.setLayout(CorpoLayout);
        CorpoLayout.setHorizontalGroup(
            CorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CorpoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPapel, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addComponent(jComboBoxPapel, javax.swing.GroupLayout.Alignment.TRAILING, 0, 788, Short.MAX_VALUE))
                .addContainerGap())
        );
        CorpoLayout.setVerticalGroup(
            CorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CorpoLayout.createSequentialGroup()
                .addComponent(jLabelPapel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxPapel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(347, Short.MAX_VALUE))
        );

        getContentPane().add(Corpo, java.awt.BorderLayout.CENTER);

        Rodape.setPreferredSize(new java.awt.Dimension(800, 40));
        Rodape.setLayout(new java.awt.GridLayout(1, 0));

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        Rodape.add(jButtonCancelar);

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        Rodape.add(jButtonSalvar);

        getContentPane().add(Rodape, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:
        try {
            
            String papel = (String) jComboBoxPapel.getSelectedItem();
            
            CargoPapelBuilder cargoPapelBuilder = new CargoPapelBuilder(Papel.valueOf(papel), cargo);
            
            CargoPapelUC.salvar(cargoPapelBuilder);
            
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Houve um erro, tente novamente!\n"+e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(CargoPapelCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CargoPapelCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CargoPapelCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CargoPapelCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CargoPapelCadastro dialog = new CargoPapelCadastro(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JPanel Rodape;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxPapel;
    private javax.swing.JLabel jLabelPapel;
    private javax.swing.JLabel jLabelTitulo;
    // End of variables declaration//GEN-END:variables
}
