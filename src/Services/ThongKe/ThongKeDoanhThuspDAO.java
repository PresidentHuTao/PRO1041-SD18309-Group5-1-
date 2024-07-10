/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.ThongKe;



import Models.ThongKe.ThongKeDoanhThuModel;
import Utilities.DBcontext;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author LVQ
 */
public class ThongKeDoanhThuspDAO {
    public ArrayList<ThongKeDoanhThuModel> getAll(){
        ArrayList<ThongKeDoanhThuModel> ds=new ArrayList<>();
        try {
            Connection cnt=DBcontext.getConnection();
            PreparedStatement pstm=cnt.prepareCall("SELECT SP.MaSanPham, SP.TenSanPham, SUM(HD.GiaTri) AS TongDoanhThu, SP.SoLuong AS TongSoLuong\n" +
"FROM SanPham SP\n" +
"LEFT JOIN HoaDon HD ON SP.MaSanPham = HD.MaSanPham\n" +
"GROUP BY SP.MaSanPham, SP.TenSanPham, SP.SoLuong");
            ResultSet rs=pstm.executeQuery();
            while (rs.next()) {                
                ds.add(new ThongKeDoanhThuModel(rs.getString(1),rs.getString(2),rs.getFloat(3),rs.getInt(4)));
            }
            return ds;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public Double getTongDoanhThu(){
        double a=0;
        try {
            Connection cnt=DBcontext.getConnection();
            PreparedStatement pstm=cnt.prepareCall("SELECT SUM(GiaTri) AS TongDoanhThu\n" +
"FROM HoaDon");
            ResultSet rs=pstm.executeQuery();
            while (rs.next()) {                
                 if (rs.getString(1)==null) {
                    a=0;
                } else {
                     a=rs.getDouble(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return a;
    }
    public Double getSHD(){
        double a=0;
        try {
            Connection cnt=DBcontext.getConnection();
            PreparedStatement pstm=cnt.prepareCall("SELECT COUNT(*) AS TongSoHoaDon\n" +
"FROM HoaDon");
            ResultSet rs=pstm.executeQuery();
            while (rs.next()) {                
                 if (rs.getString(1)==null) {
                    a=0;
                } else {
                     a=rs.getDouble(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return a;
    }
     public Double getSLSP(){
        double a=0;
        try {
            Connection cnt=DBcontext.getConnection();
            PreparedStatement pstm=cnt.prepareCall("SELECT COUNT(*) AS TongSoLuongSanPham\n" +
"FROM SanPham");
            ResultSet rs=pstm.executeQuery();
            while (rs.next()) {                
                 if (rs.getString(1)==null) {
                    a=0;
                } else {
                     a=rs.getDouble(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return a;
    }
     public Double getTongKH(){
        double a=0;
        try {
            Connection cnt=DBcontext.getConnection();
            PreparedStatement pstm=cnt.prepareCall("SELECT COUNT(*) AS TongSoLuongSanPham\n" +
"FROM SanPham");
            ResultSet rs=pstm.executeQuery();
            while (rs.next()) {                
                 if (rs.getString(1)==null) {
                    a=0;
                } else {
                     a=rs.getDouble(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return a;
    }
}
