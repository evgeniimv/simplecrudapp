package model;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserVO> {

    @Override
    public UserVO mapRow(ResultSet resultSet, int i) throws SQLException {
        final UserVO userVO = new UserVO();
        userVO.setUser_id(resultSet.getLong("user_id"));
        userVO.setUsername(resultSet.getString("username"));
        userVO.setAge(resultSet.getInt("age"));
        userVO.setGender(resultSet.getString("gender"));
        return userVO;
    }
}
