/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.KhachHang;

import Utilities.DBcontext;
import java.sql.*;
import java.util.ArrayList;
import Models.KhachHang.KhachHang;
import Models.KhachHang.LichSuGiaoDich;

/**
 *
 * @author VU ANH TAI
 */
public class LichSuGiaoDichDAO {

    public ArrayList<LichSuGiaoDich> getAllLichSuGiaoDich() {
        ArrayList<LichSuGiaoDich> lst = new ArrayList<>();
        String sql = "select TenKhachHang,TenSanPham,SDT,KHACHHANG_LICHSUMUAHANG.soLuong,tongTien,ThanhToan\n"
                + "from KhachHang join KHACHHANG_LICHSUMUAHANG on KhachHang.MaTraCuuLichSu = KHACHHANG_LICHSUMUAHANG.MaTraCuuLichSu\n"
                + "				join SanPham on KHACHHANG_LICHSUMUAHANG.MaSanPham = SanPham.MaSanPham";

        try {

            Connection cn = DBcontext.getConnection();
            PreparedStatement pstm = cn.prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                LichSuGiaoDich ls = new LichSuGiaoDich(rs.getString("TenKhachHang"), rs.getString("TenSanPham"),
                        rs.getString("SDT"), rs.getFloat("soLuong"), rs.getFloat("tongTien"), rs.getBoolean("ThanhToan"));
                lst.add(ls);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lst;
    }
}
