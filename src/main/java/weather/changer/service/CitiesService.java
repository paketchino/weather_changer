package weather.changer.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import weather.changer.model.City;
import weather.changer.repository.CitiesRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
@Log4j2
@Transactional
public class CitiesService {

    private final CitiesRepository citiesRepository;

    public Optional<City> save(City city) {
        Optional<City> optional = Optional.empty();
        City save = citiesRepository.save(city);
        if (city.getId() != 0) {
            optional = Optional.of(save);
            log.info("Добавление произведено");
        } else log.info("Добавление не произведено");
        return optional;
    }

    public Optional<City> findByName(String name) {
        Optional<City> optional = Optional.empty();
        if (citiesRepository.findByName(name).getName() != null) {
            City byName = citiesRepository.findByName(name);
            optional = Optional.of(byName);
            log.info("Город был найден по имени");
        } else log.info("Город не найден");
        return optional;
    }
}
