package edu.jwt_auth_mark_1.repositories;

import edu.jwt_auth_mark_1.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserDAO extends JpaRepository<User, Integer> {
    UserDetails findByUsername(String username);
}
