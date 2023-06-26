/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ifce;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author walmi
 */
public class tela_1 extends javax.swing.JFrame {

    ControleTela controle = new ControleTela();
    DefaultListModel userList = new DefaultListModel();
    DefaultListModel palavrasList = new DefaultListModel();

    //add a lista
    private void addArgumentToList(String argument, DefaultListModel listModel, JList list) {
        list.setModel(listModel);
        listModel.addElement(argument);
    }

    //envia as informações de usuario para a tela_1 de bate papo
    public String[] exibirListaNaTela() {
        String elementos = controle.listarUsuarioBatePapo(usuarioList.getSelectedValue());
        return elementos.split(", ");
    }
    
    public String usuarioConectade(){
        String usuarioConectade = usuarioList.getSelectedValue();
        return usuarioConectade;
    }

    public JList<String> getUsuarioList() {
        return usuarioList;
    }
   
    /**
     * Creates new form tela_1
     */
    public tela_1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usuarioButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        usuarioList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        palavrasbutton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        palavras = new javax.swing.JList<>();
        usuarioButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        usuarioButton.setText("Usuário");
        usuarioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioButtonActionPerformed(evt);
            }
        });

        usuarioList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usuarioListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(usuarioList);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("criar");

        palavrasbutton.setText("Palavras Suspeitas");
        palavrasbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                palavrasbuttonActionPerformed(evt);
            }
        });

        palavras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                palavrasMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(palavras);

        usuarioButton2.setText("Chamar Espião");
        usuarioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(palavrasbutton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(usuarioButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(usuarioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usuarioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(palavrasbutton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(usuarioButton2)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usuarioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioButtonActionPerformed
        //Cria um novo usuario
        addArgumentToList(controle.criarUsuario(), userList, usuarioList);
        //System.out.println(exibirListaNaTela());
    }//GEN-LAST:event_usuarioButtonActionPerformed

    private void usuarioListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuarioListMouseClicked
        // Crie um JTextField
        //JTextField txtAmb1 = new JTextField("amb");

        // Crie um painel personalizado contendo a mensagem, o JTextField e os botões
        Object[] opcoes = {"Excluir Usuário", "Iniciar Bate Papo", "Cancelar"};
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Escolha um ambiente:"), BorderLayout.NORTH);
        
        // Mostre a caixa de diálogo
        int escolha = JOptionPane.showOptionDialog(null, panel, "Informações do " + usuarioList.getSelectedValue(), JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        //Trata a opção que o usuario escolheu
        if (escolha == 0) {
            controle.excluirUsuario(usuarioList.getSelectedValue());
            //atualizar a lista
            int index = usuarioList.getSelectedIndex();
            userList.removeElementAt(index);
        } else if (escolha == 1) {
            chat novoBatePapo = new chat();
            novoBatePapo.setUsuarioConectade(usuarioList.getSelectedValue());
            //novoBatePapo.setAmbNome(controle.ambUsuarioBatePapo(usuarioList.getSelectedValue()));

            novoBatePapo.setVisible(true);
        } else if (escolha == 2) {

        }
    }//GEN-LAST:event_usuarioListMouseClicked

    private void palavrasbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_palavrasbuttonActionPerformed
        JLabel lbl = new JLabel("Qual palavra você deseja monitorar?");
        JTextField txtPalavra = new JTextField("");
        Object[] texts = {lbl, txtPalavra};
        JOptionPane.showMessageDialog(null, texts);

        controle.cadatrarPalavra(txtPalavra.getText());
        
        addArgumentToList(txtPalavra.getText(), palavrasList, palavras);
    }//GEN-LAST:event_palavrasbuttonActionPerformed

    private void palavrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_palavrasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_palavrasMouseClicked

    private void usuarioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(tela_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tela_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tela_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<String> palavras;
    private javax.swing.JButton palavrasbutton;
    private javax.swing.JButton usuarioButton;
    private javax.swing.JButton usuarioButton2;
    private javax.swing.JList<String> usuarioList;
    // End of variables declaration//GEN-END:variables
}