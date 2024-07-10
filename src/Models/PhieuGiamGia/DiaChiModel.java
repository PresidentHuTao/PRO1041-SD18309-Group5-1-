
package Models.PhieuGiamGia;


public class DiaChiModel {
    private String Duong,TenQh,TenTP;
    private int MaDiaDiem;
//    private String tenKH;

//    public String getTenKH() {
//        return tenKH;
//    }
//
//    public void setTenKH(String tenKH) {
//        this.tenKH = tenKH;
//    }
//
//    public DiaChiModel(String tenKH) {
//        this.tenKH = tenKH;
//    }

    public DiaChiModel(int MaDiaDiem) {
        this.MaDiaDiem = MaDiaDiem;
    }

    public DiaChiModel() {
    }

    public DiaChiModel(String Duong, String TenQh, String TenTP) {
        this.Duong = Duong;
        this.TenQh = TenQh;
        this.TenTP = TenTP;
    }

    public String getDuong() {
        return Duong;
    }

    public void setDuong(String Duong) {
        this.Duong = Duong;
    }

    public String getTenQh() {
        return TenQh;
    }

    public void setTenQh(String TenQh) {
        this.TenQh = TenQh;
    }

    public String getTenTP() {
        return TenTP;
    }

    public void setTenTP(String TenTP) {
        this.TenTP = TenTP;
    }

    public int getMaDiaDiem() {
        return MaDiaDiem;
    }

    public void setMaDiaDiem(int MaDiaDiem) {
        this.MaDiaDiem = MaDiaDiem;
    }

    @Override
    public String toString() {
        return "DiaChiModel{" + "Duong=" + Duong + ", TenQh=" + TenQh + ", TenTP=" + TenTP + ", MaDiaDiem=" + MaDiaDiem + '}';
    }



    
}
