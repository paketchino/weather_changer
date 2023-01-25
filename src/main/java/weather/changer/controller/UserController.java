package weather.changer.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import weather.changer.model.User;
import weather.changer.service.RoleService;
import weather.changer.service.UserDetailsService;
import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final RoleService roleService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    @PostMapping("/registration")
    public ResponseEntity<User> registration(@Valid @RequestBody User user) {
        user.setRole(roleService.findRoleByName("ROLE_USER"));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDetailsService.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
