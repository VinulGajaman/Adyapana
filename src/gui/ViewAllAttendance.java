/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

/**
 *
 * @author Home
 *
 */
public class ViewAllAttendance extends javax.swing.JFrame {
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * Creates new form StudentRegistartion
     */
    Attendance at;
    
    public ViewAllAttendance() {
        initComponents();
        jTable1.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 20));
        displayAttendance();
        loadStudents();
    }
    
    public ViewAllAttendance(Attendance at) {
        initComponents();
        jTable1.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 20));
        loadStudents();
        displayAttendance();
        this.at = at;
    }
    
    private void displayAttendance() {
        // Custom cell renderer to set color based on status
        jTable1.getColumnModel().getColumn(5).setCellRenderer(new AttendanceTableCellRenderer());
    }
    
    class AttendanceTableCellRenderer extends DefaultTableCellRenderer {
        
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Check if the value in the "Status" column is "Absent"
            String status = jTable1.getValueAt(row, 5).toString();
            if (status.equals("Absent")) {
                // Set the background color of the cell to red for Absent rows
                cellComponent.setBackground(Color.RED);
            } else {
                // Reset the background color to default for other rows
                cellComponent.setBackground(table.getBackground());
            }
            
            return cellComponent;
        }
    }
    
    public void loadStudents() {
        
        try {
            ResultSet rs = MySQL.search("SELECT * FROM `attendance` INNER JOIN `subject` ON `attendance`.`subject_subno`=`subject`.`subno` INNER JOIN `student` ON `attendance`.`student_sno`=`student`.`sno` ORDER BY `attendance`.`date` ASC;");
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            
            while (rs.next()) {
                
                Vector v = new Vector();
                v.add(rs.getString("attendance.student_sno"));
                v.add(rs.getString("student.name"));
                v.add(rs.getString("student.mobile"));
                v.add(rs.getString("subject.description"));
                v.add(rs.getString("attendance.date"));
                v.add(rs.getString("attendance.status"));
                
                dtm.addRow(v);
                
            }
            
            jTable1.setModel(dtm);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void searchStudents() {
        
        try {
            String status = jComboBox1.getSelectedItem().toString();

            //String sub_category = jComboBox4.getSelectedItem().toString();
            String sId = jTextField5.getText();
            String subName = jTextField6.getText();
            
            String dateAt = null;
            Vector queryVector = new Vector();
            if (jDateChooser1.getDate() != null) {
                
                dateAt = sdf.format(jDateChooser1.getDate());
                queryVector.add("`attendance`.`date`='" + dateAt + "'");
            }

            //status
            if (status.equals("Select")) {
                
            } else {
                queryVector.add("`attendance`.`status`='" + status + "'");
                
            }

            //sId
            if (sId.isEmpty()) {
                
            } else {
                
                queryVector.add("`attendance`.`student_sno` LIKE '%" + sId + "%'");
            }
            
            if (subName.isEmpty()) {
                
            } else {
                
                queryVector.add("`subject`.`description` LIKE '%" + subName + "%'");
            }
            
            String whereQuery = "";
            if (queryVector.size() > 0) {
                whereQuery = "WHERE";
            }
            
            for (int i = 0; i < queryVector.size(); i++) {
                whereQuery += " ";
                whereQuery += queryVector.get(i);
                whereQuery += " ";
                if (i != queryVector.size() - 1) {
                    whereQuery += "AND";
                }
                
            }
            
            ResultSet rs = MySQL.search("SELECT * FROM `attendance` INNER JOIN `subject` ON `attendance`.`subject_subno`=`subject`.`subno` INNER JOIN `student` ON `attendance`.`student_sno`=`student`.`sno` " + whereQuery + " ORDER BY `attendance`.`date` ASC;");
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
            
            while (rs.next()) {
                
                Vector v = new Vector();
                v.add(rs.getString("attendance.student_sno"));
                v.add(rs.getString("student.name"));
                v.add(rs.getString("student.mobile"));
                v.add(rs.getString("subject.description"));
                v.add(rs.getString("attendance.date"));
                v.add(rs.getString("attendance.status"));
                
                dtm.addRow(v);
            }
            
            jTable1.setModel(dtm);
            
        } catch (Exception e) {
            e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 51), 2, true));

        jTable1.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Studnet Id", "Student Name", "Contact Number", "Subject", "Date", "Attendance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(20);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logo.png"))); // NOI18N

        jTextField5.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jTextField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel14.setText("Student Id:");

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel15.setText("Subject Name :");

        jTextField6.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel17.setText("Date :");

        jDateChooser1.setForeground(new java.awt.Color(255, 255, 255));
        jDateChooser1.setDateFormatString("yyyy-MM-dd");
        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel18.setText("Status");

        jComboBox1.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Present", "Absent" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(jLabel17)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 64, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14)
                                .addComponent(jTextField5)
                                .addComponent(jLabel15)
                                .addComponent(jTextField6)
                                .addComponent(jLabel17))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addGap(67, 67, 67)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            
            int r = jTable1.getSelectedRow();
            ViewReason vr = new ViewReason(null, true);
            
            if (r == -1) {
                JOptionPane.showMessageDialog(this, "Please Select a Student.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                
                String selectedStatus = jTable1.getValueAt(r, 5).toString();
                
                if ("Absent".equals(selectedStatus)) { // Check if column 5 value is "Absent"
                    String sId = jTable1.getValueAt(r, 0).toString();
                    String date = jTable1.getValueAt(r, 4).toString();
                    String sub = jTable1.getValueAt(r, 3).toString();
                    
                    vr.jLabel19.setText(sId);
                    vr.jLabel20.setText(date);
                    vr.jLabel21.setText(sub);
                    
                    vr.loadFiles(sId, date, sub);
                    
                    vr.setVisible(true);
                    
                } else {
                    JOptionPane.showMessageDialog(this, "No Medical Reports.", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        }// TODO add your handling code he
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        // TODO add your handling code here:

        searchStudents();
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        // TODO add your handling code here:
        searchStudents();
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        searchStudents();
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
        // TODO add your handling code here:
        searchStudents();
    }//GEN-LAST:event_jDateChooser1PropertyChange

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
            java.util.logging.Logger.getLogger(ViewAllAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAllAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAllAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAllAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAllAttendance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    public static com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
