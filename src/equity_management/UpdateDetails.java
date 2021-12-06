/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equity_management;

import java.awt.Color;
import javax.swing.JOptionPane;
import java.sql.*;
import java.text.SimpleDateFormat;


/**
 *
 * @author Shardul Gawande
 */
public class UpdateDetails extends javax.swing.JFrame {

    /**
     * Creates new form AddScript
     */
    public UpdateDetails() {
        initComponents();
        fillComboBox();
        
        int symblNo = getSymblNo();
        txt_symblNo.setText(Integer.toString(symblNo));
        
        
        setRecord();
        
    }
    
    public boolean validation(){
        if(txt_symbl.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please Enter SYMBOL");
            return false;
        }
        if(dateChooser.getDate()==null)
        {
            JOptionPane.showMessageDialog(this,"Please Enter DATE");
            return false;
        }
        if(txt_CompanyName.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Please Enter COMPANY NAME");
            return false;
        }
        if(txt_cmp.getText().equals("")|| txt_cmp.getText().matches("[0.00-9.00]+") == false)
        {
            JOptionPane.showMessageDialog(this,"Please Enter valid CMP");
            return false;
        }
        if(txt_dayHigh.getText().equals("")|| txt_dayHigh.getText().matches("[0.00-9.00]+") == false)
        {
            JOptionPane.showMessageDialog(this,"Please Enter valid Day's High");
            return false;
        }
        if(txt_dayLow.getText().equals("")|| txt_dayLow.getText().matches("[0.00-9.00]+") == false)
        {
            JOptionPane.showMessageDialog(this,"Please Enter valid Day's Low");
            return false;
        }
        if(txt_52High.getText().equals("")|| txt_52High.getText().matches("[0.00-9.00]+") == false)
        {
            JOptionPane.showMessageDialog(this,"Please Enter valid 52 week's High");
            return false;
        }
        if(txt_52Low.getText().equals("")|| txt_52Low.getText().matches("[0.00-9.00]+") == false)
        {
            JOptionPane.showMessageDialog(this,"Please Enter valid 52 week's Low");
            return false;
        }
        if(txt_marketCap.getText().equals("")|| txt_marketCap.getText().matches("[0.00-9.00]+") == false)
        {
            JOptionPane.showMessageDialog(this,"Please Enter valid Market CAP");
            return false;
        }
        if(txt_enterpriseVal.getText().equals("")|| txt_enterpriseVal.getText().matches("[0.00-9.00]+") == false)
        {
            JOptionPane.showMessageDialog(this,"Please Enter valid Enterprise Value");
            return false;
        }
        if(txt_noOfShares.getText().equals("")|| txt_noOfShares.getText().matches("[0.00-9.00]+") == false)
        {
            JOptionPane.showMessageDialog(this,"Please Enter valid Number of Shares");
            return false;
        }
        if(txt_PE.getText().equals("")|| txt_PE.getText().matches("[0.00-9.00]+") == false)
        {
            JOptionPane.showMessageDialog(this,"Please Enter valid Profit / Earning Ratio");
            return false;
        }
        if(txt_PB.getText().equals("")|| txt_PB.getText().matches("[0.00-9.00]+") == false)
        {
            JOptionPane.showMessageDialog(this,"Please Enter valid Profit / Book Ratio");
            return false;
        }
        if(txt_faceVal.getText().equals("")|| txt_faceVal.getText().matches("[0.00-9.00]+") == false)
        {
            JOptionPane.showMessageDialog(this,"Please Enter valid Face Value");
            return false;
        }
        if(txt_bookVal.getText().equals("")|| txt_bookVal.getText().matches("[0.00-9.00]+") == false)
        {
            JOptionPane.showMessageDialog(this,"Please Enter valid Book Value");
            return false;
        }
        if(txt_divYield.getText().equals("")|| txt_divYield.getText().matches("[0.00-9.00]+") == false)
        {
            JOptionPane.showMessageDialog(this,"Please Enter valid Dividend Yield");
            return false;
        }
        if(txt_cash.getText().equals("")|| txt_cash.getText().matches("[0.00-9.00]+") == false)
        {
            JOptionPane.showMessageDialog(this,"Please Enter valid Cash Value");
            return false;
        }
        if(txt_promoterHolding.getText().equals("")|| txt_promoterHolding.getText().matches("[0.00-9.00]+") == false)
        {
            JOptionPane.showMessageDialog(this,"Please Enter valid Promoter Holding");
            return false;
        }
        if(txt_eps.getText().equals("")|| txt_eps.getText().matches("[0.00-9.00]+") == false)
        {
            JOptionPane.showMessageDialog(this,"Please Enter valid Earning Per Share");
            return false;
        }
        if(txt_salesGrowth.getText().equals("")|| txt_salesGrowth.getText().matches("[0.00-9.00]+") == false)
        {
            JOptionPane.showMessageDialog(this,"Please Enter valid Sales Growth");
            return false;
        }
        if(txt_profitGrowth.getText().equals("")|| txt_profitGrowth.getText().matches("[0.00-9.00]+") == false)
        {
            JOptionPane.showMessageDialog(this,"Please Enter valid Profit Growth");
            return false;
        }
        if(txt_roe.getText().equals("")|| txt_roe.getText().matches("[0.00-9.00]+") == false)
        {
            JOptionPane.showMessageDialog(this,"Please Enter valid Return on Equity");
            return false;
        }
        if(txt_roce.getText().equals("")|| txt_roce.getText().matches("[0.00-9.00]+") == false)
        {
            JOptionPane.showMessageDialog(this,"Please Enter valid Return on Capital Employed");
            return false;
        }
        
        
        
        
        return true;
    }
    
    
    public void fillComboBox(){
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Equity_management","root","root");
            
            java.sql.PreparedStatement pst = con.prepareStatement("select sname from sector");   
            ResultSet rs = pst.executeQuery();
            while (rs.next()){
                comboSector.addItem(rs.getString("sname"));
            }
        
        
        
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public int getSymblNo(){
        
        int symblNo = 0;
        
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Equity_management","root","root");
//            Connection con = (Connection) DBConnection.getConnection();
            java.sql.PreparedStatement pst =con.prepareStatement("Select max(symbl_no) from symbl_details");
            ResultSet rs = pst.executeQuery();
            
            if (rs.next() == true){
                symblNo = rs.getInt(1);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return symblNo + 1;
        
    }
    
    public String updateData(){
        
        String status = "";
        
        int symblNo = Integer.parseInt(txt_symblNo.getText());
        String symbl = txt_symbl.getText();
        String companyName = txt_CompanyName.getText();
        String sectorName = comboSector.getSelectedItem().toString();
        float currentPrice = Float.parseFloat(txt_cmp.getText());
        float dayLow = Float.parseFloat(txt_dayLow.getText());
        float dayHigh = Float.parseFloat(txt_dayHigh.getText());
        float high52 = Float.parseFloat(txt_52High.getText());
        float low52 = Float.parseFloat(txt_52Low.getText());
        float marketCap = Float.parseFloat(txt_marketCap.getText());
        float enterprise = Float.parseFloat(txt_enterpriseVal.getText());
        float numberOfShares = Float.parseFloat(txt_noOfShares.getText());
        float peRatio = Float.parseFloat(txt_PE.getText());
        float pbRatio = Float.parseFloat(txt_PB.getText());
        float faceValue = Float.parseFloat(txt_faceVal.getText());
        float bookValue = Float.parseFloat(txt_bookVal.getText());
        float divYield = Float.parseFloat(txt_divYield.getText());
        float cash = Float.parseFloat(txt_cash.getText());
        float promoterHold = Float.parseFloat(txt_promoterHolding.getText());
        float eps = Float.parseFloat(txt_eps.getText());
        float salesGrowth = Float.parseFloat(txt_salesGrowth.getText());
        float profitGrowth = Float.parseFloat(txt_profitGrowth.getText());
        float roe = Float.parseFloat(txt_roe.getText());
        float roce = Float.parseFloat(txt_roce.getText());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(dateChooser.getDate());
        
        
        
        try{
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Equity_management","root","root");
            java.sql.PreparedStatement pst =con.prepareStatement("update symbl_details set company_name=?, sector_name=?,date=?,current_price=?,day_low=?,day_high=?, high_52=?,low_52=?,market_cap=?,enterprise=?,number_of_shares=?,pe_ratio=?,pb_ratio=?, face_value=?,book_value=?, div_yield=?, cash=?,promoter_hold=?,eps=?,sales_growth=?,profit_growth=?,roe=?, roce=?,symbl=? "
                    + "where symbl_no =?");
            
            
            pst.setString(1, companyName);
            pst.setString(2, sectorName);
            pst.setString(3, date);
            pst.setFloat(4, currentPrice);
            pst.setFloat(5, dayLow);
            pst.setFloat(6, dayHigh);
            pst.setFloat(7, high52);
            pst.setFloat(8, low52);
            pst.setFloat(9, marketCap);
            pst.setFloat(10, enterprise);
            pst.setFloat(11, numberOfShares);
            pst.setFloat(12, peRatio);
            pst.setFloat(13, pbRatio);
            pst.setFloat(14, faceValue);
            pst.setFloat(15, bookValue);
            pst.setFloat(16, divYield);
            pst.setFloat(17, cash);
            pst.setFloat(18, promoterHold);
            pst.setFloat(19, eps);
            pst.setFloat(20, salesGrowth);
            pst.setFloat(21, profitGrowth);
            pst.setFloat(22, roe);
            pst.setFloat(23, roce);
            pst.setString(24, symbl);
            pst.setInt(25, symblNo);
            
            
            int rowCount = pst.executeUpdate();
            if(rowCount == 1){
                status = "success";
            }else{
                status="failed";
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        return status;
        
    }
    
    
    
    public void setRecord(){
        
        
        try{
            
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Equity_management","root","root");
            java.sql.PreparedStatement pst =con.prepareStatement("Select * from symbl_details order by symbl_no desc fetch first 1 rows only");
            ResultSet rs = pst.executeQuery();
            rs.next();
            txt_symblNo.setText(rs.getString("symbl_no"));
            txt_CompanyName.setText(rs.getString("company_name"));
            comboSector.setSelectedItem(rs.getString("sector_name"));
            dateChooser.setDate(rs.getDate("date"));
            txt_cmp.setText(rs.getString("current_price"));
            txt_dayLow.setText(rs.getString("day_low"));
            txt_dayHigh.setText(rs.getString("day_high"));
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


            
            
        }catch(Exception e){
        
            e.printStackTrace();
            
        }
        
        
        
    }
    
    
    
    
    
    
    
    
//    public void displayCmp(){
//     
//        lbl_info.setText("This shows the Current Market Price of the stock");
//        
//        
//    }
    

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
        panelParent = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboSector = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_sectorName = new javax.swing.JTextField();
        txt_eps = new javax.swing.JTextField();
        txt_dayHigh = new javax.swing.JTextField();
        txt_salesGrowth = new javax.swing.JTextField();
        txt_faceVal = new javax.swing.JTextField();
        txt_marketCap = new javax.swing.JTextField();
        txt_profitGrowth = new javax.swing.JTextField();
        txt_bookVal = new javax.swing.JTextField();
        txt_enterpriseVal = new javax.swing.JTextField();
        txt_roe = new javax.swing.JTextField();
        txt_divYield = new javax.swing.JTextField();
        txt_noOfShares = new javax.swing.JTextField();
        txt_roce = new javax.swing.JTextField();
        txt_cash = new javax.swing.JTextField();
        txt_PE = new javax.swing.JTextField();
        txt_PB = new javax.swing.JTextField();
        txt_promoterHolding = new javax.swing.JTextField();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_CompanyName = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txt_symbl = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txt_cmp = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txt_dayLow = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txt_52High = new javax.swing.JTextField();
        txt_52Low = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        btn_print = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel27 = new javax.swing.JLabel();
        txt_symblNo = new javax.swing.JTextField();
        lbl_info = new javax.swing.JLabel();

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
        btnViewAllSymbl.setText("View All SYMBL");
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

        getContentPane().add(panelsideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 1040));

        panelParent.setBackground(new java.awt.Color(30, 34, 45));
        panelParent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ROE:");
        panelParent.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 800, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Date:");
        panelParent.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("SYMBL NO:");
        panelParent.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        comboSector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSectorActionPerformed(evt);
            }
        });
        panelParent.add(comboSector, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 270, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Sector:");
        panelParent.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Profit Growth:");
        panelParent.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 800, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Enterprise Value:");
        panelParent.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 450, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("No.of Shares:");
        panelParent.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 450, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("P/E Ratio:");
        panelParent.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 450, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("P/B Ratio:");
        panelParent.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 450, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Face Value:");
        panelParent.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 630, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Div.Yield:");
        panelParent.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 630, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Book Value:");
        panelParent.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 630, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Cash:");
        panelParent.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 630, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Promoter Holding:");
        panelParent.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 630, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("EPS:");
        panelParent.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 800, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Sales Growth:");
        panelParent.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 800, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Market CAP:");
        panelParent.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("ROCE:");
        panelParent.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 800, -1, -1));

        txt_sectorName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelParent.add(txt_sectorName, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 270, 30));

        txt_eps.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelParent.add(txt_eps, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 860, 240, 30));

        txt_dayHigh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelParent.add(txt_dayHigh, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, 240, 30));

        txt_salesGrowth.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelParent.add(txt_salesGrowth, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 860, 240, 30));

        txt_faceVal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelParent.add(txt_faceVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 680, 240, 30));

        txt_marketCap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_marketCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_marketCapActionPerformed(evt);
            }
        });
        panelParent.add(txt_marketCap, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 240, 30));

        txt_profitGrowth.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelParent.add(txt_profitGrowth, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 860, 240, 30));

        txt_bookVal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelParent.add(txt_bookVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 680, 240, 30));

        txt_enterpriseVal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelParent.add(txt_enterpriseVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 500, 240, 30));

        txt_roe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_roe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_roeActionPerformed(evt);
            }
        });
        panelParent.add(txt_roe, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 860, 240, 30));

        txt_divYield.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_divYield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_divYieldActionPerformed(evt);
            }
        });
        panelParent.add(txt_divYield, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 680, 240, 30));

        txt_noOfShares.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelParent.add(txt_noOfShares, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 500, 240, 30));

        txt_roce.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelParent.add(txt_roce, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 860, 240, 30));

        txt_cash.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_cash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cashActionPerformed(evt);
            }
        });
        panelParent.add(txt_cash, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 680, 240, 30));

        txt_PE.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelParent.add(txt_PE, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 500, 240, 30));

        txt_PB.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelParent.add(txt_PB, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 500, 240, 30));

        txt_promoterHolding.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelParent.add(txt_promoterHolding, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 680, 240, 30));
        panelParent.add(dateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 40, 210, 30));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("SYMBL:");
        panelParent.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Today's High:");
        panelParent.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, -1, -1));

        txt_CompanyName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelParent.add(txt_CompanyName, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 270, 30));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Select Sector:");
        panelParent.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Price Summary:");
        panelParent.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));
        panelParent.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 1480, 20));

        txt_symbl.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelParent.add(txt_symbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, 270, 30));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("CMP:");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel23MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel23MouseExited(evt);
            }
        });
        jLabel23.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel23KeyPressed(evt);
            }
        });
        panelParent.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, -1, -1));

        txt_cmp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelParent.add(txt_cmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 240, 30));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Today's Low:");
        panelParent.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 320, -1, -1));

        txt_dayLow.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelParent.add(txt_dayLow, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 370, 240, 30));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("52 Weeks High:");
        panelParent.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 320, -1, -1));

        txt_52High.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelParent.add(txt_52High, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 370, 240, 30));

        txt_52Low.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelParent.add(txt_52Low, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 370, 240, 30));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("52 Week's Low:");
        panelParent.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 320, -1, -1));

        btn_print.setBackground(new java.awt.Color(41, 98, 255));
        btn_print.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_print.setForeground(new java.awt.Color(255, 255, 255));
        btn_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/equity_management/images/printer-.png"))); // NOI18N
        btn_print.setText("PRINT");
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        panelParent.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 930, 220, 80));
        panelParent.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 1480, 20));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Company:");
        panelParent.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        txt_symblNo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelParent.add(txt_symblNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 270, 30));

        lbl_info.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_info.setForeground(new java.awt.Color(255, 255, 255));
        panelParent.add(lbl_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 940, 990, 60));

        getContentPane().add(panelParent, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 1550, 1040));

        setSize(new java.awt.Dimension(2037, 1073));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseEntered
        
        Color clr = new Color(6, 3, 170);
        panelHome.setBackground(clr);
        
        
        
    }//GEN-LAST:event_btnHomeMouseEntered

    private void panelHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHomeMouseExited
        
    }//GEN-LAST:event_panelHomeMouseExited

    private void btnSectorListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSectorListMouseEntered
       Color clr = new Color(6, 3, 170);
        panelSectorList.setBackground(clr);
    }//GEN-LAST:event_btnSectorListMouseEntered

    private void panelSectorListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSectorListMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_panelSectorListMouseExited

    private void btnSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseEntered
        Color clr = new Color(6, 3, 170);
        panelSearch.setBackground(clr);
    }//GEN-LAST:event_btnSearchMouseEntered

    private void panelSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelSearchMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_panelSearchMouseExited

    private void btnViewAllSymblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewAllSymblMouseEntered
        Color clr = new Color(6, 3, 170);
        panelViewAllSymbl.setBackground(clr);
    }//GEN-LAST:event_btnViewAllSymblMouseEntered

    private void panelViewAllSymblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelViewAllSymblMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_panelViewAllSymblMouseExited

    private void btnLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseEntered
        Color clr = new Color(6, 3, 170);
        panelLogout.setBackground(clr);
    }//GEN-LAST:event_btnLogoutMouseEntered

    private void panelLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelLogoutMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_panelLogoutMouseExited

    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
        Color clr = new Color(6, 3, 170);
        panelBack.setBackground(clr);
    }//GEN-LAST:event_btnBackMouseEntered

    private void panelBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBackMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_panelBackMouseExited

    private void btnEditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseEntered
       Color clr = new Color(6, 3, 170);
        panelEdit.setBackground(clr);
    }//GEN-LAST:event_btnEditMouseEntered

    private void panelEditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelEditMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_panelEditMouseExited

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited
        Color clr = new Color(41,98,255);
        panelHome.setBackground(clr);

    }//GEN-LAST:event_btnHomeMouseExited

    private void btnSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseExited
        Color clr = new Color(41,98,255);
        panelSearch.setBackground(clr);
    }//GEN-LAST:event_btnSearchMouseExited

    private void btnEditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseExited
        Color clr = new Color(41,98,255);
        panelEdit.setBackground(clr);
    }//GEN-LAST:event_btnEditMouseExited

    private void btnSectorListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSectorListMouseExited
        Color clr = new Color(41,98,255);
        panelSectorList.setBackground(clr);
    }//GEN-LAST:event_btnSectorListMouseExited

    private void btnViewAllSymblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewAllSymblMouseExited
        Color clr = new Color(41,98,255);
        panelViewAllSymbl.setBackground(clr);
    }//GEN-LAST:event_btnViewAllSymblMouseExited

    private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseExited
        Color clr = new Color(41,98,255);
        panelBack.setBackground(clr);
    }//GEN-LAST:event_btnBackMouseExited

    private void btnLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseExited
        Color clr = new Color(41,98,255);
        panelLogout.setBackground(clr);
    }//GEN-LAST:event_btnLogoutMouseExited

    private void txt_roeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_roeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_roeActionPerformed

    private void txt_cashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cashActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cashActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        if(validation()==true)
        {
//            JOptionPane.showMessageDialog(this, "Validation Sucessfull");
            
           String result = updateData();
           
           if(result.equals("success")){
               JOptionPane.showMessageDialog(this, "Record updated successfully");
               PrintScript p = new PrintScript();
               p.setVisible(true);
               this.dispose();
               
               
           }else{
               JOptionPane.showMessageDialog(this, "Record updation failed");
           }
        }
    }//GEN-LAST:event_btn_printActionPerformed

    private void txt_marketCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_marketCapActionPerformed
        Float Mcap =Float.parseFloat(txt_marketCap.getText());
    }//GEN-LAST:event_txt_marketCapActionPerformed

    private void comboSectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSectorActionPerformed
        txt_sectorName.setText(comboSector.getSelectedItem().toString());
        
    }//GEN-LAST:event_comboSectorActionPerformed

    private void txt_divYieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_divYieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_divYieldActionPerformed

    private void jLabel23KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel23KeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jLabel23KeyPressed

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        // TODO add your handling code here:
      
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseEntered
        // TODO add your handling code here:
        lbl_info.setText("This shows the Current Market Price of the stock");
    }//GEN-LAST:event_jLabel23MouseEntered

    private void jLabel23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseExited
        // TODO add your handling code here:
        lbl_info.setText("");
    }//GEN-LAST:event_jLabel23MouseExited

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
            java.util.logging.Logger.getLogger(UpdateDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateDetails().setVisible(true);
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
    private javax.swing.JButton btn_print;
    private javax.swing.JComboBox<String> comboSector;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_info;
    private javax.swing.JPanel panelBack;
    private javax.swing.JPanel panelEdit;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelLogout;
    private javax.swing.JPanel panelParent;
    private javax.swing.JPanel panelSearch;
    private javax.swing.JPanel panelSectorList;
    private javax.swing.JPanel panelViewAllSymbl;
    private javax.swing.JPanel panelsideBar;
    private javax.swing.JTextField txt_52High;
    private javax.swing.JTextField txt_52Low;
    private javax.swing.JTextField txt_CompanyName;
    private javax.swing.JTextField txt_PB;
    private javax.swing.JTextField txt_PE;
    private javax.swing.JTextField txt_bookVal;
    private javax.swing.JTextField txt_cash;
    private javax.swing.JTextField txt_cmp;
    private javax.swing.JTextField txt_dayHigh;
    private javax.swing.JTextField txt_dayLow;
    private javax.swing.JTextField txt_divYield;
    private javax.swing.JTextField txt_enterpriseVal;
    private javax.swing.JTextField txt_eps;
    private javax.swing.JTextField txt_faceVal;
    private javax.swing.JTextField txt_marketCap;
    private javax.swing.JTextField txt_noOfShares;
    private javax.swing.JTextField txt_profitGrowth;
    private javax.swing.JTextField txt_promoterHolding;
    private javax.swing.JTextField txt_roce;
    private javax.swing.JTextField txt_roe;
    private javax.swing.JTextField txt_salesGrowth;
    private javax.swing.JTextField txt_sectorName;
    private javax.swing.JTextField txt_symbl;
    private javax.swing.JTextField txt_symblNo;
    // End of variables declaration//GEN-END:variables
}
