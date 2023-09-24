/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Connection.connectDatabase;
import Entity.NhanVien;
import Entity.TaiKhoan;
import java.sql.*;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class TaiKhoan_DAO {
    NhanVien_DAO nvDao= new NhanVien_DAO();
    connectDatabase cn = new connectDatabase();
    Connection conn;
    ResultSet rs;

    public ArrayList<TaiKhoan> Listtk() {
        ArrayList<TaiKhoan> Listtk = new ArrayList<>();
        try {
            conn = cn.getConnection();
            String sql = "select *from TaiKhoan";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            TaiKhoan listtk;
            while (rs.next()) {
                listtk = new TaiKhoan(rs.getInt("MaNhanVien"), rs.getString("TenTaiKhoan"), rs.getString("MatKhau"), rs.getString("QuyenTruyCap"), rs.getString("TenNhanVien"));
                Listtk.add(listtk);
            }
        } catch (Exception e) {
        }
        return Listtk;
    }
        public ArrayList<TaiKhoan_DTO> taikhoanDN(String user) {
        ArrayList<TaiKhoan_DTO> Listtk = new ArrayList<>();
        try {
            conn = cn.getConnection();
            String sql = "select *from TaiKhoan where TenTaiKhoan=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, user);
            ResultSet rs = st.executeQuery(sql);
            TaiKhoan_DTO listtk;
            while (rs.next()) {
                listtk = new TaiKhoan_DTO(rs.getInt("MaCongNhan"), rs.getString("TenTaiKhoan"), rs.getString("MatKhau"), rs.getString("QuyenTruyCap"), rs.getString("TenNhanVien"));
                Listtk.add(listtk);
            }
        } catch (Exception e) {
        }
        return Listtk;
    }

    public void themnv(String maNV, String tenTK, String matKhau, String quyenTC, String tenNV, JTable table) {
        conn = cn.getConnection();

        String sql = "insert into TaiKhoan(MaCongNhan,TenTaiKhoan,MatKhau,QuyenTruyCap,TenNhanVien) values(?,?,?,?,?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, maNV);
            pst.setString(2, tenTK);
            pst.setString(3, matKhau);

            pst.setString(4, quyenTC);

            pst.setString(5, tenNV);

            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            show_TK(table);
            JOptionPane.showMessageDialog(null, "them thanh cong");
        } catch (SQLException ex) {

        }

    }
    public void show_DSNV(JTable table) {
        ArrayList<CongNhan> list = cnDao.docTuBang();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Object[] row = new Object[3];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getTenCN();
            row[1] = list.get(i).getMaCN();
            row[2] = list.get(i).getChucVu();
            
            model.addRow(row);
        }
    }
     public void show_TK(JTable table) {
        ArrayList<TaiKhoan_DTO> list = Listtk();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Object[] row = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getTenTaiKhoan();
            row[1] = list.get(i).getMatKhau();
            row[2] = list.get(i).getTenNV();
            row[3] = list.get(i).getMaCN();
            row[4] = list.get(i).getQuyenTC();
            model.addRow(row);
        }
    }
    public void xoaTK(String tentk, JTable table){
          conn = cn.getConnection();

        String sql = "DELETE FROM TaiKhoan WHERE TenTaiKhoan=?";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, tentk);
            MyDialog dlg = new MyDialog("Bạn có muốn xóa không", MyDialog.WARNING_DIALOG);
            if (dlg.getAction() == MyDialog.OK_OPTION) {

                pst.executeUpdate();
                new MyDialog("Xóa thành công", MyDialog.SUCCESS_DIALOG);
            }

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            show_TK(table);
        } catch (SQLException ex) {
           
        }
    }
    public void suaTK(String maNV,String tenTaiKhoan,String matKhau,String tenNV,String quyen,JTable table){
          conn = cn.getConnection();

        

        String sql = "UPDATE TaiKhoan SET MaCongNhan=?,TenTaiKhoan=?,MatKhau=?,QuyenTruyCap=?,TenNhanVien=? where TenTaiKhoan =? ";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, maNV);
            pst.setString(2, tenTaiKhoan);
            pst.setString(3, matKhau);
            pst.setString(4, quyen);
            pst.setString(5, tenNV);
            pst.setString(6, tenTaiKhoan);
            

            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            show_TK(table);
            new MyDialog("Sửa thành công", MyDialog.SUCCESS_DIALOG);

        } catch (SQLException ex) {
         
        }
    }
    
    
}

