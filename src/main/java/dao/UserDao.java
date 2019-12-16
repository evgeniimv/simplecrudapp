package dao;

import model.UserVO;

import java.util.List;

public interface UserDao {
    UserVO getUserById(Long id);

    List<UserVO> getAllUsers();

    Long createUser(UserVO userVO);

    boolean updateUser(UserVO userVO);

    boolean deleteUser(Long id);
}
