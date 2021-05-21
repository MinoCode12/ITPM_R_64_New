/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timetableitpm.lecturer;

import com.itpm.timetablemanagement.util.Constant;
import com.itpm.timetablemanagement.util.CreateQuery;
import com.itpm.timetablemanagement.util.DBConnection;
import java.awt.Dimension;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author HASINI
 */
public class ViewLecturer extends javax.swing.JFrame {
    
    ArrayList<Lecturer> lecturers = new ArrayList<>();
    TableModel model;
    EditLecturer editLect = new EditLecturer();
    int row;
    int col;

    /**
     * Creates new form ViewLecturer
     */
    public ViewLecturer() {
        initComponents();
        execute();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_lect = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 255, 153));

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("Lecturer Details");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(342, 342, 342)
                .addComponent(jLabel1)
                .addContainerGap(360, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 51));

        tbl_lect.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Lecture ID", "Faculty", "Department", "Center", "Building", "Level", "Rank", "Update", "Delete"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_lect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_lectMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_lect);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1007, 699));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_lectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_lectMouseClicked
        int row = tbl_lect.getSelectedRow();
        int col = tbl_lect.getSelectedColumn();
        model = tbl_lect.getModel();
        
        if(col == 10){
            int x = JOptionPane.showConfirmDialog(ViewLecturer.this, "Are you sure to Delete", "Delete", JOptionPane.YES_NO_OPTION);
            if(x==0){
                deleteData(row);
            }
        }
        else if(col == 9){
            editLect.setVisible(true);
            editLect.setPreferredSize(new Dimension(200, 400));
            editLect.setLocationRelativeTo(this);
            editLect.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            Lecturer lec = new Lecturer();
            editLect.txt_name.setText(model.getValueAt(row, 1).toString());
            editLect.txt_lectID.setText(model.getValueAt(row, 2).toString());
            editLect.cmb_faculty.setSelectedItem(model.getValueAt(row, 3).toString());
            editLect.cmb_dept.setSelectedItem(model.getValueAt(row, 4).toString());
            editLect.cmb_center.setSelectedItem(model.getValueAt(row, 5).toString());
            editLect.cmb_building.setSelectedItem(model.getValueAt(row, 6).toString());
            editLect.cmb_level.setSelectedItem(model.getValueAt(row, 7).toString());
            editLect.txt_rank.setText(model.getValueAt(row, 8).toString());
            editLect.txt_id.setText(model.getValueAt(row, 0).toString());
            
            
        }
    }//GEN-LAST:event_tbl_lectMouseClicked

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
            java.util.logging.Logger.getLogger(ViewLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewLecturer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewLecturer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JTable tbl_lect;
    // End of variables declaration//GEN-END:variables

    private void deleteData(int row) {
        boolean error = false;
        DefaultTableModel mod = (DefaultTableModel) tbl_lect.getModel();
        
         try {
             int id = (int) model.getValueAt(row, 0);
            
             
            Connection connection =  DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(CreateQuery.getQuery(Constant.DELETE_LECTURER));
            
            statement.setInt(1, id);
            statement.execute();
            
        } catch (SQLException | ClassNotFoundException | IOException | 
                ParserConfigurationException | SAXException ex) {
            Logger.getLogger(ViewLecturer.class.getName()).log(Level.SEVERE, null, ex);
            error = true;
            
             JOptionPane.showMessageDialog(ViewLecturer.this, "Delete Error", "Error", JOptionPane.ERROR_MESSAGE);
        }
         
         if(!error){
             JOptionPane.showMessageDialog(ViewLecturer.this, "Delete Succes", "Succes", JOptionPane.DEFAULT_OPTION);
             mod.removeRow(row);
             
             
         }
    }
    

    private void execute() {
         try{
             Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(CreateQuery.getQuery(Constant.GET_LECTURER));
             ResultSet resultSet = statement.executeQuery();
             
             while(resultSet.next()){
                 DefaultTableModel model = (DefaultTableModel) tbl_lect.getModel();
                 Lecturer lect = new Lecturer();
                 
                lect.setId(resultSet.getInt("id"));
                lect.setName(resultSet.getString("name"));
                lect.setEmpId(resultSet.getString("lect_id"));
                lect.setFaculty(resultSet.getString("faculty"));
                lect.setDepartment(resultSet.getString("department"));
                lect.setCenter(resultSet.getString("center"));
                lect.setBuilding(resultSet.getString("building"));
                lect.setLevel(resultSet.getString("level"));
                lect.setRank(resultSet.getString("rank"));
                
                lecturers.add(lect);
                model.setRowCount(0);
                createTable();
             }    
         }catch(SQLException | ClassNotFoundException | IOException | 
                ParserConfigurationException | SAXException ex) {
            Logger.getLogger(ViewLecturer.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error on data Load", "Data error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void createTable() {
       
        DefaultTableModel model = (DefaultTableModel) tbl_lect.getModel();
        
        Object [] data = new Object[11];
        
        for(int i = 0;i < lecturers.size();i++){
            data[0] = lecturers.get(i).getId();
            data[1] = lecturers.get(i).getName();
            data[2] = lecturers.get(i).getEmpId();
            data[3] = lecturers.get(i).getFaculty();
            data[4] = lecturers.get(i).getDepartment();
            data[5] = lecturers.get(i).getCenter();
            data[6] = lecturers.get(i).getBuilding();
            data[7] = lecturers.get(i).getLevel();
            data[8] = lecturers.get(i).getRank();
            data[9] = "Edit";
            data[10] = "Delete";
            
            model.addRow(data);
            
        }
    }
}
