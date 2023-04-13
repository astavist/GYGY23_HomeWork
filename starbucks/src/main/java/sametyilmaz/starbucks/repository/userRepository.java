package sametyilmaz.starbucks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sametyilmaz.starbucks.entities.User;

public interface userRepository extends JpaRepository<User,Integer> {
}
