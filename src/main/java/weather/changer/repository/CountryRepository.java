package weather.changer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import weather.changer.model.Country;

@Repository
@Transactional
public interface CountryRepository extends JpaRepository<Country, Integer> {

    @Modifying
    Country save(Country country);

    @Query("from countries as c where c.name =:name")
    Country findByName(@Param("name") String name);
}
