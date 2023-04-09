package by.it.academy.shopS.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class UserRequest {
    @NotBlank
    private String firstName;
    @NotNull
    private String secondName;
    @NotNull
    private int age;
    @NotNull
    private String login;
    @NotNull
    private String password;
}
