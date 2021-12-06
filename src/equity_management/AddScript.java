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
public class AddScript extends javax.swing.JFrame {

    /**
     * Creates new form AddScript
     */
    public AddScript() {
        initComponents();
        fillComboBox();
        
        int symblNo = getSymblNo();
        txt_symblNo.setText(Integer.toString(symblNo));
        
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
    
    public String insertData(){
        
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
            java.sql.PreparedStatement pst =con.prepareStatement("insert into symbl_details values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            pst.setInt(1, symblNo);
            pst.setString(2, companyName);
            pst.setString(3, sectorName);
            pst.setString(4, date);
            pst.setFloat(5, currentPrice);
            pst.setFloat(6, dayLow);
            pst.setFloat(7, dayHigh);
            pst.setFloat(8, high52);
            pst.setFloat(9, low52);
            pst.setFloat(10, marketCap);
            pst.setFloat(11, enterprise);
            pst.setFloat(12, numberOfShares);
            pst.setFloat(13, peRatio);
            pst.setFloat(14, pbRatio);
            pst.setFloat(15, faceValue);
            pst.setFloat(16, bookValue);
            pst.setFloat(17, divYield);
            pst.setFloat(18, cash);
            pst.setFloat(19, promoterHold);
            pst.setFloat(20, eps);
            pst.setFloat(21, salesGrowth);
            pst.setFloat(22, profitGrowth);
            pst.setFloat(23, roe);
            pst.setFloat(24, roce);
            pst.setString(25, symbl);
            
            
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
        panelSectorList.add(btnSectorList, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, -1));

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
        jLabel1.setText("ROE(%):");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });
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
        jLabel5.setText("Profit Growth(%):");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });
        panelParent.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 800, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Enterprise Value(₹):");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });
        panelParent.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 450, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("No.of Shares:");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
        });
        panelParent.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 450, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("P/E Ratio:");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel8MouseExited(evt);
            }
        });
        panelParent.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 450, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("P/B Ratio:");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
        });
        panelParent.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 450, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Face Value(₹):");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
        });
        panelParent.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 630, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Div.Yield(%):");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });
        panelParent.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 630, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Book Value(₹):");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });
        panelParent.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 630, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Cash(₹):");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });
        panelParent.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 630, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Promoter Holding(%):");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel14MouseExited(evt);
            }
        });
        panelParent.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 630, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("EPS(₹):");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel15MouseExited(evt);
            }
        });
        panelParent.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 800, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Sales Growth(%):");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel16MouseExited(evt);
            }
        });
        panelParent.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 800, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Market CAP(₹):");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
        });
        panelParent.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("ROCE(%):");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel18MouseExited(evt);
            }
        });
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
        jLabel20.setText("Today's High(₹):");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel20MouseExited(evt);
            }
        });
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
        jLabel23.setText("CMP(₹):");
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
        jLabel24.setText("Today's Low(₹):");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel24MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel24MouseExited(evt);
            }
        });
        panelParent.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 320, -1, -1));

        txt_dayLow.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelParent.add(txt_dayLow, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 370, 240, 30));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("52 Weeks High(₹):");
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel25MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel25MouseExited(evt);
            }
        });
        panelParent.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 320, -1, -1));

        txt_52High.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelParent.add(txt_52High, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 370, 240, 30));

        txt_52Low.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelParent.add(txt_52Low, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 370, 240, 30));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("52 Week's Low(₹):");
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel26MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel26MouseExited(evt);
            }
        });
        panelParent.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 320, -1, -1));

        btn_print.setBackground(new java.awt.Color(41, 98, 255));
        btn_print.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btn_print.setForeground(new java.awt.Color(255, 255, 255));
        btn_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/equity_management/images/printer-.png"))); // NOI18N
        btn_print.setText("SAVE & PRINT");
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        panelParent.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 930, -1, 80));
        panelParent.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 1480, 20));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Company:");
        panelParent.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        txt_symblNo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelParent.add(txt_symblNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 270, 30));

        lbl_info.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_info.setForeground(new java.awt.Color(255, 255, 255));
        lbl_info.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        panelParent.add(lbl_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 910, 1150, 90));

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
            
           String result = insertData();
           
           if(result.equals("success")){
               JOptionPane.showMessageDialog(this, "Record inserted successfully");
               PrintScript p = new PrintScript();
               p.setVisible(true);
               this.dispose();
               
               
           }else{
               JOptionPane.showMessageDialog(this, "Record insertion failed");
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

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        // TODO add your handling code here:
         home h = new home();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackMouseClicked

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked
        // TODO add your handling code here:
         home h = new home();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHomeMouseClicked

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
        allSector sectorsearch = new allSector();
        sectorsearch.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSectorListMouseClicked

    private void btnViewAllSymblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewAllSymblMouseClicked
        // TODO add your handling code here:
        viewRecord symblrecord = new viewRecord();
        symblrecord.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnViewAllSymblMouseClicked

    private void jLabel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseEntered
        // TODO add your handling code here:
        lbl_info.setText("Today's high refers to a security's intraday highest trading ");
    }//GEN-LAST:event_jLabel20MouseEntered

    private void jLabel24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseEntered
        // TODO add your handling code here:
        lbl_info.setText("Today's low refers to a security's intraday lowest trading ");

    }//GEN-LAST:event_jLabel24MouseEntered

    private void jLabel25MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseEntered
        // TODO add your handling code here:
                lbl_info.setText("52 weeks high refers to a security's 52 week highest trading price");

    }//GEN-LAST:event_jLabel25MouseEntered

    private void jLabel26MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseEntered
        // TODO add your handling code here:
        lbl_info.setText("52 weeks low refers to a security's 52 week lowest trading price");
    }//GEN-LAST:event_jLabel26MouseEntered

    private void jLabel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseEntered
        // TODO add your handling code here:
        lbl_info.setText("Market capitalization refers to how much a company is worth as determined by the stock market");
    }//GEN-LAST:event_jLabel17MouseEntered

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        // TODO add your handling code here:
        lbl_info.setText("Enterprise value (EV) is a measure of a company's total value");
        
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        // TODO add your handling code here:
        lbl_info.setText("The number of shares of common stock outstanding is a metric that tells us how many shares of a company are currently owned by investors");
    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseEntered
        // TODO add your handling code here:
        lbl_info.setText("P/E, or PER, is the ratio of a company's share price to the company's earnings per share");
    }//GEN-LAST:event_jLabel8MouseEntered

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        // TODO add your handling code here:
        lbl_info.setText("The price-to-book ratio, or P/B ratio, is a financial ratio used to compare a company's current market value to its book value");
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        // TODO add your handling code here:
        lbl_info.setText("Face value is a financial term used to describe the nominal or dollar value of a security");
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
        // TODO add your handling code here:
        lbl_info.setText("Book value is the value of an asset according to its balance sheet account balance");
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
        // TODO add your handling code here:
        lbl_info.setText("The dividend yield or dividend–price ratio of a share is the dividend per share, divided by the price per share.");
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        // TODO add your handling code here:
        lbl_info.setText("Cash-on-cash yield is a basic calculation used to estimate the return from an asset that generates income");
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
        // TODO add your handling code here:
        lbl_info.setText("Promoter holding signifies a percentage of the ownership in equity capital held by the promoters of a company");
        
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered
        // TODO add your handling code here:
        lbl_info.setText("Earnings per share is the monetary value of earnings per outstanding share of common stock for a company");
    }//GEN-LAST:event_jLabel15MouseEntered

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
        // TODO add your handling code here:
        lbl_info.setText("Sales growth is a metric that measures the ability of your sales team to increase revenue over a fixed period of time");
    }//GEN-LAST:event_jLabel16MouseEntered

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        // TODO add your handling code here:
        lbl_info.setText("Profitable Growth is the combination of profitability and growth, more precisely the combination of Economic Profitability and Growth of Free cash flows");
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        // TODO add your handling code here:
        lbl_info.setText("Return on equity (ROE) is the measure of a company's net income divided by its shareholders");
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseEntered
        // TODO add your handling code here:
        lbl_info.setText("Return on capital employed (ROCE) is a financial ratio that can be used to assess a company's profitability and capital efficiency.");
    }//GEN-LAST:event_jLabel18MouseEntered

    private void jLabel20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseExited
        // TODO add your handling code here:
         lbl_info.setText("");
    }//GEN-LAST:event_jLabel20MouseExited

    private void jLabel24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseExited
        // TODO add your handling code here:
         lbl_info.setText("");
    }//GEN-LAST:event_jLabel24MouseExited

    private void jLabel25MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseExited
        // TODO add your handling code here:
         lbl_info.setText("");
    }//GEN-LAST:event_jLabel25MouseExited

    private void jLabel26MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseExited
        // TODO add your handling code here:
         lbl_info.setText("");
    }//GEN-LAST:event_jLabel26MouseExited

    private void jLabel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseExited
        // TODO add your handling code here:
         lbl_info.setText("");
    }//GEN-LAST:event_jLabel17MouseExited

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        // TODO add your handling code here:
         lbl_info.setText("");
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        // TODO add your handling code here:
         lbl_info.setText("");
    }//GEN-LAST:event_jLabel7MouseExited

    private void jLabel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseExited
        // TODO add your handling code here:
         lbl_info.setText("");
    }//GEN-LAST:event_jLabel8MouseExited

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
        // TODO add your handling code here:
         lbl_info.setText("");
    }//GEN-LAST:event_jLabel9MouseExited

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
        // TODO add your handling code here:
         lbl_info.setText("");
    }//GEN-LAST:event_jLabel10MouseExited

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
        // TODO add your handling code here:
         lbl_info.setText("");
    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
        // TODO add your handling code here:
         lbl_info.setText("");
    }//GEN-LAST:event_jLabel11MouseExited

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
        // TODO add your handling code here:
         lbl_info.setText("");
    }//GEN-LAST:event_jLabel13MouseExited

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited
        // TODO add your handling code here:
         lbl_info.setText("");
    }//GEN-LAST:event_jLabel14MouseExited

    private void jLabel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseExited
        // TODO add your handling code here:
         lbl_info.setText("");
    }//GEN-LAST:event_jLabel15MouseExited

    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
        // TODO add your handling code here:
         lbl_info.setText("");
    }//GEN-LAST:event_jLabel16MouseExited

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        // TODO add your handling code here:
         lbl_info.setText("");
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        // TODO add your handling code here:
         lbl_info.setText("");
    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseExited
        // TODO add your handling code here:
         lbl_info.setText("");
    }//GEN-LAST:event_jLabel18MouseExited

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
            java.util.logging.Logger.getLogger(AddScript.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddScript.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddScript.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddScript.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddScript().setVisible(true);
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
