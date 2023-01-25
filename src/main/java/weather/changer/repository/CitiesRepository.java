package weather.changer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import weather.changer.model.City;

@Repository
@Transactional
public interface CitiesRepository extends JpaRepository<City, Integer> {

    @Modifying
    City save(City city);

    @Query("from cities as c where c.name =:name")
    City findByName(@Param("name") String name);
}
