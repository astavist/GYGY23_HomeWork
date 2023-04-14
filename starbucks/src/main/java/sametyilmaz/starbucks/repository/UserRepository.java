package sametyilmaz.starbucks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sametyilmaz.starbucks.entities.User;

public interface UserRepository extends JpaRepository<User,Integer> {
}
