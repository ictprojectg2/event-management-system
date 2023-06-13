/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package eventschedulingsystem;

import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
/**
 *
 * @author alfin
 */
public class HallAlloc extends javax.swing.JInternalFrame {

    /**
     * Creates new form Events
     */
    public HallAlloc() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui=(BasicInternalFrameUI)this.getUI();
        ui.setNorthPane(null);
        loadApprovedEvents();
          BTALLOC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BTALLOCActionPerformed(evt);
            }
        });
        
    }
    public void loadApprovedEvents() {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/EventSS";
        String username = "root";
        String password = "Aleena123$";

        // SQL query to retrieve approved events
        String query = "SELECT * FROM approvedevents";

        // Establish the database connection
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            // Create a list to store the event data
            java.util.List<Object[]> eventData = new java.util.ArrayList<>();

            // Iterate over the result set and populate the event data
            while (resultSet.next()) {
                String eventName = resultSet.getString("name");
                String eventDate = resultSet.getString("date");
                String startTime = resultSet.getString("start_time");
                String stopTime = resultSet.getString("stop_time");
                String amPm = resultSet.getString("am_pm");

                // Create an array with the event data
                Object[] event = {eventName, eventDate, startTime, stopTime, amPm};

                // Add the event to the list
                eventData.add(event);
            }

            // Update the table model with the retrieved event data
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    eventData.toArray(new Object[0][]),
                    new String[]{
                            "EVENT NAME", "EVENT DATE", "START TIME", "STOP TIME", "AM/PM"
                    }
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    
    private void initComponents() {
       
        
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        BTALLOC = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(850, 600));

        jTable1.setBackground(new java.awt.Color(255, 201, 144));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "EVENT NAME", "EVENT DATE", "START TIME ", "STOP TIME", "AM/PM"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Segoe UI Historic", 1, 25)); // NOI18N
        jLabel2.setText("EVENT - HALLS ALLOCATION");

        BTALLOC.setBackground(new java.awt.Color(204, 255, 204));
        BTALLOC.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        BTALLOC.setText("ALLOCATE HALL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 826, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(251, 251, 251))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BTALLOC)
                .addGap(342, 342, 342))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(136, 136, 136)
                .addComponent(BTALLOC, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(191, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
        );

        pack();
        
        
    }// </editor-fold>//GEN-END:initComponents
    private void BTALLOCActionPerformed(java.awt.event.ActionEvent evt) {
        // Create a custom panel with a text field
        JPanel panel = new JPanel(new GridLayout(1, 2));
        JTextField hallTextField = new JTextField();
        panel.add(hallTextField);

        // Display the custom panel in an input dialog
        int result = JOptionPane.showConfirmDialog(this, panel, "Enter the hall to be allocated:",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Process the entered hall if the OK button is clicked
        if (result == JOptionPane.OK_OPTION) {
            String hall = hallTextField.getText().trim();
            if (!hall.isEmpty()) {
                // Do something with the allocated hall, e.g., save it to the database
                insertHallAllocation(hall);
            } else {
                // Display an error message if the input is empty
                JOptionPane.showMessageDialog(this, "Hall name cannot be empty. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public void insertHallAllocation(String hall) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/EventSS";
    String username = "root";
    String password = "Aleena123$";

    // SQL query to insert the allocated hall into the table
    String insertQuery = "INSERT INTO hallallocation (name, date, start_time, end_time, am_pm, hallallocate) "
            + "VALUES (?, ?, ?, ?, ?, ?)";

    // SQL query to delete the allocated rows from the table
    String deleteQuery = "DELETE FROM approvedevents WHERE name = ? AND date = ? AND start_time = ? AND stop_time = ? AND am_pm = ?";

    // Establish the database connection
    try (Connection connection = DriverManager.getConnection(url, username, password);
         PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
         PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {

        // Get the selected rows from the table
        int[] selectedRows = jTable1.getSelectedRows();

        // Iterate over the selected rows and insert the hall allocation
        for (int row : selectedRows) {
            // Get the event data from the selected row
            String eventName = jTable1.getValueAt(row, 0).toString();
            String eventDate = jTable1.getValueAt(row, 1).toString();
            String startTime = jTable1.getValueAt(row, 2).toString();
            String stopTime = jTable1.getValueAt(row, 3).toString();
            String amPm = jTable1.getValueAt(row, 4).toString();

            // Set the event data and hall value for the prepared statement
            insertStatement.setString(1, eventName);
            insertStatement.setString(2, eventDate);
            insertStatement.setString(3, startTime);
            insertStatement.setString(4, stopTime);
            insertStatement.setString(5, amPm);
            insertStatement.setString(6, hall);

            // Execute the query to insert the hall allocation
            int rowsInserted = insertStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Hall allocation for event " + eventName + " inserted successfully.");

                // Set the event data for the delete statement
                deleteStatement.setString(1, eventName);
                deleteStatement.setString(2, eventDate);
                deleteStatement.setString(3, startTime);
                deleteStatement.setString(4, stopTime);
                deleteStatement.setString(5, amPm);

                // Execute the query to delete the allocated rows
                int rowsDeleted = deleteStatement.executeUpdate();

                if (rowsDeleted > 0) {
                    System.out.println("Allocated event " + eventName + " removed from approved events.");
                } else {
                    System.out.println("Failed to remove allocated event " + eventName + " from approved events.");
                }
            } else {
                System.out.println("Failed to insert hall allocation for event " + eventName + ".");
            }
        }

        // Refresh the table to reflect the changes
        loadApprovedEvents();

    } catch (SQLException e) {
        e.printStackTrace();
    }
    }

     public static void main(String[] args) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HallAlloc().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTALLOC;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
