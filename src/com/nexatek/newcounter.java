/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.nexatek;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author chipcodedev
 */
public class newcounter extends javax.swing.JFrame {

    private JTable productTable;
    private JTable cartTable;
    private DefaultTableModel productTableModel;
    private DefaultTableModel cartTableModel;
    private JTextField barcodeField;
    private JTextField searchField;
    private JTextField paymentField;
    private JLabel totalLabel;
    private JLabel changeLabel;
    private JComboBox<String> paymentMethodComboBox;
    
    public newcounter() {
        initComponents();
    
        setTitle("Enhanced POS System");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // Barcode and Search Panel
        JPanel topPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        barcodeField = new JTextField();
        barcodeField.setBorder(BorderFactory.createTitledBorder("Barcode Reader"));
        searchField = new JTextField();
        searchField.setBorder(BorderFactory.createTitledBorder("Search Products"));
        topPanel.add(barcodeField);
        topPanel.add(searchField);
        add(topPanel, BorderLayout.NORTH);

        // Product Panel
        JPanel productPanel = new JPanel(new BorderLayout());
        productPanel.setBorder(BorderFactory.createTitledBorder("Products"));

        String[] productColumns = {"ID", "Product", "Price"};
        productTableModel = new DefaultTableModel(productColumns, 0);
        productTable = new JTable(productTableModel);
        productTable.setFont(new Font("Arial", Font.PLAIN, 18));
        productTable.setRowHeight(30);
        JScrollPane productScrollPane = new JScrollPane(productTable);
        productPanel.add(productScrollPane, BorderLayout.CENTER);

        // Cart Panel
        JPanel cartPanel = new JPanel(new BorderLayout());
        cartPanel.setBorder(BorderFactory.createTitledBorder("Cart"));

        String[] cartColumns = {"Product", "Price", "Quantity", "Total"};
        cartTableModel = new DefaultTableModel(cartColumns, 0);
        cartTable = new JTable(cartTableModel);
        cartTable.setFont(new Font("Arial", Font.PLAIN, 18));
        cartTable.setRowHeight(30);
        JScrollPane cartScrollPane = new JScrollPane(cartTable);
        cartPanel.add(cartScrollPane, BorderLayout.CENTER);

        // Cart Control Panel
        JPanel cartControlPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        paymentField = new JTextField();
        paymentField.setBorder(BorderFactory.createTitledBorder("Payment Amount"));
        paymentField.setFont(new Font("Arial", Font.PLAIN, 18));
        paymentMethodComboBox = new JComboBox<>(new String[]{"Cash", "Credit", "Other"});
        paymentMethodComboBox.setBorder(BorderFactory.createTitledBorder("Payment Method"));
        JButton processSaleButton = new JButton("Process Sale");
        processSaleButton.setFont(new Font("Arial", Font.PLAIN, 18));

        JButton logout = new JButton("Logout");
        logout.setFont(new Font("Arial", Font.PLAIN, 18));
        
        cartControlPanel.add(paymentField);
        cartControlPanel.add(paymentMethodComboBox);
        cartControlPanel.add(processSaleButton);

        // Total and Change Labels
        totalLabel = new JLabel("Total: $0.00");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 24));
        changeLabel = new JLabel("Change: $0.00");
        changeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        JPanel totalsPanel = new JPanel(new GridLayout(2, 1));
        totalsPanel.add(totalLabel);
        totalsPanel.add(changeLabel);

        cartPanel.add(cartControlPanel, BorderLayout.NORTH);
        cartPanel.add(totalsPanel, BorderLayout.SOUTH);

        // Add panels to frame
        add(productPanel, BorderLayout.WEST);
        add(cartPanel, BorderLayout.CENTER);

        // Fetch products from database and populate table
        populateProductTable();

        // Search field listener
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterProducts();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterProducts();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterProducts();
            }

            private void filterProducts() {
                String searchText = searchField.getText().toLowerCase();
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(productTableModel);
                productTable.setRowSorter(sorter);
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText));
            }
        });

        // Product table click listener
        productTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = productTable.getSelectedRow();
                if (selectedRow != -1) {
                    String productName = (String) productTableModel.getValueAt(selectedRow, 1);
                    double price = (double) productTableModel.getValueAt(selectedRow, 2);
                    addToCart(productName, price);
                }
            }
        });
        
         // Cart table model listener for quantity changes
        cartTableModel.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int row = e.getFirstRow();
                    int col = e.getColumn();
                    if (col == 2) { // Quantity column changed
//                        updateTotal();

                    }
                }
            }
        });


       // Cart table click listener for removing items on right-click
