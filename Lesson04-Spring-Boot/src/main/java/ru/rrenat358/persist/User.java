package ru.rrenat358.persist;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private Long id;

    @NotBlank(message = "Поле не может быть пустым")
    private String username;

    @NotBlank
    @Email
    private String email;

    public User(String username) {
        this.username = username;
    }

}
