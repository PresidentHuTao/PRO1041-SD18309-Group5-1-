
package Services.PhieuGiaoHang;


import Models.PhieuGiaoHang.PhieuGiaoHangModels;
import Utilities.DBcontext;
import Utilities.JdbcHelper;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class PhieuGiaoHangDao {
     public ArrayList<PhieuGiaoHangModels> getAll() {
       ArrayList<PhieuGiaoHangModels> pgh = new ArrayList<>();
         String sql = "Select PhieuGiaoHang.MaPhieu, NgayGiao, NguoiNhan, Sdt, Email, TrangThaiThanhToan, GhiChu,NguoiVanChuyen,SoTien,tenTrangThai\n"
                 + "From PhieuGiaoHang\n"
//                 + "join HoaDon on PhieuGiaoHang.MaPhieu=HoaDon.MaPhieu\n"
//                 + "join PHIEUGIAOHANG_DiaDiemGiaoHang on PhieuGiaoHang.MaDiaDiem=PHIEUGIAOHANG_DiaDiemGiaoHang.MaDiaDiem\n"
                 + "join PhieuGiaoHang_ThanhToan on PhieuGiaoHang.MaThanhToan=PhieuGiaoHang_ThanhToan.MaThanhToan\n"
                 + "join PHIEUGIAOHANG_thongTinVanChuyen on PhieuGiaoHang.MaVanChuyen=PHIEUGIAOHANG_thongTinVanChuyen.MaVanChuyen\n"
                 + "join PHIEUGIAOHANG_TrangThai on PHIEUGIAOHANG.MaTrangThai = PHIEUGIAOHANG_TrangThai.MaTrangThai";
        try {           
            Connection cn = DBcontext.getConnection();
            PreparedStatement ptsm = cn.prepareCall(sql);
            ResultSet rs = ptsm.executeQuery();
            while (rs.next()) {
                PhieuGiaoHangModels ph = new PhieuGiaoHangModels();
                
                ph.setMaPhieu(rs.getString(1));              
                ph.setNgayGiao(rs.getDate(2));
//                ph.setDiaChi(rs.getString(8)); 
                
                String stringValue = rs.getString(9);
                BigDecimal bigDecimalValue = new BigDecimal(stringValue);
                ph.setSoTien(bigDecimalValue);
                
//                ph.setSoTien(BigDecimal.(rs.getString(10)));
                ph.setNguoiVanChuyen(rs.getString(8));
                ph.setTrangThaiGiaoHang(rs.getString(10));
//                ph.setMaTrangThai(rs.getInt("MaTrangThai"));
                // ph.setDiaChi(rs.getString(3));
                ph.setNguoiNhan(rs.getString(3));
                ph.setSdt(rs.getString(4));
                ph.setGmail(rs.getString(5));
                ph.setTrangThaiThanhToan(rs.getString(6));
                ph.setGhiChu(rs.getString(7));
//                ph.setMaHoaDon(Integer.parseInt(rs.getString(11)));
                pgh.add(ph);
            }
        } catch (Exception e) {
              throw new RuntimeException(e);
        }
        return pgh;
    }
     
     public Integer add(PhieuGiaoHangModels nv) {
        Integer row = null;
//         String sql = "insert into PhieuGiaoHang "
//                 + "(MaPhieu, NgayGiao, NguoiNhan, Sdt, Email, TrangThaiThanhToan, GhiChu, MaVanChuyen, MaThanhToan,MaTrangThai)\n"
//                 + "values (?, ?, ?, ?, ?, ?,?, "
////                 + "(Select Max(MaDiaDiem) From PHIEUGIAOHANG_DiaDiemGiaoHang where TenTP = ? ),\n"
//                 + "                             (Select Max(MaVanChuyen) From PHIEUGIAOHANG_thongTinVanChuyen where NguoiVanChuyen = ? ),\n"
//                 + "                             (Select Max(MaThanhToan) From PhieuGiaoHang_ThanhToan where SoTien = ? ),\n"
//                 + "                             (Select Max(MaTrangThai) From PHIEUGIAOHANG_TrangThai where tenTrangThai = ?))";

String sql = "{call ThemPhieuGiaoHang_1234(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
                
//                 + "                               (SELECT Max(MaHoaDon) FROM HoaDon WHERE MaPhieu = ?))";
        Connection con = DBcontext.getConnection();       
        try {
            PreparedStatement pr = con.prepareCall(sql);
            pr.setObject(1, nv.getMaPhieu());
            pr.setObject(2, nv.getNgayGiao());
            pr.setObject(3, nv.getNguoiNhan());
            pr.setObject(4, nv.getSdt());
            pr.setObject(5, nv.getGmail());
            pr.setObject(6, nv.getTrangThaiThanhToan());
            pr.setObject(7, nv.getGhiChu());
//            pr.setObject(8, nv.getDiaChi());
            pr.setObject(9, nv.getSoTien());
            pr.setObject(8, nv.getNguoiVanChuyen());
            pr.setObject(10, nv.getTrangThaiGiaoHang()); 
//            pr.setInt(12, getLastMaHoaDon(con));
//            pr.setObject(12, getLastMaHoaDon(con));

            row = pr.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return row;
    }
private int getLastMaHoaDon(Connection con) {
    int lastMaHoaDon = 0;
    String query = "SELECT Max(MaHoaDon) FROM HoaDon";
    
    try (Statement statement = con.createStatement();
         ResultSet resultSet = statement.executeQuery(query)) {
        if (resultSet.next()) {
            lastMaHoaDon = resultSet.getInt(1);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    
    return lastMaHoaDon;
}
   
  public Integer update(PhieuGiaoHangModels pgh) {
    Integer row = null;
//      String sql = "UPDATE PhieuGiaoHang\n"
//              + "SET \n"
//              + "    NgayGiao = ?,\n"
//              + "    NguoiNhan = ?,\n"
//              + "    Sdt = ?,\n"
//              + "    Email = ?,\n"
//              + "    TrangThaiThanhToan = ?,\n"
//              + "    GhiChu = ?\n"
//              + "FROM PhieuGiaoHang\n"
////              + "INNER JOIN PHIEUGIAOHANG_DiaDiemGiaoHang ON PhieuGiaoHang.MaDiaDiem = PHIEUGIAOHANG_DiaDiemGiaoHang.MaDiaDiem\n"
//              + "INNER JOIN PhieuGiaoHang_ThanhToan ON PhieuGiaoHang.MaThanhToan = PhieuGiaoHang_ThanhToan.MaThanhToan\n"
//              + "INNER JOIN PHIEUGIAOHANG_thongTinVanChuyen ON PhieuGiaoHang.MaVanChuyen = PHIEUGIAOHANG_thongTinVanChuyen.MaVanChuyen\n"
//              + "INNER JOIN PHIEUGIAOHANG_TrangThai ON PHIEUGIAOHANG.MaTrangThai = PHIEUGIAOHANG_TrangThai.MaTrangThai\n"
//              + "WHERE \n"
//              + "    PhieuGiaoHang.MaPhieu = ? \n"
////              + "    AND PHIEUGIAOHANG_DiaDiemGiaoHang.TenTP = ? \n"
//              + "    AND PHIEUGIAOHANG_thongTinVanChuyen.NguoiVanChuyen = ? \n"
//              + "    AND PhieuGiaoHang_ThanhToan.SoTien = ? \n"
//              + "    AND PHIEUGIAOHANG_TrangThai.tenTrangThai = ?;";
//             "UPDATE PhieuGiaoHang\n" 
//               + "INNER JOIN PHIEUGIAOHANG_DiaDiemGiaoHang ON PhieuGiaoHang.MaDiaDiem = PHIEUGIAOHANG_DiaDiemGiaoHang.MaDiaDiem\n"
//              + "INNER JOIN PhieuGiaoHang_ThanhToan ON PhieuGiaoHang.MaThanhToan = PhieuGiaoHang_ThanhToan.MaThanhToan\n"
//              + "INNER JOIN PHIEUGIAOHANG_thongTinVanChuyen ON PhieuGiaoHang.MaVanChuyen = PHIEUGIAOHANG_thongTinVanChuyen.MaVanChuyen\n"
//              + "INNER JOIN PHIEUGIAOHANG_TrangThai ON PHIEUGIAOHANG.MaTrangThai = PHIEUGIAOHANG_TrangThai.MaTrangThai\n"
//              + "SET NgayGiao = ?, NguoiNhan = ?, Sdt = ?, Email = ?, TrangThaiThanhToan = ?, GhiChu = ?\n"   
//              + "WHERE PhieuGiaoHang.MaPhieu = ? \n"
//              + "    AND PHIEUGIAOHANG_DiaDiemGiaoHang.TenTP = ? \n"
//              + "    AND PHIEUGIAOHANG_thongTinVanChuyen.NguoiVanChuyen = ? \n"
//              + "    AND PhieuGiaoHang_ThanhToan.SoTien = ? \n"
//              + "    AND PHIEUGIAOHANG_TrangThai.tenTrangThai = ?;"

   String sql = " {Call ThemPhieuGiaoHang_12345(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        Connection con = DBcontext.getConnection();

      try {
          PreparedStatement pr = con.prepareStatement(sql);
          pr.setObject(1, pgh.getMaPhieu());
          pr.setObject(2, pgh.getNgayGiao());
          pr.setObject(3, pgh.getNguoiNhan());
          pr.setObject(4, pgh.getSdt());
          pr.setObject(5, pgh.getGmail());
          pr.setObject(6, pgh.getTrangThaiThanhToan());
          pr.setObject(7, pgh.getGhiChu());
//            pr.setObject(8, pgh.getDiaChi());
          pr.setObject(8, pgh.getNguoiVanChuyen());
          pr.setObject(9, pgh.getSoTien());
          pr.setObject(10, pgh.getTrangThaiGiaoHang());

          row = pr.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return row;
    }
    public Integer delete(int index, String pgh) {
        Integer row = null;
        String sql = "DELETE PhieuGiaoHang WHERE PhieuGiaoHang.MaPhieu = ?";
        Connection con = DBcontext.getConnection();
        try {
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setString(1, pgh);
            row = pr.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return row;
    }
    
    public List<PhieuGiaoHangModels>getMa(String MA){
  List<PhieuGiaoHangModels> lst = new ArrayList<>();
      try {
//          String sql = "SELECT * FROM PhieuGiaoHang  WHERE MaPhieu like '%"+MA+"%'";
          String sql = "Select PhieuGiaoHang.MaPhieu, NgayGiao, NguoiNhan, Sdt, Email, TrangThaiThanhToan, GhiChu,NguoiVanChuyen,SoTien,tenTrangThai\n"
                 + "From PhieuGiaoHang "
//                  + "join HoaDon on PhieuGiaoHang.MaPhieu=HoaDon.MaPhieu\n"
//                 + "join PHIEUGIAOHANG_DiaDiemGiaoHang on PhieuGiaoHang.MaDiaDiem=PHIEUGIAOHANG_DiaDiemGiaoHang.MaDiaDiem\n"
                 + "join PhieuGiaoHang_ThanhToan on PhieuGiaoHang.MaThanhToan=PhieuGiaoHang_ThanhToan.MaThanhToan\n"
                 + "join PHIEUGIAOHANG_thongTinVanChuyen on PhieuGiaoHang.MaVanChuyen=PHIEUGIAOHANG_thongTinVanChuyen.MaVanChuyen\n"
                 + "join PHIEUGIAOHANG_TrangThai on PHIEUGIAOHANG.MaTrangThai = PHIEUGIAOHANG_TrangThai.MaTrangThai where PhieuGiaoHang.MaPhieu like '%"+MA+"%' ";
  Connection cn = DBcontext.getConnection();
          PreparedStatement ptsm = cn.prepareStatement(sql);
          ResultSet rs = ptsm.executeQuery();
          while (rs.next()) {              
  PhieuGiaoHangModels kh = new PhieuGiaoHangModels();
              kh.setMaPhieu(rs.getString(1));
              kh.setNgayGiao(rs.getDate(2));
              kh.setNguoiNhan(rs.getString(3));
              kh.setSdt(rs.getString(4));
              kh.setGhiChu(rs.getString(7));
              kh.setGmail(rs.getString(5));
              kh.setTrangThaiThanhToan(rs.getString(6));
//              kh.setDiaChi(rs.getString(8));
              kh.setNguoiVanChuyen(rs.getString(8));
              kh.setSoTien(rs.getBigDecimal(9));
              kh.setTrangThaiGiaoHang(rs.getString(10));
//              kh.setMaHoaDon(Integer.parseInt(rs.getString(12)));
              lst.add(kh);
           
          }
      } catch (Exception e) {
          e.printStackTrace();
          
      }
      return lst;
  }
    

      public List<PhieuGiaoHangModels>getThanhToan(String TrangThaiThanhToan){
  List<PhieuGiaoHangModels> lst = new ArrayList<>();
      try {
//          String sql = "SELECT * FROM PhieuGiaoHang  WHERE MaPhieu like '%"+MA+"%'";
          String sql = "Select PhieuGiaoHang.MaPhieu, NgayGiao, NguoiNhan, Sdt, Email, TrangThaiThanhToan, GhiChu,TenTP,NguoiVanChuyen,SoTien,tenTrangThai\n"
                 + "From PhieuGiaoHang "
//                  + "join HoaDon on PhieuGiaoHang.MaPhieu=HoaDon.MaPhieu\n"
                 + "join PHIEUGIAOHANG_DiaDiemGiaoHang on PhieuGiaoHang.MaDiaDiem=PHIEUGIAOHANG_DiaDiemGiaoHang.MaDiaDiem\n"
                 + "join PhieuGiaoHang_ThanhToan on PhieuGiaoHang.MaThanhToan=PhieuGiaoHang_ThanhToan.MaThanhToan\n"
                 + "join PHIEUGIAOHANG_thongTinVanChuyen on PhieuGiaoHang.MaVanChuyen=PHIEUGIAOHANG_thongTinVanChuyen.MaVanChuyen\n"
                 + "join PHIEUGIAOHANG_TrangThai on PHIEUGIAOHANG.MaTrangThai = PHIEUGIAOHANG_TrangThai.MaTrangThai where PhieuGiaoHang.TrangThaiThanhToan like '%"+TrangThaiThanhToan+"%' ";
  Connection cn =DBcontext.getConnection();
          PreparedStatement ptsm = cn.prepareStatement(sql);
          ResultSet rs = ptsm.executeQuery();
          while (rs.next()) {              
  PhieuGiaoHangModels kh = new PhieuGiaoHangModels();
              kh.setMaPhieu(rs.getString(1));
              kh.setNgayGiao(rs.getDate(2));
              kh.setNguoiNhan(rs.getString(3));
              kh.setSdt(rs.getString(4));
              kh.setGhiChu(rs.getString(7));
              kh.setGmail(rs.getString(5));
              kh.setTrangThaiThanhToan(rs.getString(6));
              kh.setDiaChi(rs.getString(8));
              kh.setNguoiVanChuyen(rs.getString(9));
              kh.setSoTien(rs.getBigDecimal(10));
              kh.setTrangThaiGiaoHang(rs.getString(11));
//              kh.setMaHoaDon(Integer.parseInt(rs.getString(12)));
              lst.add(kh);
           
          }
      } catch (Exception e) {
          e.printStackTrace();
          
      }
      return lst;
  }
      
     
   
   

}
