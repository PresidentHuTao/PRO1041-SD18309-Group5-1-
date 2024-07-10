
package Models.PhieuGiaoHang;


public class VanChuyenModels {
    int maVanChuyen;
    String nguoiVanCHuyen,SDTNguoiGiao;

    public VanChuyenModels(int maVanChuyen, String nguoiVanCHuyen, String SDTNguoiGiao) {
        this.maVanChuyen = maVanChuyen;
        this.nguoiVanCHuyen = nguoiVanCHuyen;
        this.SDTNguoiGiao = SDTNguoiGiao;
    }

    public VanChuyenModels() {
    }

    public int getMaVanChuyen() {
        return maVanChuyen;
    }

    public void setMaVanChuyen(int maVanChuyen) {
        this.maVanChuyen = maVanChuyen;
    }

    public String getNguoiVanCHuyen() {
        return nguoiVanCHuyen;
    }

    public void setNguoiVanCHuyen(String nguoiVanCHuyen) {
        this.nguoiVanCHuyen = nguoiVanCHuyen;
    }

    public String getSDTNguoiGiao() {
        return SDTNguoiGiao;
    }

    public void setSDTNguoiGiao(String SDTNguoiGiao) {
        this.SDTNguoiGiao = SDTNguoiGiao;
    }

    @Override
    public String toString() {
        return "VanChuyenModels{" + "maVanChuyen=" + maVanChuyen + ", nguoiVanCHuyen=" + nguoiVanCHuyen + ", SDTNguoiGiao=" + SDTNguoiGiao + '}';
    }
    
}
