package ru.rrenat358.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "findAllUsers", query = "Select u from User u"),
        @NamedQuery(name = "countAllUsers", query = "Select count(u) from User u"),
        @NamedQuery(name = "deleteUserById", query = "delete from User u where u.id = :id")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @OneToMany(mappedBy = "user",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE},
            orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Contact> contacts;

    @Column(nullable = false, length = 1024)
    private String password;

    // контакты со списком ID
//    @ElementCollection
//    private List<Long> ordersIds;

//    @OneToOne(mappedBy = "user",
//            cascade = {CascadeType.ALL},
//            orphanRemoval = true,
//            fetch = FetchType.LAZY)
//    private Customer customer;
//
//    @ManyToMany(mappedBy = "users")
//    private List<Role> roles;
//
//    @Embedded
//    private Passport passport;

    public User(String username, List<Contact> contacts, String password) {
        this.username = username;
        this.contacts = contacts;
        this.password = password;
    }

//    public User(String username, String password) {
//        this.username = username;
//        this.contacts = contacts;
//        this.password = password;
//    }
//
//    public User(String user3, String s, String pass3) {
//
//    }
}
