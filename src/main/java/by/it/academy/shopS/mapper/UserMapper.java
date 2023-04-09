package by.it.academy.shopS.mapper;

import by.it.academy.shopS.dto.UserRequest;
import by.it.academy.shopS.dto.UserResponse;
import by.it.academy.shopS.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponse buildUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .secondName(user.getSecondName())
                .age(user.getAge())
                .login(user.getLogin())
                .password(user.getPassword())
                .build();
    }

    public User buildUser(UserRequest userRequest) {
        return User.builder()
                .firstName(userRequest.getFirstName())
                .secondName(userRequest.getSecondName())
                .age(userRequest.getAge())
                .login(userRequest.getLogin())
                .password(userRequest.getPassword())
                .build();
    }
}
