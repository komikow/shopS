package by.it.academy.shopS.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
public class UserRequest {
    @NotBlank
    private String firstName;
    @NotBlank
    private String secondName;
    @NotNull
    private LocalDate birthDate;
    @NotBlank
    private String login;
    @NotBlank
    private String password;
    @Email
    private String email;
}
