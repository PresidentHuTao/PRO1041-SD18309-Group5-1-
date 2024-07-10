/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.ThongKe;

/**
 *
 * @author LVQ
 */
public class ThongKeNhanVienModel {
    private String MaNV,HoTen;
    private double soluonghoadon,tongdoanhthu;

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

    public double getSoluonghoadon() {
        return soluonghoadon;
    }

    public void setSoluonghoadon(double soluonghoadon) {
        this.soluonghoadon = soluonghoadon;
    }
    public double getTongdoanhthu() {
        return tongdoanhthu;
    }

    public void setTongdoanhthu(double tongdoanhthu) {
        this.tongdoanhthu = tongdoanhthu;
    }

    public ThongKeNhanVienModel(String MaNV, String HoTen, double soluonghoadon, double tongdoanhthu) {
        this.MaNV = MaNV;
        this.HoTen = HoTen;
        this.soluonghoadon = soluonghoadon;
        this.tongdoanhthu = tongdoanhthu;
    }

    public ThongKeNhanVienModel() {
    }
}
