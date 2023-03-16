package ru.rrenat358.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.rrenat358.exceptions.EntityNotFoundException;
import ru.rrenat358.model.dto.UserDto;
import ru.rrenat358.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserResource {

    private final UserService userService;

    @GetMapping
    public List<UserDto> listPage(
            @RequestParam(required = false) String usernameFilter,
            @RequestParam(required = false) String emailFilter,
            @RequestParam(required = false) Optional<Integer> page,
            @RequestParam(required = false) Optional<Integer> size,
            @RequestParam(required = false) Optional<String> sortField
    ) {
        Integer pageValue = page.orElse(1) - 1;
        Integer sizeValue = size.orElse(3);
        String sortFieldValue = sortField.filter(s -> !s.isBlank()).orElse("id");
        Page<UserDto> allByFilter = userService.findAllByFilter(usernameFilter, emailFilter, pageValue, sizeValue, sortFieldValue);
        List<UserDto> users = allByFilter.get().collect(Collectors.toList());
        return users;
    }

    @GetMapping("/{id}")
    public UserDto form(@PathVariable("id") long id, Model model) {
        UserDto userDto = userService.findUserById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
        return userDto;
    }

    @PostMapping
    public UserDto saveUser(@RequestBody UserDto user) {
        if (user.getId() != null) {
            throw new IllegalArgumentException(" == Created user shouldn't have id == ");
        }
        userService.save(user);
        return user;
    }


}
