/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package br.unigran.restaurante.app.telas.ingredienteprato;

import br.unigran.restaurante.app.builder.IngredientePratoBuilder;
import br.unigran.restaurante.app.casouso.IngredientePratoUC;
import br.unigran.restaurante.app.casouso.IngredienteUC;
import br.unigran.restaurante.app.enums.UnidadeMedida;
import br.unigran.restaurante.app.models.Ingrediente;
import br.unigran.restaurante.app.models.IngredientePrato;
import br.unigran.restaurante.app.models.Prato;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas
 */
public class IngredientePratoCadastro extends javax.swing.JDialog {

    /**
     * Creates new form IngredientePratoCadastro
     */
    public IngredientePratoCadastro(java.awt.Frame parent, boolean modal, Prato prato, IngredientePrato ingredientePrato) {
        super(parent, modal);
        this.prato = prato;
        initComponents();
        carregaUnidadeMedida();
        carregaIngredientes();
        if (ingredientePrato != null) {
            this.ingredientePrato = ingredientePrato;
            carregaIngredientePrato();
        }
    }
    
    IngredientePrato ingredientePrato;
    Prato prato;
    
    public void carregaIngredientePrato() {
        jComboBoxIngrediente.setSelectedItem(ingredientePrato.getIngrediente());
        jComboBoxUnidadeMedida.setSelectedItem(ingredientePrato.getUnidadeMedida());
        jTextFieldQuantidade.setText(ingredientePrato.getQuantidade().toString());
        jTextFieldValor.setText(ingredientePrato.getValor().toString());
    }
    
    public void carregaUnidadeMedida() {
        List<String> unidadeMedidas = new ArrayList<String>();
        for (int i = 0; i < UnidadeMedida.values().length; i++) {
            unidadeMedidas.add(UnidadeMedida.values()[i].toString());
        }
        jComboBoxUnidadeMedida.setModel(new DefaultComboBoxModel(unidadeMedidas.toArray()));
    }
    
    public void carregaIngredientes() {
        try {
            List<Ingrediente> ingredientes = new IngredienteUC().listarTodos();
            jComboBoxIngrediente.setModel(new DefaultComboBoxModel(ingredientes.toArray()));
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
        jLabelUnidadeMedida = new javax.swing.JLabel();
        jComboBoxUnidadeMedida = new javax.swing.JComboBox<>();
        jLabelQuantidade = new javax.swing.JLabel();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jLabelValor = new javax.swing.JLabel();
        jTextFieldValor = new javax.swing.JTextField();
        jLabelIngrediente = new javax.swing.JLabel();
        jComboBoxIngrediente = new javax.swing.JComboBox<>();
        Rodape = new javax.swing.JPanel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de ingrediente no prato");

        Cabecalho.setPreferredSize(new java.awt.Dimension(800, 40));

        jLabelTitulo.setText("Cadastrar Ingrediente no prato");

        javax.swing.GroupLayout CabecalhoLayout = new javax.swing.GroupLayout(Cabecalho);
        Cabecalho.setLayout(CabecalhoLayout);
        CabecalhoLayout.setHorizontalGroup(
            CabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 808, Short.MAX_VALUE)
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

        Corpo.setPreferredSize(new java.awt.Dimension(808, 600));

        jLabelUnidadeMedida.setText("Unidade de medida");

        jComboBoxUnidadeMedida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxUnidadeMedida.setPreferredSize(new java.awt.Dimension(72, 35));

        jLabelQuantidade.setText("Quantidade");

        jTextFieldQuantidade.setPreferredSize(new java.awt.Dimension(64, 35));

        jLabelValor.setText("Valor");

        jTextFieldValor.setPreferredSize(new java.awt.Dimension(64, 35));

        jLabelIngrediente.setText("Ingrediente");

        jComboBoxIngrediente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxIngrediente.setPreferredSize(new java.awt.Dimension(72, 35));

        javax.swing.GroupLayout CorpoLayout = new javax.swing.GroupLayout(Corpo);
        Corpo.setLayout(CorpoLayout);
        CorpoLayout.setHorizontalGroup(
            CorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CorpoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelUnidadeMedida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxUnidadeMedida, 0, 796, Short.MAX_VALUE)
                    .addComponent(jLabelQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
                    .addComponent(jLabelValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldValor, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
                    .addComponent(jLabelIngrediente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxIngrediente, 0, 796, Short.MAX_VALUE))
                .addContainerGap())
        );
        CorpoLayout.setVerticalGroup(
            CorpoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CorpoLayout.createSequentialGroup()
                .addComponent(jLabelUnidadeMedida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxUnidadeMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelQuantidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelValor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelIngrediente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
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
            Float quantidade = Float.parseFloat(jTextFieldQuantidade.getText());
            Float valor = Float.parseFloat(jTextFieldValor.getText());
            String unidadeMedida = (String) jComboBoxUnidadeMedida.getSelectedItem();
            Ingrediente ingrediente = (Ingrediente) jComboBoxIngrediente.getSelectedItem();
            
            IngredientePratoBuilder ingredientePratoBuilder = new IngredientePratoBuilder(quantidade, valor, ingrediente, prato, UnidadeMedida.valueOf(unidadeMedida));
            
            if (ingredientePrato == null) {
                IngredientePratoUC.salvar(ingredientePratoBuilder);
            } else {
                IngredientePratoUC.atualizar(ingredientePratoBuilder, ingredientePrato);
            }
            
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
            java.util.logging.Logger.getLogger(IngredientePratoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngredientePratoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngredientePratoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngredientePratoCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                IngredientePratoCadastro dialog = new IngredientePratoCadastro(new javax.swing.JFrame(), true, null, null);
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
    private javax.swing.JComboBox<String> jComboBoxIngrediente;
    private javax.swing.JComboBox<String> jComboBoxUnidadeMedida;
    private javax.swing.JLabel jLabelIngrediente;
    private javax.swing.JLabel jLabelQuantidade;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelUnidadeMedida;
    private javax.swing.JLabel jLabelValor;
    private javax.swing.JTextField jTextFieldQuantidade;
    private javax.swing.JTextField jTextFieldValor;
    // End of variables declaration//GEN-END:variables
}
