/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.PhieuGiaoHang;


import Models.PhieuGiaoHang.TrangThaiModels;
import Utilities.DBcontext;
import Utilities.JdbcHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class TrangThaiDao {
     public ArrayList<TrangThaiModels> getAllTramgThai() {
        ArrayList<TrangThaiModels> list = new ArrayList<>();
        String sql = "Select * from PHIEUGIAOHANG_TrangThai";
        try {
            Connection cn = DBcontext.getConnection();
            PreparedStatement ptsm = cn.prepareCall(sql);
            ResultSet rs = ptsm.executeQuery();
            while(rs.next()) {
                TrangThaiModels n = new TrangThaiModels();
                n.setMaTrangThai(rs.getInt("MaTrangThai"));              
                n.setTrangThai(rs.getString("tenTrangThai"));
              list.add(n);
            }
        } catch (Exception e) {
            
        }
        return list;
    }
        public Integer add(TrangThaiModels pgh) {
        Integer row = null;
        String sql = "INSERT INTO PHIEUGIAOHANG_TrangThai(tenTrangThai) values (?)";
        try {
            Connection cn = DBcontext.getConnection();
            PreparedStatement ptsm = cn.prepareCall(sql);
//            ptsm.setObject(1, pgh.getMaDiaDiem());
            ptsm.setObject(1, pgh.getTrangThai());
          row = ptsm.executeUpdate();            
        } catch (Exception e) {
        }
        return row;
    }
      
      public Integer update(TrangThaiModels pgh) {
          Integer row = null;
        String sql = "UPDATE PHIEUGIAOHANG_TrangThai SET tenTrangThai=? WHERE MaTrangThai = ?";
        Connection con = DBcontext.getConnection();

        try {
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setObject(1, pgh.getTrangThai());
            pr.setObject(2, pgh.getMaTrangThai());
            row = pr.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return row;
    }
      
       public Integer delete(int index, String pgh) {
          Integer row = null;
        String sql = "DELETE PHIEUGIAOHANG_TrangThai WHERE MaTrangThai = ?";
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

