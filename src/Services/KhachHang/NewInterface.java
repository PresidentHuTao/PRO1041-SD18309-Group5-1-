/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services.KhachHang;

import java.util.ArrayList;
import Models.KhachHang.KhachHang;

/**
 *
 * @author VU ANH TAI
 */
public interface NewInterface {
    public ArrayList<KhachHang> getAllKhachHang();
    public Integer insert(KhachHang kh);
    public Integer update(KhachHang kh);
    public int find(int id);
}
