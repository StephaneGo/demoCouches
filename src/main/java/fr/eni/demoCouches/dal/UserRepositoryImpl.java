package fr.eni.demoCouches.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import fr.eni.demoCouches.bo.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	private final JdbcTemplate jdbcTemplate;
	private final NamedParameterJdbcTemplate namedJdbcTemplate;

    @Autowired
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {    	
        this.jdbcTemplate = jdbcTemplate;
        this.namedJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    }

    public List<User> getUsersByAge(int age) {
    	 String sql = "SELECT id, name, age FROM users WHERE age >= ?";

         return jdbcTemplate.query(sql, new PreparedStatementSetter() {
             @Override
             public void setValues(PreparedStatement preparedStatement) throws SQLException {
                 preparedStatement.setInt(1, age);
             }
         }, new UserRowMapper());
    }

    private static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setAge(rs.getInt("age"));
            return user;
        }
    }

	@Override
	public void saveUser(User user) {
		String sql = "INSERT INTO users (name, age) VALUES (:name, :age)";
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(user);
        namedJdbcTemplate.update(sql, namedParameters);
	}
}
