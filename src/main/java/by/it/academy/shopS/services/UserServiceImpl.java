package by.it.academy.shopS.services;

import by.it.academy.shopS.dto.UserRequest;
import by.it.academy.shopS.dto.UserResponse;
import by.it.academy.shopS.entities.User;
import by.it.academy.shopS.mapper.UserMapper;
import by.it.academy.shopS.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse getUser(int id) {
        return userRepository.findById(id)
                .map(userMapper::buildUserResponse)
                .orElseThrow(() -> new RuntimeException(String.format("Can't find user with id %s", id)));
    }

    @Override
    public void deleteUser(String login) {
        userRepository.deleteUserByLogin(login);
    }

    @Override
    public List<UserResponse> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable).stream()
                .map(userMapper::buildUserResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserResponse> getUsersByLoginAndPassword(String login, String password) throws Exception {
        List<UserResponse> userResponseList = new ArrayList<>();
        for (User users : userRepository.findAll()) {
            if (login.equals("komikow") && password.equals("Qwety5")) {
                System.out.println("login = " + login + ", passw = " + password);
                List<UserResponse> collect = userRepository.findAll().stream()
                        .map(userMapper::buildUserResponse)
                        .collect(Collectors.toList());
                userResponseList = collect;
                return userResponseList;
            } else {
                throw new Exception("Login and password is not valid");
            }
        }
        return userResponseList;
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) throws Exception {
        UserResponse userResponse = null;
        if (userRepository.findAll().isEmpty()) {
            User user = userMapper.buildUser(userRequest);
            User savedUser = userRepository.save(user);
            return userMapper.buildUserResponse(savedUser);
        } else {
            for (User users : userRepository.findAll()) {
                if (userRequest.getLogin().equals(users.getLogin())) {
                    throw new Exception("Is not valid");
                } else {
                    User user = userMapper.buildUser(userRequest);
                    User savedUser = userRepository.save(user);
                    userResponse = userMapper.buildUserResponse(savedUser);
                    break;
                }
            }
        }
        return userResponse;
    }

    @Override
    public UserResponse userUpdatePassword(int id, String password) {
        User userById = userRepository.findUserById(id);
        userById.setPassword(password);
        return userMapper.buildUserResponse(userById);
    }
}
