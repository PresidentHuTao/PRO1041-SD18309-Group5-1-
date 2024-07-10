package Models.PhieuGiamGia;

import java.util.Date;

public class phieugiamgiaModel {
   private String maPhieuGiamGia;
   private int maDieuKien;
   private boolean trangThai;
   private int maLoaiPhieu;
   private float mucGiam;
   private Date ngayHetHan;
   private int maMucGiam;
   private int maTrangThai;

    public phieugiamgiaModel() {
    }

    public phieugiamgiaModel(String maPhieuGiamGia, int maDieuKien, boolean trangThai, int maLoaiPhieu, float mucGiam, Date ngayHetHan, int maMucGiam, int maTrangThai) {
        this.maPhieuGiamGia = maPhieuGiamGia;
        this.maDieuKien = maDieuKien;
        this.trangThai = trangThai;
        this.maLoaiPhieu = maLoaiPhieu;
        this.mucGiam = mucGiam;
        this.ngayHetHan = ngayHetHan;
        this.maMucGiam = maMucGiam;
        this.maTrangThai = maTrangThai;
    }

    public String getMaPhieuGiamGia() {
        return maPhieuGiamGia;
    }

    public void setMaPhieuGiamGia(String maPhieuGiamGia) {
        this.maPhieuGiamGia = maPhieuGiamGia;
    }

    public int getMaDieuKien() {
        return maDieuKien;
    }

    public void setMaDieuKien(int maDieuKien) {
        this.maDieuKien = maDieuKien;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public int getMaLoaiPhieu() {
        return maLoaiPhieu;
    }

    public void setMaLoaiPhieu(int maLoaiPhieu) {
        this.maLoaiPhieu = maLoaiPhieu;
    }

    public float getMucGiam() {
        return mucGiam;
    }

    public void setMucGiam(float mucGiam) {
        this.mucGiam = mucGiam;
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        this.ngayHetHan = ngayHetHan;
    }

    public int getMaMucGiam() {
        return maMucGiam;
    }

    public void setMaMucGiam(int maMucGiam) {
        this.maMucGiam = maMucGiam;
    }

    public int getMaTrangThai() {
        return maTrangThai;
    }

    public void setMaTrangThai(int maTrangThai) {
        this.maTrangThai = maTrangThai;
    }
}
