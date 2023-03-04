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

//    @Pattern(regexp = "^(?=.*?[0-9])(?=.*?[A-Z]).{8,}$", message = "Password too simple")
//    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*?)[A-Za-z?]{8,}$", message = "Password too simple")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*?)(?=.*[@$!%*#?&])[A-Za-z?@$!%*#?&]{8,}$", message = "Password too simple")
    private String password;






    public User(String username) {
        this.username = username;
    }

}
