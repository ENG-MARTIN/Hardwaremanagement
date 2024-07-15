/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nexatek;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chipcodedev
 */
public class dashboard extends javax.swing.JPanel {
Connection conn;

    public dashboard() {
        initComponents();

    
    
        // Create summary panel
        JPanel summaryPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        summaryPanel.setBorder(BorderFactory.createTitledBorder("Summary"));

        // Add summary components with dummy data initially
        summaryPanel.add(createSummaryLabel("Total Sales", ""));
        summaryPanel.add(createSummaryLabel("Transactions", ""));
        summaryPanel.add(createSummaryLabel("Top Selling Item", ""));
        summaryPanel.add(createSummaryLabel("Total Items", ""));
        summaryPanel.add(createSummaryLabel("Total Users", ""));
        summaryPanel.add(createSummaryLabel("Income Today", ""));
        summaryPanel.add(createSummaryLabel("Income This Week", ""));

        // Create recent transactions panel
        JPanel recentTransactionsPanel = new JPanel(new BorderLayout());
        recentTransactionsPanel.setBorder(BorderFactory.createTitledBorder("Recent Transactions"));

        // Add table for recent transactions
        String[] transactionColumns = {"Date", "Transaction ID", "Amount"};
        DefaultTableModel transactionModel = new DefaultTableModel(transactionColumns, 0);
        JTable recentTransactionsTable = new JTable(transactionModel);
        recentTransactionsPanel.add(new JScrollPane(recentTransactionsTable), BorderLayout.CENTER);

        // Create top selling items panel
        JPanel topSellingItemsPanel = new JPanel(new BorderLayout());
        topSellingItemsPanel.setBorder(BorderFactory.createTitledBorder("Top Selling Items"));

        // Add table for top selling items
        String[] topSellingColumns = {"Item Name", "Quantity Sold"};
        DefaultTableModel topSellingModel = new DefaultTableModel(topSellingColumns, 0);
        JTable topSellingItemsTable = new JTable(topSellingModel);
        topSellingItemsPanel.add(new JScrollPane(topSellingItemsTable), BorderLayout.CENTER);

        // Main panel for holding all sub-panels
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(summaryPanel, BorderLayout.NORTH);
        mainPanel.add(recentTransactionsPanel, BorderLayout.CENTER);
        mainPanel.add(topSellingItemsPanel, BorderLayout.SOUTH);

        // Add the main panel to the current panel
        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);

