/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static gui.SignIn.firstName;
import static gui.SignIn.lastName;
import static gui.SignIn.userName;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

/**
 *
 * @author Home
 */
public class Attendance extends javax.swing.JFrame {
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * Creates new form Attendance
     *
     *
     */
    
    String cid;
    String tname;
    String sub;
    String time;
    
    public Attendance() {
        initComponents();
        jDateChooser1.setForeground(Color.WHITE);
//        jTable1.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 16));
//        jTable2.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 16));

//        loadAttendance();
    }

//    public void loadClasses() {
//
//        String sid = jLabel19.getText();
//
//        try {
//            ResultSet rs = MySQL.search("SELECT * FROM `student_class` INNER JOIN `class` ON `student_class`.`class_classno`=`class`.`classno` INNER JOIN `subject` on `class`.`subject_subno`=`subject`.`subno` INNER JOIN `teacher` ON `teacher`.`tno`=`class`.`teacher_tno` WHERE `student_sno` ='" + sid + "';");
////            DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
//            dtm.setRowCount(0);
//
//            while (rs.next()) {
//
//                Vector v = new Vector();
//                v.add(rs.getString("class.classno"));
//                v.add(rs.getString("teacher.name"));
//                v.add(rs.getString("subject.description"));
//                v.add(rs.getString("class.timeslot"));
//                dtm.addRow(v);
//
//            }
//            jTable2.setModel(dtm);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//    public void loadAttendance() {
//
//        String sid = jLabel19.getText();
//
//        try {
//            ResultSet rs = MySQL.search("SELECT * FROM `attendance` INNER JOIN `class` ON `attendance`.`class_classno`=`class`.`classno` INNER JOIN `subject` on `class`.`subject_subno`=`subject`.`subno` INNER JOIN `teacher` ON `teacher`.`tno`=`class`.`teacher_tno` INNER JOIN `student` ON `student`.`sno`= `attendance`.`student_sno`;");
//            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
//            dtm.setRowCount(0);
//
//            while (rs.next()) {
//
//                Vector v = new Vector();
//                v.add(rs.getString("attendance.id"));
//                v.add(rs.getString("student.name"));
//                v.add(rs.getString("student.mobile"));
//                v.add(rs.getString("subject.description"));
//                v.add(rs.getString("teacher.name"));
//                v.add(rs.getString("class.timeslot"));
//                v.add(rs.getString("attendance.date"));
//
//                dtm.addRow(v);
//
//            }
//            jTable1.setModel(dtm);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//    public void loadStudents(String text) {
//
//        try {
//            ResultSet rs = MySQL.search("SELECT * FROM `teacher` INNER JOIN `subject` ON `teacher`.`subject_subno`=`subject`.`subno`  WHERE `name` LIKE '" + text + "%'  OR `mobile` LIKE '" + text + "%' ORDER BY `tno` ASC;");
//            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
//            dtm.setRowCount(0);
//
//            while (rs.next()) {
//
//                Vector v = new Vector();
//                v.add(rs.getString("teacher.tno"));
//                v.add(rs.getString("teacher.name"));
//                v.add(rs.getString("teacher.mobile"));
//
//                v.add(rs.getString("subject.description"));
//                String address = rs.getString("teacher.address_01") + "," + rs.getString("teacher.address_02");
//                v.add(address);
//                dtm.addRow(v);
//
//            }
//            jTable1.setModel(dtm);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logo.png"))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 51), 2), "Student Attendance", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Century Gothic", 1, 30), new java.awt.Color(255, 102, 51))); // NOI18N

        jSeparator1.setBackground(new java.awt.Color(255, 102, 0));
        jSeparator1.setOpaque(true);

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Select Student");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 51), 2));
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setOpaque(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel18.setText("Student  Id  :");

        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel19.setText("None");

        jLabel22.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel22.setText("Student Name :");

        jLabel23.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel23.setText("None");

        jLabel25.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel25.setText("None");

        jLabel26.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel26.setText("Contact Number :");

        jButton8.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jButton8.setForeground(new java.awt.Color(51, 255, 0));
        jButton8.setText("PRESENT");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.setOpaque(true);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 51, 51));
        jButton9.setText("ABSENT");
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 17)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Select Subject");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 51), 2));
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setText("Subject Id :");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel10.setText("None");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel6.setText("Subject Name    :");

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel11.setText("None");

        jDateChooser1.setForeground(new java.awt.Color(255, 255, 255));
        jDateChooser1.setDateFormatString("yyyy-MM-dd");

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel15.setText("Date :");

        jSeparator2.setBackground(new java.awt.Color(255, 102, 0));
        jSeparator2.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(359, 359, 359)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jSeparator1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(472, 472, 472))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(376, 376, 376))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(429, 429, 429))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(jLabel19))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(jLabel23))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(jLabel25)))
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel11))
                .addGap(38, 38, 38)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton9))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(515, 515, 515)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ViewStudents sr = new ViewStudents(this);
        sr.setVisible(true);
