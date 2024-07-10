/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.DotGiamGia;

import Models.DotGiamGia.DotGiamGia;
import Utilities.DBcontext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author os
 */
public class DotGiamGiaServices {
    String sql;
    Connection con = DBcontext.getConnection();
    
    public List<DotGiamGia> getAll(){
        List<DotGiamGia> ListD = new ArrayList<>();
        sql =  "select *,DOTGIAMGIA_LoaiGiamGia.TenLoai,DOTGIAMGIA_TrangThaiDotGiamGia.TenTrangThai from DotGiamGia join DOTGIAMGIA_LoaiGiamGia on DotGiamGia.MaLoai = DOTGIAMGIA_LoaiGiamGia.MaLoai join DOTGIAMGIA_TrangThaiDotGiamGia on DotGiamGia.MaTrangThai = DOTGIAMGIA_TrangThaiDotGiamGia.MaTrangThai";
        
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {                
                DotGiamGia dot = new DotGiamGia();
            dot.setMaDot(rs.getString("MaDot"));
            dot.setMaSP(rs.getInt("MaSanPhamApDung"));
            dot.setTenLoai(rs.getInt("MaLoai"));
            dot.setNgayBatDau(rs.getString("NgayBatDau"));
            dot.setNgayKetThuc(rs.getString("NgayKetThuc"));
            dot.setTienGiam(rs.getFloat("SoTienGiam"));
            dot.setPhanTramGiam(rs.getFloat("PhanTramTienGiam"));
            dot.setTrangThai(rs.getInt("MaTrangThai"));
            
            ListD.add(dot);
            }
            
            stm.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return ListD;
        
        
    }
    public int add(DotGiamGia s){
        sql = "insert into DotGiamGia(MaDot,MaLoai,PhanTramTienGiam,SoTienGiam,NgayBatDau,NgayKetThuc,MaTrangThai,MaSanPhamApDung) values (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, s.getMaDot());
            stm.setInt(2, s.getTenLoai());
            stm.setFloat(3, s.getPhanTramGiam());
            stm.setFloat(4, s.getTienGiam());
            stm.setString(5, s.getNgayBatDau());
            stm.setString(6, s.getNgayKetThuc());
            stm.setInt(7, s.getTrangThai());
            stm.setInt(8, s.getMaSP());
            int aff = stm.executeUpdate();
            return aff;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return 0;
    }
     public int update(String maDot, DotGiamGia s) {
        sql = "update DotGiamGia set MaLoai=?, PhanTramTienGiam=?, SoTienGiam=?, NgayBatDau=?, NgayKetThuc=?, MaTrangThai=? ,MaSanPhamApDung=?  where MaDot=? ";
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, s.getTenLoai());
            stm.setFloat(2, s.getPhanTramGiam());
            stm.setFloat(3, s.getTienGiam());
            stm.setString(4, s.getNgayBatDau());
            stm.setString(5, s.getNgayKetThuc());
            stm.setInt(6, s.getTrangThai());
             stm.setInt(7, s.getMaSP());
            stm.setString(8, maDot); // Mã đợt cần cập nhật
            int aff = stm.executeUpdate();
            return aff;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return 0;
    }

    public int delete(String maDot) {
        sql = "delete from DotGiamGia where MaDot=?";
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, maDot); // Mã đợt cần xóa
            int aff = stm.executeUpdate();
            return aff;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return 0;
    }
    
    public List<DotGiamGia> Find(String madot){
        List<DotGiamGia> ListF = new ArrayList<>();
        for(DotGiamGia s: getAll()){
            if(s.getMaDot().startsWith(madot)){
                ListF.add(s);
            }
        }
        return ListF;
    }
    
}
