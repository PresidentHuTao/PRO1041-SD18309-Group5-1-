/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.DotGiamGia;

/**
 *
 * @author os
 */
public class SanPhamGiamGia {
    private String MaSP;
    private String TenSP;
    private String MaDot;
    private Float TienGiam;
    private Float PTGiam;
    private Float GiaGoc;
    private Float tongtiengiam;
    private Float GiaSauGiam;
    private String TrangThai;

    public SanPhamGiamGia() {
    }

    public SanPhamGiamGia(String MaSP, String TenSP, String MaDot, Float TienGiam, Float PTGiam, Float GiaGoc, Float tongtiengiam, Float GiaSauGiam, String TrangThai) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.MaDot = MaDot;
        this.TienGiam = TienGiam;
        this.PTGiam = PTGiam;
        this.GiaGoc = GiaGoc;
        this.tongtiengiam = tongtiengiam;
        this.GiaSauGiam = GiaSauGiam;
        this.TrangThai = TrangThai;
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

    public String getMaDot() {
        return MaDot;
    }

    public void setMaDot(String MaDot) {
        this.MaDot = MaDot;
    }

    public Float getTienGiam() {
        return TienGiam;
    }

    public void setTienGiam(Float TienGiam) {
        this.TienGiam = TienGiam;
    }

    public Float getPTGiam() {
        return PTGiam;
    }

    public void setPTGiam(Float PTGiam) {
        this.PTGiam = PTGiam;
    }

    public Float getGiaGoc() {
        return GiaGoc;
    }

    public void setGiaGoc(Float GiaGoc) {
        this.GiaGoc = GiaGoc;
    }

    public Float getTongtiengiam() {
        return TienGiam + (PTGiam * GiaGoc / 100);
    }

    public void setTongtiengiam(Float tongtiengiam) {
        this.tongtiengiam = tongtiengiam;
    }

    public Float getGiaSauGiam() {
        return GiaGoc - getTongtiengiam();
    }

    public void setGiaSauGiam(Float GiaSauGiam) {
        this.GiaSauGiam = GiaSauGiam;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    
}