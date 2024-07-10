package Models.PhieuGiamGia;

 public class dieukienModel {
    private int maDieuKien;
    private String tenDieuKien;

    public dieukienModel(int maDieuKien, String tenDieuKien) {
        this.maDieuKien = maDieuKien;
        this.tenDieuKien = tenDieuKien;
    }

    public dieukienModel() {
    }

    public int getMaDieuKien() {
        return maDieuKien;
    }

    public void setMaDieuKien(int maDieuKien) {
        this.maDieuKien = maDieuKien;
    }

    public String getTenDieuKien() {
        return tenDieuKien;
    }

    public void setTenDieuKien(String tenDieuKien) {
        this.tenDieuKien = tenDieuKien;
    }
}
