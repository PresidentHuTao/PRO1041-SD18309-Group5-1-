/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.NhanVien;

import Models.NhanVien.Luong_NhanVienModel;
import Models.NhanVien.Luong_NhanVienModel;
import Utilities.DBcontext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author LVQ
 */
public class Luong_NhanVienDAO implements InterFaceNhanVienDAO<Luong_NhanVienModel,String>{

    @Override
    public boolean Insert(Luong_NhanVienModel nv) {
        boolean a=false;
         try {
            Connection cnts=DBcontext.getConnection();
            PreparedStatement pstm=cnts.prepareCall("insert into NHANVIEN_Luong(LuongCoban,LuongTangCa,ThueKhauTru) values (?,?,?)");
            pstm.setFloat(1,nv.getLuongCoBan());
            pstm.setFloat(2,nv.getLuongTangCa());
            pstm.setFloat(3,nv.getThueKhauTru());
             if (pstm.executeUpdate()>0) {
                 a=true;
             }
        } catch (Exception e) {
            e.printStackTrace();
            a=false;
        } return a;}

    @Override
    public boolean Update(Luong_NhanVienModel nv) {
        boolean a=false;
         try {
            Connection cnts=DBcontext.getConnection();
            PreparedStatement pstm=cnts.prepareCall("update NHANVIEN_Luong set LuongCoban=?,LuongTangCa=?,ThueKhauTru=? where MaLuong in (select MaLuong from NhanVien where MaNhanVien like ?)");
            pstm.setString(4,nv.getMaNV());
            pstm.setFloat(1,nv.getLuongCoBan());
            pstm.setFloat(2,nv.getLuongTangCa());
            pstm.setFloat(3,nv.getThueKhauTru());
             if (pstm.executeUpdate()>0) {
                 a=true;
             }
        } catch (Exception e) {
            e.printStackTrace();
            a=false;
        } return a;}

    @Override
    public boolean Delete(Luong_NhanVienModel nv) {
    
        return false;
    
}
    public boolean DeleteMl(int ml){
     boolean a=false;
         try {
            Connection cnts=DBcontext.getConnection();
            PreparedStatement pstm=cnts.prepareCall("delete NHANVIEN_Luong where MaLuong like ?");
            pstm.setInt(1,ml);
             if (pstm.executeUpdate()>0) {
                 a=true;
             }
        } catch (Exception e) {
            e.printStackTrace();
            a=false;
        
    }   return a;
    }

    @Override
    public ArrayList<Luong_NhanVienModel> selectAll() {
    ArrayList<Luong_NhanVienModel>dslnv=new ArrayList<>();
    dslnv.removeAll(dslnv);
        try {
            Connection cnts =DBcontext.getConnection();
            PreparedStatement pstm=cnts.prepareCall("select NhanVien.MaNhanVien,NhanVien.HoTen,LuongCoban,LuongTangCa,ThueKhauTru from NhanVien join NHANVIEN_Luong on NhanVien.MaLuong=NHANVIEN_Luong.MaLuong");
            ResultSet rs=pstm.executeQuery();
            while (rs.next()) { 
                Luong_NhanVienModel lnv=new Luong_NhanVienModel(rs.getString(1),rs.getString(2),rs.getFloat(3),rs.getFloat(4),rs.getFloat(5));
                dslnv.add(lnv);
            }
            return dslnv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    
    }

    @Override
    public boolean selectByID(String k) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public int LayMaLuongMoiNhat(){
        int a=0;
        try {
            Connection cn=DBcontext.getConnection();
            PreparedStatement pstm=cn.prepareStatement("SELECT MAX(MaLuong) AS MaLuongMoi\n" +
"FROM NHANVIEN_Luong");
            ResultSet rs=pstm.executeQuery();
            while (rs.next()) {                
                a=rs.getInt("MaLuongMoi");
            }
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int LayMaLuongTheoNV(String mnv){
    int a=0;
        try {
            Connection cn=DBcontext.getConnection();
            PreparedStatement pstm=cn.prepareStatement("select MaLuong from NHANVIEN_Luong where MaLuong in(select MaLuong from NhanVien where MaNhanVien like ?)");
            pstm.setString(1, mnv);
            ResultSet rs=pstm.executeQuery();
            while (rs.next()) {                
                a=rs.getInt(1);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return a;
    }
}
