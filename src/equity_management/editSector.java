/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equity_management;

import java.awt.Color;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Shardul Gawande
 */

public class editSector extends javax.swing.JFrame {

    /**
     * Creates new form editSector
     */
    DefaultTableModel model;
          

    
    public editSector() {
        initComponents();
        setRecordToTable();
    }
    
    public void setRecordToTable(){
        try{
            
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Equity_management","root","root");
            java.sql.PreparedStatement pst =con.prepareStatement("Select * from sector");
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()){
                String sectorId = rs.getString("id");
                String Sname = rs.getString("sname");
                String savg= rs.getString("savg");
                
                
                
                
                Object[] obj = {sectorId,Sname,savg};
                
                model = (DefaultTableModel)tbl_sectorData.getModel();
                model.addRow(obj);
              
                
                
            }
            
            
        }catch(Exception e){
            
            e.printStackTrace();
            
        }
    }
    
    public void clearTable(){
        
        DefaultTableModel model = (DefaultTableModel)tbl_sectorData.getModel();
        model.setRowCount(0);
        
        
    }
    
    
    
    public void addSector(int id, String sname,  double savg){
        
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Equity_management","root","root");
            
            java.sql.PreparedStatement pst = con.prepareStatement("insert into sector values (?,?,?)"); 
            pst.setInt(1,id);
            pst.setString(2,sname);
            pst.setDouble(3,savg);
            
            int rowCount =pst.executeUpdate();
            if(rowCount ==1){
               JOptionPane.showMessageDialog(this,"Sector added successfully"); 
               clearTable();
               setRecordToTable();
               
            }else{
               JOptionPane.showMessageDialog(this,"Sector insertion failed"); 

            }
            
            
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(this,"Sector insertion failed"); 

            e.printStackTrace();
            
        }
        
        
    }
    
    public void update(int id, String sname, double savg){
        
        
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Equity_management","root","root");
            
            java.sql.PreparedStatement pst = con.prepareStatement("update sector set sname =? , savg =? where id =?"); 
            pst.setString(1,sname);
            pst.setDouble(2,savg);
            pst.setInt(3,id);
            
            int rowCount =pst.executeUpdate();
            if(rowCount ==1){
               JOptionPane.showMessageDialog(this,"Sector updated successfully"); 
               clearTable();
               setRecordToTable();
               
            }else{
               JOptionPane.showMessageDialog(this,"Sector updation failed"); 

            }
            
            
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(this,"Sector insertion failed"); 

            e.printStackTrace();
            
        }
        
        
    }
    
    
     public void delete(int id){
        
        
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Equity_management","root","root");
            
            java.sql.PreparedStatement pst = con.prepareStatement("delete from sector where id =?"); 
            
            pst.setInt(1,id);
            
            int rowCount =pst.executeUpdate();
            if(rowCount ==1){
               JOptionPane.showMessageDialog(this,"Sector deleted successfully"); 
               clearTable();
               setRecordToTable();
               
            }else{
               JOptionPane.showMessageDialog(this,"Sector deletion failed"); 

            }
            
            
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(this,"Sector deletion failed"); 

            e.printStackTrace();
            
        }
        
        
    }
    

    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelsideBar = new javax.swing.JPanel();
        panelHome = new javax.swing.JPanel();
        btnHome = new javax.swing.JLabel();
        panelSectorList = new javax.swing.JPanel();
        btnSectorList = new javax.swing.JLabel();
        panelSearch = new javax.swing.JPanel();
        btnSearch = new javax.swing.JLabel();
        panelViewAllSymbl = new javax.swing.JPanel();
        btnViewAllSymbl = new javax.swing.JLabel();
        panelEdit = new javax.swing.JPanel();
        btnEdit = new javax.swing.JLabel();
        panelLogout = new javax.swing.JPanel();
        btnLogout = new javax.swing.JLabel();
        panelBack = new javax.swing.JPanel();
        btnBack = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_sectorData = new javax.swing.JTable();
        txt_sectorId = new javax.swing.JTextField();
        txt_indexPrice = new javax.swing.JTextField();
        txt_sectorName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelsideBar.setBackground(new java.awt.Color(19, 23, 34));
        panelsideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelHome.setBackground(new java.awt.Color(41, 98, 255));
        panelHome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelHomeMouseExited(evt);
            }
        });
        panelHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHome.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/equity_management/images/home.png"))); // NOI18N
        btnHome.setText("HOME");
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHomeMouseExited(evt);
            }
        });
        panelHome.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, -1, -1));

        panelsideBar.add(panelHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 330, 70));

        panelSectorList.setBackground(new java.awt.Color(41, 98, 255));
        panelSectorList.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelSectorList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelSectorListMouseExited(evt);
            }
        });
        panelSectorList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSectorList.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        btnSectorList.setForeground(new java.awt.Color(255, 255, 255));
        btnSectorList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/equity_management/images/list_1.png"))); // NOI18N
        btnSectorList.setText("Sector List");
        btnSectorList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSectorListMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSectorListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSectorListMouseExited(evt);
            }
        });
        panelSectorList.add(btnSectorList, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, -1, -1));

        panelsideBar.add(panelSectorList, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 330, 70));

        panelSearch.setBackground(new java.awt.Color(41, 98, 255));
        panelSearch.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelSearchMouseExited(evt);
            }
        });
        panelSearch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/equity_management/images/search2.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearchMouseExited(evt);
            }
        });
        panelSearch.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, -1, -1));

        panelsideBar.add(panelSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 330, 70));

        panelViewAllSymbl.setBackground(new java.awt.Color(41, 98, 255));
        panelViewAllSymbl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelViewAllSymbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelViewAllSymblMouseExited(evt);
            }
        });
        panelViewAllSymbl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnViewAllSymbl.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        btnViewAllSymbl.setForeground(new java.awt.Color(255, 255, 255));
        btnViewAllSymbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/equity_management/images/view all record.png"))); // NOI18N
        btnViewAllSymbl.setText("View All Record");
        btnViewAllSymbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnViewAllSymblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnViewAllSymblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnViewAllSymblMouseExited(evt);
            }
        });
        panelViewAllSymbl.add(btnViewAllSymbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        panelsideBar.add(panelViewAllSymbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 600, 330, 70));

        panelEdit.setBackground(new java.awt.Color(41, 98, 255));
        panelEdit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelEditMouseExited(evt);
            }
        });
        panelEdit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/equity_management/images/edit2.png"))); // NOI18N
        btnEdit.setText("Edit Sector");
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditMouseExited(evt);
            }
        });
        panelEdit.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, -1, -1));

        panelsideBar.add(panelEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 330, 70));

        panelLogout.setBackground(new java.awt.Color(41, 98, 255));
        panelLogout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelLogoutMouseExited(evt);
            }
        });
        panelLogout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/equity_management/images/logout.png"))); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogoutMouseExited(evt);
            }
        });
        panelLogout.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, -1, -1));

        panelsideBar.add(panelLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 850, 330, 70));

        panelBack.setBackground(new java.awt.Color(41, 98, 255));
        panelBack.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, null));
        panelBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelBackMouseExited(evt);
            }
        });
        panelBack.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/equity_management/images/left-arrow.png"))); // NOI18N
        btnBack.setText("Back");
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackMouseExited(evt);
            }
        });
        panelBack.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, -1, -1));

        panelsideBar.add(panelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 720, 330, 70));

        getContentPane().add(panelsideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 1090));

        jPanel1.setBackground(new java.awt.Color(30, 34, 45));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_sectorData.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbl_sectorData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sector Id", "Sector Name", "Index Price"
            }
        ));
        tbl_sectorData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_sectorDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_sectorData);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 810, 710));

        txt_sectorId.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel1.add(txt_sectorId, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 280, 340, 40));

        txt_indexPrice.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel1.add(txt_indexPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 650, 340, 40));

        txt_sectorName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel1.add(txt_sectorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 460, 340, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Index Price:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 590, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Edit Sector Details");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Sector Name:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 400, -1, -1));

        jButton1.setBackground(new java.awt.Color(41, 98, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("DELETE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 750, 120, 50));

        jButton2.setBackground(new java.awt.Color(41, 98, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 750, 120, 50));

        jButton3.setBackground(new java.awt.Color(41, 98, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("UPDATE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 750, 120, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Sector ID:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 220, -1, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 950, 20));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/equity_management/images/back1.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 40, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 1480, 1060));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseEntered

        Color clr = new Color(6, 3, 170);
        panelHome.setBackground(clr);
    }//GEN-LAST:event_btnHomeMouseEntered

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited
        Color clr = new Color(41,98,255);
        panelHome.setBackground(clr);
    }//GEN-LAST:event_btnHomeMouseExited

    private void panelHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHomeMouseExited

    }//GEN-LAST:event_panelHomeMouseExited

    private void btnSectorListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSectorListMouseEntered
        Color clr = new Color(6, 3, 170);
        panelSectorList.setBackground(clr);
    }//GEN-LAST:event_btnSectorListMouseEntered

    private void btnSectorListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSectorListMouseExited
        Color clr = new Color(41,98,255);
        panelSectorList.setBackground(clr);
    }//GEN-LAST:event_btnSectorListMouseExited

    private void panelSectorListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSectorListMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_panelSectorListMouseExited

    private void btnSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseEntered
        Color clr = new Color(6, 3, 170);
        panelSearch.setBackground(clr);
    }//GEN-LAST:event_btnSearchMouseEntered

    private void btnSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseExited
        Color clr = new Color(41,98,255);
        panelSearch.setBackground(clr);
    }//GEN-LAST:event_btnSearchMouseExited

    private void panelSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSearchMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_panelSearchMouseExited

    private void btnViewAllSymblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewAllSymblMouseEntered
        Color clr = new Color(6, 3, 170);
        panelViewAllSymbl.setBackground(clr);
    }//GEN-LAST:event_btnViewAllSymblMouseEntered

    private void btnViewAllSymblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewAllSymblMouseExited
        Color clr = new Color(41,98,255);
        panelViewAllSymbl.setBackground(clr);
    }//GEN-LAST:event_btnViewAllSymblMouseExited

    private void panelViewAllSymblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelViewAllSymblMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_panelViewAllSymblMouseExited

    private void btnEditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseEntered
        Color clr = new Color(6, 3, 170);
        panelEdit.setBackground(clr);
    }//GEN-LAST:event_btnEditMouseEntered

    private void btnEditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseExited
        Color clr = new Color(41,98,255);
        panelEdit.setBackground(clr);
    }//GEN-LAST:event_btnEditMouseExited

    private void panelEditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelEditMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_panelEditMouseExited

    private void btnLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseEntered
        Color clr = new Color(6, 3, 170);
        panelLogout.setBackground(clr);
    }//GEN-LAST:event_btnLogoutMouseEntered

    private void btnLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseExited
        Color clr = new Color(41,98,255);
        panelLogout.setBackground(clr);
    }//GEN-LAST:event_btnLogoutMouseExited

    private void panelLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelLogoutMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_panelLogoutMouseExited

    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
        Color clr = new Color(6, 3, 170);
        panelBack.setBackground(clr);
    }//GEN-LAST:event_btnBackMouseEntered

    private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseExited
        Color clr = new Color(41,98,255);
        panelBack.setBackground(clr);
    }//GEN-LAST:event_btnBackMouseExited

    private void panelBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBackMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_panelBackMouseExited

    private void tbl_sectorDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sectorDataMouseClicked
        // TODO add your handling code here:
        
        int rowNo = tbl_sectorData.getSelectedRow();
        TableModel model = tbl_sectorData.getModel();
        
        txt_sectorId.setText(model.getValueAt(rowNo, 0).toString());
        txt_sectorName.setText((String)model.getValueAt(rowNo,1));
        txt_indexPrice.setText(model.getValueAt(rowNo, 2).toString());
        
    }//GEN-LAST:event_tbl_sectorDataMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        int id = Integer.parseInt(txt_sectorId.getText());
        String sname = txt_sectorName.getText();
        double savg = Double.parseDouble(txt_indexPrice.getText());
         
         
        addSector(id, sname, savg);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        int id = Integer.parseInt(txt_sectorId.getText());
        String sname = txt_sectorName.getText();
        double savg = Double.parseDouble(txt_indexPrice.getText());
        
        update(id, sname, savg);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        int id = Integer.parseInt(txt_sectorId.getText());
        
        delete(id);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        
        home h =new home();
        h.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jLabel5MouseClicked

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked
        // TODO add your handling code here:
         home h = new home();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHomeMouseClicked

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        // TODO add your handling code here:
         home h = new home();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackMouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        // TODO add your handling code here:
        searchSymbl symblsearch = new searchSymbl();
        symblsearch.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSearchMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        // TODO add your handling code here:
        editSector sectoredit = new editSector();
        sectoredit.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnSectorListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSectorListMouseClicked
        // TODO add your handling code here:
        allSector showsector = new allSector();
        showsector.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSectorListMouseClicked

    private void btnViewAllSymblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewAllSymblMouseClicked
        // TODO add your handling code here:
        viewRecord symblrecord = new viewRecord();
        symblrecord.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnViewAllSymblMouseClicked

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        // TODO add your handling code here:
        Login l = new Login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutMouseClicked

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
            java.util.logging.Logger.getLogger(editSector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editSector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editSector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editSector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editSector().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBack;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JLabel btnHome;
    private javax.swing.JLabel btnLogout;
    private javax.swing.JLabel btnSearch;
    private javax.swing.JLabel btnSectorList;
    private javax.swing.JLabel btnViewAllSymbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel panelBack;
    private javax.swing.JPanel panelEdit;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelLogout;
    private javax.swing.JPanel panelSearch;
    private javax.swing.JPanel panelSectorList;
    private javax.swing.JPanel panelViewAllSymbl;
    private javax.swing.JPanel panelsideBar;
    private javax.swing.JTable tbl_sectorData;
    private javax.swing.JTextField txt_indexPrice;
    private javax.swing.JTextField txt_sectorId;
    private javax.swing.JTextField txt_sectorName;
    // End of variables declaration//GEN-END:variables
}
