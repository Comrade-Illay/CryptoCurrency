package net.illay.cryptoCurrency.repository;

import net.illay.cryptoCurrency.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findUsersByCode(String code);
}
