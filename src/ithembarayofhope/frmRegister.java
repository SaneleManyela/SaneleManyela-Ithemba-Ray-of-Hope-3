/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ithembarayofhope;

import javax.swing.JOptionPane;

/**
 *
 * @author Sanele
 */
public class frmRegister extends javax.swing.JFrame {
   

    /**
     * Creates new form frmRegister
     */
    public frmRegister() {
        initComponents();
        if(frmLogin.mGetLoginAccount() == null) {
            btnEdit.setEnabled(false);
            btnDelete.setEnabled(false);
        } 
        else if(frmLogin.mGetLoginAccount() !=  null
                && frmMain.strRole.equals("Administrator")) {
            btnReturn.setVisible(true);
        }
    }
    
    CaesarsChiper clsCC = new CaesarsChiper();
    SQLExecutingMethods sqlMethods = new SQLExecutingMethods();
    frmLogin frmLogin = new frmLogin();
    
    String strUsername;
    String strPassword;
    String strConfirmPass;
    String strRole;
    
    public void mHideReturnButton() {
        btnReturn.setVisible(false);
    }
    
    private void mGetValuesFromGUI()
    {
        strUsername = txtUsername.getText();
        strPassword = txtPass.getText();
        strConfirmPass = txtConfirmPass.getText();
        strRole = cboRole.getSelectedItem().toString();
    }
    
    private void mClearTextFields()
    {
        txtUsername.setText("");
        txtPass.setText("");
        txtConfirmPass.setText("");
    }
    
    private void mEncryptPassword()
    {
        strPassword = clsCC.mEncrypt(strPassword, 5);
    }
    
    private void mDecryptPassword()
    {
        strPassword = clsCC.mDecrypt(strPassword, 5);
    }
    
    private boolean mCheckInput() {
        if(txtUsername.getText().equals("")) 
        {
            return false;
        } 
        else if(txtPass.getText().equals(""))
        {
            return false;
        }
        else if(txtConfirmPass.getText().equals(""))
        {
            return false;
        }
        return true;
    }
    
    private void mCreateLoginAccount() {
        if(mCheckInput()) 
        {
            mGetValuesFromGUI();
            if(strPassword.equals(strConfirmPass))
            {
                mEncryptPassword();
                if(sqlMethods.mCheckIfItemsExistInTable("SELECT Username FROM Users_Login WHERE Username ='"+strUsername+"'")) 
                {
                    JOptionPane.showMessageDialog(this, "Username exists");
                }
                else if(sqlMethods.mCreateUser("INSERT INTO users_login "+"(Username,Password,Role)" + 
                        "VALUES ('" + strUsername + "','" + strPassword + "','" + strRole + "')").equals("Created")) 
                {
                    JOptionPane.showMessageDialog(this, "Login accout created");
                }
            } 
            else {
                JOptionPane.showMessageDialog(this, "Passwords are not the same");
            }
        } 
        else if(txtUsername.getText().equals("")) 
        {
            JOptionPane.showMessageDialog(this, "Username field required");
        }
        else if(txtPass.getText().equals("")) 
        {
            JOptionPane.showMessageDialog(this, "Password field required");
        }
        else if(txtConfirmPass.getText().equals("")) 
        {
            JOptionPane.showMessageDialog(this, "Password confirmation required");
        }
    }
    
    private void mSetDetailsForUpdate() {
        String[] arrUpdateDetails = sqlMethods.mFetchUserDetails(
                "SELECT Username, Password, Role FROM Users_Login WHERE ID ='"+frmLogin.mGetLoginAccount()+"'");
        strUsername = arrUpdateDetails[0];
        strPassword = arrUpdateDetails[1];
        mDecryptPassword();
        strConfirmPass = strPassword;
        strRole = arrUpdateDetails[2];
        
        txtUsername.setText(strUsername);
        txtPass.setText(strPassword);
        txtConfirmPass.setText(strConfirmPass);
        cboRole.setSelectedItem(strRole);
    }
    
