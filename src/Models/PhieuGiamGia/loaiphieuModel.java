package Models.PhieuGiamGia;

public class loaiphieuModel {
    private int maLoaiPhieu;
    private String tenLoaiPhieu;

    public loaiphieuModel(int maLoaiPhieu, String tenLoaiPhieu) {
        this.maLoaiPhieu = maLoaiPhieu;
        this.tenLoaiPhieu = tenLoaiPhieu;
    }

    public loaiphieuModel() {
    }

    public int getMaLoaiPhieu() {
        return maLoaiPhieu;
    }

    public void setMaLoaiPhieu(int maLoaiPhieu) {
        this.maLoaiPhieu = maLoaiPhieu;
    }

    public String getTenLoaiPhieu() {
        return tenLoaiPhieu;
    }

    public void setTenLoaiPhieu(String tenLoaiPhieu) {
        this.tenLoaiPhieu = tenLoaiPhieu;
    }
}
