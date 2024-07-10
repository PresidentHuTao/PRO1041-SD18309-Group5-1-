package Models.PhieuGiamGia;

public class mucgiamModel {
    private int maMucGiam;
    private float tyLeGiam;

    public mucgiamModel() {
    }

    public mucgiamModel(int maMucGiam, float tyLeGiam) {
        this.maMucGiam = maMucGiam;
        this.tyLeGiam = tyLeGiam;
    }

    public int getMaMucGiam() {
        return maMucGiam;
    }

    public void setMaMucGiam(int maMucGiam) {
        this.maMucGiam = maMucGiam;
    }

    public float getTyLeGiam() {
        return tyLeGiam;
    }

    public void setTyLeGiam(float tyLeGiam) {
        this.tyLeGiam = tyLeGiam;
    }
    
}
