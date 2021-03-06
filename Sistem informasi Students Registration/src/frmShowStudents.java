import java.awt.Color;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
 
public class frmShowStudents extends javax.swing.JInternalFrame {
    public static frmShowStudents frame = new frmShowStudents();
    public frmMain ma = new frmMain();
    public frmShowStudents() {
        initComponents();
        ShowStudents();
        setButtonDis();
        DisAble();
        OriginalColor();
      //  PInfo.setVisible(false);
    }
    frmEditStudent fe = new frmEditStudent();
    public String ID;
    Vector StudID = new Vector();
    Vector lname = new Vector();
    Vector fname = new Vector();
    Vector mname = new Vector();
    Vector gender = new Vector();
    Vector address = new Vector();
    Vector contact = new Vector();
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudents = new javax.swing.JTable();
        cmdEdit = new javax.swing.JButton();
        cmdDelete = new javax.swing.JButton();
        cmdClose = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cmdRefresh = new javax.swing.JButton();
        PInfo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtLName = new javax.swing.JTextField();
        txtFName = new javax.swing.JTextField();
        txtMName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtContact = new javax.swing.JTextField();
        cmdUpdate = new javax.swing.JButton();
        cmbGender = new javax.swing.JComboBox();

        setClosable(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
        jLabel7.setText("Student's Information Section");
        jLabel7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel7MouseMoved(evt);
            }
        });

        tblStudents.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tblStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Student ID", "Last Name", "First Name", "Middle Name", "Gender", "Address", "Contact Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStudents.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblStudentsMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblStudentsMouseReleased(evt);
            }
        });
        tblStudents.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                tblStudentsMouseMoved(evt);
            }
        });
        tblStudents.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblStudentsKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblStudentsKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblStudents);

        cmdEdit.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cmdEdit.setText("Edit Selected");
        cmdEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdEdit.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cmdEditMouseMoved(evt);
            }
        });
        cmdEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEditActionPerformed(evt);
            }
        });

        cmdDelete.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cmdDelete.setText("Delete Selected");
        cmdDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdDelete.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cmdDeleteMouseMoved(evt);
            }
        });
        cmdDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteActionPerformed(evt);
            }
        });

        cmdClose.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cmdClose.setText("Close");
        cmdClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdClose.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cmdCloseMouseMoved(evt);
            }
        });
        cmdClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCloseActionPerformed(evt);
            }
        });

        txtSearch.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSearchFocusLost(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Search for Last Name :");

        cmdRefresh.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cmdRefresh.setText("Refresh");
        cmdRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdRefresh.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cmdRefreshMouseMoved(evt);
            }
        });
        cmdRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdRefreshActionPerformed(evt);
            }
        });

        PInfo.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Student Information :");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("Last Name :");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("First Name :");

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setText("Middle Name :");

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setText("Gender :");

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel9.setText("Address :");

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel10.setText("Contact Number :");

        txtLName.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtLName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLNameFocusLost(evt);
            }
        });

        txtFName.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtFName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFNameFocusLost(evt);
            }
        });

        txtMName.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtMName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMNameFocusLost(evt);
            }
        });

        txtAddress.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAddressFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAddressFocusLost(evt);
            }
        });

        txtContact.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtContact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtContactFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContactFocusLost(evt);
            }
        });

        cmdUpdate.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cmdUpdate.setText("Update");
        cmdUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdUpdate.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cmdUpdateMouseMoved(evt);
            }
        });
        cmdUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUpdateActionPerformed(evt);
            }
        });

        cmbGender.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cmbGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Female", "Male" }));
        cmbGender.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbGenderFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbGenderFocusLost(evt);
            }
        });

        javax.swing.GroupLayout PInfoLayout = new javax.swing.GroupLayout(PInfo);
        PInfo.setLayout(PInfoLayout);
        PInfoLayout.setHorizontalGroup(
            PInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMName)
                    .addComponent(txtLName, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(txtFName))
                .addGap(61, 61, 61)
                .addGroup(PInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PInfoLayout.createSequentialGroup()
                        .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        PInfoLayout.setVerticalGroup(
            PInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PInfoLayout.createSequentialGroup()
                        .addGroup(PInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtLName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(cmbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(PInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(PInfoLayout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel9)))
                                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtFName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)
                                .addComponent(cmdUpdate))
                            .addGroup(PInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtMName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))))
                    .addComponent(jLabel3))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1161, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                        .addComponent(cmdEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(cmdDelete)
                        .addGap(18, 18, 18)
                        .addComponent(cmdRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(cmdClose, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(431, 431, 431)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdClose, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(cmdEdit)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdDelete)
                    .addComponent(cmdRefresh))
                .addGap(28, 28, 28)
                .addComponent(PInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCloseActionPerformed
        
        int rowStudents =0;
        DefaultTableModel tStudents = (DefaultTableModel)tblStudents.getModel();
        tStudents.setRowCount(rowStudents);
        ShowStudents();
        this.dispose();
        
    }//GEN-LAST:event_cmdCloseActionPerformed

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        txtSearch.setBackground(Color.GRAY);
    }//GEN-LAST:event_txtSearchFocusGained

    private void txtSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusLost
        txtSearch.setBackground(Color.white);
    }//GEN-LAST:event_txtSearchFocusLost

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        SearchStudent();
     //   setButtonDis();
    }//GEN-LAST:event_txtSearchKeyPressed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        SearchStudent();
    }//GEN-LAST:event_txtSearchKeyReleased

    private void tblStudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentsMouseClicked
        getID();
        cmdEdit.setEnabled(true);
        cmdDelete.setEnabled(true);
    }//GEN-LAST:event_tblStudentsMouseClicked

    private void tblStudentsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentsMousePressed
        getID();
    }//GEN-LAST:event_tblStudentsMousePressed

    private void cmdEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEditActionPerformed
      // PInfo.setVisible(true);
        EnAble();
        setButtonDis();
    }//GEN-LAST:event_cmdEditActionPerformed

    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteActionPerformed
        DeleteMe();
        ShowStudents();
        setButtonDis();
        
    }//GEN-LAST:event_cmdDeleteActionPerformed

    private void tblStudentsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentsMouseReleased
        getID();
    }//GEN-LAST:event_tblStudentsMouseReleased

    private void cmdRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdRefreshActionPerformed
        ShowStudents();
        DisAble();
    }//GEN-LAST:event_cmdRefreshActionPerformed

    private void tblStudentsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblStudentsKeyPressed
        getID();
    }//GEN-LAST:event_tblStudentsKeyPressed

    private void tblStudentsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblStudentsKeyReleased
        getID();
    }//GEN-LAST:event_tblStudentsKeyReleased

    private void txtLNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLNameFocusGained
         txtLName.setBackground(Color.GRAY);
    }//GEN-LAST:event_txtLNameFocusGained

    private void txtLNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLNameFocusLost
        txtLName.setBackground(Color.WHITE);
    }//GEN-LAST:event_txtLNameFocusLost

    private void txtFNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFNameFocusGained
        txtFName.setBackground(Color.GRAY);
    }//GEN-LAST:event_txtFNameFocusGained

    private void txtFNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFNameFocusLost
        txtFName.setBackground(Color.WHITE);
    }//GEN-LAST:event_txtFNameFocusLost

    private void txtMNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMNameFocusGained
        txtMName.setBackground(Color.GRAY);
    }//GEN-LAST:event_txtMNameFocusGained

    private void txtMNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMNameFocusLost
        txtMName.setBackground(Color.WHITE);
    }//GEN-LAST:event_txtMNameFocusLost

    private void txtAddressFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAddressFocusGained
        txtAddress.setBackground(Color.GRAY);
    }//GEN-LAST:event_txtAddressFocusGained

    private void txtAddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAddressFocusLost
        txtAddress.setBackground(Color.WHITE);
    }//GEN-LAST:event_txtAddressFocusLost

    private void txtContactFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContactFocusGained
        txtContact.setBackground(Color.GRAY);
    }//GEN-LAST:event_txtContactFocusGained

    private void txtContactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContactFocusLost
        txtContact.setBackground(Color.WHITE);
    }//GEN-LAST:event_txtContactFocusLost

    private void jLabel7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel7MouseMoved

    private void cmdEditMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdEditMouseMoved
        if(cmdEdit.isEnabled()==true)
            cmdEdit.setBackground(Color.GRAY); 
        else
            cmdEdit.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_cmdEditMouseMoved

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        OriginalColor();
    }//GEN-LAST:event_formMouseMoved

    private void cmdDeleteMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdDeleteMouseMoved
        if(cmdDelete.isEnabled()==true)
            cmdDelete.setBackground(Color.GRAY); 
        else
            cmdDelete.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_cmdDeleteMouseMoved

    private void cmdRefreshMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdRefreshMouseMoved
        cmdRefresh.setBackground(Color.GRAY);
    }//GEN-LAST:event_cmdRefreshMouseMoved

    private void cmdCloseMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdCloseMouseMoved
        cmdClose.setBackground(Color.GRAY);
    }//GEN-LAST:event_cmdCloseMouseMoved

    private void cmdUpdateMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdUpdateMouseMoved
         if(cmdUpdate.isEnabled()==true)
            cmdUpdate.setBackground(Color.GRAY); 
        else
            cmdUpdate.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_cmdUpdateMouseMoved

    private void cmdUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUpdateActionPerformed
        UpdateRecord();
    }//GEN-LAST:event_cmdUpdateActionPerformed

    private void tblStudentsMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentsMouseMoved
        OriginalColor();
    }//GEN-LAST:event_tblStudentsMouseMoved

    private void cmbGenderFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbGenderFocusGained
        cmbGender.setBackground(Color.GRAY);
}//GEN-LAST:event_cmbGenderFocusGained

    private void cmbGenderFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbGenderFocusLost
        cmbGender.setBackground(Color.white);
}//GEN-LAST:event_cmbGenderFocusLost
    
    public void OriginalColor()
    {

        cmdEdit.setBackground(Color.LIGHT_GRAY);
        cmdClose.setBackground(Color.LIGHT_GRAY);
        cmdDelete.setBackground(Color.LIGHT_GRAY);
        cmdRefresh.setBackground(Color.LIGHT_GRAY);
        cmdUpdate.setBackground(Color.LIGHT_GRAY);
    }
    
    public void UpdateRecord()
    {
        try
        {
            int DelMe;
            DelMe = JOptionPane.showConfirmDialog(null, "Are you sure you want to Update this record?", "Delete?", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if(DelMe == JOptionPane.YES_OPTION)
            {
                clsConnection conn = new clsConnection();
                Connection connect = clsConnection.conn;
                Statement stm = connect.createStatement();
                stm.execute("Update tblStudents set LName ='"+ txtLName.getText().toString().toUpperCase()  +"', FNmae = '"+ txtFName.getText().toString().toUpperCase() +"',"
                        + " MName='"+ txtMName.getText().toString().toUpperCase() +"',Gender = '"+ cmbGender.getSelectedItem().toString().toUpperCase()+"',"
                        + " Address ='"+txtAddress.getText().toString().toUpperCase()+"',ContactNo='"+ txtContact.getText().toString().toUpperCase() +"'"
                        + " where StudID ="+ Integer.parseInt(ID) +"");
                JOptionPane.showMessageDialog(null, "Update Record Successful.", "Delete", JOptionPane.INFORMATION_MESSAGE);
                ShowStudents();
                connect.close();
                EnAble();
                DisAble();
            }
            
        }catch(SQLException sqlException){
            JOptionPane.showMessageDialog(getContentPane(),"Error in database connection"+sqlException,"sqlException",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void DeleteMe()
    {
        try
        {
            int DelMe;
            DelMe = JOptionPane.showConfirmDialog(null, "Are you sure you want to Delete this record?", "Delete?", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if(DelMe == JOptionPane.YES_OPTION)
            {
                clsConnection conn = new clsConnection();
                Connection connect = clsConnection.conn;
                Statement stm = connect.createStatement();
                stm.execute("Delete from tblStudents where StudID = "+ ID);
                JOptionPane.showMessageDialog(null, "Delete Record Successful.", "Delete", JOptionPane.INFORMATION_MESSAGE);
                ShowStudents();
                connect.close();
                EnAble();
                DisAble();
            }
            
        }catch(SQLException sqlException){
            JOptionPane.showMessageDialog(getContentPane(),"Error in database connection"+sqlException,"sqlException",JOptionPane.ERROR_MESSAGE);
        }
    }
   
    public void getID()
    {
         ID = this.tblStudents.getModel().getValueAt(this.tblStudents.getSelectedRow(),0).toString();
         txtLName.setText(this.tblStudents.getModel().getValueAt(this.tblStudents.getSelectedRow(),1).toString());
         txtFName.setText(this.tblStudents.getModel().getValueAt(this.tblStudents.getSelectedRow(),2).toString());
         txtMName.setText(this.tblStudents.getModel().getValueAt(this.tblStudents.getSelectedRow(),3).toString());
         String gen;
         gen = this.tblStudents.getModel().getValueAt(this.tblStudents.getSelectedRow(),4).toString();
         if(gen.equals("FEMALE")|| gen.equals("Female"))
            cmbGender.setSelectedItem("Female");
         else
             cmbGender.setSelectedItem("Male");
         txtAddress.setText(this.tblStudents.getModel().getValueAt(this.tblStudents.getSelectedRow(),5).toString());
         txtContact.setText(this.tblStudents.getModel().getValueAt(this.tblStudents.getSelectedRow(),6).toString());
         
    }
        public void DisAble()
    {
        cmdDelete.setEnabled(false);
        cmdEdit.setEnabled(false);
        txtLName.setText("");
        txtLName.setBackground(Color.GRAY);
        txtFName.setText("");
        txtFName.setBackground(Color.GRAY);
        txtMName.setText("");
        txtMName.setBackground(Color.GRAY);
        txtAddress.setText("");
        txtAddress.setBackground(Color.GRAY);
        txtContact.setText("");
        txtContact.setBackground(Color.GRAY);
        txtLName.enable(false);
        txtFName.enable(false);
        txtMName.enable(false);
        txtAddress.enable(false);
        txtContact.enable(false);
        cmbGender.setEnabled(false);
        cmdUpdate.setEnabled(false);
        txtSearch.setText("");
    //    cmbGender.setBackground(Color.GRAY);
    }
    public void EnAble()
    {

      //  txtLName.setText("");
        txtLName.setBackground(Color.WHITE);
      //  txtFName.setText("");
        txtFName.setBackground(Color.WHITE);
       // txtMName.setText("");
        txtMName.setBackground(Color.WHITE);
       // txtAddress.setText("");
        txtAddress.setBackground(Color.WHITE);
      //  txtContact.setText("");
        txtContact.setBackground(Color.WHITE);
        txtLName.enable(true);
        txtFName.enable(true);
        txtMName.enable(true);
        txtAddress.enable(true);
        txtContact.enable(true);
        cmbGender.setEnabled(true);
        cmbGender.setBackground(Color.WHITE);
        cmdUpdate.setEnabled(true);
    }
    public void setButtonDis()
    {
        cmdEdit.setEnabled(false);
        cmdDelete.setEnabled(false);
    }
    public void ShowStudents(){
    String sql1 = "";
    String sql2 = "";
    try {
       clsConnection conn = new clsConnection();
       Connection connect = clsConnection.conn;
       Statement stm = connect.createStatement();

       sql1 = "Select count(*) from tblStudents order by lname";
       sql2 = "select * from tblStudents order by lname";
       ResultSet rs1, rs2;

       rs1 = stm.executeQuery(sql1);

       int num = 0;
       if (rs1.next()) {
        num = Integer.parseInt(rs1.getString(1).trim());
       }
       if (num > 0) {
            int i = 0;
            rs2 = stm.executeQuery(sql2);
            StudID.clear(); lname.clear(); fname.clear();
            mname.clear(); gender.clear(); address.clear(); contact.clear();
            int rowStudents = 0;
            while (rs2.next()){
                StudID.add(rs2.getString(1).toString()); lname.add(rs2.getString(2).toString());
                fname.add(rs2.getString(3).toString()); mname.add(rs2.getString(4).toString());
                gender.add(rs2.getString(5).toString()); address.add(rs2.getString(6).toString());
                contact.add(rs2.getString(7).toString());
                Vector v = new Vector();
                v.add(StudID.get(i)); v.add(lname.get(i));
                v.add(fname.get(i));  v.add(mname.get(i));
                v.add(gender.get(i));  v.add(address.get(i));
                v.add(contact.get(i));
                DefaultTableModel tStudents = (DefaultTableModel)tblStudents.getModel();
                tStudents.setRowCount(rowStudents);
                tStudents.addRow(v);
                rowStudents++;
               i++;
           }
       }
    connect.close();
    }catch (SQLException sqlException){
     JOptionPane.showMessageDialog(getContentPane(),"Error in database connection"+sqlException,"sqlException",JOptionPane.ERROR_MESSAGE);

    }
    }
    public void SearchStudent(){
    String sql1 = "";
    String sql2 = "";
    try {
       clsConnection conn = new clsConnection();
       Connection connect = clsConnection.conn;
       Statement stm = connect.createStatement();
       sql1 = "select * from tblStudents where LName Like '"+ txtSearch.getText().toString().trim() +"%' order by LName";
       sql2 = "select * from tblStudents where LName Like '"+ txtSearch.getText().toString().trim() +"%' order by LName";
       ResultSet rs1, rs2;
       rs1 = stm.executeQuery(sql1);

       int num = 0;
       if (rs1.next()) {
        num = Integer.parseInt(rs1.getString(1).trim());
       }
       int rowStudents = 0;
       
       if (num > 0) {
            int i = 0;
            rs2 = stm.executeQuery(sql2);
            StudID.clear(); lname.clear(); fname.clear();
            mname.clear(); gender.clear(); address.clear(); contact.clear();
            while (rs2.next()){
                StudID.add(rs2.getString(1).toString());    
                lname.add(rs2.getString(2).toString());
                fname.add(rs2.getString(3).toString());
                mname.add(rs2.getString(4).toString());
                gender.add(rs2.getString(5).toString());
                address.add(rs2.getString(6).toString());
                contact.add(rs2.getString(7).toString());
                Vector v = new Vector();
                v.add(StudID.get(i)); v.add(lname.get(i));
                v.add(fname.get(i)); v.add(mname.get(i));
                v.add(gender.get(i));  v.add(address.get(i));
                v.add(contact.get(i));
                DefaultTableModel tStudents = (DefaultTableModel)tblStudents.getModel();
                tStudents.setRowCount(rowStudents);
                tStudents.addRow(v);
                rowStudents++;
               i++;
           }
       }
       else
       {
                DefaultTableModel tStudents = (DefaultTableModel)tblStudents.getModel();
                tStudents.setRowCount(rowStudents);
       }
    connect.close();
    }catch (SQLException sqlException){
     JOptionPane.showMessageDialog(getContentPane(),"Error in database connection"+sqlException,"sqlException",JOptionPane.ERROR_MESSAGE);

    }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PInfo;
    private javax.swing.JComboBox cmbGender;
    private javax.swing.JButton cmdClose;
    private javax.swing.JButton cmdDelete;
    private javax.swing.JButton cmdEdit;
    private javax.swing.JButton cmdRefresh;
    private javax.swing.JButton cmdUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStudents;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtFName;
    private javax.swing.JTextField txtLName;
    private javax.swing.JTextField txtMName;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
