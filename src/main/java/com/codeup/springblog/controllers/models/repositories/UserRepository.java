package com.codeup.springblog.controllers.models.repositories;
import com.codeup.springblog.controllers.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
