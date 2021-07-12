/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ithembarayofhope;

import java.sql.*;
import javax.swing.*;
/**
 *
 * @author User
 */
public class frmSelectClient extends javax.swing.JFrame {

    /**
     * Creates new form frmSelectClient
     */
    public frmSelectClient() {
        initComponents();
        lstUser.setModel(mListModel());
    }

    SQLExecutingMethods sqlMethods = new SQLExecutingMethods();
    
    private DefaultListModel mListModel() {
        DefaultListModel model = new DefaultListModel();
        String strQuery = "SELECT ID, Username FROM Users_Login";
        try (Statement stStatement = sqlMethods.mDatabaseConnection().prepareStatement(strQuery)){
            ResultSet rs = stStatement.executeQuery(strQuery);
            
            while(rs.next()) {
                model.addElement(rs.getString(1) +" "+ rs.getString(2));
            }
            stStatement.close();
            rs.close();
            
        } catch(SQLException | NullPointerException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
        return model;
    }
    
    private void mPolicyRegistration() {
        if(!lstUser.isSelectionEmpty()) {
            frmPolicyRegistrations frmPolicyReg = new frmPolicyRegistrations();
            frmPolicyReg.mSetLoginID(Integer.parseInt(lstUser.getSelectedValue().substring(0, lstUser.getSelectedValue().indexOf(" ")).trim()));
            frmPolicyReg.setLocationRelativeTo(null);
            frmPolicyReg.setAlwaysOnTop(true);
            frmPolicyReg.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            frmPolicyReg.setVisible(true);
            this.setVisible(false);
        } 
        else {
            JOptionPane.showMessageDialog(this, "Select a user to register a policy for.");
        }
    }
    
    private void mRegisterLoginAccount() {
        frmRegister frmReg = new frmRegister();
        frmReg.setLocationRelativeTo(null);
        frmReg.setAlwaysOnTop(true);
        frmReg.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frmReg.setVisible(true);
        this.setVisible(false);
    }
    
    private void mPolicyEdit() {
        if(!lstUser.isSelectionEmpty()) {
            frmPolicyRegistrations frmPolicyReg = new frmPolicyRegistrations();
            frmPolicyReg.mAdminPolicyEdit();
            frmPolicyReg.mSetLoginID(Integer.parseInt(lstUser.getSelectedValue().substring(0, lstUser.getSelectedValue().indexOf(" ")).trim()));
            frmPolicyReg.setLocationRelativeTo(null);
            frmPolicyReg.setAlwaysOnTop(true);
            frmPolicyReg.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            frmPolicyReg.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Select a user to register a policy for.");
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

        lblSelectUser = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstUser = new javax.swing.JList<>();
        btnRegPolicy = new javax.swing.JButton();
        btnRegLoginAcc = new javax.swing.JButton();
        btnEditPolicy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSelectUser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSelectUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSelectUser.setText("Select User");

        jScrollPane1.setViewportView(lstUser);

        btnRegPolicy.setText("Reg Policy");
        btnRegPolicy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegPolicyActionPerformed(evt);
            }
        });

        btnRegLoginAcc.setText("Reg Login Acc");
        btnRegLoginAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegLoginAccActionPerformed(evt);
            }
        });

        btnEditPolicy.setText("Edit Policy");
        btnEditPolicy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditPolicyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSelectUser, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegPolicy, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditPolicy, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnRegLoginAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblSelectUser, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegPolicy)
                    .addComponent(btnRegLoginAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditPolicy))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegPolicyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegPolicyActionPerformed
        mPolicyRegistration();
    }//GEN-LAST:event_btnRegPolicyActionPerformed

    private void btnRegLoginAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegLoginAccActionPerformed
        mRegisterLoginAccount();
    }//GEN-LAST:event_btnRegLoginAccActionPerformed

    private void btnEditPolicyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditPolicyActionPerformed
        mPolicyEdit();
    }//GEN-LAST:event_btnEditPolicyActionPerformed

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
            java.util.logging.Logger.getLogger(frmSelectClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSelectClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSelectClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSelectClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmSelectClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditPolicy;
    private javax.swing.JButton btnRegLoginAcc;
    private javax.swing.JButton btnRegPolicy;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSelectUser;
    private javax.swing.JList<String> lstUser;
    // End of variables declaration//GEN-END:variables
}
