package edu.jwt_auth_mark_1.controller;


import edu.jwt_auth_mark_1.domain.user.AuthentificationDTO;
import edu.jwt_auth_mark_1.domain.user.RegisterDTO;
import edu.jwt_auth_mark_1.domain.user.User;
import edu.jwt_auth_mark_1.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthentificationCrontoller {

     private AuthenticationManager manager;
     private UserDAO userDAO;

     @Autowired
    public AuthentificationCrontoller(AuthenticationManager manager, UserDAO userDAO) {
        this.manager = manager;
    }

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @PostMapping("/login")               // @Valid Annotation ver o que é e como funciona
    public ResponseEntity login(@RequestBody AuthentificationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = this.manager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDTO registerDTO){
         if(this.userDAO.findByName(registerDTO.username()) != null) return ResponseEntity.badRequest().build();

         String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());
         User user = new User(registerDTO.username(), encryptedPassword, registerDTO.role());

         userDAO.save(user);
         return ResponseEntity.ok().build();
    }


}
