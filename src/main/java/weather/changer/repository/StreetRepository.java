package weather.changer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import weather.changer.model.Street;

@Repository
@Transactional
public interface StreetRepository extends JpaRepository<Street, Integer> {

    @Modifying
    Street save(Street street);

    @Query("from streets as s where s.name =:name ")
    Street findByName(@Param("name") String name);
}
