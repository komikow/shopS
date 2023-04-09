package by.it.academy.shopS.services;

import by.it.academy.shopS.dto.UserRequest;
import by.it.academy.shopS.dto.UserResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    UserResponse getUser(int id);

    List<UserResponse> getUsersByLoginAndPassword(String login, String password) throws Exception;

    List<UserResponse> getUsers(Pageable pageable);

    UserResponse createUser(UserRequest userRequest) throws Exception;
}
