/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nexatek;

import static com.nexatek.counter.cash;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.design.JRDesignQuery;
//import net.sf.jasperreports.engine.design.JasperDesign;
//import net.sf.jasperreports.engine.xml.JRXmlLoader;
//import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author KEVINcustoms
 */
public class invoices extends javax.swing.JPanel {
    Connection conn;  
    ResultSet rst;
    PreparedStatement pst; 
    
    public invoices() {
        conn= connection.connect();
        initComponents();
        Update_table();
    }
   
    private void  Update_table(){
        try{
    String sql = "select * from invoices";
    pst = conn.prepareStatement(sql);
    rst = pst.executeQuery();
    invoices.setModel(DbUtils.resultSetToTableModel(rst));
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
    finally{
        try{
          
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenuBar5 = new javax.swing.JMenuBar();
        jMenu10 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jMenuBar6 = new javax.swing.JMenuBar();
        jMenu12 = new javax.swing.JMenu();
        jMenu13 = new javax.swing.JMenu();
        jMenuBar7 = new javax.swing.JMenuBar();
        jMenu14 = new javax.swing.JMenu();
        jMenu15 = new javax.swing.JMenu();
        jFrame1 = new javax.swing.JFrame();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar8 = new javax.swing.JMenuBar();
        jMenu16 = new javax.swing.JMenu();
        jMenu17 = new javax.swing.JMenu();
        jMenuBar9 = new javax.swing.JMenuBar();
        jMenu18 = new javax.swing.JMenu();
        jMenu19 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        invoice = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        view_all = new javax.swing.JButton();
        view_all1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        invoices = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        paybill = new javax.swing.JButton();
        change = new javax.swing.JTextField();
        total = new javax.swing.JTextField();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        jMenu7.setText("jMenu7");

        jMenu8.setText("File");
        jMenuBar4.add(jMenu8);

        jMenu9.setText("Edit");
        jMenuBar4.add(jMenu9);

        jMenu10.setText("File");
        jMenuBar5.add(jMenu10);

        jMenu11.setText("Edit");
        jMenuBar5.add(jMenu11);

        jMenu12.setText("File");
        jMenuBar6.add(jMenu12);

        jMenu13.setText("Edit");
        jMenuBar6.add(jMenu13);

        jMenu14.setText("File");
        jMenuBar7.add(jMenu14);

        jMenu15.setText("Edit");
        jMenuBar7.add(jMenu15);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenuItem1.setText("jMenuItem1");

        jMenu16.setText("File");
        jMenuBar8.add(jMenu16);

        jMenu17.setText("Edit");
        jMenuBar8.add(jMenu17);

        jMenu18.setText("File");
        jMenuBar9.add(jMenu18);

        jMenu19.setText("Edit");
        jMenuBar9.add(jMenu19);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Invoice NO.");

        invoice.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("View");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        view_all.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        view_all.setText("View All Invoices");
        view_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_allActionPerformed(evt);
            }
        });

        view_all1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        view_all1.setText("Sub Cost Prices");
        view_all1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_all1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addComponent(invoice, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 479, Short.MAX_VALUE)
                .addComponent(view_all)
                .addGap(64, 64, 64)
                .addComponent(view_all1)
                .addGap(85, 85, 85))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invoice, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(view_all, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(view_all1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jTabbedPane1.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N

        invoices.setFont(new java.awt.Font("Cantarell", 1, 16)); // NOI18N
        invoices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(invoices);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1682, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(481, 481, 481))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("All", jPanel3);

        jLabel5.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jLabel5.setText("View Invoice history by:");

        jComboBox1.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cleared Invoices", "Uncleared", "Bad Debted" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(941, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(565, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Invoice History", jPanel4);

        paybill.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        paybill.setText("Clear Invoice");
        paybill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paybillActionPerformed(evt);
            }
        });

        change.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N

        total.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(paybill, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(368, 368, 368))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTabbedPane1))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(total)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(change, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                    .addComponent(paybill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void view_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_allActionPerformed
        // TODO add your handling code here:
             try{
    String sql = "select * from invoices";
    pst = conn.prepareStatement(sql);
    rst = pst.executeQuery();
    invoices.setModel(DbUtils.resultSetToTableModel(rst));
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
       
    } 
    finally{
        try{
          
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }  
    }//GEN-LAST:event_view_allActionPerformed
}
    private void view_all1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_all1ActionPerformed
        // TODO add your handling code here:
         
    }//GEN-LAST:event_view_all1ActionPerformed

    private void paybillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paybillActionPerformed
        // TODO add your handling code here:
    cash=Float.valueOf(JOptionPane.showInputDialog("Enter AmountPaid!"));
        
                    DefaultTableModel _totalmodel = (DefaultTableModel) invoices.getModel();
            int rows = _totalmodel.getRowCount();
            for (int i = 0; i < rows; i++) {
                total.setText(_totalmodel.getValueAt(i, 6).toString());
            }
        Float total_=Float.valueOf(total.getText());
        change.setText(String.valueOf(cash-total_));
        
        if(cash>=total_){                        
            Float totalamount = Float.valueOf(total.getText());
           
            LocalDate currentDate = LocalDate.now();
            String time=String.valueOf(currentDate);

            DefaultTableModel model = (DefaultTableModel) invoices.getModel();
            int rowCount = model.getRowCount();            
            // Iterate through the rows and insert data into 'solditems' table
            try {
                String sql = "INSERT INTO solditems (receipt_number, itemId, name, quantity, itemPrice, total,sold_by,time,selldate,cash) VALUES (?, ?, ?, ?, ?, ?,?,?,?,?)";
                String invoiceDetailsSql = "INSERT INTO invoice_details (invoice_number) VALUES (?)";
                pst = conn.prepareStatement(sql);

                try{
                    for (int i = 0; i < rowCount; i++) {
                        
                        pst.setString(1, model.getValueAt(i, 0).toString()); // 
                        pst.setString(2, model.getValueAt(i, 1).toString()); // itemName
                        pst.setString(3, model.getValueAt(i, 2).toString());  //itemId
                        pst.setString(4, model.getValueAt(i, 3).toString()); // itemQuantity
                        pst.setFloat(5, Float.parseFloat(model.getValueAt(i, 4).toString())); // itemPrice
                        pst.setFloat(6,Float.valueOf(total.getText()));
                        pst.setString(7, model.getValueAt(i, 7).toString());
                        pst.setString(8, model.getValueAt(i, 8).toString());
                        pst.setObject(9, currentDate);
                        pst.setFloat(10, cash);
                        pst.executeUpdate();
                    }}
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, e);
                    }

