/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package com.nexatek;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileOutputStream;
import static java.lang.Thread.sleep;
import java.sql.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
 * @author mrrobot
 */
public class sales_admin extends javax.swing.JPanel {
 Connection conn;
 ResultSet rst;
 PreparedStatement pst;
 PreparedStatement pstInsert;
 PreparedStatement pstDelete;
 public Double Stcok_qty = 0.0;
 static String customer_name;
  static String telephone_number;
  static Float cash;
 
     public sales_admin() {
        conn= connection.connect();
        initComponents();
        items.getTableHeader().setFont( new Font("segoe UI", Font.BOLD,18));
        items.getTableHeader().setOpaque(true);
        items.getTableHeader().setBackground(new Color(242,242,242));
        items.getTableHeader().setForeground(new Color(0,0,255)); 
                
         DefaultTableModel model = new DefaultTableModel();
        items.setModel(model);
          model.addColumn("IID");
        model.addColumn("BARCODE");
        model.addColumn("NAME");
        model.addColumn("QUANTITY");
        model.addColumn("UNIT-PRICE");
        model.addColumn("SUB-TOTAL");
        currentdate();
        calculateTotal();
        InvoiceNumbers();   
        Update_table();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        counter = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        barcode = new javax.swing.JTextField();
        search_category = new javax.swing.JTextField();
        time = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        products_table = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        stock_qty = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        invoice_no = new javax.swing.JTextField();
        logout = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        INVOICES = new javax.swing.JButton();
        finish = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        total_amount = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        change = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        items = new javax.swing.JTable();

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        counter.setFont(new java.awt.Font("Lato Semibold", 1, 18)); // NOI18N
        counter.setText("User");

        jLabel3.setFont(new java.awt.Font("Lato Semibold", 1, 18)); // NOI18N
        jLabel3.setText("Search By BarCode");

        jLabel4.setFont(new java.awt.Font("Lato Semibold", 1, 18)); // NOI18N
        jLabel4.setText("Search By Category");

        barcode.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N

        search_category.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N

        time.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Lato Semibold", 1, 18)); // NOI18N
        jLabel6.setText("Search Item");

        name.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel3)
                .addGap(46, 46, 46)
                .addComponent(barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jLabel6)
                .addGap(49, 49, 49)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(search_category, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(counter)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(search_category, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3))
                            .addComponent(jLabel3))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(counter)
                            .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))))
        );

        products_table.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        products_table.setModel(new javax.swing.table.DefaultTableModel(
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
        products_table.setRowHeight(30);
        products_table.setRowSelectionAllowed(false);
        products_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                products_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(products_table);

        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel10.setText("Sale No.");

        jLabel12.setText("Quantity");

        stock_qty.setText("stck");

        quantity.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quantityKeyPressed(evt);
            }
        });

        invoice_no.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel10)
                .addGap(38, 38, 38)
                .addComponent(invoice_no)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addGap(29, 29, 29)
                .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(262, 262, 262)
                .addComponent(stock_qty)
                .addGap(50, 50, 50))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(invoice_no, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stock_qty))
                .addGap(23, 23, 23))
        );

        logout.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        logout.setText("LogOut");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setForeground(new java.awt.Color(204, 204, 204));

        INVOICES.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        INVOICES.setText("Issue Invoice");
        INVOICES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INVOICESActionPerformed(evt);
            }
        });

        finish.setFont(new java.awt.Font("Cantarell", 1, 48)); // NOI18N
        finish.setText("Pay");
        finish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jLabel7.setText("Total Amount");

        total_amount.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jLabel8.setText("Change");

        change.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N

        jComboBox1.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash Sale", "Credit", "Partial", "Cheque" }));

        items.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        items.setModel(new javax.swing.table.DefaultTableModel(
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
        items.setRowHeight(30);
        items.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(items);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(total_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(62, 62, 62)
                        .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(INVOICES, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(133, 133, 133)
                        .addComponent(finish, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(87, 87, 87))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(INVOICES, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(finish)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(total_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 875, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1026, Short.MAX_VALUE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void products_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_products_tableMouseClicked
        // TODO add your handling code here:
        try {
            DefaultTableModel t = (DefaultTableModel) products_table.getModel();
            int i = products_table.getSelectedRow();
            id.setText(t.getValueAt(i, 0).toString());
            barcode.setText(t.getValueAt(i, 1).toString());
            name.setText(t.getValueAt(i, 2).toString());
            search_category.setText(t.getValueAt(i, 6).toString());
            price.setText(t.getValueAt(i, 4).toString());
            String q_=JOptionPane.showInputDialog(null, "Enter Quantity");
            quantity.setText(q_);
            String sql = "select quantity from products where productid = '"+id.getText()+"'";

            try {
                pst = conn.prepareStatement(sql);
                rst = pst.executeQuery();
                if (rst.next()) {
                    String quantity1 = rst.getString("quantity");
                    stock_qty.setText(quantity1);
                }
            } catch (SQLException ex) {
                Logger.getLogger(sales_admin.class.getName()).log(Level.SEVERE, null, ex);
            }

            // ================================= ADDING TO ITEMS TABLE =================================

            // Get the model of the items table
            DefaultTableModel model = (DefaultTableModel) items.getModel();

            // Define the necessary variables
            String itemId = id.getText();
            String itemBarcode = barcode.getText();
            String itemName = search_category.getText();
            String itemQuantity = quantity.getText();
            String itemUnitPrice = price.getText(); // You need to fetch or define this value

            //       ================== total=================
            float p=Float.parseFloat(itemUnitPrice);
            float q=Float.parseFloat(itemQuantity);
            float t_=p*q;
            String total_=String.valueOf(t_);

            String itemSubTotal = total_;
            total_amount.setText(itemSubTotal);

            // Add the selected product to the items table
            model.addRow(new Object[]{itemId, itemBarcode, itemName, itemQuantity, itemUnitPrice, itemSubTotal});

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_products_tableMouseClicked

    private void quantityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // Check if the quantity field is not empty
            if (!quantity.getText().trim().isEmpty()) {
                int stqty = Integer.parseInt(stock_qty.getText());
                int selqty = Integer.parseInt(quantity.getText());

                float priceField = Float.parseFloat(price.getText());
                int idforuse = Integer.parseInt(id.getText());

                if (selqty > 0) {
                    if (selqty <= stqty) { // Combine conditions
                        String sql = "select price from products where productid = ?";
                        try {
                            pst = conn.prepareStatement(sql);
                            pst.setInt(1, idforuse);
                            rst = pst.executeQuery();
                            if (rst.next()) {

                                String itemId = id.getText();
                                String itemBarcode = barcode.getText();
                                String itemName = search_category.getText();
                                String itemPrice = price.getText();
                                String itemQuantity = quantity.getText();

                                // Calculating the subtotal
                                Float q = Float.valueOf(itemQuantity);
                                Float p = Float.valueOf(itemPrice);
                                Float t = q * p;
                                String sub_total = String.valueOf(t);

                                String[] rowData = {itemId, itemBarcode, itemName, itemQuantity, itemPrice, sub_total};

                                // Get the model of the 'items' table
                                DefaultTableModel model = (DefaultTableModel) items.getModel();

                                // Check if there are any rows in the table
                                if (model.getRowCount() > 0) {
                                    // Delete the last row
                                    model.removeRow(model.getRowCount() - 1);
                                }
                                model.addRow(rowData);
                                calculateTotal();
                                //                                clear();
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(oldcounter.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "The quantity you have inserted is bigger or the product is out of stock");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "The value you have inserted is invalid, please check the value and try again");
                }
            } else {
                JOptionPane.showMessageDialog(null, "The quantity field cannot be empty");
            }

        }
    }//GEN-LAST:event_quantityKeyPressed

    private void itemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemsMouseClicked
        // TODO add your handling code here:
        try {
            // Handle the left-click event
            if (SwingUtilities.isLeftMouseButton(evt)) {
                DefaultTableModel t = (DefaultTableModel) products_table.getModel();
                int i = products_table.getSelectedRow();
                id.setText(t.getValueAt(i, 0).toString());
                barcode.setText(t.getValueAt(i, 1).toString());
                search_category.setText(t.getValueAt(i, 2).toString());
                quantity.setText("1");
                //quantity.setText(t.getValueAt(i, 5).toString());
            }
            // Handle the right-click event
            if (SwingUtilities.isRightMouseButton(evt)) {
                int row = items.rowAtPoint(evt.getPoint());
                if (row >= 0 && row < items.getRowCount()) {
                    items.setRowSelectionInterval(row, row);

                    // Show confirmation dialog
                    int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove the item?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                    if (response == JOptionPane.YES_OPTION) {
                        DefaultTableModel t = (DefaultTableModel) items.getModel();
                        t.removeRow(row);
                    }
                }
            }
            // Customize the table header if not already done
            items.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 18));
            items.getTableHeader().setOpaque(true);
            items.getTableHeader().setBackground(new Color(242, 242, 242));
            items.getTableHeader().setForeground(new Color(0, 0, 255));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_itemsMouseClicked

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        LOGIN login = new LOGIN();
        login.setVisible(true);
    }//GEN-LAST:event_logoutActionPerformed

    private void INVOICESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INVOICESActionPerformed
        // TODO add your handling code here:
        String c_name= JOptionPane.showInputDialog(null, "Enter Customer Name");
        String contact=JOptionPane.showInputDialog(null, "Enter Customer's contact");

        int q=Integer.parseInt(quantity.getText());
        int st=Integer.parseInt(stock_qty.getText());

        Float totalamount = Float.valueOf(total_amount.getText());

        LocalDate currentDate = LocalDate.now();

        DefaultTableModel model = (DefaultTableModel) items.getModel();
        int rowCount = model.getRowCount();

        // Iterate through the rows and insert data into 'solditems' table
        try {
            String sql = "INSERT INTO invoices (invoice_number, itemId, name, quantity, itemPrice, total,sold_by,time,selldate, customer_name, contact) VALUES (?, ?,?, ?, ?, ?, ?,?,?,?,?)";
            String invoiceDetailsSql = "INSERT INTO invoice_details (invoice_number) VALUES (?)";

            pst = conn.prepareStatement(sql);
            PreparedStatement invoiceDetailsPst = conn.prepareStatement(invoiceDetailsSql);
            //    PreparedStatement customerPst=conn.prepareStatement(customerSql);

            pst.setString(1,invoice_no.getText());
            pst.setInt(1, Integer.valueOf(invoice_no.getText()));
            invoiceDetailsPst.setInt(1, Integer.valueOf(invoice_no.getText()));
            //         customerPst.setInt(3, Integer.valueOf(invoice_no.getText()));

            try{
                for (int i = 0; i < rowCount; i++) {
                    pst.setString(2, model.getValueAt(i, 0).toString()); // itemId
                    pst.setString(3, model.getValueAt(i, 2).toString()); // itemName
                    pst.setInt(4, Integer.parseInt(model.getValueAt(i, 3).toString())); // itemQuantity
                    pst.setFloat(5, Float.parseFloat(model.getValueAt(i, 4).toString())); // itemPrice
                    pst.setFloat(6,Float.valueOf(total_amount.getText()));
                    pst.setString(7, counter.getText());
                    pst.setString(8, time.getText());
                    pst.setObject(9, currentDate);
                    pst.setString(10, c_name);
                    pst.setString(11, contact);
                    pst.executeUpdate();
                }}
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }

                stkup();

                //                    invoiceDetailsPst.executeUpdate();
                Invoice_generation();
                Update_table();

                cash = null;
                model.setRowCount(0);
                total_amount.setText("");
                change.setText("");

            } catch (SQLException e) {
            }
            clear();
            InvoiceNumbers();

    }//GEN-LAST:event_INVOICESActionPerformed

    private void finishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishActionPerformed
        // TODO add your handling code here:
        cash=Float.valueOf(JOptionPane.showInputDialog("Enter AmountPaid!"));

        Float total_=Float.valueOf(total_amount.getText());
        change.setText(String.valueOf(cash-total_));

        int q=Integer.parseInt(quantity.getText());
        int st=Integer.parseInt(stock_qty.getText());
        if(cash>=total_){

            if (q>st){
                JOptionPane.showMessageDialog(null, "You requested for" +quantity.getText()+"items but"+stock_qty.getText()+ " are left in stock! ");
            }

            Float totalamount = Float.valueOf(total_amount.getText());
            String Status = null;

            if (totalamount <= cash) {

            }

            LocalDate currentDate = LocalDate.now();

            DefaultTableModel model = (DefaultTableModel) items.getModel();
            int rowCount = model.getRowCount();

            // Iterate through the rows and insert data into 'solditems' table
            try {
                String sql = "INSERT INTO solditems (receipt_number, itemId, name, quantity, itemPrice, total,sold_by,time,selldate,cash) VALUES (?, ?, ?, ?, ?, ?,?,?,?,?)";
                String invoiceDetailsSql = "INSERT INTO invoice_details (invoice_number) VALUES (?)";
                //    String customerSql="insert into customers(customer_name,phone_number,invoice_number) values(?,?,?)";

                pst = conn.prepareStatement(sql);
                PreparedStatement invoiceDetailsPst = conn.prepareStatement(invoiceDetailsSql);
                //    PreparedStatement customerPst=conn.prepareStatement(customerSql);

                pst.setString(1,invoice_no.getText());
                pst.setInt(1, Integer.valueOf(invoice_no.getText()));
                invoiceDetailsPst.setInt(1, Integer.valueOf(invoice_no.getText()));
                //         customerPst.setInt(3, Integer.valueOf(invoice_no.getText()));

                try{
                    for (int i = 0; i < rowCount; i++) {
                        pst.setString(2, model.getValueAt(i, 0).toString()); // itemId
                        pst.setString(3, model.getValueAt(i, 2).toString()); // itemName
                        pst.setInt(4, Integer.parseInt(model.getValueAt(i, 3).toString())); // itemQuantity
                        pst.setFloat(5, Float.parseFloat(model.getValueAt(i, 4).toString())); // itemPrice
                        pst.setFloat(6,Float.valueOf(total_amount.getText()));
                        pst.setString(7, counter.getText());
                        pst.setString(8, time.getText());
                        pst.setObject(9, currentDate);
                        pst.setFloat(10, cash);
                        pst.executeUpdate();
                    }}
                    catch(Exception e){
                        JOptionPane.showMessageDialog(null, e);
                    }

                    stkup();
                    sendOutOfStockData();
                    invoiceDetailsPst.executeUpdate();
                    //                    JOptionPane.showMessageDialog(null, "Transaction successful");
                    receipt_generation();
                    Update_table();

                    cash = null;
                    model.setRowCount(0);
                    total_amount.setText("");
                    change.setText("");

                } catch (SQLException e) {
                }
                clear();
                InvoiceNumbers();

            }
            else{
                JOptionPane.showMessageDialog(null, "Cash is less than the Total Amount Required!");
            }
    }//GEN-LAST:event_finishActionPerformed

    
//    =============================================================================================================================
    public void currentdate() {

        Thread clock = new Thread() {
            
            public void run() {
                for (;;) {
                    Calendar cal = new GregorianCalendar();
                    int month = cal.get(Calendar.MONTH);
                    int year = cal.get(Calendar.YEAR);
                    int day = cal.get(Calendar.DAY_OF_MONTH);
                    time.setText(" "+year + "/" + (month + 1) + "/" + day);

                    //time
                    int second = cal.get(Calendar.SECOND);
                    int minute = cal.get(Calendar.MINUTE);
                    int hour = cal.get(Calendar.HOUR);
                    time.setText(" "+"0" + hour + ":" + (minute) + ":" + second);
                    //TIME.setEditable(false);
                    //DATE.setEditable(false);
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    } 
                }
            }
        };
        clock.start();
    }
    
    
//    ==================================================================================================================
    public void sendOutOfStockData() {
    String selectQuery = "SELECT * FROM products";
    try {
        pst = conn.prepareStatement(selectQuery);
        rst = pst.executeQuery();

        while (rst.next()) {
            String productid = rst.getString("productid");
            int id=Integer.parseInt(productid);
            String barcode = rst.getString("barcode");
            String name = rst.getString("name");
            String size = rst.getString("size");
            String price = rst.getString("price");          
            String quantity = rst.getString("quantity");
            String category = rst.getString("category");
            String supplier_id = rst.getString("supplier_id");
            String cost_price = rst.getString("cost_price");
            Float qty = Float.valueOf(quantity);
            Float prc = Float.valueOf(price);            
            Float costp = Float.valueOf(cost_price);

            if ("0".equals(quantity)) { // Check if quantity is zero
                try {
                    String deleteQuery = "DELETE FROM products WHERE quantity = ?";
                    String insertQuery = "INSERT INTO out_of_stock (productid,barcode, name, size, price, quantity, category, supplier_id, cost_price) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?)";
                    // Use a different PreparedStatement for the DELETE query
                    pstDelete = conn.prepareStatement(deleteQuery);
                    pstDelete.setFloat(1, qty);
                    pstDelete.execute();
//                    JOptionPane.showMessageDialog(null, name);
                    // Use a different PreparedStatement for the INSERT query
                    pstInsert = conn.prepareStatement(insertQuery);
                    pstInsert.setInt(1,id);
                    pstInsert.setString(2,barcode);
            pstInsert.setString(3,name);
            pstInsert.setString(4,size);
            pstInsert.setFloat(5, prc);           
            pstInsert.setInt(6, Integer.parseInt(quantity));
            pstInsert.setString(7, category);
            pstInsert.setInt(8,Integer.valueOf(supplier_id));
            pstInsert.setFloat(9, costp);
                    pstInsert.execute();
                    
                    JOptionPane.showMessageDialog(null, "You have sold your last items and product is now out of stock"+"\n"+" inform admin for stock refill");
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null,e);
                }
            }
        }
        Update_table();
    } catch (SQLException ex) {
        Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            // Close resources (result set, prepared statements) in a finally block
            if (rst != null) {
                rst.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (pstDelete != null) {
                pstDelete.close();
            }
            if (pstInsert != null) {
                pstInsert.close();
            }
        } catch (SQLException e) {
            // Handle exceptions during closing resources
            e.printStackTrace();
        }
    }
}
    
    
//    ====================================================================================================================
    public void remove_item_from_cart(){
        // Cart table click listener for removing items on right-click
items.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1) { // Check for right-click
            int selectedRow = items.rowAtPoint(e.getPoint());
            if (selectedRow != -1) {
                int response = JOptionPane.showConfirmDialog(null, "Do you want to remove this item?", "Remove Item", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
//                    items.removeRow(selectedRow);
//                    items.remove(selectedRow);
                    items.removeRowSelectionInterval(selectedRow, selectedRow);
                }
            }
        }
    }
});
    }
    
    
  //=========================== ==============receipt=====================================================================
 public void receipt_generation() {
        String date = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        // Calculate the total
        double total = 0.0;
        int rowCount = items.getRowCount();
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
            String itemNameWithSize = items.getValueAt(i, 2).toString();
            String itemQuantity = items.getValueAt(i, 3).toString();
            String itemSubTotal = items.getValueAt(i, 5).toString();

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

 //=========================== ==============Invoice=====================================================================
 public void Invoice_generation() {
        String date = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        // Calculate the total
        double total = 0.0;
        int rowCount = items.getRowCount();
        // Create the receipt header
        StringBuilder receiptText = new StringBuilder();
        receiptText.append("                                M.R GENERAL HARDWARE\n");
        receiptText.append("                                        MENGO- Kampala, Uganda\n");
        receiptText.append("                             chipcodetechnologies@gmail.com\n");
        receiptText.append("                                Phone: (256) 700-562982\n\n");
        receiptText.append("                                INVOICE\n\n");
        receiptText.append("                    -----------------------------------------------------\n");
        receiptText.append("                            Invoice N0....    Date: ").append(date).append("\n\n");
        receiptText.append("\n");
        receiptText.append("               Items             Qty                 Price\n");
        receiptText.append("            ------------------------------------------------------------\n");
        // Add the items and prices
        for (int i = 0; i < rowCount; i++) {
            String itemNameWithSize = items.getValueAt(i, 2).toString();
            String itemQuantity = items.getValueAt(i, 3).toString();
            String itemSubTotal = items.getValueAt(i, 5).toString();

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
        scrollPane.setPreferredSize(new Dimension(400, 600));

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

        JDialog dialog = new JDialog((Frame) null, "Invoice Preview", true);
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
         String filename = "/home/chipcodedev/Desktop/Invoices/invoice.pdf"; // Set the filename for PDF

    Document document = new Document();

    try {
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.open();
        document.add(new Paragraph(receiptText));
        System.out.println("Invoice saved as PDF to file '" + filename + "'");
    } catch (DocumentException e) {
        System.err.println("Failed to write Invoice to PDF: " + e.getMessage());
    } catch (Exception e) {
        System.err.println("Exception occurred: " + e.getMessage());
    } finally {
        if (document != null) {
            document.close();
        }
    }
    }

//==================================================================================================================
    public void stkup(){
 //get all table products id and sell quantity
 DefaultTableModel dt = (DefaultTableModel) items.getModel();
 int rc = dt.getRowCount();
 for(int i = 0; i<rc; i++){
 String bcode = dt.getValueAt(i, 1).toString(); //barcode
 String sell_qty = dt.getValueAt(i, 3).toString();//quantity
     try {
         Statement s = connection.connect().createStatement();
         ResultSet rs = s.executeQuery("select quantity from products where barcode = '"+bcode+"'");
         if(rs.next()){
         Stcok_qty = Double.valueOf(rs.getString("quantity"));
         }
     } catch (SQLException e) {
         System.out.println(e);
     }
     Double st_qty = Stcok_qty;
     Double sel_qty = Double.valueOf(sell_qty);
     Double new_qty = st_qty - sel_qty;
     String nqty = String.valueOf(new_qty);
     try{
     Statement ss = connection.connect().createStatement();
     ss.executeUpdate("update products set quantity = '"+nqty+"' where barcode = '"+bcode+"'");
     }
     catch(Exception e){
         System.out.println(e);
     }
     
 }
 
 }
 
// *********=============================================================================================================
 
 private void  Update_table(){
        try{
    String sql = "select productid,barcode,name,size,price,quantity,category from products";
    pst = conn.prepareStatement(sql);
    rst = pst.executeQuery();
    products_table.setModel(DbUtils.resultSetToTableModel(rst));
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
    public void InvoiceNumbers() {
        String sql = "SELECT MAX(receipt_number) FROM solditems"; // Replace 'your_table_name' with the actual table name

        try (PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            if (rs.next()) {
                int highestInvoiceNumber = rs.getInt(1);
                highestInvoiceNumber++;
                invoice_no.setText(String.valueOf(highestInvoiceNumber));
            } else {
                // Handle the case where there are no records in the table
                invoice_no.setText("No records");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // calculating the Grand total
 public double calculateTotal() {
    double total = 0.0;
    DefaultTableModel model = (DefaultTableModel) items.getModel();
    int rowCount = model.getRowCount();

    for (int i = 0; i < rowCount; i++) {
        // Assuming sub_total is stored as a String in the table
        String subTotalStr = (String) model.getValueAt(i, 5); // 5 is the index of sub_total column

        // Parse the String to double and add it to the total
        try {
            double subTotal = Double.parseDouble(subTotalStr);
            total += subTotal;
            total_amount.setText(String.valueOf(total));
        
        } catch (NumberFormatException e) {
            // Handle the case where the sub_total value is not a valid double
            e.printStackTrace(); // Or log the error
        }
    }

    return total;
}
 public void clear(){
        name.setText("");        
        quantity.setText("");
        barcode.setText("");
        search_category.setText("");
        stock_qty.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton INVOICES;
    private javax.swing.JTextField barcode;
    private javax.swing.JTextField change;
    private javax.swing.JLabel counter;
    private javax.swing.JButton finish;
    private javax.swing.JTextField id;
    private javax.swing.JTextField invoice_no;
    private javax.swing.JTable items;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logout;
    private javax.swing.JTextField name;
    private javax.swing.JTextField price;
    private javax.swing.JTable products_table;
    private javax.swing.JTextField quantity;
    private javax.swing.JTextField search_category;
    private javax.swing.JLabel stock_qty;
    private javax.swing.JTextField time;
    private javax.swing.JTextField total_amount;
    // End of variables declaration//GEN-END:variables
}
