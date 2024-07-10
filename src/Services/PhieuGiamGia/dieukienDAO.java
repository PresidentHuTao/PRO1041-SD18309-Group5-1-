package Services.PhieuGiamGia;

import Models.PhieuGiamGia.dieukienModel;
import Utilities.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class dieukienDAO extends DAO<dieukienModel, String> {

    final String identity_insert = "set identity_insert PhieuGiamGia_DieuKienApDung on insert into PhieuGiamGia_DieuKienApDung (MaDieuKien, TenDieuKien) values (?, ?)";
    final String update = "update PhieuGiamGia_DieuKienApDung set TenDieuKien = ? where MaDieuKien = ?";
    final String selectAll = "select * from PhieuGiamGia_DieuKienApDung";
    final String selectById = "select * from PhieuGiamGia_DieuKienApDung where MaDieuKien = ?";

    public dieukienModel selectById_int(int id) {
        List<dieukienModel> lst = selectBySql(selectById, id);
        if (lst.isEmpty()) {
            return null;
        }
        return lst.get(0);
    }
    
    @Override
    public void insert(dieukienModel ent) {
        JdbcHelper.update(identity_insert, ent.getMaDieuKien(), ent.getTenDieuKien());
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(dieukienModel ent) {
        JdbcHelper.update(update, ent.getTenDieuKien(), ent.getMaDieuKien());
    }

    @Override
    public List<dieukienModel> selectAll() {
        return selectBySql(selectAll);
    }

    @Override
    public dieukienModel selectById(String id) {
        List<dieukienModel> lst = selectBySql(selectById, id);
        if (lst.isEmpty()) {
            return null;
        }
        return lst.get(0);
    }

    @Override
    protected List<dieukienModel> selectBySql(String sql, Object... args) {
        List<dieukienModel> lst = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                dieukienModel ent = new dieukienModel();
                ent.setMaDieuKien(rs.getInt("MaDieuKien"));
                ent.setTenDieuKien(rs.getString("TenDieuKien"));
                lst.add(ent);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return lst;
    }

}
