/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.ThongKe;

/**
 *
 * @author LVQ
 */
public class ThongKeDoanhThuModel {


    private String MaSP,TenSP;
    private float DoanhThu;
    private int tongsoluongsp;

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public float getDoanhThu() {
        return DoanhThu;
    }

    public void setDoanhThu(float DoanhThu) {
        this.DoanhThu = DoanhThu;
    }

    public ThongKeDoanhThuModel(String MaSP, String TenSP, float DoanhThu, int tongsoluongsp) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.DoanhThu = DoanhThu;
        this.tongsoluongsp = tongsoluongsp;
    }


    public ThongKeDoanhThuModel() {
    }

    public int getTongsoluongsp() {
        return tongsoluongsp;
    }

    public void setTongsoluongsp(int tongsoluongsp) {
        this.tongsoluongsp = tongsoluongsp;
    }
}
