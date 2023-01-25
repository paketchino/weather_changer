package weather.changer.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import weather.changer.dto.CityDTO;
import weather.changer.model.City;
import javax.validation.Valid;
import weather.changer.service.CitiesService;

@Controller
@RequestMapping("/cities")
@AllArgsConstructor
public class CitiesController {

    private final CitiesService citiesService;

    @PostMapping("/addCity")
    public ResponseEntity<CityDTO> addCity(@Valid @RequestBody City city) {
        citiesService.save(city);
        return new ResponseEntity<>(new CityDTO(city.getName(),
                city.getOblast()), HttpStatus.CREATED);
    }
}
