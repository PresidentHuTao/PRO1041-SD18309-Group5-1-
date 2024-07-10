/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.ThongKe;

import Models.ThongKe.ThongKeNhanVienModel;
import Utilities.DBcontext;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author LVQ
 */
public class ThongKeNhanVienDAO {
    public ArrayList<ThongKeNhanVienModel> getAll(){
        ArrayList<ThongKeNhanVienModel> ds=new ArrayList<>();
        try {
            Connection cnt=DBcontext.getConnection();
            PreparedStatement pstm=cnt.prepareCall("SELECT\n" +
"    NhanVien.MaNhanVien,\n" +
"    NhanVien.HoTen,\n" +
"    COUNT(HoaDon.MaHoaDon) AS SoLuongHoaDon,\n" +
"    SUM(HoaDon.GiaTri) AS TongDoanhThu\n" +
"FROM\n" +
"    NhanVien\n" +
"    LEFT JOIN HoaDon ON NhanVien.MaNhanVien = HoaDon.MaNhanVien\n" +
"    LEFT JOIN ChiTietHoaDon ON HoaDon.MaHoaDon = ChiTietHoaDon.MaHoaDon\n" +
"GROUP BY\n" +
"    NhanVien.MaNhanVien,\n" +
"    NhanVien.HoTen;");
            ResultSet rss=pstm.executeQuery();
            while (rss.next()) {                
                ds.add(new ThongKeNhanVienModel(rss.getString(1),rss.getString(2), rss.getDouble(3),rss.getDouble(4)));
            }
            return ds;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
