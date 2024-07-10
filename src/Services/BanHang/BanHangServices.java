/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.BanHang;

import Utilities.DBcontext;
import java.sql.Connection;
import Models.BanHang.*;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author os
 */
public class BanHangServices {

    String sql;
    Connection con = DBcontext.getConnection();

    public List<SanPhamBan> GetListSP() {
        List<SanPhamBan> listsp = new ArrayList<>();
        sql = "SELECT\n"
                + "    SanPham.MaSanPham,\n"
                + "    SanPham.TenSanPham,\n"
                + "    SanPham.DonGia,\n"
                + "    COALESCE(DotGiamGia.PhanTramTienGiam, 0) AS PhanTramTienGiam,\n"
                + "    SanPham.SoLuong\n"
                + "FROM\n"
                + "    SanPham\n"
                + "LEFT JOIN\n"
                + "    DOTGIAMGIA_SanPhamApDung ON SanPham.MaSanPham = DOTGIAMGIA_SanPhamApDung.MaSanPham\n"
                + "LEFT JOIN\n"
                + "    DotGiamGia ON DOTGIAMGIA_SanPhamApDung.MaSanPhamApDung = DotGiamGia.MaSanPhamApDung";
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                SanPhamBan sp = new SanPhamBan();
                sp.setMaSP(rs.getString("MaSanPham"));
                sp.setTenSP(rs.getString("TenSanPham"));
                sp.setGia(rs.getBigDecimal("DonGia"));
                sp.setGiamGia(rs.getBigDecimal("PhanTramTienGiam"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                listsp.add(sp);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return listsp;
    }

    public List<HoaDon> GetListHD() {
        List<HoaDon> listhd = new ArrayList<>();
        sql = "select * from HoaDon where TrangThai = 2";
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getInt("MaHoaDon"));
                hd.setGiatri(BigDecimal.valueOf(rs.getFloat("GiaTri")));
                hd.setManv(rs.getString("MaNhanVien"));
                hd.setIdkhachhang(rs.getInt("IDKhachHang"));
                hd.setMaphieugiam(rs.getString("MaPhieuGiamGia"));
                hd.setHinhthucNH(rs.getInt("HinhThucNhanHang"));
                hd.setHinhthucTT(rs.getInt("HinhThucTT"));
                hd.setNgaytao(rs.getString("NgayTao"));
                hd.setTrangthai(rs.getInt("TrangThai"));
                hd.setSdt(rs.getString("SoDT"));
                hd.setGhichu(rs.getString("GhiChu"));
                listhd.add(hd);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return listhd;
    }

    public int addhdcho(HoaDon hd) {
        sql = "SET IDENTITY_INSERT HoaDon ON;"
                //  +"delete from ChiTietHoaDon where MaHoaDon = "+hd.getMaHD()
                + "insert into HoaDon(MaHoaDon,MaNhanVien,GiaTri,MaPhieuGiamGia,SoDT,HinhThucTT,HinhThucNhanHang,TrangThai,GhiChu,NgayTao) values (?,?,?,?,?,?,?,?,?,?);"
                + "SET IDENTITY_INSERT HoaDon OFF;";
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, hd.getMaHD());
            stm.setString(2, hd.getManv());
            stm.setBigDecimal(3, hd.getGiatri());
            stm.setString(4, hd.getMaphieugiam());
            stm.setString(5, hd.getSdt());
            stm.setInt(6, hd.getHinhthucTT());
            stm.setInt(7, hd.getHinhthucNH());
            stm.setInt(8, hd.getTrangthai());
            stm.setString(9, hd.getGhichu());
            stm.setString(10, hd.getNgaytao());
            int rowAFF = stm.executeUpdate();
            return rowAFF;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return 0;
    }

    public int addhoadonchitiet(ChiTietHoaDon cthd) {
        sql = "insert into ChiTietHoaDon(MaHoaDon,MaSanPham,TenSanPham,SoLuong,TongTien) values (?,?,?,?,?);";

        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, cthd.getMaHD());
            stm.setString(2, cthd.getMaSP());
            stm.setString(3, cthd.getTenSP());
            stm.setInt(4, cthd.getSoLuong());
            stm.setBigDecimal(5, cthd.getDongia());

