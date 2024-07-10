/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.SanPham;


import Models.SanPham.SanPham;
import Utilities.DBcontext;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author ADMIN
 */
public class SanPham_service {

    ArrayList<SanPham> ls = new ArrayList<>();

    public ArrayList<SanPham> getAll() {
        ArrayList<SanPham> lst = new ArrayList<>();
        try {
            String sql = "select *,b.TenNhaCC as NhaCungCap, c.TenLoaiSP as Loai,d.TenChatLieu as ChatLieu   from SanPham a  inner join SANPHAM_NhaCungCap b on  a.MaNhaCC = b.MaNhaCC\n"
                    + "inner join SANPHAM_LoaiSP c on a.MaLoaiSp = c.MaLoaiSp \n"
                    + "inner join SANPHAM_ChatLieu d on a.MaChatLieu = d.MaChatLieu";

            Connection cnn = DBcontext.getConnection();
            PreparedStatement ps = cnn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSp(rs.getString("MaSanPham"));
                sp.setTenSp(rs.getNString("TenSanPham"));
                sp.setMaCC(rs.getNString("NhaCungCap"));
                sp.setAnh(rs.getNString("TenAnh"));
                sp.setLoai(rs.getNString("Loai"));
                sp.setChatLieu(rs.getNString("ChatLieu"));
                sp.setDonGia(rs.getFloat("DonGia"));
                sp.setSolg(rs.getInt("SoLuong"));
                sp.setMoTa(rs.getNString("MoTa"));
//                sp.setNgayNhap(String.valueOf(rs.getDate("NgayNhap")));
//                sp.setTrangThai(rs.getBoolean("TrangThai"));
                sp.setIdChatLieu(rs.getInt("MaChatLieu"));
//                sp.setMaAnh(rs.getInt("MaAnh"));
                sp.setIdNcc(rs.getInt("MaNhaCC"));
                sp.setIdLoai(rs.getInt("MaLoaiSp"));
                lst.add(sp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lst;
    }

    public int add(SanPham sp) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            String sql = "INSERT [dbo].[SanPham] ([MaSanPham],[SoLuong] , [DonGia], [MoTa], [TenSanPham],[TenAnh], [TenAnhQR], [MaChatLieu], [MaLoaiSp],[MaNhaCC] ) VALUES (?,?,?,?,?,?,?,?,?,?)";
            conn = DBcontext.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, sp.getMaSp());
            stm.setInt(2, sp.getSolg());
            stm.setFloat(3, sp.getDonGia());
            stm.setString(4, sp.getMoTa());
            stm.setString(5, sp.getTenSp());
            stm.setString(6, sp.getAnh());
            stm.setString(7, sp.getAnhQr());
            stm.setInt(8, sp.getIdChatLieu());
            stm.setInt(9, sp.getIdLoai());
            stm.setInt(10, sp.getIdNcc());
            if (stm.executeUpdate() > 0) {
                System.out.println("add Thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try {
                conn.close();
                stm.close();
            } catch (Exception e) {

            }
        }
        return -1;
    }

    public int del(String id) {

        Connection conn = null;
        PreparedStatement stm = null;
        try {
            String sql = "delete from SanPham where MaSanPham = ?";
            conn = DBcontext.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, id);
            stm.executeUpdate();
            if (stm.executeUpdate() > 0) {
                System.out.println("Xoa Thanh cong");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try {
                conn.close();
                stm.close();
            } catch (Exception e) {

            }
        }
        return -1;
    }

    public int update(SanPham sp) {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            String sql = " update SanPham set SoLuong =?, DonGia = ?,MoTa = ?, TenSanPham=?, TenAnh =?,TenAnhQR = ? ,MaChatLieu = ?, MaLoaiSp = ?, MaNhaCC =?\n"
                    + " where MaSanPham = ?";
            conn = DBcontext.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(10, sp.getMaSp());
            stm.setInt(1, sp.getSolg());
            stm.setFloat(2, sp.getDonGia());
            stm.setString(3, sp.getMoTa());
            stm.setString(4, sp.getTenSp());
            stm.setString(5, sp.getAnh());
            stm.setString(6, sp.getAnhQr());
            stm.setInt(7, sp.getIdChatLieu());
            stm.setInt(8, sp.getIdLoai());
            stm.setInt(9, sp.getIdNcc());
            if (stm.executeUpdate() > 0) {
                System.out.println("Sửa Thành Công");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try {
                conn.close();
                stm.close();
            } catch (Exception e) {

            }
        }
        return -1;
    }

    public ArrayList<SanPham> getAlltop3() {
        ArrayList<SanPham> lst3 = new ArrayList<>();
       try {
            String sql = "select Top 3 *,b.TenNhaCC as NhaCungCap, c.TenLoaiSP as Loai,d.TenChatLieu as ChatLieu   from SanPham a  inner join SANPHAM_NhaCungCap b on  a.MaNhaCC = b.MaNhaCC\n"
                    + "inner join SANPHAM_LoaiSP c on a.MaLoaiSp = c.MaLoaiSp \n"
                    + "inner join SANPHAM_ChatLieu d on a.MaChatLieu = d.MaChatLieu \n"
                    +"ORDER BY a.SoLuong DESC";

            Connection cnn = DBcontext.getConnection();
            PreparedStatement ps = cnn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSp(rs.getString("MaSanPham"));
                sp.setTenSp(rs.getNString("TenSanPham"));
                sp.setMaCC(rs.getNString("NhaCungCap"));
                sp.setAnh(rs.getNString("TenAnh"));
                sp.setLoai(rs.getNString("Loai"));
                sp.setChatLieu(rs.getNString("ChatLieu"));
                sp.setDonGia(rs.getFloat("DonGia"));
                sp.setSolg(rs.getInt("SoLuong"));
                sp.setMoTa(rs.getNString("MoTa"));
//                sp.setNgayNhap(String.valueOf(rs.getDate("NgayNhap")));
//                sp.setTrangThai(rs.getBoolean("TrangThai"));
                sp.setIdChatLieu(rs.getInt("MaChatLieu"));
//                sp.setMaAnh(rs.getInt("MaAnh"));
                sp.setIdNcc(rs.getInt("MaNhaCC"));
                sp.setIdLoai(rs.getInt("MaLoaiSp"));
                lst3.add(sp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lst3;
    }
}
