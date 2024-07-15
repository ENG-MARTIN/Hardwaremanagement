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
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import static java.lang.Float.valueOf;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author mrrobot
 */
public class product extends javax.swing.JPanel {

    Connection conn;
    ResultSet rst;
    PreparedStatement pst;
    PreparedStatement pstDelete;
    PreparedStatement pstInsert;
    PreparedStatement pstextra;
    PreparedStatement pstextra_extra;
    public product() {
        conn= connection.connect();
        initComponents();
        damaged.setVisible(false);
        Update_table();
        view_damaged();
//        suppliers();
         products_table.getTableHeader().setFont( new Font("segoe UI", Font.BOLD,18));
        products_table.getTableHeader().setOpaque(true);
        products_table.getTableHeader().setBackground(new Color(242,242,242));
        products_table.getTableHeader().setForeground(new Color(0,0,255)); 
    }

   private void  Update_table(){
        try{
    String sql = "select * from products";
    pst = conn.prepareStatement(sql);
    rst = pst.executeQuery();
    products_table.setModel(DbUtils.resultSetToTableModel(rst));
    particulars.setModel(DbUtils.resultSetToTableModel(rst));
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
   
    private void  view_damaged(){
        try{
    String sql = "select * from damagedproducts";
    pst = conn.prepareStatement(sql);
    rst = pst.executeQuery();
    damaged.setVisible(true);
    damaged.setModel(DbUtils.resultSetToTableModel(rst));
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
   
    public void clear(){
        product_name.setText("");
        product_size.setText("");
        price.setText("");
        quantity.setText("");
        category.addItem("");
        supplier_id.addItem("");
        barcode.setText("");
       
        cost_price.setText("");
    }
   
    public void calculateCostPrice(){
    String name = product_name.getText();
    Float cost = Float.valueOf(cost_price.getText());
    int qty = Integer.parseInt(quantity.getText());
    Float total = cost * qty;
    String sql = "insert into  sub_cost_price(product_name,sub_costp,quantity) values(?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setFloat(2, total);
            pst.setInt(3, qty);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

public void updatingQuantity(){
        DefaultTableModel t = (DefaultTableModel) products_table.getModel();
    int i = products_table.getSelectedRow();
//    BARCODE.setText(t.getValueAt(i, 0).toString());
    search_bar.setText(t.getValueAt(i, 0).toString());
    barcode.setText(t.getValueAt(i, 1).toString());
    product_name.setText(t.getValueAt(i, 2).toString());
    product_size.setText(t.getValueAt(i, 3).toString());
    price.setText(t.getValueAt(i, 4).toString());
   
//    quantity.setText(t.getValueAt(i, 7).toString());
//    category.setText(t.getValueAt(i, 8).toString());
    supplier_id.addItem(t.getValueAt(i, 9).toString());
    cost_price.setText(t.getValueAt(i, 10).toString());
    
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
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        product_name = new javax.swing.JTextField();
        product_size = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        quantity = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        barcode = new javax.swing.JTextField();
        save_damage = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        cost_price = new javax.swing.JTextField();
        category = new javax.swing.JComboBox<>();
        view_damage = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        supplier_id = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        search_bar = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        generalstock = new javax.swing.JButton();
        categories = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        enddate = new com.toedter.calendar.JDateChooser();
        firstdate = new com.toedter.calendar.JDateChooser();
        Check = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        particulars = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        products_table = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        damaged = new javax.swing.JTable();

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

        jMenu7.setText("File");
        jMenuBar4.add(jMenu7);

        jMenu8.setText("Edit");
        jMenuBar4.add(jMenu8);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel1.setText("Name:");

        product_name.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N

        product_size.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        product_size.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_sizeActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel2.setText("Product_size:");

        save.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nexatek/images/save.png"))); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nexatek/imgs/search x30.png"))); // NOI18N
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nexatek/imgs/delete.png"))); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        update.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nexatek/imgs/update.png"))); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel5.setText("Retail_P:");

        price.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N

        quantity.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel6.setText("Quantity:");

        jLabel7.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel7.setText("Category:");

        jLabel8.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel8.setText("Supplier ID:");

        jLabel9.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel9.setText("Bar_code:");

