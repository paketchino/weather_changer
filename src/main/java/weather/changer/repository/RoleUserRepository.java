package weather.changer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import weather.changer.model.Role;

@Repository
@Transactional
public interface RoleUserRepository extends JpaRepository<Role, Integer> {

    @Query("from roles as r where r.name =:name")
    Role findByName(@Param("name") String name);
}
