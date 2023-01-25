package weather.changer.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import weather.changer.dto.MeasurementDTO;
import weather.changer.model.Measurement;
import weather.changer.model.Sensor;
import weather.changer.model.Street;
import weather.changer.service.MeasurementService;
import weather.changer.service.SensorService;
import weather.changer.service.StreetService;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/measurements")
@AllArgsConstructor
public class MeasurementController {
    private final MeasurementService measurementService;

    private final StreetService streetService;
    private final SensorService sensorService;

    @PostMapping("/add")
    public ResponseEntity<MeasurementDTO> add(@Valid @RequestBody Measurement measurement) {
        Street service = streetService.findByName(measurement.getStreet().getName())
                .orElseThrow(() -> new NoSuchElementException("Улица не была найдена"));
        Sensor sensorByName = sensorService.findSensorByName(measurement.getSensor().getName())
                .orElseThrow(() -> new NoSuchElementException("Сенсор не был найден"));
        measurement.setSensor(sensorByName);
        measurement.setRaining(measurement.isRaining());
        measurement.setStreet(service);
        measurement.setRaining(measurement.isRaining());
        measurement.setStart(LocalDateTime.now());
        measurement.setFinish(LocalDateTime.now().plusHours(1));
        measurementService.add(measurement);
        return new ResponseEntity<MeasurementDTO>(new MeasurementDTO(measurement.getValue(),
                measurement.isRaining(),
                measurement.getStreet().getCity().getName(),
                measurement.getStreet().getName(),
                measurement.getSensor().getName(),
                measurement.getStart(),
                measurement.getFinish()),
                HttpStatus.CREATED);
    }

    @GetMapping("/allMeasurement")
    public ResponseEntity<List<MeasurementDTO>> allMeasurement() {
        List<MeasurementDTO> all = measurementService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/rainyDaysCount")
    public ResponseEntity<Integer> findAllRaining() {
        int count = measurementService.measurementCountDTO();
        return new ResponseEntity<>(count, HttpStatus.FOUND);
    }
}
