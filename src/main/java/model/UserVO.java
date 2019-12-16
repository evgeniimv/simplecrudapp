package model;

import lombok.Data;

@Data
public class UserVO {
    private Long user_id;
    private String username;
    private int age;
    private String gender;
}
