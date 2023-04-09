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
    public UserResponse getUser(@PathVariable int id) {
        return userServiceImpl.getUser(id);
    }

    @GetMapping
    public List<UserResponse> getUsersByCondition(Pageable pageable) {
        return userServiceImpl.getUsers(pageable);
    }

    @GetMapping("{login}/{password}")
    public List<UserResponse> getUsersByCondition(@PathVariable String login, @PathVariable String password) throws Exception {
        return userServiceImpl.getUsersByLoginAndPassword(login, password);
    }

    @PostMapping
    public UserResponse createUser(@Validated @RequestBody UserRequest userRequest) throws Exception {
        return userServiceImpl.createUser(userRequest);
    }
}
