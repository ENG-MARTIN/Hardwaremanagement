/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.nexatek;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author chipcodedev
 */
public class counter extends javax.swing.JFrame {

   ResultSet rst;
   Connection conn;
   PreparedStatement pst; 
   PreparedStatement pstInsert;
   PreparedStatement pstDelete;
   public Double Stcok_qty = 0.0;
 static String customer_name;
  static String telephone_number;
  
  static Float cash;
    public counter() {
        conn=connection.connect();
        initComponents();
        setExtendedState(Home.MAXIMIZED_BOTH);
        items.getTableHeader().setFont( new Font("segoe UI", Font.BOLD,18));
        items.getTableHeader().setOpaque(true);
        items.getTableHeader().setBackground(new Color(242,242,242));
        items.getTableHeader().setForeground(new Color(0,0,255) ); 
                
         DefaultTableModel model = new DefaultTableModel();
        items.setModel(model);
          model.addColumn("IID");
        model.addColumn("BARCODE");
        model.addColumn("NAME");
        model.addColumn("QUANTITY");
        model.addColumn("UNIT-PRICE");
        model.addColumn("SUB-TOTAL");
        
        currentdate();
        sendOutOfStockData();
        InvoiceNumbers();   
        Update_table();
        calculateTotal();
        id.setVisible(false);
        price.setVisible(false);
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        products_table = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        items = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        INVOICES = new javax.swing.JButton();
        finish = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        total_amount = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        change = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        stock_qty = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        invoice_no = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        logout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
                .addGap(172, 172, 172)
                .addComponent(jLabel3)
                .addGap(46, 46, 46)
                .addComponent(barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(jLabel6)
                .addGap(40, 40, 40)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(search_category, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96)
                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(counter)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(counter)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_category, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

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
        products_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                products_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(products_table);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

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
        items.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(items);

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(62, 62, 62)
                        .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(INVOICES, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(finish, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(135, 135, 135))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(INVOICES, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(finish)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(total_amount, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(change, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );

        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel10.setText("IINVOICE NO.");

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
                .addComponent(invoice_no, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jLabel5.setText("Biiling system");

        jLabel9.setText("Supported by ChipCode Technologies");

        logout.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        logout.setText("LogOut");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(610, 610, 610)
                        .addComponent(jLabel5))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(640, 640, 640)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                String sql = "INSERT INTO solditems (invoice_number, itemId, name, quantity, itemPrice, total,sold_by,time,selldate,cash) VALUES (?, ?, ?, ?, ?, ?,?,?,?,?)";
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

                InvoiceNumbers();
            }
            else{
                JOptionPane.showMessageDialog(null, "Cash is less than the Total Amount Required!");
        }
    }//GEN-LAST:event_finishActionPerformed

    private void products_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_products_tableMouseClicked
        // TODO add your handling code here:         
          try {
        DefaultTableModel t = (DefaultTableModel) products_table.getModel();    
        int i = products_table.getSelectedRow();
        id.setText(t.getValueAt(i, 0).toString());
        barcode.setText(t.getValueAt(i, 1).toString());
        search_category.setText(t.getValueAt(i, 2).toString());    
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

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    LOGIN login = new LOGIN();
    login.setVisible(true);
    }//GEN-LAST:event_logoutActionPerformed

    private void INVOICESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INVOICESActionPerformed
        // TODO add your handling code here:
       JOptionPane.showConfirmDialog(null, "Then i will show the the invoice from here");
    }//GEN-LAST:event_INVOICESActionPerformed
    
    
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
                    String insertQuery = "INSERT INTO out_of_stock (barcode, name, size, price, quantity, category, supplier_id, cost_price) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                    // Use a different PreparedStatement for the DELETE query
                    pstDelete = conn.prepareStatement(deleteQuery);
                    pstDelete.setFloat(1, qty);
                    pstDelete.execute();
JOptionPane.showMessageDialog(null, name);
                    // Use a different PreparedStatement for the INSERT query
                    pstInsert = conn.prepareStatement(insertQuery);
                    pstInsert.setString(1,barcode);
            pstInsert.setString(2,name);
            pstInsert.setString(3,size);
            pstInsert.setFloat(4, prc);           
            pstInsert.setInt(5, Integer.parseInt(quantity));
            pstInsert.setString(6, category);
            pstInsert.setInt(7,Integer.valueOf(supplier_id));
            pstInsert.setFloat(8, costp);
                    pstInsert.execute();
                    
                    JOptionPane.showMessageDialog(null, "You have sold your last items and product is now out of stock"+"\n"+" inform admin for stock refill");
                } catch (SQLException e) {
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
        scrollPane.setPreferredSize(new Dimension(500, 500));

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
        String filename = "/home/chipcodedev/Desktop/Receipts/receipt.txt"; // Set the filename
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(receiptText);
            System.out.println("Receipt saved to file '" + filename + "'");
        } catch (IOException e) {
            System.err.println("Failed to write receipt to file: " + e.getMessage());
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
        String sql = "SELECT MAX(invoice_number) FROM solditems"; // Replace 'your_table_name' with the actual table name

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
    
    /* *
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
            java.util.logging.Logger.getLogger(counter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(counter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(counter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(counter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new counter().setVisible(true);
            }
        });
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
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
