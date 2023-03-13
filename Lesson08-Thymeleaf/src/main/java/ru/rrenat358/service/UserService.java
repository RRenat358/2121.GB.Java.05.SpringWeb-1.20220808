package ru.rrenat358.service;


import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rrenat358.model.User;
import ru.rrenat358.model.dto.UserDto;
import ru.rrenat358.model.mapper.UserDtoMapper;
import ru.rrenat358.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDtoMapper mapper;
    private final UserRepository userRepository;


    //todo
//    public Object findAllByFilter(String usernameFilter, String emailFilter) {
//        return null;
//    }

    public List<UserDto> findAllByFilter(String usernameFilter, String emailFilter) {
//        QUser user = QUser.user;

        BooleanBuilder predicate = new BooleanBuilder();

        return null;
    }


    public Optional<UserDto> findUserById(Long id) {
        return userRepository.findById(id).map(mapper::map);
    }

    //todo
    public void save(UserDto dto) {
        userRepository.save(mapper.map(dto));

    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

}
