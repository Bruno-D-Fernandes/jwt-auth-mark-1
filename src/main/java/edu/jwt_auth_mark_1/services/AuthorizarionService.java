package edu.jwt_auth_mark_1.services;

import edu.jwt_auth_mark_1.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class AuthorizarionService implements UserDetailsService {

    private UserDAO userDAO;

    @Autowired
    public AuthorizarionService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDAO.findByName(username);
    }
}
