/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.DotGiamGia;
import Services.*;
import Utilities.DBcontext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author os
 */
//class này để truyền dữ liệu vào lựa chọn của view
public class ViewDotGiamGiaServices {
    Connection con = DBcontext.getConnection();
    public List getAll(){
        List rdo = new ArrayList();
        try {
            String sql = "select TenLoai from DOTGIAMGIA_LoaiGiamGia";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {      
                String maloai = rs.getString(1);
                rdo.add(maloai);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return rdo;
    }
}
