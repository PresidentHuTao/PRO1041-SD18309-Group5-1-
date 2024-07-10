/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.DotGiamGia;

import java.sql.*;
import Models.*;
import Models.DotGiamGia.SanPhamGiamGia;
import Services.*;
import Utilities.DBcontext;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author os
 */
public class SanPhamGiamGiaServices {
    String sql;
    Connection con = DBcontext.getConnection();
    
    public List<SanPhamGiamGia> getAll(){
        List<SanPhamGiamGia> ListSP = new ArrayList<>();
sql = "select SanPham.MaSanPham, SanPham.TenSanPham , DotGiamGia.MaDot ,DotGiamGia.PhanTramTienGiam,DotGiamGia.SoTienGiam, SanPham.DonGia ,DOTGIAMGIA_TrangThaiDotGiamGia.GhiChu from SanPham join DOTGIAMGIA_SanPhamApDung on SanPham.MaSanPham = DOTGIAMGIA_SanPhamApDung.MaSanPham join DotGiamGia on DOTGIAMGIA_SanPhamApDung.MaSanPhamApDung = DotGiamGia.MaSanPhamApDung join DOTGIAMGIA_TrangThaiDotGiamGia on DotGiamGia.MaTrangThai= DOTGIAMGIA_TrangThaiDotGiamGia.MaTrangThai";
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {                
                SanPhamGiamGia sp = new SanPhamGiamGia();
                sp.setMaSP(rs.getString("MaSanPham"));
                sp.setTenSP(rs.getString("TenSanPham"));
                sp.setMaDot(rs.getString("MaDot"));
                sp.setPTGiam(rs.getFloat("PhanTramTienGiam"));
                sp.setTienGiam(rs.getFloat("SoTienGiam"));
                sp.setGiaGoc(rs.getFloat("DonGia"));
                sp.setTrangThai(rs.getString("GhiChu"));
            
            ListSP.add(sp);
            }
            
            stm.close();
            rs.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return ListSP;
        
        
    }
    public List<SanPhamGiamGia> FindMaSP(String maSanPham){
        List<SanPhamGiamGia> ListF = new ArrayList<>();
        for(SanPhamGiamGia s: getAll()){
            if(s.getMaSP().startsWith(maSanPham)){
                ListF.add(s);
            }
        }
        return ListF;
    }
    public List<SanPhamGiamGia> FindTenSP(String TenSp){
        List<SanPhamGiamGia> ListF = new ArrayList<>();
        for(SanPhamGiamGia s: getAll()){
            if(s.getTenSP().startsWith(TenSp)){
                ListF.add(s);
            }
        }
        return ListF;
    }
}
//com.microsoft.sqlserver.jdbc.SQLServerException: The column name SanPham.MaSanPham is not valid.

