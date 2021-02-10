package net.wenthura.wenthura.repository;

import net.wenthura.wenthura.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