//                    stkup();
//                    sendOutOfStockData();
//                    JOptionPane.showMessageDialog(null, "Transaction successful");
                    receipt_generation();
                    Update_table();
                    
                    cash = null;
                    model.setRowCount(0);
                    total.setText("");
                    change.setText("");

                } catch (SQLException e) {
                }
//            clear();
//                InvoiceNumbers();
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Cash is less than the Total Amount Required!");
        }
    }//GEN-LAST:event_paybillActionPerformed
  //=========================== ==============receipt=====================================================================
 public void receipt_generation() {
        String date = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        // Calculate the total
        double total = 0.0;
        int rowCount = invoices.getRowCount();
        // Create the receipt header
        StringBuilder receiptText = new StringBuilder();
        receiptText.append("                                M.R GENERAL HARDWARE\n");
        receiptText.append("                                        MENGO- Kampala, Uganda\n");
        receiptText.append("                             chipcodetechnologies@gmail.com\n");
        receiptText.append("                                Phone: (256) 700-562982\n");
        receiptText.append("                    -----------------------------------------------------\n");
        receiptText.append("                                Date: ").append(date).append("\n\n");
        receiptText.append("\n");
        receiptText.append("               Items             Qty                 Price\n");
        receiptText.append("            ------------------------------------------------------------\n");
        // Add the items and prices
        for (int i = 0; i < rowCount; i++) {
            String itemNameWithSize = invoices.getValueAt(i, 2).toString();
            String itemQuantity = invoices.getValueAt(i, 3).toString();
            String itemSubTotal = invoices.getValueAt(i, 5).toString();

            receiptText.append(String.format("        %-30s %-10s %s\n", itemNameWithSize, itemQuantity, itemSubTotal));
            total += Double.parseDouble(itemSubTotal);
        }
        receiptText.append("\n");
        receiptText.append("                 ----------------------------------------------------\n");
        receiptText.append(String.format("          TOTAL:          %.2f\n", total));
        receiptText.append("                 ----------------------------------------------------\n");
        receiptText.append(String.format("          TOTAL:          %.2f\n", total));
        receiptText.append("\n\n");
        receiptText.append("                         Thank you for shopping!\n");
        receiptText.append("                *********************************\n");

        // Preview the receipt in a popup
        JTextArea textArea = new JTextArea(receiptText.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 500));

        JButton printButton = new JButton("Print");
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printReceipt(textArea);
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(printButton, BorderLayout.SOUTH);

        JDialog dialog = new JDialog((Frame) null, "Receipt Preview", true);
        dialog.getContentPane().add(panel);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

        // Save the receipt to a file
        saveReceiptToFile(receiptText.toString());
    }
 private void printReceipt(JTextArea textArea) {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(textArea.getPrintable(null, null));
        if (job.printDialog()) {
            try {
                job.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void saveReceiptToFile(String receiptText) {
        String filename = "/home/chipcodedev/Desktop/Invoices/invoice.txt"; // Set the filename
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(receiptText);
            System.out.println("Invoice saved to file '" + filename + "'");
        } catch (IOException e) {
            System.err.println("Failed to write Invoice to file: " + e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField change;
    private javax.swing.JTextField invoice;
    private javax.swing.JTable invoices;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu17;
    private javax.swing.JMenu jMenu18;
    private javax.swing.JMenu jMenu19;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuBar jMenuBar5;
    private javax.swing.JMenuBar jMenuBar6;
    private javax.swing.JMenuBar jMenuBar7;
    private javax.swing.JMenuBar jMenuBar8;
    private javax.swing.JMenuBar jMenuBar9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton paybill;
    private javax.swing.JTextField total;
    private javax.swing.JButton view_all;
    private javax.swing.JButton view_all1;
    // End of variables declaration//GEN-END:variables
}
