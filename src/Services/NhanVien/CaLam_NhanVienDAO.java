/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.NhanVien;

import Models.NhanVien.CaLam_NhanVienModel;
import Utilities.DBcontext;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author LVQ
 */
public class CaLam_NhanVienDAO implements InterFaceNhanVienDAO<CaLam_NhanVienModel, String> {

    @Override
    public boolean Insert(CaLam_NhanVienModel nv) {
        return false;
    }

    @Override
    public boolean Update(CaLam_NhanVienModel e) {
        boolean a = false;
        try {
            Connection cnts=DBcontext.getConnection();
            PreparedStatement pstm=cnts.prepareStatement("update NhanVien set MaCa=? where MaNhanVien like ?");
            pstm.setString(2,e.getMaNV());
            pstm.setInt(1, e.getCaLam());
            if (pstm.executeUpdate()>0) {
                a=true;
            }    
       } catch (Exception ex) {
           ex.printStackTrace();
        }
        return a;
    }

    @Override
    public boolean Delete(CaLam_NhanVienModel nv) {
        boolean a = false;
//        try {
//            Connection cnts = DBcontext.getConnection();
//            PreparedStatement pstm = cnts.prepareCall("delete NHANVIEN_CaLam where MaNhanVien = ?");
//            pstm.setString(1, nv.getMaNV());
//            if (pstm.executeUpdate() > 0) {
//                a = true;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            a = false;
//        }
        return a;
    }

    @Override
    public ArrayList<CaLam_NhanVienModel> selectAll() {
        ArrayList<CaLam_NhanVienModel> ds = new ArrayList<>();
        try {
            Connection cnts = DBcontext.getConnection();
            PreparedStatement pstm = cnts.prepareCall("select MaNhanVien,HoTen,TenCa from NHANVIEN_CaLam join NhanVien on NHANVIEN_CaLam.MaCa=NhanVien.MaCa");
            ResultSet rs = pstm.executeQuery();
            ArrayList<Integer> caca = new ArrayList<>();

            while (rs.next()) {
                ds.add(new CaLam_NhanVienModel(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
            return ds;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public boolean selectByID(String k) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
