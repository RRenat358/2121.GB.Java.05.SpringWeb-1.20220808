package ru.rrenat358.service;
//import ru.rrenat358.model.QUser;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.rrenat358.model.dto.UserDto;
import ru.rrenat358.model.mapper.UserDtoMapper;
import ru.rrenat358.repository.UserRepository;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDtoMapper mapper;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

/*
    public List<UserDto> findAllByFilter(String usernameFilter, String emailFilter) {
        QUser user = QUser.user;
        BooleanBuilder predicate = new BooleanBuilder();

        if (usernameFilter != null || !usernameFilter.isBlank()) {
            predicate.and(user.username.contains(usernameFilter.trim()));
        }
        if (emailFilter != null || !emailFilter.isBlank()) {
            predicate.and(user.email.contains(emailFilter.trim()));
        }
        return StreamSupport.stream(userRepository.findAll(predicate).spliterator(), true)
                .map(
//                        userFromDB -> {
//                    UserDto dto = new UserDto();
//                    dto.setId(userFromDB.getId());
//                    dto.setUsername(userFromDB.getUsername());
//                    dto.setEmail(userFromDB.getEmail());
//                    dto.setPassword(userFromDB.getPassword());
//                    return dto;
//                      }
                        //OR ↓
                        mapper::map
                ).collect(Collectors.toList());
    }
*/

    public Page<UserDto> findAllByFilter(String usernameFilter, String emailFilter, int page, int size, String sortField) {
        usernameFilter = usernameFilter == null || usernameFilter.isBlank() ? null : "%" + usernameFilter.trim() + "%";
        emailFilter = emailFilter == null || emailFilter.isBlank() ? null : "%" + emailFilter.trim() + "%";
        return userRepository.usersByFilter(usernameFilter, emailFilter, PageRequest.of(page, size, Sort.by(sortField)))
                .map(mapper::map);
    }

    public Optional<UserDto> findUserById(Long id) {
        return userRepository.findById(id).map(mapper::map);
    }

    public void save(UserDto dto) {
        userRepository.save(mapper.map(dto, encoder));
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public org.springframework.security.core.userdetails.User findUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(user -> new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"))
                )).orElseThrow(() -> new UsernameNotFoundException(username));

    }

}
