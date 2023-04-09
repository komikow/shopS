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
    @Column(name = "\"USER_ID\"", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "FIRST_NAME", nullable = false, length = 100)
    private String firstName;

    @Column(name = "SECOND_NAME", nullable = false, length = 100)
    private String secondName;

    @Column(name = "AGE", nullable = false)
    private int age;

    @Column(name = "LOGIN", unique = true, nullable = false, length = 100)
    private String login;

    @Column(name = "PASSWORD", nullable = false, length = 100)
    private String password;
}
