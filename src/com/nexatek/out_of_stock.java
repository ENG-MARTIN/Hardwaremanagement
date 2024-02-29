/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nexatek;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author KEVINcustoms
 */
public class out_of_stock extends javax.swing.JPanel {
Connection conn;
 ResultSet rst;
 PreparedStatement pst;
PreparedStatement pstDelete;
PreparedStatement pstInsert;
PreparedStatement pstInsert2;
    /**
     * Creates new form out_of_stock
     */
    public out_of_stock() {
        conn= connection.connect();
        initComponents();
        Update_table();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void  Update_table(){
        try{
    String sql = "select * from out_of_stock";
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
    
//public void sendOutOfStockData() {
//    try {
//       
//
//            if ("0".equals(quantity)) { // Check if quantity is zero
//                try {
//                    String deleteQuery = "DELETE FROM products WHERE quantity = ?";
//                    String insertQuery = "INSERT INTO out_of_stock (barcode, name, size, price, price2, price3, quantity, category, supplier_id, cost_price) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//
//                    // Use a different PreparedStatement for the DELETE query
//                    pstDelete = conn.prepareStatement(deleteQuery);
//                    pstDelete.setFloat(1, qty);
//                    pstDelete.execute();
//JOptionPane.showMessageDialog(null, name);
//                    // Use a different PreparedStatement for the INSERT query
//                    pstInsert = conn.prepareStatement(insertQuery);
//                    pstInsert.setString(1,barcode);
//            pstInsert.setString(2,name);
//            pstInsert.setString(3,size);
//            pstInsert.setFloat(4, prc);
//            pstInsert.setFloat(5, prc2);
//            pstInsert.setFloat(6, prc3);
//            pstInsert.setInt(7, Integer.parseInt(quantity));
//            pstInsert.setString(8, category);
//            pstInsert.setInt(9,Integer.valueOf(supplier_id));
//            pstInsert.setFloat(10, costp);
//                    pstInsert.execute();
//                    
//                    JOptionPane.showMessageDialog(null, "Deleted and Inserted into out_of_stock");
//                } catch (SQLException e) {
//                    JOptionPane.showMessageDialog(null, e);
//                }
//            }
//        }
//        Update_table();
//    } catch (SQLException ex) {
//        Logger.getLogger(product.class.getName()).log(Level.SEVERE, null, ex);
//    } finally {
//        try {
//            // Close resources (result set, prepared statements) in a finally block
//            if (rst != null) {
//                rst.close();
//            }
//            if (pst != null) {
//                pst.close();
//            }
//            if (pstDelete != null) {
//                pstDelete.close();
//            }
//            if (pstInsert != null) {
//                pstInsert.close();
//            }
//        } catch (SQLException e) {
//            // Handle exceptions during closing resources
//            e.printStackTrace();
//        }
//    }
//}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        products_table = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        search_bar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

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

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        search_bar.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        search_bar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search_barKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel3.setText("Search ID:");

        jLabel4.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel4.setText("Out Of Stock Info");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(56, 56, 56)
                        .addComponent(search_bar, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(684, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(search_bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Delete Permanently");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(427, 427, 427)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1045, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void products_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_products_tableMouseClicked
        // TODO add your handling code here:
        try {
            DefaultTableModel t = (DefaultTableModel) products_table.getModel();
            int i = products_table.getSelectedRow();
            //    BARCODE.setText(t.getValueAt(i, 0).toString());
            search_bar.setText(t.getValueAt(i, 0).toString());
            String barcode = (t.getValueAt(i, 1).toString());
            String product_name = (t.getValueAt(i, 2).toString());
            String product_size = (t.getValueAt(i, 3).toString());
            Float price = Float.valueOf(t.getValueAt(i, 4).toString());
            Float price2 = Float.valueOf(t.getValueAt(i, 5).toString());
            Float price3 = Float.valueOf(t.getValueAt(i, 6).toString());
            String quantity = (t.getValueAt(i, 7).toString());
            String category = (t.getValueAt(i, 8).toString());
            int supplier_id = Integer.valueOf(t.getValueAt(i, 9).toString());
            Float cost_price = Float.valueOf(t.getValueAt(i, 10).toString());
            int newqty = Integer.parseInt(JOptionPane.showInputDialog(null, "insert new quantity to add in stock"));
            
            if (newqty != 0){
            String sql = "delete from out_of_stock where barcode = ?";
            String sql2= "Insert into products (barcode,name,size,price,price2,price3,quantity,category, supplier_id, cost_price) values(?,?,?,?,?,?,?,?,?,?)";
            String sql3 = "Insert into sub_cost_price(product_name,sub_costp,quantity )";
            pst = conn.prepareStatement(sql);
            pst.setString(1, barcode);
            pst.execute();
            //            pstInsert.setString(2,name);
//            pstInsert.setString(3,size);
//            pstInsert.setFloat(4, prc);
//            pstInsert.setFloat(5, prc2);
//            pstInsert.setFloat(6, prc3);
//            pstInsert.setInt(7, Integer.parseInt(quantity));
//            pstInsert.setString(8, category);
//            pstInsert.setInt(9,Integer.valueOf(supplier_id));
//            pstInsert.setFloat(10, costp);
            
            pstInsert = conn.prepareStatement(sql2);
            pstInsert.setString(1, barcode);
            pstInsert.setString(2, product_name);
            pstInsert.setString(3, product_size);
            pstInsert.setFloat(4,price );
            pstInsert.setFloat(5,price2 );
            pstInsert.setFloat(6,price3 );
            pstInsert.setInt(7, newqty);
            pstInsert.setString(8, category);
            pstInsert.setInt(9, supplier_id);
            pstInsert.setFloat(10, cost_price);
            pstInsert.execute();
            
            
            
            
            JOptionPane.showMessageDialog(null, "products added to stock successfully");
            Update_table();
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_products_tableMouseClicked

    private void search_barKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_barKeyTyped
        // TODO add your handling code here:
        String searchCriteria = search_bar.getText().trim();

        try {
            // Construct the SQL query for searching
            String sql = "SELECT * FROM out_of_stock WHERE barcode LIKE ? OR name LIKE ? OR category LIKE ?";
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    DefaultTableModel t = (DefaultTableModel) products_table.getModel();
            int i = products_table.getSelectedRow();
            //    BARCODE.setText(t.getValueAt(i, 0).toString());
            search_bar.setText(t.getValueAt(i, 0).toString());
            String barcode = (t.getValueAt(i, 1).toString());
            String product_name = (t.getValueAt(i, 2).toString());
            String product_size = (t.getValueAt(i, 3).toString());
            Float price = Float.valueOf(t.getValueAt(i, 4).toString());
            Float price2 = Float.valueOf(t.getValueAt(i, 5).toString());
            Float price3 = Float.valueOf(t.getValueAt(i, 6).toString());
            String quantity = (t.getValueAt(i, 7).toString());
            String category = (t.getValueAt(i, 8).toString());
            int supplier_id = Integer.valueOf(t.getValueAt(i, 9).toString());
            Float cost_price = Float.valueOf(t.getValueAt(i, 10).toString());
            
            String sql = "delete from out_of_stock where barcode = ?";
    try {
        pst = conn.prepareStatement(sql);
    } catch (SQLException ex) {
        Logger.getLogger(out_of_stock.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        pst.setString(1, barcode);
        pst.execute();
    } catch (SQLException ex) {
        Logger.getLogger(out_of_stock.class.getName()).log(Level.SEVERE, null, ex);
    }
    Update_table();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable products_table;
    private javax.swing.JTextField search_bar;
    // End of variables declaration//GEN-END:variables
}
