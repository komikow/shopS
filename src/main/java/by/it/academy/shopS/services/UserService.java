package by.it.academy.shopS.services;

import by.it.academy.shopS.dto.UserRequest;
import by.it.academy.shopS.dto.UserResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    UserResponse getUser(Long id);

    void deleteUser(Long id);

    List<UserResponse> getUsers(Pageable pageable);

    UserResponse createUser(UserRequest userRequest);

    UserResponse userUpdateEmail(Long id, String email);
}
