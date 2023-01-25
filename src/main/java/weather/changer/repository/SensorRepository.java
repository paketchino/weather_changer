package weather.changer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import weather.changer.model.Sensor;

@Repository
@Transactional
public interface SensorRepository extends JpaRepository<Sensor, Integer> {

    @Modifying
    Sensor save(Sensor sensor);

    @Query("from sensors as s where s.name =:name")
    Sensor findSensorByName(@Param("name") String name);
}
