/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;
import java.sql.*;
import Utilities.*;
import Models.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author os
 */
public class AccoutServices {
    String sql;
    Connection con = DBcontext.getConnection();
    
    public List<AccountSIGN> getAll(){
        List<AccountSIGN> listacc = new ArrayList<>();
        sql = "select NhanVien.MaNhanVien,NhanVien.MatKhau,NhanVien.HoTen,NHANVIEN_ChucVu.MaCV,NHANVIEN_ChucVu.TenCV from NhanVien join NHANVIEN_ChucVu on NhanVien.MaCV=NHANVIEN_ChucVu.MaCV";
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while (rs.next()) {                
                AccountSIGN acc = new AccountSIGN();
                acc.setUser(rs.getString("MaNhanVien"));
                acc.setPass(rs.getString("MatKhau"));
                acc.setTennv(rs.getString("HoTen"));
                acc.setMaCV(rs.getInt("MaCV"));
                acc.setTenCV(rs.getString("TenCV"));
                
                listacc.add(acc);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return listacc;
    }
}
