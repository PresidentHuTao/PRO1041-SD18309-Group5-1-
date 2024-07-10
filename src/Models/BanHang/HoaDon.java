/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.BanHang;

import java.math.BigDecimal;

/**
 *
 * @author os
 */
public class HoaDon {
    private int MaHD;
    private int idkhachhang;
    private String manv;
    private BigDecimal giatri;
    private String ngaytao;
    private String maphieugiam;
    private int hinhthucTT;
    private int hinhthucNH;
    private int trangthai;
    private String sdt;
    private String ghichu;

    public HoaDon() {
    }

    public HoaDon(int MaHD, int idkhachhang, String manv, BigDecimal giatri, String ngaytao, String maphieugiam, int hinhthucTT, int hinhthucNH, int trangthai, String sdt, String ghichu) {
        this.MaHD = MaHD;
        this.idkhachhang = idkhachhang;
        this.manv = manv;
        this.giatri = giatri;
        this.ngaytao = ngaytao;
        this.maphieugiam = maphieugiam;
        this.hinhthucTT = hinhthucTT;
        this.hinhthucNH = hinhthucNH;
        this.trangthai = trangthai;
        this.sdt = sdt;
        this.ghichu = ghichu;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public int getIdkhachhang() {
        return idkhachhang;
    }

    public void setIdkhachhang(int idkhachhang) {
        this.idkhachhang = idkhachhang;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public BigDecimal getGiatri() {
        return giatri;
    }

    public void setGiatri(BigDecimal giatri) {
        this.giatri = giatri;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    public String getMaphieugiam() {
        return maphieugiam;
    }

    public void setMaphieugiam(String maphieugiam) {
        this.maphieugiam = maphieugiam;
    }

    public int getHinhthucTT() {
        return hinhthucTT;
    }

    public void setHinhthucTT(int hinhthucTT) {
        this.hinhthucTT = hinhthucTT;
    }

    public int getHinhthucNH() {
        return hinhthucNH;
    }

    public void setHinhthucNH(int hinhthucNH) {
        this.hinhthucNH = hinhthucNH;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

  
    
    
}
