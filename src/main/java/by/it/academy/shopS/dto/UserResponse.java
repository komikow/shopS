package by.it.academy.shopS.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private int id;
    private String firstName;
    private String secondName;
    private int age;
    private String login;
    private String password;
}
