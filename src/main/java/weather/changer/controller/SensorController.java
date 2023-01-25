package weather.changer.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import weather.changer.dto.SensorDTO;
import weather.changer.model.Sensor;
import weather.changer.service.SensorService;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/sensors")
@AllArgsConstructor
public class SensorController {

    private final SensorService sensorService;

    @PostMapping("/registration")
    public ResponseEntity<SensorDTO> registration(@Valid @RequestBody Sensor sensor) {
        Optional<Sensor> add = sensorService.add(sensor);
        SensorDTO sensorDTO = new SensorDTO(add.get().getName());
        return new ResponseEntity<>(sensorDTO, HttpStatus.CREATED);
    }
}