        // Fetch and display data
        fetchData(summaryPanel, transactionModel, topSellingModel);
    }

    // Helper method to create summary labels
    private JLabel createSummaryLabel(String title, String value) {
        JLabel label = new JLabel("<html><body><b>" + title + ":</b> " + value + "</body></html>");
        return label;
    }

    private void fetchData(JPanel summaryPanel, DefaultTableModel transactionModel, DefaultTableModel topSellingModel) {
        try (Connection conn = connection.connect()) {
            // Fetch total sales, total transactions, top selling item, etc.
            String totalSalesQuery = "SELECT SUM(total) FROM solditems";
            String totalTransactionsQuery = "SELECT COUNT(*) FROM solditems";
            String topSellingItemQuery = "SELECT name, SUM(quantity) as qty FROM solditems GROUP BY name ORDER BY qty DESC LIMIT 1";
//            String totalCustomersQuery = "SELECT COUNT(DISTINCT customer_id) FROM solditems"; // Assuming there's a customer_id field
            String totalItemsQuery = "SELECT COUNT(DISTINCT itemid) FROM solditems";
//            String itemsPerCategoryQuery = "SELECT category, COUNT(*) FROM solditems GROUP BY category"; // Assuming there's a category field
            String totalUsersQuery = "SELECT COUNT(DISTINCT sold_by) FROM solditems"; // Assuming sold_by is the user field            
             String incomeTodayQuery = "SELECT SUM(total) FROM solditems WHERE DATE(selldate) = CURRENT_DATE"; // Assuming sell_date field
            String incomeThisWeekQuery = "SELECT SUM(total) FROM solditems WHERE DATE_TRUNC('week', selldate) = DATE_TRUNC('week', CURRENT_DATE)";

            
            
            PreparedStatement totalSalesStmt = conn.prepareStatement(totalSalesQuery);
            PreparedStatement totalTransactionsStmt = conn.prepareStatement(totalTransactionsQuery);
            PreparedStatement topSellingItemStmt = conn.prepareStatement(topSellingItemQuery);
//            PreparedStatement totalCustomersStmt = conn.prepareStatement(totalCustomersQuery);
            PreparedStatement totalItemsStmt = conn.prepareStatement(totalItemsQuery);
//            PreparedStatement itemsPerCategoryStmt = conn.prepareStatement(itemsPerCategoryQuery);
            PreparedStatement totalUsersStmt = conn.prepareStatement(totalUsersQuery);
            PreparedStatement incomeTodayStmt = conn.prepareStatement(incomeTodayQuery);
            PreparedStatement incomeThisWeekStmt = conn.prepareStatement(incomeThisWeekQuery);

            ResultSet totalSalesRs = totalSalesStmt.executeQuery();
            ResultSet totalTransactionsRs = totalTransactionsStmt.executeQuery();
            ResultSet topSellingItemRs = topSellingItemStmt.executeQuery();
            ResultSet totalItemsRs = totalItemsStmt.executeQuery();
//            ResultSet itemsPerCategoryRs = itemsPerCategoryStmt.executeQuery();
            ResultSet totalUsersRs = totalUsersStmt.executeQuery();
            ResultSet incomeTodayRs = incomeTodayStmt.executeQuery();
            ResultSet incomeThisWeekRs = incomeThisWeekStmt.executeQuery();

            // Update summary panel labels
            if (totalSalesRs.next()) {
                ((JLabel) summaryPanel.getComponent(0)).setText(createSummaryLabel("Total Sales", "shs." + totalSalesRs.getDouble(1)).getText());
            }
            
            if (incomeTodayRs.next()) {
                ((JLabel) summaryPanel.getComponent(0)).setText(createSummaryLabel("Income Today", "shs." + incomeTodayRs.getDouble(1)).getText());
            }
            
            if (totalTransactionsRs.next()) {
                ((JLabel) summaryPanel.getComponent(1)).setText(createSummaryLabel("Transactions", totalTransactionsRs.getString(1)).getText());
            }
            if (topSellingItemRs.next()) {
                ((JLabel) summaryPanel.getComponent(2)).setText(createSummaryLabel("Top Selling Item", topSellingItemRs.getString(1)).getText());
            }            
            if (totalItemsRs.next()) {
                ((JLabel) summaryPanel.getComponent(4)).setText(createSummaryLabel("Total Items", totalItemsRs.getString(1)).getText());
            }
//            category
//            StringBuilder itemsPerCategory = new StringBuilder();
//            while (itemsPerCategoryRs.next()) {
//                itemsPerCategory.append(itemsPerCategoryRs.getString(1)).append(": ").append(itemsPerCategoryRs.getString(2)).append(", ");
//            }
//            
//            if (itemsPerCategory.length() > 0) {
//                itemsPerCategory.setLength(itemsPerCategory.length() - 2); // Remove the last comma and space
//            }
//            ((JLabel) summaryPanel.getComponent(5)).setText(createSummaryLabel("Items per Category", itemsPerCategory.toString()).getText());
//            
            if (totalUsersRs.next()) {
                ((JLabel) summaryPanel.getComponent(6)).setText(createSummaryLabel("Total Users", totalUsersRs.getString(1)).getText());
            }            

            // Fetch recent transactions
            String recentTransactionsQuery = "SELECT selldate, id, total FROM solditems ORDER BY selldate DESC LIMIT 10";
            PreparedStatement recentTransactionsStmt = conn.prepareStatement(recentTransactionsQuery);
            ResultSet recentTransactionsRs = recentTransactionsStmt.executeQuery();

            while (recentTransactionsRs.next()) {
                Object[] row = {
                    recentTransactionsRs.getDate(1),
                    recentTransactionsRs.getString(2),
                    "shs." + recentTransactionsRs.getDouble(3)
                };
                transactionModel.addRow(row);
            }

            // Fetch top selling items
            String topSellingItemsQuery = "SELECT name, SUM(quantity) FROM solditems GROUP BY name ORDER BY SUM(quantity) DESC LIMIT 10";
            PreparedStatement topSellingItemsStmt = conn.prepareStatement(topSellingItemsQuery);
            ResultSet topSellingItemsRs = topSellingItemsStmt.executeQuery();

            while (topSellingItemsRs.next()) {
                Object[] row = {
                    topSellingItemsRs.getString(1),
                    topSellingItemsRs.getInt(2)
                };
                topSellingModel.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
 // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    }

