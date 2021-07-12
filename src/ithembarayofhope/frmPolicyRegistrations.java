/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ithembarayofhope;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Sanele
 */
public class frmPolicyRegistrations extends javax.swing.JFrame {

    /**
     * Creates new form frmPolicyRegistrations
     */
    public frmPolicyRegistrations() {
        initComponents();
        if(frmMain.strRole.equals("Administrator")) {
            sqlMethods.mLoadName("SELECT FName, ID_Num FROM principal_member", cboName);
        }
        else if(frmMain.strRole.equals("Client")) {
            cboName.setVisible(false);
            this.pack();
        }
        sqlMethods.mLoadName("SELECT DISTINCT CoverAmount FROM Covers ORDER BY CoverAmount ASC", cboCoverAmount);
        sqlMethods.mLoadName("SELECT DISTINCT Category FROM Covers ORDER BY Category ASC", cboCategory);
        sqlMethods.mLoadName("SELECT DISTINCT Premium FROM Covers ORDER BY Premium ASC", cboPremium);
        txtDateOfBirth.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    }
    
    int intLoginID;
    String strSurname;
    String strName;
    String strPrincipalMemberIdNum;
    String strPrincipalID;
    String strDateOfBirth;
    String strAddress;
    String strTelephone;
    String strEmail;
    String strCoverAmount;
    String strCategory;
    String strPremium;
    
    
    SQLExecutingMethods sqlMethods = new SQLExecutingMethods();
    frmLogin frmLogin = new frmLogin();
    
    private void mGetValuesFromGUI() {
        strName = txtFirstName.getText();
        strSurname = txtSurname.getText();
        strPrincipalMemberIdNum = txtIDNumber.getText();
        strDateOfBirth = txtDateOfBirth.getText();
        strAddress = txtAddress.getText();
        strTelephone = txtTell.getText();
        strEmail = txtEmail.getText();
        strCoverAmount = cboCoverAmount.getSelectedItem().toString();
        strCategory = cboCategory.getSelectedItem().toString();
        strPremium = cboPremium.getSelectedItem().toString();
    }

    private void mSetValuesInGUI(String strQuery) {
        try {
            String[] arrPolicyDdetails = sqlMethods.mFetchUserDetails(strQuery);
        
            strSurname = arrPolicyDdetails[0];
            strName = arrPolicyDdetails[1];
            strPrincipalID = arrPolicyDdetails[2];
            strDateOfBirth = arrPolicyDdetails[3];
            strAddress = arrPolicyDdetails[4];
            strTelephone = arrPolicyDdetails[5];
            strEmail = arrPolicyDdetails[6];
            strCoverAmount = sqlMethods.mTableField("SELECT CoverAmount FROM Covers WHERE ID="+arrPolicyDdetails[7]);
            strCategory = sqlMethods.mTableField("SELECT Category FROM Covers WHERE ID="+arrPolicyDdetails[7]);
            strPremium = sqlMethods.mTableField("SELECT Premium FROM Covers WHERE ID="+arrPolicyDdetails[7]);
        
            txtSurname.setText(strSurname);
            txtFirstName.setText(strName);
            txtIDNumber.setText(strPrincipalID);
            txtDateOfBirth.setText(strDateOfBirth);
            txtAddress.setText(strAddress);
            txtTell.setText(strTelephone);
            txtEmail.setText(strEmail);
            cboCoverAmount.setSelectedItem(strCoverAmount);
            cboCategory.setSelectedItem(strCategory);
            cboPremium.setSelectedItem(strPremium);
        }
        catch(ArrayIndexOutOfBoundsException e) {
        }
    }
        
    public void mSetLoginID(int intLogin) {
        intLoginID = intLogin;
    }
    
    public void mAdminPolicyEdit() {
        btnCreate.setEnabled(false);
    }

    private boolean mCheckInput() {
        if(txtSurname.getText().equals("")) {
            return false;
            
        } else if(txtFirstName.getText().equals("")) {
            return false;
            
        } else if(txtIDNumber.getText().equals("")) {
            return false;
            
        } else if(txtDateOfBirth.getText().equals("")) {
            return false;
            
        } else if(txtAddress.getText().equals("")) {
            return false;
            
        } else if(txtTell.getText().equals("")) {
            return false;
            
        } else if(txtEmail.getText().equals("")) {
            return false;   
        } 
        return true;
    }
    
