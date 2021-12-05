package ac.injecs.java2.config.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class SQLMapper {
    protected PreparedStatement preparedStatement = null;
    protected ResultSet resultSet = null;

    public abstract void insert(PreparedStatement preparedStatement, Object object);
    public abstract Object select(PreparedStatement preparedStatement);
    public void update(PreparedStatement preparedStatement, Object object) {
	}
    public void delete(PreparedStatement preparedStatement, Object object) {
    }
}
