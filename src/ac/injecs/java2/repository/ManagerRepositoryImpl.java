package ac.injecs.java2.repository;

import ac.injecs.java2.config.DBConnect;
import ac.injecs.java2.config.sql.MangerMapper;
import ac.injecs.java2.entity.Manager;

import java.util.List;
import java.util.Optional;

public class ManagerRepositoryImpl implements ManagerRepository {
    final DBConnect dbConnect = DBConnect.getInstance();

    @Override
    public Manager save(Manager manager) {
        return null;
    }

    @Override
    public Optional<Manager> findById(String id) {
        String sql = "select * from manager where mid like " + id;
        Manager find = (Manager) dbConnect.select(sql, new MangerMapper());
        return Optional.ofNullable(find);
    }

    @Override
    public Optional<Manager> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Manager> findAll() {
        return null;
    }
}
