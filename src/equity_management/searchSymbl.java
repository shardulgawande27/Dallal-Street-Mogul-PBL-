/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equity_management;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JOptionPane;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.lang.String;

/**
 *
 * @author Shardul Gawande
 */
public class searchSymbl extends javax.swing.JFrame {

    /**
     * Creates new form searchSymbl
     */
    public searchSymbl() {
        initComponents();
        searchData();
        
       
    }
    
    
    public void searchData(){
        
         try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Equity_management","root","root");
             
            java.sql.PreparedStatement pst =con.prepareStatement("select * from symbl_details where company_name =? ");
            pst.setString(1, txt_search.getText());
            Statement st=con.createStatement();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
            txt_symblNo.setText(rs.getString("symbl_no"));
            txt_CompanyName.setText(rs.getString("company_name"));
            txt_sectorName.setText(rs.getString("sector_name"));
            txt_cmp.setText(rs.getString("current_price"));
            txt_dayHigh.setText(rs.getString("day_high"));
            txt_dayLow.setText(rs.getString("day_low"));
            txt_52High.setText(rs.getString("high_52"));
            txt_52Low.setText(rs.getString("low_52"));
            txt_marketCap.setText(rs.getString("market_cap"));
            txt_enterpriseVal.setText(rs.getString("enterprise"));
            txt_noOfShares.setText(rs.getString("number_of_shares"));
            txt_PE.setText(rs.getString("pe_ratio"));
            txt_PB.setText(rs.getString("pb_ratio"));
            txt_faceVal.setText(rs.getString("face_value"));
            txt_bookVal.setText(rs.getString("book_value"));
            txt_divYield.setText(rs.getString("div_yield"));
            txt_cash.setText(rs.getString("cash"));
            txt_promoterHolding.setText(rs.getString("promoter_hold"));
            txt_eps.setText(rs.getString("eps"));
            txt_salesGrowth.setText(rs.getString("sales_growth"));
            txt_profitGrowth.setText(rs.getString("profit_growth"));
            txt_roe.setText(rs.getString("roe"));
            txt_roce.setText(rs.getString("roce"));
            txt_symbl.setText(rs.getString("symbl"));
            txt_date.setText(rs.getString("date"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
         
         
         
         
         try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Equity_management","root","root");
             
            java.sql.PreparedStatement pst =con.prepareStatement("select * from symbl_details where symbl =? ");
            pst.setString(1, txt_search.getText());
            Statement st=con.createStatement();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
            txt_symblNo.setText(rs.getString("symbl_no"));
            txt_CompanyName.setText(rs.getString("company_name"));
            txt_sectorName.setText(rs.getString("sector_name"));
            txt_cmp.setText(rs.getString("current_price"));
            txt_dayHigh.setText(rs.getString("day_high"));
            txt_dayLow.setText(rs.getString("day_low"));
            txt_52High.setText(rs.getString("high_52"));
            txt_52Low.setText(rs.getString("low_52"));
            txt_marketCap.setText(rs.getString("market_cap"));
            txt_enterpriseVal.setText(rs.getString("enterprise"));
            txt_noOfShares.setText(rs.getString("number_of_shares"));
            txt_PE.setText(rs.getString("pe_ratio"));
            txt_PB.setText(rs.getString("pb_ratio"));
            txt_faceVal.setText(rs.getString("face_value"));
            txt_bookVal.setText(rs.getString("book_value"));
            txt_divYield.setText(rs.getString("div_yield"));
            txt_cash.setText(rs.getString("cash"));
            txt_promoterHolding.setText(rs.getString("promoter_hold"));
            txt_eps.setText(rs.getString("eps"));
            txt_salesGrowth.setText(rs.getString("sales_growth"));
            txt_profitGrowth.setText(rs.getString("profit_growth"));
            txt_roe.setText(rs.getString("roe"));
            txt_roce.setText(rs.getString("roce"));
            txt_symbl.setText(rs.getString("symbl"));
            txt_date.setText(rs.getString("date"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
         
         try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Equity_management","root","root");
             
            java.sql.PreparedStatement pst =con.prepareStatement("select * from symbl_details where symbl_no =? ");
            pst.setString(1, txt_search.getText());
            Statement st=con.createStatement();
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
            txt_symblNo.setText(rs.getString("symbl_no"));
            txt_CompanyName.setText(rs.getString("company_name"));
            txt_sectorName.setText(rs.getString("sector_name"));
            txt_cmp.setText(rs.getString("current_price"));
            txt_dayHigh.setText(rs.getString("day_high"));
            txt_dayLow.setText(rs.getString("day_low"));
            txt_52High.setText(rs.getString("high_52"));
            txt_52Low.setText(rs.getString("low_52"));
            txt_marketCap.setText(rs.getString("market_cap"));
            txt_enterpriseVal.setText(rs.getString("enterprise"));
            txt_noOfShares.setText(rs.getString("number_of_shares"));
            txt_PE.setText(rs.getString("pe_ratio"));
            txt_PB.setText(rs.getString("pb_ratio"));
            txt_faceVal.setText(rs.getString("face_value"));
            txt_bookVal.setText(rs.getString("book_value"));
            txt_divYield.setText(rs.getString("div_yield"));
            txt_cash.setText(rs.getString("cash"));
            txt_promoterHolding.setText(rs.getString("promoter_hold"));
            txt_eps.setText(rs.getString("eps"));
            txt_salesGrowth.setText(rs.getString("sales_growth"));
            txt_profitGrowth.setText(rs.getString("profit_growth"));
            txt_roe.setText(rs.getString("roe"));
            txt_roce.setText(rs.getString("roce"));
            txt_symbl.setText(rs.getString("symbl"));
            txt_date.setText(rs.getString("date"));
            }
            
        }catch(Exception e){
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
        txt_symblNo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_symbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_date = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txt_CompanyName = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txt_sectorName = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txt_cmp = new javax.swing.JLabel();
        txt_dayHigh = new javax.swing.JLabel();
        txt_dayLow = new javax.swing.JLabel();
        txt_52High = new javax.swing.JLabel();
        txt_52Low = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_marketCap = new javax.swing.JLabel();
        txt_enterpriseVal = new javax.swing.JLabel();
        txt_noOfShares = new javax.swing.JLabel();
        txt_PE = new javax.swing.JLabel();
        txt_PB = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_promoterHolding = new javax.swing.JLabel();
        txt_cash = new javax.swing.JLabel();
        txt_divYield = new javax.swing.JLabel();
        txt_bookVal = new javax.swing.JLabel();
        txt_faceVal = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txt_eps = new javax.swing.JLabel();
        txt_salesGrowth = new javax.swing.JLabel();
        txt_profitGrowth = new javax.swing.JLabel();
        txt_roe = new javax.swing.JLabel();
        txt_roce = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jPanel1.setBackground(new java.awt.Color(30, 34, 45));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_symblNo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_symblNo.setForeground(new java.awt.Color(41, 98, 255));
        jPanel1.add(txt_symblNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 40, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("SYMBL :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 190, -1, -1));

        txt_symbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_symbl.setForeground(new java.awt.Color(41, 98, 255));
        jPanel1.add(txt_symbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 190, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Date:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 190, -1, -1));

        txt_date.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_date.setForeground(new java.awt.Color(41, 98, 255));
        jPanel1.add(txt_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 190, -1, -1));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Company :");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        txt_CompanyName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_CompanyName.setForeground(new java.awt.Color(41, 98, 255));
        jPanel1.add(txt_CompanyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, -1, -1));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Sector :");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        txt_sectorName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_sectorName.setForeground(new java.awt.Color(41, 98, 255));
        jPanel1.add(txt_sectorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, -1, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Price Summary:");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, -1));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("CMP:");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Today's High:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 420, -1, -1));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Today's Low:");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 420, -1, -1));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("52 Weeks High:");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 420, -1, -1));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("52 Week's Low:");
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 420, -1, -1));

        txt_cmp.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_cmp.setForeground(new java.awt.Color(41, 98, 255));
        jPanel1.add(txt_cmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, -1, -1));

        txt_dayHigh.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_dayHigh.setForeground(new java.awt.Color(41, 98, 255));
        jPanel1.add(txt_dayHigh, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 460, -1, -1));

        txt_dayLow.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_dayLow.setForeground(new java.awt.Color(41, 98, 255));
        jPanel1.add(txt_dayLow, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 460, -1, -1));

        txt_52High.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_52High.setForeground(new java.awt.Color(41, 98, 255));
        jPanel1.add(txt_52High, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 460, -1, -1));

        txt_52Low.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_52Low.setForeground(new java.awt.Color(41, 98, 255));
        jPanel1.add(txt_52Low, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 460, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Market CAP:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 550, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Enterprise Value:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 550, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("No.of Shares:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 550, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("P/E Ratio:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 550, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("P/B Ratio:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 550, -1, -1));

        txt_marketCap.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_marketCap.setForeground(new java.awt.Color(41, 98, 255));
        jPanel1.add(txt_marketCap, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 600, -1, -1));

        txt_enterpriseVal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_enterpriseVal.setForeground(new java.awt.Color(41, 98, 255));
        jPanel1.add(txt_enterpriseVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 600, -1, -1));

        txt_noOfShares.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_noOfShares.setForeground(new java.awt.Color(41, 98, 255));
        jPanel1.add(txt_noOfShares, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 600, -1, -1));

        txt_PE.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_PE.setForeground(new java.awt.Color(41, 98, 255));
        jPanel1.add(txt_PE, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 600, -1, -1));

        txt_PB.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_PB.setForeground(new java.awt.Color(41, 98, 255));
        jPanel1.add(txt_PB, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 600, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Face Value:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 720, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Book Value:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 720, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Div.Yield:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 720, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Cash:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 720, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Promoter Holding:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 720, -1, -1));

        txt_promoterHolding.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_promoterHolding.setForeground(new java.awt.Color(41, 98, 255));
        jPanel1.add(txt_promoterHolding, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 770, -1, -1));

        txt_cash.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_cash.setForeground(new java.awt.Color(41, 98, 255));
        jPanel1.add(txt_cash, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 770, -1, -1));

        txt_divYield.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_divYield.setForeground(new java.awt.Color(41, 98, 255));
        jPanel1.add(txt_divYield, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 770, -1, -1));

        txt_bookVal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_bookVal.setForeground(new java.awt.Color(41, 98, 255));
        jPanel1.add(txt_bookVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 770, -1, -1));

        txt_faceVal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_faceVal.setForeground(new java.awt.Color(41, 98, 255));
        jPanel1.add(txt_faceVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 770, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("EPS:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 900, -1, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Sales Growth:");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 900, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Profit Growth:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 900, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ROE:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 900, -1, -1));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("ROCE:");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 900, -1, -1));

        txt_eps.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_eps.setForeground(new java.awt.Color(41, 98, 255));
        jPanel1.add(txt_eps, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 950, -1, -1));

        txt_salesGrowth.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_salesGrowth.setForeground(new java.awt.Color(41, 98, 255));
        jPanel1.add(txt_salesGrowth, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 950, -1, -1));

        txt_profitGrowth.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_profitGrowth.setForeground(new java.awt.Color(41, 98, 255));
        jPanel1.add(txt_profitGrowth, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 950, -1, -1));

        txt_roe.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_roe.setForeground(new java.awt.Color(41, 98, 255));
        jPanel1.add(txt_roe, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 950, -1, -1));

        txt_roce.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_roce.setForeground(new java.awt.Color(41, 98, 255));
        jPanel1.add(txt_roce, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 950, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("SYMBL NO :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        txt_search.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });
        jPanel1.add(txt_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 601, 40));

        btn_search.setBackground(new java.awt.Color(41, 98, 255));
        btn_search.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_search.setForeground(new java.awt.Color(255, 255, 255));
        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });
        jPanel1.add(btn_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 60, 210, 62));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 1480, 20));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, 1480, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelsideBar, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1538, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelsideBar, javax.swing.GroupLayout.PREFERRED_SIZE, 1040, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        
        // TODO add your handling code here:
