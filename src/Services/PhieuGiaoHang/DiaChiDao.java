
package Services.PhieuGiaoHang;


import Models.PhieuGiaoHang.DiaChiModel;
import Utilities.DBcontext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DiaChiDao {
     public ArrayList<DiaChiModel> getAllDiaDiem() {
        ArrayList<DiaChiModel> list = new ArrayList<>();
        String sql = "select * from PHIEUGIAOHANG_DiaDiemGiaoHang ";
        try {
            Connection cn = DBcontext.getConnection();
            PreparedStatement ptsm = cn.prepareCall(sql);
            ResultSet rs = ptsm.executeQuery();
            while(rs.next()) {
                DiaChiModel n = new DiaChiModel();
//                n.setTenKH(rs.getString("NguoiNhan"));
                n.setMaDiaDiem(rs.getInt("MaDiaDiem"));            
                n.setTenTP(rs.getString("TenTP"));
                n.setDuong(rs.getString("Duong"));
                n.setTenQh(rs.getString("TenQH"));
                list.add(n);
            }
        } catch (Exception e) {
        }
        return list;
    }
     
      public Integer add(DiaChiModel pgh) {
        Integer row = null;
        String sql = "INSERT INTO PHIEUGIAOHANG_DiaDiemGiaoHang(Duong,TenQH,TenTP) values (?,?,?)";
        try {
            Connection cn = DBcontext.getConnection();
            PreparedStatement ptsm = cn.prepareCall(sql);
//            ptsm.setObject(1, pgh.getMaDiaDiem());
            ptsm.setObject(1, pgh.getDuong());
            ptsm.setObject(3, pgh.getTenTP());
            ptsm.setObject(2, pgh.getTenQh());
           
          row = ptsm.executeUpdate();            
        } catch (Exception e) {
        }
        return row;
    }
      
      public Integer update(DiaChiModel pgh) {
          Integer row = null;
        String sql = "UPDATE PHIEUGIAOHANG_DiaDiemGiaoHang SET Duong=?,TenQH=?,TenTP=? WHERE MaDiaDiem = ?";
        Connection con = DBcontext.getConnection();

        try {
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setObject(1, pgh.getDuong());
            pr.setObject(2, pgh.getTenQh());
            pr.setObject(3, pgh.getTenTP());
            pr.setObject(4, pgh.getMaDiaDiem());
            row = pr.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return row;
    }
      
       public Integer delete(int index, String pgh) {
          Integer row = null;
        String sql = "DELETE PHIEUGIAOHANG_DiaDiemGiaoHang WHERE MaDiaDiem = ?";
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
