package controller;

import dao.UserDao;
import model.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserVO> getUserById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userDao.getUserById(id));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserVO>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userDao.getAllUsers());
    }

    @PostMapping("/create")
    public ResponseEntity<Long> createUser(@RequestBody UserVO userVO) {
        return ResponseEntity.status(HttpStatus.OK).body(userDao.createUser(userVO));
    }

    @PostMapping("/updateuser")
    public ResponseEntity<Boolean> updateUser(@RequestBody UserVO userVO) {
        return ResponseEntity.status(HttpStatus.OK).body(userDao.updateUser(userVO));
    }

    @PostMapping("/users/{id}:delete")
    public ResponseEntity<Boolean> deleteUser(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userDao.deleteUser(id));
    }
}