//        
//        String searchString = txt_search.getText();
//        searchData(searchString);
 searchData();
        
       
       
        
        
    }//GEN-LAST:event_btn_searchActionPerformed

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
            java.util.logging.Logger.getLogger(searchSymbl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(searchSymbl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(searchSymbl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(searchSymbl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new searchSymbl().setVisible(true);
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
    private javax.swing.JButton btn_search;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel panelBack;
    private javax.swing.JPanel panelEdit;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelLogout;
    private javax.swing.JPanel panelSearch;
    private javax.swing.JPanel panelSectorList;
    private javax.swing.JPanel panelViewAllSymbl;
    private javax.swing.JPanel panelsideBar;
    private javax.swing.JLabel txt_52High;
    private javax.swing.JLabel txt_52Low;
    private javax.swing.JLabel txt_CompanyName;
    private javax.swing.JLabel txt_PB;
    private javax.swing.JLabel txt_PE;
    private javax.swing.JLabel txt_bookVal;
    private javax.swing.JLabel txt_cash;
    private javax.swing.JLabel txt_cmp;
    private javax.swing.JLabel txt_date;
    private javax.swing.JLabel txt_dayHigh;
    private javax.swing.JLabel txt_dayLow;
    private javax.swing.JLabel txt_divYield;
    private javax.swing.JLabel txt_enterpriseVal;
    private javax.swing.JLabel txt_eps;
    private javax.swing.JLabel txt_faceVal;
    private javax.swing.JLabel txt_marketCap;
    private javax.swing.JLabel txt_noOfShares;
    private javax.swing.JLabel txt_profitGrowth;
    private javax.swing.JLabel txt_promoterHolding;
    private javax.swing.JLabel txt_roce;
    private javax.swing.JLabel txt_roe;
    private javax.swing.JLabel txt_salesGrowth;
    private javax.swing.JTextField txt_search;
    private javax.swing.JLabel txt_sectorName;
    private javax.swing.JLabel txt_symbl;
    private javax.swing.JLabel txt_symblNo;
    // End of variables declaration//GEN-END:variables
}
