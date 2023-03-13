package ru.rrenat358.contoller;

//import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.rrenat358.exceptions.EntityNotFoundException;
import ru.rrenat358.model.User;
import ru.rrenat358.model.dto.UserDto;
import ru.rrenat358.repository.UserRepository;
import ru.rrenat358.service.UserService;

import javax.validation.Valid;


@Slf4j
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

//    public UserController(@Qualifier("persistentUserRepository") UserRepositoryImpl userRepository) {
//        this.userRepository = userRepository;
//    }

    @GetMapping
    public String listPage(
            @RequestParam(required = false) String usernameFilter,
            @RequestParam(required = false) String emailFilter,
            Model model) {
        usernameFilter = usernameFilter == null || usernameFilter.isBlank() ? null : "%" + usernameFilter.trim() + "%";
        emailFilter = emailFilter == null || emailFilter.isBlank() ? null : "%" + emailFilter.trim() + "%";
        model.addAttribute(
                "users",
                userService.findAllByFilter(usernameFilter, emailFilter));
        return "user";
    }

    @GetMapping("/{id}")
    public String form(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.findUserById(id)
                .orElseThrow(() -> new EntityNotFoundException(" == User not found ==")));
        return "user_form";
    }

    @GetMapping("/new")
    public String addNewUser(Model model) {
        model.addAttribute("user", new UserDto());
        return "user_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserById(@PathVariable long id) {
        userService.deleteUserById(id);
        return "redirect:/user";
    }


    @PostMapping
    public String saveUser(@Valid @ModelAttribute("user") UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user_form";
        }
        if (!userDto.getPassword().equals(userDto.getMatchingPassword())) {
            bindingResult.rejectValue("password", "Password not match");
            return "user_form";
        }
        userService.save(userDto);
        return "redirect:/user";
    }


    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") UserDto userDto) {
        userService.save(userDto);
        return "redirect:/user";
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFoundExceptionHandler(Model model, EntityNotFoundException e) {
        model.addAttribute("message", e.getMessage());
        return "not_found";
    }



}
