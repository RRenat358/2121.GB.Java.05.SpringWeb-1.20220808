package ru.rrenat358.persist;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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

    //Минимум восемь символов, минимум одна заглавная буква, одна строчная буква и одна цифра:
//    @Pattern(regexp = "^(?=.*?[0-9])(?=.*?[A-Z]).{2,}$", message = "Password too simple")
    //Минимум восемь символов, минимум одна буква, одна цифра и один специальный символ:
//    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*?)[A-Za-z?]{8,}$", message = "Password too simple")
//    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*?)(?=.*[@$!%*#?&])[A-Za-z?@$!%*#?&]{8,}$", message = "Password too simple")
    private String password;

    private String matchingPassword;




    public User(String username) {
        this.username = username;
    }

}