            int RowAFF = stm.executeUpdate();
            return RowAFF;
        } catch (Exception e) {
            System.out.println(e.toString());

        }
        return 0;
    }

    public List<ChiTietHoaDon> GetListCTHD(int mahd) {
        List<ChiTietHoaDon> Lcthd = new ArrayList<>();
        sql = "select * from ChiTietHoaDon where MaHoaDon = " + mahd;
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ChiTietHoaDon s = new ChiTietHoaDon();
                s.setMaSP(rs.getString("MaSanPham"));
                s.setTenSP(rs.getString("TenSanPham"));
                s.setSoLuong(rs.getInt("SoLuong"));
                s.setDongia(BigDecimal.valueOf(rs.getFloat("TongTien")));
                Lcthd.add(s);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return Lcthd;
    }

    public int hdmax() {
        int maxMaHD = 0;
        sql = "SELECT MAX(MaHoaDon) AS MaxMaHD FROM HoaDon";
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                maxMaHD = rs.getInt("MaxMaHD");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return maxMaHD;
    }

    public HoaDon getHoaDonByMaHD(int maHoaDon) {
        HoaDon hoaDon = null;
        sql = "SELECT * FROM HoaDon WHERE MaHoaDon = ?";
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, maHoaDon);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                hoaDon = new HoaDon();
                hoaDon.setMaHD(rs.getInt("MaHoaDon"));
                hoaDon.setGiatri(BigDecimal.valueOf(rs.getFloat("GiaTri")));
                hoaDon.setManv(rs.getString("MaNhanVien"));
                hoaDon.setIdkhachhang(rs.getInt("IDKhachHang"));
                hoaDon.setMaphieugiam(rs.getString("MaPhieuGiamGia"));
                hoaDon.setHinhthucNH(rs.getInt("HinhThucNhanHang"));
                hoaDon.setHinhthucTT(rs.getInt("HinhThucTT"));
                hoaDon.setNgaytao(rs.getString("NgayTao"));
                hoaDon.setTrangthai(rs.getInt("TrangThai"));
                hoaDon.setSdt(rs.getString("SoDT"));
                hoaDon.setGhichu(rs.getString("GhiChu"));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return hoaDon;
    }

    public int setMaTrangThai3(int maHoaDon) {
        sql = "UPDATE HoaDon SET TrangThai = 3 WHERE MaHoaDon = ?";
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, maHoaDon);
            int rowAffected = stm.executeUpdate();
            return rowAffected;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return 0;
    }

    public int deleteChiTietHoaDon(int maHoaDon) {
        String sqlStatement = "DELETE FROM ChiTietHoaDon WHERE MaHoaDon = " + maHoaDon;
        try {
            Statement stm = con.createStatement();
            int rowAffected = stm.executeUpdate(sqlStatement);
            return rowAffected;
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return 0;
    }

    public List<SanPhamBan> GetListSPByMa(String searchText) {
        List<SanPhamBan> listsp = new ArrayList<>();
        sql = "SELECT\n"
                + "    SanPham.MaSanPham,\n"
                + "    SanPham.TenSanPham,\n"
                + "    SanPham.DonGia,\n"
                + "    COALESCE(DotGiamGia.PhanTramTienGiam, 0) AS PhanTramTienGiam,\n"
                + "    SanPham.SoLuong\n"
                + "FROM\n"
                + "    SanPham\n"
                + "LEFT JOIN\n"
                + "    DOTGIAMGIA_SanPhamApDung ON SanPham.MaSanPham = DOTGIAMGIA_SanPhamApDung.MaSanPham\n"
                + "LEFT JOIN\n"
                + "    DotGiamGia ON DOTGIAMGIA_SanPhamApDung.MaSanPhamApDung = DotGiamGia.MaSanPhamApDung"
                + " WHERE SanPham.MaSanPham LIKE ? OR SanPham.TenSanPham LIKE ?";
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, "%" + searchText + "%"); // Tìm theo mã sản phẩm
            stm.setString(2, "%" + searchText + "%"); // Tìm theo tên sản phẩm
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                SanPhamBan sp = new SanPhamBan();
                sp.setMaSP(rs.getString("MaSanPham"));
                sp.setTenSP(rs.getString("TenSanPham"));
                sp.setGia(rs.getBigDecimal("DonGia"));
                sp.setGiamGia(rs.getBigDecimal("PhanTramTienGiam"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                listsp.add(sp);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return listsp;
    }

    public List<SanPhamBan> GetSortedListSP(int sortByColumn) {
        List<SanPhamBan> listsp = new ArrayList<>();
        String orderByColumn;

        switch (sortByColumn) {
            case 0:
                orderByColumn = "SanPham.MaSanPham";
                break;
            case 1:
                orderByColumn = "SanPham.TenSanPham";
                break;
            case 2:
                orderByColumn = "SanPham.DonGia";
                break;
            case 3:
                orderByColumn = "SanPham.SoLuong";
                break;
            default:
                orderByColumn = "SanPham.MaSanPham"; // Mặc định sắp xếp theo mã nếu giá trị không hợp lệ
                break;
        }

        sql = "SELECT\n"
                + "    SanPham.MaSanPham,\n"
                + "    SanPham.TenSanPham,\n"
                + "    SanPham.DonGia,\n"
                + "    COALESCE(DotGiamGia.PhanTramTienGiam, 0) AS PhanTramTienGiam,\n"
                + "    SanPham.SoLuong\n"
                + "FROM\n"
                + "    SanPham\n"
                + "LEFT JOIN\n"
                + "    DOTGIAMGIA_SanPhamApDung ON SanPham.MaSanPham = DOTGIAMGIA_SanPhamApDung.MaSanPham\n"
                + "LEFT JOIN\n"
                + "    DotGiamGia ON DOTGIAMGIA_SanPhamApDung.MaSanPhamApDung = DotGiamGia.MaSanPhamApDung"
                + " ORDER BY " + orderByColumn + " DESC"; // DESC để sắp xếp giảm dần

        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                SanPhamBan sp = new SanPhamBan();
                sp.setMaSP(rs.getString("MaSanPham"));
                sp.setTenSP(rs.getString("TenSanPham"));
                sp.setGia(rs.getBigDecimal("DonGia"));
                sp.setGiamGia(rs.getBigDecimal("PhanTramTienGiam"));
                sp.setSoLuong(rs.getInt("SoLuong"));
                listsp.add(sp);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return listsp;
    }

    public List<ChiTietHoaDon> GetSortedCTHD(int sortBy) {
        List<ChiTietHoaDon> listCTHD = new ArrayList<>();
        String orderByColumn;

        switch (sortBy) {
            case 0:
                orderByColumn = "ChiTietHoaDon.MaHoaDon"; // Sắp xếp theo mã đơn
                break;
            case 1:
                orderByColumn = "ChiTietHoaDon.TongTien"; // Sắp xếp theo giá
                break;
            default:
                orderByColumn = "ChiTietHoaDon.MaHoaDon"; // Mặc định sắp xếp theo mã đơn nếu giá trị không hợp lệ
                break;
        }

        sql = "SELECT * FROM ChiTietHoaDon ORDER BY " + orderByColumn + " ASC"; // ASC để sắp xếp tăng dần

        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ChiTietHoaDon cthd = new ChiTietHoaDon();
                cthd.setMaHD(rs.getInt("MaHoaDon"));
                cthd.setMaSP(rs.getString("MaSanPham"));
                cthd.setTenSP(rs.getString("TenSanPham"));
                cthd.setSoLuong(rs.getInt("SoLuong"));
                cthd.setDongia(BigDecimal.valueOf(rs.getFloat("TongTien")));
                listCTHD.add(cthd);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return listCTHD;
    }

    public int setTrangThaiHoaDonTo1(int maHoaDon) {
        sql = "UPDATE HoaDon SET TrangThai = 1 WHERE MaHoaDon = ?";
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, maHoaDon);
            int rowAffected = stm.executeUpdate();
            return rowAffected;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return 0;
    }

    public List<HoaDon> GetListHDFUll() {
        List<HoaDon> listhd = new ArrayList<>();
        sql = "select * from HoaDon ";
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getInt("MaHoaDon"));
                hd.setGiatri(BigDecimal.valueOf(rs.getFloat("GiaTri")));
                hd.setManv(rs.getString("MaNhanVien"));
                hd.setIdkhachhang(rs.getInt("IDKhachHang"));
                hd.setMaphieugiam(rs.getString("MaPhieuGiamGia"));
                hd.setHinhthucNH(rs.getInt("HinhThucNhanHang"));
                hd.setHinhthucTT(rs.getInt("HinhThucTT"));
                hd.setNgaytao(rs.getString("NgayTao"));
                hd.setTrangthai(rs.getInt("TrangThai"));
                hd.setSdt(rs.getString("SoDT"));
                hd.setGhichu(rs.getString("GhiChu"));
                listhd.add(hd);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return listhd;
    }

    public int findKhachHangByPhoneNumber(String phoneNumber) {
        int rowsAffected = 0;
        String sql = "SELECT * FROM KhachHang WHERE SDT = ?";
        Connection cn = DBcontext.getConnection();

        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, phoneNumber);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                // If a record is found, set rowsAffected to 
                rowsAffected = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return rowsAffected;
    }

    public int updateHoaDonCustomerId(int maHoaDon, int maKhachHang) {
        int rowsAffected = 0;
        String sql = "UPDATE HoaDon SET IDKhachHang = ? WHERE MaHoaDon = ?";
        Connection cn = DBcontext.getConnection();

        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, maKhachHang);
            pstm.setInt(2, maHoaDon);
            rowsAffected = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return rowsAffected;
    }
    public boolean isHoaDonExists(int maHoaDon) {
    String sql = "SELECT COUNT(*) AS Count FROM HoaDon WHERE MaHoaDon = ?";
    try {
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setInt(1, maHoaDon);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            int count = rs.getInt("Count");
            return count > 0;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}
}
