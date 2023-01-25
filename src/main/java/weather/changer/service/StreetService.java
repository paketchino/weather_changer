package weather.changer.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import weather.changer.model.Street;
import weather.changer.repository.StreetRepository;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
@Log4j2
public class StreetService {

    private final StreetRepository streetRepository;

    public Optional<Street> save(Street street) {
        Optional<Street> optional = Optional.empty();
        streetRepository.save(street);
        if (street.getId() != 0) {
            log.info("Добавление успешно произведено");
        } else log.info("Что то пошло не так");
        return optional;
    }

    public Optional<Street> findByName(String name) {
        Optional<Street> optional = Optional.empty();
        Street byName = streetRepository.findByName(name);
        if (byName.getName() != null) {
            log.info("Улица успешно найдено");
            optional = Optional.of(byName);
        } else log.info("Поиск не обнаружил запрашиваемой улице по имени");
        return optional;
    }
}
