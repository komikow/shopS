package by.it.academy.shopS.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "USERS")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME", nullable = false, length = 100)
    private String firstName;

    @Column(name = "SECOND_NAME", nullable = false, length = 100)
    private String secondName;

    @Column(name = "AGE", nullable = false)
    private Integer age;

    @Column(name = "LOGIN", unique = true, nullable = false, length = 100)
    private String login;

    @Column(name = "PASSWORD", nullable = false, length = 100)
    private String password;

    @Column(name = "EMAIL", nullable = false, length = 20)
    private String email;
}
