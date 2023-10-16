/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import GUI.GUI_Admin;
import GUI.GUI_DonHang;
import GUI.GUI_Home;
import GUI.GUI_PhieuThongKe;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import menu.menuPrimary;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 *
 * @author TriHieu
 */
public class chuyenMHController {
    private JPanel root;
    private String kindSelected = "";
    private List<menuPrimary> listItem = null;

    public chuyenMHController(JPanel root) {
        this.root = root;
    }
    
    public void setView(JPanel jpnItem, JLabel JlbItem){
        kindSelected = "Home";
//        jpnItem.setBackground(new Color(96, 100, 191 ));        
//        JlbItem.setBackground(new Color(96, 100, 191 ));
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new GUI_Home());
        root.validate();
        root.repaint();
    }
    
    public void setEvent(List<menuPrimary> listItem){
        this.listItem = listItem;
        for (menuPrimary item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(),item.getJlb() ));
        }
    }
    class LabelEvent implements MouseListener{
        private JPanel node;
        private String kind;
        private JPanel jpnItem;
        private JLabel JlbItem;

        public LabelEvent( String kind, JPanel jpnItem, JLabel JlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.JlbItem = JlbItem;
        }
        
        
        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "ThongKe":
                    node = new GUI_PhieuThongKe();
                    break;
                case "DonHang":
                    node = new GUI_DonHang();
                    break;
                case "Admin":
                    node = new GUI_Admin();
                    break;
                case "Home":
                    node = new GUI_Home();
                    break;
                default:
                    node = new GUI_Home();
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
//            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
//            jpnItem.setBackground(new Color(96, 100, 191));            
//            JlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
//            jpnItem.setBackground(new Color(96, 100, 191));            
//            JlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
//            if(!kindSelected.equalsIgnoreCase(kind)){
//                jpnItem.setBackground(new Color(76, 175, 80));            
//                JlbItem.setBackground(new Color(76, 175, 80));
            }
        }
        private void setChangeBackground (String k){
//            for (menuPrimary item : listItem) {
//                if(item.getKind().equalsIgnoreCase(k)){
//                    item.getJlb().setBackground(new Color(96, 100, 191));
//                    item.getJpn().setBackground(new Color(96, 100, 191));
//                }else {
//                    item.getJlb().setBackground(new Color(76, 175, 80));
//                    item.getJpn().setBackground(new Color(76, 175, 80));
//                }
//            }
//        }
        
    }
}
