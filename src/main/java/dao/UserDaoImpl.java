package dao;


import model.UserMapper;
import model.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    final private JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_PERSON = "SELECT * FROM Users WHERE user_id = ?";
    private final String SQL_DELETE_PERSON = "DELETE FROM Users WHERE user_id = ?";
    private final String SQL_UPDATE_PERSON = "UPDATE Users SET username = ?, age = ?, gender  = ? WHERE user_id = ?";
    private final String SQL_GET_ALL = "SELECT * FROM Users";
    private final String SQL_INSERT_PERSON = "INSERT INTO Users (username, age, gender) VALUES (?,?,?)";

    @Autowired
    public UserDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public UserVO getUserById(Long id) {
        return jdbcTemplate.queryForObject(SQL_FIND_PERSON, new Object[]{id}, new UserMapper());
    }

    @Override
    public List<UserVO> getAllUsers() {
        return jdbcTemplate.query(SQL_GET_ALL, new UserMapper());
    }

    @Override
    public Long createUser(UserVO userVO) {
        jdbcTemplate.update(SQL_INSERT_PERSON, userVO.getUsername(), userVO.getAge(), userVO.getGender());
        return userVO.getUser_id();
    }

    @Override
    public boolean updateUser(UserVO userVO) {
        return jdbcTemplate.update(SQL_UPDATE_PERSON, userVO.getUsername(), userVO.getAge(), userVO.getGender(), userVO.getUser_id()) > 0;
    }

    @Override
    public boolean deleteUser(Long id) {
        return jdbcTemplate.update(SQL_DELETE_PERSON, id) > 0;
    }
}
