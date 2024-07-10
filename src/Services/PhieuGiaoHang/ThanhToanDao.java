
package Services.PhieuGiaoHang;


import Models.PhieuGiaoHang.ThanhToanModels;
import Utilities.DBcontext;
import Utilities.JdbcHelper;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ThanhToanDao {
     public ArrayList<ThanhToanModels> getAllThanhToan() {
        ArrayList<ThanhToanModels> list = new ArrayList<>();
        String sql = "Select * from PHIEUGIAOHANG_ThanhToan";
        try {
            Connection cn = DBcontext.getConnection();
            PreparedStatement ptsm = cn.prepareCall(sql);
            ResultSet rs = ptsm.executeQuery();
            while(rs.next()) {
                ThanhToanModels n = new ThanhToanModels();
                n.setMaThanhToan(rs.getInt("MaThanhToan"));              
                n.setNgayThanhToan(rs.getDate("NgayThanhToan"));
//                n.setSoTien(rs.getFloat("SoTien"));
                
                 String stringValue = rs.getString("SoTien");
                BigDecimal bigDecimalValue = new BigDecimal(stringValue);
                n.setSoTien(bigDecimalValue);
                
                n.setPhuongThuc(rs.getString("PhuongThucThanhToan"));
                n.setTrangThai(rs.getString("TrangThai"));
                list.add(n);
            }
        } catch (Exception e) {
        }
        return list;
    }
     
       public Integer add(ThanhToanModels pgh) {
        Integer row = null;
        String sql = "INSERT INTO PHIEUGIAOHANG_ThanhToan(NgayThanhToan,SoTien,PhuongThucThanhToan,TrangThai) values (?,?,?,?)";
        try {
            Connection cn = DBcontext.getConnection();
            PreparedStatement ptsm = cn.prepareCall(sql);
//            ptsm.setObject(1, pgh.getMaDiaDiem())
            ptsm.setObject(2, pgh.getSoTien());
            ptsm.setObject(1, pgh.getNgayThanhToan());
            ptsm.setObject(3, pgh.getPhuongThuc());
            ptsm.setObject(4, pgh.getTrangThai());
           
          row = ptsm.executeUpdate();            
        } catch (Exception e) {
        }
        return row;
    }
      
      public Integer update(ThanhToanModels pgh) {
          Integer row = null;
        String sql = "UPDATE PHIEUGIAOHANG_ThanhToan SET NgayThanhToan=?,SoTien=?,PhuongThucThanhToan=?,TrangThai=? WHERE MaThanhToan = ?";
        Connection con = DBcontext.getConnection();

        try {
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setObject(5, pgh.getMaThanhToan());
            pr.setObject(1, pgh.getNgayThanhToan());
            pr.setObject(2, pgh.getSoTien());
            pr.setObject(3, pgh.getPhuongThuc());
            pr.setObject(4, pgh.getTrangThai());
            row = pr.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return row;
    }
      
       public Integer delete(int index, String pgh) {
          Integer row = null;
        String sql = "DELETE PhieuGiaoHang_ThanhToan WHERE MaThanhToan = ?";
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
}
