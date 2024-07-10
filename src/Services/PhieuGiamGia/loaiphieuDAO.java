package Services.PhieuGiamGia;

import Models.PhieuGiamGia.loaiphieuModel;
import Utilities.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class loaiphieuDAO extends DAO<loaiphieuModel, String> {

    final String identity_insert = "set identity_insert PhieuGiamGia_LoaiPhieu on insert into PhieuGiamGia_LoaiPhieu (MaLoaiPhieu, TenLoaiPhieu) values (?, ?)";
    final String update = "update PhieuGiamGia_LoaiPhieu set TenLoaiPhieu = ? where MaLoaiPhieu = ?";
    final String selectAll = "select * from PhieuGiamGia_LoaiPhieu";
    final String selectById = "select * from PhieuGiamGia_LoaiPhieu where MaLoaiPhieu = ?";

    @Override
    public void insert(loaiphieuModel ent) {
        JdbcHelper.update(identity_insert, ent.getMaLoaiPhieu(), ent.getTenLoaiPhieu());
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(loaiphieuModel ent) {
        JdbcHelper.update(update, ent.getTenLoaiPhieu(), ent.getMaLoaiPhieu());
    }

    @Override
    public List<loaiphieuModel> selectAll() {
        return selectBySql(selectAll);
    }

    @Override
    public loaiphieuModel selectById(String id) {
        List<loaiphieuModel> lst = selectBySql(selectById, id);
        if (lst.isEmpty()) {
            return null;
        }
        return lst.get(0);
    }

    public loaiphieuModel selectById_int(int id) {
        List<loaiphieuModel> lst = selectBySql(selectById, id);
        if (lst.isEmpty()) {
            return null;
        }
        return lst.get(0);
    }

    @Override
    protected List<loaiphieuModel> selectBySql(String sql, Object... args) {
        List<loaiphieuModel> lst = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                loaiphieuModel ent = new loaiphieuModel();
                ent.setMaLoaiPhieu(rs.getInt("MaLoaiPhieu"));
                ent.setTenLoaiPhieu(rs.getString("TenLoaiPhieu"));
                lst.add(ent);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return lst;
    }

}
