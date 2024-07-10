package Models.DotGiamGia;

public class DotGiamGia {
    private String MaDot;
    private int TenLoai;
    private Float PhanTramGiam;
    private Float TienGiam;
    private String NgayBatDau;
    private String NgayKetThuc;
    private int TrangThai;
    private int maSP;

    public DotGiamGia() {
    }

    public DotGiamGia(String MaDot, int TenLoai, Float PhanTramGiam, Float TienGiam, String NgayBatDau, String NgayKetThuc, int TrangThai, int maSP) {
        this.MaDot = MaDot;
        this.TenLoai = TenLoai;
        this.PhanTramGiam = PhanTramGiam;
        this.TienGiam = TienGiam;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.TrangThai = TrangThai;
        this.maSP = maSP;
    }

    public String getMaDot() {
        return MaDot;
    }

    public void setMaDot(String MaDot) {
        this.MaDot = MaDot;
    }

    public int getTenLoai() {
        return TenLoai;
    }

    public void setTenLoai(int TenLoai) {
        this.TenLoai = TenLoai;
    }

    public Float getPhanTramGiam() {
        return PhanTramGiam;
    }

    public void setPhanTramGiam(Float PhanTramGiam) {
        this.PhanTramGiam = PhanTramGiam;
    }

    public Float getTienGiam() {
        return TienGiam;
    }

    public void setTienGiam(Float TienGiam) {
        this.TienGiam = TienGiam;
    }

    public String getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(String NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public String getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(String NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }
}
