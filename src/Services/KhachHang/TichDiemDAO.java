/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.KhachHang;

import Utilities.DBcontext;
import java.sql.*;
import java.util.ArrayList;
import Models.KhachHang.TichDiemKH;

/**
 *
 * @author VU ANH TAI
 */
public class TichDiemDAO {

    public ArrayList<TichDiemKH> getAllTichDiem() {
        ArrayList<TichDiemKH> lst = new ArrayList<>();
        String sql = "select TenKhachHang,TongDiemTichLuy,DiemDaDung,DiemConLai,hangKhach\n"
                + "from  KhachHang join KHACHHANG_TICHDIEM on KhachHang.MaTichDiemKH = KHACHHANG_TICHDIEM.MaTichDiemKH";
        Connection cn = DBcontext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                TichDiemKH td = new TichDiemKH(rs.getString("TenKhachHang"), rs.getInt("TongDiemTichLuy"),
                        rs.getInt("DiemDaDung"), rs.getInt("DiemConLai"), rs.getBoolean("hangKhach"));
                lst.add(td);
            }
        } catch (Exception e) {
        }
        return lst;
    }
}
