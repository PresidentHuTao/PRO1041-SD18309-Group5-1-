
package Models.PhieuGiaoHang;


public class TrangThaiModels {
    int MaTrangThai;
    String TrangThai;

    public TrangThaiModels() {
    }

    public TrangThaiModels(int MaTrangThai, String TrangThai) {
        this.MaTrangThai = MaTrangThai;
        this.TrangThai = TrangThai;
    }

    public int getMaTrangThai() {
        return MaTrangThai;
    }

    public void setMaTrangThai(int MaTrangThai) {
        this.MaTrangThai = MaTrangThai;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    @Override
    public String toString() {
        return "TrangThaiModels{" + "MaTrangThai=" + MaTrangThai + ", TrangThai=" + TrangThai + '}';
    }
    
}
