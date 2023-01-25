package weather.changer.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import weather.changer.model.Sensor;
import weather.changer.repository.SensorRepository;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
@Log4j2
public class SensorService {

    private final SensorRepository sensorRepository;

    @Modifying
    public Optional<Sensor> add(Sensor sensor) {
        Optional<Sensor> optionalSensor = Optional.empty();
        Sensor s = sensorRepository.save(sensor);
        if (sensor.getId() != 0) {
            log.info("Добавление произведено");
            log.trace("Добавлен элемент кузова машины: = {}",
                    sensor.toString());
            optionalSensor = Optional.of(s);
        }
        return optionalSensor;
    }

    public Optional<Sensor> findSensorByName(String name) {
        Optional<Sensor> optionalSensor = Optional.empty();
        Sensor sensorByName = sensorRepository.findSensorByName(name);
        if (sensorByName.getId() != 0) {
            log.info("Добавление произведено");
            log.trace("Добавлен элемент кузова машины: = {}",
                    sensorByName.toString());
            optionalSensor = Optional.of(sensorByName);
        }
        return optionalSensor;
    }
}
