package Services.PhieuGiamGia;

import Models.PhieuGiamGia.phieugiamgiaModel;
import Utilities.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class phieugiamgiaDAO extends DAO<phieugiamgiaModel, String> {

    final String insert = "insert into PhieuGiamGia(MaPhieuGiamGia, MaDieuKien, TrangThai, MaLoaiPhieu, MucGiam, NgayHetHan, MaMucGiam, MaTrangThai) values (?,?,?,?,?,?,?,?)";
    final String delete = "delete from PhieuGiamGia where MaPhieuGiamGia = ?";
    final String update = "update PhieuGiamGia set MaDieuKien = ?, TrangThai = ?, MaLoaiPhieu = ?, MucGiam = ?, NgayHetHan = ?, MaMucGiam = ?, MaTrangThai = ? where MaPhieuGiamGia = ?";
    final String selectAll = "select * from PhieuGiamGia";
    final String selectById = "select * from PhieuGiamGia where MaPhieuGiamGia = ?";

    @Override
    public void insert(phieugiamgiaModel ent) {
        JdbcHelper.update(insert, ent.getMaPhieuGiamGia(), ent.getMaDieuKien(), ent.isTrangThai(), ent.getMaLoaiPhieu(), ent.getMucGiam(), ent.getNgayHetHan(), ent.getMaMucGiam(), ent.getMaTrangThai());
    }

    @Override
    public void update(phieugiamgiaModel ent) {
        JdbcHelper.update(update, ent.getMaDieuKien(), ent.isTrangThai(), ent.getMaLoaiPhieu(), ent.getMucGiam(), ent.getNgayHetHan(), ent.getMaMucGiam(), ent.getMaTrangThai(), ent.getMaPhieuGiamGia());
    }
    
    @Override
    public void delete(String id) {
        JdbcHelper.update(delete, id);
    }

    @Override
    public List<phieugiamgiaModel> selectAll() {
        return selectBySql(selectAll);
    }

    @Override
    public phieugiamgiaModel selectById(String id) {
        List<phieugiamgiaModel> lst = selectBySql(selectById, id);
        if (lst.isEmpty()) {
            return null;
        }
        return lst.get(0);
    }

    @Override
    protected List<phieugiamgiaModel> selectBySql(String sql, Object... args) {
        List<phieugiamgiaModel> lst = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                phieugiamgiaModel ent = new phieugiamgiaModel();
                ent.setMaPhieuGiamGia(rs.getString("MaPhieuGiamGia"));
                ent.setMaDieuKien(rs.getInt("MaDieuKien"));
                ent.setTrangThai(rs.getBoolean("TrangThai"));
                ent.setMaLoaiPhieu(rs.getInt("MaLoaiPhieu"));
                ent.setMucGiam(rs.getFloat("MucGiam"));
                ent.setNgayHetHan(rs.getDate("NgayHetHan"));
                ent.setMaMucGiam(rs.getInt("MaMucGiam"));
                ent.setMaTrangThai(rs.getInt("MaTrangThai"));
                lst.add(ent);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return lst;
    }

}