    private void mSaveUpdate() {
        if(mCheckInput()) 
        {
            mGetValuesFromGUI();
            if(!sqlMethods.mTableField("SELECT Username FROM Users_Login WHERE ID ='"+
                    frmLogin.mGetLoginAccount()+"'").equals(strUsername)
                    && sqlMethods.mCheckIfItemsExistInTable("SELECT Username FROM Users_Login WHERE "
                        + "Username ='"+strUsername+"'")) 
            {
                JOptionPane.showMessageDialog(this, "Username exists");
            }
            else if(strPassword.equals(strConfirmPass)) 
            {
                mEncryptPassword();
                if(sqlMethods.mUpdateUser("UPDATE Users_Login SET Username ='"+strUsername +"', Password = '"+ strPassword+"', Role ='" + strRole +"' WHERE ID ='"+frmLogin.mGetLoginAccount()+"'").equals("Updated"))
                {
                    JOptionPane.showMessageDialog(this, "Login account updated");
                }
            } 
            else
            {
                JOptionPane.showMessageDialog(this, "Passwords are not the same");
            }
        }
        else if(txtUsername.getText().equals("")) 
        {
            JOptionPane.showMessageDialog(this, "Username field required");
        }
        else if(txtPass.getText().equals("")) 
        {
            JOptionPane.showMessageDialog(this, "Password field required");
        }
        else if(txtConfirmPass.getText().equals("")) 
        {
            JOptionPane.showMessageDialog(this, "Password confirmation required");
        }
    }
    
    private void mDeleteLoginAccount() {
        if(sqlMethods.mDeleteUser("DELETE FROM Users_Login WHERE ID='"+frmLogin.mGetLoginAccount()+"'").equals("Deleted")) 
        {
            JOptionPane.showMessageDialog(this, "Login Account deleted");
            frmLogin.setLocationRelativeTo(null);
            frmLogin.setVisible(true);
            this.setVisible(false);
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

        jDialog1 = new javax.swing.JDialog();
        jTextField1 = new javax.swing.JTextField();
        lblRegister = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblConfirmPassword = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        txtConfirmPass = new javax.swing.JTextField();
        btnReturn = new javax.swing.JButton();
        lblRole = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        cboRole = new javax.swing.JComboBox<>();
        btnDelete = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblRegister.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblRegister.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRegister.setText("Register for login details");

        lblUsername.setText("Username:");

        lblPassword.setText("Password:");

        lblConfirmPassword.setText("Confirm Password:");

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        txtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassActionPerformed(evt);
            }
        });

        btnReturn.setText("Back");
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });

        lblRole.setText("Role:");

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        cboRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrator", "Client" }));

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnDelete)
                        .addGap(20, 20, 20)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblConfirmPassword)
                            .addComponent(lblRole, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                            .addComponent(txtConfirmPass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                            .addComponent(txtPass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                            .addComponent(cboRole, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnReturn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(lblRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblConfirmPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(btnEdit)
                    .addComponent(btnClear)
                    .addComponent(btnDelete))
                .addGap(18, 18, 18)
                .addComponent(btnReturn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if(btnEdit.getText().equals("Edit")) {
            mSetDetailsForUpdate();
            btnEdit.setText("Save");
        } else {
            mSaveUpdate();
            btnEdit.setText("Edit");
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        if(frmMain.strRole != null) {
            frmSelectClient frmSelectClient = new frmSelectClient();
            frmSelectClient.setLocationRelativeTo(null);
            frmSelectClient.setAlwaysOnTop(true);
            frmSelectClient.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            frmSelectClient.setVisible(true);
            this.setVisible(false);
        } 
        else {
            frmLogin.setLocationRelativeTo(null);
            frmLogin.setVisible(true);
            this.setVisible(false);
        }
        
    }//GEN-LAST:event_btnReturnActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        mCreateLoginAccount();
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        mClearTextFields();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        mDeleteLoginAccount();
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(frmRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnReturn;
    private javax.swing.JComboBox<String> cboRole;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblConfirmPassword;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRegister;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextField txtConfirmPass;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
