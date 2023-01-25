package weather.changer.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import weather.changer.dto.MeasurementDTO;
import weather.changer.model.Measurement;
import weather.changer.repository.MeasurementRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Log4j2
public class MeasurementService {

    private final MeasurementRepository measurementRepository;

    @Modifying
    public Optional<Measurement> add(@Param("measurement") Measurement measurement) {
        Optional<Measurement> optionalMeasurement = Optional.empty();
        measurementRepository.save(measurement);
        if (measurement.getId() != 0) {
            log.info("Добавление произведено успешно");
            log.trace("Добавление элемента {}", measurement.toString());
        }
        return optionalMeasurement;
    }

    public List<MeasurementDTO> getAll() {
        if (measurementRepository.getAll().size() == 0) {
            log.trace("Измерения отсутствуют в бд");
            throw new NoSuchElementException();
        }
        return convertToDTO();
    }

    public int measurementCountDTO() {
        if (measurementRepository.findAllRainyDaysCount() == 0) {
           log.error("Счетчик равен 0");
        } else {
            log.info("Поиск успешно окончен");
        }
        return measurementRepository.findAllRainyDaysCount();
    }

    private List<MeasurementDTO> convertToDTO() {
        return measurementRepository.getAll()
                .stream()
                .map(measurement ->
                        new MeasurementDTO(measurement.getValue(),
                                measurement.isRaining(),
                                measurement.getStreet().getCity().getName(),
                                measurement.getStreet().getName(),
                                measurement.getSensor().getName(),
                                measurement.getStart(),
                                measurement.getFinish()))
                .collect(Collectors.toList());
    }


}
