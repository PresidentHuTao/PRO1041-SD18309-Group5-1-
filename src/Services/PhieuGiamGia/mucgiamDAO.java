package Services.PhieuGiamGia;

import Models.PhieuGiamGia.mucgiamModel;
import Utilities.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class mucgiamDAO extends DAO<mucgiamModel, String> {

    final String identity_insert = "set identity_insert PhieuGiamGia_MucGiam on insert into PhieuGiamGia_MucGiam (MaMucGiam, TyLeGiam) values (?, ?)";
    final String update = "update PhieuGiamGia_MucGiam set TyLeGiam = ? where MaMucGiam = ?";
    final String selectAll = "select * from PhieuGiamGia_MucGiam";
    final String selectById = "select * from PhieuGiamGia_MucGiam where MaMucGiam = ?";

    public mucgiamModel selectById_int(int id) {
        List<mucgiamModel> lst = selectBySql(selectById, id);
        if (lst.isEmpty()) {
            return null;
        }
        return lst.get(0);
    }

    @Override
    public void insert(mucgiamModel ent) {
        JdbcHelper.update(identity_insert, ent.getMaMucGiam(), ent.getTyLeGiam());
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(mucgiamModel ent) {
        JdbcHelper.update(update, ent.getTyLeGiam(), ent.getMaMucGiam());
    }

    @Override
    public List<mucgiamModel> selectAll() {
        return selectBySql(selectAll);
    }

    @Override
    public mucgiamModel selectById(String id) {
        List<mucgiamModel> lst = selectBySql(selectById, id);
        if (lst.isEmpty()) {
            return null;
        }
        return lst.get(0);
    }

    @Override
    protected List<mucgiamModel> selectBySql(String sql, Object... args) {
        List<mucgiamModel> lst = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                mucgiamModel ent = new mucgiamModel();
                ent.setMaMucGiam(rs.getInt("MaMucGiam"));
                ent.setTyLeGiam(rs.getFloat("TyLeGiam"));
                lst.add(ent);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return lst;
    }

}
