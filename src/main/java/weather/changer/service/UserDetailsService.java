package weather.changer.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import weather.changer.repository.UserRepository;

import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Log4j2
@AllArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        weather.changer.model.User byEmail = userRepository.findByEmail(email);
        return new User(byEmail.getEmail(), byEmail.getPassword(), Collections.emptyList());
    }

    @Transactional
    public Optional<weather.changer.model.User> save(weather.changer.model.User user) {
        Optional<weather.changer.model.User> optionalUser = Optional.empty();
        if (user.getEmail() == null) {
            throw new NoSuchElementException("Юзер не был добавлен");
        } else {
            log.info("Добавление пользователя произведено успешно");
            userRepository.save(user);
            optionalUser = Optional.of(user);
        }
        return optionalUser;
    }
}