//        loadClasses();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        String sNo = jLabel19.getText();
        String subId = jLabel10.getText();
        Date dob1 = jDateChooser1.getDate();
        
        if (sNo.isEmpty() || subId.isEmpty() || dob1 == null) {
            JOptionPane.showMessageDialog(this, "Please fill the all details.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            // Proceed with further processing
            String dateClass = sdf.format(dob1);
            // Your remaining code here

            if (sNo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Select a Student", "Warning", JOptionPane.WARNING_MESSAGE);
                
            } else if (subId.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Select the Subejct.", "Warning", JOptionPane.WARNING_MESSAGE);
                
            } else if (dob1 == null) {
                JOptionPane.showMessageDialog(this, "Please Select the Date.", "Warning", JOptionPane.WARNING_MESSAGE);
                
            } else if (dob1.after(new Date())) {
                JOptionPane.showMessageDialog(this, "Invalid Date! , Please Select a Valid Date.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {

                //Check
                try {
                    ResultSet rs = MySQL.search("SELECT * FROM `attendance` WHERE `date`='" + dateClass + "' AND `student_sno`='" + sNo + "' AND `subject_subno`='" + subId + "' ;");
                    if (rs.next()) {
                        
                        JOptionPane.showMessageDialog(this, "The student attendance has already been marked.", "Warning", JOptionPane.WARNING_MESSAGE);
                        
                    } else {
                        
                    MySQL.iud("INSERT INTO `attendance`(`date`,`student_sno`,`subject_subno`,`status`,`reason`,`filePath`) VALUES ('" + dateClass + "','" + sNo + "','" + subId + "','Present','No','No');");
                        jLabel19.setText("None");
                        jLabel23.setText("None");
                        jLabel25.setText("None");
                        jLabel10.setText("None");
                        jLabel11.setText("None");
                        jDateChooser1.setDate(null);
                        
                        jButton3.grabFocus();

                        //loadSuppliers();
                        JOptionPane.showMessageDialog(this, "Attendance Marked.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        
                    }
                    
                } catch (Exception e) {
                    
                    e.printStackTrace();
                    
                }
            }
        }

    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        SubjectRegistration sr = new SubjectRegistration(this, true);
        sr.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:

        String sNo = jLabel19.getText();
        String subId = jLabel10.getText();
        Date dob1 = jDateChooser1.getDate();
//        String dateClass = sdf.format(dob1);
        
        if (sNo.isEmpty() || subId.isEmpty() || dob1 == null) {
            JOptionPane.showMessageDialog(this, "Please fill the all details.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            // Proceed with further processing
            String dateClass = sdf.format(dob1);
            // Your remaining code here

            if (sNo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Select a Student", "Warning", JOptionPane.WARNING_MESSAGE);
                
            } else if (subId.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Select the Subejct.", "Warning", JOptionPane.WARNING_MESSAGE);
                
            } else if (dob1 == null) {
                JOptionPane.showMessageDialog(this, "Please Select the Date.", "Warning", JOptionPane.WARNING_MESSAGE);
                
            } else {

                //Check
                try {
                    ResultSet rs = MySQL.search("SELECT * FROM `attendance` WHERE `date`='" + dateClass + "' AND `student_sno`='" + sNo + "' AND `subject_subno`='" + subId + "' ;");
                    if (rs.next()) {
                        
                        JOptionPane.showMessageDialog(this, "The student attendance has already been marked.", "Warning", JOptionPane.WARNING_MESSAGE);
                        
                    } else {
                        
                        
                        MedicalReason mr = new MedicalReason(null, true);
                        
                        mr.jLabel19.setText(sNo);
                        mr.jLabel20.setText(dateClass);
                        
                        ResultSet rs1 = MySQL.search("SELECT * FROM `subject` WHERE `subno`='" + subId + "' ;");
                        
                        if (rs1.next()) {
                            //JOptionPane.showMessageDialog(this, "Sign In Success", "Success", JOptionPane.INFORMATION_MESSAGE);

                            String subName = rs1.getString("description");
                            
                            mr.jLabel21.setText(subName);
                            
                            mr.setVisible(true);
                            //loadSuppliers();
//                            JOptionPane.showMessageDialog(this, "Attendance Marked.", "Success", JOptionPane.INFORMATION_MESSAGE);
                            
                        }
                    }
                } catch (Exception e) {
                    
                    e.printStackTrace();
                    
                }
            }
        }

    }//GEN-LAST:event_jButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Attendance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton3;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    public static com.toedter.calendar.JDateChooser jDateChooser1;
    public static javax.swing.JLabel jLabel10;
    public static javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    public static javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel22;
    public static javax.swing.JLabel jLabel23;
    public static javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
