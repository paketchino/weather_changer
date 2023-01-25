package weather.changer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import weather.changer.model.Measurement;

import java.util.List;

@Repository
@Transactional
public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {

    Measurement save(Measurement measurement);

    @Query("from measurements")
    List<Measurement> getAll();

    @Query("select count(raining) from measurements as m where m.raining = true")
    int findAllRainyDaysCount();
}
