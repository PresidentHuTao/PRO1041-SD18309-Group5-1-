package Services.PhieuGiamGia;

import Models.PhieuGiamGia.trangthaiModel;
import Utilities.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class trangthaiDAO extends DAO<trangthaiModel, String> {

    final String identity_insert = "set identity_insert PhieuGiamGia_TrangThai on insert into PhieuGiamGia_TrangThai (MaTrangThai, TenTrangThai) values (?, ?)";
    final String update = "update PhieuGiamGia_TrangThai set TenTrangThai = ? where MaTrangThai = ?";
    final String selectAll = "select * from PhieuGiamGia_TrangThai";
    final String selectById = "select * from PhieuGiamGia_TrangThai where MaTrangThai = ?";

    public trangthaiModel selectById_int(int id) {
        List<trangthaiModel> lst = selectBySql(selectById, id);
        if (lst.isEmpty()) {
            return null;
        }
        return lst.get(0);
    }

    @Override
    public void insert(trangthaiModel ent) {
        JdbcHelper.update(identity_insert, ent.getMaTrangThai(), ent.getTenTrangThai());
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(trangthaiModel ent) {
        JdbcHelper.update(update, ent.getTenTrangThai(), ent.getMaTrangThai());
    }

    @Override
    public List<trangthaiModel> selectAll() {
        return selectBySql(selectAll);
    }

    @Override
    public trangthaiModel selectById(String id) {
        List<trangthaiModel> lst = selectBySql(selectById, id);
        if (lst.isEmpty()) {
            return null;
        }
        return lst.get(0);
    }

    @Override
    protected List<trangthaiModel> selectBySql(String sql, Object... args) {
        List<trangthaiModel> lst = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                trangthaiModel ent = new trangthaiModel();
                ent.setMaTrangThai(rs.getInt("MaTrangThai"));
                ent.setTenTrangThai(rs.getString("TenTrangThai"));
                lst.add(ent);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return lst;
    }

}
