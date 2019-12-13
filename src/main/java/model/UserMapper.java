package model;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserVO> {

    @Override
    public UserVO mapRow(ResultSet resultSet, int i) throws SQLException {
        final UserVO userVO = new UserVO();
        userVO.setId(resultSet.getLong("id"));
        userVO.setName(resultSet.getString("name"));
        userVO.setAge(resultSet.getInt("age"));
        userVO.setGender(resultSet.getString("gender"));
        return userVO;
    }
}
