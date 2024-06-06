/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nexatek;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;


public class dashboard extends javax.swing.JPanel {

    /**
     * Creates new form dashboard
     */
    public dashboard() {
        initComponents();
        
         // Create summary panel
        JPanel summaryPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        summaryPanel.setBorder(BorderFactory.createTitledBorder("Summary"));

        // Add summary components
//        summaryPanel.add(createSummaryLabel("Total Sales", "$5000"));
//        summaryPanel.add(createSummaryLabel("Transactions", "200"));
//        summaryPanel.add(createSummaryLabel("Top Selling Item", "Item A"));
//        summaryPanel.add(createSummaryLabel("Total Customers", "150"));

        // Create recent transactions panel
        JPanel recentTransactionsPanel = new JPanel(new BorderLayout());
        recentTransactionsPanel.setBorder(BorderFactory.createTitledBorder("Recent Transactions"));

        // Add table for recent transactions
        String[] transactionColumns = {"Date", "Transaction ID", "Amount"};
        Object[][] transactionData = {
                {new Date(), "TXN001", "$50"},
                {new Date(), "TXN002", "$30"},
                {new Date(), "TXN003", "$20"},
                // Add more sample data here
        };
        JTable recentTransactionsTable = new JTable(new DefaultTableModel(transactionData, transactionColumns));
        recentTransactionsPanel.add(new JScrollPane(recentTransactionsTable), BorderLayout.CENTER);

        // Create top selling items panel
        JPanel topSellingItemsPanel = new JPanel(new BorderLayout());
        topSellingItemsPanel.setBorder(BorderFactory.createTitledBorder("Top Selling Items"));

        // Add table for top selling items
        String[] topSellingColumns = {"Item Name", "Quantity Sold"};
        Object[][] topSellingData = {
                {"Item A", "100"},
                {"Item B", "80"},
                {"Item C", "60"},
                // Add more sample data here
        };
        JTable topSellingItemsTable = new JTable(new DefaultTableModel(topSellingData, topSellingColumns));
        topSellingItemsPanel.add(new JScrollPane(topSellingItemsTable), BorderLayout.CENTER);

        // Main layout
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(summaryPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(recentTransactionsPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(topSellingItemsPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(summaryPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recentTransactionsPanel, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(topSellingItemsPanel, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
        );
    // </editor-fold>                        

}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1742, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 856, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
