package Services.PhieuGiamGia;

import java.util.List;

public abstract class DAO<EntityType, KeyType> {

    public abstract void insert(EntityType ent);

    public abstract void delete(KeyType id);

    public abstract void update(EntityType ent);

    public abstract List<EntityType> selectAll();

    public abstract EntityType selectById(KeyType id);

    protected abstract List<EntityType> selectBySql(String sql, Object... args);
}
