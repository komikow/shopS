package by.it.academy.shopS.controllers;

import by.it.academy.shopS.dto.UserRequest;
import by.it.academy.shopS.dto.UserResponse;
import by.it.academy.shopS.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userServiceImpl;

    @GetMapping("{id}")
    public UserResponse getUser(@PathVariable Long id) {
        return userServiceImpl.getUser(id);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long id) {
        userServiceImpl.deleteUser(id);
    }

    @GetMapping
    public List<UserResponse> getUsers(Pageable pageable) {
        return userServiceImpl.getUsers(pageable);
    }

    @PostMapping
    public UserResponse createUser(@Validated @RequestBody UserRequest userRequest) {
        return userServiceImpl.createUser(userRequest);
    }

    @PatchMapping("{id}/{email}")
    public UserResponse userUpdateEmail(@PathVariable Long id, @PathVariable String email) {
        return userServiceImpl.userUpdateEmail(id, email);
    }
}
