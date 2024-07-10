/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models.KhachHang;

/**
 *
 * @author VU ANH TAI
 */
public class TichDiemKH {
    private String tenKH;
    private int tongDiem;
    private int diemDaDung;
    private int diemConLai;
    private boolean hangKhach;

    public TichDiemKH() {
    }

    public TichDiemKH(String tenKH, int tongDiem, int diemDaDung, int diemConLai, boolean hangKhach) {
        this.tenKH = tenKH;
        this.tongDiem = tongDiem;
        this.diemDaDung = diemDaDung;
        this.diemConLai = diemConLai;
        this.hangKhach = hangKhach;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public int getTongDiem() {
        return tongDiem;
    }

    public void setTongDiem(int tongDiem) {
        this.tongDiem = tongDiem;
    }

    public int getDiemDaDung() {
        return diemDaDung;
    }

    public void setDiemDaDung(int diemDaDung) {
        this.diemDaDung = diemDaDung;
    }

    public int getDiemConLai() {
        return diemConLai;
    }

    public void setDiemConLai(int diemConLai) {
        this.diemConLai = diemConLai;
    }

    public boolean isHangKhach() {
        return hangKhach;
    }

    public void setHangKhach(boolean hangKhach) {
        this.hangKhach = hangKhach;
    }
    
    
}
