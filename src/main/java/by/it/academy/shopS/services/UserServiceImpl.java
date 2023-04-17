package by.it.academy.shopS.services;

import by.it.academy.shopS.dto.UserRequest;
import by.it.academy.shopS.dto.UserResponse;
import by.it.academy.shopS.entities.User;
import by.it.academy.shopS.exceptions.UserNotFoundException;
import by.it.academy.shopS.mapper.UserMapper;
import by.it.academy.shopS.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse getUser(Long id) {
        return userRepository.findById(id)
                .map(userMapper::buildUserResponse)
                .orElseThrow(() -> new UserNotFoundException(String.format("Can't find user with id %s", id)));
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserResponse> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable).stream()
                .map(userMapper::buildUserResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User user = userMapper.buildUser(userRequest);
        return userMapper.buildUserResponse(userRepository.save(user));
    }

    @Override
    public UserResponse userUpdateEmail(Long id, String email) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Can't find user with id %s"));
        user.setEmail(email);
        userRepository.save(user);
        return userMapper.buildUserResponse(user);
    }
}
