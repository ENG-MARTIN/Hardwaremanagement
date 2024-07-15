/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nexatek;

import com.lowagie.text.Element;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author engmartin
 */
public class sales extends javax.swing.JPanel {
    Connection conn;
    ResultSet rst;
    PreparedStatement pst;
    public sales() {
        conn= connection.connect();
        initComponents();
        Update_table();  
        totalsales();
        
        
        view_all1.setVisible(false);
    }

    private void costprices(){
        try{
    String sql = "select SUM(total) from solditems";
    pst = conn.prepareStatement(sql);
    rst = pst.executeQuery();    
//    String sum=String.valueOf(rst);
    total.setText(String.valueOf(rst));
//    JOptionPane.showMessageDialog(null, sum);
    }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void  Update_table(){
        try{
            String invoice=invoice_no.getText();
//    String sql = "select * from solditems where invoice_number='"+invoice+"'";
    String sql = "select * from solditems";
    pst = conn.prepareStatement(sql);
    rst = pst.executeQuery();
    invoice_details.setModel(DbUtils.resultSetToTableModel(rst));
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
    
    private void searchInvoicesByDate() {
    try {
        // Get the selected dates from your JDateChooser components
        Date startDate = startDateChooser.getDate();
        Date endDate = endDateChooser.getDate();

        // Construct the SQL query for searching by date range
        String sql = "SELECT * FROM solditems WHERE selldate BETWEEN ? AND ?";
        pst = conn.prepareStatement(sql);

        // Set the start and end dates to the prepared statement
        pst.setDate(1, new java.sql.Date(startDate.getTime()));
        pst.setDate(2, new java.sql.Date(endDate.getTime()));

        rst = pst.executeQuery();

        // Set the result to your table model (replace with your actual table model)
        invoice_details.setModel(DbUtils.resultSetToTableModel(rst));
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        invoice_details = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        invoice_no = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        startDateChooser = new com.toedter.calendar.JDateChooser();
        endDateChooser = new com.toedter.calendar.JDateChooser();
        check = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        periodic_sales = new javax.swing.JComboBox<>();
        invoice_status = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        view_all1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        percent = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        export = new javax.swing.JButton();
        print = new javax.swing.JButton();

        invoice_details.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        invoice_details.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "SALES ID", "INVOICE NO.", "CUSTOMER", "ITEMS", "AMOUNT", "CASH", "DATE", "TIME"
            }
        ));
        invoice_details.setRowHeight(40);
        jScrollPane1.setViewportView(invoice_details);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel1.setFont(new java.awt.Font("Noto Sans", 1, 16)); // NOI18N
        jLabel1.setText("Enter receipt number");

        invoice_no.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        invoice_no.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        invoice_no.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                invoice_noKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                invoice_noKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(invoice_no, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(invoice_no, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel4.setText("Search  by sales info");

        jLabel3.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jLabel3.setText("Start Date");

        jLabel5.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jLabel5.setText("End Date");

        check.setFont(new java.awt.Font("Noto Sans", 1, 24)); // NOI18N
        check.setForeground(new java.awt.Color(0, 102, 51));
        check.setText("CHECK");
        check.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel7.setText("Search  Sale by Date ");

        periodic_sales.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        periodic_sales.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Today", "This Week", "This Month", "This Year", "Highly Sold", "Highest Profit" }));
        periodic_sales.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                periodic_salesItemStateChanged(evt);
            }
        });
        periodic_sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                periodic_salesActionPerformed(evt);
            }
        });

        invoice_status.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        invoice_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash Sales", "Invoiced Sales", "Partial" }));
        invoice_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoice_statusActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Noto Sans", 1, 16)); // NOI18N
        jLabel6.setText("Status");

        view_all1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        view_all1.setText("Compare Cost Prices");
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(endDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(check, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(periodic_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(invoice_status, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(view_all1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(check, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel7))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(startDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(invoice_status, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(view_all1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(periodic_sales)
                            .addComponent(endDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(40, 40, 40))
        );

        jLabel8.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel8.setText("Percentage");

        percent.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel10.setText("Total Income ");

        total.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N

        export.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        export.setText("Export");
        export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportActionPerformed(evt);
            }
        });

        print.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel8)
                .addGap(30, 30, 30)
                .addComponent(percent, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(export, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(percent, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(export, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void invoice_noKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_invoice_noKeyTyped
        // TODO add your handling code here:
          if (evt.getKeyChar() == KeyEvent.VK_ENTER) {     
        try {
            // Convert the text to an integer
            int searchCriteria = Integer.parseInt(invoice_no.getText().trim());

            // Construct the SQL query for searching
            String sql = "SELECT * FROM solditems WHERE receipt_number = ?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, searchCriteria);
            rst = pst.executeQuery();       

            invoice_details.setModel(DbUtils.resultSetToTableModel(rst));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid invoice number. Please enter an integer.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    }//GEN-LAST:event_invoice_noKeyTyped

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
        // TODO add your handling code here:
        searchInvoicesByDate();
    }//GEN-LAST:event_checkActionPerformed

    private void invoice_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoice_statusActionPerformed
        // TODO add your handling code here:
       String selectedStatus = invoice_status.getSelectedItem().toString();
    TableRowSorter<TableModel> sorter = new TableRowSorter<>(invoice_details.getModel());
    invoice_details.setRowSorter(sorter);

    if (!"All".equals(selectedStatus)) {
        RowFilter<Object, Object> rowFilter = RowFilter.regexFilter("(?i)" + selectedStatus, invoice_details.getColumnModel().getColumnIndex("status"));
        sorter.setRowFilter(rowFilter);
    } else {
        sorter.setRowFilter(null); // Show all rows
    }
    }//GEN-LAST:event_invoice_statusActionPerformed

    private void invoice_noKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_invoice_noKeyPressed
        // TODO add your handling code here:
         if (evt.getKeyChar() == KeyEvent.VK_ENTER) {     
        try {
            // Convert the text to an integer
            int searchCriteria = Integer.parseInt(invoice_no.getText().trim());

            // Construct the SQL query for searching
            String sql = "SELECT * FROM solditems WHERE receipt_number = ?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, searchCriteria);
            rst = pst.executeQuery();       

            invoice_details.setModel(DbUtils.resultSetToTableModel(rst));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid invoice number. Please enter an integer.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    }//GEN-LAST:event_invoice_noKeyPressed

    private void view_all1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_all1ActionPerformed
        // TODO add your handling code here:
costprices();
    }//GEN-LAST:event_view_all1ActionPerformed

    private void periodic_salesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_periodic_salesItemStateChanged
        // TODO add your handling code here:
       
   
    }//GEN-LAST:event_periodic_salesItemStateChanged

    private void periodic_salesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_periodic_salesActionPerformed
        // TODO add your handling code here:
//        JOptionPane.showConfirmDialog(null, "working");
                   String query = "";
                   String filter=periodic_sales.getSelectedItem().toString();
        switch (filter) {
            case "Today":
                query = "SELECT * FROM solditems WHERE selldate = CURRENT_DATE";
                break;
            case "This Week":
                query = "SELECT * FROM solditems WHERE selldate >= CURRENT_DATE - INTERVAL '7 days'";
                break;
            case "This Month":
                query = "SELECT * FROM solditems WHERE EXTRACT(MONTH FROM selldate) = EXTRACT(MONTH FROM CURRENT_DATE) " +
                        "AND EXTRACT(YEAR FROM selldate) = EXTRACT(YEAR FROM CURRENT_DATE)";
                break;
            case "This Year":
                query = "SELECT * FROM solditems WHERE EXTRACT(YEAR FROM selldate) = EXTRACT(YEAR FROM CURRENT_DATE)";
                break;
            case "Highly Sold":
                query = "SELECT * FROM solditems ORDER BY quantity DESC";
                break;
            case "Highest Profit":
                query = "SELECT * FROM solditems ORDER BY total DESC";
                break;
        }
            try{
             pst= conn.prepareStatement(query);
             rst = pst.executeQuery();

      invoice_details.setModel(DbUtils.resultSetToTableModel(rst));
      totalsales();

        } catch (SQLException e) {
            e.printStackTrace();
        }
 
    }//GEN-LAST:event_periodic_salesActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here:
         String directoryPath = "/home/chipcodedev/Desktop/Mr hardware";
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        String filePath = directoryPath + File.separator + "SalesReport.pdf";


        // Create a PDF document
        com.lowagie.text.Document document = new com.lowagie.text.Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // Add table to PDF
            PdfPTable pdfTable = new PdfPTable(invoice_details.getColumnCount());
            pdfTable.setWidthPercentage(100);

            // Add table header
            for (int i = 0; i < invoice_details.getColumnCount(); i++) {
                PdfPCell cell = new PdfPCell(new Phrase(invoice_details.getColumnName(i)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfTable.addCell(cell);
            }

            // Add table rows
            for (int rows = 0; rows < invoice_details.getRowCount(); rows++) {
                for (int cols = 0; cols < invoice_details.getColumnCount(); cols++) {
                    pdfTable.addCell(invoice_details.getModel().getValueAt(rows, cols).toString());
                }
            }

            document.add(pdfTable);
            JOptionPane.showMessageDialog(null, "PDF created successfully at Reprts folder: SalesReport.pdf ");

        } catch (FileNotFoundException | com.lowagie.text.DocumentException e) {
            JOptionPane.showMessageDialog(null, "Error creating PDF: " + e.getMessage());
        } finally {
            document.close();
        }
    }//GEN-LAST:event_printActionPerformed

    private void exportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_exportActionPerformed

 public void totalsales() {
    // Assuming 'total' is in column index 6 and 'profit' is in column index 11
    double totalAmount = 0.0;
    double grandTotalProfit = 0.0;

    for (int i = 0; i < invoice_details.getRowCount(); i++) {
        double total = Double.parseDouble(invoice_details.getValueAt(i, 6).toString()); // Column index for 'total'
        double profit = Double.parseDouble(invoice_details.getValueAt(i, 11).toString()); // Column index for 'profit'
        int quantity = Integer.parseInt(invoice_details.getValueAt(i, 4).toString()); // Column index for 'quantity'

        double totalProfit = profit * quantity;

        totalAmount += total;
        grandTotalProfit += totalProfit;
    }

    double percentage = 0.0;
    if (totalAmount > 0) {
        percentage = (grandTotalProfit / totalAmount) * 100;
    }

    // Update the text fields
    total.setText(String.format("%.2f", totalAmount));
    percent.setText(String.format("%.2f%%", percentage));
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton check;
    private com.toedter.calendar.JDateChooser endDateChooser;
    private javax.swing.JButton export;
    private javax.swing.JTable invoice_details;
    private javax.swing.JTextField invoice_no;
    private javax.swing.JComboBox<String> invoice_status;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField percent;
    private javax.swing.JComboBox<String> periodic_sales;
    private javax.swing.JButton print;
    private com.toedter.calendar.JDateChooser startDateChooser;
    private javax.swing.JTextField total;
    private javax.swing.JButton view_all1;
    // End of variables declaration//GEN-END:variables
}