        barcode.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        barcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barcodeActionPerformed(evt);
            }
        });

        save_damage.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        save_damage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nexatek/images/damage.png"))); // NOI18N
        save_damage.setText("Save As Damage");
        save_damage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_damageActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel13.setText("Cost Price");

        cost_price.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        cost_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cost_priceActionPerformed(evt);
            }
        });

        category.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Plumbing", "Kitchen ware", "Cement", "Steel", "Iron", "Plastic", "Glass", "Electrical", " ", " " }));

        view_damage.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        view_damage.setText("View Damaged Items");
        view_damage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_damageActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel14.setText("Status");

        status.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Paid", "UnPaid" }));

        supplier_id.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        supplier_id.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(product_size, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(product_name, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(88, 88, 88)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(quantity)
                            .addComponent(category, 0, 306, Short.MAX_VALUE)
                            .addComponent(supplier_id, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(save_damage, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(view_damage, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel14)))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(status, 0, 292, Short.MAX_VALUE)
                            .addComponent(cost_price)
                            .addComponent(barcode))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(product_name, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(supplier_id, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cost_price, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(2, 2, 2))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(product_size, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(category, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(save_damage, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(view_damage, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel3.setText("Search Item:");

        search_bar.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        search_bar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search_barKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addGap(84, 84, 84)
                .addComponent(search_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(search_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        jTabbedPane1.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jButton3.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nexatek/imgs/invo.png"))); // NOI18N
        jButton3.setText("Print");

        jButton6.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jButton6.setText("This Month's Report");

        generalstock.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        generalstock.setText("Print Stock Update");
        generalstock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generalstockActionPerformed(evt);
            }
        });

        categories.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        categories.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Plumbing", "Kitchen ware", "Cement", "Steel", "Iron", "Plastic", "Glass", "Electrical" }));
        categories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriesActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        jLabel4.setText("Print Report By Product Category");

        jLabel10.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel10.setText("Printing Receipts");

        enddate.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N

        firstdate.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N

        Check.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        Check.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/nexatek/images/save.png"))); // NOI18N
        Check.setText("Check");
        Check.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CheckMouseClicked(evt);
            }
        });

        jLabel11.setText("Start Date");

        jLabel12.setText("End Date");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(499, 499, 499)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(348, 348, 348)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(categories, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(generalstock)
                        .addGap(29, 29, 29)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(firstdate, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(enddate, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Check)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(enddate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(categories, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(generalstock, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(firstdate, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Check, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );

        particulars.setFont(new java.awt.Font("Cantarell", 0, 18)); // NOI18N
        particulars.setModel(new javax.swing.table.DefaultTableModel(
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
        particulars.setRowHeight(28);
        jScrollPane3.setViewportView(particulars);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Reports", jPanel4);

        products_table.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 0), 1, true));
        products_table.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        products_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Product Name", "Bar Code", "Price", "Qty", "SID"
            }
        ));
        products_table.setRowHeight(40);
        products_table.setSelectionBackground(new java.awt.Color(0, 153, 0));
        products_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                products_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(products_table);

        jTabbedPane1.addTab("View Stock", jScrollPane1);

        damaged.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(damaged);

        jTabbedPane1.addTab("Damaged Items", jScrollPane2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jTabbedPane1)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void search_barKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_barKeyTyped
        // TODO add your handling code here:
        String searchCriteria = search_bar.getText().trim();

    try {
        // Construct the SQL query for searching
        String sql = "SELECT * FROM products WHERE barcode LIKE ? OR name LIKE ? OR category LIKE ?";
        pst = conn.prepareStatement(sql);

        // Set the parameters for the prepared statement
        pst.setString(1, "%" + searchCriteria + "%"); // Using "%" for partial matches
        pst.setString(2, "%" + searchCriteria + "%");
        pst.setString(3, "%" + searchCriteria + "%");
        

        // Execute the query and update the JTable
        rst = pst.executeQuery();
        products_table.setModel(DbUtils.resultSetToTableModel(rst));
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
    }//GEN-LAST:event_search_barKeyTyped

    private void products_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_products_tableMouseClicked
        // TODO add your handling code here:
           try {
            DefaultTableModel t = (DefaultTableModel) products_table.getModel();
    int i = products_table.getSelectedRow();
//    BARCODE.setText(t.getValueAt(i, 0).toString());
    search_bar.setText(t.getValueAt(i, 0).toString());
    barcode.setText(t.getValueAt(i, 1).toString());
    product_name.setText(t.getValueAt(i, 2).toString());
    product_size.setText(t.getValueAt(i, 3).toString());
    price.setText(t.getValueAt(i, 4).toString());     
    quantity.setText(t.getValueAt(i, 5).toString());
    category.removeAllItems();
    category.addItem(t.getValueAt(i, 6).toString());
    cost_price.setText(t.getValueAt(i, 6).toString());
    cost_price.setText(t.getValueAt(i, 8).toString());
    supplier_id.addItem(t.getValueAt(i, 9).toString());
    
    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Soorry! something went wrong");
        }
    }//GEN-LAST:event_products_tableMouseClicked

    private void cost_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cost_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cost_priceActionPerformed

    private void view_damageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_damageActionPerformed
        // TODO add your handling code here:

        view_damaged();

    }//GEN-LAST:event_view_damageActionPerformed

    private void save_damageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_damageActionPerformed
        // TODO add your handling code here:
        String qty=quantity.getText();
        String s_id=supplier_id.getSelectedItem().toString();
        float prc = Float.valueOf(price.getText());
        String status_=status.getSelectedItem().toString();
        
        try{
            String sql= "Insert into damagedproducts (barcode,name,size,price,quantity,category, supplier_id,status) values(?,?,?,?,?,?,?,?)";
            pst= conn.prepareStatement(sql);
            pst.setString(1,barcode.getText());
            pst.setString(2,product_name.getText());
            pst.setString(3,product_size.getText());
            //pst.setString(4, price.getText());
            pst.setFloat(4, prc);
            pst.setInt(5, Integer.parseInt(qty));
            pst.setString(6, category.getSelectedItem().toString());
            pst.setInt(7,Integer.valueOf(s_id));
            pst.setString(8, status_);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Product Added to Damaged");
            products_table.setModel(DbUtils.resultSetToTableModel(rst));
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,e);
        }
        Update_table();

        clear();
    }//GEN-LAST:event_save_damageActionPerformed

    private void barcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_barcodeActionPerformed

    private void quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed

        int id_ = Integer.valueOf(search_bar.getText());
        String qty = quantity.getText();
        float prc = Float.valueOf(price.getText());
       
        float costP = Float.valueOf(cost_price.getText());

        String name = product_name.getText();
        String Category = category.getSelectedItem().toString();
        String size = product_size.getText();
        Float total;

        if (qty.isEmpty()) {
            String sql1 = "select quantity from products where productid = ?";
            String sql3 = "select quantity,sub_costp from sub_cost_price where product_name = ?";
            String sql4 = "update sub_cost_price set sub_costp = ? where product_name = ?";
            try {
                // here am trying to update the total cost if really needed by ma boss
                pstextra = conn.prepareStatement(sql3);
                pstextra.setString(1, name);
                rst = pstextra.executeQuery();
                if(rst.next()){
                    int quant = Integer.valueOf(rst.getString("quantity"));
                    float unitcost = Float.valueOf(cost_price.getText());
                    float totalcost = quant * unitcost;
                    JOptionPane.showMessageDialog(null, totalcost);

                    pstextra_extra = conn.prepareStatement(sql4);
                    pstextra_extra.setFloat(1, totalcost);
                    pstextra_extra.setString(2, name);
                    pstextra_extra.executeUpdate();

                }
                JOptionPane.showMessageDialog(null, "updated the cost price too from"+rst.getString("sub_costp"));
            } catch (SQLException ex) {
                Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
            }
            //    try {
                //        pstextra.setString(1, name);
                //    } catch (SQLException ex) {
                //        Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
                //    }
            try {
                pstInsert = conn.prepareStatement(sql1);
                pstInsert.setInt(1, id_);
                rst = pstInsert.executeQuery();
                if (rst.next()) {
                    Float newqty = Float.valueOf(rst.getString("quantity"));
                    JOptionPane.showMessageDialog(null, newqty);
                    String sql = "update products set name = ?, category = ?, price = ?, price2 = ?, price3 = ?, quantity = ?, size = ?, cost_price = ? where productid = ?";
                    pst = conn.prepareStatement(sql);
                    pst.setString(1, name);
                    pst.setString(2, Category);
                    pst.setFloat(3, prc);
                    
                    pst.setFloat(6, newqty);
                    pst.setString(7, size);
                    pst.setFloat(8, costP);
                    pst.setInt(9, id_);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Changes Tracked Successfully");
                    Update_table();
                    clear();
                }
            } catch (SQLException ex) {
                Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (Integer.valueOf(qty) > 0) {
            int qty4 = Integer.valueOf(qty);
            total = costP * qty4;
            String sql = "insert into sub_cost_price(product_name, sub_costp, quantity) values(?,?,?)";
            String sql2 = "select quantity from products where productid = ?";
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, name);
                pst.setFloat(2, total);
                pst.setInt(3, qty4);
                pst.executeUpdate();

                pstInsert = conn.prepareStatement(sql2);
                pstInsert.setInt(1, id_);
                rst = pstInsert.executeQuery();
                if (rst.next()) {
                    Float newqty = Float.valueOf(rst.getString("quantity"));
                    Float totalqty = qty4 + newqty;
                    String sql3 = "update products set name = ?, category = ?, price = ?, price2 = ?, price3 = ?, quantity = ?, size = ?, cost_price = ? where productid = ?";
                    pstextra = conn.prepareStatement(sql3);
                    pstextra.setString(1, name);
                    pstextra.setString(2, Category);
                    pstextra.setFloat(3, prc);
                    
                    pstextra.setFloat(6, totalqty);
                    pstextra.setString(7, size);
                    pstextra.setFloat(8, costP);
                    pstextra.setInt(9, id_);
                    pstextra.executeUpdate();
                    JOptionPane.showMessageDialog(null, totalqty);
                }
                Update_table();
                JOptionPane.showMessageDialog(null, "successfully added the sum of cost price and saved to db");
            } catch (SQLException ex) {
                Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        try{
            String sql= "Delete from products where productid=?";
            pst= conn.prepareStatement(sql);
            pst.setInt(1, Integer.valueOf(search_bar.getText()));

            pst.execute();
            JOptionPane.showMessageDialog(null,"Deleted");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        Update_table();
        clear();

    }//GEN-LAST:event_deleteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        String qty=quantity.getText();
        String s_id=supplier_id.getSelectedItem().toString();
        float prc = Float.valueOf(price.getText());
        String status_=status.getSelectedItem().toString();
         Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());       
         
        float costp = Float.valueOf(cost_price.getText());
          float profit=prc-costp;
        try{
            
            String sql= "Insert into products (barcode,name,size,price,quantity,category, supplier_id, cost_price,purchasedate,status,profit) values(?,?,?,?,?,?,?,?,?,?,?)";
            pst= conn.prepareStatement(sql);
            pst.setString(1,barcode.getText().toLowerCase());
            pst.setString(2,product_name.getText().toLowerCase());
            pst.setString(3,product_size.getText().toLowerCase());
            pst.setFloat(4, prc);           
            pst.setInt(5, Integer.parseInt(qty));
            pst.setString(6, category.getSelectedItem().toString());
            pst.setInt(7,Integer.valueOf(s_id));
            pst.setFloat(8, costp);
            pst.setTimestamp(9,timestamp);
            pst.setString(10, status_);
            pst.setFloat(11, profit);
            
            pst.execute();
            calculateCostPrice();
            JOptionPane.showMessageDialog(null,"Product Added Successful");
            products_table.setModel(DbUtils.resultSetToTableModel(rst));
        }
        catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,e);
        }
        Update_table();

        clear();
    }//GEN-LAST:event_saveActionPerformed

    private void product_sizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_sizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_product_sizeActionPerformed

    private void generalstockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generalstockActionPerformed
         // Define the file path
        String directoryPath = "/home/chipcodedev/Desktop/Mr hardware";
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        String filePath = directoryPath + File.separator + "AvailableStock.pdf";


        // Create a PDF document
        com.lowagie.text.Document document = new com.lowagie.text.Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // Add table to PDF
            PdfPTable pdfTable = new PdfPTable(products_table.getColumnCount());
            pdfTable.setWidthPercentage(100);

            // Add table header
            for (int i = 0; i < products_table.getColumnCount(); i++) {
                PdfPCell cell = new PdfPCell(new Phrase(products_table.getColumnName(i)));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfTable.addCell(cell);
            }

            // Add table rows
            for (int rows = 0; rows < products_table.getRowCount(); rows++) {
                for (int cols = 0; cols < products_table.getColumnCount(); cols++) {
                    pdfTable.addCell(products_table.getModel().getValueAt(rows, cols).toString());
                }
            }

            document.add(pdfTable);
            JOptionPane.showMessageDialog(null, "PDF created successfully at Reprts folder: AvailableStock.pdf ");

        } catch (FileNotFoundException | com.lowagie.text.DocumentException e) {
            JOptionPane.showMessageDialog(null, "Error creating PDF: " + e.getMessage());
        } finally {
            document.close();
        }
    }//GEN-LAST:event_generalstockActionPerformed

    private void categoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriesActionPerformed
        // TODO add your handling code here:
         String query = "";
                   String filter=categories.getSelectedItem().toString();
        switch (filter) {
            case "Kitchen ware":
                query = "SELECT * FROM products WHERE category = 'Kitchen ware'";
                break;
            case "Cement":
                query = "SELECT * FROM products WHERE category = 'Cement'";
                break;
            case "Steel":
               query = "SELECT * FROM products WHERE category = 'Steel'";
                break;
            case "Iron":
               query = "SELECT * FROM products WHERE category = 'Iron'";
                break;
            case "Glass":
               query = "SELECT * FROM products WHERE category = 'Glass'";
                break;
            case "Electrical":
                query = "SELECT * FROM products WHERE category = 'Electrical'";
                break;
            case "Plastic":
                query = "SELECT * FROM products WHERE category = 'Plastic'";
                break;
        }
            try{
             pst= conn.prepareStatement(query);
             rst = pst.executeQuery();

      particulars.setModel(DbUtils.resultSetToTableModel(rst));
//      totalsales();

        } catch (SQLException e) {
            e.printStackTrace();
        }
 
    }//GEN-LAST:event_categoriesActionPerformed

    private void CheckMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CheckMouseClicked
        // TODO add your handling code here:
        searchInvoicesByDate();
    }//GEN-LAST:event_CheckMouseClicked

    public void suppliers() {
        // Clear the comboBox first
        supplier_id.removeAllItems();


        // SQL query to get supplier names
        String sql = "SELECT name FROM suppliers";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();

            while (rst.next()) {
                // Get the supplier name from the result set
                String id = rst.getString("supplier_id");

                // Add the supplier name to the comboBox model
                supplier_id.addItem(id);
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Set the model for the comboBox
    }

      private void searchInvoicesByDate() {
    try {
        // Get the selected dates from your JDateChooser components
        java.util.Date startDate = firstdate.getDate();
        java.util.Date endDate = enddate.getDate();

        // Construct the SQL query for searching by date range
        String sql = "SELECT * FROM products WHERE purchasedate BETWEEN ? AND ?";
        pst = conn.prepareStatement(sql);

        // Set the start and end dates to the prepared statement
        pst.setDate(1, new java.sql.Date(startDate.getTime()));
        pst.setDate(2, new java.sql.Date(endDate.getTime()));
        rst = pst.executeQuery();

        // Set the result to your table model (replace with your actual table model)
        particulars.setModel(DbUtils.resultSetToTableModel(rst));
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Check;
    private javax.swing.JTextField barcode;
    private javax.swing.JComboBox<String> categories;
    private javax.swing.JComboBox<String> category;
    private javax.swing.JTextField cost_price;
    private javax.swing.JTable damaged;
    private javax.swing.JButton delete;
    private com.toedter.calendar.JDateChooser enddate;
    private com.toedter.calendar.JDateChooser firstdate;
    private javax.swing.JButton generalstock;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable particulars;
    private javax.swing.JTextField price;
    private javax.swing.JTextField product_name;
    private javax.swing.JTextField product_size;
    private javax.swing.JTable products_table;
    private javax.swing.JTextField quantity;
    private javax.swing.JButton save;
    private javax.swing.JButton save_damage;
    private javax.swing.JTextField search_bar;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JComboBox<String> supplier_id;
    private javax.swing.JButton update;
    private javax.swing.JButton view_damage;
    // End of variables declaration//GEN-END:variables
}
