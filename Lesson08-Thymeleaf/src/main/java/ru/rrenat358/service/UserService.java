package ru.rrenat358.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rrenat358.model.User;
import ru.rrenat358.model.dto.UserDto;
import ru.rrenat358.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public Optional<UserDto> findUserById(Long id) {
        return userRepository.findById(id).map(UserService::userToDto);
    }

    public UserDto save(UserDto dto) {
        return userToDto(userRepository.save(new User(
                dto.getId(),
                dto.getUsername(),
                dto.getEmail(),
                dto.getPassword())));
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public static UserDto userToDto(User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword());
    }


    //todo
    public Object findAllByFilter(String usernameFilter, String emailFilter) {
        return null;
    }
}
