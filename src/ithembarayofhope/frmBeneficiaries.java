/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ithembarayofhope;

import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class frmBeneficiaries extends javax.swing.JFrame {

    /**
     * Creates new form frmBeneficiary
     */
    public frmBeneficiaries() {
        initComponents();
        switch(frmMain.strRole) {
            case "Client":
                sqlMethods.mLoadName("SELECT IDNum, FName FROM Beneficiaries WHERE PM_ID_Num ='"+
                        sqlMethods.mTableField("SELECT ID_Num FROM Principal_Member WHERE Login='"+
                                frmLogin.mGetLoginAccount()+"'")+"'", cboIDNumber);
                
                sqlMethods.mLoadName("SELECT ID_Num FROM Principal_Member WHERE Login ='"+
                        frmLogin.mGetLoginAccount()+"'", cboPrincipalID);
                break;
                
            case "Administrator":
                sqlMethods.mLoadName("SELECT IDNum, FName FROM Beneficiaries", cboIDNumber);
                sqlMethods.mLoadName("SELECT ID_Num FROM Principal_Member", cboPrincipalID);
                break;
        }
    }
    
    String strPM_ID_Num;
    String strID_Num;
    String strSelectedIDNum;
    String strFName;
    String strLName;
    String strRelationship;
    
    frmLogin frmLogin = new frmLogin();
    SQLExecutingMethods sqlMethods = new SQLExecutingMethods();
    
    private void mGetValuesFromGUI()
    {
        strFName = txtName.getText();
        strLName = txtSurname.getText();
        strRelationship = txtRelationship.getText();
        strID_Num = txtID.getText();
        strPM_ID_Num = cboPrincipalID.getSelectedItem().toString();
    }
    
    private void mSetValuesInGUI()
    {
        try {
            strSelectedIDNum = cboIDNumber.getSelectedItem().toString().substring(0, 
                                cboIDNumber.getSelectedItem().toString().indexOf(" ")).trim();
                
            String[] arrBeneficiary = sqlMethods.mFetchUserDetails(
                    "SELECT FName, LName, Relationship, IDNum, PM_ID_Num FROM Beneficiaries WHERE IDNum='"+
                        strSelectedIDNum+"'");
        
            strFName = arrBeneficiary[0];
            strLName = arrBeneficiary[1];
            strRelationship = arrBeneficiary[2];
            strID_Num = arrBeneficiary[3];
            strPM_ID_Num = arrBeneficiary[4];
        
            txtName.setText(strFName);
            txtSurname.setText(strLName);
            txtRelationship.setText(strRelationship);
            txtID.setText(strID_Num);
            cboPrincipalID.setSelectedItem(strPM_ID_Num);
        }
        catch(ArrayIndexOutOfBoundsException e) {
        }
    }
    
    private void mClearTextFields()
    {
        txtName.setText("");
        txtSurname.setText("");
        txtRelationship.setText("");
        txtID.setText("");
    }
    
    private boolean mCheckInput() {
        if(txtName.getText().equals("")) {
            return false;
        }
        else if(txtSurname.getText().equals("")) {
            return false;
        }
        else if(txtID.getText().equals("")) {
            return false;
        }
        else if(txtRelationship.getText().equals("")) {
            return false;
        }
        return true;
    }
    
    private void mCreateBeneficiary() {
        if(mCheckInput()) {
            mGetValuesFromGUI();
            if(sqlMethods.mCheckIfItemsExistInTable("SELECT * FROM Beneficiaries WHERE FName ='"+strFName+"' AND LName='"+strLName+"' OR IDNum='"+strID_Num+"'")) {
                JOptionPane.showMessageDialog(this, "Beneficiary exists");
            }
            else if(sqlMethods.mCreateUser("INSERT INTO Beneficiaries(IDNum, FName, LName, Relationship, PM_ID_Num)"
                    + "VALUES('"+strID_Num+"','"+strFName+"','"+strLName+"','"+strRelationship+"','"+strPM_ID_Num+"')").equals("Created")) {
                
                JOptionPane.showMessageDialog(this, "Beneficiary created");
            }
        } 
        else if(txtName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Name field required");
        }
        else if(txtSurname.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Surname field required");
        }
        else if(txtID.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "ID field required");
        }
        else if(txtRelationship.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Relationship field required");
        }
    }
    
    private void mSaveUpdate() {
        if(mCheckInput()) {
            mGetValuesFromGUI();
            if(sqlMethods.mUpdateUser("UPDATE Beneficiaries SET IDNum ='"+
                    strID_Num+"', FName ='"+strFName+"', LName ='"+strLName+
                    "', Relationship ='"+strRelationship+"', PM_ID_Num ='"+
                    strPM_ID_Num+"' WHERE IDNum ='"+strSelectedIDNum+"'").equals("Updated")) {
                
                JOptionPane.showMessageDialog(this, "Beneficiary Updated");
            }
        } 
        else if(txtName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Name field required");
        }
        else if(txtSurname.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Surname field required");
        }
        else if(txtID.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "ID field required");
        }
        else if(txtRelationship.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Relationship field required");
        }
    }
    
    private void mDeleteBeneficiary() {
        strSelectedIDNum = cboIDNumber.getSelectedItem().toString().substring(0, 
                                cboIDNumber.getSelectedItem().toString().indexOf(" ")).trim();
        
        if(sqlMethods.mDeleteUser("DELETE FROM Beneficiaries WHERE IDNum ='"+strSelectedIDNum+"'").equals("Deleted")) {
            JOptionPane.showMessageDialog(this, "Beneficiary deleted");
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

        jLabel1 = new javax.swing.JLabel();
        lblSurname = new javax.swing.JLabel();
        lblRelationship = new javax.swing.JLabel();
        lblIDNumber = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtSurname = new javax.swing.JTextField();
        txtRelationship = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        lblBeneficiaries = new java.awt.Label();
        btnEdit = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        cboIDNumber = new javax.swing.JComboBox();
        btnCreate = new javax.swing.JButton();
        lblIPrincipalDNumber = new javax.swing.JLabel();
        cboPrincipalID = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Name:");

        lblSurname.setText("Surname:");

        lblRelationship.setText("Relationship:");

        lblIDNumber.setText("ID Number:");

        txtRelationship.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRelationshipActionPerformed(evt);
            }
        });

        lblBeneficiaries.setAlignment(java.awt.Label.CENTER);
        lblBeneficiaries.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblBeneficiaries.setText("Beneficiary");

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        lblIPrincipalDNumber.setText("Principal ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(lblBeneficiaries, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCreate)
                        .addGap(45, 45, 45)
                        .addComponent(btnEdit)
                        .addGap(50, 50, 50)
                        .addComponent(btnDelete)
                        .addGap(45, 45, 45)
                        .addComponent(btnClear))
                    .addComponent(cboIDNumber, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIDNumber)
                            .addComponent(lblRelationship)
                            .addComponent(lblSurname)
                            .addComponent(jLabel1)
                            .addComponent(lblIPrincipalDNumber))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(txtID)
                            .addComponent(txtRelationship)
                            .addComponent(txtSurname)
                            .addComponent(cboPrincipalID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBeneficiaries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(cboIDNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSurname)
                    .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRelationship)
                    .addComponent(txtRelationship, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIDNumber)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIPrincipalDNumber)
                    .addComponent(cboPrincipalID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete)
                    .addComponent(btnCreate)
                    .addComponent(btnClear))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        mClearTextFields();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
       if(btnEdit.getText().equals("Edit")) {
           mSetValuesInGUI();
           btnEdit.setText("Save");
       }
       else if(btnEdit.getText().equals("Save")) {
           mSaveUpdate();
           btnEdit.setText("Edit");
       }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        mCreateBeneficiary();
    }//GEN-LAST:event_btnCreateActionPerformed

    private void txtRelationshipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRelationshipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRelationshipActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        mDeleteBeneficiary();
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
            java.util.logging.Logger.getLogger(frmBeneficiaries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBeneficiaries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBeneficiaries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBeneficiaries.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmBeneficiaries().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JComboBox cboIDNumber;
    private javax.swing.JComboBox<String> cboPrincipalID;
    private javax.swing.JLabel jLabel1;
    private java.awt.Label lblBeneficiaries;
    private javax.swing.JLabel lblIDNumber;
    private javax.swing.JLabel lblIPrincipalDNumber;
    private javax.swing.JLabel lblRelationship;
    private javax.swing.JLabel lblSurname;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtRelationship;
    private javax.swing.JTextField txtSurname;
    // End of variables declaration//GEN-END:variables
}
