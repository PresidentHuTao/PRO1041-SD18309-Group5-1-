
package Models.PhieuGiaoHang;

import java.math.BigDecimal;
import java.util.Date;


public class PhieuGiaoHangModels {
    private String maPhieu;
    private Date ngayGiao; 
//    private Float soTien;
    private int MaHoaDon;
    private BigDecimal SoTien;
    private String NguoiNhan,Sdt,Gmail,TrangThaiThanhToan,GhiChu,DiaChi,NguoiVanChuyen,TrangThaiGiaoHang;

    public PhieuGiaoHangModels() {
    }

    public BigDecimal getSoTien() {
        return SoTien;
    }

    public PhieuGiaoHangModels(int MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public Integer getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(int MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }
    

    public void setSoTien(BigDecimal SoTien) {
        this.SoTien = SoTien;
    }

    public PhieuGiaoHangModels(BigDecimal SoTien) {
        this.SoTien = SoTien;
    }

    public PhieuGiaoHangModels(String maPhieu, Date ngayGiao, String NguoiNhan, String Sdt, String Gmail, String TrangThaiThanhToan, String GhiChu, String DiaChi, String NguoiVanChuyen, String TrangThaiGiaoHang) {
        this.maPhieu = maPhieu;
        this.ngayGiao = ngayGiao;
//        this.soTien = soTien;
        this.NguoiNhan = NguoiNhan;
        this.Sdt = Sdt;
        this.Gmail = Gmail;
        this.TrangThaiThanhToan = TrangThaiThanhToan;
        this.GhiChu = GhiChu;
        this.DiaChi = DiaChi;
        this.NguoiVanChuyen = NguoiVanChuyen;
        this.TrangThaiGiaoHang = TrangThaiGiaoHang;
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public Date getNgayGiao() {
        return ngayGiao;
    }

    public void setNgayGiao(Date ngayGiao) {
        this.ngayGiao = ngayGiao;
    }

//    public Float getSoTien() {
//        return soTien;
//    }
//
//    public void setSoTien(Float soTien) {
//        this.soTien = soTien;
//    }

    public String getNguoiNhan() {
        return NguoiNhan;
    }

    public void setNguoiNhan(String NguoiNhan) {
        this.NguoiNhan = NguoiNhan;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public String getGmail() {
        return Gmail;
    }

    public void setGmail(String Gmail) {
        this.Gmail = Gmail;
    }

    public String getTrangThaiThanhToan() {
        return TrangThaiThanhToan;
    }

    public void setTrangThaiThanhToan(String TrangThaiThanhToan) {
        this.TrangThaiThanhToan = TrangThaiThanhToan;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getNguoiVanChuyen() {
        return NguoiVanChuyen;
    }

    public void setNguoiVanChuyen(String NguoiVanChuyen) {
        this.NguoiVanChuyen = NguoiVanChuyen;
    }

    public String getTrangThaiGiaoHang() {
        return TrangThaiGiaoHang;
    }

    public void setTrangThaiGiaoHang(String TrangThaiGiaoHang) {
        this.TrangThaiGiaoHang = TrangThaiGiaoHang;
    }

    @Override
    public String toString() {
        return "PhieuGiaoHangModels{" + "maPhieu=" + maPhieu + ", ngayGiao=" + ngayGiao + ", MaHoaDon=" + MaHoaDon + ", SoTien=" + SoTien + ", NguoiNhan=" + NguoiNhan + ", Sdt=" + Sdt + ", Gmail=" + Gmail + ", TrangThaiThanhToan=" + TrangThaiThanhToan + ", GhiChu=" + GhiChu + ", DiaChi=" + DiaChi + ", NguoiVanChuyen=" + NguoiVanChuyen + ", TrangThaiGiaoHang=" + TrangThaiGiaoHang + '}';
    }


 

    
    
    

   
}
