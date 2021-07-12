/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ithembarayofhope;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Sanele
 */
public class SearchFilter extends JDialog{
    public SearchFilter(JFrame frmParent) {
        super(frmParent, "Select Alphabet to Filter by", Dialog.ModalityType.APPLICATION_MODAL);
        this.setSize(500, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        mCreateDialogWindow();
    }
    
    private void mCreateDialogWindow() {
        JPanel jpParentPanel = new JPanel(new BorderLayout(0, 20));
        jpParentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
            
        jpParentPanel.add(new JLabel("Select Alphabet to Filter search by:"), BorderLayout.NORTH);
        
        JPanel jpPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        
        for (char c = 'A'; c <= 'Z'; c++) {
            jpPanel.add(mButton("" + c));
        }
        jpParentPanel.add(jpPanel, BorderLayout.CENTER);
        this.add(jpParentPanel);
    }
            
    private JButton mButton(String strText) {
        JButton btnButton = new JButton(strText);
        btnButton.setPreferredSize(new Dimension(50, 30));
        btnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
                frmViewDatabaseTable frmViewPrincipalMembers = new frmViewDatabaseTable(
                        "SELECT ID_Num, LName, FName, DOB, Address, Tel, Email, CoverID FROM Principal_Member WHERE FName LIKE '%"+
                                strText+"%' OR LName LIKE '%"+strText+"%'");
                frmViewPrincipalMembers.setLocationRelativeTo(null);
                frmViewPrincipalMembers.setAlwaysOnTop(true);
                frmViewPrincipalMembers.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                frmViewPrincipalMembers.setVisible(true);
                SearchFilter.this.setVisible(false);
            }
        });
        return btnButton;
    }
    
}