cartTable.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1) { // Check for right-click
            int selectedRow = cartTable.rowAtPoint(e.getPoint());
            if (selectedRow != -1) {
                int response = JOptionPane.showConfirmDialog(null, "Do you want to remove this item?", "Remove Item", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    cartTableModel.removeRow(selectedRow);
                    updateTotal();
                }
            }
        }
    }
});


        // Process Sale button action
        processSaleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processSale();
            }
        });

        // Quantity change listener
        cartTable.getModel().addTableModelListener(e -> updateTotal());

        // Barcode field action
        barcodeField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String barcode = barcodeField.getText().trim();
                addProductByBarcode(barcode);
                barcodeField.setText("");
            }
        });
    }

    private void populateProductTable() {
        try (Connection conn = connection.connect()) {
            if (conn == null) {
                JOptionPane.showMessageDialog(this, "Failed to connect to the database.", "Database Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String query = "SELECT * FROM products";
            try (PreparedStatement statement = conn.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    String id = resultSet.getString("productid");
                    String productName = resultSet.getString("name");
                    double price = resultSet.getDouble("price");
                    productTableModel.addRow(new Object[]{id, productName, price});
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error fetching products: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addProductByBarcode(String barcode) {
        for (int i = 0; i < productTableModel.getRowCount(); i++) {
            if (productTableModel.getValueAt(i, 0).equals(barcode)) {
                String productName = (String) productTableModel.getValueAt(i, 1);
                double price = Double.parseDouble((String) productTableModel.getValueAt(i, 2));
                addToCart(productName, price);
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Product not found!", "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void addToCart(String productName, double price) {
        for (int i = 0; i < cartTableModel.getRowCount(); i++) {
            if (cartTableModel.getValueAt(i, 0).equals(productName)) {
                int quantity = (int) cartTableModel.getValueAt(i, 2) + 1;
                double total = price * quantity;
                cartTableModel.setValueAt(quantity, i, 2);
                cartTableModel.setValueAt(total, i, 3);
                updateTotal();
                return;
            }
        }
        cartTableModel.addRow(new Object[]{productName, price, 1, price});
        updateTotal();
    }

    private void processSale() {
        double total = 0;
        for (int i = 0; i < cartTableModel.getRowCount(); i++) {
            total += (double) cartTableModel.getValueAt(i, 3);
        }
        double payment = 0;
        try {
            payment = Double.parseDouble(paymentField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid payment amount!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        double change = payment - total;
        if (change < 0) {
            JOptionPane.showMessageDialog(this, "Insufficient payment!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        changeLabel.setText("Change: $" + String.format("%.2f", change));
        JOptionPane.showMessageDialog(this, "Sale processed successfully!", "Sale", JOptionPane.INFORMATION_MESSAGE);
        generateReceipt(total, change);
        cartTableModel.setRowCount(0);
        updateTotal();
    }

    private void generateReceipt(double total, double change) {
        StringBuilder receipt = new StringBuilder();
        receipt.append("********** RECEIPT **********\n");
        receipt.append("Date: ").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).append("\n\n");
        receipt.append("Product\tPrice\tQuantity\tTotal\n");
        for (int i = 0; i < cartTableModel.getRowCount(); i++) {
            String product = (String) cartTableModel.getValueAt(i, 0);
            double price = (double) cartTableModel.getValueAt(i, 1);
            int quantity = (int) cartTableModel.getValueAt(i, 2);
            double totalAmount = (double) cartTableModel.getValueAt(i, 3);
            receipt.append(product).append("\t").append(price).append("\t").append(quantity).append("\t").append(totalAmount).append("\n");
        }
        receipt.append("\nTotal: $").append(String.format("%.2f", total)).append("\n");
        receipt.append("Payment Method: ").append(paymentMethodComboBox.getSelectedItem()).append("\n");
        receipt.append("Change: $").append(String.format("%.2f", change)).append("\n");

        JTextArea receiptArea = new JTextArea(receipt.toString());
        receiptArea.setEditable(false);
        receiptArea.setFont(new Font("Arial", Font.PLAIN, 18));
        JScrollPane receiptScrollPane = new JScrollPane(receiptArea);
        receiptScrollPane.setPreferredSize(new Dimension(400, 300));

        JOptionPane.showMessageDialog(this, receiptScrollPane, "Receipt Preview", JOptionPane.INFORMATION_MESSAGE);
    }

    private void updateTotal() {
        double total = 0;
        for (int i = 0; i < cartTableModel.getRowCount(); i++) {
            total += (double) cartTableModel.getValueAt(i, 3);
        }
        totalLabel.setText("Total: $" + String.format("%.2f", total));            
    }   
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Logout");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(320, 320, 320))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 275, Short.MAX_VALUE)
                .addComponent(jButton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(newcounter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newcounter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newcounter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newcounter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new newcounter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
