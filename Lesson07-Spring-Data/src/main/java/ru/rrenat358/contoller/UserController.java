package ru.rrenat358.contoller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.rrenat358.persist.User;
import ru.rrenat358.persist.UserRepository;
import ru.rrenat358.persist.UserRepositoryImpl;

@Slf4j
@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {


    private final UserRepositoryImpl userRepository;

//    public UserController(@Qualifier("persistentUserRepository") UserRepositoryImpl userRepository) {
//        this.userRepository = userRepository;
//    }

    @GetMapping
    public String listPage(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user";
    }

    @GetMapping("/{id}")
    public String form(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userRepository.userById(id));
        return "user_form";
    }

    @GetMapping("/new")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User(""));
        return "user_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserById(@PathVariable long id) {
        userRepository.deleteById(id);
        return "redirect:/user";
    }


    @PostMapping
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user_form";
        }
        if (!user.getPassword().equals(user.getMatchingPassword())) {
            bindingResult.rejectValue("password", "Password not match");
            return "user_form";
        }
        userRepository.save(user);
        return "redirect:/user";
    }


    @PostMapping("/update")
    public String updateUser(User user) {
        userRepository.save(user);
        return "redirect:/user";
    }


}
