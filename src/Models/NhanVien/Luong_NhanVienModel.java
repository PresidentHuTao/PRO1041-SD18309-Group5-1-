/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.NhanVien;

/**
 *
 * @author LVQ
 */
public class Luong_NhanVienModel {
    
    private String MaNV,HoTen;
private float luongCoBan,LuongTangCa,ThueKhauTru;
private int maLuong;
    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public float getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(float luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public float getLuongTangCa() {
        return LuongTangCa;
    }

    public void setLuongTangCa(float LuongTangCa) {
        this.LuongTangCa = LuongTangCa;
    }

    public float getThueKhauTru() {
        return ThueKhauTru;
    }

    public void setThueKhauTru(float ThueKhauTru) {
        this.ThueKhauTru = ThueKhauTru;
    }

    public Luong_NhanVienModel() {
    }

    public Luong_NhanVienModel(String MaNV, String HoTen, float luongCoBan, float LuongTangCa, float ThueKhauTru) {
        this.MaNV = MaNV;
        this.HoTen = HoTen;
        this.luongCoBan = luongCoBan;
        this.LuongTangCa = LuongTangCa;
        this.ThueKhauTru = ThueKhauTru;
    }
    
}