    private void mClearTextFields() {
        txtFirstName.setText("");
        txtSurname.setText("");
        txtDateOfBirth.setText("");
        txtAddress.setText("");
        txtTell.setText("");
        txtEmail.setText("");
        txtDateOfBirth.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        txtID.setText("");
    }
                  
    private void mRefreshComboBox() {
        String[] arrArray = new String[0];
        javax.swing.DefaultComboBoxModel model = new javax.swing.DefaultComboBoxModel(arrArray);
        cboName.setModel(model);
        sqlMethods.mLoadName("SELECT FName, ID_Num FROM principal_member", cboName);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        label2 = new java.awt.Label();
        jFrame1 = new javax.swing.JFrame();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtName1 = new javax.swing.JTextField();
        txtSurname1 = new javax.swing.JTextField();
        txtRelationship = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        label4 = new java.awt.Label();
        btnSave1 = new javax.swing.JButton();
        btnClear1 = new javax.swing.JButton();
        btnExit1 = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnLoad = new javax.swing.JButton();
        cboName2 = new javax.swing.JComboBox();
        btnCreate1 = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblSurname = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        lblIDNumber = new javax.swing.JLabel();
        lblDateOfBirth = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblTextphone = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtTell = new javax.swing.JTextField();
        txtIDNumber = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSurname = new javax.swing.JTextField();
        lblPrincipalMembers = new java.awt.Label();
        btnClear = new javax.swing.JButton();
        cboName = new javax.swing.JComboBox();
        btnDelete = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        cboCoverAmount = new javax.swing.JComboBox();
        cboCategory = new javax.swing.JComboBox();
        txtDateOfBirth = new javax.swing.JTextField();
        lblCover = new javax.swing.JLabel();
        lblCoverCategory = new javax.swing.JLabel();
        cboPremium = new javax.swing.JComboBox();
        lblPremium = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        label2.setAlignment(java.awt.Label.CENTER);
        label2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label2.setText("Add Beneficiary");

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel13.setText("Name:");

        jLabel14.setText("Surname:");

        jLabel15.setText("Relationship:");

        jLabel16.setText("ID Number:");

        label4.setAlignment(java.awt.Label.CENTER);
        label4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label4.setText("Add Beneficiary");

        btnSave1.setText("Save");
        btnSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave1ActionPerformed(evt);
            }
        });

        btnClear1.setText("Clear");
        btnClear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClear1ActionPerformed(evt);
            }
        });

        btnExit1.setText("Exit");
        btnExit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExit1ActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");

        btnLoad.setText("Load");

        btnCreate1.setText("Create");
        btnCreate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreate1ActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cboName2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtName1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(txtID)
                            .addComponent(txtRelationship)
                            .addComponent(txtSurname1))))
                .addGap(48, 48, 48))
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(btnCreate1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSave1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLoad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClear1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExit1)))
                .addGap(0, 47, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(36, 36, 36))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtSurname1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtRelationship, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave1)
                    .addComponent(btnEdit)
                    .addComponent(btnLoad)
                    .addComponent(btnCreate1)
                    .addComponent(btnClear1)
                    .addComponent(btnExit1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnBack)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMaximumSize(new java.awt.Dimension(823, 360));
        setMinimumSize(new java.awt.Dimension(823, 360));
        setResizable(false);

        lblSurname.setText("Surname:");

        lblFirstName.setText("First Names:");

        lblIDNumber.setText("ID Number:");

        lblDateOfBirth.setText("Date of Birth:");

        lblAddress.setText("Address:");

        lblTextphone.setText("Telephone:");

        lblEmail.setText("Email:");

        txtFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstNameActionPerformed(evt);
            }
        });

        lblPrincipalMembers.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblPrincipalMembers.setText("Principal Member Registration");

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        cboName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNameActionPerformed(evt);
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

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        cboCoverAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCoverAmountActionPerformed(evt);
            }
        });

        cboCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCategoryActionPerformed(evt);
            }
        });

        lblCover.setText("Cover:");

        lblCoverCategory.setText("Category:");

        lblPremium.setText("Premium:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPrincipalMembers, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(248, 248, 248))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTextphone)
                                    .addComponent(lblCover, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cboCoverAmount, 0, 263, Short.MAX_VALUE)
                                    .addComponent(txtTell))))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEmail)
                                .addGap(55, 55, 55)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(lblCoverCategory)
                                        .addGap(34, 34, 34)
                                        .addComponent(cboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(lblPremium, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                    .addComponent(cboPremium, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblIDNumber)
                            .addComponent(lblSurname)
                            .addComponent(lblAddress))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIDNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDateOfBirth)
                                    .addComponent(lblFirstName))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDateOfBirth, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFirstName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtAddress)))
                    .addComponent(cboName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPrincipalMembers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSurname)
                        .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIDNumber)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIDNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDateOfBirth)
                        .addComponent(txtDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTextphone)
                    .addComponent(txtTell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCover, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboCoverAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCoverCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboPremium, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPremium))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnClear))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstNameActionPerformed

    private void cboNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboNameActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        if(mCheckInput()) 
        {
            try {
                if(Period.between((LocalDate.parse(txtDateOfBirth.getText().trim())),
                            LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date()))).getYears() < 18 
                        || Period.between((LocalDate.parse(txtDateOfBirth.getText().trim())),
                                LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date()))).getYears() >= 65) {
                    
                    JOptionPane.showMessageDialog(this, "Policy cover is for members under 65 years");
                } else {
                    mGetValuesFromGUI();
                    int intCover = Integer.parseInt(sqlMethods.mTableField("SELECT ID FROM Covers WHERE CoverAmount ="+strCoverAmount+" AND Category ='"+strCategory+"' AND Premium="+strPremium));
            
                    if(frmMain.strRole.equals("Client")) 
                    {
                        if(!sqlMethods.mCheckIfItemsExistInTable("SELECT * FROM Principal_Member WHERE LName ='"+strSurname+"' AND FName ='"+strName+"' AND ID_Num ='"+strPrincipalMemberIdNum+"'")) 
                        {
                            if(sqlMethods.mCreateUser("INSERT INTO Principal_Member(ID_Num, LName, FName, DOB, Address, Tel, Email, CoverID, Login)"
                                + "VALUES('"+strPrincipalMemberIdNum+"','"+strName+"','"+strSurname+"','"+strDateOfBirth+"','"+strAddress+"','"+strTelephone+"','"+strEmail+"','"+intCover+"','"+frmLogin.mGetLoginAccount()+"')").equals("Created")) 
                            {
                    
                                JOptionPane.showMessageDialog(this, "Policy created successfully.");
                            }
                        } 
                        else {
                            JOptionPane.showMessageDialog(this, "Policy exists.");
                        }
                    } 
                    else if(frmMain.strRole.equals("Administrator")) 
                    {
                        if(!sqlMethods.mCheckIfItemsExistInTable("SELECT * FROM Principal_Member WHERE LName ='"+strSurname+"' AND FName ='"+strName+"' AND ID_Num ='"+strPrincipalMemberIdNum+"'")) 
                        {
                            if(sqlMethods.mCreateUser("INSERT INTO Principal_Member(ID_Num, LName, FName, DOB, Address, Tel, Email, CoverID, Login)"
                                + "VALUES('"+strPrincipalMemberIdNum+"','"+strName+"','"+strSurname+"','"+strDateOfBirth+"','"+strAddress+"','"+strTelephone+"','"+strEmail+"','"+intCover+"','"+intLoginID+"')").equals("Created")) 
                            {
                    
                                JOptionPane.showMessageDialog(this, "Policy created successfully.");
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(this, "Policy exists.");
                        }
                    }
                }
            } catch(DateTimeException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
        else if(txtSurname.getText().equals("")) 
        {
            JOptionPane.showMessageDialog(null, "Surname field required.");
        }
        else if(txtFirstName.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "First name field required.");
        }
        else if(txtIDNumber.getText().equals("")) 
        {
            JOptionPane.showMessageDialog(null, "ID number required.");
        } 
        else if(txtDateOfBirth.getText().equals("")) 
        {
            JOptionPane.showMessageDialog(null, "Date of Birth required.");
        } 
        else if(txtAddress.getText().equals("")) 
        {
            JOptionPane.showMessageDialog(null, "Address field required.");
        }
        else if(txtTell.getText().equals("")) 
        {
            JOptionPane.showMessageDialog(null, "Telephone field required.");
        } 
        else if(txtEmail.getText().equals("")) 
        {
            JOptionPane.showMessageDialog(null, "Email field required.");   
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(frmMain.strRole.equals("Client")) {
            if(sqlMethods.mCheckIfItemsExistInTable("SELECT PM_ID_Num FROM Beneficiaries WHERE PM_ID_Num='"+sqlMethods.mTableField("SELECT ID_Num FROM Principal_Member WHERE Login="+
                                frmLogin.mGetLoginAccount())+"'")) {
                JOptionPane.showMessageDialog(this, "Delete beneficiaries registered under this policy first");
            } 
            else if(sqlMethods.mDeleteUser("DELETE FROM Principal_Member WHERE Login="+frmLogin.mGetLoginAccount()).equals("Deleted")) {
                JOptionPane.showMessageDialog(this, "Policy deleted");
            }
        }
        else if(frmMain.strRole.equals("Administrator")) {
            if(sqlMethods.mCheckIfItemsExistInTable("SELECT Login FROM Principal_Member WHERE Login="+intLoginID)) {
                if(sqlMethods.mCheckIfItemsExistInTable("SELECT PM_ID_Num FROM Beneficiaries WHERE PM_ID_Num='"+sqlMethods.mTableField("SELECT ID_Num FROM Principal_Member WHERE Login="+
                                intLoginID)+"'")) {
                    JOptionPane.showMessageDialog(this, "Delete beneficiaries registered under this policy first");
                }
                else if(sqlMethods.mDeleteUser("DELETE FROM Principal_Member WHERE Login="+intLoginID).equals("Deleted")) {
                    JOptionPane.showMessageDialog(this, "Policy deleted");
                }
            }
            else {
                JOptionPane.showMessageDialog(this, 
                        sqlMethods.mTableField("SELECT Username FROM Users_Login WHERE ID="+intLoginID)+" does not have a principal policy.");               
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if(btnUpdate.getText().equals("Update")) {
            
            switch(frmMain.strRole) {
                case "Client":
                    mSetValuesInGUI(
                            "SELECT LName, FName, ID_Num, DOB, Address, Tel, Email, CoverID FROM Principal_Member WHERE Login="+
                                    frmLogin.mGetLoginAccount());
                    btnUpdate.setText("Save");
                    break;
                    
                case "Administrator":
                    mSetValuesInGUI(
                            "SELECT LName, FName, ID_Num, DOB, Address, Tel, Email, CoverID FROM Principal_Member WHERE ID_Num="+
                                    cboName.getSelectedItem().toString().substring(cboName.getSelectedItem().toString().indexOf(" "), cboName.getSelectedItem().toString().length()).trim());
                    btnUpdate.setText("Save");
                    break;
            }
            
        } 
        else if(btnUpdate.getText().equals("Save")) {
            if(mCheckInput()) 
            {
                try {
                    if(Period.between((LocalDate.parse(txtDateOfBirth.getText().trim())),
                                LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date()))).getYears() < 18 
                            || Period.between((LocalDate.parse(txtDateOfBirth.getText().trim())),
                                    LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date()))).getYears() >= 65)
                    {
                        JOptionPane.showMessageDialog(this, "Policy cover is for members under 65 years");
                    }
                    else {
                        mGetValuesFromGUI();
                        if(frmMain.strRole.equals("Client")) 
                        {
                    
                            if(sqlMethods.mUpdateUser("UPDATE Principal_Member SET LName ='"+
                                    strSurname+"', FName ='"+strName+"', ID_Num ='"+strPrincipalMemberIdNum+"', Address ='"+
                                    strAddress+"', Tel ='"+strTelephone+"', Email ='"+strEmail+"', CoverID ='"+
                                    sqlMethods.mTableField("SELECT ID FROM Covers WHERE CoverAmount ='"+
                                            strCoverAmount+"' AND Category ='"+strCategory+"' AND Premium="+
                                            strPremium)+"' WHERE ID_Num ='"+
                                    sqlMethods.mTableField("SELECT ID_Num FROM Principal_Member WHERE Login="+
                                        frmLogin.mGetLoginAccount())+"'").equals("Updated")) {
                        
                                btnEdit.setText("Update");
                                JOptionPane.showMessageDialog(this, "Policy updated");
                            }
                        }    
                        else if(frmMain.strRole.equals("Administrator")) 
                        {
                            if(sqlMethods.mUpdateUser("UPDATE Principal_Member SET LName ='"+
                                    strSurname+"', FName ='"+strName+"', ID_Num ='"+strPrincipalMemberIdNum+"', Address ='"+
                                    strAddress+"', Tel ='"+strTelephone+"', Email ='"+strEmail+"', CoverID ='"+
                                    sqlMethods.mTableField("SELECT ID FROM Covers WHERE CoverAmount ='"+
                                        strCoverAmount+"' AND Category ='"+strCategory+"' AND Premium="+
                                            strPremium)+"' WHERE ID_Num ='"+
                                    strPrincipalID+"'").equals("Updated")) {
                        
                                btnEdit.setText("Update");
                                JOptionPane.showMessageDialog(this, "Policy updated");
                            }
                        }
                    }
                } catch(DateTimeException e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
            }
            else if(txtSurname.getText().equals("")) 
            {
                JOptionPane.showMessageDialog(null, "Surname field required.");
            }
            else if(txtFirstName.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "First name field required.");
            }
            else if(txtIDNumber.getText().equals("")) 
            {
                JOptionPane.showMessageDialog(null, "ID number required.");
            } 
            else if(txtDateOfBirth.getText().equals("")) 
            {
                JOptionPane.showMessageDialog(null, "Date of Birth required.");
            } 
            else if(txtAddress.getText().equals("")) 
            {
                JOptionPane.showMessageDialog(null, "Address field required.");
            }
            else if(txtTell.getText().equals("")) 
            {
                JOptionPane.showMessageDialog(null, "Telephone field required.");
            } 
            else if(txtEmail.getText().equals("")) 
            {   
                JOptionPane.showMessageDialog(null, "Email field required.");   
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void cboCoverAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCoverAmountActionPerformed
        
    }//GEN-LAST:event_cboCoverAmountActionPerformed

    private void cboCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCategoryActionPerformed
        
    }//GEN-LAST:event_cboCategoryActionPerformed

    private void btnSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave1ActionPerformed
        
    }//GEN-LAST:event_btnSave1ActionPerformed

    private void btnClear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClear1ActionPerformed
        
    }//GEN-LAST:event_btnClear1ActionPerformed

    private void btnExit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExit1ActionPerformed
        
    }//GEN-LAST:event_btnExit1ActionPerformed

    private void btnCreate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreate1ActionPerformed
        
    }//GEN-LAST:event_btnCreate1ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        mClearTextFields();
        mRefreshComboBox();
    }//GEN-LAST:event_btnClearActionPerformed

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
            java.util.logging.Logger.getLogger(frmPolicyRegistrations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPolicyRegistrations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPolicyRegistrations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPolicyRegistrations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPolicyRegistrations().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClear1;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnCreate1;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit1;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnSave1;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox cboCategory;
    private javax.swing.JComboBox cboCoverAmount;
    private javax.swing.JComboBox cboName;
    private javax.swing.JComboBox cboName2;
    private javax.swing.JComboBox cboPremium;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label2;
    private java.awt.Label label4;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblCover;
    private javax.swing.JLabel lblCoverCategory;
    private javax.swing.JLabel lblDateOfBirth;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblIDNumber;
    private javax.swing.JLabel lblPremium;
    private java.awt.Label lblPrincipalMembers;
    private javax.swing.JLabel lblSurname;
    private javax.swing.JLabel lblTextphone;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtDateOfBirth;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDNumber;
    private javax.swing.JTextField txtName1;
    private javax.swing.JTextField txtRelationship;
    private javax.swing.JTextField txtSurname;
    private javax.swing.JTextField txtSurname1;
    private javax.swing.JTextField txtTell;
    // End of variables declaration//GEN-END:variables

  
}
