
package GUI;

import GUI.GUI_DonHang;
import GUI.GUI_Home;
import GUI.GUI_KhachHang;
import GUI.MenuItem;
import GUI.GUI_ThongKe;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.management.timer.Timer;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;
public class GUI_HomeMain extends javax.swing.JFrame {

    

    Connection conn;
    ResultSet rs;

//    public void clock() {
//        javax.swing.Timer Time;
//
//        //date  
//        Date d = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        String date = sdf.format(d);
//
//        //time
//        Time = new javax.swing.Timer(0, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                Date dt = new Date();
//                SimpleDateFormat st = new SimpleDateFormat("HH:mm:ss a");
//                String time = st.format(dt);
//
//                lblClock.setText("Ngày: " + date + "    Giờ: " + time);
//            }
//        });
//        Time.start();
//    }

    public GUI_HomeMain() {
    initComponents();
    setLocationRelativeTo(null);
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    
    execute();
  
}
   
   public void scaleImage() {
         ImageIcon icon =  new ImageIcon("D:\\Group4_PTUD\\BanHangThoiTrang\\src\\img\\bg_homeNew.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(bgHome.getWidth(), bgHome.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaleIcon  = new ImageIcon(imgScale);
        bgHome.setIcon(scaleIcon);
    }
   
    private void execute() {
        //icon
       
        ImageIcon iconSubMenu = new ImageIcon(getClass().getResource("/img/icon_item.png"));
        ImageIcon iconHome = new ImageIcon(getClass().getResource("/img/icon_home.png"));
        ImageIcon iconThongKe = new ImageIcon(getClass().getResource("/img/icon_tke.png"));
        ImageIcon iconHoaDon = new ImageIcon(getClass().getResource("/img/icon_order.png"));
        ImageIcon iconDangXuat = new ImageIcon(getClass().getResource("/img/icon_exit.png"));
        ImageIcon iconNhanVien = new ImageIcon(getClass().getResource("/img/icon_admin.png"));
        ImageIcon iconSupplier = new ImageIcon(getClass().getResource("/img/icon_supplier.png"));
        ImageIcon iconProduct = new ImageIcon(getClass().getResource("/img/icon_product.png"));

        //Create submenu
        MenuItem menuSanPham = new MenuItem(iconSubMenu, "Sản phẩm", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnlBody.removeAll();
                pnlBody.add(new GUI_KhachHang());
                pnlBody.repaint();
                pnlBody.revalidate();
            }
        });
        MenuItem menuHoaDon = new MenuItem(iconSubMenu, "Hóa Đơn", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnlBody.removeAll();
                pnlBody.add(new GUI_HoaDon());
                pnlBody.repaint();
                pnlBody.revalidate();
            }
        });
        MenuItem menuPB2 = new MenuItem(iconSubMenu, "Đơn Hàng", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnlBody.removeAll();
                pnlBody.add(new GUI_DonHang());
                pnlBody.repaint();
                pnlBody.revalidate();
            }
        });

        
        // Thống kê theo sản phẩm
        //create menu
        MenuItem menuHome = new MenuItem(iconHome, "Home",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnlBody.removeAll();
                pnlBody.add(new GUI_Home());
                pnlBody.repaint();
                pnlBody.revalidate();
            }
        });
        MenuItem menuSP = new MenuItem(iconProduct, "Sản Phẩm", null, menuHoaDon, menuPB2);
        MenuItem menuTKe = new MenuItem(iconThongKe, "Thống Kê", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnlBody.removeAll();
                pnlBody.add(new GUI_ThongKe());
                pnlBody.repaint();
                pnlBody.revalidate();
            }
        });
        MenuItem menuDangXuat = new MenuItem(iconDangXuat, "Đăng xuất", null);
        MenuItem menuNhanVien = new MenuItem(iconNhanVien, "Nhân Viên", null);
        MenuItem menuNCC = new MenuItem(iconSupplier, "Nhà Cung Cấp", null);
        MenuItem menuProduct = new MenuItem(iconHoaDon, "Hóa Đơn", null);
        
//        MenuItem menuCongTrinh = new MenuItem(null, "Công trình", null, menuCT1, menuCT2);
        MenuItem menuAdmin = new MenuItem(null, "Admin", null);
        addMenu( menuHome, menuSP,menuProduct, menuNhanVien, menuNCC, menuTKe, menuAdmin, menuDangXuat);

    }

    private void addMenu(MenuItem... menu) {
        for (int i = 0; i < menu.length; i++) {
            menus.add(menu[i]);
            ArrayList<MenuItem> subMenu = menu[i].getSubMenu();
            for (MenuItem m : subMenu) {
                addMenu(m);
            }
        }
        menus.revalidate();
    }
   
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMenu = new RoundedPanel(50, new Color(0, 204,204));
        jScrollPane1 = new javax.swing.JScrollPane();
        menus = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        LOGO = new javax.swing.JLabel();
        pnlBody = new javax.swing.JPanel();
        bgHome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FlashWork_Phần mềm chấm công");
        setBackground(new java.awt.Color(0, 204, 51));

        pnlMenu.setBackground(new java.awt.Color(204, 153, 0));
        pnlMenu.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setToolTipText("");
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setHorizontalScrollBar(null);

        menus.setBackground(new java.awt.Color(153, 51, 255));
        menus.setLayout(new javax.swing.BoxLayout(menus, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(menus);

        pnlMenu.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel5.setBackground(new java.awt.Color(153, 51, 255));

        LOGO.setBackground(new java.awt.Color(0, 204, 153));
        LOGO.setFont(new java.awt.Font("Segoe UI Symbol", 1, 30)); // NOI18N
        LOGO.setForeground(new java.awt.Color(255, 255, 255));
        LOGO.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LOGO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N
        LOGO.setText("FashionPro");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LOGO, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LOGO, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
        );

        pnlMenu.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        pnlBody.setBackground(new java.awt.Color(204, 204, 204));
        pnlBody.setLayout(new java.awt.BorderLayout());

        bgHome.setBackground(new java.awt.Color(255, 102, 102));
        bgHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bg_homeNew.png"))); // NOI18N
        pnlBody.add(bgHome, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlBody, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1182, 857));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LOGO;
    private javax.swing.JLabel bgHome;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel menus;
    private javax.swing.JPanel pnlBody;
    private javax.swing.JPanel pnlMenu;
    // End of variables declaration//GEN-END:variables
}
