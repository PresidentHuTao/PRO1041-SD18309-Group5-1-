/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.KhachHang;

import Utilities.DBcontext;
import java.util.ArrayList;
import Models.KhachHang.KhachHang;
import java.sql.*;

/**
 *
 * @author VU ANH TAI
 */
public class KhachHangDAO implements NewInterface {

    @Override
    public ArrayList<KhachHang> getAllKhachHang() {
        ArrayList<KhachHang> lst = new ArrayList<>();
        String sql = "select * from KhachHang";
        Connection cn = DBcontext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getInt("IDKhachHang"), rs.getString("TenKhachHang"),
                        rs.getBoolean("GioiTinh"), rs.getString("SDT"),
                        rs.getString("Email"), rs.getString("diaChi"), rs.getBoolean("hangKhach"));
                lst.add(kh);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return lst;
    }
///////tesst page
//    public ArrayList<KhachHang> selectAll(int page) {
//         String sql = """
//                SELECT IDKhachHang,TenKhachHang,GioiTinh,SDT,Email,diaChi,hangKhach
//                				FROM KhachHang
//                                ORDER BY IDKhachHang
//                                OFFSET (? - 1) * 5 ROWS
//                                FETCH NEXT 5 ROWS ONLY;
//                """;
//          ArrayList<KhachHang> lst = new ArrayList<>();
//        try {
//            Connection cn  = DBcontext.getConnection();
//            PreparedStatement pstm = cn.prepareStatement(sql); 
//            pstm.setObject(1, page );
//            ResultSet rs = pstm.executeQuery();
//            while(rs.next()){
//              KhachHang kh = new KhachHang(rs.getInt("IDKhachHang"), rs.getString("TenKhachHang"),
//                        rs.getBoolean("GioiTinh"), rs.getString("SDT"),
//                        rs.getString("Email"), rs.getString("diaChi"), rs.getBoolean("hangKhach"));
//                lst.add(kh);
//            }
//            return lst;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
    public ArrayList<KhachHang> getAllKhachHangNam() {
        ArrayList<KhachHang> lst = new ArrayList<>();
        String sql = "select IDKhachHang,TenKhachHang,GioiTinh,SDT,Email,diaChi,hangKhach\n"
                + "from KhachHang\n"
                + "where GioiTinh ='1'";
        Connection cn = DBcontext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getInt("IDKhachHang"), rs.getString("TenKhachHang"),
                        rs.getBoolean("GioiTinh"), rs.getString("SDT"),
                        rs.getString("Email"), rs.getString("diaChi"), rs.getBoolean("hangKhach"));
                lst.add(kh);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lst;
    }

    public ArrayList<KhachHang> getAllKhachHangNu() {
        ArrayList<KhachHang> lst = new ArrayList<>();
        String sql = "select IDKhachHang,TenKhachHang,GioiTinh,SDT,Email,diaChi,hangKhach\n"
                + "from KhachHang\n"
                + "where GioiTinh ='0'";
        Connection cn = DBcontext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getInt("IDKhachHang"), rs.getString("TenKhachHang"),
                        rs.getBoolean("GioiTinh"), rs.getString("SDT"),
                        rs.getString("Email"), rs.getString("diaChi"), rs.getBoolean("hangKhach"));
                lst.add(kh);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lst;
    }

    public ArrayList<KhachHang> getAllHangKhachLaunam() {
        ArrayList<KhachHang> lst = new ArrayList<>();
        String sql = "select IDKhachHang,TenKhachHang,GioiTinh,SDT,Email,diaChi,hangKhach\n"
                + "from KhachHang\n"
                + "where hangKhach ='1'";
        Connection cn = DBcontext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getInt("IDKhachHang"), rs.getString("TenKhachHang"),
                        rs.getBoolean("GioiTinh"), rs.getString("SDT"),
                        rs.getString("Email"), rs.getString("diaChi"), rs.getBoolean("hangKhach"));
                lst.add(kh);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lst;
    }

     public ArrayList<KhachHang> getAllHangKhachMoi() {
        ArrayList<KhachHang> lst = new ArrayList<>();
        String sql = "select IDKhachHang,TenKhachHang,GioiTinh,SDT,Email,diaChi,hangKhach\n"
                + "from KhachHang\n"
                + "where hangKhach ='0'";
        Connection cn = DBcontext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getInt("IDKhachHang"), rs.getString("TenKhachHang"),
                        rs.getBoolean("GioiTinh"), rs.getString("SDT"),
                        rs.getString("Email"), rs.getString("diaChi"), rs.getBoolean("hangKhach"));
                lst.add(kh);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lst;
    }
    @Override
    public Integer insert(KhachHang kh) {
        Integer row = null;
        String sql = "insert into KhachHang(TenKhachHang,GioiTinh,SDT,Email,DiaChi,hangKhach)\n"
                + "values(?,?,?,?,?,?)";
        Connection cn = DBcontext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, kh.getTenKhachHang());
            pstm.setBoolean(2, kh.isGioiTinh());
            pstm.setString(3, kh.getSdt());
            pstm.setString(4, kh.getEmail());
            pstm.setString(5, kh.getDiaChi());
            pstm.setBoolean(6, kh.isHangKhach());
            row = pstm.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }

    @Override
    public Integer update(KhachHang kh) {
        Integer row = null;
        String sql = "update KhachHang\n"
                + "set TenKhachHang =?,GioiTinh=?,SDT=?,Email=?,diaChi=?,hangKhach=?\n"
                + "where IDKhachHang =?";
        Connection cn = DBcontext.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);

            pstm.setString(1, kh.getTenKhachHang());
            pstm.setBoolean(2, kh.isGioiTinh());
            pstm.setString(3, kh.getSdt());
            pstm.setString(4, kh.getEmail());
            pstm.setString(5, kh.getDiaChi());
            pstm.setBoolean(6, kh.isHangKhach());
            pstm.setInt(7, kh.getMaKhachHang());
            row = pstm.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }

    @Override
    public int find(int id) {
        int a = -1;
        for (int i = 0; i < getAllKhachHang().size(); i++) {
            if(getAllKhachHang().get(i).getMaKhachHang()==id){
                a= i;
                break;
            }
        }
        return a;
    }
     public int getMaxMaKhachHang() {
        int maxMaKhachHang = -1;
        String sql = "SELECT MAX(IDKhachHang) AS MaxMaKhachHang FROM KhachHang";
        Connection cn = DBcontext.getConnection();

        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                maxMaKhachHang = rs.getInt("MaxMaKhachHang");
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

        return maxMaKhachHang;
    }

public int findKHbangsdt(String phoneNumber) {
    int maKhachHang = -1;
    String sql = "SELECT IDKhachHang FROM KhachHang WHERE SDT = ?";
    Connection cn = DBcontext.getConnection();

    try {
        PreparedStatement pstm = cn.prepareStatement(sql);
        pstm.setString(1, phoneNumber);
        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            maKhachHang = rs.getInt("IDKhachHang");
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

    return maKhachHang;
}

}
