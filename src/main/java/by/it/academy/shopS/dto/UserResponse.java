package by.it.academy.shopS.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private Long id;
    private String firstName;
    private String secondName;
    private Integer age;
    private String login;
    private String password;
    private String email;
}
