/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package eventschedulingsystem;

import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author alfin
 */
public class Ereq extends javax.swing.JInternalFrame {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/eventss";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Aleena123$";
    /**
     * Creates new form Events
     */
    public Ereq() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
          jButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3ActionPerformed(evt);
        }
    });
           jButton10.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton10ActionPerformed(evt);
        }
    });
    }
     public void retrieveEventRequests() {
        try {
            // Create a connection to the database
            Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

            // Create a prepared statement to retrieve event requests
            String query = "SELECT name, date, start_time, stop_time, am_pm FROM events";
            PreparedStatement statement = connection.prepareStatement(query);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

          
            // Populate the table with the retrieved data
             DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("EVENT NAME");
        tableModel.addColumn("EVENT DATE");
        tableModel.addColumn("START TIME");
        tableModel.addColumn("STOP TIME");
        tableModel.addColumn("AM/PM");

        // Populate the table model with the retrieved data
        while (resultSet.next()) {
            Object[] row = new Object[5];
            row[0] = resultSet.getString("name");
            row[1] = resultSet.getString("date");
            row[2] = resultSet.getString("start_time");
            row[3] = resultSet.getString("stop_time");
            row[4] = resultSet.getString("am_pm");
            tableModel.addRow(row);
        }

        // Set the table model to the jTable1
        jTable1.setModel(tableModel);

            // Close the database resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // Handle Approve button action
        int selectedRowIndex = jTable1.getSelectedRow();
        if (selectedRowIndex != -1) {
            String eventName = jTable1.getValueAt(selectedRowIndex, 0).toString();
            String eventDate = jTable1.getValueAt(selectedRowIndex, 1).toString();
            String startTime = jTable1.getValueAt(selectedRowIndex, 2).toString();
            String stopTime = jTable1.getValueAt(selectedRowIndex, 3).toString();
            String amPm = jTable1.getValueAt(selectedRowIndex, 4).toString();

            // Store the approved event request in another table
            storeApprovedEvent(eventName, eventDate, startTime, stopTime, amPm);
        }
    }

    public void storeApprovedEvent(String eventName, String eventDate, String startTime, String stopTime, String amPm) {
        try {
            // Create a connection to the database
            Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

            // Create a prepared statement to insert the approved event request
            String query = "INSERT INTO approvedevents (name, date, start_time, stop_time, am_pm) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, eventName);
            statement.setString(2, eventDate);
            statement.setString(3, startTime);
            statement.setString(4, stopTime);
            statement.setString(5, amPm);

            // Execute the statement
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Event request approved and stored successfully.");
                deleteEventRequest(eventName, eventDate, startTime, stopTime, amPm);
            } else {
                System.out.println("Failed to approve and store event request.");
            }

            // Close the database resources
            statement.close();
            connection.close();
        } catch (SQLException e) {
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
        jLabel1 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(850, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("EVENT REQUESTS");

        jButton10.setBackground(new java.awt.Color(255, 153, 153));
        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton10.setText("Reject");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 255, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setText("Approve");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "EVENT NAME", "EVENT DATE", "START TIME", "STOP TIME", "AM/PM"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(jButton3)
                        .addGap(72, 72, 72)
                        .addComponent(jButton10)))
                .addContainerGap(274, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton10, jButton3});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(247, 247, 247)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton10))
                .addGap(78, 78, 78))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton10, jButton3});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
         int selectedRowIndex = jTable1.getSelectedRow();
    if (selectedRowIndex != -1) {
        String eventName = jTable1.getValueAt(selectedRowIndex, 0).toString();
        String eventDate = jTable1.getValueAt(selectedRowIndex, 1).toString();
        String startTime = jTable1.getValueAt(selectedRowIndex, 2).toString();
        String stopTime = jTable1.getValueAt(selectedRowIndex, 3).toString();
        String amPm = jTable1.getValueAt(selectedRowIndex, 4).toString();

        // Delete the rejected event request from the table
        deleteEventRequest(eventName, eventDate, startTime, stopTime, amPm);
    }// TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed
    public void deleteEventRequest(String eventName, String eventDate, String startTime, String stopTime, String amPm) {
    try {
        // Create a connection to the database
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

        // Create a prepared statement to delete the event request
        String query = "DELETE FROM events WHERE name = ? AND date = ? AND start_time = ? AND stop_time = ? AND am_pm = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, eventName);
        statement.setString(2, eventDate);
        statement.setString(3, startTime);
        statement.setString(4, stopTime);
        statement.setString(5, amPm);

        // Execute the statement
        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Event request rejected and deleted successfully.");
            retrieveEventRequests(); // Refresh the table after deletion
        } else {
            System.out.println("Failed to reject and delete event request.");
        }

        // Close the database resources
        statement.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
     public static void main(String[] args) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ereq().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
