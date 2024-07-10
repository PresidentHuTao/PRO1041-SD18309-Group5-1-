/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.BanHang;
import Models.SanPham.*;
import java.math.BigDecimal;
/**
 *
 * @author os
 */
public class SanPhamBan {
    private String MaSP;
    private String TenSP;
    private BigDecimal GiamGia;
    private BigDecimal gia;
    private int soLuong;

    public SanPhamBan() {
    }

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

    public BigDecimal getGiamGia() {
        return GiamGia;
    }

    public void setGiamGia(BigDecimal GiamGia) {
        this.GiamGia = GiamGia;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

   
    

  
    
}
