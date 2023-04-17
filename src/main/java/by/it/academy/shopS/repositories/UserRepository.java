package by.it.academy.shopS.repositories;

import by.it.academy.shopS.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
