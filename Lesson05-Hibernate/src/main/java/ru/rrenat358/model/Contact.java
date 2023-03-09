package ru.rrenat358.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "contacts")
@NoArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ContactType type;

    @Column(nullable = false)
    private String value;

    @ManyToOne
    private User user;

    public Contact(ContactType type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", type=" + type +
                ", value='" + value + '\'' +
                ", userId=" + user.getId() +
                '}';
    }
}
