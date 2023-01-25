package weather.changer.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import weather.changer.model.Country;
import weather.changer.repository.CountryRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
@Log4j2
public class CountriesService {

    private final CountryRepository countryRepository;

    public Optional<Country> save(Country country) {
        Optional<Country> optionalCountry = Optional.empty();
        Country save = countryRepository.save(country);
        if (country.getId() != 0) {
            optionalCountry = Optional.of(save);
            log.info("Добавление произошло успешно");
        } else log.info("Не успешно");
        return optionalCountry;
    }

    public Optional<Country> findByName(String name) {
        Optional<Country> optionalCountry = Optional.empty();
        Country byName = countryRepository.findByName(name);
        if (byName.getName() != null) {
            optionalCountry = Optional.of(byName);
            log.info("Поиск успешно завершен");
        } else log.info("Значения не найдено");
        return optionalCountry;
    }

}
