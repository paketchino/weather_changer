package weather.changer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import weather.changer.model.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("from users where email =: email")
    User findByEmail(String email);

    @Modifying
    User save(User user);
}
